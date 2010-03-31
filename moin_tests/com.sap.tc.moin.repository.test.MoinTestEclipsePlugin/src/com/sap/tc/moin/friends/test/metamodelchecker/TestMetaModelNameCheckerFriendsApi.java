package com.sap.tc.moin.friends.test.metamodelchecker;

import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;

import org.junit.Test;

import com.sap.tc.moin.MoinPackage;
import com.sap.tc.moin.friends.MetaModelChecker;
import com.sap.tc.moin.friends.factory.UtilitiesFactory;
import com.sap.tc.moin.friends.test.MoinFriendsBaseTest;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.NameViolation;
import com.sap.tc.moin.repository.NameViolation.NameViolationErrorCode;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;

/**
 * Test the metamodel name checker of the MOIN API
 */
@SuppressWarnings( "nls" )
public class TestMetaModelNameCheckerFriendsApi extends MoinFriendsBaseTest {

    private MetaModelChecker checker = null;

    private ModelPackage modelPackage = null;

    private MultiplicityType multiplicity1To1 = null;

    @Override
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        checker = UtilitiesFactory.getMetaModelChecker( );
        MoinPackage moinPackage = (MoinPackage) getMOINConnection( ).getPackage( null, new String[] { "MOIN" } );
        modelPackage = moinPackage.getModel( );
        MultiplicityType.Descriptors desc = MultiplicityType.DESCRIPTORS;
        StructureFieldContainer<MultiplicityType> container = new StructureFieldContainer<MultiplicityType>( );
        container.put( desc.LOWER( ), 1 ).put( desc.UPPER( ), 1 ).put( desc.IS_ORDERED( ), false ).put( desc.IS_UNIQUE( ), false );
        multiplicity1To1 = modelPackage.createMultiplicityType( container );
    }

    @Override
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        checker = null;
        modelPackage = null;
        multiplicity1To1 = null;
    }

    @Test
    public void testUniqueMoinModelElementNameStringsInNamespace( ) {

        // we test uniqueness in an Operation (i.e. in a Namespace)
        // an operation with a parameter with multiplicity 1
        Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
        operation.setName( "validName" );
        Parameter parameter = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
        parameter.setName( "uniqueName" );
        parameter.setMultiplicity( multiplicity1To1 );
        operation.getContents( ).add( parameter );

        // check whether another new parameter with the same name is possible
        NameViolation violation = checker.checkModelElementName( getMOINConnection( ), operation, "uniqueName" );
        // the name is not unique in the namespace of the operation
        String vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name should be non unique, but it is: uniqueName - " + vMsg, violation != null );
        NameViolationErrorCode errorCode = violation.getErrorCode( );
        assertTrue( "Error code should be " + NameViolationErrorCode.NAME_EXISTS_IN_NAMESPACE + ", but it is " + errorCode, errorCode == NameViolationErrorCode.NAME_EXISTS_IN_NAMESPACE );
    }

    @Test
    public void testUniqueMoinModelElementNamesInNamespace( ) {

        // we test uniqueness in an Operation (i.e. in a Namespace)
        // an operation with a parameter with multiplicity 1
        Operation operation = (Operation) modelPackage.getOperation( ).refCreateInstance( );
        operation.setName( "validName" );
        Parameter parameter = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
        parameter.setName( "uniqueName" );
        parameter.setMultiplicity( multiplicity1To1 );
        operation.getContents( ).add( parameter );

        // existing parameter does not conflict with itself
        NameViolation violation = checker.checkModelElementName( getMOINConnection( ), operation, parameter );
        String vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name conflicts with itself, but it should not: uniqueName - " + vMsg, violation == null );

        // we add another parameter with the same name
        Parameter parameter2 = (Parameter) modelPackage.getParameter( ).refCreateInstance( );
        parameter2.setName( "uniqueName" );
        parameter2.setMultiplicity( multiplicity1To1 );
        operation.getContents( ).add( parameter2 );

        // the name is not unique in the namespace of the operation
        violation = checker.checkModelElementName( getMOINConnection( ), operation, parameter2 );
        vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name should be non unique, but it is: uniqueName - " + vMsg, violation != null );
        NameViolationErrorCode errorCode = violation.getErrorCode( );
        assertTrue( "Error code should be " + NameViolationErrorCode.NAME_EXISTS_IN_NAMESPACE + ", but it is " + errorCode, errorCode == NameViolationErrorCode.NAME_EXISTS_IN_NAMESPACE );
    }

    @Test
    public void testUniqueToplevelPackageNamesInContainerWithinOnePartition( ) throws Exception {

        // we test uniqueness of toplevel packages in a container with one single partition
        // create one toplevel package in a partition
        CRI partitionCri = getPartitionOne( ).getPri( ).getCri( );
        MofPackage samePackage1 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage1.setName( "samePackage" );
        getPartitionOne( ).assignElement( samePackage1 );
        // now check the partition, the package name is unique
        NameViolation violation = checker.checkToplevelPackageName( getMOINConnection( ), partitionCri, samePackage1 );
        String vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name should be unique, but it isn't: samePackage - " + vMsg, violation == null );

        // check that the creation of a package with the same name would not be possible
        violation = checker.checkToplevelPackageName( getMOINConnection( ), partitionCri, "samePackage", null );
        vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name should be non unique, but it is: samePackage - " + vMsg, violation != null );
        NameViolationErrorCode errorCode = violation.getErrorCode( );
        assertTrue( "Error code should be " + NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE + ", but it is " + errorCode, errorCode == NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE );

        // create a second toplevel package with the same name and add it to the partition
        MofPackage samePackage2 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage2.setName( "samePackage" );
        getPartitionOne( ).assignElement( samePackage2 );
        // now check the partition, the package name is not unique anymore in the container
        violation = checker.checkToplevelPackageName( getMOINConnection( ), partitionCri, samePackage2 );
        vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name should be non unique, but it is: samePackage - " + vMsg, violation != null );
        errorCode = violation.getErrorCode( );
        assertTrue( "Error code should be " + NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE + ", but it is " + errorCode, errorCode == NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE );
    }

    @Test
    public void testUniqueToplevelPackageNamesInContainerWithinTwoPartitions( ) throws Exception {

        // we test uniqueness of toplevel packages in a container with two separate partitions
        // create one toplevel package in a partition
        CRI partition1Cri = getPartitionOne( ).getPri( ).getCri( );
        MofPackage samePackage1 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage1.setName( "samePackage" );
        getPartitionOne( ).assignElement( samePackage1 );
        // now check the partition, the package name is unique
        NameViolation violation = checker.checkToplevelPackageName( getMOINConnection( ), partition1Cri, samePackage1 );
        String vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name should be unique, but it isn't: samePackage - " + vMsg, violation == null );

        // create another toplevel package in another partition with the same name as the package in the first partition
        CRI partition2Cri = getPartitionTwo( ).getPri( ).getCri( );
        MofPackage samePackage2 = (MofPackage) modelPackage.getMofPackage( ).refCreateInstance( );
        samePackage2.setName( "samePackage" );
        getPartitionTwo( ).assignElement( samePackage2 );
        // now check the second partition, the package name is not unique anymore in the container
        violation = checker.checkToplevelPackageName( getMOINConnection( ), partition2Cri, samePackage2 );
        vMsg = ( violation != null ) ? violation.getDescription( ) : null;
        assertTrue( "Name should be non unique, but it is: samePackage - " + vMsg, violation != null );
        NameViolationErrorCode errorCode = violation.getErrorCode( );
        assertTrue( "Error code should be " + NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE + ", but it is " + errorCode, errorCode == NameViolationErrorCode.PACKAGE_NAME_EXISTS_IN_NAMESPACE );
    }
}
