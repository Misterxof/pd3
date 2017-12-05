package models.StringTokenFactories;

import models.CodeBlock;
import models.StringToken;

public class CodeBlockFactory extends BaseFactory {

    /**
     * The method returns object of CodeBlock type
     * @param input
     * @return object of CodeBlock type
     */
    @Override
    public StringToken createStringTokenFromFactory(String input) {
        return new CodeBlock(input);
    }
}
