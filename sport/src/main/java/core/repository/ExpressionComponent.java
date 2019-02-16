package core.repository;

public class ExpressionComponent implements Expression{
	private Class entityClass;
	private String field;
	private String operation;
	private String value;
	
	public ExpressionComponent(Class entityClass, String field, String operation, String value) {
		this.entityClass = entityClass;
		this.field = field;
		this.operation = operation;
		this.value = value;
	}
}
