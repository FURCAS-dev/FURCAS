package com.sap.ide.cts.parser.incremental;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class SetNewFeatureBean {

	public final RefObject parentRefObject;
	public final String property;
	public final Object value;
	public final int valueIndex;

	public SetNewFeatureBean(RefObject parentRefObject, String property,
			Object value, int valueIndex) {
		this.parentRefObject = parentRefObject;
		this.property = property;
		this.value = value;
		this.valueIndex = valueIndex;
	}

}
