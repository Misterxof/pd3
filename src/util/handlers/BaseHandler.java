package util.handlers;

import models.StringToken;
import models.StringTokenFactories.BaseFactory;

import java.util.regex.Pattern;

/**
 *  Handler class which implements interface handler and is basic for all handlers
 */
public abstract class BaseHandler implements Handler {
    private Handler next;
    private final BaseFactory FACTORY = getFactory();
    private final Pattern REGEX_PATTERN = getRegexPattern();

    /**
     * The method returns object of type ...Factory
     * @return object of type ...Factory
     */
    protected abstract BaseFactory getFactory();

    /**
     * The method returns regex pattern
     * @return regex pattern
     */
    protected abstract Pattern getRegexPattern();

    /**
     * The method sets next handler
     * @param next - next handler
     */
    @Override
    public void setNext(Handler next) {
        this.next = next;
    }

    /**
     * The method checks if content corresponds to special token. If not - sent to next handler.
     * @param content
     * @return token or null
     */
    @Override
    public StringToken handle(String content) {
        StringToken result = acceptIfMatches(content);
        return result != null ? result : next != null ? next.handle(content) : null;
    }

    /**
     * The method returns StringToken if it matches the regex pattern
     * @param content - string object
     * @return StringToken if it matches the regex pattern, else return null
     */
    private StringToken acceptIfMatches(String content) {
        if (REGEX_PATTERN.matcher(content).matches()) {
            return FACTORY.createStringTokenFromFactory(content);
        }
        return null;
    }
}
