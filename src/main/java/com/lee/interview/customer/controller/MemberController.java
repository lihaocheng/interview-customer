package com.lee.interview.customer.controller;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lee.interview.customer.req.CreateMemberReq;
import com.lee.interview.customer.req.QueryMembersReq;
import com.lee.interview.customer.req.UpdateMemberReq;
import com.lee.interview.customer.rsp.BaseRsp;
import com.lee.interview.customer.rsp.QueryMembersRsp;
import com.lee.interview.customer.service.MemberService;


@RestController
@RequestMapping("/interview/customer/v1")
public class MemberController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MemberController.class);
	@Autowired
	private RestTemplate restTemplate;

//	@RequestMapping("/warp/get/{userId}")
//	public UserInfo getUser(@PathVariable Integer userId) {
//		return restTemplate.getForObject("http://localhost:8099/user/get/"+userId, UserInfo.class);
//	}
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(path = "/members", method = RequestMethod.GET)
	public QueryMembersRsp queryMembers(@RequestParam(required = false) String startTime, 
							   @RequestParam(required = false) String endTime, 
							   @RequestParam(required = false) String memberName, 
							   @RequestParam(required = true) Integer pageNo,
							   @RequestParam(required = true) Integer pageSize) {
		LOG.info("start queryMembers");
		QueryMembersReq req = new QueryMembersReq();
		req.setStartTime(startTime);
		req.setEndTime(endTime);
		req.setMemberName(memberName);
		req.setPageNo(pageNo);
		req.setPageSize(pageSize);
		return memberService.queryMembers(req);
	}
	
	@RequestMapping(path = "/member/create", method = RequestMethod.POST)
	public BaseRsp createMember(@RequestBody  @Valid CreateMemberReq req) {
		LOG.info("start createMember");
		return memberService.createMember(req);
	}
	
	@RequestMapping(path = "/member/update", method = RequestMethod.PUT)
	public BaseRsp updateMember(@RequestBody  @Valid UpdateMemberReq req) {
		LOG.info("start updateMember");
		return memberService.updateMember(req);
	}
	
	@RequestMapping(path = "/member/{memberId}", method = RequestMethod.DELETE)
	public BaseRsp updateMember(@PathVariable(value = "memberId") String memberId) {
		LOG.info("start deleteMember");
		return memberService.deleteMember(memberId);
	}
}
