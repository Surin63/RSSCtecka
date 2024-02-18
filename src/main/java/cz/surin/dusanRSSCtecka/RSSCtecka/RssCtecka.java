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
    public String scifi() throws LoadFromFileException {
        return LoadFromFile.loadFromFile(Settings.defaultFileName()).toString();}
    @GetMapping("/historic")
    public String historic() throws LoadFromFileException {
        return LoadFromFile.loadFromFile(Settings.defaultFileName()).toString();}
    @GetMapping("romantic")
    public String romantic() throws LoadFromFileException {
        return LoadFromFile.loadFromFile(Settings.defaultFileName()).toString();}



    public static void main(String[] args)  {
        try {
            LoadFromFile.loadFromFile(Settings.defaultFileName());
        } catch (LoadFromFileException e) {
            System.err.println("Chyba pri cteni souboru");
            }
        }
    }


