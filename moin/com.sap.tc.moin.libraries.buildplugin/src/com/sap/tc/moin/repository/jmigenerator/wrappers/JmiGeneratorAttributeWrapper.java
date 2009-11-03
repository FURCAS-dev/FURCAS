package com.sap.tc.moin.repository.jmigenerator.wrappers;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorMofType;

/**
 * The Attribute wrapper
 */
public class JmiGeneratorAttributeWrapper extends JmiGeneratorStructuralFeatureWrapper {

    private final AttributeInternal wrappedAttribute;

    private final String variableName;

    private final Boolean isDerived;

    private final Boolean isObjectTyped;

    /**
     * @param attribute
     * @param parent
     * @param generator
     */
    public JmiGeneratorAttributeWrapper( CoreConnection connection, String metamodelName, Attribute attribute, JmiGeneratorBaseWrapper parent, JmiGeneratorImpl generator ) {

        super( connection, metamodelName, attribute, parent, generator );
        this.wrappedAttribute = (AttributeInternal) attribute;
        this.isDerived = Boolean.valueOf( this.wrappedAttribute.isDerived( ) );
        this.variableName = composeVariableName( getJMIIdentifier( ) );
        this.isObjectTyped = Boolean.valueOf( this.wrappedAttribute.getType( connection ) instanceof MofClass );
    }

    @Override
    public String getJavaType( ) {

        return getAttributeType( this.wrappedAttribute );
    }

    /**
     * @return true if the attribute is derived
     */
    public Boolean isDerived( ) {

        return this.isDerived;
    }

    /**
     * @return true if the attribute is object types (i.e. not primitive)
     */
    public Boolean isObjectTyped( ) {

        return this.isObjectTyped;
    }

    /**
     * @return the variable name with which this attribute is backed
     */
    public String getVariableName( ) {

        return this.variableName;
    }

    @Override
    public JmiGeneratorMofType getMofType( ) {

        return JmiGeneratorMofType.ATTRIBUTE;
    }

    @Override
    public String getJavaClassName( JmiGenerationKind genKind, boolean qualified ) {

        return getAttributeType( this.wrappedAttribute );
    }

    /**
     * @return the MofID
     */
    public String getAttributeMofId( ) {

        return this.wrappedAttribute.refMofId( );
    }

    /**
     * @return the number of the "To"-End
     */
    public int getToEndNumber( ) {

        return getJmiHelper( ).getAttributeToEndNumber( (Attribute) this.wrappedAttribute );
    }

    public boolean isSingleValuedNonObjectTyped( ) {

        return !isMultiple( ) && !isObjectTyped;
    }
}
