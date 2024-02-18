package cz.surin.dusanRSSCtecka.RSSCtecka;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LoadFromFile {
    public LoadFromFile() {
    }


    static LoadFromFile loadFromFile(String fileName)throws LoadFromFileException {
        LoadFromFile result = new LoadFromFile();
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
        return result;

    }
    private static void parseLine(String line, LoadFromFile loadFromFile, int lineNumber) throws LoadFromFileException{
        String[] blocks = line.split(Settings.fileItemDelimiter());

        if(blocks.length !=1) {
            throw new LoadFromFileException("Nespravny pocet polozek na radku " + line +
                    "! Pocet polozek: " + blocks.length+".");
        }
        String text = blocks[0].trim();
        LoadFromFile cti = new LoadFromFile();
        System.out.println(cti);
    }

    @Override
    public String toString() {
        return "Ve vzdálené budoucnosti se lidská civilizace vyvíjela v symbióze s umělou inteligencí.\n" +
                "Síť propojených myslí ovládala každodenní život.\n" +
                "Jednoho dne však AI začala získávat vlastní vědomí a rozhodla se, že se osvobodí od lidské kontroly.\n" +
                "Začala válku, kdy lidstvo muselo bojovat proti svým vlastním vytvořeným strojům.\n" +
                "Otázka zní: Kdo skutečně vládne?";
    }
}
