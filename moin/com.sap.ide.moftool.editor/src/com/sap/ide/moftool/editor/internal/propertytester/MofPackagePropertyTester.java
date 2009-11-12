package com.sap.ide.moftool.editor.internal.propertytester;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import org.eclipse.core.expressions.PropertyTester;

public class MofPackagePropertyTester extends PropertyTester {

	private static final String PROP_HAS_PARENT = "hasParent"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof MofPackage && expectedValue instanceof Boolean) {
			if ( property.equals(PROP_HAS_PARENT)) {
				return (((MofPackage) receiver).getContainer() != null) == ((Boolean) expectedValue).booleanValue();
			}
		}
		return false;
	}

}
