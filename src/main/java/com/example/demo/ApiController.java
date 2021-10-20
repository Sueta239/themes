package com.example.demo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {
    private List<String> themes = new ArrayList<>();
    /* 3 curl -X GET  http://localhost:8080/themes -H 'Content-Type: text/plain'  список сообщений */
    @GetMapping("themes")
    public List<String> getThemes() {
        return themes;
    }
    /*  1 curl -X POST http://localhost:8080/themes -H 'Content-Type: text/plain' -d 'dota2' добавляет в список */
    @PostMapping("themes")
    public void addThemes(@RequestBody String text) {
        themes.add(text);
    }
    /*  7 curl -X GET http://localhost:8080/themes/2 -H 'Content-Type: text/plain' выводит */
    @GetMapping("themes/{index}")
    public String getThemes(@PathVariable("index") Integer index) {
        return themes.get(index);
    }
    /* 2  curl -X DELETE http://localhost:8080/themes/1 -H 'Content-Type: text/plain' удаляет */
    @DeleteMapping("themes/{index}")
    public void deleteThemes(@PathVariable("index") Integer index) {
        themes.remove((int) index);
    }
    /*  4 curl -X PUT http://localhost:8080/themes/0 -H 'Content-Type: text/plain' -d 'teamSpirit'  обновляет */
    @PutMapping("themes/{index}")
    public void updateThemes(
            @PathVariable("index") Integer i,
            @RequestBody String theme) {
        themes.remove((int) i);
        themes.add(i, theme);
    }
    /* 6  curl -X DELETE http://localhost:8080/themes/del -H 'Content-Type: text/plain' удаляет */
    @DeleteMapping("themes/del")
    public void deleteText() {
        for (int i=themes.size();i>0;i--){
        themes.remove(0);}
    }
    /* 5 curl -X GET  http://localhost:8080/themes/size -H 'Content-Type: text/plain'  список сообщений */
    @GetMapping("themes/size")
    public int getThemessize() {
        return themes.size();
    }
}