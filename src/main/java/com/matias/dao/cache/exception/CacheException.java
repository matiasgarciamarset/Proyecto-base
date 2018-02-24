package com.matias.dao.cache.exception;

public class CacheException extends Exception  {
	
	private static final long serialVersionUID = -5135529939384277754L;

	public CacheException() {
		super();
	}
	
	public CacheException(String message) {
		super(message);
	}
	
	public CacheException(Throwable cause) {
		super(cause);
	}

}
