package com.xgj.dao.basicOperation.callProc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository
public class CallProcDemoWithSimpleJdbcCall {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void getUserCount(int userId) {

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("PROC_artisan_selectInfo_withId");
		// 如果调用function 则为withFunctionName(functionName)

		// 注册入参 必须和存过的入参保持一致 不区分大小写
		SqlParameterSource in = new MapSqlParameterSource().addValue(
				"p_user_id", userId);

		// 获取返回结果
		Map<String, Object> outMap = jdbcCall.execute(in);

		for (Map.Entry<String, Object> entry : outMap.entrySet()) {
			System.out.println("key=" + entry.getKey() + ",value="
					+ entry.getValue());
		}

		String userName = (String) outMap.get("O_USERNAME");
		String password = (String) outMap.get("O_PASSWORD");

		System.out.println("userName:" + userName + " ,password=" + password);

	}
}
