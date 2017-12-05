package util.handlers;

import models.StringTokenFactories.BaseFactory;
import models.StringTokenFactories.SentenceFactory;

import java.util.regex.Pattern;
/***
 * Handler which works only with sentences
 */
public class SentenceHandler extends BaseHandler {

    /**
     * The method returns object of type SentenceFactory
     * @return new SentenceFactory object
     */
    @Override
    protected BaseFactory getFactory() {
        return new SentenceFactory();
    }

    /**
     * The method returns regex pattern
     * @return regex pattern
     */
    @Override
    protected Pattern getRegexPattern() {
        return Pattern.compile("(.+?)([.!?\\r\\n]+|$)");
    }
}
