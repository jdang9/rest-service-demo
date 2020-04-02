package com.demo.rest_service.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class PlayerBusinessExceptionMapper implements ExceptionMapper<PlayerBusinessException> {

	@Override
	public Response toResponse(PlayerBusinessException exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\": \"error\"");
		sb.append(",");
		sb.append("\"message\": \"player not found\"");
		sb.append("}");
		
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
