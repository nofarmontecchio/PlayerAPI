package com.rest.application;

import com.rest.configuration.PlayerAPIConfiguration;
import com.rest.healthCheck.PlayerAPICheck;
import com.rest.resource.PlayerAPIResource;

import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;


/**
 * The base class for Dropwizard applications.
 * Combined with project’s Configuration subclass
 * 
 * @author Nofar Montecchio
 *
 */
public class PlayerAPIApplication extends Application<PlayerAPIConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PlayerAPIApplication().run(args);
    }

    @Override
    public String getName() {
        return "PlayerAPI";
    }

    @Override
    public void initialize(Bootstrap<PlayerAPIConfiguration> bootstrap) {
    	bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
    }

    @Override
    public void run(final PlayerAPIConfiguration configuration,
                    final Environment environment) {
    	final PlayerAPIResource resource = new PlayerAPIResource();
    	
    	
    	final PlayerAPICheck healthCheck = new PlayerAPICheck(configuration.getVersion());
    	    environment.healthChecks().register("template", healthCheck);

    	    environment.jersey().register(resource);
    	
    	
    }

}
