package com.sap.tc.moin.repository.jmigenerator.wrappers;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;

/**
 * The Reference wrapper
 */
public class JmiGeneratorReferenceWrapper extends JmiGeneratorStructuralFeatureWrapper {

    private final ReferenceInternal wrappedReference;

    private final Boolean exposesEnd0;

    private final Boolean bothEndsChangeable;

    private final Boolean associationIsDerived;

    /**
     * @param reference
     * @param parent
     * @param generator
     */
    public JmiGeneratorReferenceWrapper( CoreConnection connection, String metamodelName, Reference reference, JmiGeneratorBaseWrapper parent, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, reference, parent, generator );
        this.wrappedReference = (ReferenceInternal) reference;

        AssociationEndInternal associationEnd = (AssociationEndInternal) this.wrappedReference.getReferencedEnd( connection );
        AssociationInternal association = (AssociationInternal) associationEnd.getContainer( connection );

        JmiGeneratorAssociationWrapper assocWrapper = (JmiGeneratorAssociationWrapper) getOrCreateWrapper( association );

        AssociationEnd associationEnd0 = assocWrapper.getEnd0( );
        AssociationEnd associationEnd1 = assocWrapper.getEnd1( );

        this.exposesEnd0 = Boolean.valueOf( associationEnd.getName( ).equals( associationEnd0.getName( ) ) );
        this.bothEndsChangeable = Boolean.valueOf( associationEnd0.isChangeable( ) && associationEnd1.isChangeable( ) );
        this.associationIsDerived = Boolean.valueOf( association.isDerived( ) );

    }

    /**
     * @return true if end0 is exposed
     */
    public Boolean exposesEnd0( ) {

        return this.exposesEnd0;

    }

    /**
     * @return true if the exposed association is derived
     */
    public Boolean associationIsDerived( ) {

        return this.associationIsDerived;
    }

    /**
     * @return true if both ends are changeable
     */
    public Boolean bothEndsChangeable( ) {

        return this.bothEndsChangeable;

    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.REFERENCE;
    }

    @Override
    public String getJavaType( ) {

        return getReferenceType( this.wrappedReference );
    }

    @Override
    public String getJavaClassName( JmiGenerationKind genKind, boolean qualified ) {

        return getReferenceType( this.wrappedReference );
    }

    public String getAssociationMofId( ) {

        return ( (AssociationEndInternal) this.wrappedReference.getReferencedEnd( connection ) ).getContainer( connection ).refMofId( );
    }

    public int getReferencedAssociationEndNumber( ) {

        return getJmiHelper( ).getAssociationEndNumber( this.connection.getSession( ), this.wrappedReference.getReferencedEnd( connection ) );
    }

    public String getReferenceMofId( ) {

        return this.wrappedReference.refMofId( );
    }

}
