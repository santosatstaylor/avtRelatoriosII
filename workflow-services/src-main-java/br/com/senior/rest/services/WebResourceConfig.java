package br.com.senior.rest.services;

import org.glassfish.hk2.api.PerLookup;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import br.com.senior.mobile.server.sdk.client.ClientBuilder;
import br.com.senior.mobile.server.sdk.client.DefaultClientBuilder;

public class WebResourceConfig extends ResourceConfig {
	
	public WebResourceConfig() {
        super(JacksonFeature.class);

        register(new AbstractBinder() {

            @Override
            protected void configure() {
                bind(DefaultClientBuilder.class).to(ClientBuilder.class).in(PerLookup.class);
            }
        });

        packages(true, "br.com.senior.rest.services");
    }
}


