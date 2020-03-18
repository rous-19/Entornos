package com.gmq.entornos.refactoring.exercice;

/**
 * 
 * Dada la siguiente clase:
 * 
 * 	1.- Lee el código y crea los tests de junit necesarios
 * 		1.1.- Sigue las indicaciones de la asignatura buscando la máxima cobertura posible
 * 
 * 	2.- Realiza las correcciones que veas necesarias para mejorar la calidad del código.
 *  	2.1.- Añade un comentario en el código explicando el cambio que has realizado
 *  
 * @author Raul.Camarero
 *
 */
public class Evaluate {

	String id; 
	
	String name;
	
	String evaluations[];
	
	public Evaluate(String id, String name, String[] evaluations) { 
		this.id = id;
		this.name = name;
		this.evaluations = evaluations;
	}
	
	public Evaluate(String id, String name) {
		this.id = id;
		this.name = name;	
	}
	
	public void evaluate_pupil(int value) {  
		String annotation = null;
		if(value > 10) {
			throw new RuntimeException("La nota no es válida. Nadie saca más de 10!!!");
		}
		if(value < 5) {
			annotation = "SUSPENSO"; 
		} 
		else
		{
			if (value > 5 && value < 6) 
			{
				annotation = "GOOD"; 
			} 
			else
			{
				if( value < 10 ) {
					if(value > 9) {
						annotation = "SOBRESALIENTE";
					}
					else if (value > 8) {
						annotation = "notable";
					}
				}
			}
		}
		
		for (int i = 0; i < evaluations.length; i++) 
		{
			if(evaluations[i] == null) {
				evaluations[i]= annotation;
				System.out.println("Añadir al alumno "+name+"("+id+") la nota "+evaluations[i].toString()); 
				break;
			}
		}
	}
}
