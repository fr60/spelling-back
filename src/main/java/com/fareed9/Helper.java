package com.fareed9;

import java.util.concurrent.ThreadLocalRandom;

public class Helper {

    public static String mask(String text){
        int charsToMask = charsToMask(text);//number of chars to mask
        int[] randomIndexes = ThreadLocalRandom.current().ints(0, text.length()).distinct().limit(charsToMask).toArray();//indexes to mask

        char[] chars = text.toCharArray();
        for (int index : randomIndexes)
            chars[index] = '*';
        return String.valueOf(chars);
    }

    private static int charsToMask(String text){
        return 2;
    }
}
