package com.lee.interview.customer.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.interview.customer.controller.MemberController;
import com.lee.interview.customer.domain.Member;
import com.lee.interview.customer.mapper.MemberMapper;
import com.lee.interview.customer.req.QueryMembersReq;
import com.lee.interview.customer.req.UpdateMemberReq;
import com.lee.interview.customer.req.CreateMemberReq;
import com.lee.interview.customer.resultcode.CustomerResultCode;
import com.lee.interview.customer.rsp.BaseRsp;
import com.lee.interview.customer.rsp.QueryMembersRsp;
import com.lee.interview.customer.service.MemberService;
@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public QueryMembersRsp queryMembers(QueryMembersReq req) {
		PageHelper.startPage(req.getPageNo(), req.getPageSize());
		List<Member> memberList = memberMapper.queryMembers(req);
		PageInfo<Member> pageInfo = new PageInfo<Member>(memberList);
		QueryMembersRsp rsp = new QueryMembersRsp(CustomerResultCode.SUCCESS);
		rsp.setData(memberList);
		rsp.setCount((int)pageInfo.getTotal());
		return rsp;
	}

	@Override
	public BaseRsp createMember(CreateMemberReq req) {
		Member member = Member.transfer(req);
		memberMapper.createMember(member);
		return new BaseRsp(CustomerResultCode.SUCCESS);
	}

	@Override
	public BaseRsp updateMember(UpdateMemberReq req) {
		LOG.info("start update member by memberId:" + req.getMemberId());
		String memberId = req.getMemberId();
		Member member = memberMapper.getMember(memberId);
		if(member == null)
		{
			LOG.warn("can not find member by memberId:" + memberId);
			return new BaseRsp(CustomerResultCode.DOMAIN_DOSE_NOT_EXIST);
		}
		Member updateMember = Member.transfer(req);
		memberMapper.updateMember(updateMember);
		return new BaseRsp(CustomerResultCode.SUCCESS);
	}

	@Override
	public BaseRsp deleteMember(String memberId) {
		LOG.info("start delete member by memberId:" + memberId);
		if(StringUtils.isEmpty(memberId))
		{
			LOG.warn("param is null, memberId:" + memberId);
			return new BaseRsp(CustomerResultCode.PARAM_IS_NULL);
		}
		Member member = memberMapper.getMember(memberId);
		if(member == null)
		{
			LOG.warn("can not find member by memberId:" + memberId);
			return new BaseRsp(CustomerResultCode.DOMAIN_DOSE_NOT_EXIST);
		}
		memberMapper.deleteMember(memberId);
		return new BaseRsp(CustomerResultCode.SUCCESS);
	}

}
