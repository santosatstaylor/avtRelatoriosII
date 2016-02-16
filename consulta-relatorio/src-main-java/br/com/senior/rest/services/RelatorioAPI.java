package br.com.senior.rest.services;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.file.Files;

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

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import br.com.senior.dto.ResponseModelDTO;
import br.com.senior.dto.StatusDTO;
import br.com.senior.mobile.server.sdk.client.Client;
import br.com.senior.mock.dto.MockDTO;

/**
 * Classe responsável por conter os serviços(rest) para o aplicativo Workflow.
 * @author wesley.barros
 */

@Path("api")
public class RelatorioAPI {
	@Target({ ElementType.METHOD, ElementType.TYPE})
	@Retention(RetentionPolicy.RUNTIME)
	@HttpMethod("PATCH")
	@Documented
	@NameBinding
	public @interface PATCH {
	}
	
//	DynamicConfigurationService dcs = locator.getService(DynamicConfigurationService.class);
//	Populator populator = dcs.getPopulator();
//	populator.populate(new ClasspathDescriptorFileFinder(getClass().getClassLoader()); 
	
/*	@Inject
	private ClientBuilder clientBuilder;
*/	

	/* como trafegar um pdf pelo json
    * http://www.devmedia.com.br/como-transferir-arquivos-entre-aplicacoes-cliente-servidor-com-datasnap/27093
    * org.glassfish.hk2.api.UnsatisfiedDependencyException
    */	
	public static final Logger LOG = Logger.getLogger(RelatorioAPI.class);
	public static final String WS_SERVICE_RELATORIOS = "";
	ResponseModelDTO response = new ResponseModelDTO();
	RelatUtils util = new RelatUtils();
	String url = null;
	Client client;
	
	@Path("produtos")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarProduto(@HeaderParam("Authorization") String token) {
		if (token == null) { return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build(); }
		
/*		client = clientBuilder.build(token);
		if(client.isAutenticated() == false) {
			LOG.warn(Status.UNAUTHORIZED+" - "+StatusDTO.MSG_NOT_FOUND_AUTHORIZATION);
			return Response.status(Status.UNAUTHORIZED).entity(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION).build();
		}
*/
		String retorno = null;
		try {
			retorno = MockDTO.getReq001_produto();
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" Não foi possível obter a lista de produtos!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(200).entity(retorno).build();
	}
	
	@Path("sistemas")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarSistema(@HeaderParam("Authorization") String token) {
		if (token == null) { return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build(); }
		
		String retorno = null;
		try {
			retorno = MockDTO.getReq002_sistema();
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" Não foi possível obter a lista de sistemas!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(200).entity(retorno).build();
	}
	
	@Path("extensao")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarExtensao(@HeaderParam("Authorization") String token) {
		if (token == null) { return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build(); }
		
		String retorno = null;
		try {
			retorno = MockDTO.getReq003_extensao();
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" Não foi possível obter a lista de extensões!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(200).entity(retorno).build();
	}
	
	@Path("categoria")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarCategoria(@HeaderParam("Authorization") String token) {
		if (token == null) { return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build(); }
		
		String retorno = null;
		try {
			retorno = MockDTO.getReq004_categoria();
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" Não foi possível obter a lista de categorias!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(200).entity(retorno).build();
	}
	
	@Path("relacao-relatorios")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarRelacao(@HeaderParam("Authorization") String token) {
		if (token == null) { return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build(); }
		
		String retorno = null;
		try {
			retorno = MockDTO.getReq005_relacao_relatorios();
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" Não foi possível obter lista com a relação de relatorios!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(200).entity(retorno).build();
	}

	@Path("filtro-relatorios/{dtInicio}/{dtFinal}/{relatorio}")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarFiltro(
			@HeaderParam("Authorization") String token,
			@PathParam("dtInicio")        String dtInicio,
			@PathParam("dtFinal")         String dtFinal,
			@PathParam("relatorio")       String relatorio) {
		if (token == null) { return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build(); }
		
		//String retorno = null;
		try {
			//retorno = MockDTO.getReq006_filtro_relatorios();
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" Não foi possível obter lista com filtro de relatorios!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		//return Response.status(200).entity(retorno).build();
		return Response.status(200).entity(StatusDTO.MSG_OK).build();
	}

	@Path("relatorios-gerados/{relatorio}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listarRelatoriosProntos(
			@HeaderParam("Authorization") String token,
			@PathParam("relatorio")       String relatorio) {
		int status = 200;
		if (token == null) { return Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_ERROR_NOT_FOUND_TOKEN).build(); }
		
		String retorno = null;
		try {
			switch (relatorio) {
			case "FPAF002.COL":
				retorno = MockDTO.getReq006_filtro_FPAF002();
				break;
			
			case "FPAF003.COL":
				retorno = MockDTO.getReq006_filtro_FPAF003();
				break;
				
			case "FPAF004.COL":
				retorno = MockDTO.getReq006_filtro_FPAF004();
				break;
				
			case "FPAF005.COL":
				retorno = MockDTO.getReq006_filtro_FPAF005();
				break;
				
			case "FPAF006.COL":
				retorno = MockDTO.getReq006_filtro_FPAF006();
				break;
				
			case "FPPG041.CRE":
				retorno = MockDTO.getReq006_filtro_FPPG041();
				break;
			
			case "FPEG003.EPT":
				retorno = MockDTO.getReq006_filtro_FPEG003();
				break;
			
			case "FPFF007.OPE":
				retorno = MockDTO.getReq006_filtro_FPFF007();
				break;
				
			case "FPFR010.FGT":
				retorno = MockDTO.getReq006_filtro_FPFR010();
				break;
				
			case "FPRE005.IRF":
				retorno = MockDTO.getReq006_filtro_FPRE005();
				break;
			
			default:
				status  = 404;
				retorno = StatusDTO.MSG_NOT_FOUND;
			}
		} catch (Exception e) {
			LOG.error(Status.INTERNAL_SERVER_ERROR+" Não foi possível obter lista com os relatorios disponíveis!\n"+e.getMessage());
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(StatusDTO.MSG_ERROR_INTERNAL_SERVER).build();
		}
		return Response.status(status).entity(retorno).build();
	}
	
	@Path("gera-binario")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response transfereArquivo(
			@HeaderParam("Authorization") String token,
			@QueryParam("arquivo") String arquivo) throws IOException {
		ResponseModelDTO responseModel = new ResponseModelDTO();
		File file = new File(arquivo);
		String retorno = null;
		
		if (file.exists()) {
			byte[] binario = Files.readAllBytes(file.toPath());
			responseModel.setRetornoServico(Base64.encodeBase64String(binario).replaceAll("\r\n", ""));
			responseModel.setStatusCode(Status.OK.getStatusCode());
			retorno = "{\"byte\":\""+responseModel.getRetornoServico()+"\"}";
			return Response.status(Status.OK).entity(retorno).build();
		}
		retorno = "{\"message\":\"Arquivo não encontrado.\"}";
		return Response.status(Status.NOT_FOUND).entity(retorno).build();
	}
}