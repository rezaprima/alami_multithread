package bank;

import com.opencsv.bean.CsvBindByName;

public class Entry {
	@CsvBindByName(column="id")
	private int id;
	
	@CsvBindByName(column="Nama")
	private String nama;
	
	@CsvBindByName(column="Age")
	private int age;
	
	@CsvBindByName(column="Balanced")
	private int balanced;
	
	@CsvBindByName(column="Previous Balanced")
	private int previousBalanced;
	
	@CsvBindByName(column="Average Balanced")
	private int averageBalanced;
	
	@CsvBindByName(column="Free Transfer")
	private int freeTransfer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBalanced() {
		return balanced;
	}

	public void setBalanced(int balanced) {
		this.balanced = balanced;
	}

	public int getPreviousBalanced() {
		return previousBalanced;
	}

	public void setPreviousBalanced(int previousBalanced) {
		this.previousBalanced = previousBalanced;
	}

	public int getAverageBalanced() {
		return averageBalanced;
	}

	public void setAverageBalanced(int averageBalanced) {
		this.averageBalanced = averageBalanced;
	}

	public int getFreeTransfer() {
		return freeTransfer;
	}

	public void setFreeTransfer(int freeTransfer) {
		this.freeTransfer = freeTransfer;
	}

	@Override
	public String toString() {
		return "Entry [id=" + id + ", nama=" + nama + ", age=" + age + ", balanced=" + balanced + ", previousBalanced="
				+ previousBalanced + ", averageBalanced=" + averageBalanced + ", freeTransfer=" + freeTransfer + "]";
	}
	
}
