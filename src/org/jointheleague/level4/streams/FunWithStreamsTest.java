package org.jointheleague.level4.streams;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class FunWithStreamsTest {
    private final Stream<Integer> testEmpty = Stream.empty();
    private final Stream<Integer> testNumbers = Stream.of(1, 2, 3, 4, 10, 12);
    
    private static <T> List<T> list(Stream<T> input) {
        return input.collect(Collectors.toList());
    }
    
    @Test
    public void testPrint() {
        System.out.println("\nTesting print with 1, 2, 3, 4, 10, 12:");
        FunWithStreams.print(testNumbers);
    }

    @Test
    public void testParallelPrint() {
        System.out.println("\nTesting parallel print with 1, 2, 3, 4, 10, 12:");
        FunWithStreams.parallelPrint(testNumbers);
        System.out.println("Was this the result you expected? Why?");
    }

    @Test
    public void testConvertToString() {
        assertEquals(
            Arrays.asList(new String[] {"1", "2", "3", "4", "10", "12"}),
            list(FunWithStreams.convertToString(testNumbers))
        );
        assertEquals(
            new ArrayList<String>(),
            list(FunWithStreams.convertToString(testEmpty))
        );
    }

    @Test
    public void testSum() {
        assertEquals(
            Optional.of(32),
            FunWithStreams.sum(testNumbers)
        );
        assertEquals(
            Optional.empty(),
            FunWithStreams.sum(testEmpty)
        );
    }

    @Test
    public void testSumFormula() {
        System.out.println("\nTesting sum formula with 1, 2, 3, 4, 10, 12 (not parallel):");
        FunWithStreams.sumFormula(testNumbers);
    }

    @Test
    public void testSumFormulaParallel() {
        System.out.println("\nTesting sum formula with 1, 2, 3, 4, 10, 12 (parallel):");
        FunWithStreams.sumFormula(testNumbers.parallel());
        System.out.println("Was this the result you expected? Why?");
    }

    @Test
    public void testEvens() {
        assertEquals(
            Arrays.asList(new Integer[] {2, 4, 10, 12}),
            list(FunWithStreams.evens(testNumbers.parallel()))
        );
        assertEquals(
            new ArrayList<String>(),
            list(FunWithStreams.evens(testEmpty))
        );
    }

    @Test
    public void testDeductFromFirst() {
        assertEquals(
            Optional.of(-30),
            FunWithStreams.deductFromFirst(testNumbers)
        );
        assertEquals(
            Optional.empty(),
            FunWithStreams.deductFromFirst(testEmpty)
        );
    }
    
    @Test
    public void testDeductFromFirstParallel() {
        assertEquals(
            Optional.of(-30),
            FunWithStreams.deductFromFirst(testNumbers.parallel())
        );
    }

}
