package business;

import bank.Entry;

public class CalculateAdditionalBalance implements Calculator {
	public final void execute(Entry entry, int threadId) {
		if(entry.getBalanced()>150) {
			entry.setBalanced(entry.getBalanced() + 25);
		}
		entry.setNo2bThreadNo(threadId);
	}
}
