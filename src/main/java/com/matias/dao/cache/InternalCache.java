package com.matias.dao.cache;

import com.matias.dao.cache.exception.CacheException;

public class InternalCache<T> {

	private Boolean status = false;
	private T object = null;
	private java.util.Date dateofExpiration = null;

	private Boolean getStatus() {
		if (dateofExpiration != null && !dateofExpiration.before(new java.util.Date()))
        {
			return false;
        }
		return status;
	}

	public void isExpired() {
		this.status = false;
	}

	public T getObject() throws CacheException {
		if (!getStatus()) {
			System.out.println("Cache expired.");
			throw new CacheException();
		}
		System.out.println("Using cache.");
		return object;
	}

	public void update(T obj) {
		this.object = obj;
		this.status = true;
	}
	
	public void update(T obj, int minutesToLive) {
		update(obj);
		dateofExpiration = new java.util.Date();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(dateofExpiration);
        cal.add(cal.MINUTE, minutesToLive);
        dateofExpiration = cal.getTime();
	}
}
