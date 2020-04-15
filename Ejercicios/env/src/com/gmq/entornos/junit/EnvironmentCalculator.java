package com.gmq.entornos.junit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EnvironmentCalculator implements Calculator {
	
	
    @Override
    public BigDecimal sum(BigDecimal firstSummand, BigDecimal secondSummand) {
    	
        return firstSummand.add(secondSummand);
    }

    @Override
    public BigDecimal substract(BigDecimal minuend, BigDecimal subtrahend) {
    	
        return minuend.subtract(subtrahend);
    }

    @Override
    public BigDecimal multiply(BigDecimal multiplicand, BigDecimal multiplier) {
    	
        return multiplicand.multiply(multiplier);
    }

    @Override
    public BigDecimal divide(BigDecimal dividend, BigDecimal divisor) {
    	
        try {
            if(BigDecimal.ZERO == divisor) {
                return BigDecimal.valueOf(-1);
            }
            return dividend.divide(divisor);
        } catch(Exception e) {
        	return BigDecimal.valueOf(-1);
        }
    }

    @Override
    public BigDecimal mcd(BigDecimal first, BigDecimal second) {
        return null;
    }

    @Override
    public BigDecimal mcm(BigDecimal first, BigDecimal second) {
        return null;
    }
}
