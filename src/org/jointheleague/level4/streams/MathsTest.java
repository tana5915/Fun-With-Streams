package org.jointheleague.level4.streams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Ignore;
import org.junit.Test;

public class MathsTest {
    final Maths instance = new Maths();
    final Maths funnyInstance = new Maths() {
        @Override Stream<Integer> positiveIntegers() {
            return Stream.of(1, 2, 1, 2, 1, 2, 1, 2, 1, 2);
        }
    };

    @Test
    public void testPositiveEvenIntegers() {
        assertEquals(
            Arrays.asList(2, 4, 6, 8, 10),
            instance.positiveEvenIntegers().
                limit(5).
                collect(Collectors.toList())
        );
        assertEquals(
            Arrays.asList(2, 2, 2, 2, 2),
            funnyInstance.positiveEvenIntegers().
                collect(Collectors.toList())
        );
    }

    @Test
    public void testFactorialWithStreams() {
        assertEquals(
            Optional.of(3628800),
            instance.factorialWithStreams(10)
        );
    }

    @Test
    public void testFactorialFormula() {
        // No assertions, just prints out the formula.
        // Try adding parallelism and see what happens.
        System.out.println(instance.factorialFormula(10));
    }

    @Test
    public void testFactorialWithMemoization() {
        assertEquals(
            Optional.of(3628800),
            instance.factorialWithMemoization(10)
        );
    }

    @Ignore
    public void testApproximateE() {
        final Optional<Double> actualApproxEOpt = instance.approximateE(18);
        
        assertTrue(actualApproxEOpt.isPresent());
        actualApproxEOpt.ifPresent(
            actualApproxE -> assertEquals(Math.E, actualApproxE, 0.0001)
        );
    }

}
