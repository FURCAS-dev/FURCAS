package com.sap.tc.moin.repository.test.core;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.Import;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofException;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.test.fw.TestMetaModels;

/**
 * Creates an invalid Mof Model, and tests if all the violated constrains are
 * found by the RefBaseObject.refVerifyConstraints(true) operation. Status:
 * Following constrains are successfully checked: 5, 6, (8), 10, 12, 13, 15, 16,
 * 17, 19, 20, 21, 22, 23, 24, 25, 26, 29, 32, 34, 36, 38, 39, 40, 41, 42, 44,
 * 47, 48, 53, 54, 55, 56, 59 Following constrains are not identified -
 * Association::AssociationMustBeRootAndLeaf -
 * Import::NestedPackagesCannotImport -
 * ModelElement::MustBeContainedUnlessPackage -
 * MultiplicityType::MustBeUnorderedNonunique
 */
public class TestMofConstrains extends CoreMoinTest {

    // Elements in the bad MOF Model
    private MofPackage badPackage = null;

    private MofPackage badPackageB = null;

    private Import packageImport = null;

    private MofClass classA = null;

    private MofClass classB = null;

    private MofClass classC = null;

    private MofClass classD = null;

    private Constant constA = null;

    private Operation operA = null;

    private Parameter param0 = null;

    private Parameter param1 = null;

    private PrimitiveType primitiveC = null;

    private EnumerationType enumD = null;

    private StructureType structE = null;

    private Attribute attrA = null;

    private Attribute attrB = null;

    private Association assocAB = null;

    private AssociationEnd aEndA = null;

    private AssociationEnd aEndB = null;

    private AssociationEnd aEndC = null;

    private Reference refAB = null;

    private ModelPackage mofModelPackage;

    private Map<String, PrimitiveType> mofPrimitives;

    /**
     * Gets a connection from MMR and obtains the Mof ModelPackage meta object.
     */
    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        this.mofModelPackage = (ModelPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );

