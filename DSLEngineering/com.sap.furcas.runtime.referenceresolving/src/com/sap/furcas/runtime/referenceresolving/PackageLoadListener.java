package com.sap.furcas.runtime.referenceresolving;

import com.sap.emf.bundlelistener.EcorePackageLoadListener;

public class PackageLoadListener implements EcorePackageLoadListener{

    @Override
    public void packageLoaded(String nsURI) {
       // Delegate. Cannot make the activator the listener directly, as we would end up
       // with two different instances of the Activator!
       Activator.getDefault().packageLoaded(nsURI);
    }

}
