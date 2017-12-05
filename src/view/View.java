package view;

import controllers.TextController;
import logic.Logic;
import models.*;

public class View {

    public static void main(String[] args) {

        Logic logic = new Logic();
        logic.init(args);
        int i = 0;

        System.out.println(logic.bundle.getString("originalText"));
        System.out.println(logic.text);
        System.out.println();

        logic.printLexemes(logic.bundle, logic.text);

        System.out.println();
        System.out.println(logic.bundle.getString("uniqueWordFromFirstSentence"));

        System.out.println(TextController.checkWordsFromFirstSentence(logic.text));

        System.out.println();
        System.out.println(logic.bundle.getString("sentencesSortedByCountOfWorlds"));

        logic.sentences = TextController.sentencesSortedByCountOfWorlds(logic.text);

        System.out.println();
        for (Sentence sentence : logic.sentences){
            if(!(sentence.toString().replaceAll("\\s+"," ")).equals(" ")) {
                System.out.println("" + i + ") " + sentence.toString().trim());
                i++;
            }
        }
    }
}
