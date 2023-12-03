package org.advent.day1;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestElfCaloriesDocumentParserImplShould {

    @Test
    void throw_a_FileNotFoundException_when_could_not_find_document() {
        ElfCaloriesDocumentParser elfCaloriesDocumentParser = new ElfCaloriesDocumentParserImpl();

        assertThrows(
                FileNotFoundException.class,
                () -> elfCaloriesDocumentParser.parseCaloriesDocument("FileNotFound.txt"),
                "Expected parseCaloriesDocument() to throw, but it didn't."
        );
    }

    @Test
    void throw_a_NumberFormatException_when_it_could_not_convert_a_line() {
        ElfCaloriesDocumentParser elfCaloriesDocumentParser = new ElfCaloriesDocumentParserImpl();

        assertThrows(
                NumberFormatException.class,
                () -> elfCaloriesDocumentParser.parseCaloriesDocument("IllegalFormat.txt"),
                "Expected parseCaloriesDocument() to throw, but it didn't."
        );
    }

    @Test
    void return_an_empty_list_of_elf_when_document_is_empty() throws URISyntaxException, IOException {
        ElfCaloriesDocumentParser elfCaloriesDocumentParser = new ElfCaloriesDocumentParserImpl();

        List<Elf> elves = elfCaloriesDocumentParser.parseCaloriesDocument("EmptyFile.txt");

        assertThat(elves, is(empty()));
    }

    @Test
    void return_a_list_of_correctly_initialized_elves_when_document_is_valid_and_not_empty() throws URISyntaxException, IOException {
        ElfCaloriesDocumentParser elfCaloriesDocumentParser = new ElfCaloriesDocumentParserImpl();
        List<Elf> expectedElves = getExpectedElves();

        List<Elf> elves = elfCaloriesDocumentParser.parseCaloriesDocument("ValidFile.txt");

        assertThat(elves.size(), equalTo(expectedElves.size()));
        assertThat(elves, containsInAnyOrder(expectedElves.toArray()));
    }

    private static List<Elf> getExpectedElves() {
        Elf elf1 = new Elf();
        elf1.addCalories(1000);
        elf1.addCalories(2000);
        elf1.addCalories(3000);
        Elf elf2 = new Elf();
        elf2.addCalories(4000);
        Elf elf3 = new Elf();
        elf3.addCalories(5000);
        elf3.addCalories(6000);
        Elf elf4 = new Elf();
        elf4.addCalories(7000);
        elf4.addCalories(8000);
        elf4.addCalories(9000);
        Elf elf5 = new Elf();
        elf5.addCalories(10000);
        List<Elf> expectedElves = List.of(elf1, elf2, elf3, elf4, elf5);
        return expectedElves;
    }
}
