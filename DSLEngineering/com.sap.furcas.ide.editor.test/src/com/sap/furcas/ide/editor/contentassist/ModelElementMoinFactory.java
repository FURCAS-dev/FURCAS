package com.sap.furcas.ide.editor.contentassist;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class ModelElementMoinFactory implements ModelElementFactory {

    private final ResourceSet connection;

    public ModelElementMoinFactory(ResourceSet connection) {
        this.connection = connection;
    }

    protected ResourceSet getConnection() {
        return connection;
    }

    @Override
    public EClass createMofClass() {
        return EcoreFactory.eINSTANCE.createEClass();
    }

    @Override
    public EAttribute createAttribute() {
        return EcoreFactory.eINSTANCE.createEAttribute();
    }

    @Override
    public EReference createReference() {
        return EcoreFactory.eINSTANCE.createEReference();
    }

}
