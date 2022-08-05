package business;

import bank.Entry;

public class CalculateFreeTransfer {
	public static final void execute(Entry entry) {
		if (entry.getBalanced() >= 100 && entry.getBalanced() <= 150) {
			entry.setFreeTransfer(entry.getFreeTransfer() + 5);
		}
	} 

}
