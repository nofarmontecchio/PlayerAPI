package com.rest.healthCheck;

import com.codahale.metrics.health.HealthCheck;
import com.rest.dao.DAO;

/**
 * Health checks give a way of adding small tests to the application
 * Used to verify that the application is functioning correctly in production.
 * 
 * @author Nofar Montecchio
 */
 
public class PlayerAPICheck extends HealthCheck{

	 private final String version;

	    public PlayerAPICheck(String version) {
	        this.version = version;
	    }

	    @Override
	    protected Result check() throws Exception {
	        if (DAO.getCount() == 0) {
	            return Result.unhealthy("No persons in DB! Version: " + this.version);
	        }
	        return Result.healthy("OK with version: " + this.version + ". Players count: " + DAO.getCount());
	    }
	
}
