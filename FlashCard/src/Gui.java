import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

class guiButton extends JPanel implements ActionListener {
    int count = 0;
    boolean first = false;
    JLabel question, rightWrong;
    JLabel picture = new JLabel();
    JButton next, addCardButton, useDefault, sort, search;
    JRadioButton b1,b2,b3;
    ArrayList <ImageCard> A = new ArrayList<ImageCard>();
    ArrayList<DefaultCard> DefaultDeck = new ArrayList<DefaultCard>();

    public guiButton(ArrayList <ImageCard> A, ArrayList<DefaultCard> DefaultDeck) {
        setLayout(new BoxLayout (this, BoxLayout.PAGE_AXIS));

        this.A = A;
        this.DefaultDeck = DefaultDeck;
        setBackground(Color.white);
        question = new JLabel("");
        rightWrong = new JLabel("");
        rightWrong.setFont(new Font("Helvetica", Font.PLAIN,30));



        add(question);
        add(rightWrong);

        picture.setPreferredSize(new Dimension(200, 200));
        add(picture);


        next = new JButton("START");
        next.setBackground(Color.blue);

        addCardButton = new JButton("ADD");
        addCardButton.setBackground(Color.red);

        useDefault = new JButton("USE OTHER");
        useDefault.setBackground(Color.orange);

        sort = new JButton("SORT");
        sort.setBackground(Color.yellow);


        search = new JButton("SEARCH FOR A CHAR");
        search.setBackground(Color.green);

        b1 = new JRadioButton();
        b2 = new JRadioButton();
        b3 = new JRadioButton();


        add(next);
        add(addCardButton);
        add(useDefault);
        add(sort);
        add(search);

        add(b1);
        add(b2);
        add(b3);


        next.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        addCardButton.addActionListener(this);
        useDefault.addActionListener(this);
        sort.addActionListener(this);
        search.addActionListener(this);

        setPreferredSize(new Dimension(500, 500));
    }

    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();



        //Next Button**************************************
        if(source == next) {
            if(first) {
                count++;
            }
            if (count == A.size()) {
                count = 0;
            }
            next.setText("NEXT");
            question.setText(A.get(count).getQuestion());
            rightWrong.setText("");
            b1.setSelected(false);
            b2.setSelected(false);
            b3.setSelected(false);

            picture.setIcon(A.get(count).getCardIcon());
            b1.setText(A.get(count).getC1());
            b2.setText(A.get(count).getC2());
            b3.setText(A.get(count).getC3());

            first = true;
        }

        //*************************************************

        //Radio Buttons************************************
        if(source == b1){
            b2.setSelected(false);
            b3.setSelected(false);

            if(A.get(count).getAnswerChoice() == 1){
                rightWrong.setText("Right");
            }
            else{
                rightWrong.setText("wrong");
            }
        }
        if(source == b2){
            b1.setSelected(false);
            b3.setSelected(false);

            if(A.get(count).getAnswerChoice() == 2){
                rightWrong.setText("Right");
            }
            else{
                rightWrong.setText("wrong");
            }
        }
        if(source == b3){
            b1.setSelected(false);
            b2.setSelected(false);

            if(A.get(count).getAnswerChoice() == 3){
                rightWrong.setText("Right");
            }
            else{
                rightWrong.setText("wrong");
            }
        }
        //************************************************

        //Add Card Button ********************************
        if(source == addCardButton){
            int again;
            String Question, Answer;

            do {
                Question = JOptionPane.showInputDialog("Enter Your Question");
                Answer = JOptionPane.showInputDialog("Enter Your Answer");

                again = JOptionPane.showConfirmDialog(null, "Do Another?");

                DefaultDeck.add(new DefaultCard(Question, Answer));
            }
            while(again == JOptionPane.YES_OPTION);
            }

        //Use Default Deck *******************************
        if(source == useDefault) {
            int again;
            int dCount = 0;
            do {
                if (dCount == DefaultDeck.size()) {
                    dCount = 0;
                }
                String userAnswer = JOptionPane.showInputDialog(DefaultDeck.get(dCount).getQuestion());
                if (userAnswer.toUpperCase().equals(DefaultDeck.get(dCount).getAnswer().toUpperCase())) {
                    JOptionPane.showMessageDialog(null, "Right");

                } else {
                    JOptionPane.showMessageDialog(null, "Wrong!!!");

                }
                dCount++;
                again = JOptionPane.showConfirmDialog(null, "Do Another One?");
            }

            while (again == JOptionPane.YES_OPTION);
        }
        //*************************************************

        // Sort Button ************************************
        if(source == sort) {
            //Sorts based on answer choice, if the same, then sorts based on Question
            Collections.sort(A);
        }
        //*************************************************

        // Search Button **********************************


        if(source == search){
            int Index = 0;
            String searchStr = JOptionPane.showInputDialog("Enter your search char");
            char searchChar = searchStr.charAt(0);

            for (int i = 0; i < A.size(); i++) {
                ImageCard imageCard = new ImageCard();
                imageCard = A.get(i);
                if (find(imageCard.getQuestion(), searchChar)) {
                    Index++;
                }
            }
            JOptionPane.showMessageDialog(null,"That char was found: "+Index+" times in the deck");

        }
        }


    public static boolean find(String S, char c) {
        if (S == "") {
            return false;
        } else if (S.length() == 1) {
            return (S.charAt(0) == c);
        } else {
            return ((S.charAt(0) == c) || find(S.substring(1), c));
        }
    }

    }



public class Gui {
    public static void main(String[] args)
    {
        ArrayList <ImageCard> A = new ArrayList<ImageCard>();
        ArrayList<DefaultCard> DefaultDeck = new ArrayList<DefaultCard>();

        ImageCard firstCard = new ImageCard("What is this?","giraffe","tree","rock",new ImageIcon("giraffe.jpg"),1);
        ImageCard SecondCard = new ImageCard("What is the name of this?","Lion","Ruler of the Internet","Tiger",new ImageIcon("kitten.jpg"),2);
        ImageCard thirdCard = new ImageCard("What is this animal?","Wolf","Tree","Puppy",new ImageIcon("puppy.jpg"),3);
        ImageCard fourCard = new ImageCard("What is this?","かさ","じんじゃ","みせ",new ImageIcon("umbrella.jpg"),1);


        ImageCard fiveCard = new ImageCard("What is this?","A small Palm Tree","A Vegetable","The Perfect Pizza Topping",new ImageIcon("pineapple2.jpg"),3);


        A.add(firstCard);
        A.add(SecondCard);
        A.add(thirdCard);
        A.add(fourCard);
        A.add(fiveCard);

        DefaultCard defaultCard = new DefaultCard("Test Question","Test");

        DefaultDeck.add(defaultCard);

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiButton P = new guiButton(A,DefaultDeck);

        frame.getContentPane().add(P);
        frame.pack();
        frame.setVisible(true);
    }

}
