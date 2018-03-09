package com.johnny.ensemble.codetest.codetestwithnoui;

import com.johnny.ensemble.codetest.codetestwithui.models.InputFileModel;
import com.johnny.ensemble.codetest.codetestwithui.models.WordModel;
import com.johnny.ensemble.codetest.codetestwithui.utils.CountUtil;
import com.johnny.ensemble.codetest.codetestwithui.utils.InputUtil;
import com.johnny.ensemble.codetest.codetestwithui.utils.PrintUtil;
import java.io.IOException;
import java.util.Map;

public class CodeTest {

    public static void main(String[] args){

        //get file
        try {

            if(args.length < 1) {
                System.err.println("You need to give the path to the file.");
                System.exit(-1);
            }

            InputFileModel inputFileModel = InputUtil.readFromDisk(args[0]);

            //have the file, do count
            Map<WordModel, Integer> result = CountUtil.countAndIgnorePartialMatches(inputFileModel);

            //output the result
            PrintUtil.printToConsole(result);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
