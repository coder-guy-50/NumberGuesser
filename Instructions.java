import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Instructions extends JFrame implements ActionListener {

    //Initialize the button
    JButton backButton;

    //Initialize the constructor
    Instructions(){
        //Initialize and customize the label and add it to the frame
        JLabel label = new JLabel("<html>You have 10 turns to guess the number.<br> Enter a number and a hint will be provided <br> to tell you whether your guess is greater <br> or less than the actual number. The earlier <br> you guess the number the greater will be your score.</html>");
        label.setFont(new Font(null, Font.PLAIN, 20));
        label.setForeground(Color.WHITE);
        add(label);

        //Initialize and customize the button and add it to the frame
        backButton = new JButton("Back");
        backButton.setBackground(Color.BLUE);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font(null, Font.BOLD, 20));
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        add(backButton);


        //Customize the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
        setLayout(new FlowLayout());
        setResizable(false);
        setSize(500, 250);
        setLocationRelativeTo(null);
    }

    //Action Performed Method
    @Override
    public void actionPerformed(ActionEvent e) {
        new WelcomePage();
        dispose();
    }
}