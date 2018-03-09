package com.johnny.ensemble.codetest.codetestwithui.utils;

import com.johnny.ensemble.codetest.codetestwithui.models.WordModel;
import java.util.Iterator;
import java.util.Map;

public class PrintUtil {

    public static void printToConsole(Map<WordModel,Integer> input){

        Iterator it = input.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<WordModel,Integer> pair = (Map.Entry)it.next();
            String str = pair.getKey().getWordContentInLowerCase();
            System.out.println(toStartWithUpper(str) + ": " + pair.getValue());
        }
    }

    public static String printToWebPage(Map<WordModel, Integer> input){

        String result = "";

        Iterator it = input.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<WordModel,Integer> pair = (Map.Entry)it.next();
            String str = pair.getKey().getWordContentInLowerCase();
            result += toStartWithUpper(str) + ": " + pair.getValue() + "\n";
        }

        return result;
    }

    private static String toStartWithUpper(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
