import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//frontend
public class gui extends JFrame implements ActionListener{
//invokes jframe and add title to it
JButton rock,paper,scissor;

//will display the choice of the computer
    JLabel choice;

    //will display the score
JLabel label1,player;

//backend object
rockpaperscissor rps;

    gui() {
        setTitle("Rock Paper Scissor GAME");
        //setting the size  of gui
        setSize(450, 574);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //loads the gui in the centre of the screen every time when we run the application
        setLocationRelativeTo(null);

        //initialize the backend object
        rps=new rockpaperscissor();

        // adding gui components
        addcomponents();
    }

    private void addcomponents() {
        //computer score label
        label1=new JLabel("Computer:0");
        label1.setBounds(0,43,450,30);
        //add the component
        add(label1);
        //font
        label1.setFont(new Font("Dialog",Font.BOLD,26));
        //placing the text in the center
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        //add the computers choice
        choice=new JLabel("?");
        choice.setBounds(175,118,98,81);
        choice.setFont(new Font("Dialog",Font.PLAIN,18));
        add(choice);
        choice.setHorizontalAlignment(SwingConstants.CENTER);
        //add a border to it
        choice.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //add the player
        player=new JLabel("Player: 0");
        player.setBounds(0,317,450,30);
        add(player);
        player.setFont(new Font("Dialog",Font.BOLD,26));
        player.setHorizontalAlignment(SwingConstants.CENTER);

        //add the game options
        rock=new JButton("Rock");
        rock.setBounds(40,387,105,81);
        rock.setFont(new Font("Dialog",Font.PLAIN,18));
        rock.addActionListener(this);
        add(rock);
        rock.setFocusable(false);

        paper=new JButton("Paper");
        paper.setBounds(165,387,105,81);
        paper.setFont(new Font("Dialog",Font.PLAIN,18));
        paper.addActionListener(this);
        add(paper);
        paper.setFocusable(false);

        scissor=new JButton("Scissor");
        scissor.setBounds(290,387,105,81);
        scissor.setFont(new Font("Dialog",Font.PLAIN,18));
        scissor.addActionListener(this);
        add(scissor);
        scissor.setFocusable(false);

    }
//message box to display the winner and the try again option
    private void displayoutput(String message){
    JDialog result =new JDialog(this,"Result",true);
    result.setSize(227,124);
    result.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    result.setResizable(false);

    //message in the dialog box
        JLabel resultlabel=new JLabel(message);
        resultlabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultlabel.setHorizontalAlignment(SwingConstants.CENTER);
        result.add(resultlabel,BorderLayout.CENTER);

        //try again button
        JButton tryagain=new JButton("Try Again?");
        tryagain.setFocusable(false);
        tryagain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              //reset the computer choice
                choice.setText("?");

              //dispose the dialog box to press the buttons again
                result.dispose();
            }
        });
        result.add(tryagain,BorderLayout.SOUTH);
        result.setLocationRelativeTo(this);
        result.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get player choice
        String playerchoice=e.getActionCommand().toString();

        //play rock paper scissor and store result into string var
        String result=rps.result(playerchoice);

        //load computers choice
        choice.setText(rps.getComputerchoice());

        //update the score
        label1.setText("Computer:"+rps.getCompsccore());
        player.setText("Player:"+rps.getPlayscore());

        //display the result in the dialog box
        displayoutput(result);
    }
}
