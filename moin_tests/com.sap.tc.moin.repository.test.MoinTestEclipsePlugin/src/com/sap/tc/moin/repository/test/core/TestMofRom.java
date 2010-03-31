/*
 * Created on 14.11.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.sap.junit.Staged;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.PartitionDeletingNotPossibleException;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.WorkspaceSet;
import com.sap.tc.moin.repository.core.mofrom.MofRomPhase;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.jmigenerator.mofrom.MoinMofRomGeneratorNG;
import com.sap.tc.moin.repository.jmigenerator.mofrom.MoinMofRomGeneratorNG.Phase;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.testcases.case014.A14;

/**
 * Class to test the MOF ROM
 * 
 * @author d024227
 * @author d046220
 */
public class TestMofRom extends CoreMoinTest {

    private ModelPackage mofModelPackage;

    private HashMap<String, PrimitiveType> mofPrimitives;

    protected boolean doFireEvents = false;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        mofPrimitives = new HashMap<String, PrimitiveType>( 6 );
        PrimitiveTypesPackage ptp = (PrimitiveTypesPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_PT );
        List<ModelElement> prims = ptp.refMetaObject( ).getContents( );
        for ( Iterator<ModelElement> i = prims.iterator( ); i.hasNext( ); ) {
            ModelElement me = i.next( );
            if ( me instanceof PrimitiveType ) {
                PrimitiveType pt = (PrimitiveType) me;
                mofPrimitives.put( pt.getName( ), pt );
            }
        }

