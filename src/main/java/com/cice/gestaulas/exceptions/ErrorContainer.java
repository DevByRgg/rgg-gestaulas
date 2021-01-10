package com.cice.gestaulas.exceptions;

/**
 * NO USADA DE MOMENTO
 * @author Diego
 *
 */
public class ErrorContainer {
	private int id;
	private String message;
	/**
	 * @param id
	 * @param message
	 */
	public ErrorContainer(int id, String message) {
		this.id = id;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

	@Override
	public String toString() {
		
	
		StringBuilder builder = new StringBuilder();
		builder.append("ErrorContainer [id=");
		builder.append(id);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}
	
	
}
