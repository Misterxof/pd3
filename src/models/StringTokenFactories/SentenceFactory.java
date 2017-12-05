package models.StringTokenFactories;

import models.Sentence;
import models.StringToken;

public class SentenceFactory extends BaseFactory {

    /**
     * The method returns object of Sentence type
     * @param input
     * @return object of Sentence type
     */
    @Override
    public StringToken createStringTokenFromFactory(String input) {
        return new Sentence(input);
    }
}
