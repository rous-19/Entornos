package com.gmq.entornos.refactoring.exercice;

/**
 * 
 * Dada la siguiente clase:
 * 
 * 1.- Lee el código y crea los tests de junit necesarios 2.- Realiza las
 * correcciones que veas necesarias para mejorar la calidad del código.
 * 
 * @author Raul.Camarero
 *
 */
public class SolEvaluate {

	private static final int DEFAULT_EVAL_SIZE = 10;

	private String id; // private fields

	private String name;

	private String[] evaluations; // array with type


	public SolEvaluate(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public SolEvaluate(String id, String name, String[] evaluations) { // orden de constructores (x1)
		this.id = id;
		this.name = name;
		this.evaluations = evaluations;
	}

	public String evaluatePupil(int value) { // nombre del método, else if (x1)

		String annotation = null;

		if (isNotAcceptedValue(value)) {

			annotation = "Error";
			
		} else if (isFail(value)) {

			annotation = Qualification.FAIL.getSpanishName(); // notas to Enum (x1)
			
		} else if (isFair(value)) {

			annotation = Qualification.FAIR.getSpanishName(); // castellano, inglés y no mayúsculas -> enum (x2)
		
		} else if (isGood(value)) {

			annotation = Qualification.GOOD.getSpanishName(); // castellano, inglés y no mayúsculas -> enum (x2)
		
		} else if (isNotable(value)) {
		
			annotation = Qualification.NOTABLE.getSpanishName();
		
		} else if (isRemarkable(value)) {
			
			annotation = Qualification.REMARKABLE.getSpanishName();
				
		} else if (isHonours(value)) {

			annotation = Qualification.HONOURS.getSpanishName();
		}
		
		if(evaluations == null) {
			evaluations = new String[DEFAULT_EVAL_SIZE];
		}
		
		if(evaluations != null) {
			for (int i = 0; i < evaluations.length; i++) {
				if (evaluations[i] == null) {
					evaluations[i] = annotation;
					System.out.println("Añadir al alumno " + name + "(" + id + ") la nota " + evaluations[i].toString()); // null																								// cuand																								// (x1)
					break;
				}
			}	
		}
		
		return annotation;
	}

	private boolean isGood(int value) {
		
		return value > Qualification.FAIR.getMinValue() && 
				value <= Qualification.FAIR.getMinValue();
	}

	private boolean isNotable(int value) {
		
		return value >= Qualification.NOTABLE.getMinValue() &&
				value < Qualification.REMARKABLE.getMinValue();
	}

	private boolean isRemarkable(int value) {
		
		return value >= Qualification.REMARKABLE.getMinValue() &&
				value < Qualification.HONOURS.getMinValue();
	}


	private boolean isHonours(int value) {
		return value == Qualification.HONOURS.getMinValue();
	}

	private boolean isNotAcceptedValue(int value) {
		
		return value > Qualification.HONOURS.getMinValue();
	}

	private boolean isFail(int value) {
		return value < Qualification.FAIR.getMinValue();
	}

	private boolean isFair(int value) {
		
		return value >= Qualification.FAIR.getMinValue() 
				&& value < Qualification.GOOD.getMinValue();
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String[] getEvaluations() {
		return evaluations;
	}
}
