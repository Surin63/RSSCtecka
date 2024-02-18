package cz.surin.dusanRSSCtecka.RSSCtecka;

import ch.qos.logback.core.spi.ScanException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


@RestController
@RequestMapping("/api")
public class RssCtecka {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/scifi")
    public ResponseEntity<String> getScifi(){
        String fileName = "scifi.txt";
        return ResponseEntity.ok(fileName);
    }

    public static void main(String[] args)  {
        try {
            LoadFromFile.loadFromFile(Settings.defaultFileName());
        } catch (LoadFromFileException e) {
            System.err.println("Chyba pri cteni souboru");
            }
        }
    }


