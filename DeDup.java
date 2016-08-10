import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Take care of removing any duplicate entries in the array. Include a default
 * array to be used or can be used any new array in production.
 *
 * Reference to Question 5 in problem:
 * The positive of using set over other two will the time complexity for that
 * will be only O(n). We can do parallel stream for larger data set as a negative
 * point we not streaming that fast in this solution.
 *
 * @author ryadav003c
 *
 */
public class DeDup {
	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	public static void main(final String[] args) {
		final DeDup dedup = new DeDup();
		System.out.println("Removes all duplicate using array: ");
		for (final Integer dupInteger : dedup.randomIntegers) {
			System.out.print(dupInteger + ",");
		}
		Integer[] noDupIntegers = dedup.deDupUsingArray(dedup.randomIntegers);
		System.out.println("\nRemoves all duplicate using array: ");
		for (final Integer noDupInteger : noDupIntegers) {
			System.out.print(noDupInteger + ",");
		}
		System.out.println("\nRemoves all duplicate using linkedHashSet:");
		noDupIntegers = dedup.deDupUsingSet(dedup.randomIntegers);
		for (final Integer noDupInteger : noDupIntegers) {
			System.out.print(noDupInteger + ",");
		}
		System.out.println("\nRemoves all duplicate using Streams");
		noDupIntegers = dedup.deDupUsingStreams(dedup.randomIntegers);
		for (final Integer noDupInteger : noDupIntegers) {
			System.out.print(noDupInteger + ",");
		}
	}

	/**
	 * Removes all duplicate elements using linkedHashSet.
	 *
	 * @param dupInteger
	 *            Array from which duplicate elements are to be removed.
	 * @return Integer array of unique elements.
	 */
	public Integer[] deDupUsingSet(final int[] dupIntegers) {
		final Set<Integer> setWithoutDuplicates = new LinkedHashSet<>();
		for (final Integer dupInteger : dupIntegers) {
			setWithoutDuplicates.add(dupInteger);
		}
		return setWithoutDuplicates.toArray(new Integer[setWithoutDuplicates.size()]);
	}

	/**
	 * Removes all duplicate elements using Streams with List.
	 *
	 * @param dupInteger
	 *            Array from which duplicate elements are to be removed.
	 * @return Integer array of unique elements.
	 */
	public Integer[] deDupUsingStreams(final int[] dupInteger) {
		final List<Integer> listWithoutDuplicates = Arrays.stream(dupInteger).distinct().boxed()
				.collect(Collectors.toList());
		return listWithoutDuplicates.toArray(new Integer[listWithoutDuplicates.size()]);
	}

	/**
	 * Removes all duplicate elements using simple looping over array.
	 *
	 * @param dupInteger
	 *            Array from which duplicate elements are to be removed.
	 * @return Integer array of unique elements.
	 */
	public Integer[] deDupUsingArray(final int[] dupInteger) {
		int size = dupInteger.length;
		final boolean[] flag = new boolean[size];
		for (int i = 0; i < dupInteger.length; i++) {
			for (int j = i + 1; j < dupInteger.length; j++) {
				if (dupInteger[i] == dupInteger[j]) {
					flag[j] = true;
					size--;
					break;
				}
			}
		}

		final Integer noDupIntegers[] = new Integer[size];
		int j = 0;
		for (int i = 0; i < size; i++) {
			while (flag[j]) {
				j++;
			}
			noDupIntegers[i] = dupInteger[j];
			j++;
		}

		return noDupIntegers;
	}
}
