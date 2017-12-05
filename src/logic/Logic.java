package logic;

import exception.IncorrectNumberOfArgumentsException;
import models.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import view.View;

public class Logic {

    private static Logger LOGGER = LogManager.getLogger(View.class);

    public ArrayList<Sentence> sentences;
    public ResourceBundle bundle;
    public Text text;
    public Path p;

    /**
     * The method initialize program
     * @param args - arguments
     */
    public void init(String[] args) {
        sentences = new ArrayList<Sentence>();
        Locale.setDefault(new Locale("ru"));
        Locale locale = args.length > 1 ? new Locale(args[1]) : Locale.getDefault();
        bundle = ResourceBundle.getBundle("l10n.Resources", locale);

        LOGGER.debug("Localization included successfully");

        text = null;
        p = null;
        try {
            p = getPath(args);
        } catch (IncorrectNumberOfArgumentsException e) {
            LOGGER.error(e.getMessage());
            System.exit(2);
        }
        try {
            String textContent = new String(Files.readAllBytes(p), StandardCharsets.UTF_16);
            text = new Text(textContent);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            System.exit(1);
        }
    }

    /**
     * The method print all lexemes(sentences, words, signs, code blocks)
     * @param bundle
     * @param text
     */
    public static void printLexemes(ResourceBundle bundle, Text text){
        System.out.println(bundle.getString("lexemes"));
        System.out.println("\t" + bundle.getString("sentences"));

        for(Sentence sentence : text.getSentences()){
            System.out.println("\t\t" + sentence);
            System.out.println("\t\t" + bundle.getString("words"));

            for(Word word : sentence.getWords()){
                System.out.println("\t\t\t" + word);
            }
            System.out.println("\t\t" + bundle.getString("punctuation"));

            int j =0;
            for(Sign punctuationSign : sentence.getSigns()){
                if(!(punctuationSign.toString().replaceAll("\\s+"," ")).equals(" ")) {
                    System.out.println("\t\t\t" + j + ") " + punctuationSign);
                    j++;
                }
            }
        }
        System.out.println("\t" + bundle.getString("codeBlocks"));

        for(CodeBlock codeBlock : text.getCodeBlocks()) {
            System.out.println(codeBlock + "\n");
        }
    }

    /**
     * The method returns first argument, in oua case it's the path to the input file
     * @param args - arguments
     * @return path to the file
     * @throws IncorrectNumberOfArgumentsException
     */
    public static Path getPath(String[] args) throws IncorrectNumberOfArgumentsException
    {
        if ((args.length < 1) || (args.length > 2)) {
            throw new IncorrectNumberOfArgumentsException("Incorrect number of arguments! Should be 1 or 2 arguments.");
        }
        return Paths.get(args[0]);
    }
}
