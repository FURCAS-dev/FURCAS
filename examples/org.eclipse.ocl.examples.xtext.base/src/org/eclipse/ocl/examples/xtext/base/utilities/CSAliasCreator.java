package org.eclipse.ocl.examples.xtext.base.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;

/**
 * A CSAliasCreator support creation of CS package aliases from CS package monikers.
 */
public class CSAliasCreator extends AliasAdapter.AbstractCreator
{
	public static CSAliasCreator INSTANCE = new CSAliasCreator();

	public static void refreshPackageAliases(Resource resource) {
		INSTANCE.refreshAliases(resource);
	}

	public String getAlias(EObject eObject) {
		if (eObject instanceof PackageCS) {
			PackageCS csPackage = (PackageCS)eObject;
			String moniker = csPackage.getMoniker();
			return moniker;
//			String nsPrefix = csPackage.getNsPrefix();
//			if (nsPrefix != null) {
//				return nsPrefix;
//			}
//			return csPackage.getName();
		}
		return null;
	}
}