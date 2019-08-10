package com.lee.interview.customer.enums;

public enum MemberStatusEnum {

	NEW_CREATE(0, "新建"),
	RUNNING(1, "启用"),
	DELETE(2, "删除");
	
	MemberStatusEnum(Integer statusId, String statusDesc)
	{
		this.statusId = statusId;
		this.statusDesc = statusDesc;
	}
	
	private Integer statusId;
	
	private String statusDesc;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	
}
