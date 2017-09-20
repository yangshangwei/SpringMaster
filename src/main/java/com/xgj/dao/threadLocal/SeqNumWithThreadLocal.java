package com.xgj.dao.threadLocal;

public class SeqNumWithThreadLocal {

	private ThreadLocal<Integer> seqNumLocal = new ThreadLocal<Integer>() {
		// 通过匿名内部类覆盖initialValue方法，指定初始值
		protected Integer initialValue() {
			return 0;
		}
	};

	// 获取下一个序列值
	public int getNextNum() {
		seqNumLocal.set(seqNumLocal.get() + 1);
		return seqNumLocal.get();
	}

	public static void main(String[] args) {
		SeqNumWithThreadLocal seqNum = new SeqNumWithThreadLocal();
		TestThread t1 = new TestThread(seqNum);
		TestThread t2 = new TestThread(seqNum);
		TestThread t3 = new TestThread(seqNum);

		t1.start();
		t2.start();
		t3.start();

	}

	@SuppressWarnings("unused")
	static class TestThread extends Thread {

		SeqNumWithThreadLocal sn = new SeqNumWithThreadLocal();

		public TestThread(SeqNumWithThreadLocal sn) {
			this.sn = sn;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) { // 每个线程打印 5个值
				System.out.println("Thread:" + Thread.currentThread().getName()
						+ ",sn:" + sn.getNextNum());
			}
		}

	}

}
