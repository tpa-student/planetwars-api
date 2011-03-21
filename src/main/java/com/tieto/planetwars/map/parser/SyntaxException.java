package com.tieto.planetwars.map.parser;

public class SyntaxException extends RuntimeException {
	private String msg;	
	
	public SyntaxException(String message) {
		msg = message;
	}

	public SyntaxException() {
		msg = "";
	}
	
}
