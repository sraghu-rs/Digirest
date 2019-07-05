package com.digirest.service.api;

import org.glassfish.jersey.server.ResourceConfig;

import com.digirest.filter.AuthenticationFilter;

/**
 *  set the filter applications manually and not via web.xml
 */
public class RestApplicationConfig extends ResourceConfig {
	
	public RestApplicationConfig() {
        packages( "com.unify.rest.filter" );
		register( AuthenticationFilter.class );
	}
}
