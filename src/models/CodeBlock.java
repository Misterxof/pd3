package models;

/***
 * CodeBlock class
 */
public class CodeBlock implements TextToken {
    private String content;

    /**
     * Constructor for class CodeBlock
     * @param content
     */
    public CodeBlock(String content) {
        this.content = content;
    }

    /**
     * The method returns the content
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * The method sets the content
     * @param content
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Overriding the method toString()
     * @return String
     */
    @Override
    public String toString() {
        return this.content;
    }
}
