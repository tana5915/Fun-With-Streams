package org.jointheleague.level4.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Maths {
    Stream<Integer> positiveIntegers() {
        return Stream.iterate(1, last -> last + 1);
    }
    
    
    
    // TODO Apply the appropriate transformation to nonNegativeIntegers to
    // obtain an IntStream of non-negative even numbers.
    public Stream<Integer> positiveEvenIntegers() {
        throw new UnsupportedOperationException();
//      return positiveIntegers()...
    }
    
    
    
    // TODO Implement factorials by applying the appropriate transformation to 
    // the nonNegativeIntegers Stream.
    public Optional<Integer> factorialWithStreams(Integer n) {
        throw new UnsupportedOperationException();
//        return positiveIntegers()...
    }
    
    // TODO Print the factorial formula, showing the order in which the computer
    // applies the multiplications.
    // For instance, factorialFormula(3) should return:
    // (((0 * 1) * 2) * 3)
    // TODO Parallelize the stream, and run. What do you expect to see?
    public Optional<String> factorialFormula(Integer n) {
        throw new UnsupportedOperationException();
//      return positiveIntegers()...
    }
    
    
    // Implement factorials again, but this time recursively, using Memoization
    // https://en.wikipedia.org/wiki/Memoization
    Map<Integer,Integer> factorialMemo = new HashMap<>();
    {
        factorialMemo.put(0, 1);
    }
    public Optional<Integer> factorialWithMemoization(Integer n) {
        if (n < 0)
            return Optional.empty();
        else
            return Optional.of(
                factorialMemo.computeIfAbsent(
                    n,
                    // TODO
                    // Write a Lambda that would efficiently calculate factorial.
                    // Efficiently in this case means it does not repeat any factorial
                    // calculation that had been done
                    x -> null
                )
            );
    }
    
    
    
    public Optional<Integer> factorial(Integer n) {
        return factorialWithMemoization(n);
    }
    
    
    
    // Extra credit
    public Optional<Double> approximateE(final Integer nMax) {
        throw new UnsupportedOperationException();
        // TODO
        // Approximate Euler's number using the formula:
        // 1/0! + 1/1! + 1/2! + ... + 1/nMax!
        // As described here:
        // https://en.wikipedia.org/wiki/E_(mathematical_constant)
        //
        // Replace the Optional.empty() with the appropriate transformation to
        // the nonNegativeIntegers() Stream.
        //return nonNegativeIntegers()...
    }
}
