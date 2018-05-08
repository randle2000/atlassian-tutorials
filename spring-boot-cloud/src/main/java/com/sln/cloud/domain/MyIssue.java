package com.sln.cloud.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyIssue {
	long id;
	String key;
	Fields fields;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public Fields getFields() {
		return fields;
	}
	
	public void setFields(Fields fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", key=" + key + ", fields=" + fields + "]";
	}
	
}
