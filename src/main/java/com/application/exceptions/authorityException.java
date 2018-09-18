/**
 * author: Alhajras Algdairy
 * 
 *  authorityException throws an error if the user has an
 *   invalid key
 * */

package com.application.exceptions;

public class authorityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public authorityException(String error) {
		super(error);

	}
}
