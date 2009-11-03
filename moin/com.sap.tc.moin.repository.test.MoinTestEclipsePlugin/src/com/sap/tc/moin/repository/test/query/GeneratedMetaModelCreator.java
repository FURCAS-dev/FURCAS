package com.sap.tc.moin.repository.test.query;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import com.sap.tc.moin.repository.mmi.model.AggregationKindEnum;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.ScopeKindEnum;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.StructureType;
import com.sap.tc.moin.repository.mmi.model.Tag;
import com.sap.tc.moin.repository.mmi.model.VisibilityKindEnum;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.serialization.PartitionWriterImpl;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.core.Wrapper;
import com.sap.tc.moin.repository.spi.core.serialization.SpiPartitionWriter;
import com.sap.tc.moin.test.fw.TestClient;
import com.sap.tc.moin.test.fw.TestMetaModels;
import com.sap.tc.moin.test.testcase.MoinTestCase;

/**
 * Generator for the synthetic metamodel. Before running this class, please
 * ensure that the XMI file at
 * %MOINWORKSPACE%\moin\moin.test\dev\src\_tc~moin~metamodel
 * ~generatedmetamodel\moin\meta\generatedmetamodel.xmi is writable
 * 
 * @author d046918
 */
public class GeneratedMetaModelCreator extends MoinTestCase {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, GeneratedMetaModelCreator.class );

    private Connection conn;

    private ModelPackage mofModelPackage;

    private MofPackage testPackage1;

    private ModelPartition metaModelPartition;

    private HashMap<String, PrimitiveType> mofPrimitives;

    private PrimitiveTypesPackage ptp;

    private RefPackage rtp;

    private MofClass refElmnt;

    private TestClient testClient1;

    private Properties instParameters;

    private int mmSize;

    private int attrSize;

    private String pkgPath;

    public GeneratedMetaModelCreator( ) {

    }

    public GeneratedMetaModelCreator( String string ) {

        super( string );
    }

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        String pkgName = this.getClass( ).getPackage( ).getName( );

        this.pkgPath = "\\" + pkgName.replaceAll( "\\.", "\\\\" ) + "\\";

        this.conn = this.getMOINConnection( );

        this.mofModelPackage = (ModelPackage) this.conn.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MODEL );
        this.mofPrimitives = new HashMap<String, PrimitiveType>( 6 );
        this.ptp = (PrimitiveTypesPackage) this.conn.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_PT );
        List<ModelElement> prims = this.ptp.refMetaObject( ).getContents( );
        for ( Iterator<ModelElement> i = prims.iterator( ); i.hasNext( ); ) {
            ModelElement me = i.next( );
            if ( me instanceof PrimitiveType ) {
                PrimitiveType pt = (PrimitiveType) me;
                this.mofPrimitives.put( pt.getName( ), pt );
            }
        }

        this.rtp = this.conn.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_REFLECT );
        List<ModelElement> refs = this.rtp.refMetaObject( ).getContents( );
        for ( Iterator<ModelElement> i = refs.iterator( ); i.hasNext( ); ) {
            ModelElement ob = i.next( );
            if ( ob instanceof MofClass ) {
                this.refElmnt = (MofClass) ob;
            }
        }

        // more than 60 attributes are not possible because of Java language limitations
        // (too many parameters in method)

        String propertyResourceLocation = System.getProperties( ).getProperty( "moin.generatedmetamodel.properties" );
        FileInputStream in = new FileInputStream( propertyResourceLocation );
        this.instParameters = new Properties( );
        this.instParameters.load( in );

        this.mmSize = Integer.decode( this.instParameters.getProperty( "metaModelSize" ) );
        this.attrSize = Integer.decode( this.instParameters.getProperty( "attributesSize" ) );

        this.metaModelPartition = this.createParameterizedMetaModel( this.mmSize, this.attrSize );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        this.testClient1.clear( );
        this.testClient1 = null;
        super.afterTestMethod( );
    }

    @Test
    public void writeMetaModelPartition( ) throws Exception {

        String generatedMetaModelXmiLocation = System.getProperties( ).getProperty( "moin.generatedmetamodel.path" )
        //+ "\\moin\\moin.test\\FrwkDev_stream\\src\\_tc~moin~metamodel~generatedmetamodel\\moin\\meta\\generatedMetaModel.xmi";
                                               + "\\generatedmetamodel" + MetaModelCatalog.META_MODEL_EXTENSION;

        SpiPartitionWriter partitionWriter = new PartitionWriterImpl( );

        OutputStream os2;

        try {
            os2 = new FileOutputStream( generatedMetaModelXmiLocation );

            ModelPartition mp = (ModelPartition) ( ( (Wrapper) this.metaModelPartition ).unwrap( ) );

            partitionWriter.write( getTestHelper( ).getCoreConnection( getMOINConnection( ) ).getSession( ), os2, mp );
            os2.close( );
            System.out.println( "XMI file written to " + generatedMetaModelXmiLocation );
        } catch ( FileNotFoundException e ) {
            System.out.println( "The File " + generatedMetaModelXmiLocation + " could not be written." + "\n" + "Please ensure that it is opened for edit and writable." );
            e.printStackTrace( );
            throw e;
        }
    }

    /**
     * Creates a MOF metamodel programmatically, with a variable number of Class
     * elements and attributes per class. For the given number of attributes,
     * each String, Float and Integer attributes are created.
     * 
     * @param classesSize The number of classes to be created
     * @param attributesSize The number of attributes per class to be created
     * @return
     */
    public ModelPartition createParameterizedMetaModel( int classesSize, int attributesSize ) throws Exception {

        CoreConnection coreConn = getTestHelper( ).getCoreConnection( conn );
        // generatedMetaModel.xml=PF.DefaultDataArea:DCs/sap.com/tc/moin/testcases_1.0/_comp/generatedMetaModel,true
        ModelPartition mp = this.testClient1.getOrCreatePartitionStable( "generatedMetaModel" );

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Generating the metamodel with these parameters:" );
            logger.trace( MoinSeverity.INFO, "Classes........" + classesSize );
            logger.trace( MoinSeverity.INFO, "Attributes....." + attributesSize );
        }

        MofPackage metaModelPackage = null;
        MofClass[] tmpClass = new MofClass[classesSize];
        MofClass tmpSubClass = null;
        Association tmpAssoc = null;
        AssociationEnd aEndA = null;
        AssociationEnd aEndB = null;
        Attribute attr = null;
        Reference ref = null;
        EnumerationType enumTp = null;
        StructureType structTp = null;
        StructureType structInStructTp = null;
        StructureField field1 = null;
        StructureField field2 = null;
        StructureField field3 = null;

        Tag attachTag = (Tag) this.mofModelPackage.getTag( ).refCreateInstance( );
        attachTag.setName( "javax.jmi.packagePrefix=com.sap.tc.moin.repository.test.query" );
        attachTag.setAnnotation( "" );
        attachTag.setTagId( "javax.jmi.packagePrefix" );
        attachTag.getValues( ).add( "com.sap.tc.moin.repository.test.query" );

        metaModelPackage = (MofPackage) this.mofModelPackage.getMofPackage( ).refCreateInstance( );
        metaModelPackage.setName( "generatedmetamodel" );
        metaModelPackage.setRoot( true );
        metaModelPackage.setLeaf( true );
        setDefaultValues( metaModelPackage );

        /*
         * create AttachesTo
         */

        this.mofModelPackage.getAttachesTo( ).add( metaModelPackage, attachTag );
        attachTag.setContainer( metaModelPackage );

        /*
         * create an Enumeration Type
         */

        enumTp = (EnumerationType) this.mofModelPackage.getEnumerationType( ).refCreateInstance( );
        this.setDefaultValues( enumTp );
        enumTp.setName( "EnumTp" );
        enumTp.setLeaf( true );
        enumTp.setRoot( true );
        enumTp.getLabels( ).add( "Label1" );
        enumTp.getLabels( ).add( "Label2" );
        enumTp.getLabels( ).add( "Label3" );
        enumTp.getLabels( ).add( "Label4" );
        enumTp.getLabels( ).add( "Label5" );
        enumTp.getLabels( ).add( "Label6" );
        enumTp.getLabels( ).add( "Label7" );
        enumTp.getLabels( ).add( "Label8" );
        enumTp.getLabels( ).add( "Label9" );
        enumTp.getLabels( ).add( "Label10" );
        enumTp.setContainer( metaModelPackage );

        /*
         * create a structure type
         */
        structInStructTp = (StructureType) this.mofModelPackage.getStructureType( ).refCreateInstance( );
        this.setDefaultValues( structInStructTp );
        structInStructTp.setName( "StructInStructTp" );
        structInStructTp.setRoot( true );
        structInStructTp.setLeaf( true );
        structInStructTp.setContainer( metaModelPackage );
        field1 = (StructureField) this.mofModelPackage.getStructureField( ).refCreateInstance( );
        this.setDefaultValues( field1 );
        field1.setName( "Field1" );
        field1.setType( this.mofPrimitives.get( "Integer" ) );
        field1.setContainer( structInStructTp );
        field2 = (StructureField) this.mofModelPackage.getStructureField( ).refCreateInstance( );
        this.setDefaultValues( field2 );
        field2.setName( "Field2" );
        field2.setType( this.mofPrimitives.get( "String" ) );
        field2.setContainer( structInStructTp );

        /*
         * create a structure type that has a structure type field
         */

        structTp = (StructureType) this.mofModelPackage.getStructureType( ).refCreateInstance( );
        this.setDefaultValues( structTp );
        structTp.setName( "StructTp" );
        structTp.setRoot( true );
        structTp.setLeaf( true );
        structTp.setContainer( metaModelPackage );
        field1 = (StructureField) this.mofModelPackage.getStructureField( ).refCreateInstance( );
        this.setDefaultValues( field1 );
        field1.setName( "Field1" );
        field1.setType( this.mofPrimitives.get( "Integer" ) );
        field1.setContainer( structTp );
        field2 = (StructureField) this.mofModelPackage.getStructureField( ).refCreateInstance( );
        this.setDefaultValues( field2 );
        field2.setName( "Field2" );
        field2.setType( this.mofPrimitives.get( "String" ) );
        field2.setContainer( structTp );
        field3 = (StructureField) this.mofModelPackage.getStructureField( ).refCreateInstance( );
        this.setDefaultValues( field3 );
        field3.setName( "Field3" );
        field3.setType( structInStructTp );
        field3.setContainer( structTp );

        /*
         * create classes
         */

        if ( classesSize > 0 ) {
            for ( int i = 0; i < classesSize; i++ ) {
                tmpClass[i] = (MofClass) this.mofModelPackage.getMofClass( ).refCreateInstance( );
                this.setDefaultValues( tmpClass[i] );
                tmpClass[i].setName( "TestClass" + i );
                tmpClass[i].setContainer( metaModelPackage );

                tmpSubClass = (MofClass) this.mofModelPackage.getMofClass( ).refCreateInstance( );
                this.setDefaultValues( tmpSubClass );
                tmpSubClass.setName( "TestSubClass" + i );
                tmpSubClass.setContainer( metaModelPackage );
                tmpSubClass.getSupertypes( ).add( tmpClass[i] );

            }
        }

        /*
         * create attributes of type String, String(multivalued), Integer,
         * Double; also create object-valued attributes
         */

        com.sap.tc.moin.repository.mmi.model.MultiplicityType mt = coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 1, 1, false, false );
        com.sap.tc.moin.repository.mmi.model.MultiplicityType mtMulti = coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 1, 10, false, false );

        for ( int c = 0; c < classesSize; c++ ) {
            attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
            this.setDefaultValues( attr );
            attr.setName( "name" );
            attr.setType( this.mofPrimitives.get( "String" ) );
            attr.setMultiplicity( mt );
            attr.setChangeable( true );
            attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            attr.setDerived( false );
            attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
            attr.setContainer( tmpClass[c] );

            for ( int a = 0; a < attributesSize; a++ ) {
                attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
                this.setDefaultValues( attr );
                attr.setName( "attrString" + a );
                attr.setType( this.mofPrimitives.get( "String" ) );
                attr.setMultiplicity( mt );
                attr.setChangeable( true );
                attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
                attr.setDerived( false );
                attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
                attr.setContainer( tmpClass[c] );

                attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
                this.setDefaultValues( attr );
                attr.setName( "attrStringMultiValued" + a );
                attr.setType( this.mofPrimitives.get( "String" ) );
                attr.setMultiplicity( mtMulti );
                attr.setChangeable( true );
                attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
                attr.setDerived( false );
                attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
                attr.setContainer( tmpClass[c] );

                attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
                this.setDefaultValues( attr );
                attr.setName( "attrInt" + a );
                attr.setType( this.mofPrimitives.get( "Integer" ) );
                attr.setMultiplicity( mt );
                attr.setChangeable( true );
                attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
                attr.setDerived( false );
                attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
                attr.setContainer( tmpClass[c] );

                attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
                this.setDefaultValues( attr );
                attr.setName( "attrDouble" + a );
                attr.setType( this.mofPrimitives.get( "Double" ) );
                attr.setMultiplicity( mt );
                attr.setChangeable( true );
                attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
                attr.setDerived( false );
                attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
                attr.setContainer( tmpClass[c] );
            }

//            attr = this.mofModelPackage.getAttribute( ).createAttribute( );
//            this.setDefaultValues( attr );
//            attr.setName( "attrStringDerived" );
//            attr.setType( (PrimitiveType) this.mofPrimitives.get( "String" ) );
//            attr.setMultiplicity( mt );
//            attr.setChangeable( true );
//            attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
//            attr.setDerived( true );
//            attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
//            attr.setContainer( tmpClass[c] );

            // the number of object-valued attributes depends on the variable attributesSize;
            // yet, if there are less types than attributes, the number of object-valued
            // attributes is only as high as the number of classes.
            int objValSize = java.lang.Math.min( attributesSize, classesSize );

            for ( int in = 0; in < objValSize; in++ ) {
                attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
                this.setDefaultValues( attr );
                attr.setName( "attrObjectValued" + in );
                attr.setType( tmpClass[in] );
                attr.setMultiplicity( mt );
                attr.setChangeable( true );
                attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
                attr.setDerived( false );
                attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
                attr.setContainer( tmpClass[c] );
            }

            attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
            this.setDefaultValues( attr );
            attr.setName( "attrStruct" );
            attr.setType( structTp );
            attr.setMultiplicity( mt );
            attr.setChangeable( true );
            attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            attr.setDerived( false );
            attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
            attr.setContainer( tmpClass[c] );

            attr = (Attribute) this.mofModelPackage.getAttribute( ).refCreateInstance( );
            this.setDefaultValues( attr );
            attr.setName( "attrEnum" );
            attr.setType( enumTp );
            attr.setMultiplicity( mt );
            attr.setChangeable( true );
            attr.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            attr.setDerived( false );
            attr.setScope( ScopeKindEnum.INSTANCE_LEVEL );
            attr.setContainer( tmpClass[c] );
        }

        /*
         * Create associatons between classes; here, a complete graph is
         * generated. associations are named Assoc<m>x<n> "left ends" are named
         * Assoc<m>x<n>EndA "right ends" are named Assoc<m>x<n>EndB Furthermore,
         * for each class there exists an association to Reflect::Element
         */

        String lin_prefix = "";

        for ( int end1 = 0; end1 < classesSize; end1++ ) {

            // This was used to distinguish (n)x(n+1) associations from
            // others using prefix "Linear"
            // lin_prefix="Linear";

            for ( int end2 = 0; end2 < classesSize; end2++ ) {

                if ( !( end1 == end2 ) ) {
                    // create an association
                    tmpAssoc = (Association) this.mofModelPackage.getAssociation( ).refCreateInstance( );
                    this.setDefaultValues( tmpAssoc );
                    tmpAssoc.setName( "Assoc" + lin_prefix + end1 + "x" + end2 );
                    tmpAssoc.setContainer( metaModelPackage );

                    // create association ends
                    aEndA = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
                    this.setDefaultValues( aEndA );
                    aEndA.setName( "assoc" + lin_prefix + end1 + "x" + end2 + "EndA" );
                    aEndA.setType( tmpClass[end1] );
                    aEndA.setAggregation( AggregationKindEnum.NONE );
                    aEndA.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, 1, false, false ) );
                    aEndA.setContainer( tmpAssoc );
                    aEndA.setChangeable( true );
                    aEndA.setNavigable( true );

                    aEndB = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
                    this.setDefaultValues( aEndB );
                    aEndB.setName( "assoc" + lin_prefix + end1 + "x" + end2 + "EndB" );
                    aEndB.setType( tmpClass[end2] );
                    aEndB.setAggregation( AggregationKindEnum.NONE );
                    aEndB.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 1, -1, false, true ) );
                    aEndB.setContainer( tmpAssoc );
                    aEndB.setChangeable( true );
                    aEndB.setNavigable( true );

                    ref = (Reference) this.mofModelPackage.getReference( ).refCreateInstance( );
                    this.setDefaultValues( ref );
                    ref.setReferencedEnd( aEndB );
                    ref.setName( "reference" + lin_prefix + end1 + "x" + end2 );
                    ref.setType( aEndB.getType( ) );
                    ref.setMultiplicity( aEndB.getMultiplicity( ) );
                    ref.setExposedEnd( aEndA );
                    ref.setContainer( aEndA.getType( ) );
                    ref.setChangeable( true );
                    ref.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
                    ref.setScope( ScopeKindEnum.INSTANCE_LEVEL );

                    // lin_prefix="";
                }
            }

            // create an association
            tmpAssoc = (Association) this.mofModelPackage.getAssociation( ).refCreateInstance( );
            this.setDefaultValues( tmpAssoc );
            tmpAssoc.setName( "Assoc" + end1 + "xRefElement" );
            tmpAssoc.setContainer( metaModelPackage );

            // create association ends
            aEndA = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
            this.setDefaultValues( aEndA );
            aEndA.setName( "assoc" + lin_prefix + end1 + "xRefElementEndA" );
            aEndA.setType( tmpClass[end1] );
            aEndA.setAggregation( AggregationKindEnum.NONE );
            aEndA.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 1, -1, false, true ) );
            aEndA.setContainer( tmpAssoc );
            aEndA.setChangeable( true );
            aEndA.setNavigable( true );

            aEndB = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
            this.setDefaultValues( aEndB );
            aEndB.setName( "assoc" + end1 + "xRefElementEndB" );
            aEndB.setType( this.refElmnt );
            aEndB.setAggregation( AggregationKindEnum.NONE );
            aEndB.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 1, -1, false, true ) );
            aEndB.setContainer( tmpAssoc );
            aEndB.setChangeable( true );
            aEndB.setNavigable( true );

            ref = (Reference) this.mofModelPackage.getReference( ).refCreateInstance( );
            this.setDefaultValues( ref );
            ref.setReferencedEnd( aEndB );
            ref.setName( "reference" + lin_prefix + end1 + "xRefElement" );
            ref.setType( aEndB.getType( ) );
            ref.setMultiplicity( aEndB.getMultiplicity( ) );
            ref.setExposedEnd( aEndA );
            ref.setContainer( aEndA.getType( ) );
            ref.setChangeable( true );
            ref.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            ref.setScope( ScopeKindEnum.INSTANCE_LEVEL );

            /*
             * create a composite association
             */

            tmpAssoc = (Association) this.mofModelPackage.getAssociation( ).refCreateInstance( );
            this.setDefaultValues( tmpAssoc );
            tmpAssoc.setName( "Assoc" + end1 + "Composite" );
            tmpAssoc.setContainer( metaModelPackage );

            // create association ends
            aEndA = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
            this.setDefaultValues( aEndA );
            aEndA.setName( "assoc" + end1 + "CompositeEndA" );
            aEndA.setType( tmpClass[end1] );
            aEndA.setAggregation( AggregationKindEnum.COMPOSITE );
            aEndA.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 0, 1, false, false ) );
            aEndA.setContainer( tmpAssoc );
            aEndA.setChangeable( true );
            aEndA.setNavigable( true );

            aEndB = (AssociationEnd) this.mofModelPackage.getAssociationEnd( ).refCreateInstance( );
            this.setDefaultValues( aEndB );
            aEndB.setName( "assoc" + end1 + "CompositeEndB" );
            aEndB.setType( tmpClass[end1] );
            aEndB.setAggregation( AggregationKindEnum.NONE );
            aEndB.setMultiplicity( coreConn.getCoreJmiHelper( ).createMultiplicityType( coreConn, 1, -1, false, true ) );
            aEndB.setContainer( tmpAssoc );
            aEndB.setChangeable( true );
            aEndB.setNavigable( true );

            ref = (Reference) this.mofModelPackage.getReference( ).refCreateInstance( );
            this.setDefaultValues( ref );
            ref.setReferencedEnd( aEndB );
            ref.setName( "reference" + end1 + "Composite" );
            ref.setType( aEndB.getType( ) );
            ref.setMultiplicity( aEndB.getMultiplicity( ) );
            ref.setExposedEnd( aEndA );
            ref.setContainer( aEndA.getType( ) );
            ref.setChangeable( true );
            ref.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
            ref.setScope( ScopeKindEnum.INSTANCE_LEVEL );

            /*
             * create a derived association
             */
