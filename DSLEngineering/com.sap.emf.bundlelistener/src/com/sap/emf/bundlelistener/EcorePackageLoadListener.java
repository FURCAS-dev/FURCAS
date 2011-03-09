package com.sap.emf.bundlelistener;

import org.eclipse.emf.ecore.EPackage;
import org.osgi.framework.Bundle;

/**
 * Callback interface notifying the listener about the loading of an {@link EPackage} that
 * happened by means of loading its containing OSGi {@link Bundle}.
 * 
 * @author Axel Uhl (d043530)
 *
 */
public interface EcorePackageLoadListener {
    void packageLoaded(EPackage pkg);
}
