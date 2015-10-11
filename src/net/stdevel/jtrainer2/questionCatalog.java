package net.stdevel.jtrainer2;
import java.util.ArrayList;

/**
 * JTrainer2 questionCatalog class
 * @author Christian Stankowic
 * @version 0.1
 */
public class questionCatalog
{
    //variables
    //private int answered;
    private String name;
    private String description;
    private String author;
    private String date;
    private int limit;
    private ArrayList<question> questions = new ArrayList<question>();
    private boolean endless;
    private boolean random;



    /* CONSTRUCTORS / DESTRUCTOR */

    /* .... */

    /**
     * constructor
     * @param name catalog name
     * @param description catalog description
     * @param author catalog author
     * @param date date
     * @param limit time limit
     * @param endless flag whether endless mode enabled
     * @param random flag whether random mode enabled
     * @param questions questions
     */
    public questionCatalog(String name, String description, String author, String date, int limit, boolean endless,
                      boolean random, ArrayList<question> questions)
    {
        init(name, description, author, date, limit, endless, random, questions);
    }

    /**
     * constructor helper
     * @param name catalog name
     * @param description catalog description
     * @param author catalog author
     * @param date date
     * @param limit time limit
     * @param endless flag whether endless mode enabled
     * @param random flag whether random mode enabled
     * @param questions questions
     */
    private void init(String name, String description, String author, String date, int limit, boolean endless,
                      boolean random, ArrayList<question> questions)
    {
        //set variables
        this.name = name;
        this.description = description;
        this.author = author;
        this.date = date;
        this.limit = limit;
        this.endless = endless;
        this.random = random;
        this.questions = questions;
        debugMsg("Created question catalog with name='" + name + "', description='" + description + "', author='" +
                author + "', date='" + date + "', limit='" + limit + "', endless='" + endless + "', random='"
                + random + "'");
    }



    /* GETTER / SETTER */

    /**
     * retrieves the catalog name
     * @return the name
     */
    public String getName() { return this.name; }

    /**
     * sets the catalog's name
     * @param n the name
     */
    public void setName(String n) { this.name = n; }

    /**
     * retrieves the catalog's description
     * @return the description
     */
    public String getDescription() { return this.description; }

    /**
     * sets the catalog's description
     * @param d the description
     */
    public void setDescription(String d) { this.description = d; }

    /**
     * retrieves the catalog's author
     * @return the author
     */
    public String getAuthor() { return this.author; }

    /**
     * sets the catalog's author
     * @param a the author
     */
    public void setAuthor(String a) { this.author = a; }

    /**
     * retrieves the catalog's date
     * @return the date
     */
    public String getDate() { return this.date; }

    /**
     * sets the catalog's date
     * @param d the date
     */
    public void setDate(String d) { this.date = d; }

    /**
     * retrieves the catalog's limit
     * @return the limit
     */
    public int getLimit() { return this.limit; }

    /**
     * sets the catalog's limit
     * @param l the limit
     */
    public void setLimit(int l) { this.limit = l; }

    /**
     * retrieves all questions
     * @return all question objects
     */
    public ArrayList<question> getQuestions() { return this.questions; }

    /**
     * retrieves an specific question
     * @param o offset
     * @return the question object
     */
    public question getQuestion(int o) { return this.questions.get(o); }

    /**
     * removes an specific question
     * @param o offset
     */
    public void removeQuestion(int o) { this.questions.remove(0); }

    /**
     * adds an question
     * @param q the question object
     */
    public void addQuestion(question q) { this.questions.add(q); }

    /**
     * defines whether the catalog's mode is endless
     * @param e boolean defining whether the catalog's mode is endless
     */
    public void setEndless(boolean e) { this.endless = e; }

    /**
     * sets the catalog's mode to endless
     */
    public void setEndless() { this.endless = true; }

    /**
     * tells whether the catalog's mode is endless
     * @return a boolean defining whether the catalog's mode is endless
     */
    public boolean isEndless() { return this.endless; }

    /**
     * defines whether this catalog mode is random
     * @param r boolean defining whether the catalog mode is random
     */
    public void setRandom(boolean r) { this.random = r; }

    /**
     * set's this catalog's mode to random
     */
    public void setRandom() { this.random = true; }

    /**
     * tells whether this catalog's mode is random
     * @return a boolean defining whether this catalog's mode is random
     */
    public boolean isRandom() {return this.random; }



    /* DEBUG */

    /**
     * prints a debugging message
     * @param msg the message
     */
    private void debugMsg(String msg) { System.out.println("QC: " + msg); }

    /**
     * dumps question data
     */
    public void dumpQuestionCatalogData()
    {
        debugMsg("Dumping question catalog data #" + Integer.toHexString(System.identityHashCode(this)) );
        //print meta information
        debugMsg("Name: " + this.name);
        debugMsg("Description: " + this.description);
        debugMsg("Author: " + this.author);
        debugMsg("Date: " + this.date);
        debugMsg("Limit: " + this.limit);
        debugMsg("endless: " + this.endless);
        debugMsg("random: " + this.random);

        //print questions
        for(question i: this.getQuestions()) { i.dumpQuestionData(); }
    }



}