package com.gmq.entornos.bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface CustomBigDecimal {

	/**
	 * Returns the max value between this BigDecimal and the argument val. 
	 * If val is greater than 100, then returns 100.
	 * 
	 * @param value 
	 * @return max value or 100
	 */
	BigDecimal max(BigDecimal value);
	
	/**
	 * Returns a BigDecimal whose value is (this / divisor), 
	 * 
	 * If divisor is lower or equal than 0, then returns 0.
	 * 
	 * @param divisor 
	 * @return max value or 100
	 */
	BigDecimal divide(BigDecimal divisor);

	
}
