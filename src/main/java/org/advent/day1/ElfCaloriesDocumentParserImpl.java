package org.advent.day1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ElfCaloriesDocumentParserImpl implements ElfCaloriesDocumentParser {
    @Override
    public List<Elf> parseCaloriesDocument(String filename) throws URISyntaxException, IOException {
        try {
            Path path = Paths.get(getClass().getClassLoader().getResource(filename).toURI());
            List<String> allLines = Files.readAllLines(path);

            List<Elf> elves = new ArrayList<>(Collections.emptyList());

            if (!allLines.isEmpty()) {
                Elf elf = new Elf();
                for (String line: allLines) {
                    if (line.isEmpty()) {
                        elves.add(elf);
                        elf = new Elf();
                    } else {
                        elf.addCalories(Integer.parseInt(line));
                    }
                }
                if (elf.getTotalCalories() > 0) elves.add(elf);
            }
            return elves;
        } catch (NullPointerException e){
            throw new FileNotFoundException();
        }

    }
}
