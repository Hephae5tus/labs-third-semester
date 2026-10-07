package tasks;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task19Test {

    @Test
    void countsSaddlePointsAndSortsRows() {
        int[][] matrix = {
                {4, 2, 2, 9},
                {8, 5, 5, 6},
                {1, 0, 0, 3}
        };

        int count = parse(matrix);

        assertEquals(2, count);
        assertArrayEquals(new int[][]{
                {8, 5, 5, 6},
                {4, 2, 2, 9},
                {1, 0, 0, 3}
        }, matrix);
    }

    @Test
    void sortsRowsWithZeroSaddlePointsBetweenThem() {
        int[][] matrix = {
                {0, 0, 9, 9},
                {1, 1, 8, 0},
                {4, 4, 5, 5}
        };

        int count = parse(matrix);

        assertEquals(2, count);
        assertArrayEquals(new int[][]{
                {4, 4, 5, 5},
                {0, 0, 9, 9},
                {1, 1, 8, 0}
        }, matrix);
    }

    @Test
    void keepsOrderOfRowsWithEqualSaddleCounts() {
        int[][] matrix = {
                {1, 5},
                {1, 4}
        };

        int count = parse(matrix);

        assertEquals(2, count);
        assertArrayEquals(new int[][]{
                {1, 5},
                {1, 4}
        }, matrix);
    }

    @Test
    void returnsZeroWhenMatrixHasNoSaddlePoints() {
        int[][] matrix = {
                {2, 1},
                {0, 3}
        };

        int count = parse(matrix);

        assertEquals(0, count);
        assertArrayEquals(new int[][]{
                {2, 1},
                {0, 3}
        }, matrix);
    }

    @Test
    void treatsSingleElementAsSaddlePoint() {
        int[][] matrix = {{5}};

        int count = parse(matrix);

        assertEquals(1, count);
        assertArrayEquals(new int[][]{{5}}, matrix);
    }

    @Test
    void countsNegativeSaddlePoint() {
        int[][] matrix = {
                {-1, -5},
                {-3, -4}
        };

        int count = parse(matrix);

        assertEquals(1, count);
        assertArrayEquals(new int[][]{
                {-3, -4},
                {-1, -5}
        }, matrix);
    }

    @Test
    void returnsZeroForEmptyMatrix() {
        assertEquals(0, Task19.parse(new int[0][3], 0, 3));
        int[][] noColumns = new int[2][0];
        assertEquals(0, Task19.parse(noColumns, 2, 0));
        assertArrayEquals(new int[2][0], noColumns);
    }

    @Test
    void generatesValuesInsideGivenRange() {
        int[][] matrix = new int[30][30];
        Task19.generateMatrix(matrix, 30, 30, -2, 5);

        assertTrue(Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .allMatch(value -> value >= -2 && value < 5));
    }

    private static int parse(int[][] matrix) {
        return Task19.parse(matrix, matrix.length, matrix[0].length);
    }
}
