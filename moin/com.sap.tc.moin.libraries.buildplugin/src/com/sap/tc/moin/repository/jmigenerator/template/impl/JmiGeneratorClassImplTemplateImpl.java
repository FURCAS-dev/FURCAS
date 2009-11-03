package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndInternal;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAttributeDeclaration;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassImplTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorFeature;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorTypedElementInitialization;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;
import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * The Class implementation
 */
public class JmiGeneratorClassImplTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorClassImplTemplate {

    private final JmiGeneratorClassWrapper myClassWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorClassImplTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.CLASS );
        this.myClassWrapper = wrapper;
    }

    public List<JmiGeneratorFeature> getFeatures( ) {

        return this.myClassWrapper.getFeatures( this.genKind, false );
    }

    public List<String> getFeatureIds( ) {

        return this.myClassWrapper.getFeatureIds( this.genKind, false );
    }

    public List<String> getOperationIds( ) {

        return this.myClassWrapper.getOperationIds( this.genKind, false );
    }

    public int getFeatureIdsMapCapacity( ) {

        return Utilities.calcInitialCapacity( getFeatureIds( ).size( ) );
    }

    public int getOperationIdsMapCapacity( ) {

        Iterator<ModelElement> contents = myClassWrapper.getAllContent( );
        int operations = 0;
        for ( ; contents.hasNext( ); ) {
            Object obj = contents.next( );
            if ( obj instanceof Operation ) {
                operations++;
            }
        }
        return Utilities.calcInitialCapacity( operations );
    }

    public List<JmiGeneratorClassOperation> getAttributeOperations( ) {

        return this.myClassWrapper.getAttributeOperations( this.genKind, false );
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myClassWrapper.getOperations( this.genKind, false );
    }

    public List<JmiGeneratorClassOperation> getReferenceOperations( ) {

        return this.myClassWrapper.getReferenceOperations( this.genKind );
    }

    public List<JmiGeneratorAttributeDeclaration> getAttributeDeclarations( ) {

        return this.myClassWrapper.getAttributeDeclarations( this.genKind, false );
    }

    public List<JmiGeneratorTypedElementInitialization> getAttributeInitializations( ) {

        return this.myClassWrapper.getAttributeInitializations( this.genKind, false );
    }

    public JmiGeneratorClassInterfaceTemplate getInterface( ) {

        return (JmiGeneratorClassInterfaceTemplate) this.myClassWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "ClassInterface" ); //$NON-NLS-1$
    }

    public Boolean isAbstract( ) {

        return Boolean.valueOf( this.myClassWrapper.isAbstract( ) );
    }

    public List<JmiGeneratorFeature> getInternalSetterFeatures( ) {

        return this.myClassWrapper.getInternalSetterFeatures( this.genKind, false );
    }

    public List<JmiGeneratorClassOperation> getInternalModeledOperations( ) {

        return this.myClassWrapper.getInternalModeledOperations( this.genKind, false );
    }

    public JmiGeneratorBaseTemplate getWrapper( ) {

        if ( !this.myClassWrapper.isAbstract( ) ) {
            return this.myClassWrapper.getJavaTemplate( JmiGenerationKind.WRAPPER, "ClassWrapper" ); //$NON-NLS-1$
        }
        return null;
    }

    public Boolean isNeedsNonFinal( ) {

        if ( getPackageName( ).equals( "com.sap.tc.moin.repository.mmi.model.__impl" ) ) { //$NON-NLS-1$
            if ( getJavaName( ).equals( "AssociationImpl" ) || getJavaName( ).equals( "AssociationEndImpl" ) ) { //$NON-NLS-1$  //$NON-NLS-2$
                // All implementation classes should be final, except for com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl and
                // com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl (which have specialized subclasses for the MofRom case).
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public Map<String, String> getMultiplicityOneLinkVariables( ) {

        return getVariableNamesForAssociationLinks( myClassWrapper.getConnection( ), myClassWrapper.getStoredAssociationEndsMultiplicityOne( ) );
    }

    public Map<String, String> getMultiplicityManyLinkVariables( ) {

        return getVariableNamesForAssociationLinks( myClassWrapper.getConnection( ), myClassWrapper.getStoredAssociationEndsMultiplicityMany( ) );
    }

    public Map<String, String> getMultiplicityOneAttributeLinkVariables( ) {

        return getVariableNamesForAttributeLinks( myClassWrapper.getObjectValuedAttributesMultiplicityOne( ) );
    }

    public Map<String, String> getMultiplicityManyAttributeLinkVariables( ) {

        return getVariableNamesForAttributeLinks( myClassWrapper.getObjectValuedAttributesMultiplicityMany( ) );
    }

    private Map<String, String> getVariableNamesForAssociationLinks( CoreConnection connection, Set<AssociationEnd> ends ) {

        Map<String, String> result = new TreeMap<String, String>( );
        for ( AssociationEnd assocEnd : ends ) {
            AssociationEndInternal end = (AssociationEndInternal) assocEnd;
            result.put( end.refMofId( ), "__" + end.getContainer( connection ).getName( ) + "_" + end.getName( ) + "_" + end.refMofId( ) ); //$NON-NLS-1$  //$NON-NLS-2$ //$NON-NLS-3$
        }
        return result;
    }

    private Map<String, String> getVariableNamesForAttributeLinks( List<Attribute> attributes ) {

        Map<String, String> result = new TreeMap<String, String>( );
        for ( Attribute attr : attributes ) {
            result.put( attr.refMofId( ), "__" + attr.getName( ) ); //$NON-NLS-1$
        }
        return result;
    }

    public boolean isHasLinkVariables( ) {

        return getMultiplicityOneLinkVariables( ).size( ) + getMultiplicityManyLinkVariables( ).size( ) + getMultiplicityOneAttributeLinkVariables( ).size( ) + getMultiplicityManyAttributeLinkVariables( ).size( ) > 0;
    }
}