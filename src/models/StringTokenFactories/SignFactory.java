package models.StringTokenFactories;

import models.Sign;
import models.StringToken;

public class SignFactory extends BaseFactory {

    /**
     * The method returns object of Sign type
     * @param input
     * @return object of Sign type
     */
    @Override
    public StringToken createStringTokenFromFactory(String input) {
        return new Sign(input);
    }
}
