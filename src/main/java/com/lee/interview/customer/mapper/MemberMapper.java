package com.lee.interview.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.lee.interview.customer.domain.Member;
import com.lee.interview.customer.req.QueryMembersReq;
@Mapper
public interface MemberMapper {

	public List<Member> queryMembers(QueryMembersReq req);
	
	public void createMember(Member member);
	
	public Member getMember(@Param(value = "memberId") String memberId);

	public void updateMember(Member member);
	
	public void deleteMember(@Param(value = "memberId") String memberId);
}
