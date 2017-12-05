package models;

import util.handlers.CodeBlockHandler;
import util.handlers.Handler;
import util.handlers.SentenceHandler;
import util.parsers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Text class, text consists of code blocks and sentences
 */

public class Text{

    private ArrayList<TextToken> tokens = new ArrayList<TextToken>();

    /**
     * The method returns tokens
     * @return tokens
     */
    public ArrayList<TextToken> getTokens() {
        return tokens;
    }

    /**
     * The method change tokens
     * @param tokens
     */
    public void setTokens(ArrayList<TextToken> tokens) {
        this.tokens = tokens;
    }

    /**
     * The method returns sentences
     * @return list of sentences
     */
    public List<Sentence> getSentences(){
        return tokens.stream().filter(t -> t instanceof Sentence).
                map(t -> (Sentence)t).
                collect(Collectors.toList());  // collect the output and convert streams to a List
    }

    /**
     * The method returns code blocks
     * @return list of code blocks
     */
    public List<CodeBlock> getCodeBlocks(){
        return tokens.stream().filter(t -> t instanceof CodeBlock).
                map(t -> (CodeBlock)t).
                collect(Collectors.toList());
    }

    /**
     * Text constructor. Our parsing begins here. We divide text on sentences and code blocks
     * @param content - string object
     */
    public Text(String content){
        String nextToken;
        BaseParser parser = new TextParser(content);
        Handler firstHandler = new SentenceHandler();
        Handler secondHandler = new CodeBlockHandler();

        firstHandler.setNext(secondHandler);

        while ((nextToken = parser.findNext()) != null) {
            TextToken tokenToAdd = (TextToken)firstHandler.handle(nextToken);
            if (tokenToAdd != null)
                tokens.add(tokenToAdd);
        }
    }

    /**
     * Overriding the method toString()
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (TextToken token : tokens) {
            result.append(token.toString());
        }
        return result.toString();
    }
}
