package com.johnny.ensemble.codetest.codetestwithui.controllers;

import com.johnny.ensemble.codetest.codetestwithui.models.InputFileModel;
import com.johnny.ensemble.codetest.codetestwithui.models.WordModel;
import com.johnny.ensemble.codetest.codetestwithui.utils.CountUtil;
import com.johnny.ensemble.codetest.codetestwithui.utils.InputUtil;
import com.johnny.ensemble.codetest.codetestwithui.utils.PrintUtil;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/web")
@RestController
public class WebModeController {

    @RequestMapping(method = RequestMethod.POST)
    public String count(@RequestParam("textData") String input) {
        //read from web
        InputFileModel inputFileModel = InputUtil.readFromWeb(input);

        //have the file, do count
        Map<WordModel, Integer> result = CountUtil.countAndIgnorePartialMatches(inputFileModel);

        //output the result
        return PrintUtil.printToWebPage(result);
    }
}