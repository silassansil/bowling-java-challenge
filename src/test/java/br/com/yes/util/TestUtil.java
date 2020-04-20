package br.com.yes.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class TestUtil {

    private TestUtil() {
        throw new IllegalStateException("Utility Class");
    }

    public static List<Integer> values() {
        return values(21);
    }

    public static List<Integer> values(int num) {
        return IntStream.range(1, num).boxed().collect(Collectors.toList());
    }

    public static Map<String, List<Integer>> dumpFrames(String name, int num) {
        final Map<String, List<Integer>> map = new HashMap<>();
        map.put(name, values(num));
        return map;
    }

    public static Map<String, List<Integer>> dumpFrames(String name, Integer... num) {
        final Map<String, List<Integer>> map = new HashMap<>();
        map.put(name, asList(num));
        return map;
    }
}
