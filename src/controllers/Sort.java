package controllers;

import models.Sentence;
import java.util.Comparator;

/**
 * Class Sort
 */
public class Sort implements Comparator<Sentence> {

    /**
     * Overriding the method compare
     * @param o1 - first Sentence
     * @param o2 - second Sentence
     * @return int
     */
    @Override
    public int compare(Sentence o1, Sentence o2) {
        Sentence sentence1 = null;
        Sentence sentence2 = null;
        if (o2 instanceof Sentence) {
            sentence2 = (Sentence) o2;
        }
        if (o1 instanceof Sentence) {
            sentence1 = (Sentence) o1;
        }
        return sentence1.getWords().size() - sentence2.getWords().size();
    }

}
