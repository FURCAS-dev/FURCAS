package com.sap.mi.tools.cockpit.mql.ui.testers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.sap.mi.tools.cockpit.mql.ui.search.MQLCellData;

/**
 * @author d003456
 * 
 */
public class RemoteMriPropertyTester extends PropertyTester {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.expressions.IPropertyTester#test(java.lang.Object, java.lang.String, java.lang.Object[], java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		final ISelection selection = (ISelection) receiver;
		if (selection != null && !selection.isEmpty() && selection instanceof IStructuredSelection && "isRemoteMRI".equals(property)) { //$NON-NLS-1$
			final IStructuredSelection elements = (IStructuredSelection) selection;
			if (elements.getFirstElement() instanceof ArrayList) {
				final List<?> objs = (ArrayList<?>) elements.getFirstElement();
				if (objs.size() > 0 && objs.get(0) instanceof MQLCellData) {
					final List<MQLCellData> row = (List<MQLCellData>) objs;
					if (row != null && row.size() > 0 && row.get(0).isMRI() && row.get(0).isRemote()) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
