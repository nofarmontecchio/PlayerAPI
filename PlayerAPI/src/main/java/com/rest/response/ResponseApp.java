package com.rest.response;


/**
 * This class is used to create a single type of response to the client from the server.
 * @author Nofar Montecchio
 *
 */
public class ResponseApp {

	
		private int responseCode;
	 	private String errorMessage;
	 	
	 	/**
		 * Default empty constructor.
		 */
	 	public ResponseApp() {}
	 	
	 	/**
	 	 * Constructor that assigns specific information to the attributes of the object.
	 	 * @param errorMessage Error message that is going to be used.
	 	 */
	 	public ResponseApp(String errorMessage) {
	 		
	 		this.errorMessage = errorMessage;
	 	}
	 	/**
	 	 * Constructor that assigns specific information to the attributes of the object.
	 	 * @param errorCode Error code that is going to be used.
	 	 * @param errorMessage Error message that is going to be used.
	 	 */
	 	public ResponseApp(int responseCode, String errorMessage) {
	 		this.responseCode = responseCode;
	 		this.errorMessage = errorMessage;
	 	}
	 	
	 	/**
	 	Getters and Setters
	 	 */
	 	public String getErrorMessage() {
	 		return errorMessage;
	 	}
	 	
	 	public void setErrorMessage(String errorMessage) {
	 		this.errorMessage = errorMessage;
	 	}

		public int getResponseCode() {
			return responseCode;
		}

		public void setResponseCode(int responseCode) {
			this.responseCode = responseCode;
		}
	 		
	 	
	 	
	 }

	
