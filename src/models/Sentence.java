package models;

import util.handlers.*;
import util.parsers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sentence class. It consists of words objects and signs objects
 */
public class Sentence implements TextToken {

    private ArrayList<SentenceToken> tokens = new ArrayList<SentenceToken>();

    /**
     * The method returns list of tokens from sentence
     * @return ArrayList of tokens
     */
    public ArrayList<SentenceToken> getTokens() {
        return tokens;
    }

    /**
     * The method change the list of tokens
     * @param tokens
     */
    public void setTokens(ArrayList<SentenceToken> tokens) {
        this.tokens = tokens;
    }

    /**
     * The method returns the words
     * @return the words
     */
    public List<Word> getWords(){
        return tokens.stream().filter(t -> t instanceof Word).
                map(t -> (Word)t).
                collect(Collectors.toList());
    }

    /**
     * The method returns the signs
     * @return the signs
     */
    public List<Sign> getSigns(){
        return tokens.stream().filter(t -> t instanceof Sign).
                map(t -> (Sign)t).
                collect(Collectors.toList());
    }
    /**
     * Sentence constructor. Sentence parsing begins here. We divide sentence on words and punctuation marks
     * @param content - string object
     */
    public Sentence(String content) {
        BaseParser parser = new SentenceParser(content);
        Handler firstHandler = new WordHandler();
        Handler secondHandler = new SignHandler();
        firstHandler.setNext(secondHandler);
        String nextToken;
        while ((nextToken = parser.findNext()) != null) {
            SentenceToken tokenToAdd = (SentenceToken)firstHandler.handle(nextToken);
            if (tokenToAdd != null)
                tokens.add(tokenToAdd);
        }
    }

    /**
     * Overriding the method toString()
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (SentenceToken token : tokens) {
            result.append(token.toString());
        }
        return result.toString();
    }
}
