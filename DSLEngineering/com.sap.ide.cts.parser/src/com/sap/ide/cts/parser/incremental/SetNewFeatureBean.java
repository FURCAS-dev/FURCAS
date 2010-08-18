package com.sap.ide.cts.parser.incremental;

import org.eclipse.emf.ecore.EObject;


public class SetNewFeatureBean {

	public final EObject parentRefObject;
	public final String property;
	public final Object value;
	public final int valueIndex;

	public SetNewFeatureBean(EObject parentRefObject, String property,
			Object value, int valueIndex) {
		this.parentRefObject = parentRefObject;
		this.property = property;
		this.value = value;
		this.valueIndex = valueIndex;
	}

}
