package business;

import bank.Entry;

public class CalculateFreeTransfer implements Calculator {
	public final void execute(Entry entry, int threadId) {
		if (entry.getBalanced() >= 100 && entry.getBalanced() <= 150) {
			entry.setFreeTransfer(entry.getFreeTransfer() + 5);
		}
		entry.setNo2aThreadNo(threadId);
	} 

}
