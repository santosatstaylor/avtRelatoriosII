package br.com.senior.rest.services;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import senior.escolas.domain.dao.UsuarioDAO;
import br.com.senior.dto.ResponseModelDTO;
import br.com.senior.mobile.server.sdk.client.Client;
import br.com.senior.mobile.server.sdk.client.DefaultClientBuilder;
import br.com.senior.mobile.server.sdk.client.EAuthProvider;
import br.com.senior.mobile.server.sdk.client.Property;

import com.senior.auth.utils.ServicesConsts;

public class WorkUtils {
	
	JSONObject obj = new JSONObject();
	JSONParser jsonParse = new JSONParser();

	
	public Boolean validarToken(String token) {
		Client client = new DefaultClientBuilder().build(token);

		return client.isAutenticated();
	}

	public Object getUsuario(String token, String prop) {
		Client client = new DefaultClientBuilder().build(token);
		Object propriedade = null;

		switch(prop) {
		case "nome":
			propriedade = client.getUser().getName();
			break;
			
		case "email":
			propriedade = client.getUser().getEmail();
			break;
			
		case "inquilino":
			propriedade = client.getUser().getTenant().getId();
			break;
			
		case "provedor":
			propriedade = client.getUser().getAuthProvider().getKey();
			break;
			
		case "senha":
			UsuarioDAO usuario = new UsuarioDAO();
			try {
				propriedade = usuario.getSenha(
						client.getUser().getEmail(),
						client.getUser().getAuthProvider().getKey(),
						client.getUser().getTenant().getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		}
		return propriedade;
	}

	@SuppressWarnings("unchecked")
	public String formatJson(String key, Object valor) {
		JSONObject obj = new JSONObject();
		obj.put(key, valor);

		return obj.toJSONString();	
	}

	public String getAuthentication(String token) {
		String authorization = getUsuario(token, "nome")+":"+getUsuario(token, "senha");
		Base64 base64 = new Base64();
		String dataEncoded = new String(base64.encode(authorization.getBytes()));

		return "Basic "+dataEncoded;
	}

	public String getUrl(String token) {
		Client client = new DefaultClientBuilder().build(token);
		Client authzClient = new DefaultClientBuilder().build(token);
		EAuthProvider authProvider = client.getUser().getAuthProvider();
		String urlKey = ServicesConsts.PROPERTY_PREFIX + authProvider.getValue() + ServicesConsts.PROPERTY_WEBSERVICES_URL;

		Property propertyUrl = authzClient.getProperty(urlKey);
		String url = propertyUrl.getValue();

		return url;	
	}

	public ResponseModelDTO callServiceRest(String url, String token, String method, String param) throws Exception {
		CloseableHttpClient httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
		StringEntity entityString = new StringEntity(param);
		entityString.setContentType("application/json");
		HttpResponse response = null;

		switch (method) {
		case "get":
			HttpGet get = new HttpGet(url);
			get.setHeader("Authorization", getAuthentication(token));
			response = httpClient.execute(get);
			break;

		case "put":
			HttpPut put = new HttpPut(url);
			put.setHeader("Authorization", getAuthentication(token));
			put.setEntity(entityString);
			response = httpClient.execute(put);
			break;

		case "post":
			HttpPost post = new HttpPost(url);
			post.setHeader("Authorization", getAuthentication(token));
			post.setEntity(entityString);
			response = httpClient.execute(post);
			break;

		case "patch":
			HttpPatch patch = new HttpPatch(url);
			patch.setHeader("Authorization", getAuthentication(token));
			patch.setEntity(entityString);
			response = httpClient.execute(patch);
			break;

		case "delete":
			HttpDelete delete = new HttpDelete(url);
			delete.setHeader("Authorization", getAuthentication(token));
			response = httpClient.execute(delete);
			break;
		}		
		
		HttpEntity entity = response.getEntity();
		ResponseModelDTO responseModel = new ResponseModelDTO();
		responseModel.setRetornoServico(EntityUtils.toString(entity, "UTF-8"));
		responseModel.setStatusCode(response.getStatusLine().getStatusCode());

		return responseModel;
	}
	
	public String getObjJson(String json, String objeto) {
		String valor = null;
		try {
			obj = (JSONObject) jsonParse.parse(json);
			valor = ((String) obj.get(objeto));
		} catch (ParseException pe) {
			pe.getStackTrace();
		}
		return valor;	
	}
}