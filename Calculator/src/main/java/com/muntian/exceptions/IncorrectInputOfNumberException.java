package com.muntian.exceptions;

public class IncorrectInputOfNumberException extends IllegalArgumentException {
	
	public IncorrectInputOfNumberException() {
		super();
	}
	
	public IncorrectInputOfNumberException(String message) {
		super(message);
	}
}
