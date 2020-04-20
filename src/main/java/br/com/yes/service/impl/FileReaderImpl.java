package br.com.yes.service.impl;

import br.com.yes.service.FileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

public class FileReaderImpl implements FileReader {

    @Override
    public Map<String, List<Integer>> read(final String filePath) {

        try (Stream<String> file = Files.lines(Paths.get(filePath))) {
            final Map<String, List<Integer>> map = new HashMap<>();
            file.forEach(line -> {
                final String[] value = line.split(" ");
                map.putIfAbsent(value[0], new ArrayList<>());
                map.get(value[0]).add(parseIntOrDefault(value[1]));
            });

            return map;

        } catch (IOException e) {
            throw new RuntimeException("something went wrongs happening");
        }
    }


    private Integer parseIntOrDefault(final String value) {
        return value.equals("F") ? 0 : parseInt(value);
    }
}

