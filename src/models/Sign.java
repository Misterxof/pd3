package models;

/***
 * Sign class
 */
public class Sign implements SentenceToken {
    private String content;

    /**
     * The constructor of class Sign
     * @param content
     */
    public Sign(String content) {
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
