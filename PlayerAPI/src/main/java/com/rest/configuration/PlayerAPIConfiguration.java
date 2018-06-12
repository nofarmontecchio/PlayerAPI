package com.rest.configuration;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;

public class PlayerAPIConfiguration extends Configuration {
		
		@NotEmpty
	    private String version;

		/**
	     * Returns the version of the configuration file.
	     * @return version
	     */
	    @JsonProperty
	    public String getVersion() {
	        return version;
	    }

	    /**
	     * Sets the version of the configuration file.
	     * @return version
	     */
	    @JsonProperty
	    public void setVersion(String version) {
	        this.version = version;
	    }
}
