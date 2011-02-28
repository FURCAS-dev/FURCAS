package com.sap.furcas.ide.dslproject.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

public class BuildHelper {
    public static boolean isModelProject(IProject project) {
	return true;
    }

    public static ResourceSet getResourceSetForProject(IProject project) {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
        resourceSet.eAdapters().add(new Adapter() {
            
            @Override
            public void setTarget(Notifier newTarget) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public void notifyChanged(Notification notification) {
                // TODO Auto-generated method stub
                
            }
            
            @Override
            public boolean isAdapterForType(Object type) {
                // TODO Auto-generated method stub
                return false;
            }
            
            @Override
            public Notifier getTarget() {
                // TODO Auto-generated method stub
                return null;
            }
        });
        return resourceSet;
    }
}
