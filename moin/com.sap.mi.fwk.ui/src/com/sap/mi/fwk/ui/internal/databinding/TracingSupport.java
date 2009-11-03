package com.sap.mi.fwk.ui.internal.databinding;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

public class TracingSupport {
	public static String getName(RefObject refObject) {
		if (refObject != null) {
			Object v = refObject.refGetValue("name"); //$NON-NLS-1$
			if (v instanceof String) {
				return (String) v;
			}
			v = refObject.refGetValue("id"); //$NON-NLS-1$
			if (v instanceof String) {
				return (String) v;
			}
		}
		return refObject.toString();
	}
}