        MofPackage testMofPackage = createTestMOFModel( );
        verify( testMofPackage != null, "The test package is null" );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        mofModelPackage = null;
        mofPrimitives = null;
        mofPackage = null;
        mofPackageB = null;
        packageImport = null;
        classA = null;
        classB = null;
        classC = null;
        classD = null;
        constA = null;
        operA = null;
        param0 = null;
        param1 = null;
        primitiveC = null;
        enumD = null;
        structE = null;
        fieldF = null;
        fieldG = null;
        attrA = null;
        attrB = null;
        assocAB = null;
        aEndA = null;
        aEndB = null;
        refAB = null;
    }

    /*
     * Test if the creation and modification api is working correctly by dumping
     * the test Mof Metamodel and comparing it with an expected file
     */
    // @Test public void testNewMofModelStructure() throws Exception {
    // String useWrappers = System.getProperty("moin.use.wrappers");
    // if (!(useWrappers != null && useWrappers.equalsIgnoreCase("false"))) {
    // // This test cannot work with wrappers because TestMofModel.txt contains
    // Strings from <obj>.getClass().getName(),
    // // which in the wrapper case results in "$Proxy..." instead of e.g.
    // "com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl".
    // return;
    // }
    // // Create Dump
    // MofModelDumper mmd = new MofModelDumper(mofPackage);
    // String dump = mmd.dumpModel(false, true);
    //        
    // java.lang.System.out.println("-------------------------------------");
    // java.lang.System.out.println(dump);
    //
    // // Read Desired
    // StringBuffer desired = new StringBuffer();
    // InputStream is = Thread.currentThread().getContextClassLoader()
    // .getResourceAsStream("com/sap/tc/moin/repository/test/rom/TestMofModel.txt");
    // BufferedReader in = new BufferedReader( new InputStreamReader(is));
    // String line = in.readLine();
    // while (line !=null) {
    // desired.append(line).append("\n");
    // line = in.readLine();
    // }
    // assertEquals(desired.toString(),dump+"\n");
    // }
    /*
     * Tests the operation AssociationEnd::otherEnd()
     */
    @Test
    public void testOtherEnd( ) throws Exception {

        assertEquals( "Operation AssociationEnd:otherEnd() failed", aEndB, aEndA.otherEnd( ) );
        assertEquals( "Operation AssociationEnd:otherEnd() failed", aEndA, aEndB.otherEnd( ) );
    }

    /*
     * Tests the operation GeneralizableElement::allSupertypes()
     */
    @Test
    public void testAllSupertypes( ) throws Exception {

        assertEquals( "Operation classD.allSupertypes() failed", 3, classD.allSupertypes( ).size( ) );
    }

    /*
     * Tests the operation ModelElement::findRequiredElements()
     */
    @Test
    public void testFindRequiredElements( ) throws Exception {

        Collection<String> kinds = new ArrayList<String>( );
        kinds.add( ModelElement.ALLDEP );
        Collection<ModelElement> req = classB.findRequiredElements( kinds, true );
        assertNotNull( "Operation classA.findRequiredElements(kinds,false) failed", req );
    }

    /*
     * Tests the operation Namespace::lookupElement()
     */
    @Test
    public void testLookupElement( ) throws Exception {

        assertEquals( "Operation mofPackage.lookupElement('ClassA') failed", classA, mofPackage.lookupElement( "ClassA" ) );
        try {
            mofPackage.lookupElement( "anotherMofPackage" );
            fail( "Operation mofPackage.lookupElement('anotherMofPackage') failed. The exception NameNotFound was not trhown." );
        } catch ( NameNotFoundException nnfe ) {
        }
    }

    /*
     * Tests the operation GeneralizableElement::lookupElementExtended()
     */
    @Test
    public void testLookupElementExtended( ) throws Exception {

        assertEquals( "Operation mofPackage.lookupElementExtended('anotherMofPackage') failed", mofPackageB, mofPackage.lookupElementExtended( "anotherMofPackage" ) );
        try {
            mofPackage.lookupElementExtended( "Inexistent" );
            fail( "Operation mofPackage.lookupElementExtended('Inexistent') failed. The exception NameNotFoundException was not trhown." );
        } catch ( NameNotFoundException nnfe ) {
        }
    }

    /*
     * Tests the operation Namespace::findElementsByType
     */
    @Test
    public void testFindElementsByType( ) throws Exception {

        com.sap.tc.moin.repository.mmi.model.MofPackage modelPackageElement = mofModelPackage.refMetaObject( );
        MofClass theMofClassElement = (MofClass) modelPackageElement.lookupElement( "Class" );

        // Test that there are exactly 4 Mof Classes in "mofPackage"
        List<ModelElement> l = mofPackage.findElementsByType( theMofClassElement, false );
        assertEquals( "Operation mofPackage.findElementsByType(MofClass,false) failed", 4, l.size( ) );

        MofClass theMofClassifierElement = (MofClass) modelPackageElement.lookupElement( "Classifier" );
        // Test that there are exactly 4 Mof Classifiers in "mofPackage"
        // (4 classes and 1 association)
        l = mofPackage.findElementsByType( theMofClassifierElement, true );
        assertEquals( "Operation mofPackage.findElementsByType() failed", 5, l.size( ) );
    }

    /*
     * Tests the operation GeneralizableElement::findElementsByTypeExtended
     */
    @Test
    public void testFindElementsByTypeExtended( ) throws Exception {

        // TODO reactivate as soon as it is implemented

        /*
         * com.sap.tc.moin.repository.mmi.model.MofPackage modelPackageElement =
         * (MofPackage)mofModelPackage.refMetaObject(); MofClass
         * theMofClassifierElement = (MofClass) modelPackageElement.
         * lookupElement("Classifier"); // Test that there are exactly 4 Mof
         * Classes and 1 Association in mofPackage // and 3 DataTypes in the
         * imported mofPackageB List l =
         * mofPackage.findElementsByTypeExtended(theMofClassifierElement,true);
         * assertNotNull("Operation
         * mofPackage.findElementsByTypeExtended(Classifier,true) failed:
         * returned list is null",l); assertEquals("Operation
         * mofPackage.findElementsByTypeExtended(Classifier,true) failed", 8,
         * l.size());
         */
    }

    /*
     * Tests the operation Namespace::resolveQualifiedName()
     */
    @Test
    public void testResolveQualifiedName( ) throws Exception {

        List<String> qualifiedName = new ArrayList<String>( );
        // removed because we are asking the "aMofPackage" itself
        // qualifiedName.add("aMofPackage");
        qualifiedName.add( "ClassD" );
        List<String> ll = classD.getQualifiedName( );
        assertEquals( "Operation mofPackage.resolveQualifiedName('aMofPackage.ClassB') failed.", classD, mofPackage.resolveQualifiedName( qualifiedName ) );
    }

    /*
     * Tests the operation Namespace::nameIsValid()
     */
    @Test
    public void testNameIsValid( ) throws Exception {

        // TODO reactivate as soon as it is implemented

        /*
         * assertEquals("Operation mofPackage.nameIsValid('NewName') failed.",
         * true, mofPackage.nameIsValid("NewName")); assertEquals("Operation
         * mofPackage.nameIsValid('12Class') failed.", false,
         * mofPackage.nameIsValid("12Class")); assertEquals("Operation
         * mofPackage.nameIsValid('ClassB') failed.", false,
         * mofPackage.nameIsValid("ClassB"));
         */

    }

    @Test
    public void testNoConstraintViolationShallow( ) throws Exception {

        Collection<JmiException> errorsCol = mofPackage.refVerifyConstraints( false );
        assertEquals( "Operation mofPackage.refVerifyConstraints(false) returned errors.", null, errorsCol );
    }

    @Test
    public void testNoConstraintViolationDeep( ) throws Exception {

        Collection<JmiException> errorsCol = mofPackage.refVerifyConstraints( true );
        assertNotEqualsAndContinue( "Operation mofPackage.refVerifyConstraints(true) returned no errors.", null, errorsCol );
    }

    /*
     * Tests the existence of Reflect:Element
     */
    @Test
    public void testExistenceOfElement( ) throws Exception {

        RefPackage rp = getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_REFLECT );
        RefClass rc = rp.refClass( "Element" );
        List<String> qn = rc.refMetaObject( ).getQualifiedName( );
        assertTrue( qn.size( ) == 2 && qn.get( 0 ).equals( "Reflect" ) && qn.get( 1 ).equals( "Element" ) );
    }

    /*
     * Tests the correct implementation of the methods of the derived MOF
     * association "Exposes" and the reference in MOF class "Reference" that
     * refers the end "exposedEnd" of "Exposes". The derived association Exposes
     * is so to say the opposite of the association RefersTo.
     */
    @Test
    public void testExposes( ) throws Exception {

        assertTrue( mofModelPackage.getExposes( ).exists( refAB, aEndA ) );
        assertEquals( refAB, mofModelPackage.getExposes( ).getReferrer( aEndA ).iterator( ).next( ) );
        assertEquals( aEndA, mofModelPackage.getExposes( ).getExposedEnd( refAB ) );
        assertEquals( aEndA, refAB.getExposedEnd( ) );

        assertTrue( mofModelPackage.getRefersTo( ).exists( refAB, aEndB ) );
        assertEquals( refAB, mofModelPackage.getRefersTo( ).getReferent( aEndB ).iterator( ).next( ) );
        assertEquals( aEndB, mofModelPackage.getRefersTo( ).getReferencedEnd( refAB ) );

        mofModelPackage.getRefersTo( ).remove( refAB, aEndB );
        assertFalse( mofModelPackage.getExposes( ).exists( refAB, aEndA ) );
        mofModelPackage.getExposes( ).add( refAB, aEndA );
        assertTrue( mofModelPackage.getExposes( ).exists( refAB, aEndA ) );

        mofModelPackage.getExposes( ).remove( refAB, aEndA );
        assertFalse( mofModelPackage.getExposes( ).exists( refAB, aEndA ) );
        mofModelPackage.getRefersTo( ).add( refAB, aEndB );
        assertTrue( mofModelPackage.getExposes( ).exists( refAB, aEndA ) );
    }

    /**
     * Retrieves many instances of a specific MofClass by invoking the
     * refAllOfClass method and loops the result set. This verifies that the
     * refAllOfClass methods works. Within this implementation the MOIN
     * DerivedCollection is used which had a problem as internally the original
     * Collection was held as a WeakReference. It could happen that the original
     * Collection was garbage collected and the DerivedCollection was then
     * corupted.
     * 
     * @throws Exception
     */
    @Test
    public void testRefAllOfClass( ) throws Exception {

        Collection<RefObject> allMofClasses = mofModelPackage.getMofClass( ).refAllOfClass( );
        int i;
        for ( i = 0; i < 10; i++ ) {
            for ( Object object : allMofClasses ) {
                MofClass mc = (MofClass) object;
                mc.getName( ); // this tests runs different, as all metamodels
                // are deployed in index scenarios.
                // i leads to npe's if e.g. the (corrupted) WebDynpro metamodel
                // is loaded ( "Twice" )
                // remove/disable: the following plugins from/in your target
                // platform
                // com.sap.tc.moin.metamodel.webdynpro
                // com.sap.tc.moin.metamodel.common
                // com.sap.tc.moin.metamodel.dictionary
                // com.sap.tc.moin.metamodel.composition

                // Adding partition(previous duplicate removed)
                // PF.MetaModelDataArea:DCs/sap.com/com.sap.tc.composition.metamodel/_comp/moin/meta/Composition.xmi
                // Remove Partition pri
                // PF.MetaModelDataArea:DCs/sap.com/tc/moin/webdynpro/webdynpro/_comp/moin/meta/WebDynpro.xmi
                // Adding partition(previous duplicate removed)
                // PF.MetaModelDataArea:DCs/sap.com/tc/moin/webdynpro/webdynpro/_comp/moin/meta/WebDynpro.xmi

                // in this case: disable on of the metamodels in your client
                // workspace:

            }
        }
        assertTrue( i == 10 );
    }

    @Test
    public void testGetElementsOfMetamodelPartition( ) throws Exception {

        ModelPackage modelPackage = (ModelPackage) getMOINConnection( ).getPackage( "sap.com/tc/moin/mof_1.4", "Model" );
        ModelPartition partition = ( (Partitionable) modelPackage ).get___Partition( );
        Collection<Partitionable> elements = partition.getElements( );
    }

    @Test
    public void testDeleteOfMetamodelPartition( ) throws Exception {

        ModelPackage modelPackage = (ModelPackage) getMOINConnection( ).getPackage( "sap.com/tc/moin/mof_1.4", "Model" );
        ModelPartition partition = ( (Partitionable) modelPackage ).get___Partition( );
        try {
            partition.delete( );
            fail( "Expected PartitionDeletingNotPossibleException or AssertionError" );
        } catch ( PartitionDeletingNotPossibleException ex ) {
            System.out.println( );
        } catch ( RuntimeException ex ) {
            // If both the "-ea" VM parameter and the
            // "-Dcom.sap.tc.moin.checkLockHolding=true" property are set, an
            // AssertionError will be thrown instead of the
            // PartitionDeletingNotPossibleException.
            assertTrue( "Expected AssertionError as the cause of the RuntimeException", ex.getCause( ) instanceof AssertionError );
        }
    }

    @Test
    public void testCreateElementFromMetaModelContainingOCL( ) {

        getTestHelper( ).reset( );

        RefClass proxy = getMOINConnection( ).getClass( A14.CLASS_DESCRIPTOR );

        assertNotNull( proxy );

        A14 element = (A14) proxy.refCreateInstance( );

        assertNotNull( element );
    }

    // @Test public void testDeleteElementsOfMetamodelPartition() throws
    // Exception {
    // long timeStamp = System.currentTimeMillis();
    //
    // ModelPackage modelPackage = (ModelPackage)
    // getMOINConnection().getPackage("sap.com/tc/moin/mof_1.4", "Model");
    // ModelPartition partition = ((Partitionable)
    // modelPackage).get___Partition();
    // try {
    // partition.deleteElements();
    // fail("Excepted PartitionEditingNotPossibleException");
    // } catch (PartitionEditingNotPossibleException ex) {
    // }
    //        
    // long queryTime = System.currentTimeMillis() - timeStamp;
    // addToCsvFile(smokeTestFileName, queryTime);
    // }

    // Elements in the test MOF Model
    MofPackage mofPackage = null;

    MofPackage mofPackageB = null;

    Import packageImport = null;

    MofClass classA = null;

    MofClass classB = null;

    MofClass classC = null;

    MofClass classD = null;

    Constant constA = null;

    Operation operA = null;

    Parameter param0 = null;

    Parameter param1 = null;

    PrimitiveType primitiveC = null;

    EnumerationType enumD = null;

    StructureType structE = null;

    StructureField fieldF = null;

    StructureField fieldG = null;

    Attribute attrA = null;

    Attribute attrB = null;

    Association assocAB = null;

    AssociationEnd aEndA = null;

    AssociationEnd aEndB = null;

    Reference refAB = null;

    /*
     * Creates a Mof Metamodel programatically using Mof JMI
     */
    private MofPackage createTestMOFModel( ) {

        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );

        // Create a Mof Package named "aMofPackage"
        mofPackage = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        mofPackage.setRoot( true );
        mofPackage.setLeaf( true );
        setDefaultValues( mofPackage );
        mofPackage.setName( "aMofPackage" );

        // Create another Mof Package named "anotherMofPackage"
        mofPackageB = (MofPackage) mofModelPackage.getMofPackage( ).refCreateInstance( );
        setDefaultValues( mofPackageB );
        mofPackageB.setName( "anotherMofPackage" );

        packageImport = (Import) mofModelPackage.getImport( ).refCreateInstance( );
        setDefaultValues( packageImport );
        packageImport.setName( "importAnother" );
        packageImport.setContainer( mofPackage );
        packageImport.setImportedNamespace( mofPackageB );
        packageImport.setClustered( true );

        // Create an Abstract Mof Class named "ClassA"
        classA = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        setDefaultValues( classA );
        classA.setName( "ClassA" );
        classA.setAbstract( true );
        classA.setContainer( mofPackage );

        // Create a Mof Class named "ClassB", derived from "ClassB"
        classB = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        setDefaultValues( classB );
        classB.setName( "ClassB" );
        classB.setContainer( mofPackage );
        classB.getSupertypes( ).add( classA );

        classC = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        setDefaultValues( classC );
        classC.setName( "ClassC" );
        classC.setContainer( mofPackage );
        classC.getSupertypes( ).add( classA );

        classD = (MofClass) mofModelPackage.getMofClass( ).refCreateInstance( );
        setDefaultValues( classD );
        classD.setName( "ClassD" );
        classD.setContainer( mofPackage );
        classD.getSupertypes( ).add( classB );
        classD.getSupertypes( ).add( classC );

        // Create a Mof Primitive Type named "PrimitiveC"
        primitiveC = (PrimitiveType) mofModelPackage.getPrimitiveType( ).refCreateInstance( );
        setDefaultValues( primitiveC );
        primitiveC.setName( "PrimitiveC" );
        primitiveC.setContainer( mofPackageB );
        // TODO: Inherits from a MOF primitive
        // primitiveC.getSupertypes().add();

        // Create a Mof EnumerationType "EnumD"
        enumD = (EnumerationType) mofModelPackage.getEnumerationType( ).refCreateInstance( );
        setDefaultValues( enumD );
        enumD.setName( "EnumD" );
        enumD.getLabels( ).add( "Label1" );
        enumD.getLabels( ).add( "Label2" );
        enumD.setContainer( mofPackageB );

        // Create a Mof StructureType "StructE"
        structE = (StructureType) mofModelPackage.getStructureType( ).refCreateInstance( );
        setDefaultValues( structE );
        structE.setName( "StructE" );
        structE.setContainer( mofPackageB );
        StructureField fieldF = (StructureField) mofModelPackage.getStructureField( ).refCreateInstance( );
        setDefaultValues( fieldF );
        fieldF.setName( "FieldF" );
        fieldF.setType( mofPrimitives.get( "Integer" ) );
        fieldF.setContainer( structE );
        StructureField fieldG = (StructureField) mofModelPackage.getStructureField( ).refCreateInstance( );
        setDefaultValues( fieldG );
        fieldG.setName( "FieldG" );
        fieldG.setType( mofPrimitives.get( "String" ) );
        fieldG.setContainer( structE );

        // Create Attribute attrA in class ClassA of type ClassB
        // ClassA.attrA:ClassB
        attrA = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        setDefaultValues( attrA );
        attrA.setName( "attrA" );
        attrA.setType( classB );
        attrA.setDerived( true );
        attrA.setContainer( classA );
        attrA.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 1, 1, false, false ) );
        // C5074171: Test case adjustment due to changed default values
        attrA.setChangeable( true );

        // Create Attribute attrB in class ClassA of type ClassB
        // ClassA.attrB:PrimitiveC
        attrB = (Attribute) mofModelPackage.getAttribute( ).refCreateInstance( );
        setDefaultValues( attrB );
        attrB.setName( "attrB" );
        attrB.setType( primitiveC );
        attrB.setScope( ScopeKindEnum.CLASSIFIER_LEVEL );
        attrB.setContainer( classA );
        attrB.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 1, 1, false, false ) );
        // C5074171: Test case adjustment due to changed default values
        attrB.setChangeable( true );

        constA = (Constant) mofModelPackage.getConstant( ).refCreateInstance( );
        setDefaultValues( constA );
        constA.setName( "ConstA" );
        constA.setType( mofPrimitives.get( "Integer" ) );
        constA.setContainer( classA );
        constA.setValue( "44" );

        operA = (Operation) mofModelPackage.getOperation( ).refCreateInstance( );
        setDefaultValues( operA );
        operA.setName( "operA" );
        operA.setContainer( classA );
        operA.setQuery( true );

        param0 = (Parameter) mofModelPackage.getParameter( ).refCreateInstance( );
        setDefaultValues( param0 );
        param0.setName( "param0" );
        param0.setContainer( operA );
        param0.setDirection( DirectionKindEnum.RETURN_DIR );
        param0.setType( classB );

        param1 = (Parameter) mofModelPackage.getParameter( ).refCreateInstance( );
        setDefaultValues( param1 );
        param1.setName( "param1" );
        param1.setContainer( operA );
        param1.setDirection( DirectionKindEnum.IN_DIR );
        param1.setType( mofPrimitives.get( "String" ) );
        param1.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 1, -1, true, false ) );

        assocAB = (Association) mofModelPackage.getAssociation( ).refCreateInstance( );
        setDefaultValues( assocAB );
        assocAB.setName( "AssocAB" );
        assocAB.setContainer( mofPackage );

        aEndA = (AssociationEnd) mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        setDefaultValues( aEndA );
        aEndA.setName( "theA" );
        aEndA.setType( classA );
        aEndA.setAggregation( AggregationKindEnum.COMPOSITE );
        aEndA.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 0, 1, false, true ) );
        aEndA.setContainer( assocAB );
        // C5074171: Test case adjustment due to changed default values
        aEndA.setChangeable( true );

        aEndB = (AssociationEnd) mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        setDefaultValues( aEndB );
        aEndB.setName( "theB" );
        aEndB.setType( classB );
        aEndB.setAggregation( AggregationKindEnum.NONE );
        aEndB.setMultiplicity( coreConnection.getCoreJmiHelper( ).createMultiplicityType( coreConnection, 0, -1, false, true ) );
        aEndB.setContainer( assocAB );
        // C5074171: Test case adjustment due to changed default values
        aEndB.setChangeable( true );
        aEndB.setNavigable( true );

        refAB = (Reference) mofModelPackage.getReference( ).refCreateInstance( );
        setDefaultValues( refAB );
        refAB.setReferencedEnd( aEndB );
        refAB.setName( aEndB.getName( ) );
        refAB.setType( aEndB.getType( ) );
        refAB.setMultiplicity( aEndB.getMultiplicity( ) );
        refAB.setExposedEnd( aEndA );
        refAB.setContainer( aEndA.getType( ) );
        // C5074171: Test case adjustment due to changed default values
        refAB.setChangeable( true );

        return mofPackage;
    }

    private void setDefaultValues( ModelElement modelElement ) {

        // C5074171: Test case adjustment due to changed default values
        modelElement.setAnnotation( "" );
        if ( modelElement instanceof GeneralizableElement ) {
            ( (GeneralizableElement) modelElement ).setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        }
    }

    @Test
    @Ignore
    public void testMofRomGeneration( ) throws Exception {

        CoreConnection coreConnection = getTestHelper( ).getCoreConnection( getMOINConnection( ) );
        WorkspaceSet workspaceSet = coreConnection.getSession( ).getWorkspaceSet( );
        CRI mofRomCri = workspaceSet.getMoin( ).getMofRomCri( );
        if ( !workspaceSet.getMoin( ).isSecondStageInjected( ) ) {
            workspaceSet.getMoin( ).injectSecondMofRomStage( );
        }
        Collection<CoreModelPartition> mofRomPartitions = new ArrayList<CoreModelPartition>( );
        Collection<CoreModelPartition> loadedPartitions = workspaceSet.getMoin( ).getMetamodelWorkspace( ).getPartitionManager( ).getLoadedPartitionsLive( );
        for ( CoreModelPartition coreModelPartition : loadedPartitions ) {

            if ( coreModelPartition.getPri( ).getCri( ).equals( mofRomCri ) ) {
                mofRomPartitions.add( coreModelPartition );
            }
        }

        MofRomWriterProvider writerProvider = new MofRomWriterProvider( );
        MoinMofRomGeneratorNG mofRomGeneratorNG = new MoinMofRomGeneratorNG( coreConnection, mofRomPartitions, writerProvider );
        Phase[] phases = mofRomGeneratorNG.execute( );
        assertNotNull( "Expected phases to be not null", phases );
        assertEquals( 2, phases.length );
        for ( Phase phase : phases ) {
            Class<?> mofRomClass = Class.forName( "com.sap.tc.moin.repository.core.mofrom.MoinMofRom" + phase.number, true, MoinMofRomServicesImpl.class.getClassLoader( ) );
            MofRomPhase mofRomPhase = (MofRomPhase) mofRomClass.newInstance( );
            assertEquals( mofRomPhase.getNumberOfAssociations( ), phase.getNumberOfAssociations( ) );
            assertEquals( mofRomPhase.getNumberOfInstances( ), phase.getNumberOfInstances( ) );
            assertEquals( mofRomPhase.getNumberOfLinks( ), phase.getNumberOfLinks( ) );
        }

    }

    private static final class MofRomWriterProvider implements MoinMofRomGeneratorNG.WriterProvider {

        public Writer getWriterForMofRomPhase( int phase ) {

            return createWriter( );
        }

        public Writer getWriterForTxtOutput( ) {

            return createWriter( );

        }

        private Writer createWriter( ) {

            return new BufferedWriter( new OutputStreamWriter( new ByteArrayOutputStream( ) ) );
        }
    }

    @Staged
    @Test
    public void testMofRomGeneratedClasses( ) throws Exception {

        Connection connection = getMOINConnection( );
        ModelPackage modelPackage = connection.getPackage( ModelPackage.PACKAGE_DESCRIPTOR );
        CRI cri = ( (Partitionable) modelPackage.refMetaObject( ) ).get___Partition( ).getPri( ).getCri( );
        new GeneratedJmiClassesTraverser( cri, connection ).run( );
    }

    @Test
    public void testRetrievalOfMofRomPris( ) throws Exception {

        String[] expectedMofRomPris = new String[] { "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/OCL.moinmm", //$NON-NLS-1$
            "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/MOIN.moinmm", //$NON-NLS-1$
            "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Model.moinmm", //$NON-NLS-1$
            "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/CorbaIdlTypes.moinmm", //$NON-NLS-1$
            "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/PrimitiveTypes.moinmm", //$NON-NLS-1$
            "PF.MetaModelDataArea:DCs/sap.com/tc/moin/mof_1.4/_comp/moin/meta/Reflect.moinmm" }; //$NON-NLS-1$
        Connection connection = getMOINConnection( );
        Moin moin = connection.getSession( ).getMoin( );
        CRI mofRomCri = getMofRomCri( );
        assertNotNull( mofRomCri );
        Collection<PRI> mofRomPartitions = connection.getSession( ).getInnerPartitions( mofRomCri );
        assertEquals( expectedMofRomPris.length, mofRomPartitions.size( ) );
        for ( String mofRomPriString : expectedMofRomPris ) {
            PRI pri = moin.createPri( mofRomPriString );
            assertTrue( mofRomPartitions.contains( pri ) );
        }
    }

    private CRI getMofRomCri( ) {

        return getTestHelper( ).getCoreMoin( ).getMofRomCri( );
    }
}
