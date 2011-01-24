package org.eclipse.ocl.examples.xtext.base.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;

/**
 * A CS2PivotAliasCreator support creation of pivot package aliases from CS package monikers.
 */
public class CS2PivotAliasCreator extends CSAliasCreator
{
	public static CS2PivotAliasCreator INSTANCE = new CS2PivotAliasCreator();

	public static void refreshPackageAliases(Resource resource) {
		INSTANCE.refreshAliases(resource);
	}

	@Override
	public EObject getAliasTarget(EObject eObject) {
		return ((ModelElementCS)eObject).getPivot();
	}
}