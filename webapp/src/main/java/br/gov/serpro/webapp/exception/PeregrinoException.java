package br.gov.serpro.webapp.exception;

import br.gov.frameworkdemoiselle.exception.ApplicationException;
import br.gov.frameworkdemoiselle.message.SeverityType;

@ApplicationException(severity = SeverityType.ERROR)
public class PeregrinoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PeregrinoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PeregrinoException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PeregrinoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PeregrinoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
