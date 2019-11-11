package com.sudoku.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * @author gauridengare Utilities to check weather given sudoku solution is
 *         valid or not
 */
public class SudokuValidator {

	final int subArraySize = 3;

	/**
	 * Checks if given row denoted by rowNumber has duplicates. Preconditions:
	 * rowNumber < number of rows in grid
	 * 
	 * @param grid      the 2D array to check
	 * @param rowNumber the number of the row to be checked
	 * @return true if the row contains no duplicate values, false otherwise
	 */
	public boolean checkRow(int[][] grid, int rowNumber) {
		Boolean valid = Arrays.stream(grid[rowNumber]).boxed()
				.collect(Collectors.groupingBy(Integer::intValue, Collectors.counting())).values().stream().distinct()
				.count() < 2;

		if (!valid)
			return false;

		return true;
	}

	/**
	 * Checks if given row denoted by colNumber has duplicates. Preconditions:
	 * colNumber < number of columns in grid
	 * 
	 * @param grid      the 2D array to check
	 * @param colNumber the number of the rcolumn to be checked
	 * @return true if the column contains no duplicate values, false otherwise
	 */
	public boolean checkColumn(int[][] grid, int colNumber) {
		List<Integer> currCol = new ArrayList<Integer>();
		for (int row = 0; row < grid.length; row++) {
			currCol.add(grid[row][colNumber]);
		}
		Boolean valid = currCol.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
				.values().stream().distinct().count() < 2;
		if (!valid)
			return false;

		return true;

	}

	/**
	 * Checks whether a subarray contains duplicate values. Returns true if the
	 * subarray of grid
	 * 
	 * @param grid         the 2D array to check
	 * @param inRow      topmost row of the subarray
	 * @param inCol      leftmost column of the subarrays
	 * @return true if the subarray contains no duplicates, false otherwise
	 */
	public boolean checkSubArray(int[][] grid, int inRow, int inCol) {

		List<Integer> numbers = new ArrayList<Integer>();
		for (int row = inRow; row < (inRow + subArraySize); row++) {
			for (int col = inCol; col < (inCol + subArraySize); col++) {

				numbers.add(grid[row][col]);
			}
		}
		Boolean valid = numbers.stream().collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()))
				.values().stream().distinct().count() < 2;

		if (!valid)
			return false;

		return true;
	}

	/**
	 * Check whether the given grid is a valid Sudoku solution.
	 * 
	 * @param grid         the 2D array to check
	 * @param subArraySize the size of subarray(3*3)
	 * @return true if the given array is a valid solution, false otherwise
	 */
	public boolean checkGridValidity(int[][] grid) {
		boolean validRow = true;
		boolean validCol = true;
		boolean validSubArray = true;

		// check if a row has any duplicate values
		for (int row = 0; row < grid.length; ++row) {
			if (!checkRow(grid, row)) {
				validRow = false;
			}
		}

		// check if a column has any duplicate values
		for (int col = 0; col < grid.length; ++col) {
			if (!checkColumn(grid, col)) {
				validCol = false;
			}
		}

		// Check if subArray(3*3) has duplicate values
		for (int row = 0; row < grid.length; row += subArraySize) {
			for (int col = 0; col < grid.length; col += subArraySize) {
				if (!checkSubArray(grid, row, col)) {
					validSubArray = false;
				}
			}
		}

		// Check if all the criteria for valid solution returns true
		if (validRow && validCol && validSubArray) {
			return true;
		}

		return false;
	}
}
