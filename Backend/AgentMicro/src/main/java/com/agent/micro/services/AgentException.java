package com.agent.micro.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class AgentException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private Long resourceId;
	private String errorCode;
	private HttpStatus status;
	    
	    public AgentException(String message) {
	        super(message);
	    }
	    
	   public AgentException(Long resourceId, String message) {
	        super(message);
	        this.resourceId = resourceId;
	    }
	    public AgentException(Long resourceId, String errorCode, String message) {
	        super(message);
	        this.resourceId = resourceId;
	        this.errorCode = errorCode;
	    }
	    
	    public AgentException(String errorCode, String message) {
	        super(message);
	        this.errorCode = errorCode;
	    }
	    
	    public AgentException(String errorCode, String message, HttpStatus status) {
	        super(message);
	        this.errorCode = errorCode;
	        this.status = status;
	    }

	    public Long getResourceId() {
	        return resourceId;
	    }

	    public void setResourceId(Long resourceId) {
	        this.resourceId = resourceId;
	    }

	    public String getErrorCode() {
	        return errorCode;
	    }

	    public void setErrorCode(String errorCode) {
	        this.errorCode = errorCode;
	    }    
	    
	    public HttpStatus getStatus() {
	        return status;
	    }

	    public void setStatus(HttpStatus status) {
	        this.status = status;
	    }
	    

}
