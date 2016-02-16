package br.com.senior.workflow.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Classe responsável por conter os testes dos serviços da WorkflowAPI.
 * @author wesley.barros
 */

public class WorkflowTest extends JerseyTest{

	@Override
	protected Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);

		final HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
		ResourceConfig config = new ResourceConfig().packages("br.com.senior.rest.services");
		config.register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(request).to(HttpServletRequest.class);
			}
		});
		return config;
	}

	private final String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI5IiwiaXNzIjoiMDowOjA6MDowOjA6MDoxIiwiZXhwIjoxOTE4NjUwMzEzLCJpYXQiOjE0NDUyNjExMTN9.GGFHbi6K48pJejbZ0Y7y5RqB1AU9W8ZJ8dQgk-S2Uuw";
	private final String assumirPendencia = "{\"responsible\":\"senior\"}";
	private final String responderPerdencia = "{\"action\":{\"id\":\"APROVAR\",\"reason\":\"Informe justificativa para o fracionamento das férias, obrigado.\"}}";
	private final String idTarefa = "5@13@2";
	private final long offset = 1;
	private final long limit = 3;
	private final String fields = "*,performerInfo/@performer='com.senior.wfe.Action'";
	private final String fields2 = "id,name,performer,expiration";
	
	Client client = ClientBuilder.newClient();
	WebTarget target = client.target("http://192.168.100.163:8080/workflow-services/api/pendencias/");

	@Test
	public void consultarPendenciasTest() {
		final Response response = target.queryParam("offset", offset)
										.queryParam("limit", limit)
										.queryParam("fields", fields)
										.request().header("Authorization", token).get();

		assertEquals(Status.OK.getStatusCode(), response.getStatusInfo().getStatusCode());
		assertNotNull(response.readEntity(String.class));
	}
	
	@Test
	public void consultarPendenciaUnicaTest() {
		final Response response = target.path(idTarefa)
				.queryParam("fields", fields2).request().header("Authorization", token).get();

		assertEquals(Status.OK.getStatusCode(), response.getStatusInfo().getStatusCode());
		assertNotNull(response.readEntity(String.class));
	}

	@Test
	public void assumirPendenciaTest() {
		Entity<String> body = Entity.entity(assumirPendencia, MediaType.APPLICATION_JSON);
		final Response response = target.path(idTarefa).request().header("Authorization", token).post(body);
	
		assertEquals(Status.OK.getStatusCode(), response.getStatusInfo().getStatusCode());
		assertNotNull(response.readEntity(String.class));
		
	}
	
	@Test
	public void responderPendenciaTest() {
		Entity<String> body = Entity.entity(responderPerdencia, MediaType.APPLICATION_JSON);
		final Response response = target.path(idTarefa+"/response").request().header("Authorization", token).post(body);
	
		assertEquals(Status.OK.getStatusCode(), response.getStatusInfo().getStatusCode());	
		assertNotNull(response.readEntity(String.class));
		
	}
}
