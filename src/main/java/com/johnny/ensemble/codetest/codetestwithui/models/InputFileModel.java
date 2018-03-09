package com.johnny.ensemble.codetest.codetestwithui.models;

import java.util.List;

public class InputFileModel {
    List<WordModel> content;

    public List<WordModel> getContent() {
        return content;
    }

    public void setContent(List<WordModel> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "InputFileModel{" +
                "content=" + content +
                '}';
    }
}
