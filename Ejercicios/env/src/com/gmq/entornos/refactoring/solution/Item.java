package com.gmq.entornos.refactoring.solution;

public class Item {

	//MAKE FIELDS PRIVATE
	private int quality; 
	
	private String name;

	private int sold;
	
	//CONTRUCTOR WITH ALL ARGS BECAUSE ALL ITEMS ARE CREATED WITH THE THREE FIELDS
	public Item(String name, int quality,  int sold) {
		this.quality = quality;
		this.name = name;
		this.sold = sold;
	}

	
	//GENERATE GETTERS Y SETTERS
	public int getQuality() {
		return quality;
	}

	public String getItemName() {
		return name;
	}

	public int getSold() {
		return sold;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSold(int sold) {
		this.sold = sold;
	}
	
	

}
