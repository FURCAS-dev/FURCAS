package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import com.sap.tc.moin.xm.generation.XmGeneratorInput;


public final class XmAttribute extends XmStructuralFeature {



    private final boolean changeable;


    public XmAttribute( final XmGeneratorInput input, final String xsdName, final XmClass containerClass, final int lower, final int upper, final XmClassifier classifier, final boolean changeable, final XmXsdComponentKind kind ) {

        super( input, xsdName, containerClass, lower, upper, classifier, kind );
        this.changeable = changeable;
    }

    @Override
    public Attribute createModelElement( ) {

        if ( modelElement == null ) {
            final Attribute attribute = (Attribute) this.createClassInstance( Attribute.CLASS_DESCRIPTOR );
            attribute.setName( mofName );
            //TODO annotation
            attribute.setAnnotation( "" ); //$NON-NLS-1$
            attribute.setScope( ScopeKindEnum.INSTANCE_LEVEL );
            attribute.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            attribute.setMultiplicity( this.createMultiplicityType( lower, upper, false, false ) );
            attribute.setChangeable( changeable );
            attribute.setDerived( false );
            modelElement = attribute;
            attribute.setType( classifier.createModelElement( ) );
        }
        return (Attribute) modelElement;
    }
}
