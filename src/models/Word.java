package models;

/***
 * word class
 */
public class Word implements SentenceToken {

    private String content;

    /**
     * Constructor for class Word
     * @param content
     */
    public Word(String content) {
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
     * The method returns the content
     * @param content
     */
    public void setContent(String content){
        this.content = content;
    }

    /**
     * Overriding the method equals()
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word = (Word) o;

        if (content.equals(word.getContent())) return true;
        else return false;
    }

    /**
     * Overriding the method hashCode()
     * @return
     */
    @Override
    public int hashCode() {
        return content.hashCode();
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
