package controllers;

import exception.IncorrectNumberOfArgumentsException;
import models.*;

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Controller class which provide methods to solve special tasks
 */
public class TextController {
    private static Logger LOGGER = LogManager.getLogger(TextController.class);

    /**
     * The method returns the word form first sentence that doesn't contain in other sentences
     * @param text
     * @return return unique word from first sentence
     */
    public static Word checkWordsFromFirstSentence(Text text) {
        ArrayList<Word> words = new ArrayList<>();
        Sentence first_sentence=null;
        boolean first = true;

        LOGGER.debug("Find first sentence. ");

            for (Sentence sentence : text.getSentences()) {
                if (first) {
                    first_sentence = sentence;
                    first = false;
                } else {
                    for (Word word : sentence.getWords()) {
                        words.add(word);
                    }
                }
            }
        LOGGER.debug("Success!");

        for (Word word : first_sentence.getWords()) {
            if (!words.contains(word)) {
                LOGGER.debug("Word was found.\nChecking words from first sentence which are not in the other sentences:  ");
                return word;
            }
        }

        return null;
    }

    /**
     * The method returns ArrayList of sentences sort by count of worlds
     * @param text
     * @return ArrayList of sentences
     */
    public static ArrayList<Sentence> sentencesSortedByCountOfWorlds(Text text){
        ArrayList<Sentence> sentences = new ArrayList<Sentence>();

        LOGGER.debug("Adding sentences to list for sorting.");

        for (Sentence sentence : text.getSentences()) {
            sentences.add(sentence);
        }

        Collections.sort(sentences, new Sort());

        LOGGER.debug("Success! List was sorted.");

        return sentences;
    }
}
