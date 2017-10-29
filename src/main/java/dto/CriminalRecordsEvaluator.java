package dto;

public class CriminalRecordsEvaluator extends EvaluatorChain
{

    public CriminalRecordsEvaluator(Evaluator nextEvaluator)
    {
        super(nextEvaluator);
    }

    @Override
    public boolean evaluate(Applicant applicant)
    {
        if (!applicant.hasCriminalRecords())
        {
            return super.evaluate(applicant);
        }
        return false;
    }
}
