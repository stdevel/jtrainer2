package net.stdevel.jtrainer2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * JTrainer2 jtrainer2 class
 * @author Christian Stankowic
 * @version 0.1
 */
public class jtrainer2 extends JFrame implements ItemListener {

    //variables
    final static String version = "0.1";
    final static boolean betaRelease = true;

    /**
     * JTrainer2 jtrainer2 GUI class
     * @param title window's title
     */
    jtrainer2(String title)
    {
        //get standards
        super(title);

        //variables
            //resources
            ResourceBundle messages;
            String lang = System.getProperty("user.language");
            String country = System.getProperty("user.country");

            //elements
            JTextArea txtQuestion;
            JLabel lblStatistic, lblCatalog, lblTimer;
            JButton btnHint, btnAnswer, btnNext;
            JCheckBox chkAnswer[] = new JCheckBox[5];
            JRadioButton radAnswer[] = new JRadioButton[5];
            JTextField txtAnswer;
            ButtonGroup grpAnswers;
            JPanel panCheckboxes, panRadiobuttons, panTextfield, panBar, panLbls, panBar2, panContent;

            //menu
            JMenuBar mnbMenu;

            //file
            JMenu mnuFile;
            JMenuItem mniOpen, mniDetails, mniAbort, mniEnd, mniExit;

            //settings
            JMenu mnuSettings;
            ButtonGroup bgrSettings, bgrSettings2;
            JRadioButtonMenuItem mrbRandom, mrbOrdered, mrbOnce, mrbEndless;

            //help
            JMenu mnuHelp;
            JMenuItem mniAbout;

            //icons
            Icon iconCorrect = new ImageIcon(this.getClass().getResource("/res/correct.png"));
            Icon iconIncorrect = new ImageIcon(this.getClass().getResource("/res/incorrect.png"));
            Icon iconEnd = new ImageIcon(this.getClass().getResource("/res/end.png"));
            Icon iconAbort = new ImageIcon(this.getClass().getResource("/res/abort.png"));
            Icon iconAnswer = new ImageIcon(this.getClass().getResource("/res/answer.png"));
            Icon iconNext = new ImageIcon(this.getClass().getResource("/res/next.png"));
            Icon iconOpen = new ImageIcon(this.getClass().getResource("/res/open.png"));
            Icon iconHint = new ImageIcon(this.getClass().getResource("/res/eye.png"));

        //get localization
        Locale currentLocale;
        try {
            currentLocale = new Locale(lang, country);
            messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        }
        catch(Exception e)
        {
            currentLocale = new Locale("en", "US");
            messages = ResourceBundle.getBundle("MessagesBundle", currentLocale);
        }
        debugMsg("Welcome to JTrainer2 v" + version + ", your locale is " + currentLocale);

        //don't quit application directly when closing window
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                //clean exit
                //end();
                debugMsg("JTrainer2 has left the building.");
                System.exit(0);
            }
        });

        //show information about beta release (if required)
        if (betaRelease == true) {
            JOptionPane.showMessageDialog(
                    null,
                    messages.getString("betarel_1") + "\n" + messages.getString("betarel_2"), "JTrainer2",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        //set layout
        setLayout(new BorderLayout());

        //instance elements

        //menu bar
        mnbMenu = new JMenuBar();

            //file
            mnuFile = new JMenu(messages.getString("mnu_file"));
            mniOpen = new JMenuItem(messages.getString("mnu_file_opencat"), KeyEvent.VK_O);
            mniOpen.setIcon(iconOpen);
            mniOpen.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //open catalog
                    //openCatalog(e);
                }
            });
            //mniOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
            mniOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.META_MASK));
            mniDetails = new JMenuItem(messages.getString("mnu_details"));
            mniDetails.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    //show details about catalog
                    JOptionPane.showMessageDialog(
                            null, "7" + " " + "catalogName" + "\n" + "8" + " " + "catalogDescription" +  "\n" + "37" +
                            " " + "catalogQuestions" + "\n" + "9" + " " + "catalogAuthor" + "\n" + "10" + " " +
                            "catalogDate", "11" + " '" + "catalogName" + "'", JOptionPane.INFORMATION_MESSAGE
                    );
                }
            });
            mniAbort = new JMenuItem(messages.getString("sim_abrt"), KeyEvent.VK_A);
            mniAbort.setIcon(iconAbort);
            mniAbort.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //abort
                    //btnAnswer.setIcon(iconAnswer);
                    //end();
                }
            });
            //mniAbort.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
            mniAbort.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.META_MASK));
            mniEnd = new JMenuItem(messages.getString("sim_exit"));
            mniEnd.setIcon(iconEnd);
            mniEnd.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //end
                    //btnAnswer.setIcon(iconAnswer);
                    //end();
                }
            });
            mniExit = new JMenuItem(messages.getString("mnu_exit"), KeyEvent.VK_Q);
            mniExit.setIcon(iconIncorrect);
            //mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
            mniExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.META_MASK));
            mniExit.addActionListener(new ActionListener() {
                //exit
                public void actionPerformed(ActionEvent e) {
                    //try abort timer
                    try {
                        debugMsg("About to kill timers...");
                        //countdown.cancel();
                        //ticker.cancel();
                        debugMsg("Killed timers!");
                    } catch (NullPointerException exp) {
                        debugMsg("No timers active - can't kill them");
                    }

                    //stop application
                    debugMsg("Application end - goodbye!");
                    System.exit(0);
                }
            });

            //Add menu elements for "file"
            mnuFile.add(mniOpen);
            mnuFile.addSeparator();
            mnuFile.add(mniDetails);
            mnuFile.addSeparator();
            mnuFile.add(mniAbort);
            mnuFile.add(mniEnd);
            mnuFile.addSeparator();
            mnuFile.add(mniExit);

            //settings
            mnuSettings = new JMenu(messages.getString("mnu_settings"));
            bgrSettings = new ButtonGroup();
            bgrSettings2 = new ButtonGroup();
            mrbRandom = new JRadioButtonMenuItem(messages.getString("mnu_random"));
            mrbRandom.setSelected(true);
            mrbOrdered = new JRadioButtonMenuItem(messages.getString("mnu_ordered"));
            bgrSettings.add(mrbRandom);
            bgrSettings.add(mrbOrdered);
            mrbOnce = new JRadioButtonMenuItem(messages.getString("mnu_once"));
            mrbOnce.setSelected(true);
            mrbEndless = new JRadioButtonMenuItem(messages.getString("mnu_endless"));
            bgrSettings2.add(mrbOnce);
            bgrSettings2.add(mrbEndless);

            //add item listeners
            mrbRandom.addItemListener(this);
            mrbOrdered.addItemListener(this);
            mrbOnce.addItemListener(this);
            mrbEndless.addItemListener(this);

            //Add menu elements for "settings"
            mnuSettings.add(mrbRandom);
            mnuSettings.add(mrbOrdered);
            mnuSettings.addSeparator();
            mnuSettings.add(mrbOnce);
            mnuSettings.add(mrbEndless);

            //help
            mnuHelp = new JMenu(messages.getString("mnu_help"));
            mniAbout = new JMenuItem(messages.getString("mnu_about"));
            final ResourceBundle finalMessages = messages;
            mniAbout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //info dialog
                    JOptionPane.showMessageDialog(
                            null,
                            finalMessages.getString("mnu_about_t1") + "\n\n" + finalMessages.getString("mnu_about_t2") +
                            "\n\n\n" + finalMessages.getString("mnu_about_t3") + "\n" + finalMessages.getString("mnu_about_t4"),
                            finalMessages.getString("mnu_about_t") + version,
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            });
            mnuHelp.add(mniAbout);

            //add menus
            mnbMenu.add(mnuFile);
            mnbMenu.add(mnuSettings);
            mnbMenu.add(mnuHelp);

        //buttons
        btnHint = new JButton(messages.getString("hint_show"));
        btnHint.setIcon(iconHint);
        btnAnswer = new JButton(messages.getString("question_answer"));
        btnAnswer.setIcon(iconAnswer);
        btnNext = new JButton(messages.getString("question_next"));
        btnNext.setIcon(iconNext);

        //text fields
        lblStatistic = new JLabel();
        lblStatistic.setSize(50, lblStatistic.getHeight());
        lblCatalog = new JLabel();
        lblTimer = new JLabel();
        lblTimer.setSize(50, lblStatistic.getHeight());
        txtQuestion = new JTextArea(10,40);
        txtQuestion.setLineWrap(true);
        txtQuestion.setWrapStyleWord(true);
        txtQuestion.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        txtQuestion.setEditable(false);
        JScrollPane scrQuestion = new JScrollPane(txtQuestion);
        scrQuestion.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrQuestion.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        //answer boxes

        //check boxes
        chkAnswer[0] = new JCheckBox(messages.getString("answer_lblA"));
        chkAnswer[1] = new JCheckBox(messages.getString("answer_lblB"));
        chkAnswer[2] = new JCheckBox(messages.getString("answer_lblC"));
        chkAnswer[3] = new JCheckBox(messages.getString("answer_lblD"));
        chkAnswer[4] = new JCheckBox(messages.getString("answer_lblE"));

        //listener for check boxes
        chkAnswer[0].addItemListener(this);
        chkAnswer[1].addItemListener(this);
        chkAnswer[2].addItemListener(this);
        chkAnswer[3].addItemListener(this);
        chkAnswer[4].addItemListener(this);

        //radio buttons
        grpAnswers = new ButtonGroup();
        radAnswer[0] = new JRadioButton(messages.getString("answer_lblA"));
        radAnswer[1] = new JRadioButton(messages.getString("answer_lblB"));
        radAnswer[2] = new JRadioButton(messages.getString("answer_lblC"));
        radAnswer[3] = new JRadioButton(messages.getString("answer_lblD"));
        radAnswer[4] = new JRadioButton(messages.getString("answer_lblE"));
        grpAnswers.add(radAnswer[0]);
        grpAnswers.add(radAnswer[1]);
        grpAnswers.add(radAnswer[2]);
        grpAnswers.add(radAnswer[3]);
        grpAnswers.add(radAnswer[4]);

        //listener for radio buttons
        radAnswer[0].addItemListener(this);
        radAnswer[1].addItemListener(this);
        radAnswer[2].addItemListener(this);
        radAnswer[3].addItemListener(this);
        radAnswer[4].addItemListener(this);

        //text field
        txtAnswer = new JTextField(messages.getString("answer_txt"));


        //checkbox panel
        panCheckboxes = new JPanel(new GridLayout(0,1));
        panCheckboxes.add(chkAnswer[0]);
        panCheckboxes.add(chkAnswer[1]);
        panCheckboxes.add(chkAnswer[2]);
        panCheckboxes.add(chkAnswer[3]);
        panCheckboxes.add(chkAnswer[4]);

        //radio button panel
        panRadiobuttons = new JPanel(new GridLayout(0,1));
        panRadiobuttons.add(radAnswer[0]);
        panRadiobuttons.add(radAnswer[1]);
        panRadiobuttons.add(radAnswer[2]);
        panRadiobuttons.add(radAnswer[3]);
        panRadiobuttons.add(radAnswer[4]);

        //textfield panel
        panTextfield = new JPanel(new GridLayout(10,1));
        panTextfield.setPreferredSize(new Dimension(0, 35));
        panTextfield.add(txtAnswer);

        //label panel
        panLbls = new JPanel(new GridLayout(1,0));
        panLbls.add(lblStatistic);
        panLbls.add(lblTimer);
        panLbls.add(lblCatalog);

        //bar panel (open, abort)
        panBar = new JPanel(new GridLayout(0,1));
        panBar.add(mnbMenu);
        panBar.add(panLbls);

        //content panel (textbox, checkbox/radiobutton panel)
        //panContent = new JPanel(new GridLayout(0,1));
        panContent = new JPanel(new BorderLayout());
        //panContent.add(scrQuestion);
        panContent.add(scrQuestion, BorderLayout.CENTER);

        //bar panel 2 (hint, answer, next)
        panBar2 = new JPanel(new GridLayout(1,0));
        panBar2.add(btnHint);
        panBar2.add(btnAnswer);
        panBar2.add(btnNext);
        //panContent.add(panBar2);
        panContent.add(panBar2, BorderLayout.PAGE_END);

        JPanel panBla = new JPanel(new BorderLayout());
        //Create the nodes.
        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode("Simulation");
        createNodes(top);

        JTree bla = new JTree(top);
        /*DefaultMutableTreeNode category = new DefaultMutableTreeNode("Simulation");
        bla.add(category);*/


        //JLabel bla2 = new JLabel("Frage 1/1");
        panBla.add(bla, BorderLayout.PAGE_START);
        //panBla.add(bla2, BorderLayout.PAGE_END);
        panBla.add(panLbls, BorderLayout.PAGE_END);

        //add elements
        add(panBar, BorderLayout.PAGE_START);
        add(panBla, BorderLayout.LINE_START);
        add(panContent, BorderLayout.CENTER);
        //add(panBar2, BorderLayout.PAGE_END);

        //disable elements
        mniDetails.setEnabled(false);
        mniAbort.setEnabled(false);
        mniEnd.setEnabled(false);
        mniEnd.setEnabled(false);
        mniAbort.setEnabled(false);
        chkAnswer[0].setEnabled(false);
        chkAnswer[1].setEnabled(false);
        chkAnswer[2].setEnabled(false);
        chkAnswer[3].setEnabled(false);
        chkAnswer[4].setEnabled(false);
        radAnswer[0].setEnabled(false);
        radAnswer[1].setEnabled(false);
        radAnswer[2].setEnabled(false);
        radAnswer[3].setEnabled(false);
        radAnswer[4].setEnabled(false);
        txtAnswer.setEnabled(false);
        btnHint.setEnabled(false);
        btnAnswer.setEnabled(false);
        btnNext.setEnabled(false);



        debugMsg("GUI class brought up");
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode e1 = null;
        DefaultMutableTreeNode e2 = null;
        DefaultMutableTreeNode e3 = null;
        //DefaultMutableTreeNode book = null;

        e1 = new DefaultMutableTreeNode("Frage 1");
        e2 = new DefaultMutableTreeNode("Frage 2");
        e3 = new DefaultMutableTreeNode("Frage 3");
        top.add(e1);
        top.add(e2);
        top.add(e3);
    }

    public static void main(String[] args)
    {
        //instance new window
        jtrainer2 myWindow = new jtrainer2("JTrainer2 v." + version);
        myWindow.pack();
        myWindow.setSize(520, 500);
        myWindow.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //TODO: handle clicks
    }

    /**
     * prints a debugging message
     * @param msg the message
     */
    private void debugMsg(String msg)
    {
        System.out.println("JT: " + msg);
    }
}