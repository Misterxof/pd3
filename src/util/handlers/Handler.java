package util.handlers;

import models.StringToken;

/**
 *  Handler is necessary for realisation chain of responsibility pattern
 */
public interface Handler {
    void setNext(Handler next);

    /**
     * The method defines what handler should do with content
     * @param content - string object to handle
     * @return StringToken or null
     */
    StringToken handle(String content);
}
