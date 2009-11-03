package com.sap.tc.moin.repository.test.metamodelchecker;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;

import org.junit.Test;

import com.sap.tc.moin.repository.ocl.notification.DeferredConstraintViolationStatusItem;

/**
 * Test the metamodel constraint checker within the check framework
 */

@SuppressWarnings( "nls" )
public class TestMetamodelConstraintChecker extends TestDefaultMetamodelChecker {

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
    }

    @Test
    public void testPackageInheritanceNotAllowed( ) {

        // we create a MOF package father and let inherit another one from it
        // this shouldn't be allowed
        MofPackage packageFather = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        packageFather.setName( "packageFather" );
        MofPackage packageChild = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        packageChild.setName( "packageChild" );
        modelPackage.getGeneralizes( ).add( packageFather, packageChild );
        checkOclViolation( "NoSupertypesAllowedForRoot", "Package Inheritance should be forbidden, but isn't: \"" + packageChild.getName( ) + "\" inherits from \"" + packageFather.getName( ) + "\"" );
        checkOclViolation( "NoSubtypesAllowedForLeaf", "Package Inheritance should be forbidden, but isn't: \"" + packageChild.getName( ) + "\" inherits from \"" + packageFather.getName( ) + "\"" );
    }

    @Test
    public void testStaticAttributesNotAllowed( ) {

        // we create a static attribute of a class
        // this shouldn't be allowed
        MofClass mofClass = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        mofClass.setName( "ClassWithStaticAttribute" );
        Attribute attribute = (Attribute) modelPackage.getAttribute( ).refCreateInstance( );
        attribute.setName( "staticAttribute" );
        attribute.setScope( ScopeKindEnum.CLASSIFIER_LEVEL );
        attribute.setContainer( mofClass );
        checkOclViolation( "AttributesMustNotBeStatic", "Static attributes should be forbidden, but aren't: \"" + attribute.getName( ) + "\" is a static attribute of class \"" + mofClass.getName( ) + "\"" );
    }

    @Test
    public void testDerivedAttributesNotAllowed( ) {

        // we create a derived attribute of a class
        // this shouldn't be allowed
        MofClass mofClass = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        mofClass.setName( "ClassWithDerivedAttribute" );
        Attribute attribute = (Attribute) modelPackage.getAttribute( ).refCreateInstance( );
        attribute.setName( "derivedAttribute" );
        attribute.setDerived( true );
        attribute.setContainer( mofClass );
        checkOclViolation( "AttributesMustNotBeDerived", "Derived attributes should be forbidden, but aren't: \"" + attribute.getName( ) + "\" is a derived attribute of class \"" + mofClass.getName( ) + "\"" );
    }

    @Test
    public void testDerivedAssociationsNotAllowed( ) {

        // we create a derived association
        // this shouldn't be allowed
        Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
        association.setName( "derivedAssociation" );
        association.setDerived( true );
        checkOclViolation( "AssociationsMustNotBeDerived", "Derived associations should be forbidden, but aren't: \"" + association.getName( ) + "\" is a derived association" );
    }

    private void checkOclViolation( String violationName, String message ) {

        checker.doCheck( getMOINConnection( ).getNullPartition( ) );
        boolean violationFound = false;
        List<DeferredConstraintViolationStatusItem> violationItems = checker.getConstraintViolationItems( );
        for ( DeferredConstraintViolationStatusItem violationItem : violationItems ) {
            if ( violationItem.getConstraintRegistration( ).getName( ).equals( violationName ) ) {
                violationFound = true;
            }
        }
        assertTrue( message, violationFound );
    }
}
