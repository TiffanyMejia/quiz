package org.launchcode.quiz.assignment;

import org.launchcode.quiz.question.AbstractQuestion;

import java.util.ArrayList;
import java.util.Scanner;

public class AlgebraProblemSet implements Gradeable {

    private final ArrayList<AbstractQuestion> questions = new ArrayList<AbstractQuestion>();
    private int pointTotal = 0;
    private int userScore = 0;

    public AlgebraProblemSet() { }
    public AlgebraProblemSet(ArrayList<AbstractQuestion> questions) {
        this.questions.addAll(questions);
        for (AbstractQuestion question : this.questions) {
            this.pointTotal += question.getPointValue();
        }
    }

    public void addQuestion(AbstractQuestion question) {
        this.questions.add(question);
        this.pointTotal += question.getPointValue();
    }

    public void runAlgebraProblemSet() {
        System.out.println("This is your homework. There are " + this.questions.size() + "." + " Each question is worth " + this.pointTotal + ". Have fun and good luck.");

        Scanner input = new Scanner(System.in);

        int currentQuestionNum = 1;
        for (AbstractQuestion question : this.questions) {
            System.out.print("\n" + currentQuestionNum + ". ");
            question.displayQuestion();
            question.collectResponse(input);
            this.userScore += question.gradeResponse();
            currentQuestionNum++;

        }

        input.close();

        System.out.println("\nYour score: " + this.userScore + "/" + this.pointTotal + " (" + this.getDisplayScorePercentage() + ")");
    }


    @Override
    public int getPointTotal() {
        return pointTotal;
    }

    @Override
    public int getUserScore() {
        return userScore;
    }

    public double getScorePercentage() {
        return (double) this.userScore / (double) this.pointTotal;
    }

    @Override
    public String getDisplayScorePercentage() {
        double pct = this.getScorePercentage();
        long pctScore = Math.round(pct * 100);
        return pctScore + "%";
    }

}
