package com.lee.interview.customer.service;


import com.lee.interview.customer.req.QueryMembersReq;
import com.lee.interview.customer.req.UpdateMemberReq;


import com.lee.interview.customer.req.CreateMemberReq;
import com.lee.interview.customer.rsp.BaseRsp;
import com.lee.interview.customer.rsp.QueryMembersRsp;

public interface MemberService {

	public QueryMembersRsp queryMembers(QueryMembersReq req);
	
	public BaseRsp createMember(CreateMemberReq req);

	public BaseRsp updateMember(UpdateMemberReq req);

	public BaseRsp deleteMember(String memberId); 
}
