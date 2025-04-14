import javax.swing.*;

public class app {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              gui rps=new gui();
              //set the visability
                rps.setVisible(true);
            }
        });
    }
}
