package bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import business.CalculateAverageBalance;
import business.CalculateFreeTransfer;


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
		for (Entry entry : entries) {
			CalculateAverageBalance.execute(entry);
			CalculateFreeTransfer.execute(entry);
		}
		writeCsv(entries);
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
