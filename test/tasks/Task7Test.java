package tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class Task7Test {

    @ParameterizedTest
    @MethodSource("columnOrderCases")
    void sortsColumnsByDescendingNumberOfSameElements(int[][] matrix, int[][] expected) {
        assertArrayEquals(expected, sorted(matrix));
    }

    @Test
    void keepsColumnOrderWhenFrequenciesAreEqual() {
        int[][] matrix = {
                {1, 7, 2},
                {1, 7, 3},
                {4, 8, 5}
        };

        assertArrayEquals(matrix, sorted(matrix));
    }

    @Test
    void leavesSingleColumnUnchanged() {
        int[][] matrix = {
                {4},
                {4},
                {1}
        };

        assertArrayEquals(matrix, sorted(matrix));
    }

    @Test
    void acceptsEmptyMatrix() {
        assertDoesNotThrow(() -> Task7.parse(new int[0][3], 0, 3));
        assertDoesNotThrow(() -> Task7.parse(new int[2][0], 2, 0));
    }

    private static Stream<Arguments> columnOrderCases() {
        return Stream.of(
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {1, 4, 3},
                                {1, 5, 6},
                                {9, 7, 6}
                        },
                        new int[][]{
                                {1, 3, 2},
                                {1, 3, 4},
                                {1, 6, 5},
                                {9, 6, 7}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 5, 3, 7},
                                {2, 5, 3, 7},
                                {4, 5, 8, 7},
                                {6, 9, 8, 7}
                        },
                        new int[][]{
                                {7, 5, 3, 1},
                                {7, 5, 3, 2},
                                {7, 5, 8, 4},
                                {7, 9, 8, 6}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {5, 1},
                                {5, 1},
                                {6, 1},
                                {6, 2}
                        },
                        new int[][]{
                                {1, 5},
                                {1, 5},
                                {1, 6},
                                {2, 6}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {0, -1},
                                {0, -1},
                                {0, 2}
                        },
                        new int[][]{
                                {0, -1},
                                {0, -1},
                                {0, 2}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {-2, 4, 4},
                                {3, 5, 4},
                                {8, 6, 1}
                        },
                        new int[][]{
                                {4, -2, 4},
                                {4, 3, 5},
                                {1, 8, 6}
                        }
                )
        );
    }

    private static int[][] sorted(int[][] matrix) {
        int[][] copy = Arrays.stream(matrix).map(int[]::clone).toArray(int[][]::new);
        Task7.parse(copy, copy.length, copy[0].length);
        return copy;
    }
}
