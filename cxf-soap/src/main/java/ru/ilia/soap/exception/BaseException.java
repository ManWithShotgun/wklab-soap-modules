package ru.ilia.soap.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class BaseException extends WebApplicationException  {

	private String message;

	public BaseException(Status status, String message) {
		super(Response.status(status).entity(message).build());

		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
