package org.launchcode.quiz;

import org.launchcode.quiz.assignment.AlgebraProblemSet;
import org.launchcode.quiz.question.CheckboxQuestion;
import org.launchcode.quiz.question.MultipleChoiceQuestion;
import org.launchcode.quiz.question.ShortAnswerQuestion;
import org.launchcode.quiz.question.TrueFalseQuestion;

/**
 * Created by Chris Bay
 */
public class Main {

    public static void main(String[] args) {

        Student student = new Student("Jane");

        AlgebraProblemSet algebraQuiz = new AlgebraProblemSet();
        student.addAssignment(algebraQuiz);

        algebraQuiz.addQuestion(new ShortAnswerQuestion("Simplify the expression   -(5x - 7) +2 ", "\n" +
                "−5x+9"));
        algebraQuiz.addQuestion(new TrueFalseQuestion("x-3 and -3x are unlike terms.", true));

        String[] mcChoices = {"0", "2", "3", "5"};
        algebraQuiz.addQuestion(new MultipleChoiceQuestion("What is the coefficient of x in 2x+3?", mcChoices, 1));

        String[] cbChoices = {"6", "42", "7", "2"};
        int[] cbAnswers = {2, 3};
        algebraQuiz.addQuestion(new CheckboxQuestion("Which of the following are prime numbers?", cbChoices, cbAnswers));

        algebraQuiz.runAlgebraProblemSet();

        double studentGrade = student.calculateGrade();

        System.out.println("The overall grade for " + student.getName() + " is " + studentGrade);
    }

}
