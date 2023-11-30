import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame implements ActionListener {

    //Initialize the components
    JLabel mainLabel;
    JButton playButton;
    JButton instructionsButton;

    //Initialize the constructor
    WelcomePage(){
        //Initialize first panel and add main label
        mainLabel = newLabel("Welcome to the Number Guessing Game!", 25);
        JPanel panel1 = newPanel();
        panel1.add(mainLabel);

        //Initialize the second panel and add buttons
        playButton = newButton("Play");
        instructionsButton = newButton("Instructions");
        JPanel panel2 = newPanel();
        panel2.add(playButton);
        panel2.add(instructionsButton);


        //Add the panels to the frame and customize it
        add(panel1);
        add(panel2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    //Method to make and customize a new button
    private JButton newButton(String text){
        JButton button = new JButton(text);
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setFont(new Font(null, Font.BOLD, 20));
        button.setFocusable(false);
        button.addActionListener(this);
        return button;
    }

    //Method to make and customize a new panel
    private JPanel newPanel(){
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        panel.setOpaque(true);
        panel.setLayout(new FlowLayout());
        return panel;
    }

    //Method to make and customize a new label
    private JLabel newLabel(String text, int size){
        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setFont(new Font(null, Font.PLAIN, size));
        label.setText(text);
        return label;
    }

    //Action Performed Method
    @Override
    public void actionPerformed(ActionEvent e) {

        //If playButton is pressed
        if (e.getSource() == playButton){
            new NumberGuesser();
            dispose();

        } else if (e.getSource() == instructionsButton) {
            //If instructionsButton is pressed
            new Instructions();
            dispose();
        }
    }
}