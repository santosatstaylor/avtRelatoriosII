package br.com.senior.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import br.com.senior.dto.StatusDTO;
import br.com.senior.mobile.server.sdk.client.Client;
import br.com.senior.mobile.server.sdk.client.ClientBuilder;

public class AutorizacaoServico {

	private final ClientBuilder clientBuilder;
	
	private static int codigoSistema = 8;       // 8    - (systemCode) sistema mobilidade
	private static int codigoModulo  = 1507;    // 1507 - (moduleCode) código do Workflow
	
	public static final String GRUPODESEGURANCA_ADMINISTRACAO = "Mobilidade - Central de Tarefas - Administradores";
	public static final String MSG_NOT_AUTHENTICATION = "{\"message\":\"Usuário não autenticado ou inválido.\"}";
	public static final String MSG_NOT_LICENSE = "{\"message\":\"Sem licença de uso ou inválida.\"}";
	public static final String MSG_NOT_PERMISSION = "{\"message\":\"Usuário não pertence ao grupo de segurança\"}";
	
	public AutorizacaoServico (ClientBuilder clientBuilder) {
		this.clientBuilder = clientBuilder;
	}
	
	/**
	 * Valida autenticação, licenciamento e permissão em um grupo de segurança
	 * @param token
	 * @return Retorna Optional.empty() se estiver autenticado, licenciado e com permissão no grupo de segurança, caso contrário, retorna um Response com a informação de qual o motivo de negar o acesso.
	 */
	public Optional<Response> verificarPermissoes(String token, String grupoDeSegurança) {
		List<String> gruposDeSeguranca = new ArrayList<>();
		gruposDeSeguranca.add(grupoDeSegurança);
		return verificarPermissoes(token, gruposDeSeguranca);
	}
	
	/**
	 * Valida autenticação, licenciamento e permissão nos grupos de segurança
	 * @param token
	 * @return Retorna Optional.empty() se estiver autenticado, licenciado e com permissão nos grupos de segurança, caso contrário, retorna um Response com a informação de qual o motivo de negar o acesso.
	 */
	@SuppressWarnings("unchecked")
	public Optional<Response> verificarPermissoes(String token, List<String> gruposDeSegurança) {
		if (token == null || token.isEmpty())
			return Optional.of(Response.status(Status.BAD_REQUEST).entity(StatusDTO.MSG_NOT_FOUND_AUTHORIZATION).build());

		try {
			// Autenticação
			Client client = clientBuilder.build(token);
			if (!client.isAutenticated()) {
				return Optional.of(Response.status(Status.UNAUTHORIZED).entity(MSG_NOT_AUTHENTICATION).build());
			}

			// Licença de uso
			if (!client.isLicensed(codigoSistema, codigoModulo)) {
				return Optional.of(Response.status(Status.FORBIDDEN).entity(MSG_NOT_LICENSE).build());
			}

			// Permissões
			for (String grupoDeSeguranca : gruposDeSegurança) {
				if (!client.isInRole(grupoDeSeguranca)) {
					JSONParser jsonParser = new JSONParser();
					JSONObject jsonObject = (JSONObject) jsonParser.parse(MSG_NOT_PERMISSION);
					jsonObject.replace("message", jsonObject.get("message")+": "+grupoDeSeguranca);
					return Optional.of(Response.status(Status.FORBIDDEN).entity(jsonObject.toJSONString()).build());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}	
}
