package com.experimentality.Exception;

import java.io.IOException;

public class TallaException extends IOException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6890550011934097787L;

	public TallaException() {
		super("Datos no almacenados!!!");
	}
}
