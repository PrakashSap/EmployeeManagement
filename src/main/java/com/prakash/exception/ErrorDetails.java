/**
 * 
 */
package com.prakash.exception;

import java.util.Date;

/**
 * @author Prakash M
 *
 */
public class ErrorDetails {
	 
	 @SuppressWarnings("unused")
	private Date timestamp;
	@SuppressWarnings("unused")
	private String message;
	@SuppressWarnings("unused")
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {

		 super();
		  this.timestamp = timestamp;
		  this.message = message;
		  this.details = details;
		}

}
