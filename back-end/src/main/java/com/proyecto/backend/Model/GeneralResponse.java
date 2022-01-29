package com.proyecto.backend.Model;

import java.io.Serializable;

public class GeneralResponse<T> implements Serializable {

	private static final long serialVersionUID = 2975454650689834772L;

	private T data;
	private boolean success;
	private String resp;
	private String message;
    private int code;
	

	public T getData() {
		return data;
	}
	
	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
		
}
