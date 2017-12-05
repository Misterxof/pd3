package models.StringTokenFactories;

import models.StringToken;

/**
 * The abstract class BaseFactory
 */
public abstract class BaseFactory {
    /**
     * The method returns object of some models classes
     * @param input
     * @return object of some models classes
     */
    public abstract StringToken createStringTokenFromFactory(String input);
}
