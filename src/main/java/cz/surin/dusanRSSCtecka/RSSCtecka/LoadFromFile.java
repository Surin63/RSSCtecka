package cz.surin.dusanRSSCtecka.RSSCtecka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LoadFromFile {
    public LoadFromFile() {
    }


    static String loadFromFile(String fileName)throws LoadFromFileException {
        StringBuilder result = new StringBuilder();
        int lineNumber = 1;

        try (Scanner scaneer = new Scanner(new BufferedReader(new FileReader(fileName)))) {
                while (scaneer.hasNextLine()) {
                    String line = scaneer.nextLine();
                    System.out.println(line);
                    parseLine(line, result, lineNumber);
                    lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.err.println("Chyba pri nacitani souboru");
        }
        return result.toString();

    }
    private static void parseLine(String line, StringBuilder result, int lineNumber) throws LoadFromFileException{
        String[] blocks = line.split(Settings.fileItemDelimiter());

        if(blocks.length !=1) {
            throw new LoadFromFileException("Nespravny pocet polozek na radku " + line +
                    "! Pocet polozek: " + blocks.length+".");
        }
        String text = blocks[0].trim();
        result.append(text).append("\n");
    }


}
