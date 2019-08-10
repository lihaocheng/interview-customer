package com.lee.interview.customer.req;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CreateMemberReq {

	@NotBlank(message = "memberName can not be blank.")
	@Length(min = 0, max = 255, message = "memberName can not be greater than 255")
	private String memberName;
	@NotNull(message = "sex can not be null.")
	@Min(value = 0, message = "sex must be 0 or 1")
	@Max(value = 1, message = "sex must be 0 or 1")
	private Integer sex;
	@NotBlank(message = "phone can not be blank.")
	@Length(min = 0, max = 32, message = "phone can not be greater than 32")
	private String phone;
	@NotBlank(message = "email can not be blank.")
	@Length(min = 0, max = 255, message = "memberId can not be greater than 255")
	private String email;
	@Length(min = 0, max = 255, message = "address can not be greater than 255")
	private String address;
	
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
	
	
}
