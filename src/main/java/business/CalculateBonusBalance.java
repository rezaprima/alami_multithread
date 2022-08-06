package business;

import bank.Entry;

public class CalculateBonusBalance implements Calculator {
	public void execute(Entry entry, int threadId) {
		if(entry.getId()<=100) {
			entry.setBalanced(entry.getBalanced() + 10);
		}
		entry.setNo3ThreadNo(threadId);
	}
}
