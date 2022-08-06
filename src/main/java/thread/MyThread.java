package thread;

import java.util.List;
import java.util.Map;

import bank.Entry;
import business.CalculateAverageBalance;

public class MyThread extends Thread {
	private List<Entry> list;
	private Map<Long, Integer> map;
	private int threadCount;
	
	public MyThread(List<Entry> list, Map<Long, Integer> map, int threadCount) {
		super();
		this.list = list;
		this.map = map;
		this.threadCount = threadCount;
	}
	
	@Override
	public void run() {
		final int i = map.get(Thread.currentThread().getId());
		int j = i;
		for(;j < list.size(); j += threadCount) {
			CalculateAverageBalance.execute(list.get(j), i);
		}
	}
}
