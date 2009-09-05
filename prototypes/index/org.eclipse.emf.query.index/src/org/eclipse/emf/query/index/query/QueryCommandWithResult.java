package org.eclipse.emf.query.index.query;

public abstract class QueryCommandWithResult<T> implements QueryCommand {

	private T _result;

	protected void setResult(T result) {
		this._result = result;
	}

	public T getResult() {
		return this._result;
	}

}
