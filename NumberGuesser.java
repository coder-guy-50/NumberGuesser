import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuesser extends JFrame implements ActionListener {

    //Initialize counter to track tries remaining
    private int counter;
    //Initialize score
    private int score;
    //Generate a random number
    static int randomNumber = (int) (Math.random()*101);
    //Initialize the components
    private JLabel mainLabel;
    private JLabel hintLabel;
    private JLabel triesLabel;
    JButton guessButton;
    JButton exitButton;
    JTextField guessField;

    //Initialize the constructor
    NumberGuesser(){
        //Set the counter and the score
        counter = 10;
        score = 1000;

        //Initialize the first panel and add the labels
        mainLabel = newLabel("Guess The Number!", 50);
        hintLabel = newLabel("Enter a number to receive a hint.", 30);
        triesLabel = newLabel("Tries Remaining: " + counter, 28);
        JPanel panel1 = newPanel();
        panel1.add(mainLabel);
        panel1.add(hintLabel);
        panel1.add(triesLabel);

        //Initialize the second panel and add the text field
        JPanel panel2 = newPanel();
        guessField = new JTextField(5);
        guessField.setForeground(Color.WHITE);
        guessField.setForeground(Color.BLACK);
        guessField.setFont(new Font(null, Font.PLAIN, 20));
        panel2.add(guessField);

        //Initialize the third panel and add the buttons
        guessButton = newButton("Guess");
        exitButton = newButton("Exit");
        JPanel panel3 = newPanel();
        panel3.add(guessButton);
        panel3.add(exitButton);


        //Add the panels to the frame and customize the frames
        add(panel1);
        add(panel2);
        add(panel3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        setSize(new Dimension(600, 500));
        setLocationRelativeTo(null);
        setResizable(false);

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

    //Action Performed method
    @Override
    public void actionPerformed(ActionEvent e) {

        //Check if guessButton is pressed
        if(e.getSource() == guessButton){

            //Check if tries are remaining
            if (counter > 1) {

                //Check if user input is a number
                try {

                    int userGuess = Integer.parseInt(guessField.getText());

                    //Check if guess is within the range
                    if (userGuess >= 0 && userGuess <= 100) {

                        //Check if guess is correct
                        if (userGuess == randomNumber) {

                            hintLabel.setText("That's the correct number!");
                            guessButton.setEnabled(false);
                            exitButton.setEnabled(false);
                            Timer timer = new Timer(1000, e1 -> {
                                dispose();
                                JOptionPane.showMessageDialog(null, "Congratulations You Won! Your score is " + score, "You Win", JOptionPane.INFORMATION_MESSAGE);
                            });
                            timer.setRepeats(false);
                            timer.start();

                        } else if (userGuess > randomNumber) {
                            //If guess is larger than the actual number
                            hintLabel.setText("That number is too large...");
                            score-=100;  //Decrease the score by 100

                        } else if (userGuess < randomNumber) {
                            //If guess is smaller than the actual number
                            hintLabel.setText("That number is too small...");
                            score-=100;  //Decrease the score by 100

                        }

                        //Decrement the counter
                        counter--;

                    } else {
                        //If guess is out of range
                        hintLabel.setText("Please enter a number between 0 and 100");

                    }

                } catch (NumberFormatException e1) {
                    //If input is not a valid number
                    hintLabel.setText("Please enter a valid number!");
                }

                //Update the label to show tries remaining
                triesLabel.setText("Tries Remaining: " + counter);

            } else {
                //If no tries left
                dispose();
                JOptionPane.showMessageDialog(null, "No tries left. Please play again.", "No tries left", JOptionPane.ERROR_MESSAGE);

            }
        } else if (e.getSource() == exitButton) {
            //If exitButton is pressed
            dispose();
        }
    }
}
