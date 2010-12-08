package com.sap.furcas.ide.projectwizard.util;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.provider.EcoreItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

/**
 * Used for displaying the model tree on the {@link}ClassChooserPage.
 * 
 * @author Frederik Petersen (D054528)
 * 
 */
public class MNComposedAdapterFactory {
    private static ComposedAdapterFactory mnCompAdapterFactory;

    public final static ComposedAdapterFactory getAdapterFactory() {
        if (mnCompAdapterFactory == null)
            mnCompAdapterFactory = new ComposedAdapterFactory(createFactoryList());
        return mnCompAdapterFactory;
    }

    public final static ArrayList<AdapterFactory> createFactoryList() {
        ArrayList<AdapterFactory> factories = new ArrayList<AdapterFactory>();
        factories.add(new ResourceItemProviderAdapterFactory());
        factories.add(new EcoreItemProviderAdapterFactory());
        factories.add(new ReflectiveItemProviderAdapterFactory());
        return factories;
    }
}
