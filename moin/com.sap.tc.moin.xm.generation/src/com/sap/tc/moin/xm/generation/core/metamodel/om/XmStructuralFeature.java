package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.StructuralFeature;

import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.metamodel.util.XmMofNameBuilder;

public abstract class XmStructuralFeature extends XmTypedElement {

    int lower;

    int upper;

    XmClassifier classifier;

    public XmStructuralFeature( final XmGeneratorInput input, final String xsdName, final XmClass containerClass, final int lower, final int upper, final XmClassifier classifier, final XmXsdComponentKind kind ) {

        super( input, xsdName, XmMofNameBuilder.buildMofFeatureName( xsdName ), containerClass, kind );
        this.lower = lower;
        this.upper = upper;
        this.classifier = classifier;
    }

    @Override
    public abstract StructuralFeature createModelElement( );

}
