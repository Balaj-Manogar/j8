package dto;

public class EmploymentEvaluator extends EvaluatorChain
{

    public EmploymentEvaluator(Evaluator nextEvaluator)
    {
        super(nextEvaluator);
    }

    @Override
    public boolean evaluate(Applicant applicant)
    {
        if (applicant.getEmploymentYears() > 0)
        {
            return super.evaluate(applicant);
        }
        return false;
    }
}
