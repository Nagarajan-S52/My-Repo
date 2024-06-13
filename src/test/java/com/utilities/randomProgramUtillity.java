package com.utilities;

import java.util.Random;

/**
 * Utility class to generate random numbers.
 */
public class randomProgramUtillity {
    /**
     * Generates a random integer within the specified range.
     *
     * @param size The upper bound of the range (exclusive).
     * @return A random integer between 0 (inclusive) and the specified size (exclusive).
     * @throws IllegalArgumentException If the size is not positive.
     */
    public int randamValue(int size) {
        // Check if size is positive
        if (size <= 0) {
            throw new IllegalArgumentException("size must be positive");
        }
        // Create a Random object
        Random random = new Random();

        // Generate a random number within the specified range
        int randomNumber = random.nextInt(size);

        // Return the generated random number
        return randomNumber;
    }


}
