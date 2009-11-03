package com.sap.tc.moin.xm.generation.core.metamodel.om;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;

import com.sap.tc.moin.xm.generation.XmGeneratorInput;
import com.sap.tc.moin.xm.generation.core.metamodel.util.XmMofNameBuilder;

public final class XmAssociation extends XmModelElementImpl {

    private final XmReference reference;

    private final String referencedEndName;

    private final String exposedEndName;

    XmAssociation( final XmGeneratorInput input, final String mofName, final XmReference reference, final XmPackage containerPackage, final XmXsdComponentKind kind ) {

        super( input, mofName, containerPackage, kind );
        this.reference = reference;
        // calculation or referenced end name
        // because the first character has been moved to lower case the resulting word could be a java key word
        this.referencedEndName = this.getNonJavaKeyWord( XmMofNameBuilder.convertFirstCharToLower( reference.getReferencedClass( ).getMofName( ) ) );

        // calculation of exposed end name
        this.exposedEndName = this.getNonJavaKeyWord( this.getUniqueEndName( XmMofNameBuilder.convertFirstCharToLower( this.reference.getContainerClass( ).getMofName( ) ), this.referencedEndName ) );
    }

    public String getReferencedEndName( ) {

        return this.referencedEndName;
    }



    public Association createModelElement( ) {

        if ( modelElement == null ) {

            final Reference mofReference = reference.createModelElement( );
            final MofClass referencedMofClass = reference.getReferencedClass( ).createModelElement( );
            final MofClass exposedMofClass = reference.getContainerClass( ).createModelElement( );

            final Association association = (Association) this.createClassInstance( Association.CLASS_DESCRIPTOR );
            association.setName( this.mofName );
            // TODO annotation
            association.setAnnotation( "" ); //$NON-NLS-1$ 
            association.setRoot( true );
            association.setLeaf( true );
            association.setAbstract( false );
            association.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            association.setDerived( false );
            modelElement = association;

            final AssociationEnd associationEndReferenced = (AssociationEnd) this.createClassInstance( AssociationEnd.CLASS_DESCRIPTOR, this.referencedEndName, this );
            associationEndReferenced.setName( this.referencedEndName );
            // TODO annotation
            associationEndReferenced.setAnnotation( "" ); //$NON-NLS-1$
            associationEndReferenced.setNavigable( true );
            associationEndReferenced.setAggregation( AggregationKindEnum.NONE );
            associationEndReferenced.setMultiplicity( mofReference.getMultiplicity( ) );
            associationEndReferenced.setChangeable( true );
            associationEndReferenced.setContainer( (Namespace) modelElement );

            mofReference.setReferencedEnd( associationEndReferenced );
            associationEndReferenced.setType( referencedMofClass );

            final MultiplicityType exposedMultiplicity;
            if ( reference.getReferencedClass( ).getXsdComponentKind( ) == XmXsdComponentKind.LocalElement ) {
                exposedMultiplicity = createMultiplicityType( 1, 1, false, false );
            } else {
                exposedMultiplicity = createMultiplicityType( 0, 1, false, false );
            }

            final AssociationEnd associationEndExposed = (AssociationEnd) this.createClassInstance( AssociationEnd.CLASS_DESCRIPTOR, this.exposedEndName, this );
            associationEndExposed.setName( this.exposedEndName );
            // TODO annotation
            associationEndExposed.setAnnotation( "" ); //$NON-NLS-1$
            associationEndExposed.setNavigable( true );
            // always composite 
            associationEndExposed.setAggregation( AggregationKindEnum.COMPOSITE );
            associationEndExposed.setMultiplicity( exposedMultiplicity );
            associationEndExposed.setChangeable( true );
            associationEndExposed.setContainer( (Namespace) modelElement );
            associationEndExposed.setType( exposedMofClass );
        }
        return (Association) modelElement;
    }

    /**
     * Returns an end name which is different from the other end name.
     * 
     * @param proposedName
     * @return end name
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    private String getUniqueEndName( final String proposedName, final String otherEndName ) {

        if ( proposedName == null ) {
            throw new NullPointerException( "proposedName is null" ); //$NON-NLS-1$
        }
        if ( otherEndName == null ) {
            throw new NullPointerException( "otherEndName is null" ); //$NON-NLS-1$
        }
        if ( !proposedName.equals( otherEndName ) ) {
            return proposedName;
        } else {
            return proposedName + "Parent"; //$NON-NLS-1$
        }
    }

    /**
     * Adds to the proposed name "End" if the proposed name is a java key word.
     * Otherwise the proposed name is returned.
     * 
     * @param proposedName
     * @return non java key word
     */
    private String getNonJavaKeyWord( final String proposedName ) {

        if ( XmMofNameBuilder.isJavaKeyWord( proposedName ) ) {
            return proposedName + "End"; //$NON-NLS-1$
        } else {
            return proposedName;
        }
    }

}
