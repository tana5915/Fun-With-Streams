package org.jointheleague.level4.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class FunWithStreams {
	/**
	 * Prints out the numbers in the stream to the console, one number per line.
	 * 
	 * @param numbers
	 *            the stream of numbers to print.
	 */
	public static void print(Stream<Integer> numbers) {
		// TODO hint: use forEach
		numbers.forEach(System.out::println);
	}

	/**
	 * Prints out the numbers in the stream to the console, one number per line,
	 * but in parallel.
	 * 
	 * @param numbers
	 *            the stream of numbers to print.
	 */
	public static void parallelPrint(Stream<Integer> numbers) {
		// TODO hint: use forEach
		numbers.parallel().forEach(System.out::println);
	}

	/**
	 * Converts the numbers in a stream to strings. 1 -> "1", 2 -> "2" etc. A
	 * Stream of 1, 2, 3 should return a Stream of "1", "2" "3".
	 * 
	 * @param numbers
	 *            the stream of numbers to convert.
	 */
	public static Stream<String> convertToString(Stream<Integer> numbers) {
		return numbers.map(n -> n.toString());
	}

	/**
	 * Sums up all the numbers in a stream. A Stream of 1, 2, 3 should return 1
	 * + 2 + 3, or 6.
	 * 
	 * @param numbers
	 *            the stream of numbers to sum up.
	 */
	public static Optional<Integer> sum(Stream<Integer> numbers) {
		return numbers.reduce((x, y) -> x + y);
	}

	/**
	 * Prints out the formula for summing up the numbers in a stream. A Stream
	 * of 1, 2 should print out: "(1 + 2)" A Stream of 1, 2, 3 should print out:
	 * "((1 + 2) + 3)"
	 * 
	 * @param numbers
	 *            the stream of numbers to sum up.
	 */
	public static void sumFormula(Stream<Integer> numbers) {
		// TODO hint: use map and reduce, and Optional#ifPresent
		numbers.map(n -> n.toString()).reduce((x, y) -> "(" + x + "+" + y + ")").ifPresent(System.out::println);

	}

	/**
	 * Filter out odd numbers from the stream, returning only even numbers. A
	 * Stream of 1, 2, 3, 4 sholud return a Stream of 2, 4.
	 * 
	 * @param numbers
	 *            the stream of numbers to filter.
	 */
	public static Stream<Integer> evens(Stream<Integer> numbers) {
		// TODO hint: use filter
		return numbers.filter(x -> x % 2 == 0);
	}

	// Extra credit
	/**
	 * Deducts the second number in the stream and up from the first number. A
	 * Stream of 1, 2, 3 should return 1 - 2 - 3, or -4.
	 * 
	 * This method should work even on parallel Streams.
	 * 
	 * @param numbers
	 *            the stream of numbers calculate.
	 */
	public static Optional<Integer> deductFromFirst(Stream<Integer> numbers) {
		// TODO
		throw new UnsupportedOperationException("pending");
	}
}
