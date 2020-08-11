package com.redis.controller;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.redisson.api.ObjectListener;
import org.redisson.api.RFuture;
import org.redisson.api.annotation.REntity;
import org.redisson.api.annotation.RId;
import org.redisson.api.annotation.RIndex;
import org.redisson.client.codec.Codec;

@REntity
public class MyObject  {

    @RId
    private String id;
    
	
    private String field1;

   
    private Integer field2;
    
  
    private Long field3;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public Integer getField2() {
		return field2;
	}

	public void setField2(Integer field2) {
		this.field2 = field2;
	}

	public Long getField3() {
		return field3;
	}

	public void setField3(Long field3) {
		this.field3 = field3;
	}

   
  
}
