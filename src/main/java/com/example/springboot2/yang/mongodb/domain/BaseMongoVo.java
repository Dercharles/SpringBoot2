package com.example.springboot2.yang.mongodb.domain;

import java.io.Serializable;

public abstract class BaseMongoVo implements Serializable{
	
	protected static final long serialVersionUID = 1373760761780840080L;
	
	private Pagination pagination;

	public Pagination getPagination() {
		return pagination == null ? new Pagination() : pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
	

}
