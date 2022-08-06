package bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import business.CalculateAdditionalBalance;
import business.CalculateAverageBalance;
import business.CalculateBonusBalance;
import business.CalculateFreeTransfer;
import business.Calculator;
import repo.Csv;
import thread.MyThread;


public class Main {

	public static void main(String[] args) throws IOException {
		Csv repo = new Csv("before_eod.csv", "after_eod.csv");
		List<Entry> entries = repo.readCsv();

		int thread1Count = 3;		
		Calculator averageBalanceCalculator = new CalculateAverageBalance();
		processAverageBalance(entries, thread1Count, averageBalanceCalculator);
		
		int thread2aCount = 4;
		Calculator freeTransferCalculator = new CalculateFreeTransfer();
		processAverageBalance(entries, thread2aCount, freeTransferCalculator);
		
		int thread2bCount = 4;
		Calculator additionalBalanceCalculator = new CalculateAdditionalBalance();
		processAverageBalance(entries, thread2bCount, additionalBalanceCalculator);
		
		int thread3Count = 8;
		Calculator bonusBalanceCalculator = new CalculateBonusBalance();
		processAverageBalance(entries, thread3Count, bonusBalanceCalculator);
		
		repo.writeCsv(entries);
	}

	private static void processAverageBalance(List<Entry> entries, int threadCount, Calculator calculator) {
		Map<Long, Integer> threadMap1 = new HashMap<Long, Integer>();		
		for(int i=0; i<threadCount; i++) {
			Thread t = new MyThread(entries, threadMap1, threadCount, calculator);
			threadMap1.put(t.getId(), Integer.valueOf(i));
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				
			}
		}
	}
	
}
