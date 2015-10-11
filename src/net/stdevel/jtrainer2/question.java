package net.stdevel.jtrainer2;

import net.stdevel.jtrainer2.answer;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * JTrainer2 question class
 * @author Christian Stankowic
 * @version 0.1
 */
public class question
{
	//variables
	private String question;
	private String hint;
	private String explanation;
	private boolean isTypePrompt;
	private ArrayList<answer> answers = new ArrayList<answer>();



    /* CONSTRUCTORS / DESTRUCTOR */

    /**
     * constructor
     * @param q the question
     * @param a answers
     */
    public question(String q, ArrayList<answer> a)
    {
        init(q, false, "", "");
        this.setAnswers(a);
    }

    /**
     * constructor
     * @param q the question
     */
    public question(String q) { init(q, false, "", ""); }

    /**
     * constructor
     * @param q the question
     * @param h the hint
     * @param a answers
     */
    public question(String q, String h, ArrayList<answer> a)
    {
        init(q, false, h, "");
        this.setAnswers(a);
    }
    /**
     * constructor
     * @param q the question
     * @param h the hint
     */
    public question(String q, String h) { init(q, false, h, ""); }

    /**
     * constructor
     * @param q the question
     * @param h the hint
     * @param e the explanation
     * @param a answers
     */
    public question(String q, String h, String e, ArrayList<answer> a)
    {
        init(q, false, h, e);
        this.setAnswers(a);
    }

    /**
     * constructor
     * @param q the question
     * @param h the hint
     * @param e the explanation
     */
    public question(String q, String h, String e) { init(q, false, h, e); }

    /**
     * constructor
     * @param q the question
     * @param p defines whether the answer needs to be entered
     * @param a answers
     */
    public question(String q, boolean p, ArrayList<answer> a)
    {
        init(q, p, "", "");
        this.setAnswers(a);
    }

    /**
     * constructor
     * @param q the question
     * @param p defines whether the answer needs to be entered
     */
    public question(String q, boolean p) { init(q, p, "", ""); }

    /**
     * constructor
     * @param q the question
     * @param p defines whether the answer needs to be entered
     * @param h the hint
     * @param a answers
     */
    public question(String q, boolean p, String h, ArrayList<answer> a)
    {
        init(q, p, h, "");
        this.setAnswers(a);
    }

    /**
     * constructor
     * @param q the question
     * @param p defines whether the answer needs to be entered
     * @param h the hint
     */
    public question(String q, boolean p, String h) { init(q, p, h, ""); }

    /**
     * constructor
     * @param q the question
     * @param p defines whether the answer needs to be entered
     * @param h the hint
     * @param e the explanation
     */
	public question(String q, boolean p, String h, String e) { init(q, p, h, e); }

    /**
     * constructor
     * @param q the question
     * @param p defines whether the answer needs to be entered
     * @param h the hint
     * @param e the explanation
     * @param a answers
     */
    public question(String q, boolean p, String h, String e, ArrayList<answer> a)
    {
        init(q, p, h, e);
        this.setAnswers(a);
    }

    /**
     * constructor helper
     * @param question the question
     * @param prompt defines whether the answer needs to be entered
     * @param hint the hint
     * @param explanation the explanation
     */
    private void init(String question, boolean prompt, String hint, String explanation)
    {
        //set variables
        this.question = question;
        this.isTypePrompt = prompt;
        this.hint = hint;
        this.explanation = explanation;
        debugMsg("Created question with isTypePrompt='" + prompt + "', question='" + question + "', hint='" + hint + "' and explanation='" + explanation + "'");
    }

    /**
     * destructor
     */
	protected void finalize()
	{
		//clear objects
		this.answers.clear();
		debugMsg("Killed question, goodbye!");
	}



    /* GETTER / SETTER */

    /**
     * retrieves all answers
     * @return all answer objects
     */
    public ArrayList<answer> getAnswers() { return this.answers; }

    /**
     * sets answers
     * @param a all answer objects
     */
    public void setAnswers(ArrayList<answer> a) { this.answers = a; }

    /**
     * adds an answer
     * @param a the answer object
     */
    public void addAnswer(answer a) { this.answers.add(a); }

    /**
     * retrieves an specific answer
     * @param o offset
     * @return the answer object
     */
    public answer getAnswer(int o) { return this.answers.get(o); }

    /**
     * removes an answer
     * @param o offset
     */
    public void removeAnswer(int o) { this.answers.remove(0); }

    /**
     * retrieves the question
     * @return the question
     */
	public String getQuestion() { return this.question; }

    /**
     * sets the question
     * @param q the question
     */
    public void setQuestion(String q) { this.question = q; }

    /**
     * retrieves the hint
     * @return the hint
     */
	public String getHint() { return this.hint; }

    /**
     * sets the hint
     * @param h the hint
     */
    public void setHint(String h) {this.hint = h; }

    /**
     * retrieves the explanation
     * @return the explanation
     */
	public String getExplanation()  { return this.explanation; }

    /**
     * sets the explanation
     * @param e the explanation
     */
    public void setExplanation(String e) { this.explanation = e; }

    /**
     * tells whether the answer needs to be prompted
     * @return boolean defining whether the answer needs to be prompted
     */
	public boolean isPrompted() { return this.isTypePrompt; }

    /**
     * sets that the answer needs to be prompted
     */
    public void setPrompted() { this.isTypePrompt = true; }

    /**
     * defines whether the answer needs to be prompted
     * @param p boolean defining whether the answer needs to be prompted
     */
    public void setPrompted(boolean p) { this.isTypePrompt = p; }



    /**
     * retrieves the amount of answers
     * @return the amount of answers
     */
	public int getNumbAnswers()
	{
		if(this.isTypePrompt) { return 1; }
		else { return this.answers.size(); }
	}



    /* DEBUG */

    /**
     * prints a debugging message
     * @param msg the message
     */
    private void debugMsg(String msg) { System.out.println("Q: " + msg); }

    /**
     * dumps question data
     */
	public void dumpQuestionData()
	{
        debugMsg("Dumping question data #" + Integer.toHexString(System.identityHashCode(this)) );
		//print question and hint
		debugMsg("Question: " + this.getQuestion());
		debugMsg("Hint: " + this.getHint());
		//print answers
        for(answer i: this.getAnswers()) { i.dumpAnswerData(); }
		//write out explanation
		debugMsg("Explanation: " + this.explanation);
	}
}