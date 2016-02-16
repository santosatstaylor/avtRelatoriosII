package br.com.senior.rest.services;

import java.io.IOException;
import java.util.Collections;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
 
/**
 * https://developer.mozilla.org/en-US/docs/Web/HTTP/Access_control_CORS
 */
@Provider
public class CorsFilter implements ContainerResponseFilter { 

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		String origins = requestContext.getHeaderString("Origin");
		if (origins != null) {
			responseContext.getHeaders().add("Access-Control-Allow-Origin", origins);
			responseContext.getHeaders().add("Access-Control-Allow-Credentials", true);
		}

		if ("OPTIONS".equals(requestContext.getMethod())) {  
			if (responseContext.getHeaderString("Accept-Patch") == null) {  
				responseContext.getHeaders().put(  
						"Accept-Patch", Collections.<Object>singletonList("application/json-patch+json"));    
			}  
		}  

		if (requestContext.getMethod().equals("OPTIONS")) {
			responseContext.getHeaders().add("Access-Control-Allow-Methods", "PATCH, POST, GET, DELETE, PUT, HEAD, OPTIONS");
		}

		String requestHeaders = requestContext.getHeaderString("Access-Control-Request-Headers");

		if (requestHeaders != null) {
			responseContext.getHeaders().add("Access-Control-Allow-Headers", requestHeaders);
		}
	}
}
