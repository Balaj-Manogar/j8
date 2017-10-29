package dto;

public class CreditEvaluator extends EvaluatorChain
{

    public CreditEvaluator(Evaluator nextEvaluator)
    {
        super(nextEvaluator);
    }

    @Override
    public boolean evaluate(Applicant applicant)
    {
        if (applicant.getCreditScore() > 600)
        {
            return super.evaluate(applicant);
        }
        return false;
    }
}
