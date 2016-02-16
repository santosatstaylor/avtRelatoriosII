package br.com.senior.rest.services;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {
	@Override
	protected void configure() {
		bind(RelatoriosAPI.class).to(RelatoriosAPI.class);
	}

}
