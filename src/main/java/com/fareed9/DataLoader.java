package com.fareed9;

import com.fareed9.model.Word;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.*;


public class DataLoader {
    private static volatile DataLoader instance;//singleton
    private static final String PATH_TO_FILE = "/Users/fareedrezaei/lexicon.txt";
    private Map<Integer, Word> data;

    static {
        loadData();
    }

    private DataLoader(){}

    private synchronized static void loadData() {
        instance = new DataLoader();
        instance.data = new HashMap();
        //read from file
        try {
            List<String> strings = Files.readAllLines(Paths.get(PATH_TO_FILE), StandardCharsets.UTF_8);
            for(int i = 0; i < strings.size(); i++) {
                int id = i+1;
                instance.data.put(id, new Word(id, strings.get(i)));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Word getWord(int id){
        return instance.data.get(id);
    }


    public static Word getWord(){
        try {
            return instance.extractRandomWord();
        }catch (Exception ex){
            return null;
        }
    }

    private Word extractRandomWord(){
        SecureRandom random = new SecureRandom();
        int next = random.nextInt(data.size()) + 1;
        return data.get(next);
    }

}
