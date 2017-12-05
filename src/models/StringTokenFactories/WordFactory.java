package models.StringTokenFactories;

import models.StringToken;
import models.Word;

public class WordFactory extends BaseFactory {

    /**
     * The method returns object of Word type
     * @param input
     * @return object of Word type
     */
    @Override
    public StringToken createStringTokenFromFactory(String input) {
        return new Word(input);
    }
}
