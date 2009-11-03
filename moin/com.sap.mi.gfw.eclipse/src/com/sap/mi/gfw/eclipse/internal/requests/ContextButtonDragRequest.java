package com.sap.mi.gfw.eclipse.internal.requests;

import org.eclipse.gef.requests.CreateConnectionRequest;

import com.sap.mi.gfw.tb.ContextButtonEntry;

public class ContextButtonDragRequest extends CreateConnectionRequest {

	private ContextButtonEntry contextButtonEntry;

	public ContextButtonEntry getContextButtonEntry() {
		return contextButtonEntry;
	}

	public void setContextButtonEntry(ContextButtonEntry contextButtonEntry) {
		this.contextButtonEntry = contextButtonEntry;
	}

}
