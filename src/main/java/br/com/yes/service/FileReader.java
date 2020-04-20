package br.com.yes.service;

import java.util.List;
import java.util.Map;

public interface FileReader {

    Map<String, List<Integer>> read(final String filePath);
}
