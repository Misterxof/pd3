package util.handlers;

import models.StringTokenFactories.BaseFactory;
import models.StringTokenFactories.CodeBlockFactory;

import java.util.regex.Pattern;

/***
 * Handler which works only with code blocks
 */
public class CodeBlockHandler extends BaseHandler {

    /**
     * The method returns object of type CodeBlockFactory
     * @return new CodeBlockFactory object
     */
    @Override
    protected BaseFactory getFactory() {
        return new CodeBlockFactory();
    }

    /**
     * The method returns regex pattern
     * @return regex pattern
     */
    @Override
    protected Pattern getRegexPattern() {
        return Pattern.compile("<block>(.*?)</block>(\r\n)*", Pattern.DOTALL);
    }
}
