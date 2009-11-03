package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import com.sap.tc.moin.xm.generation.XmGeneratorInput;

public final class XmReference extends XmStructuralFeature {


    private final XmClass referencedClass;

    private final XmClass containerClass;

    private final boolean isUnique;

    private final XmAssociation association;


    public XmReference( final XmGeneratorInput input, final String name, final XmClass containerClass, final int lower, final int upper, final XmClass referencedClass, final XmXsdComponentKind kind ) {

        super( input, name, containerClass, lower, upper, referencedClass, kind );
        this.referencedClass = referencedClass;
        this.containerClass = containerClass;

        if ( upper != 1 ) {
            isUnique = true;
        } else {
            isUnique = false;
        }

        // create association
        String associationName = containerClass.getMofName( ) + "_" + referencedClass.getMofName( ); //$NON-NLS-1$
        if ( containerClass.getPackage( ).getSetWithUniqueMofElements( ).contains( associationName ) ) {
            // the association name is already contained in the package --> add the reference name, if the current name does not yet end with the reference name          
            if ( !associationName.endsWith( this.getMofName( ) ) ) {
                associationName = associationName + "_" + this.getMofName( ); //$NON-NLS-1$
            }
        }
        this.association = new XmAssociation( input, associationName, this, containerClass.getPackage( ), XmXsdComponentKind.Undefined );
    }

    public XmClass getContainerClass( ) {

        return containerClass;
    }

    public XmClass getReferencedClass( ) {

        return referencedClass;
    }

    public XmAssociation getAssociation( ) {

        return this.association;
    }

    @Override
    public Reference createModelElement( ) {

        if ( modelElement == null ) {

            boolean isOrdered = false;
            if ( upper > lower && upper > 1 ) {
                isOrdered = true;
            } else if ( upper == -1 ) {
                // upper is unbounded
                isOrdered = true;
            }
            final Reference reference = (Reference) this.createClassInstance( Reference.CLASS_DESCRIPTOR );
            reference.setName( mofName );
            //TODO annotation
            reference.setAnnotation( "" ); //$NON-NLS-1$
            reference.setScope( ScopeKindEnum.INSTANCE_LEVEL );
            reference.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            reference.setMultiplicity( this.createMultiplicityType( lower, upper, isOrdered, isUnique ) );
            reference.setChangeable( true );
            reference.setType( referencedClass.createModelElement( ) );
            modelElement = reference;
        }
        return (Reference) modelElement;
    }

}
