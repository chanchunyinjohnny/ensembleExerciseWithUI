package com.johnny.ensemble.codetest.codetestwithui.models;

public class WordModel implements Comparable<WordModel>{

    private String wordContentInLowerCase;
    private int length;

    public WordModel(String wordContentInLowerCase){
        this.wordContentInLowerCase = wordContentInLowerCase.toLowerCase();
        this.length = wordContentInLowerCase.length();
    }

    public String getWordContentInLowerCase() {
        return wordContentInLowerCase;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WordModel input = (WordModel) o;

        if (length != input.length) return false;
        return wordContentInLowerCase.equals(input.wordContentInLowerCase);
    }

    @Override
    public int hashCode() {
        int result = wordContentInLowerCase.hashCode();
        result = 31 * result + length;
        return result;
    }

    public int compareTo(WordModel o) {
        if (this.length < o.length){
            return 1;
        }
        else if (this.length > o.length){
            return -1;
        }
        else{
            return this.wordContentInLowerCase.compareTo(o.wordContentInLowerCase);
        }
    }

    @Override
    public String toString() {
        return "WordModel{" +
                "wordContentInLowerCase='" + wordContentInLowerCase + '\'' +
                ", length=" + length +
                '}';
    }
}
