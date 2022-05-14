package com.fareed9;

import com.fareed9.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SpellingsController {
    @GetMapping("/")
    public Map<String, Object> getWord(){
        Map<String, Object> map = new HashMap<>();
        Word word = DataLoader.getWord();
        map.put("masked", word.getMasked());
        map.put("id", word.getId());
        return map;
    }

    @PostMapping("/")
    public ResponseEntity<Map<String,String>> matchWord(@RequestBody Word attempt){
        Word word = DataLoader.getWord(attempt.getId());
        Map<String,String> result = new HashMap();
        if(word.matched(attempt.getText())) {
            result.put("result", "matched");
            return new ResponseEntity(result, HttpStatus.OK);
        }
        result.put("result", "didn't match");
        return new ResponseEntity(result, HttpStatus.FORBIDDEN);
    }

    @PostMapping("/reveal")
    public ResponseEntity<Word> reveal(@RequestBody Map<String,Integer> attempt){
        Word word = DataLoader.getWord(attempt.get("id"));
        return new ResponseEntity(word, HttpStatus.OK);
    }

}
