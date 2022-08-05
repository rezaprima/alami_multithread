package business;

import bank.Entry;

public final class CalculateAverageBalance {
	public static final void execute(Entry entry) {
		entry.setAverageBalanced( (entry.getBalanced() + entry.getPreviousBalanced()) / 2 );
	}
}
