package business;

import bank.Entry;

public final class CalculateAverageBalance implements Calculator {
	public final void execute(Entry entry, int threadId) {
		entry.setAverageBalanced( (entry.getBalanced() + entry.getPreviousBalanced()) / 2 );
		entry.setNo1ThreadNo(threadId);
	}
}
