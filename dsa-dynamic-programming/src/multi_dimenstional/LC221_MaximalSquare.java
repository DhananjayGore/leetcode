/**
 * 
 */
package multi_dimenstional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dhananjay
 * @link : https://leetcode.com/problems/maximal-square/
 * @level : medium
 */
public class LC221_MaximalSquare {

	int rows, columns;

	public int maximalSquare(char[][] matrix) {
		rows = matrix.length;
		columns = matrix[0].length;

		Map<String, Integer> dp = new HashMap<>();
		int area = 0;
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				if (matrix[r][c] == '1') {
					int side = maximalSquare(matrix, r, c, dp);
					area = Math.max(area, side * side);
				}
			}
		}
		return area;
	}

	int maximalSquare(char[][] matrix, int currRow, int currCol, Map<String, Integer> dp) {

		// return when element at currRow & currCol is '0' , currRow /currCol out of
		// bound
		if (currRow < 0 || currRow >= rows || currCol < 0 || currCol >= columns || matrix[currRow][currCol] == '0') {
			return 0;
		}

		String key = currRow + "_" + currCol;
		if (dp.containsKey(key))
			return dp.get(key);

		// down square search
		int down = 1 + maximalSquare(matrix, currRow + 1, currCol, dp);
		// right side
		int right = 1 + maximalSquare(matrix, currRow, currCol + 1, dp);
		// right diagonal search
		int rightDiagonal = 1 + maximalSquare(matrix, currRow + 1, currCol + 1, dp);

		// calculate which ever is min as square is X*X
		int area = Math.min(rightDiagonal, Math.min(down, right));
		// memorize
		dp.put(key, area);
		// return element we stored at key
		return dp.get(key);
	}
}
