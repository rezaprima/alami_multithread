package business;

import bank.Entry;

public class CalculateAdditionalBalance {
	public static final void execute(Entry entry) {
		if(entry.getBalanced()>150) {
			entry.setBalanced(entry.getBalanced() + 25);
		}
	}
}
