package com.gmq.entornos.junit;

import static com.gmq.entornos.junit.PriceCalculator.Products.*;

public class PriceCalculator {

    public Integer sumProductsPrice(Integer[] productPrices) {
        Integer result = 0;
        for(Integer productPrice : productPrices) {
            result += productPrice;
        }
        return result;
    }

    public Double calculatePrice(String productName, Integer numberOfProducts)  throws CalculatePriceException {
        Products product;
        try{
        	product = Products.valueOf(productName);
        } catch(IllegalArgumentException e) {
        	throw new CalculatePriceException("Tu producto no es válido");
        }

        int tax = calculateTax(product);
        int co2Tax = 0;
        int trushTax = 0;

        if(isATransport(product)) {
            if(isAnAirTransport(product)) {
                co2Tax = 20;
            } else {
                co2Tax = 10;
            }
        }

        if(isAHome(product)) {
            trushTax = 3;
        }   
        
        double price = calculateTaxValue(tax, product.getUnitPrice()) + //precio con la tasa
        		calculateTaxValue(co2Tax, product.getUnitPrice())  + // se le suma precio con la tasa de contaminación co2
        		calculateTaxValue(trushTax, product.getUnitPrice()) + // se le suma precio con la tasa de basura
        		product.getUnitPrice(); 

        return price*numberOfProducts;
    }
    
    private int calculateTaxValue(int tax, int productUnitPrice) {
    	return (tax/100)*productUnitPrice;
    }

    private boolean isAHome(Products product) {
        return HOUSE == product ||  APPARTMENT == product;
    }

    private boolean isAnAirTransport(Products product) {
        return PLANE == product ||  HELICOPTER == product;
    }

    private boolean isAnEathTransport(Products product) {
        return CAR == product || TRUCK == product;
    }

    private boolean isATransport(Products product) {
        return isAnEathTransport(product) || isAnAirTransport(product);
    }

    private int calculateTax(Products product) {
        int tax;
        switch (product) {
            case CAR:
            case PLANE:
            case TRUCK:
            case HELICOPTER:
                tax = 21;
                break;
            case HOUSE:
            case APPARTMENT:
                tax = 10;
                break;
            case FOOD:
                tax = 4;
                break;
            default:
                return -1;
        }
        return tax;
    }

    enum Products {
        CAR("car", 15000),
        HOUSE("house", 350000),
        APPARTMENT("appartment", 200000),
        TRUCK("truck", 60000),
        FOOD("food", 50),
        PLANE("plane", 3500000),
        HELICOPTER("helicopter", 1400000);

        String name;

        int unitPrice;

        Products(String name, int unitPrice) {
            this.name = name;
            this.unitPrice = unitPrice;
        }

        String getName() {
            return this.name;
        }

        int getUnitPrice() {
            return this.unitPrice;
        }
    }
}
