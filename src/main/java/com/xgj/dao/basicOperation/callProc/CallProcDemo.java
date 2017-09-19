package com.xgj.dao.basicOperation.callProc;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.stereotype.Component;

import com.xgj.dao.demo.BaseDao;

@Component
public class CallProcDemo extends BaseDao {
	// (1) 调用存过的语句
	private static final String PROCSQL_STRING = "call PROC_artisan_oper(?,?)";

	public int getUserCount(final String userName) {
		int num = jdbcTemplate.execute(PROCSQL_STRING,
				new CallableStatementCallback<Integer>() {

					@Override
					public Integer doInCallableStatement(CallableStatement cs)
							throws SQLException, DataAccessException {
						// (2)绑定入参
						cs.setString(1, userName);
						// (3)注册输出参数
						cs.registerOutParameter(2, Types.INTEGER);
						// 执行
						cs.execute();
						return cs.getInt(2);
					}
				});
		System.out.println("num:" + num);
		return num;
	}
}
