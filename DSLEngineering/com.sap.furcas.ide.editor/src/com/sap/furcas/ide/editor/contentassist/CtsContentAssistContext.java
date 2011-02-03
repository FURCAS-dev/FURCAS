/**
 * 
 */
package com.sap.furcas.ide.editor.contentassist;

import java.util.Stack;

import org.antlr.runtime.Token;

import com.sap.furcas.metamodel.FURCAS.TCS.FunctionCall;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;

public class CtsContentAssistContext {
	private Stack<FunctionCall> parentFunctionCallStack;
	private Stack<Property> parentPropertyStack;

	/**
	 * stack of parent ClassTemplates and OperatorTemplates
	 */
	private Stack<Template> parentTemplateStack;

	private SequenceElement sequenceElement;
	private Token token;
	private boolean isErrorContext;

	private boolean isOperator;

	public boolean isOperator() {
		return isOperator;
	}

	public void setOperator(boolean isOperator) {
		this.isOperator = isOperator;
	}

	public boolean isErrorContext() {
		return isErrorContext;
	}

	public void setErrorContext(boolean isErrorContext) {
		this.isErrorContext = isErrorContext;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public Token getToken() {
		return token;
	}

	public void setParentFunctionCallStack(
			Stack<FunctionCall> parentFunctionCallStack) {
		this.parentFunctionCallStack = parentFunctionCallStack;
	}

	public Stack<FunctionCall> getParentFunctionCallStack() {
		return parentFunctionCallStack;
	}

	public SequenceElement getSequenceElement() {
		return sequenceElement;
	}

	public void setSequenceElement(SequenceElement sequenceElement) {
		this.sequenceElement = sequenceElement;

	}

	@Override
	public String toString() {
		return token.getText();
	}

	public Stack<Property> getParentPropertyStack() {
		return parentPropertyStack;
	}

	public void setParentPropertyStack(Stack<Property> parentPropertyStack) {
		this.parentPropertyStack = parentPropertyStack;
	}

	public Stack<Template> getParentTemplateStack() {
		return parentTemplateStack;
	}

	public void setParentTemplateStack(Stack<Template> parentTemplateStack) {
		this.parentTemplateStack = parentTemplateStack;
	}
}