        this.mofPrimitives = new HashMap<String, PrimitiveType>( 6 );
        PrimitiveTypesPackage ptp = (PrimitiveTypesPackage) getMOINConnection( ).getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_PT );
        for ( ModelElement me : ptp.refMetaObject( ).getContents( ) ) {
            if ( me instanceof PrimitiveType ) {
                PrimitiveType pt = (PrimitiveType) me;
                this.mofPrimitives.put( pt.getName( ), pt );
            }
        }

        createBadMOFModel( );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        this.mofModelPackage = null;
        this.mofPrimitives = null;
        this.badPackage = null;
        this.badPackageB = null;
        this.packageImport = null;
        this.classA = null;
        this.classB = null;
        this.classC = null;
        this.classD = null;
        this.constA = null;
        this.operA = null;
        this.param0 = null;
        this.param1 = null;
        this.primitiveC = null;
        this.enumD = null;
        this.structE = null;
        this.attrA = null;
        this.attrB = null;
        this.assocAB = null;
        this.aEndA = null;
        this.aEndB = null;
        this.aEndC = null;
        this.refAB = null;
    }

    /**
     * @throws Exception
     */
    @Test
    /* adjust the test case */
    public void testVerifyConstraintsDeep( ) throws Exception {

        Collection<JmiException> errorsCol = this.badPackage.refVerifyConstraints( true );
        // Sort Errors
        Set<String> sortedErrors = new TreeSet<String>( );
        String errDesc;

        for ( JmiException jve : errorsCol ) {
            errDesc = jve.getMessage( ) + " : " + ( (ModelElement) jve.getObjectInError( ) ).getName( );
            sortedErrors.add( errDesc );
        }
        // Dump Errors
        StringBuffer errorDump = new StringBuffer( );
        for ( String error : sortedErrors ) {
            errorDump.append( error ).append( "\n" );
        }
        java.lang.System.out.println( "-------------------------------------" );
        java.lang.System.out.println( errorDump );

        // Read Desired
        StringBuffer desired = new StringBuffer( );
        InputStream is = null;
        try {
            is = Thread.currentThread( ).getContextClassLoader( ).getResourceAsStream( "com/sap/tc/moin/repository/test/rom/MofConstrainsViolations.txt" );
            BufferedReader in = new BufferedReader( new InputStreamReader( is ) );
            String line = in.readLine( );
            while ( line != null ) {
                desired.append( line ).append( "\n" );
                line = in.readLine( );
            }
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }

        // Compare
        assertEquals( desired.toString( ), errorDump.toString( ) );

    }

    /**
     * @throws Exception
     */
    @Test
    public void testVerifyConstraintsShallow( ) throws Exception {

        Collection<JmiException> errorsCol = this.badPackage.refVerifyConstraints( false );
        // Sort Errors
        Set<String> sortedErrors = new TreeSet<String>( );
        String errDesc;

        for ( JmiException jve : errorsCol ) {
            errDesc = jve.getMessage( ) + " : " + ( (ModelElement) jve.getObjectInError( ) ).getName( );
            sortedErrors.add( errDesc );
        }
        // Dump Errors
        StringBuffer errorDump = new StringBuffer( );
        for ( String error : sortedErrors ) {
            errorDump.append( error ).append( "\n" );
        }
        java.lang.System.out.println( "-------------------------------------" );
        java.lang.System.out.println( errorDump );

        // Read Desired
        StringBuffer desired = new StringBuffer( );
        InputStream is = null;
        try {
            is = Thread.currentThread( ).getContextClassLoader( ).getResourceAsStream( "com/sap/tc/moin/repository/test/rom/MofConstrainsViolationsShallow.txt" );
            BufferedReader in = new BufferedReader( new InputStreamReader( is ) );
            String line = in.readLine( );
            while ( line != null ) {
                desired.append( line ).append( "\n" );
                line = in.readLine( );
            }
        } finally {
            if ( is != null ) {
                is.close( );
            }
        }

        // Compare
        assertEquals( desired.toString( ), errorDump.toString( ) );
    }

    private MofPackage createBadMOFModel( ) {

        CoreConnection conn = getTestHelper( ).getCoreConnection( getMOINConnection( ) );

        this.badPackage = (MofPackage) this.mofModelPackage.getMofPackage( ).refCreateInstance( );
        this.badPackage.setRoot( true );
        this.badPackage.setLeaf( true );
        this.badPackage.setName( "badMofPackage" );

        this.badPackageB = (MofPackage) this.mofModelPackage.getMofPackage( ).refCreateInstance( );
        this.badPackageB.setName( "badMofPackageB" );
        this.badPackageB.setContainer( this.badPackage );
        this.badPackageB.setAbstract( true ); // [44]

        MofPackage badPackageC = (MofPackage) this.mofModelPackage.getMofPackage( ).refCreateInstance( );
        badPackageC.setName( "badMofPackageC" );
        badPackageC.setContainer( this.badPackage );

        this.packageImport = (Import) this.mofModelPackage.getImport( ).refCreateInstance( );
        this.packageImport.setName( "importAnother" );
        this.packageImport.setContainer( this.badPackage );
        this.packageImport.setImportedNamespace( this.badPackageB ); // [48]
        this.packageImport.setClustered( true );

        Import selfImport = (Import) this.mofModelPackage.getImport( ).refCreateInstance( );
        selfImport.setName( "selfImport" );
        selfImport.setContainer( badPackageC );
        selfImport.setImportedNamespace( badPackageC ); // [47]
        selfImport.setClustered( true );

        Import badImport = (Import) this.mofModelPackage.getImport( ).refCreateInstance( );
        badImport.setName( "selfImport" );
        badImport.setContainer( badPackageC );
        // TODO Nested Packages cannot import [?]
        badImport.setImportedNamespace( this.badPackageB );
        badImport.setClustered( true );

        this.classA = (MofClass) this.mofModelPackage.getMofClass( ).refCreateInstance( );
        this.classA.setName( "ClassA" );
        this.classA.setLeaf( true );
        this.classA.setContainer( this.badPackage );
        this.classA.setAbstract( true );
        this.classA.setSingleton( true ); // [16]

        this.classB = (MofClass) this.mofModelPackage.getMofClass( ).refCreateInstance( );
        this.classB.setName( "ClassB" );
        this.classB.setContainer( this.badPackageB );
        this.classB.getSupertypes( ).add( this.classA ); // [12]

        this.classC = (MofClass) this.mofModelPackage.getMofClass( ).refCreateInstance( );
        this.classC.setName( "ClassC" );
        this.classC.setContainer( this.badPackage );
        this.classC.getSupertypes( ).add( this.classA ); // [12]
        // TODO class cast exception
        this.classC.getSupertypes( ).add( this.badPackage );
        this.classC.setRoot( true ); // [10]

        this.classD = (MofClass) this.mofModelPackage.getMofClass( ).refCreateInstance( );
        this.classD.setName( "ClassD" );
        this.classD.setContainer( this.badPackage );
        this.classD.getSupertypes( ).add( this.classB );
        this.classD.getSupertypes( ).add( this.classC );
        this.classD.getSupertypes( ).add( this.classD ); // [6]

        // This produces an infinite recursion :-)
        // classC.getSupertypes().add(classD);

        // Create a Mof Primitive Type named "PrimitiveC"
        this.primitiveC = (PrimitiveType) this.mofModelPackage.getPrimitiveType( ).refCreateInstance( );
        this.primitiveC.setName( "PrimitiveC" );
        this.primitiveC.setContainer( this.badPackageB );
        this.primitiveC.getSupertypes( ).add( this.classD ); // [19]

        // Create a Mof EnumerationType "EnumD"
        this.enumD = (EnumerationType) this.mofModelPackage.getEnumerationType( ).refCreateInstance( );
        this.enumD.setName( "EnumD" );
        this.enumD.getLabels( ).add( "Label1" );
        this.enumD.getLabels( ).add( "Label2" );
        this.enumD.setContainer( this.primitiveC ); // [17]
        this.enumD.setAbstract( true ); // [20]

        // Create a Mof StructureType "StructE"
        this.structE = (StructureType) this.mofModelPackage.getStructureType( ).refCreateInstance( );
        this.structE.setName( "StructE" );
        this.structE.setContainer( this.badPackageB );
        StructureField fieldF = (StructureField) this.mofModelPackage.getStructureField( ).refCreateInstance( );
        fieldF.setName( "FieldF" );
        fieldF.setType( this.mofPrimitives.get( "Integer" ) );
        fieldF.setContainer( this.enumD ); // [17]
        StructureField fieldG = (StructureField) this.mofModelPackage.getStructureField( ).refCreateInstance( );
        fieldG.setName( "FieldG" );
        fieldG.setType( this.mofPrimitives.get( "String" ) );
        fieldG.setContainer( this.structE );

        // No Structure without Fields [59]
        StructureType structX = (StructureType) this.mofModelPackage.getStructureType( ).refCreateInstance( );
        structX.setName( "StructX" );
        structX.setContainer( this.badPackageB );

        // Create Attribute attrA in class ClassA of type ClassB
        // ClassA.attrA:ClassB
        this.attrA = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
        this.attrA.setName( "__attrA" );
        this.attrA.setType( this.classB );
        this.attrA.setDerived( true );
        this.attrA.setContainer( this.classA );

        // Create Attribute attrB in class ClassA of type ClassB
        // ClassA.attrB:PrimitiveC
        this.attrB = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
        this.attrB.setName( "attrA" );
        this.attrB.setType( this.primitiveC );
        this.attrB.setScope( ScopeKindEnum.CLASSIFIER_LEVEL );
        this.attrB.setContainer( this.classA ); // [5]

        this.constA = (Constant) this.mofModelPackage.getConstant( ).refCreateInstance( );
        this.constA.setName( "ConstA" );
        this.constA.setType( this.classA ); // [53]
        this.constA.setContainer( this.classA );
        this.constA.setValue( "44" );

        this.operA = (Operation) this.mofModelPackage.getOperation( ).refCreateInstance( );
        this.operA.setName( "operA" );
        this.operA.setContainer( this.classA );
        this.operA.setQuery( true );

        this.param0 = (Parameter) this.mofModelPackage.getParameter( ).refCreateInstance( );
        this.param0.setName( "param0" );
        this.param0.setContainer( this.operA );
        this.param0.setDirection( DirectionKindEnum.RETURN_DIR );
        this.param0.setType( this.classB );
        this.param0.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 6, 1, true, false ) ); // [55]

        this.param1 = (Parameter) this.mofModelPackage.getParameter( ).refCreateInstance( );
        this.param1.setName( "param1" );
        this.param1.setContainer( this.operA );
        this.param1.setDirection( DirectionKindEnum.RETURN_DIR ); // [29]
        this.param1.setType( this.mofPrimitives.get( "String" ) );
        this.param1.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, -1, -10, true, false ) ); // [54]

        this.assocAB = (Association) this.mofModelPackage.getAssociation( ).refCreateInstance( );
        this.assocAB.setName( "AssocAB" );
        this.assocAB.setContainer( this.badPackage );
        this.assocAB.setAbstract( true ); // [36]
        // TODO AssociationMustBeRootAndLeaf [?]
        this.assocAB.setRoot( false );
        this.assocAB.getSupertypes( ).add( this.classA ); // [34]

        this.aEndA = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        this.aEndA.setName( "theA" );
        this.aEndA.setType( this.classA );
        this.aEndA.setAggregation( AggregationKindEnum.COMPOSITE ); // [42]
        this.aEndA.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, 0, true, false ) ); // [56]
        this.aEndA.setNavigable( false ); // [25]
        this.aEndA.setContainer( this.assocAB );
        this.aEndA.setChangeable( false );

        this.aEndB = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        this.aEndB.setName( "theB" );
        this.aEndB.setType( this.classB );
        this.aEndB.setAggregation( AggregationKindEnum.COMPOSITE ); // [42]
        this.aEndB.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, -1, true, false ) ); // [40]
        // [41]
        this.aEndB.setContainer( this.assocAB );

        this.aEndC = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
        this.aEndC.setName( "theB" ); // [5?]
        this.aEndC.setType( this.mofPrimitives.get( "String" ) ); // [39]
        this.aEndC.setAggregation( AggregationKindEnum.COMPOSITE ); // [42]
        this.aEndC.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, -1, false, false ) ); // [40]
        this.aEndC.setContainer( this.assocAB ); // [38]

        this.refAB = (Reference) this.mofModelPackage.getReference( ).refCreateInstance( );
        this.refAB.setName( "theBB" );
        this.refAB.setContainer( this.classC ); // [26]
        this.refAB.setType( this.classC );
        this.refAB.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, 1, false, false ) ); // [21]
        this.refAB.setReferencedEnd( this.aEndA );
        this.refAB.setScope( ScopeKindEnum.CLASSIFIER_LEVEL ); // [22]
        this.refAB.setExposedEnd( this.aEndA ); // [24]
        this.refAB.setChangeable( true ); // [23]

        MofException except = (MofException) this.mofModelPackage.getMofException( ).refCreateInstance( );
        except.setName( "aException" );
        except.setContainer( this.classC );

        Parameter param2 = (Parameter) this.mofModelPackage.getParameter( ).refCreateInstance( );
        param2.setName( "param2" );
        param2.setContainer( except );
        param2.setDirection( DirectionKindEnum.IN_DIR ); // [32]
        param2.setType( this.assocAB ); // [13]
        // TODO MustBeUnorderedNonunique[?]
        param2.setMultiplicity( conn.getCoreJmiHelper( ).createMultiplicityType( conn, 0, 1, true, true ) );

        return this.badPackage;
    }

}
