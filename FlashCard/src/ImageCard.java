import javax.swing.*;

public class ImageCard extends DefaultCard implements Comparable<ImageCard>{
    ImageIcon cardIcon;
    Integer answerChoice;
    String c1, c2, c3;

    public ImageCard() {
    }

    public ImageCard(ImageIcon cardIcon){
        this.cardIcon = cardIcon;
    }
    public ImageCard(String question, String c1, String c2, String c3, ImageIcon cardIcon, int answerChoice) {
        super(question, "Default Answer");
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
        this.cardIcon = cardIcon;
        this.answerChoice = answerChoice;
    }

    public ImageIcon getCardIcon() {
        return cardIcon;
    }

    public int getAnswerChoice() {
        return answerChoice;
    }

    public String getC1() {
        return c1;
    }

    public String getC2() {
        return c2;
    }

    public String getC3() {
        return c3;
    }

    public int compareTo(ImageCard I) {
        int answerChoiceComp =answerChoice.compareTo(I.getAnswerChoice());

        if (answerChoiceComp==0){
            if(question.compareTo(I.getQuestion()) == 0 ) {
                return 0;
            }
            else if(question.compareTo(I.getQuestion()) > 0){
                return 1;
            }
            return -1;
        }
        return answerChoiceComp;

    }
}
