public class game {

    private State currentState = State.CREATE;
    private static Display Master = new Display();

    // Default Constructor.
    public game(){
    }

    // Sets the state of the "currentState" variable.
    public void setState(State penn){
        this.currentState = penn;
    }

    /*
    * The game utilizes different states to display certain panels
    * and call specific methods at different instances.
    *
    * */
    public enum State
    {
        START, RUNNING, INTRO, WON, LOST, CREATE
    }

    /*
    * Runs the game and allows the player to traverse different stages / panels.
    * Each panel is created once the program is run alternating between being visible and not visible
    * depending on the players actions and progress.
    *
    * */
    public void run()
    {
        switch(currentState)
        {
            // Creates every panel at the start of the game.
            case CREATE:
                Master.menuPanel();
                Master.clearPanel();
                Master.gamePanel();
                Master.wonPanel();
                Master.lostPanel();
                Master.setInstructionPanel(false);
                Master.setWonPanel(false);
                Master.setGamePanel(false);
                Master.setlostPanel(false);
                setState(State.START);
                run();
                break;
            case START:
                // Sets the start menu visible.
                Master.setStartMenu(true);
                Master.setInstructionPanel(false);
                Master.setWonPanel(false);
                Master.setGamePanel(false);
                Master.setlostPanel(false);
                break;
            case INTRO:
                // Sets the instruction panel visible.
                Master.setInstructionPanel(true);
                Master.setGamePanel(true);
                Master.setlostPanel(false);
                Master.setWonPanel(false);
                Master.setStartMenu(false);
                break;
            case RUNNING:
                // Sets the main game panel visible.
                Master.setGamePanel(true);
                Master.setInstructionPanel(false);
                Master.setWonPanel(false);
                Master.setStartMenu(false);
                Master.setlostPanel(false);
                break;
            case WON:
                // Sets the won panel visible in the event the player wins.
                Master.setGamePanel(false);
                Master.setInstructionPanel(false);
                Master.setWonPanel(true);
                Master.setStartMenu(false);
                Master.setlostPanel(false);
                break;
            case LOST:
                // Sets the lost panel visible in the event the player wins.
                Master.setGamePanel(false);
                Master.setInstructionPanel(false);
                Master.setWonPanel(false);
                Master.setStartMenu(false);
                Master.setlostPanel(true);
                break;
            default:
                throw new RuntimeException("Unknown state: " + currentState);
        }
    }
}
