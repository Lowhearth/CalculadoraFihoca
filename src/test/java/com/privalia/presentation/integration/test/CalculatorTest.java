package com.privalia.presentation.integration.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.privalia.presentation.Calculator;
import com.privalia.presentation.ICalculator;

public class CalculatorTest {

	@Test
	public void testAdd() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.add(3, 2) == 5);
	}

	@Test
	public void testSubstract() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.substract(3, 2) == 1);
	}

	@Test
	public void testMultiply() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.multiply(3, 2) == 6);
	}

	@Test
	public void testDivide() {
		ICalculator calculator = new Calculator();
		assertTrue(calculator.divide(4, 2) == 2);
	}

}
