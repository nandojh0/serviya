/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.serviYa.controller.dto;

/**
 *
 * @author daihan
 */
public class Respuesta<T> {
	
	private boolean success;

	private String message;
	
	private int errorCode;
	
	private T data;

	public Respuesta() {
		
	}
	
	public Respuesta(Boolean success, String message) {
		this(success, message, 0, null);
	}
	
	public Respuesta(T data) {
		this(true, null, 0, data);
	}

	public Respuesta(boolean success, String message, int errorCode, T data) {
		super();
		this.success = success;
		this.message = message;
		this.errorCode = errorCode;
		this.data = data;
	}

	public boolean getSuccess() {
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

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}

