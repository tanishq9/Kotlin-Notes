import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A", "B", "C");

		List<?> collect = list.stream()
				.map(String::toLowerCase)
				// flatmap: combination of a map and a flat operation i.e, it first applies map function and than flattens the result.
				.flatMap(
						element -> Stream.of(
								new Random().nextInt(10),
								new Random().nextLong(),
								"Hello"
						)
				)
				.collect(Collectors.toList());

		System.out.println(collect);
	}
}
