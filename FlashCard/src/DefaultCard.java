public class DefaultCard {
    String question;
    String Answer;
    public DefaultCard(){
        this.question = "Question";
        this.Answer = "Answer";

    }
    public DefaultCard(String question, String answer) {
        this.question = question;
        Answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return Answer;
    }
}
