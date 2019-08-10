package com.lee.interview.customer.resultcode;

public enum CustomerResultCode 
{
	
	SUCCESS(0, "success"),
	
	DOMAIN_DOSE_NOT_EXIST(10001, "domain does not exist."),
	
	PARAM_IS_NULL(10002, "param is null.");
	
	private Integer code;
	
	private String msg;
	
	CustomerResultCode(Integer code, String msg)
	{
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	
}
