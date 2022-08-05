package business;

import bank.Entry;

public class CalculateBonusBalance {
	public static final void execute(Entry entry) {
		if(entry.getId()<=100) {
			entry.setBalanced(entry.getBalanced() + 10);
		}
	}
}
