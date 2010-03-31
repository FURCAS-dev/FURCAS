package com.sap.tc.moin.repository.test.core;

import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.DataType;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings( value = "nls" )
public class TestMofAttributeInitializer extends CoreMoinTest {

    private ModelPackage modelPackage = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        modelPackage = getMOINConnection( ).getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        modelPackage = null;
    }

    // Test of the initializer in the MOF metamodel
    @Test
    public void testAssociationEndIsNavigable( ) {

        // initial value of AssociationEnd.isNavigable is true
        AssociationEnd associationEnd = (AssociationEnd) modelPackage.getAssociationEnd( ).refCreateInstance( );
        assertTrue( "An association should be navigable, but it isn't.", associationEnd.isNavigable( ) );
    }

    @Test
    public void testGeneralizableElementIsRoot( ) {

        // initial value of Package.isRoot is true
        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        assertTrue( "A package should be root, but it isn't.", mofPackage.isRoot( ) );
        // initial value of DataType.isRoot is true
        DataType dataType = (DataType) modelPackage.getPrimitiveType( ).refCreateInstance( );
        assertTrue( "A data type should be root, but it isn't.", dataType.isRoot( ) );
        // initial value of Association.isRoot is true
        Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
        assertTrue( "An association should be root, but it isn't.", association.isRoot( ) );
        // initial value of Class.isRoot is true
        MofClass mofClass = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        assertFalse( "A class shouldn't be root, but it is.", mofClass.isRoot( ) );
    }

    @Test
    public void testGeneralizableElementIsLeaf( ) {

        // initial value of Package.isLeaf is true
        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        assertTrue( "A package should be leaf, but it isn't.", mofPackage.isLeaf( ) );
        // initial value of DataType.isLeaf is true
        DataType dataType = (DataType) modelPackage.getPrimitiveType( ).refCreateInstance( );
        assertTrue( "A data type should be leaf, but it isn't.", dataType.isLeaf( ) );
        // initial value of Association.isLeaf is true
        Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
        assertTrue( "An association should be leaf, but it isn't.", association.isLeaf( ) );
        // initial value of Class.isLeaf is true
        MofClass mofClass = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        assertFalse( "A class shouldn't be leaf, but it is.", mofClass.isLeaf( ) );
    }

    @Test
    public void testOperationIsQuery( ) {

        // initial value of Package.isRoot and Package.isLeaf is true
        MofPackage mofPackage = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        assertTrue( "A package should be root, but it isn't.", mofPackage.isRoot( ) );
        assertTrue( "A package should be leaf, but it isn't.", mofPackage.isLeaf( ) );
        // initial value of DataType.isRoot and DataType.isLeaf is true
        DataType dataType = (DataType) modelPackage.getPrimitiveType( ).refCreateInstance( );
        assertTrue( "A data type should be root, but it isn't.", dataType.isRoot( ) );
        assertTrue( "A data type should be leaf, but it isn't.", dataType.isLeaf( ) );
        // initial value of Association.isRoot and Association.isLeaf is true
        Association association = (Association) modelPackage.getAssociation( ).refCreateInstance( );
        assertTrue( "An association should be root, but it isn't.", association.isRoot( ) );
        assertTrue( "An association should be leaf, but it isn't.", association.isLeaf( ) );
        // initial value of Class.isRoot and Class.isLeaf is true
        MofClass mofClass = (MofClass) modelPackage.getMofClass( ).refCreateInstance( );
        assertFalse( "A class shouldn't be root, but it is.", mofClass.isRoot( ) );
        assertFalse( "A class shouldn't be leaf, but it is.", mofClass.isLeaf( ) );
        // initial value of Operation.isQuery is true
        Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
        assertTrue( "An operation should be queryable, but it isn't.", operation.isQuery( ) );
    }
}
