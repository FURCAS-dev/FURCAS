package com.sap.furcas.ide.editor.contentassist;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public interface ModelElementFactory {

    public EClass createMofClass();

    public EReference createReference();

    public EAttribute createAttribute();

}
