package org.advent.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface ElfCaloriesDocumentParser {
    public List<Elf> parseCaloriesDocument(String filename) throws URISyntaxException, IOException;
}

