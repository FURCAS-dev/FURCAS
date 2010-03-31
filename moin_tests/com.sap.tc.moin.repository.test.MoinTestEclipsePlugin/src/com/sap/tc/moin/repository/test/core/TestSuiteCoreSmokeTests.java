/*
 * Created on 07.03.2006
 */
package com.sap.tc.moin.repository.test.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.sap.junit.MoinSuite;
import com.sap.tc.moin.repository.test.commands.TestSuiteAllCommandsTests;
import com.sap.tc.moin.repository.test.errorhandler.TestSuiteAllErrorHandlersTest;
import com.sap.tc.moin.repository.test.jmigenerator.standalone.TestGenerateMoinMetamodelsStandaloneSmoke;
import com.sap.tc.moin.repository.test.metamodelchecker.TestSuiteAllMetamodelCheckerTests;
import com.sap.tc.moin.repository.test.persistence.TestPartitionChangeRecorder;
import com.sap.tc.moin.repository.test.transactions.TestSuiteAllTransactionsTest;

/**
 * @author d037271
 */

@RunWith( MoinSuite.class )
@Suite.SuiteClasses( {
    TestBasics.class,
    TestCalculatedMofIds.class,
    TestConnectionAndSession.class,
    TestCompositionHierarchyTraversal.class,
    TestLinks.class,
    TestMofElement.class,
    TestMofRom.class,
    TestMofRomOclInjection.class,
    TestModeledOperations.class,
    TestMofAttributeInitializer.class,
    TestSuiteEventFramework.class,
    TestOclMofExtensions.class,
    TestSuitePartitions.class,
    TestRomStructure.class,
    TestSimpleModelAndPartitionHandling.class,
    TestGetRefPackageForMofPackage.class,
    TestGetExtentsFromConnection.class,
    TestJmiLists.class,
    TestJmiListsDistributedEndStorage.class,
    TestLockManager.class,
    TestMofConstrains.class,
    TestRefInvokeOperation.class,
    TestSuiteAllTransactionsTest.class,
    TestSuiteAllCommandsTests.class,
    TestContainerAssignment.class,
    TestXmi.class,
    TestSuiteAllErrorHandlersTest.class,
    TestCrossPartitionObjectValuedAttributes.class,
    TestMetamodelFederation.class,
    TestTransientPartition.class,
    TestPartitionChangeRecorder.class,
    TestTextverticalization.class,
    TestGeneratedJmiNames.class,
    TestWorkspaceOperations.class,
    TestJmiHelper.class,
    TestMetaModelOperations.class,
    TestCreateElement.class,
    TestDeepCopy.class,
    TestTypeMorphing.class,
    TestGenerateMoinMetamodelsStandaloneSmoke.class,
    TestResourceIdentifierRecreationFromString.class,
    TestSuiteAllMetamodelCheckerTests.class,
    TestJmx.class,
    TestStringUtils.class,
    TestMetaModelExtensionGenerator.class,
    TestMetamodelElementDescriptors.class,
    TestCopyOnWrite.class,
    TestStructureTypeInheritance.class } )
public class TestSuiteCoreSmokeTests {
}
