package com.gmq.entornos.refactoring.exercice;

public enum Qualification {

	HONOURS("MATRÍCULA DE HONOR", "HONOUR", 10),
	REMARKABLE("SOBRESALIENTE", "REMARKABLE", 9),
	NOTABLE("NOTABLE","NOTABLE", 7),
	GOOD("BIEN", "GOOD", 6),
	FAIR("APROBADO", "FAIR", 5),
	FAIL("SUSPENSO", "FAIL",0);
	
	
	private String spanishName;
	
	private String englishName;
	
	private int minValue;
		
	Qualification(String spanishName, String englishName, int minValue) {
		this.spanishName = spanishName;
		this.englishName = englishName;
		this.minValue = minValue;
	}
	
	public String getSpanishName() {
		
		return this.spanishName;
	}
	
	public String getEnglishName() {
		
		return this.englishName;
	}

	public int getMinValue() {
		
		return minValue;
	}
}
