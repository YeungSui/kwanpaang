package core.repository;

public class CompoundExpression implements Expression{
	public CompoundExpression and(Expression e) {
		return this;
	}
}
