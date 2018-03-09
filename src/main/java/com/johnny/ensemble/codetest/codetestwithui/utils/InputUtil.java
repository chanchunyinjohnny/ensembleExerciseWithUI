package com.johnny.ensemble.codetest.codetestwithui.utils;

import com.johnny.ensemble.codetest.codetestwithui.models.InputFileModel;
import com.johnny.ensemble.codetest.codetestwithui.models.WordModel;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InputUtil {

    public static InputFileModel readFromDisk(String path) throws IOException {

        InputFileModel inputFileModel = new InputFileModel();

        File file = new File(path);
        List<String> lines = FileUtils.readLines(file, "UTF-8");

        List<WordModel> formatedWords = formatTextLines(lines);

        inputFileModel.setContent(formatedWords);

        return inputFileModel;
    }

    public static InputFileModel readFromWeb(String input){
        List<String> lines = new LinkedList<>();
        lines.add(input);
        List<WordModel> formatedWords = formatTextLines(lines);

        InputFileModel inputFileModel = new InputFileModel();
        inputFileModel.setContent(formatedWords);

        return inputFileModel;
    }

    public static InputFileModel readFromMultipartFile(MultipartFile file) throws IOException {


        InputFileModel inputFileModel = new InputFileModel();

        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();

        List<String> lines = FileUtils.readLines(convFile, "UTF-8");

        List<WordModel> formatedWords = formatTextLines(lines);

        inputFileModel.setContent(formatedWords);

        return inputFileModel;
    }

    private static List<WordModel> formatTextLines(List<String> lines){
        List<WordModel> formatedWords = new LinkedList<>();

        List<String> wordList = Arrays.asList(lines.get(0).split("\\s+"));

        for(String temp : wordList){
            WordModel wordModel  = new WordModel(temp);
            formatedWords.add(wordModel);
        }

        return formatedWords;
    }


}
