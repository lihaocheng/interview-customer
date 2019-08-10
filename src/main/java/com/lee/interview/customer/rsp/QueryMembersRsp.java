package com.lee.interview.customer.rsp;

import java.util.List;

import com.lee.interview.customer.domain.Member;
import com.lee.interview.customer.resultcode.CustomerResultCode;

public class QueryMembersRsp extends BaseRsp{

	private Integer count;
	
	private List<Member> data;
	
	public QueryMembersRsp(CustomerResultCode resultCode)
	{
		super(resultCode);
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Member> getData() {
		return data;
	}

	public void setData(List<Member> data) {
		this.data = data;
	}

	
	
}
