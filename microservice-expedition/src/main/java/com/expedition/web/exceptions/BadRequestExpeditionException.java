package com.expedition.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExpeditionException extends RuntimeException {

	public BadRequestExpeditionException(String message) {
		super(message);
	}
}
