package com.sap.mi.gfw.eclipse.internal.platform;

import com.sap.mi.gfw.dt.IDiagramType;
import com.sap.mi.gfw.platform.AbstractGFWExtension;

public class GenericDiagramType extends AbstractGFWExtension implements IDiagramType {

	private final String id;

	private final String name;

	private final String description;

	public GenericDiagramType(String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
