package repo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import bank.Entry;

public class Csv {
	private String sourceCsvFilename;
	private String targetCsvFilename;
	
	public Csv(String sourceCsvFilename, String targetCsvFilename) {
		super();
		this.sourceCsvFilename = sourceCsvFilename;
		this.targetCsvFilename = targetCsvFilename;
	}
	
	public List<Entry> readCsv() throws FileNotFoundException {
		Reader reader = new BufferedReader(new FileReader(this.sourceCsvFilename));
		CsvToBean<Entry> csvReader = new CsvToBeanBuilder<Entry>(reader).
				withType(Entry.class).
				withSeparator(';').
				withIgnoreLeadingWhiteSpace(true).
				build();
		return csvReader.parse();
	}

	public void writeCsv(List<Entry> entries) throws IOException {
		FileWriter writer = new FileWriter(this.targetCsvFilename);
		writer.write("id;Nama;Age;Balanced;No 2b Thread-No;No 3 Thread-No;Previous Balanced;Average Balanced;No 1 Thread-No;Free Transfer;No 2a Thread-No");
		for (Entry entry : entries) {
			String line = format(entry);
			writer.write(System.lineSeparator()+line);
		}
		writer.close();
	}
	
	private String format(Entry entry) {
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
