package thread;

import java.util.List;
import java.util.Map;

import bank.Entry;
import business.Calculator;

public class MyThread extends Thread {
	private List<Entry> list;
	private Map<Long, Integer> map;
	private int threadCount;
	private Calculator calculator;
	
	public MyThread(List<Entry> list, Map<Long, Integer> map, int threadCount, Calculator calculator) {
		super();
		this.list = list;
		this.map = map;
		this.threadCount = threadCount;
		this.calculator = calculator;
	}
	
	@Override
	public void run() {
		final int i = map.get(Thread.currentThread().getId());
		int j = i;
		for(;j < list.size(); j += threadCount) {
			calculator.execute(list.get(j), i);
		}
	}
}
