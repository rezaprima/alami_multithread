package business;

import bank.Entry;

public interface Calculator {

	void execute(Entry entry, int threadId);

}