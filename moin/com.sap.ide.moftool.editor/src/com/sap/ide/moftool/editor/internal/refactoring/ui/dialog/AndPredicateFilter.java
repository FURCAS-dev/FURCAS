package com.sap.ide.moftool.editor.internal.refactoring.ui.dialog;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

public class AndPredicateFilter implements IPackageFilterCallback{
	
	private final IPackageFilterCallback second;
	private final IPackageFilterCallback first;

	public AndPredicateFilter(IPackageFilterCallback first, IPackageFilterCallback second) {
		this.first = first;
		this.second = second;
	}

	public boolean matches(MofPackage object) {
		return first.matches(object) && second.matches(object);
	}

}
