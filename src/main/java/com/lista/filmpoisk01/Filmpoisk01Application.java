package com.lista.filmpoisk01;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@SpringBootApplication
public class Filmpoisk01Application implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(Filmpoisk01Application.class);
    @Autowired
    SpringBootConfiguration config;

    public static void main(String[] args) {
        SpringApplication.run(Filmpoisk01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       System.out.println(config.getApikey());
       //log.debug("config.getApikey()="+config.getApikey());

        String cUrlMain = "http://www.omdbapi.com/?apikey=";
        String cSeekKey;


        cSeekKey = "cat";
        String cUrl01 = cUrlMain  + config.getApikey()
                + "&t=" + cSeekKey;

        cSeekKey =  "tt3340364";
        String cUrl02 = cUrlMain  + config.getApikey()
                + "&i=" + cSeekKey;

        System.out.println("cUrl01=" + cUrl01);
        log.debug("cUrl01=" + cUrl01);
        // чтение из сайта cUrl01
        RestTemplate restTemplate = new RestTemplate();
        String cPage = restTemplate.getForObject(cUrl01, String.class);

        //System.out.println("Title:    " + cPage);

        // запись в экзепляр класса
        Page oPage01 = new Page();

        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> mapPage = mapper.readValue(cPage, new TypeReference<Map<String, Object>>() {
            });
            oPage01.setImdbID((String) mapPage.get("imdbID"));
            oPage01.setTitle((String) mapPage.get("Title"));
            oPage01.setYear(Integer.parseInt((String) mapPage.get("Year")));
            oPage01.setProduction((String) mapPage.get("Production"));
            oPage01.setPoster((String) mapPage.get("Poster"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("oPage01:" + oPage01);

        new WordWorker().Create(oPage01, "Page01.docx");

       new WordRepl().Eval(oPage01, "FilmPoisk.docx");


    }
}
