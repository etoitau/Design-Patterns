package com.etoitau.designpatterns.flyweight;


import java.util.ArrayList;
import java.util.List;

class Sentence
{
    private List<WordToken> words;

    public Sentence(String plainText)
    {
        words = new ArrayList<>();
        for (String word: plainText.split(" ")) {
            words.add(new WordToken(word));
        }
    }

    public WordToken getWord(int index)
    {
        return words.get(index);
    }

    @Override
    public String toString()
    {

        if ( words.size() == 0)
            return null;
        StringBuilder sb = new StringBuilder();
        sb.append(words.get(0));
        for (int i = 1; i < words.size(); i++) {
            sb.append(" ").append(words.get(i));
        }
        return sb.toString();
    }

    class WordToken
    {
        String word;
        public boolean capitalize;

        public WordToken(String word) {
            this.word = word;
        }

        @Override
        public String toString() {
            return capitalize? word.toUpperCase(): word;
        }

    }
}
