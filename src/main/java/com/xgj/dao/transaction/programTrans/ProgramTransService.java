package com.xgj.dao.transaction.programTrans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * 
 * 
 * @ClassName: ProgramTransService
 * 
 * @Description: 在实际应用中，很少通过编程的方式来进行事务管理。
 * 
 * @author: Mr.Yang
 * 
 * @date: 2017年9月21日 下午3:48:10
 */

@Service
public class ProgramTransService {

	private JdbcTemplate jdbcTemplate;
	private TransactionTemplate transactionTemplate;

	// 下面两条SQL在一个事务中，第二条故意写错了表名，会执行失败，第一条已经成功的SQL也会回滚
	private static final String addArtisanSQL = "insert into artisan_user(user_name,password) values(?,?)";
	private static final String deleteOneArtisanSQL = "delete from artisan_user1 where user_name = 'ArtisanBatch0' ";

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 
	 * 
	 * @Title: setTransactionTemplate
	 * 
	 * @Description: 通过AOP主动注入transactionTemplate
	 * 
	 * @param transactionTemplate
	 * 
	 * @return: void
	 */
	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void operArtisanInTrans(final Artisan artisan) {

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				// 需要在事务中执行的逻辑
				jdbcTemplate.update(addArtisanSQL, artisan.getUserName(),
						artisan.getPassword());
				System.out.println("addArtisanSQL  OK ");
				jdbcTemplate.update(deleteOneArtisanSQL);
				System.out.println("deleteOneArtisanSQL  OK ");
			}
		});

	}
}
