package com.benitogarcia.biblback.models.dto;

public class ResponseStatusDto {

	private int code;
	private String status;
	private String title;
	private String message;

	public ResponseStatusDto() {
	}

	public ResponseStatusDto(int code, String status, String title, String message) {
		super();
		this.code = code;
		this.status = status;
		this.title = title;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