//
//            tmpAssoc = this.mofModelPackage.getAssociation( ).createAssociation( );
//            this.setDefaultValues( tmpAssoc );
//            tmpAssoc.setName( "Assoc" + end1 + "Derived" );
//            tmpAssoc.setContainer( metaModelPackage );
//            tmpAssoc.setDerived( true );
//
//            // create association ends
//            aEndA = this.mofModelPackage.getAssociationEnd( ).createAssociationEnd( );
//            this.setDefaultValues( aEndA );
//            aEndA.setName( "assoc" + lin_prefix + end1 + "DerivedEndA" );
//            aEndA.setType( tmpClass[end1] );
//            aEndA.setAggregation( AggregationKindEnum.NONE );
//            aEndA.setMultiplicity( this.mofModelPackage.createMultiplicityType( 0, -1, false, true ) );
//            aEndA.setContainer( tmpAssoc );
//            aEndA.setChangeable( true );
//            aEndA.setNavigable( true );
//
//            aEndB = this.mofModelPackage.getAssociationEnd( ).createAssociationEnd( );
//            this.setDefaultValues( aEndB );
//            aEndB.setName( "assoc" + end1 + "DerivedEndB" );
//            aEndB.setType( tmpClass[end1] );
//            aEndB.setAggregation( AggregationKindEnum.NONE );
//            aEndB.setMultiplicity( this.mofModelPackage.createMultiplicityType( 0, -1, false, true ) );
//            aEndB.setContainer( tmpAssoc );
//            aEndB.setChangeable( true );
//            aEndB.setNavigable( true );
//
//            ref = this.mofModelPackage.getReference( ).createReference( );
//            this.setDefaultValues( ref );
//            ref.setReferencedEnd( aEndB );
//            ref.setName( "reference" + end1 + "Derived" );
//            ref.setType( aEndB.getType( ) );
//            ref.setMultiplicity( aEndB.getMultiplicity( ) );
//            ref.setExposedEnd( aEndA );
//            ref.setContainer( aEndA.getType( ) );
//            ref.setChangeable( true );
//            ref.setVisibility( VisibilityKindEnum.PUBLIC_VIS );
//            ref.setScope( ScopeKindEnum.INSTANCE_LEVEL );
            // lin_prefix="";
        }

        mp.assignElementIncludingChildren( metaModelPackage );

        this.checkMofConstraints( metaModelPackage );

        return mp;
    }

    private void setDefaultValues( ModelElement modelElement ) {

        // C5074171: Test case adjustment due to changed default values
        modelElement.setAnnotation( "" );
        if ( modelElement instanceof GeneralizableElement ) {
            ( (GeneralizableElement) modelElement ).setVisibility( VisibilityKindEnum.PUBLIC_VIS );
        }
        if ( modelElement instanceof Association ) {
            ( (GeneralizableElement) modelElement ).setLeaf( true );
            ( (GeneralizableElement) modelElement ).setRoot( true );
        }
    }

    private Connection getMOINConnection( ) {

        this.testClient1 = getTestHelper( ).getDefaultTestClient( true );
        this.testClient1.setAsCurrentClient( );
        return this.testClient1.getConnection( );
    }

    private void checkMofConstraints( ModelElement modelElement ) {

        Collection<JmiException> jmiExceptions = modelElement.refVerifyConstraints( false );
        if ( jmiExceptions == null ) {
            jmiExceptions = new ArrayList<JmiException>( );
        }
        if ( modelElement instanceof Namespace ) {
            for ( ModelElement me : ( (Namespace) modelElement ).getContents( ) ) {
                Collection<JmiException> childResult = me.refVerifyConstraints( false );
                if ( childResult != null ) {
                    jmiExceptions.addAll( childResult );
                }
            }
        }
        for ( JmiException e : jmiExceptions ) {
            e.printStackTrace( );
        }
    }
}