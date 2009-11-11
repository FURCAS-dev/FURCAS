package com.sap.ide.moftool.editor.core.service;

import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;

public final class PackageService {

	/**
	 * Returns the root package (the top level {@link MofPackage}) of the given {@link ModelElement}.
	 * If the given element is null or there is no top level package <code>null</code> is
	 * returned.
	 * @param element The element to get the root package for.
	 * @return The root package of <code>null</code> in case it could not be found.
	 */
	public static MofPackage getRootPackage(ModelElement element) {
		if (element == null) {
			return null;
		}
		else if (element.getContainer() != null) {
			return getRootPackage(element.getContainer());
		}
		else if (element instanceof MofPackage) {
			return (MofPackage)element;
		}
		return null;
	}
}
