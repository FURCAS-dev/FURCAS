package com.sap.tc.moin.test.fw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.ModelPartition;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.mmi.descriptors.StructureFieldContainer;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.EnumTp;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.EnumTpEnum;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.StructInStructTp;
import com.sap.tc.moin.repository.test.query.generatedmetamodel.StructTp;

@SuppressWarnings( "nls" )
public class ModelDataInstantiator {

    // trace setup
    protected static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, ModelDataInstantiator.class );

    private static final String PART_PREFIX = "generatedMM_instances";

    // by definition the 5th attribute has an emptyString value
    private static final int EMPTY_STRING_ATTR_NUM = 5;

    static public String partitionNameAppendix = "";

    private TestClient testClient;

    private int mmSize = 10;

    private int attrSize = 10;

    private int instSize = 10;

    private int partSize = 10;

    private boolean withSave = true;

    private boolean createObjValAttrs = true;

    public ModelDataInstantiator( TestClient testClient ) {

        this.testClient = testClient;
    }

    public ModelDataInstantiator( TestClient testClient, boolean withSave, int mmSize, int attributeSize, int instanceSize, int partitionSize, boolean createObjValAttrs ) {

        this.testClient = testClient;
        this.withSave = withSave;
        this.mmSize = mmSize;
        this.attrSize = attributeSize;
        this.instSize = instanceSize;
        this.partSize = partitionSize;
        this.createObjValAttrs = createObjValAttrs;
    }

    public boolean createData( ) throws Exception {

        if ( mmSize < 3 ) {
            mmSize = 3;
            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, "Number of classes too low; forced reset to minimum value (3)" );
            }
        }
        if ( attrSize < 3 ) {
            attrSize = 3;
            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, "Number of attributes too low; forced reset to minimum value (3)" );
            }
        }
        if ( instSize < 3 ) {
            instSize = 3;
            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, "Number of instances too low; forced reset to minimum value (3)" );
            }
        }

        // delete partitions (only if we save the new ones)
        if ( withSave ) {
            if ( logger.isTraced( MoinSeverity.INFO ) ) {
                logger.trace( MoinSeverity.INFO, "Query Test: DELETING OLD PARTITIONS" );
            }
            removeData( );
        }

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "ModelDataInstantiator: CREATING NEW INSTANCE DATA" );
        }

        // instantiate data
        instantiate( );

        // if we have to save partitions and clean up
        if ( withSave ) {
            saveData( );
        }

        return true;
    }

    public Collection<PRI> loadData( ) throws Exception {

        this.testClient.setAsCurrentClient( );
        Connection myConn = testClient.getConnection( );

        return this.getAllPartitions( myConn );
    }

    public int removeData( ) throws Exception {

        this.testClient.setAsCurrentClient( );

        Connection myConn = testClient.getConnection( );

        // actually delete partitions
        int dp = delete_inst_partitions( myConn );

        // save partitions
        myConn.save( );

        return dp;
    }

    private void instantiate( ) throws Exception {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Instantiation Parameters:" );
            logger.trace( MoinSeverity.INFO, "Classes (types)........." + mmSize + " (minimum 3)" );
            logger.trace( MoinSeverity.INFO, "Attributes (each)......." + attrSize + " (minimum 3)" );
            logger.trace( MoinSeverity.INFO, "Instances per Class....." + instSize + " (minimum 3)" );
            logger.trace( MoinSeverity.INFO, "Partitions.............." + partSize );
        }
        Connection myConn = testClient.getConnection( );

        ModelPartition[] instPart = new ModelPartition[partSize];
        RefPackage gpackage1 = null;

        for ( int i = 0; i < partSize; i++ ) {
            instPart[i] = this.testClient.getOrCreatePartitionStable( getInstPartName( i ) );
        }

        gpackage1 = myConn.getPackage( null, new String[] { "generatedmetamodel" } );

        Object tmpClass = null;
        Object tmpSubClass = null;
        Object tmpObjValClass = null;
        Object[][][] tmpObjValAttribute = new Object[mmSize][instSize][Math.min( mmSize, attrSize )];
        Object[][] tmpElements = new Object[mmSize][instSize];
        Object[][] tmpSubElements = new Object[mmSize][instSize];

        // arrays for the reflective 'invoke' methods; these are used
        // repeatedly,
        // instead of initializing a new Object every time

        Class[] intClass = new Class[] { int.class };
        Class[] doubleClass = new Class[] { double.class };
        Class[] stringClass = new Class[] { String.class };

        int intAttr;
        double dblAttr;
        String className;
        String stringAttr;
        Object structAttr;
        Object structAttrInStructAttr;
        Object enumAttr;
        Collection stringAttrMV;

        for ( int testClassNr = 0; testClassNr < mmSize; testClassNr++ ) {
            for ( int instNr = 0; instNr < instSize; instNr++ ) {

                /*
                 * create TestClass and TestSubClass objects via JMI reflection
                 * (which itself is invoked by Java Reflection)
                 */

                tmpClass = gpackage1.getClass( ).getMethod( "getTestClass" + testClassNr, (Class[]) null ).invoke( gpackage1, (Object[]) null );
                tmpElements[testClassNr][instNr] = tmpClass.getClass( ).getMethod( "refCreateInstance", (Class[]) null ).invoke( tmpClass, (Object[]) null );
                className = calculateClassName( testClassNr, instNr, false );
                tmpElements[testClassNr][instNr].getClass( ).getMethod( "setName", stringClass ).invoke( tmpElements[testClassNr][instNr], className );

                tmpSubClass = gpackage1.getClass( ).getMethod( "getTestSubClass" + testClassNr, (Class[]) null ).invoke( gpackage1, (Object[]) null );
                tmpSubElements[testClassNr][instNr] = tmpSubClass.getClass( ).getMethod( "refCreateInstance", (Class[]) null ).invoke( tmpSubClass, (Object[]) null );
                className = calculateClassName( testClassNr, instNr, true );
                tmpSubElements[testClassNr][instNr].getClass( ).getMethod( "setName", stringClass ).invoke( tmpSubElements[testClassNr][instNr], className );

                /*
                 * set attribute values
                 */

                for ( int attrNr = 0; attrNr < attrSize; attrNr++ ) {

                    intAttr = calculateIntAttr( testClassNr, instNr, attrNr );
                    dblAttr = calculateDoubleAttr( testClassNr, instNr, attrNr );
                    stringAttr = calculateStringAttr( testClassNr, instNr, attrNr, false );

                    tmpElements[testClassNr][instNr].getClass( ).getMethod( "setAttrInt" + attrNr, intClass ).invoke( tmpElements[testClassNr][instNr], intAttr );
                    tmpElements[testClassNr][instNr].getClass( ).getMethod( "setAttrDouble" + attrNr, doubleClass ).invoke( tmpElements[testClassNr][instNr], dblAttr );
                    tmpElements[testClassNr][instNr].getClass( ).getMethod( "setAttrString" + attrNr, stringClass ).invoke( tmpElements[testClassNr][instNr], stringAttr );

                    stringAttrMV = (Collection) tmpElements[testClassNr][instNr].getClass( ).getMethod( "getAttrStringMultiValued" + attrNr, (Class[]) null ).invoke( tmpElements[testClassNr][instNr], (Object[]) null );

                    /*
                     * set multi-valued String attributes
                     */
                    for ( int in = 0; in < 10; in++ ) {
                        String st = calculateMultiValuedStringAttr( testClassNr, instNr, attrNr, in, false );
                        stringAttrMV.add( st );
                    }

                    /*
                     * set attributes for subclasses
                     */

                    stringAttr = calculateStringAttr( testClassNr, instNr, attrNr, true );

                    tmpSubElements[testClassNr][instNr].getClass( ).getMethod( "setAttrInt" + attrNr, intClass ).invoke( tmpSubElements[testClassNr][instNr], intAttr );
                    tmpSubElements[testClassNr][instNr].getClass( ).getMethod( "setAttrDouble" + attrNr, doubleClass ).invoke( tmpSubElements[testClassNr][instNr], dblAttr );
                    tmpSubElements[testClassNr][instNr].getClass( ).getMethod( "setAttrString" + attrNr, stringClass ).invoke( tmpSubElements[testClassNr][instNr], stringAttr );
                }

                /*
                 * set structure type attribute
                 */

                Object[] structFields = new Object[2];
                structFields[0] = testClassNr;
                structFields[1] = "TestClass" + testClassNr + "Inst" + instNr + "structValueField3structValue";

                StructureFieldContainer<StructInStructTp> containerStructInStructTp = new StructureFieldContainer<StructInStructTp>( );
                containerStructInStructTp.put( StructInStructTp.DESCRIPTORS.FIELD1( ), (Integer) structFields[0] ).put( StructInStructTp.DESCRIPTORS.FIELD2( ), (String) structFields[1] );

                structAttrInStructAttr = gpackage1.getClass( ).getMethod( "createStructInStructTp", new Class[] { StructureFieldContainer.class } ).invoke( gpackage1, containerStructInStructTp );

                structFields = new Object[3];

                structFields[0] = testClassNr;
                structFields[1] = "TestClass" + testClassNr + "Inst" + instNr + "structValue";
                structFields[2] = structAttrInStructAttr;

                StructureFieldContainer<StructTp> containerStructTp = new StructureFieldContainer<StructTp>( );
                containerStructTp.put( StructTp.DESCRIPTORS.FIELD1( ), (Integer) structFields[0] ).put( StructTp.DESCRIPTORS.FIELD2( ), (String) structFields[1] ).put( StructTp.DESCRIPTORS.FIELD3( ), (StructInStructTp) structFields[2] );

                structAttr = gpackage1.getClass( ).getMethod( "createStructTp", new Class[] { StructureFieldContainer.class } ).invoke( gpackage1, containerStructTp );

                tmpElements[testClassNr][instNr].getClass( ).getMethod( "setAttrStruct", new Class[] { StructTp.class } ).invoke( tmpElements[testClassNr][instNr], structAttr );

                /*
                 * set Enum type attribute
                 */

                enumAttr = EnumTpEnum.forName( "Label1" );

                tmpElements[testClassNr][instNr].getClass( ).getMethod( "setAttrEnum", new Class[] { EnumTp.class } ).invoke( tmpElements[testClassNr][instNr], enumAttr );

                /*
                 * create object-valued attributes
                 */
                if ( createObjValAttrs ) {
                    // we put all object values as instances of TestClass0
                    int ovaNr = 0;
                    // create factory for correct class for object value
                    tmpObjValClass = gpackage1.getClass( ).getMethod( "getTestClass" + ovaNr, (Class[]) null ).invoke( gpackage1, (Object[]) null );
                    // create object value
                    tmpObjValAttribute[testClassNr][instNr][ovaNr] = tmpObjValClass.getClass( ).getMethod( "refCreateInstance", (Class[]) null ).invoke( tmpObjValClass, (Object[]) null );
                    // calculate object valued attribute name for current class
                    className = calculateObjectValuedAttrName( testClassNr, instNr, ovaNr, false );
                    // assign object value to attribute
                    tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass( ).getMethod( "setName", stringClass ).invoke( tmpObjValAttribute[testClassNr][instNr][ovaNr], className );

                    /*
                     * create attribute values object-valued attributes
                     */

                    for ( int attrNr = 0; attrNr < attrSize; attrNr++ ) {
                        intAttr = calculateIntAttr( testClassNr, instNr, attrNr );
                        dblAttr = calculateDoubleAttr( testClassNr, instNr, attrNr );
                        stringAttr = className + "strValue" + attrNr;

                        tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass( ).getMethod( "setAttrInt" + attrNr, intClass ).invoke( tmpObjValAttribute[testClassNr][instNr][ovaNr], intAttr );
                        tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass( ).getMethod( "setAttrDouble" + attrNr, doubleClass ).invoke( tmpObjValAttribute[testClassNr][instNr][ovaNr], dblAttr );
                        tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass( ).getMethod( "setAttrString" + attrNr, stringClass ).invoke( tmpObjValAttribute[testClassNr][instNr][ovaNr], stringAttr );

                        stringAttrMV = (Collection) tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass( ).getMethod( "getAttrStringMultiValued" + attrNr, (Class[]) null ).invoke( tmpObjValAttribute[testClassNr][instNr][ovaNr], (Object[]) null );

                        /*
                         * set multi-valued String attributes
                         */

                        for ( int in = 0; in < 10; in++ ) {
                            stringAttrMV.add( className + "strMultiValued" + attrNr + "Value" + in );
                        }
                    }

                    tmpElements[testClassNr][instNr].getClass( ).getInterfaces( )[0].getMethod( "setAttrObjectValued" + ( ovaNr ), tmpObjValAttribute[testClassNr][instNr][ovaNr].getClass( ).getInterfaces( )[0] ).invoke( tmpElements[testClassNr][instNr],
                                                                                                                                                                                                                            tmpObjValAttribute[testClassNr][instNr][ovaNr] );
                }
            }
        }

        // add links between instances

        Object testAssoc;
        Class[] addTypes = new Class[2];
        Object[] addElements = new Object[2];

        for ( int testClassNrA = 0; testClassNrA < mmSize; testClassNrA++ ) {
            for ( int testClassNrB = testClassNrA + 1; testClassNrB < mmSize; testClassNrB++ ) {
                if ( !( testClassNrA == testClassNrB ) ) {

                    testAssoc = gpackage1.getClass( ).getMethod( "getAssoc" + testClassNrA + "x" + testClassNrB, (Class[]) null ).invoke( gpackage1, (Object[]) null );
                    for ( int instNr = 0; instNr < instSize; instNr++ ) {
                        addTypes[0] = tmpElements[testClassNrA][instNr].getClass( ).getInterfaces( )[0];
                        addTypes[1] = tmpElements[testClassNrB][instNr].getClass( ).getInterfaces( )[0];
                        addElements[0] = tmpElements[testClassNrA][instNr];
                        addElements[1] = tmpElements[testClassNrB][instNr];
                        testAssoc.getClass( ).getMethod( "add", addTypes ).invoke( testAssoc, addElements );
                        addElements[0] = tmpElements[testClassNrA][instNr];
                        addElements[1] = tmpSubElements[testClassNrB][instNr];
                        testAssoc.getClass( ).getMethod( "add", addTypes ).invoke( testAssoc, addElements );

                    }

                }
            }

            testAssoc = gpackage1.getClass( ).getMethod( "getAssoc" + testClassNrA + "xRefElement", (Class[]) null ).invoke( gpackage1, (Object[]) null );
            for ( int instNr = 0; instNr < instSize; instNr++ ) {
                addTypes[0] = tmpElements[testClassNrA][0].getClass( ).getInterfaces( )[0];
                addTypes[1] = RefObject.class;
                addElements[0] = tmpElements[testClassNrA][0];
                addElements[1] = tmpElements[testClassNrA][instNr];
                testAssoc.getClass( ).getMethod( "add", addTypes ).invoke( testAssoc, addElements );
            }

        }

        // persist class objects
        // objects are distributed to partitions "instPart0" ..
        // "instPart<partSize-1>"

        for ( int i = 0; i < mmSize; i++ ) {
            for ( int k = 0; k < instSize; k++ ) {

                int assignNr = calculatePartitionForClassNr( i, partSize );
                instPart[assignNr].assignElement( (Partitionable) tmpElements[i][k] );
                instPart[assignNr].assignElement( (Partitionable) tmpSubElements[i][k] );

                if ( createObjValAttrs ) {
                    instPart[assignNr].assignElement( (Partitionable) tmpObjValAttribute[i][k][0] );
                }

            }
        }

        tmpClass = null;
        tmpSubClass = null;

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Instantiation finished." );
        }

    }

    public void saveData( ) throws Exception {

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Saving ... " );
        }
        Connection conn = testClient.getConnection( );
        conn.save( );

    }

    private int delete_inst_partitions( Connection myConn ) throws Exception {

        int deletedPartitions = 0;

        Collection<PRI> persistedPartitionsList = getAllPartitions( myConn );

        long time = System.currentTimeMillis( );

        for ( Iterator<PRI> partIter = persistedPartitionsList.iterator( ); partIter.hasNext( ); ) {
            PRI currentPRI = partIter.next( );
            if ( currentPRI.getPartitionName( ).contains( "generatedMM" ) ) {
                ModelPartition mp = myConn.getPartition( currentPRI );
                if ( mp != null ) {
                    mp.delete( );
                }
                deletedPartitions++;
                if ( logger.isTraced( MoinSeverity.INFO ) ) {
                    logger.trace( MoinSeverity.INFO, "Deleting partition: " + currentPRI.getPartitionName( ) );
                }
            }
        }

        if ( logger.isTraced( MoinSeverity.INFO ) ) {
            logger.trace( MoinSeverity.INFO, "Deleting instances took " + ( System.currentTimeMillis( ) - time ) + " ms." );
        }
        return deletedPartitions;
    }

    /*
     * Static helper functions for the calculation of attribute values; these
     * can be used by the instantiation method and the queries (to calculate the
     * intended result set)
     */

    static public String calculateClassName( int testClassNr, int instNr, boolean subClass ) {

        return "Test" + ( subClass ? "Sub" : "" ) + "Class" + testClassNr + "Inst" + instNr;
    }

    static public int calculateIntAttr( int testClassNr, int instNr, int attrNr ) {

        return testClassNr * 1000000 + attrNr * 1000 + instNr;
    }

    static public double calculateDoubleAttr( int testClassNr, int instNr, int attrNr ) {

        return testClassNr * 1000000 + attrNr * 1000 + instNr;
    }

    static public String calculateStringAttr( int testClassNr, int instNr, int attrNr, boolean subClass ) {

        if ( attrNr == EMPTY_STRING_ATTR_NUM ) {
            return "";
        }
        return "Test" + ( subClass ? "Sub" : "" ) + "Class" + testClassNr + "Inst" + instNr + "strValue" + attrNr;
    }

    static public String calculateMultiValuedStringAttr( int testClassNr, int instNr, int attrNr, int valueNr, boolean subClass ) {

        return "Test" + ( subClass ? "Sub" : "" ) + "Class" + testClassNr + "Inst" + instNr + "strMultiValued" + attrNr + "Value" + valueNr;
    }

    static public String calculateObjectValuedAttrName( int testClassNr, int instNr, int attrNr, boolean subClass ) {

        return "Test" + ( subClass ? "Sub" : "" ) + "Class" + testClassNr + "Inst" + instNr + "attrObjValued" + attrNr;
    }

    static public int calculatePartitionForClassNr( int testClassNr, int _partSize ) {

        return testClassNr % _partSize;
    }

    static public String getInstPartName( int partNr ) {

        return PART_PREFIX + partNr + partitionNameAppendix;
    }

    public Collection<PRI> getAllPartitions( Connection conn ) throws Exception {

        DataAreaDescriptor dataAreaDescriptor = this.testClient.getClientSpec( ).getDataArea( ).getDescriptor( );
        CRI cri = conn.getSession( ).getMoin( ).createCri( dataAreaDescriptor.getFacilityId( ), dataAreaDescriptor.getDataAreaName( ), "test.sap.com/tc/moin/repository/test" );
        Collection<PRI> allMaxRelevantPartitions = conn.getSession( ).getInnerPartitions( cri );
        // Clone list, because returned list is unmodifiable
        allMaxRelevantPartitions = new ArrayList<PRI>( allMaxRelevantPartitions );
        for ( Iterator<PRI> iter = allMaxRelevantPartitions.iterator( ); iter.hasNext( ); ) {
            PRI pri = iter.next( );
            String partitionName = pri.getPartitionName( );
            if ( !partitionName.contains( PART_PREFIX ) ) {
                iter.remove( );
            }
        }

        return allMaxRelevantPartitions;
    }

    public void shutdown( ) {

        if ( testClient != null ) {
            testClient.clear( );
        }
        testClient = null;
    }
}
