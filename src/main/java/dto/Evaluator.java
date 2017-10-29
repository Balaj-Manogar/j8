
/**
 *
 * Example of builder pattern
 *
 */


package dto;

public interface Evaluator
{
    boolean evaluate(Applicant applicant);
}

class EvaluatorChain implements Evaluator
{
    private Evaluator nextEvaluator;

    public EvaluatorChain(Evaluator nextEvaluator)
    {
        this.nextEvaluator = nextEvaluator;
    }

    @Override
    public boolean evaluate(Applicant applicant)
    {
        return nextEvaluator.evaluate(applicant);
    }
}


