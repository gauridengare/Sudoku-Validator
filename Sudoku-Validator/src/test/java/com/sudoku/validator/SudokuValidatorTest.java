package com.sudoku.validator;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



class SudokuValidatorTest {

	public static int[][] valid_grid = { 
			{ 5, 3, 4, 6, 7, 8, 9, 1, 2 }, 
			{ 6, 7, 2, 1, 9, 5, 3, 4, 8 },
			{ 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, 
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 2, 8, 4 }, 
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, 
            { 3, 4, 5, 2, 8, 6, 1, 7, 9 } };
	
	
	public static int[][] invalid_grid = {
			{ 5, 3, 4, 6, 6, 8, 9, 1, 2 }, 
			{ 6, 7, 2, 1, 9, 5, 3, 4, 8 },
			{ 1, 9, 8, 3, 4, 2, 5, 6, 7 },
            { 8, 5, 9, 7, 6, 1, 4, 2, 3 }, 
            { 4, 2, 6, 8, 5, 3, 7, 9, 1 }, 
            { 7, 1, 3, 9, 2, 4, 8, 5, 6 },
            { 9, 6, 1, 5, 3, 7, 3, 8, 4 }, 
            { 2, 8, 7, 4, 1, 9, 6, 3, 5 }, 
            { 3, 4, 8, 2, 8, 6, 1, 7, 9 } };

	private static SudokuValidator sv;

	@BeforeAll
	public static void init() {
		sv = new SudokuValidator();
	}

	@Test
	void checkGridValidity_ValidGrid_ReturnTrue() {
		boolean actual = sv.checkGridValidity(valid_grid);
		assertEquals(true, actual);
	}

	@Test
	void checkGridInvalidity_InvalidGrid_ReturnFalse() {
		boolean actual = sv.checkGridValidity(invalid_grid);
		assertEquals(false, actual);
	}
	
}
