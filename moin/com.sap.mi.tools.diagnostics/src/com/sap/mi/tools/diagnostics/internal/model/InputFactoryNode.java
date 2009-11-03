package com.sap.mi.tools.diagnostics.internal.model;


public class InputFactoryNode extends DelegateNode {

	public InputFactoryNode(DelegateNode parent, String className) {
		super(parent, className);
	}

	@Override
	public String getText() {
		return (String) getDelegate();
	}
}
