package com.lee.interview.customer.domain;

import java.sql.Timestamp;

import com.lee.interview.common.util.DateUtil;
import com.lee.interview.common.util.IdUtil;
import com.lee.interview.customer.enums.MemberStatusEnum;
import com.lee.interview.customer.req.CreateMemberReq;
import com.lee.interview.customer.req.UpdateMemberReq;

public class Member {

	private String memberId;
	private String memberName;
	private Integer sex;
	private String phone;
	private String email;
	private String address;
	private Timestamp joinTime;
	private Timestamp createTime;
	private Integer status; //状态，0：新建，1：启用，2：删除
	private String creator;
	private Timestamp updateTime;
	private String updator;
	
	public static Member transfer(CreateMemberReq req)
	{
		Member member = new Member();
		member.setMemberId(IdUtil.randomId());
		member.setMemberName(req.getMemberName());
		member.setSex(req.getSex());
		member.setPhone(req.getPhone());
		member.setEmail(req.getEmail());
		member.setAddress(req.getAddress());
		member.setJoinTime(DateUtil.currentTimestamp());
		member.setCreateTime(DateUtil.currentTimestamp());
		member.setStatus(MemberStatusEnum.NEW_CREATE.getStatusId());
		return member;
	}
	
	public static Member transfer(UpdateMemberReq req)
	{
		Member member = new Member();
		member.setMemberId(req.getMemberId());
		member.setMemberName(req.getMemberName());
		member.setSex(req.getSex());
		member.setPhone(req.getPhone());
		member.setEmail(req.getEmail());
		member.setAddress(req.getEmail());
		member.setUpdateTime(DateUtil.currentTimestamp());
		return member;
	}
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Timestamp joinTime) {
		this.joinTime = joinTime;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	
	
}
