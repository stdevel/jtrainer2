package net.stdevel.jtrainer2;

/**
 * JTrainer2 answer class
 * @author Christian Stankowic
 * @version 0.1
 */
public class answer
{
	//variables
	private String answer;
	private boolean correct;



    /* CONSTRUCTORS / DESTRUCTOR */

    /**
     * constructor
     * @param a the answer
     * @param c boolean defining whether the answer is correct
     */
	public answer(String a, boolean c)  { init(a, c); }

    /**
     * constructor
     * @param a the answer
     */
    public answer(String a) { init(a, false); }



    /**
     * constructor helper
     * @param answer the answer
     * @param correct boolean defining whether the answer is correct
     */
    private void init(String answer, boolean correct)
    {
        //set variables
        this.answer = answer;
        this.correct = correct;
        debugMsg("Created answer with answer='" + answer + "' and correct='" + correct + "'");
    }

    /**
     * destructor
     */
	protected void finalize()
	{
		//clear answer
		this.answer = null;
		debugMsg("Killed answer, goodbye!");
	}



    /* GETTER / SETTER */

    /**
     * marks the answer as correct
     */
    public void setCorrect()
    {
        this.correct = true;
    }

    /**
     * marks the answer as incorrect
     */
    public void setIncorrect()
    {
        this.correct = false;
    }

    /**
     * retrieves the answer
     * @return the answer
     */
    public String getAnswer()
    {
        return this.answer;
    }

    /**
     * defines the answer
     * @param a the new answer
     */
    public void setAnswer(String a)
    {
        this.answer = a;
    }

    /**
     * tells if the answer is correct
     * @return boolean defining whether the answer is correct
     */
    public boolean isCorrect()
    {
        return this.correct;
    }



    /* DEBUG */

    /**
     * prints a debugging message
     * @param msg the message
     */
    private void debugMsg(String msg)
    {
        System.out.println("A: " + msg);
    }

    /**
     * dumps answer data
     */
    public void dumpAnswerData()
    {
        debugMsg("Dumping answer data #" + Integer.toHexString(System.identityHashCode(this)) );
        //print answer and whether it's correct
        debugMsg("Answer: " + this.getAnswer());
        debugMsg("isCorrect: " + this.isCorrect());
    }
}