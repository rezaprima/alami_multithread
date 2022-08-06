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

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import business.CalculateAdditionalBalance;
import business.CalculateAverageBalance;
import business.CalculateBonusBalance;
import business.CalculateFreeTransfer;
import business.Calculator;
import thread.MyThread;


public class Main {

	public static List<Entry> readCsv() throws FileNotFoundException {
		Reader reader = new BufferedReader(new FileReader("before_eod.csv"));
		CsvToBean<Entry> csvReader = new CsvToBeanBuilder<Entry>(reader).
				withType(Entry.class).
				withSeparator(';').
				withIgnoreLeadingWhiteSpace(true).
				build();
		return csvReader.parse();
	}

	public static void main(String[] args) throws IOException {
		List<Entry> entries = readCsv();

		int thread1Count = 3;		
		Calculator averageBalanceCalculator = new CalculateAverageBalance();
		processAverageBalance(entries, thread1Count, averageBalanceCalculator);
		
		int thread2aCount = 4;
		Calculator freeTransferCalculator = new CalculateFreeTransfer();
		processAverageBalance(entries, thread2aCount, freeTransferCalculator);
		
		
		for (Entry entry : entries) {
//			CalculateAverageBalance.execute(entry);
//			CalculateFreeTransfer.execute(entry);
			CalculateAdditionalBalance.execute(entry);
			CalculateBonusBalance.execute(entry);
		}
		writeCsv(entries);
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
	
	private static void processAverageBalance() {
		
	}
	
	public static void writeCsv(List<Entry> entries) throws IOException {
		FileWriter writer = new FileWriter("after_eod1.csv");
		writer.write("id;Nama;Age;Balanced;No 2b Thread-No;No 3 Thread-No;Previous Balanced;Average Balanced;No 1 Thread-No;Free Transfer;No 2a Thread-No");
		for (Entry entry : entries) {
			String line = format(entry);
			writer.write(System.lineSeparator()+line);
		}
		writer.close();
	}
	
	private static String format(Entry entry) {
		return entry.getId()+";"+
			entry.getNama()+";"+
			entry.getAge()+";"+
			entry.getBalanced()+";"+
			entry.getNo2bThreadNo() +";"+
			entry.getNo3ThreadNo() + ";"+
			entry.getPreviousBalanced()+";"+
			entry.getAverageBalanced()+";"+
			entry.getNo1ThreadNo() + ";"+
			entry.getFreeTransfer()+";"+
			entry.getNo2aThreadNo();
	}
}
