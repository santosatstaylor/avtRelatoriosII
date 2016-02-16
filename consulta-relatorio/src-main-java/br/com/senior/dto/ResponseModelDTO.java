package br.com.senior.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public class ResponseModelDTO {  

	public ResponseModelDTO() {}

	@XmlElement(name = "statusCode") 
	private int statusCode; 

	@XmlElement(name = "retornoServico") 
	private String retornoServico; 

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getRetornoServico() {
		return retornoServico;
	}

	public void setRetornoServico(String retornoServico) {
		this.retornoServico = retornoServico;
	}  

}