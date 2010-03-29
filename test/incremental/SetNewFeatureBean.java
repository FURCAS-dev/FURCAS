package com.sap.ide.cts.parser.incremental;

import tcs.Property;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class SetNewFeatureBean {

	public final RefObject parentRefObject;
	public final String property;
	public final Object value;
	public final int valueIndex;
	public Property tcs_Property;

	public SetNewFeatureBean(RefObject parentRefObject, String property, Object value,
		int valueIndex, Property tcs_Property) {
		this.parentRefObject = parentRefObject;
		this.property = property;
		this.value = value;
		this.valueIndex = valueIndex;
		this.tcs_Property = tcs_Property;

	}

	public SetNewFeatureBean(RefObject parentRefObject, String property, Object value,
		int valueIndex) {
		this.parentRefObject = parentRefObject;
		this.property = property;
		this.value = value;
		this.valueIndex = valueIndex;
	}

}
