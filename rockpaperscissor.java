import java.util.Random;

//backend of the game
public class rockpaperscissor {

    //choice for the computer to choose
    private static final String[] computerchoices = {"Rock", "Paper", "Scissor"};

    private String computerchoice;

    public int getPlayscore() {
        return playscore;
    }

    public int getCompsccore() {
        return compsccore;
    }

    public String getComputerchoice() {
        return computerchoice;
    }

    private int compsccore;
    private int playscore;

    //generates a random choice for the computer
    private Random random;

    //constructor to initialize
    rockpaperscissor() {
        random = new Random();
    }

    //this method return the result of the game
    public String result(String playerchoice) {
//generate computer choice
        computerchoice = computerchoices[random.nextInt(computerchoices.length)];

        String result;//contains the game result

        if (computerchoice.equals("Rock")) {
            if (playerchoice.equals("Rock")) {
                result = "Draw";
            } else if (playerchoice.equals("Paper")) {
                result = "Player Wins";
                playscore++;
            } else {
                result = "Computer Wins";
                compsccore++;
            }
        } else if (computerchoice.equals("Paper")) {
            if (playerchoice.equals("Rock")) {
                result = "Computer Wins";
                compsccore++;
            } else if (playerchoice.equals("Paper")) {
                result = "Draw";
            } else {
                result = "Player Wins";
                playscore++;
            }
        } else {
            if (playerchoice.equals("Rock")) {
                result = "Player Wins";
                playscore++;
            } else if (playerchoice.equals("Paper")) {
                result = "Computer Wins";
                compsccore++;
            } else {
                result = "Draw";
            }
        }
        return result;

    }


}
