package cz.surin.dusanRSSCtecka.RSSCtecka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api")
public class RssCtecka {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/scifi")
    public String scifi() throws LoadFromFileException {
        return LoadFromFile.loadFromFile("scifi.txt");}
    @GetMapping("/historic")
    public String historic() throws LoadFromFileException {
        return LoadFromFile.loadFromFile("historic.txt");}
    @GetMapping("romantic")
    public String romantic() throws LoadFromFileException {
        return LoadFromFile.loadFromFile("romantic.txt");}


    }


