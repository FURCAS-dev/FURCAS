package com.sap.mi.tools.diagnostics.internal.model;

import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;

/**
 * Node that is present if Moin cannot be inspected (Jmx not enabled)
 * 
 * @author d031150
 */
public final class NoJmxDummyNode extends StructureNode {
	public NoJmxDummyNode() {
		super(null);
	}
	
	@Override
	public String getText() {
		return DiagnosticsMessages.NoJmxNode_jmxNotAvailable_label;
	}
}