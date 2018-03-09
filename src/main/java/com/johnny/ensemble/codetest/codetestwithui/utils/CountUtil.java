package com.johnny.ensemble.codetest.codetestwithui.utils;


import com.johnny.ensemble.codetest.codetestwithui.models.InputFileModel;
import com.johnny.ensemble.codetest.codetestwithui.models.WordModel;
import java.util.*;

public class CountUtil {

    public static Map<WordModel, Integer> countAndIgnorePartialMatches(InputFileModel inputFileModel) {

        //ignore partial matches
        deletePartialMatchfromInputFile(inputFileModel);

        //count
        Map<WordModel, Integer> result = new TreeMap<>();

        for (WordModel wordModel : inputFileModel.getContent()) {
            if (result.containsKey(wordModel)) {
                result.put(wordModel, result.get(wordModel) + 1);
            } else {
                result.putIfAbsent(wordModel, 1);
            }
        }

        return result;

    }

    private static void deletePartialMatchfromInputFile(final InputFileModel inputFileModel){

        Set<String> keyToDelete = new HashSet<>();

        for(WordModel current: inputFileModel.getContent()){
            for(WordModel compare : inputFileModel.getContent()){
                if(current.getWordContentInLowerCase().contains(compare.getWordContentInLowerCase())){
                    //size of current is bigger or equal to compare
                    if(!current.equals(compare)) {
                        keyToDelete.add(compare.getWordContentInLowerCase());
                    }
                }
            }
        }

        for(String temp : keyToDelete){
            for (Iterator<WordModel> iter = inputFileModel.getContent().listIterator(); iter.hasNext(); ) {
                String key = iter.next().getWordContentInLowerCase();
                if (key.equals(temp)) {
                    iter.remove();
                }
            }
        }

    }
}
