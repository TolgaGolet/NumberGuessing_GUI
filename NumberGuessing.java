package numberguessing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class NumberGuessing extends JFrame {
    
    private JLabel resultLabel;
    private JButton biggerButton;
    private JButton smallerButton;
    private JButton correctButton;
    
    static int guess=50, max=101, min=0, steps=0;
    
     public class biggerPressed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            steps++;
            if(steps>6) {
                guess=50;
                max=101;
                min=0;
                resultLabel.setText("YOU ARE CHEATING!");
                return;  
            }
            min=guess;
            guess=(guess+max)/2;
            resultLabel.setText("(0-100)Guess is: "+guess);
        }
        
    }
     
     public class smallerPressed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            steps++;
            if(steps>6) {
                guess=50;
                max=101;
                min=0;
                resultLabel.setText("YOU ARE CHEATING!");
                return;  
            }
            max=guess;
            guess=(min+guess)/2;
            resultLabel.setText("(0-100)Guess is: "+guess);
        }
        
    }
     
    public class correctPressed implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            steps=0;
            guess=50;
            max=101;
            min=0;
            resultLabel.setText("Reset!(0-100)Guess is: "+guess);
        }
        
    }
    
    public NumberGuessing() {
        setLayout(new FlowLayout());
        
        resultLabel=new JLabel("(0-100)Guess is: 50");
        biggerButton=new JButton("Bigger");
        smallerButton=new JButton("Smaller");
        correctButton=new JButton("Correct!");
        
        biggerButton.addActionListener(new biggerPressed());
        smallerButton.addActionListener(new smallerPressed());
        correctButton.addActionListener(new correctPressed());
        
        add(resultLabel);
        add(biggerButton);
        add(smallerButton);
        add(correctButton);
    }
    
    public static void main(String[] args) {
        NumberGuessing gui=new NumberGuessing();
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setSize(500, 200);
        gui.setVisible(true);
        gui.setTitle("Number Guessing");
        gui.setLocation(700, 300);
    }
    
}
