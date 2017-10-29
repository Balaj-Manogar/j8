package java8;

import java.util.function.Predicate;

import dto.Applicant;
import dto.*;

public class EvaluatorDemo
{
    public static void evaluate(Applicant applicant, Evaluator evaluator)
    {
        String result = evaluator.evaluate(applicant) ? "accepted" : "rejected";
        System.out.println("Applicant status: " + result);
    }

    public static void evaluate(Applicant applicant, Predicate<Applicant> evaluator)
    {
        String result = evaluator.test(applicant) ? "accepted" : "rejected";
        System.out.println("Applicant status: " + result);
    }

    public static void evaluateImperativeStyle()
    {
        Applicant applicant = new Applicant();
        evaluate(applicant, new CreditEvaluator(new QualifiedEvaluator()));
        evaluate(applicant, new EmploymentEvaluator(new QualifiedEvaluator()));
        evaluate(applicant, new CriminalRecordsEvaluator(new EmploymentEvaluator(new QualifiedEvaluator())));

    }

    public static void evaluateFunctionalStyle()
    {
        System.out.println("====================================");
        System.out.println("\tFunctional Style");
        System.out.println("====================================");

        Applicant applicant =  new Applicant();
        Predicate<Applicant> isCredible = Applicant::isCredible;
        Predicate<Applicant> hasGoodCredit = applicant1 -> applicant1.getCreditScore() > 600;
        Predicate<Applicant> isEmployed = applicant2 -> applicant2.getEmploymentYears() > 0;
        Predicate<Applicant> hasCriminalRecords = Applicant::hasCriminalRecords;
        Predicate<Applicant> hasNoCriminalRecords = hasCriminalRecords.negate();

        evaluate(applicant, isCredible.and(hasGoodCredit));
        evaluate(applicant, isCredible.and(isEmployed));
        evaluate(applicant, isCredible.and(isEmployed).and(hasNoCriminalRecords));
    }


    public static void main(String[] args)
    {
        evaluateImperativeStyle();
        evaluateFunctionalStyle();
    }
}
