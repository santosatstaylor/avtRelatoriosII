package br.com.senior.rest.services;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.NameBinding;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import br.com.senior.dto.ResponseModelDTO;
import br.com.senior.dto.StatusDTO;
import br.com.senior.mobile.server.sdk.client.Client;
import br.com.senior.mobile.server.sdk.client.ClientBuilder;

/**
 * Classe responsável por conter os serviços(rest) para o aplicativo Workflow.
 * @author wesley.barros
 */

@Path("api")
public class WorkflowAPI {	
	@Target({ ElementType.METHOD, ElementType.TYPE })  
	@Retention(RetentionPolicy.RUNTIME)  
	@HttpMethod("PATCH")  
	@Documented  
	@NameBinding  
	public @interface PATCH {  
	}
	
	@Inject
	private ClientBuilder clientBuilder = null;

	public static final Logger LOG = Logger.getLogger(WorkflowAPI.class);
	public static final String WS_SERVICE_WORKFLOW = "/workflow/api/v1/pendencies/";
	ResponseModelDTO response = new ResponseModelDTO();
	WorkUtils util = new WorkUtils();
	String url = null;
	Client client;

	@Path("pendencias")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response consultarPendencias(
			@HeaderParam("Authorization") String token,
			@QueryParam("offset") long offset,
			@QueryParam("limit") long limit,
			@QueryParam("fields") String fields) {
		if(token == null) 
			return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build();

		client = clientBuilder.build(token);
		if(client.isAutenticated() == false){
			LOG.warn(Status.UNAUTHORIZED+" - "+util.getObjJson(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION, "message"));
			return Response.status(Status.UNAUTHORIZED).entity(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION).build();
		}	

		// Valida licenciamento e permissões
		AutorizacaoServico autorizacaoServico = new AutorizacaoServico(clientBuilder);
		
		Optional<Response> naoAutorizadoAdmin = autorizacaoServico.verificarPermissoes(token, AutorizacaoServico.GRUPODESEGURANCA_ADMINISTRACAO);
		if (naoAutorizadoAdmin.isPresent()) {
			return naoAutorizadoAdmin.get();
		}
		
		
		
		String retorno = null;
		try {
			url = util.getUrl(token)+WS_SERVICE_WORKFLOW;
			if(fields == null && !(limit == 0)) {
				url = url+"?offset="+offset+"&limit="+limit;
			}
			else if (offset == 0 && limit == 0 && fields != null) {
				url = url+"?fields="+fields;
			}
			else if ((offset != 0) && (limit == 0) && fields != null) {
				url = url+"?offset="+offset+"&fields="+fields;
			}
			else if((offset != 0 && limit == 0) && fields != null) {
				url = url+"?offset="+offset+"&limit="+limit+"&fields="+fields;
			}
			response = util.callServiceRest(url, token, "get", "");
			retorno = response.getRetornoServico();
			if (!retorno.isEmpty()) {
				//retorno = retorno.substring (1); 
				retorno = retorno.substring (1, retorno.length() - 1);  
				retorno = "[["+retorno+"],["+util.formatJson("logado", util.getUsuario(token, "nome"))+"]]";
				if (retorno.contains("<br>")) {
					retorno = retorno.replace("<br>", "\r\n");
				}
			}
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" - Não foi possível buscar as pendências!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(response.getStatusCode()).entity(retorno).build();
	}

	@Path("pendencias/{idPendencia}")
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response consultarPendenciaUnica(
			@HeaderParam("Authorization") String token,
			@PathParam("idPendencia") String idPendencia,
			@QueryParam("fields") String fields) {
		if(token == null) 
			return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build();

		client = clientBuilder.build(token);
		if(client.isAutenticated() == false){
			LOG.warn(Status.UNAUTHORIZED+" - "+util.getObjJson(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION, "message"));
			return Response.status(Status.UNAUTHORIZED).entity(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION).build();
		}	

		// Valida licenciamento e permissões
		AutorizacaoServico autorizacaoServico = new AutorizacaoServico(clientBuilder);
		
		Optional<Response> naoAutorizadoAdmin = autorizacaoServico.verificarPermissoes(token, AutorizacaoServico.GRUPODESEGURANCA_ADMINISTRACAO);
		if (naoAutorizadoAdmin.isPresent()) {
			return naoAutorizadoAdmin.get();
		}

		try {
			url = util.getUrl(token)+WS_SERVICE_WORKFLOW+idPendencia;
			if(fields != null)
				url = url+"/?fields="+fields;
			response = util.callServiceRest(url, token, "get", "");
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" - Não foi possível buscar a pendência!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(response.getStatusCode()).entity(response.getRetornoServico()).build();
	}

	@Path("pendencia/{idPendencia}/assumir")
	@PATCH
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response assumirPendencia(
			@HeaderParam("Authorization") String token,
			@PathParam("idPendencia") String idPendencia) {
		if(token == null) 
			return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build();

		client = clientBuilder.build(token);
		if(client.isAutenticated() == false){
			LOG.warn(Status.UNAUTHORIZED+" - "+util.getObjJson(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION, "message"));
			return Response.status(Status.UNAUTHORIZED).entity(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION).build();
		}	

		// Valida licenciamento e permissões
		AutorizacaoServico autorizacaoServico = new AutorizacaoServico(clientBuilder);
		
		Optional<Response> naoAutorizadoAdmin = autorizacaoServico.verificarPermissoes(token, AutorizacaoServico.GRUPODESEGURANCA_ADMINISTRACAO);
		if (naoAutorizadoAdmin.isPresent()) {
			return naoAutorizadoAdmin.get();
		}

		try {
			url = util.getUrl(token)+WS_SERVICE_WORKFLOW+idPendencia;
			String responsavel = util.formatJson("responsible", util.getUsuario(token, "nome"));
			response = util.callServiceRest(url, token, "patch", responsavel);
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" - Não foi possível assumir a pendência!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		} 
		return Response.status(response.getStatusCode()).entity(response.getRetornoServico()).build();
	}

	@Path("pendencia/{idPendencia}/responder")
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response responderPendencia(
			@HeaderParam("Authorization") String token,
			@PathParam("idPendencia") String idPendencia,  
			String resposta) {
		if (token == null) 
			return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build();

		client = clientBuilder.build(token);
		if(client.isAutenticated() == false){
			LOG.warn(Status.UNAUTHORIZED+" - "+util.getObjJson(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION, "message"));
			return Response.status(Status.UNAUTHORIZED).entity(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION).build();
		}	

		// Valida licenciamento e permissões
		AutorizacaoServico autorizacaoServico = new AutorizacaoServico(clientBuilder);
		
		Optional<Response> naoAutorizadoAdmin = autorizacaoServico.verificarPermissoes(token, AutorizacaoServico.GRUPODESEGURANCA_ADMINISTRACAO);
		if (naoAutorizadoAdmin.isPresent()) {
			return naoAutorizadoAdmin.get();
		}

		if(resposta.equals("")) {
			return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_ACAO).build();
		}
		try {
			url = util.getUrl(token)+WS_SERVICE_WORKFLOW+idPendencia+"/response";
			response = util.callServiceRest(url, token, "post", resposta);
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" - Não foi possível tratar a pendência!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(response.getStatusCode()).entity(response.getRetornoServico()).build();
	}
}