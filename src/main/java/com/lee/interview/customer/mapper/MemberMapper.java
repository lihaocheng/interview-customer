package com.lee.interview.customer.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.lee.interview.customer.domain.Member;
import com.lee.interview.customer.req.QueryMembersReq;

public interface MemberMapper {

	@Select("<script>"  
            + "SELECT * FROM t_customer_member WHERE 1=1"  
            + "<if test='memberName != null'>"  
            + " AND memberName LIKE CONCAT('%',#{memberName},'%')"  
            + "</if>"
            + "<if test='startTime != null'>"  
            + " AND joinTime &gt;= #{startTime}"  
            + "</if>"
            + "<if test='endTime != null '>"  
            + " AND joinTime &lt;= #{endTime}"  
            + "</if>"
            + "ORDER BY createTime DESC"
            + "</script>")  
	public List<Member> queryMembers(QueryMembersReq req);
	
	@Insert("INSERT INTO t_customer_member VALUES(#{memberId}, #{memberName}, #{sex}, #{phone},"
			+ " #{email}, #{address}, #{joinTime}, #{createTime}, #{status}, #{creator}, #{updateTime}, #{updator})")
	public void createMember(Member member);

	@Select("SELECT * FROM t_customer_member WHERE memberId = #{memberId}")
	public Member getMember(@Param(value = "memberId") String memberId);

	@Update("UPDATE t_customer_member SET memberName = #{memberName}, "
			+ "sex = #{sex}, "
			+ "phone = #{phone}, "
			+ "email = #{email}, "
			+ "address = #{address}, "
			+ "joinTime = #{joinTime}, "
			+ "createTime = #{createTime}, "
			+ "status = #{status}, "
			+ "creator = #{creator}, "
			+ "updateTime = #{updateTime}, "
			+ "updator = #{updator} "
			+ "WHERE memberId = #{memberId}")
	public void updateMember(Member member);
	
	@Delete("DELETE FROM t_customer_member WHERE memberId = #{memberId}")
	public void deleteMember(@Param(value = "memberId") String memberId);
}
