package util.handlers;

import models.StringTokenFactories.BaseFactory;
import models.StringTokenFactories.SignFactory;

import java.util.regex.Pattern;
/***
 * Handler which works only with signs
 */
public class SignHandler extends BaseHandler {

    /**
     * The method returns object of type SignFactory
     * @return new SignFactory object
     */
    @Override
    protected BaseFactory getFactory() {
        return new SignFactory();
    }

    /**
     * The method returns regex pattern
     * @return regex pattern
     */
    @Override
    protected Pattern getRegexPattern() {
        return Pattern.compile("[ \t\\[\\]{}\"'.?!,;:\\-()\\r\\n]");
    }
}
