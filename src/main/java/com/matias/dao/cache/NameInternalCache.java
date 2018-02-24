package com.matias.dao.cache;

import org.springframework.stereotype.Component;

import com.matias.dao.cache.exception.CacheException;

@Component
public class NameInternalCache extends InternalCache<Long> {

	public Long getRowCount() throws CacheException {
		return super.getObject();
	}

	public void updateRowCount(Long rowCount) {
		super.update(rowCount);
	}
}
