package com.sap.mi.tools.mmdeploy.internal.view;

import org.eclipse.core.expressions.PropertyTester;

/**
 * A property tester for working set nodes. See plugin.xml for its usage.
 * 
 * @author d031150
 */
public final class MmWorkingSetNodeTester extends PropertyTester {

	/**
	 * A property indicating whether the working set node is the "Others" node.
	 */
	public static final String PROPERTY_IS_OTHERS = "isOthers"; //$NON-NLS-1$

	public MmWorkingSetNodeTester() {
	}

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (PROPERTY_IS_OTHERS.equals(property)) {
			if (receiver instanceof MmWorkingSetNode) {
				MmWorkingSetNode node = (MmWorkingSetNode) receiver;
				if (Boolean.valueOf(node.isOthers()).equals(expectedValue)) {
					return true;
				}
			}
		}
		return false;
	}

}
