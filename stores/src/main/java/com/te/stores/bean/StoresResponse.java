package com.te.stores.bean;

import lombok.Data;

@Data
public class StoresResponse {

	private boolean error;

	private Object data;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public StoresResponse() {
		super();
	}

	public StoresResponse(boolean error, Object data) {
		super();
		this.error = error;
		this.data = data;
	}

}
