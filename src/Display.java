import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Display extends JPanel implements ActionListener {

    // Frame is where everything takes place.
    private JFrame frame = new JFrame();

    // Objects
    private Gameplay gameplay = new Gameplay();
    private randomWord randomWord = new randomWord();
    private textFile readFile = new textFile();
    private game gameObject = new game();

    // Panels
    private JPanel startMenu = new JPanel();
    private JPanel gamePanel = new JPanel();
    private JPanel instructionPanel = new JPanel();
    private JPanel wonPanel = new JPanel();
    private JPanel lostPanel = new JPanel();

    // Labels
    private JLabel label = new JLabel();
    private JLabel label_2 = new JLabel();
    private JLabel label_3 = new JLabel();
    private JLabel answerLabel = new JLabel();
    private JLabel optionsLeft = new JLabel();
    private JLabel answerChecker = new JLabel();
    private JLabel head = new JLabel();
    private JLabel torso = new JLabel();
    private JLabel leftArm = new JLabel();
    private JLabel rightArm = new JLabel();
    private JLabel leftLeg = new JLabel();
    private JLabel rightLeg = new JLabel();
    private JLabel leftEye = new JLabel();
    private JLabel rightEye = new JLabel();
    private JLabel mouth = new JLabel();
    private JLabel lifeWarning = new JLabel();
    private JLabel entireWord = new JLabel();
    private JLabel xentireWord = new JLabel();

    // Buttons
    private JButton start = new JButton();
    private JButton gotIt = new JButton();
    private JButton closeGame = new CreateRoundButton(null);
    private JButton restartGame = new CreateRoundButton(null);
    private JButton exit = new JButton();
    private JButton exit2 = new JButton();
    private JButton startOver = new JButton();
    private JButton startOver2 = new JButton();
    private JButton mainMenu = new JButton();
    private JButton mainMenu2 = new JButton();

    // Textfields
    private JTextField textField = new JTextField();

    // Fonts
    private Font font = new Font("Serif", Font.PLAIN, 60);
    private Font wordFont = new Font("Courier New", Font.PLAIN, 50); // answer string builder font, it was serif font.plain size 66
    private Font livesFont = new Font("Serif", Font.ITALIC, 24);
    private Font correctIncorrect = new Font("Serif", Font.PLAIN, 24);
    private Font endGame = new Font("Serif", Font.PLAIN, 20);
    private Font optionsLeftFont = new Font("Courier New", Font.PLAIN, 17); // it was serif font.plain 20 size

    // Int variables
    private int lives = 10;
    private int astrix = 0;

    // String variables
    private String fullWord;
    private String displayAnswer = "";
    private String holder;
    private String userInput;
    private String alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase();

    // Boolean variables
    private boolean beenUpdated = false;
    private boolean continueBuilding = true;

    // StringBuilder variables
    private StringBuilder builtWord = new StringBuilder(displayAnswer);

    // ArrayLists
    private ArrayList<Character> alphaList = new ArrayList<>();

    // Default Constructor
    public Display() {
        backing();
    }

    // Sets the properties of the frame.
    public void backing() {

        frame.setBounds(10, 10, 905, 665);
        frame.setBackground(Color.DARK_GRAY);
        frame.setUndecorated(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        frame.setLocationRelativeTo(null);
        frame.add(gameplay);
    }

    /*
    * Sets the properties of the menu panel and adds it to the frame.
    * The player must select "start" on this panel to begin playing.
    *
    * */
    public void menuPanel() {

        ImageIcon icon = new ImageIcon("images/menuPanelPicture.jpg");
        JLabel thumb = new JLabel();
        thumb.setIcon(icon);
        thumb.setVisible(true);
        thumb.setLayout(null);
        thumb.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        thumb.setBounds(0, 0, 850, 576);

        ImageIcon startImage = new ImageIcon("images/startButtonPicture.png");
        start.setIcon(startImage);
        start.setLayout(null);
        start.setBounds(369, 450, 112, 43);
        start.setContentAreaFilled(true);
        start.addActionListener(this);

        startMenu.setLayout(null);
        startMenu.setBounds(25, 75, 850, 576);
        startMenu.setBackground(Color.BLACK);
        startMenu.add(start);
        startMenu.add(thumb);

        frame.add(startMenu);
        frame.add(gameplay);
        frame.setVisible(true);
    }

    /*
     * Sets the properties of the instruction panel and adds it to the frame.
     * The instruction panel informs the player on how to play and demonstrates various features within the game.
     *
     * */
    public void clearPanel() {

        JLabel topArrow = new JLabel();
        ImageIcon arrow = new ImageIcon("images/closeGameArrow.png");
        topArrow.setLayout(null);
        topArrow.setBounds(35, -34, 100, 100);
        topArrow.setIcon(arrow);

        JLabel closeDesc = new JLabel();
        ImageIcon closeDes = new ImageIcon("images/closeGameDes.png");
        closeDesc.setLayout(null);
        closeDesc.setBounds(110, -34, 100, 100);
        closeDesc.setIcon(closeDes);

        JLabel bottomArrow = new JLabel();
        ImageIcon bArrow = new ImageIcon("images/restartGameArrow.png");
        bottomArrow.setLayout(null);
        bottomArrow.setBounds(41, 0, 100, 100);
        bottomArrow.setIcon(bArrow);

        JLabel restartDesc = new JLabel();
        ImageIcon restartDes = new ImageIcon("images/restartGameDes.png");
        restartDesc.setLayout(null);
        restartDesc.setBounds(45, 35, 100, 100);
        restartDesc.setIcon(restartDes);

        JLabel livesArrow = new JLabel();
        ImageIcon livesA = new ImageIcon("images/livesArrow.png");
        livesArrow.setLayout(null);
        livesArrow.setBounds(650, 46, 100, 100);
        livesArrow.setIcon(livesA);

        JLabel livesDesc = new JLabel();
        ImageIcon livesDes = new ImageIcon("images/livesRemaining.png");
        livesDesc.setLayout(null);
        livesDesc.setBounds(667, 85, 110, 120);
        livesDesc.setIcon(livesDes);

        JLabel circledEntry = new JLabel();
        ImageIcon circledDes = new ImageIcon("images/textfieldCircle.png");
        circledEntry.setLayout(null);
        circledEntry.setBounds(563, 380, 410, 200);
        circledEntry.setIcon(circledDes);

        JLabel entryDesc = new JLabel();
        ImageIcon entryDes = new ImageIcon("images/textfieldDes.png");
        entryDesc.setLayout(null);
        entryDesc.setBounds(620, 292, 210, 120);
        entryDesc.setIcon(entryDes);

        JLabel howto = new JLabel();
        ImageIcon how = new ImageIcon("images/mainInstructions.png");
        howto.setLayout(null);
        howto.setBounds(230, -10, 400, 500);
        howto.setIcon(how);

        JLabel letterBankDesc = new JLabel();
        ImageIcon letterBank = new ImageIcon("images/letterBank.png");
        letterBankDesc.setLayout(null);
        letterBankDesc.setBounds(35, 200, 400, 500);
        letterBankDesc.setIcon(letterBank);

        JLabel letterBankArrow = new JLabel();
        ImageIcon letterBankA = new ImageIcon("images/letterBankArrow.png");
        letterBankArrow.setLayout(null);
        letterBankArrow.setBounds(127, 232, 400, 500);
        letterBankArrow.setIcon(letterBankA);

        ImageIcon gotItImage = new ImageIcon("images/gotItPicture.png");
        gotIt.setIcon(gotItImage);
        gotIt.setLayout(null);
        gotIt.setBounds(320, 450, 110, 45);
        gotIt.addActionListener(this);

        instructionPanel.setLayout(null);
        instructionPanel.setBounds(25, 75, 850, 576);
        instructionPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        instructionPanel.setBackground(new Color(153, 153, 255, 100));
        instructionPanel.add(howto);
        instructionPanel.add(letterBankArrow);
        instructionPanel.add(letterBankDesc);
        instructionPanel.add(entryDesc);
        instructionPanel.add(circledEntry);
        instructionPanel.add(livesArrow);
        instructionPanel.add(livesDesc);
        instructionPanel.add(closeDesc);
        instructionPanel.add(restartDesc);
        instructionPanel.add(bottomArrow);
        instructionPanel.add(topArrow);
        instructionPanel.add(gotIt);

        frame.add(instructionPanel);
        frame.add(gameplay);
        frame.setVisible(true);
    }

    /*
     * Sets the properties of the game panel and adds it to the frame.
     * The game panel is where the main game is played.
     *
     * */
    public void gamePanel() {

        alphabetList();

        closeGame.setBackground(Color.red);
        closeGame.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        closeGame.setBounds(5, 5, 20, 20);
        closeGame.setLayout(null);
        closeGame.addActionListener(this);

        restartGame.setBackground(Color.yellow);
        restartGame.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        restartGame.setBounds(5, 30, 20, 20);
        restartGame.setLayout(null);
        restartGame.addActionListener(this);

        textField.setBounds(660, 450, 150, 100);
        textField.setFont(font);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        textField.addActionListener(this);

        label.setLayout(null);
        label.setBounds(20, 20, 100, 100);

        label_2.setLayout(null);
        label_2.setBounds(70, 20, 100, 100);

        label_3.setLayout(null);
        label_3.setFont(livesFont);
        label_3.setBounds(700, 10, 100, 100);
        label_3.setText("Lives: " + lives);

        ImageIcon inGameIcon = new ImageIcon("images/capitalPunishment.png"); //450cap
        JLabel inGamePic = new JLabel();
        inGamePic.setIcon(inGameIcon);
        inGamePic.setLayout(null);
        inGamePic.setBounds(215, -60, 500, 500);
        inGamePic.setVisible(true);

        head.setLayout(null);
        head.setBounds(392, -70, 500, 500);
        head.setVisible(true);

        torso.setLayout(null);
        torso.setBounds(408, 5, 500, 500);
        torso.setVisible(true);

        leftArm.setLayout(null);
        leftArm.setBounds(360, -5, 500, 500);
        leftArm.setVisible(true);

        rightArm.setLayout(null);
        rightArm.setBounds(423, -5, 500, 500);
        rightArm.setVisible(true);

        leftLeg.setLayout(null);
        leftLeg.setBounds(373, 92, 500, 500);
        leftLeg.setVisible(true);

        rightLeg.setLayout(null);
        rightLeg.setBounds(420, 92, 500, 500);
        rightLeg.setVisible(true);

        leftEye.setLayout(null);
        leftEye.setBounds(392, -70, 500, 500);
        leftEye.setVisible(true);

        rightEye.setLayout(null);
        rightEye.setBounds(392, -70, 500, 500);
        rightEye.setVisible(true);

        mouth.setLayout(null);
        mouth.setBounds(392, -70, 500, 500);
        mouth.setVisible(true);

        lifeWarning.setLayout(null);
        lifeWarning.setBounds(460, -120, 500, 500);
        lifeWarning.setVisible(true);

        answerLabel.setLayout(null);
        answerLabel.setBounds(180, 455, 500, 100);
        answerLabel.setText("  ");
        answerLabel.setFont(wordFont);

        answerChecker.setLayout(null);
        answerChecker.setFont(correctIncorrect);
        answerChecker.setBounds(600, 60, 300, 100);

        JLabel underline = new JLabel();
        underline.setLayout(null);
        underline.setBounds(210, 463, 500, 100);
        underline.setText("_____      _____       _____      _____      _____      _____");

        optionsLeft.setLayout(null);
        optionsLeft.setFont(optionsLeftFont);
        optionsLeft.setAlignmentX(CENTER_ALIGNMENT);
        optionsLeft.setBounds(110, 500, 800, 100);
        optionsLeft.setText(getAlphaList().toString().replaceAll("\\p{P}", ""));

        gamePanel.setLayout(null);
        gamePanel.setBounds(25, 75, 850, 576);
        gamePanel.setBackground(Color.lightGray);
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        gamePanel.add(head);
        gamePanel.add(torso);
        gamePanel.add(leftArm);
        gamePanel.add(rightArm);
        gamePanel.add(leftLeg);
        gamePanel.add(rightLeg);
        gamePanel.add(leftEye);
        gamePanel.add(rightEye);
        gamePanel.add(mouth);
        gamePanel.add(lifeWarning);
        gamePanel.add(answerChecker);
        gamePanel.add(inGamePic);
        gamePanel.add(underline);
        gamePanel.add(optionsLeft);
        gamePanel.add(restartGame);
        gamePanel.add(closeGame);
        gamePanel.add(label);
        gamePanel.add(label_2);
        gamePanel.add(label_3);
        gamePanel.add(answerLabel);
        gamePanel.add(textField, BorderLayout.CENTER);

        frame.add(gamePanel);
        frame.add(gameplay);
        frame.setVisible(true);
    }

    /*
     * Sets the properties of the won panel and adds it to the frame.
     * The won panel will display if the user successfully guesses the word before running out of lives.
     *
     * */
    public void wonPanel() {

        Font winFont = new Font("Serif", Font.BOLD, 82);

        ImageIcon savedMan = new ImageIcon("images/finalmanman.png");
        ImageIcon playAgain = new ImageIcon("images/playagainsmall (1).png");
        ImageIcon brexit = new ImageIcon("images/closegame.png");
        ImageIcon Mainmen = new ImageIcon("images/mainmenu.png");

        JLabel savedManLabel = new JLabel();
        savedManLabel.setIcon(savedMan);
        savedManLabel.setLayout(null);
        savedManLabel.setBounds(30, 270, 500, 400);
        savedManLabel.setVisible(true);

        JLabel youWon = new JLabel();
        youWon.setFont(winFont);
        youWon.setForeground(Color.BLACK);
        youWon.setText("You Won!");
        youWon.setAlignmentX(CENTER_ALIGNMENT);
        youWon.setVisible(true);
        youWon.setBounds(245, 0, 400, 140);

        entireWord.setLayout(null);
        entireWord.setFont(endGame);
        entireWord.setForeground(Color.black);
        entireWord.setAlignmentX(CENTER_ALIGNMENT);
        entireWord.setBounds(340, 70, 400, 140);
        entireWord.setVisible(true);

        startOver.setIcon(playAgain);
        startOver.setBounds(320, 300, 226, 50);
        startOver.addActionListener(this);
        startOver.setVisible(true);

        exit.setIcon(brexit);
        exit.setBounds(320, 400, 226, 50);
        exit.addActionListener(this);
        exit.setVisible(true);

        mainMenu.setIcon(Mainmen);
        mainMenu.setBounds(320, 200, 226, 50);
        mainMenu.addActionListener(this);
        mainMenu.setVisible(true);

        wonPanel.setLayout(null);
        wonPanel.setBackground(new Color(13, 180, 35, 255));
        wonPanel.setBounds(25, 75, 850, 576);
        wonPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        wonPanel.add(entireWord);
        wonPanel.add(savedManLabel);
        wonPanel.add(youWon);
        wonPanel.add(mainMenu);
        wonPanel.add(startOver);
        wonPanel.add(exit);

        frame.add(wonPanel);
        frame.add(gameplay);
        frame.setVisible(true);
    }

    /*
     * Sets the properties of the lost panel and adds it to the frame.
     * The lost panel will display if the user unsuccessfully guesses the word and runs out of lives.
     *
     * */
    public void lostPanel() {

        Font winFont = new Font("Serif", Font.BOLD, 82);

        ImageIcon deadMan = new ImageIcon("images/newguru.png");
        ImageIcon playAgain = new ImageIcon("images/playagainsmall (1).png");
        ImageIcon brexit = new ImageIcon("images/closegame.png");
        ImageIcon Mainmen = new ImageIcon("images/mainmenu.png");

        JLabel deadManLabel = new JLabel();
        deadManLabel.setIcon(deadMan);
        deadManLabel.setLayout(null);
        deadManLabel.setBounds(550, 230, 500, 400);
        deadManLabel.setVisible(true);

        JLabel youWon = new JLabel();
        youWon.setFont(winFont);
        youWon.setForeground(Color.BLACK);
        youWon.setText("You Lost!");
        youWon.setAlignmentX(CENTER_ALIGNMENT);
        youWon.setVisible(true);
        youWon.setBounds(230, 0, 400, 140);

        xentireWord.setLayout(null);
        xentireWord.setFont(endGame);
        xentireWord.setForeground(Color.black);
        xentireWord.setAlignmentX(CENTER_ALIGNMENT);
        xentireWord.setBounds(312, 70, 400, 140);
        xentireWord.setVisible(true);

        startOver2.setIcon(playAgain);
        startOver2.setBounds(291, 300, 226, 50);
        startOver2.addActionListener(this);
        startOver2.setVisible(true);

        exit2.setIcon(brexit);
        exit2.setBounds(291, 400, 226, 50);
        exit2.addActionListener(this);
        exit2.setVisible(true);

        mainMenu2.setIcon(Mainmen);
        mainMenu2.setBounds(291, 200, 226, 50);
        mainMenu2.addActionListener(this);
        mainMenu2.setVisible(true);

        lostPanel.setLayout(null);
        lostPanel.setBackground(Color.RED);
        lostPanel.setBounds(25, 75, 850, 576);
        lostPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
        lostPanel.add(xentireWord);
        lostPanel.add(deadManLabel);
        lostPanel.add(youWon);
        lostPanel.add(mainMenu2);
        lostPanel.add(startOver2);
        lostPanel.add(exit2);

        frame.add(lostPanel);
        frame.add(gameplay);
        frame.setVisible(true);
    }

    // Resets the necessary variables and restarts the game.
    public void restartGame() {
        astrix = 0;
        lives = 10;
        label_3.setText("Lives: " + lives);
        userInput = null;
        answerLabel.setText(null);
        answerChecker.setIcon(null);
        head.setIcon(null);
        torso.setIcon(null);
        leftArm.setIcon(null);
        rightArm.setIcon(null);
        leftLeg.setIcon(null);
        rightLeg.setIcon(null);
        leftEye.setIcon(null);
        rightEye.setIcon(null);
        mouth.setIcon(null);
        lifeWarning.setIcon(null);
        answerChecker.setText(null);
        displayAnswer = "";
        fullWord = null;
        alphaList.clear();
        alphabetList();
        optionsLeft.setText(guessedLetters());
        readFile.resetLists(randomWord.randomlySelected());
        readFile.emptyUsedWords();
    }

    // Adds a piece of the hanging character each time the player guesses incorrectly.
    public void manBuilder() {

        if (userInput != null && continueBuilding) {

            if (lives == 9) {
                ImageIcon headd = new ImageIcon("images/sundayHead.png");
                head.setIcon(headd);
            } else if (lives == 8) {
                ImageIcon body = new ImageIcon("images/sundayBody.png");
                torso.setIcon(body);
            } else if (lives == 7) {
                ImageIcon leftArmm = new ImageIcon("images/sundayLeftArm.png");
                leftArm.setIcon(leftArmm);
            } else if (lives == 6) {
                ImageIcon rightArmm = new ImageIcon("images/sundayRightArm.png");
                rightArm.setIcon(rightArmm);
            } else if (lives == 5) {
                ImageIcon leftLegg = new ImageIcon("images/newLeftLeg.png");
                leftLeg.setIcon(leftLegg);
            } else if (lives == 4) {
                ImageIcon rightLegg = new ImageIcon("images/newRightLeg.png");
                rightLeg.setIcon(rightLegg);
            } else if (lives == 3) {
                ImageIcon leftEyee = new ImageIcon("images/sundayHeadoneX.png");
                leftEye.setIcon(leftEyee);
                head.setIcon(null);
            } else if (lives == 2) {
                ImageIcon rightEyee = new ImageIcon("images/sundayHeadtwoX.png");
                rightEye.setIcon(rightEyee);
                leftEye.setIcon(null);
            } else if (lives == 1) {
                ImageIcon mouthh = new ImageIcon("images/sundayHeadcompleteSet.png");
                mouth.setIcon(mouthh);
                rightEye.setIcon(null);
                ImageIcon lastLifeWarningg = new ImageIcon("images/newWarning.png");
                lifeWarning.setIcon(lastLifeWarningg);
            }
        }
    }

    // Checks if the user entered a valid input.
    public void inputChecker() {

        if (userInput.trim().length() != 1) {
            userInput = null;
        } else if (userInput.trim().length() == 1) {
            if (!alphabet.contains(userInput.trim().toUpperCase())) {
                userInput = null;
            }
        }
    }

    // Checks if the user should lose a life and updates the count.
    public void lifeAdjuster() {
        if (userInput != null && !randomWord.randomlySelected().toUpperCase().contains(userInput.toUpperCase().trim())) {
            lives--;
        }
        label_3.setText("Lives: " + lives);
    }

    // Returns the users input if it was valid and clears the textfield.
    public String userInfo() {
        if (beenUpdated) {
            holder = textField.getText();
            userInput = holder.trim();
            inputChecker();
            beenUpdated = false;
            textField.setText(null);
        }
        return userInput;
    }

    /*
     * Once the secret word is selected the characters will be replaced with empty spaces.
     * If the user guesses a letter from the secret word correctly, all instances of that letter
     * will be revealed in the appropriate spots.
     *
     * */
    public void wordBuilder() {

        if (userInput != null) {
            char userChar = userInput.trim().toLowerCase().charAt(0);
            if (astrix < randomWord.randomlySelected().length()) {
                for (astrix = 0; astrix < randomWord.randomlySelected().length(); astrix++) {
                    displayAnswer += " ";
                    builtWord = new StringBuilder(displayAnswer);
                }
                astrix = 100;
            }

            builtWord.setLength(displayAnswer.length());

            int position;
            for (position = 0; position < randomWord.randomlySelected().length(); position++) {

                if (randomWord.randomlySelected().charAt(position) == userChar) {
                    builtWord.setCharAt(position, userChar);
                }
            }
            fullWord = builtWord.toString().replaceAll("", " ");
            answerLabel.setText(fullWord);
        }
    }

    /*
     * Tracks and displays if the users input was invalid,
     * all ready guessed previously, correct or incorrect.
     *
     * */
    public void inputFeedback() {
        if (userInput != null) {
            if (!alphaList.contains(userInput.trim().toUpperCase().charAt(0))) {
                answerChecker.setIcon(null);
                answerChecker.setText("\"" + userInput.charAt(0) + "\"" + " was already guessed");
                continueBuilding = false;
            } else if (randomWord.randomlySelected().toUpperCase().contains(userInput.toUpperCase().trim()) && alphaList.contains(userInput.trim().toUpperCase().charAt(0))) {
                ImageIcon greenCheck = new ImageIcon("images/fixedGreenCheck.png");
                answerChecker.setIcon(greenCheck);
                answerChecker.setText("\"" + userInput + "\"" + " is correct ");
                guessedLetters();
                lifeAdjuster();
                continueBuilding = true;
            } else if (!randomWord.randomlySelected().toUpperCase().contains(userInput.toUpperCase().trim())) {
                ImageIcon redX = new ImageIcon("images/smallerX.png");
                answerChecker.setIcon(redX);
                answerChecker.setText("\"" + userInput + "\"" + " is not correct ");
                guessedLetters();
                lifeAdjuster();
                continueBuilding = true;
            }
        } else {
            answerChecker.setText("             Invalid Input");
            answerChecker.setIcon(null);
        }
    }

    /*
    * Eliminates words from the pool of potential selected words if they contain a letter the user guessed.
    * It will continue to remove words after each new guess from the list of words until one word remains.
    * The final word becomes the selected word.
    *
    * */
    public ArrayList<String> matchRemover() {

        if (userInput != null) {
            for (int traverseArray = readFile.getWordsList().size() - 1; traverseArray >= 0; traverseArray--) {
                if (readFile.getWordsList().size() <= 1) {
                    traverseArray = -1;
                } else if (readFile.getIndexWord(traverseArray).contains(userInfo().trim().toLowerCase())) {
                    readFile.setWordsList(readFile.deleteWord(readFile.getIndexWord(traverseArray)));
                }
            }
            randomWord.setTotalWords(readFile.getWordsList().size());
        }
        return readFile.getWordsList();
    }

    /*
     * Removes letters from the available letter bank after each guess.
     * After a letter is removed, the list is updated to only
     * display letters not yet guessed.
     *
     * */
    public void optionRemover(Character opt) {
        if (userInput != null) {
            if (alphaList.contains(userInput.trim().toUpperCase().charAt(0))) {
                int nullSetter = alphaList.indexOf(userInput.trim().toUpperCase().charAt(0));
                alphaList.remove(opt);
                alphaList.add(nullSetter, ' ');
                setAlphaList(alphaList);
            }
        }
    }

    /*
     * Checks the status of the game after each guess.
     * If the player won, the game state will be updated to "won" and the panel will be changed.
     * If the player lost, the game state will be updated to "lost" and the panel will be changed.
     *
     * */
    public void winChecker() {

        if (fullWord != null) {
            if (lives >= 0 && fullWord.replaceAll(" ", "").trim().equals(randomWord.randomlySelected())) {
                gameObject.setState(game.State.WON);
                gameObject.run();
            } else if (lives <= 0 && !fullWord.replaceAll(" ", "").trim().equals(randomWord.randomlySelected())) {
                gameObject.setState(game.State.LOST);
                gameObject.run();
            }
        } else if (lives == 0) {
            gameObject.setState(game.State.LOST);
            gameObject.run();
        }
    }

    // Returns and displays the updated list of unused guesses.
    public String guessedLetters() {
        if (userInput != null) {
            optionRemover(userInput.trim().toUpperCase().charAt(0));
        }
        return alphaList.toString().replaceAll("\\p{P}", "");
    }

    // Adds each letter of the alphabet to an array list.
    public void alphabetList() {
        for (int x = 0; alphaList.size() != 26; x++) {
            alphaList.add(alphabet.charAt(x));
        }
    }

    // Returns the "alphaList" array list containing the alphabet.
    public ArrayList<Character> getAlphaList() {
        return alphaList;
    }

    // Sets the "alphaList" array list containing the alphabet.
    public void setAlphaList(ArrayList<Character> NewAlpha) {
        this.alphaList = NewAlpha;
    }

    // Sets the start menus visibility to the given parameter.
    public void setStartMenu(boolean a) {
        startMenu.setVisible(a);
    }

    // Sets the game panels visibility to the given parameter.
    public void setGamePanel(boolean b) {
        gamePanel.setVisible(b);
    }

    // Sets the won panels visibility to the given parameter.
    public void setWonPanel(Boolean c) {
        wonPanel.setVisible(c);
    }

    // Sets the instruction panels visibility to the given parameter.
    public void setInstructionPanel(boolean d) {
        instructionPanel.setVisible(d);
    }

    // Sets the start menus visibility to the given parameter.
    public void setlostPanel(boolean e) {
        lostPanel.setVisible(e);
    }

    // Disposes the frame entered in the parameter.
    public void disposer(JFrame f) {
        f.dispose();
    }

    // Returns the frame.
    public JFrame getFrame() {
        return frame;
    }

    // Returns the "holder" variable.
    public String getHolder() {
        return holder;
    }

    // Sets the "holder" variable.
    public void setHolder(String z) {
        this.holder = z;
    }

    // Listens to the players actions and responds accordingly.
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == textField) {
            beenUpdated = true;
            userInfo();
            entireWord.setText("The word was: " + randomWord.randomlySelected());
            xentireWord.setText("The word was: " + randomWord.randomlySelected());
            matchRemover();
            randomWord.setWordsList(matchRemover());
            inputFeedback();
            optionsLeft.setText(guessedLetters());
            textField.setText(null);
            if (readFile.getWordsList().size() <= 1) {
                wordBuilder();
            }
            manBuilder();
            winChecker();
        } else if (e.getSource() == closeGame) {
            closeGame.removeActionListener(this);
            frame.dispose();
            System.exit(0);
        } else if (e.getSource() == restartGame) {
            restartGame();
        } else if (e.getSource() == start) {
            textField.removeActionListener(this);
            restartGame.removeActionListener(this);
            gameObject.setState(game.State.INTRO);
            gameObject.run();
        } else if (e.getSource() == gotIt) {
            restartGame.addActionListener(this);
            textField.addActionListener(this);
            textField.setText(null);
            gameObject.setState(game.State.RUNNING);
            gameObject.run();
        } else if (e.getSource() == exit) {
            frame.dispose();
            System.exit(0);
        } else if (e.getSource() == startOver) {
            gameObject.setState(game.State.RUNNING);
            gameObject.run();
            restartGame();
        } else if (e.getSource() == mainMenu) {
            restartGame();
            gameObject.setState(game.State.START);
            gameObject.run();
        } else if (e.getSource() == exit2) {
            frame.dispose();
            System.exit(0);
        } else if (e.getSource() == startOver2) {
            gameObject.setState(game.State.RUNNING);
            gameObject.run();
            restartGame();
        } else if (e.getSource() == mainMenu2) {
            restartGame();
            gameObject.setState(game.State.START);
            gameObject.run();
        }
    }
}
