package com.lee.interview.customer.rsp;

import com.lee.interview.customer.resultcode.CustomerResultCode;

public class BaseRsp {

	private Integer code;
	
	private String msg;
	
	public BaseRsp(CustomerResultCode resultCode)
	{
		this.code = resultCode.getCode();
		this.msg = resultCode.getMsg();
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
