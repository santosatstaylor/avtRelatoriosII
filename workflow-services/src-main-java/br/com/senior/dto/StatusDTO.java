package br.com.senior.dto;

import org.json.simple.JSONArray;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_DEFAULT)
public class StatusDTO {
	
	@JsonProperty
	private JSONArray status;
	
	@JsonProperty
	private long code;
	
	@JsonProperty
	private String message;
	
	public static final String MSG_ERROR_NOT_FOUND_TOKEN = "{\"Erro\":\"Token não encontrado! Não foi possível realizar a operação.\"}";
	public static final String MSG_ERROR_NOT_FOUND_ACAO = "{\"Erro\":\"Ação da pendência não encontrada! Não foi possível realizar a operação.\"}";
    public static final String MSG_ERROR_INTERNAL_SERVER = "{\"Erro\":\"Falha interna: Não foi possível realizar a operação. Contate o administrador do sistema.\"}";
    public static final String MSG_ERROR_AUTHORIZATION = "{\"Erro\":\"Usuário não foi autenticado. Você não tem autorização para realizar essa operação.\"}";
    public static final String MSG_NOT_FOUND_AUTHORIZATION = "{\"message\":\"Authorization não encontrado! Não foi possível realizar a operação solicitada.\"}";
	
	public StatusDTO(long code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public StatusDTO() {	
	}
	
	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
		
}