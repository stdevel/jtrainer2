package net.stdevel.jtrainer2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JTrainer2 tests class
 * @author Christian Stankowic
 * @version 0.1
 */
public class tests
{

    tests()
    {
        //localization
        ResourceBundle messages;
        //Locale locale = Locale.getDefault();
        String country = System.getProperty("user.country");
        String lang = System.getProperty("user.language");
        //System.out.println(lang + "_" + country);
        Locale currentLocale = new Locale(lang, country);
        try {
            messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        }
        catch(Exception e)
        {
            messages = ResourceBundle.getBundle("MessagesBundle",
                    new Locale("en", "US")
            );
        }

        System.out.println(messages.getString("test"));

        /*
        ANSWER
         */
        //generate answers
        debugMsg("*********************");
        debugMsg("Generate some answers");
        debugMsg("*********************");
        /*ArrayList<answer> answers = new ArrayList<answer>();
        answers.add(new answer("A"));
        answers.add(new answer("B", true));
        answers.add(new answer("C", false));*/
        ArrayList<answer> answers = new ArrayList<answer>() {{
            add(new answer("A"));
            add(new answer("B", true));
            add(new answer("C", false));
        }};
        //change some information
        answers.get(0).setAnswer("A!");
        answers.get(1).setIncorrect();
        answers.get(2).setCorrect();
        //dump data
        for(answer i: answers) { i.dumpAnswerData(); }

        /*
        QUESTION
         */
        //generate questions with answers
        debugMsg("***********************");
        debugMsg("Generate some questions");
        debugMsg("***********************");
        ArrayList<question> questions = new ArrayList<question>() {{
            add(
                    new question(
                            "1+1=?",
                            true,
                            new ArrayList<answer>() {{
                                add(new answer("2", true));
                            }}
                    )
            );
            add(
                    new question(
                            "Roses are?",
                            new ArrayList<answer>() {{
                                add(new answer("blue"));
                                add(new answer("red", true));
                                add(new answer("ugly"));
                            }}
                    )
            );
        }};
        //dump data
        for(question i : questions) { i.dumpQuestionData(); }

        /*
        QUESTION CATALOG
         */
        //generate question catalog with questions (and answers)
        debugMsg("***************************");
        debugMsg("Generate a question catalog");
        debugMsg("***************************");
        questionCatalog qCat = new questionCatalog(
                "Test catalog", "Example test question catalog", "Christian Stankowic", "03/22/2015", 5,
                false, false, questions
        );
        //dump data
        qCat.dumpQuestionCatalogData();
    }

    public static void main(String[] args)
    {
        System.out.println("Test program for net.stdevel.jtrainer2");
        tests bla = new tests();
    }

    /**
     * prints a debugging message
     * @param msg the message
     */
    private void debugMsg(String msg)
    {
        System.out.println("T: " + msg);
    }
}
