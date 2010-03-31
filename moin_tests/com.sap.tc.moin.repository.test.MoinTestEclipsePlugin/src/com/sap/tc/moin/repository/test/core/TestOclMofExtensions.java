/*
 * Created on 27.01.2005
 */
package com.sap.tc.moin.repository.test.core;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.ModelPackage;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.primitivetypes.PrimitiveTypesPackage;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.OclPackage;
import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.OperationCallExp;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.Partitionable;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.xmi.XmiWriter;
import com.sap.tc.moin.test.fw.TestMetaModels;


/**
 * Creates a little MOF model and creates links with varying storage (some based
 * on the existence of an exposing reference on the corresponding association
 * end, some based on explicit mark-up).
 * 
 * @author D043530
 */
public class TestOclMofExtensions extends CoreMoinTest {

    Connection moinConnection = null;

    com.sap.tc.moin.MoinPackage mofPackage = null;

    Workspace workspace = null;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );

        moinConnection = getMOINConnection( );
        mofPackage = (com.sap.tc.moin.MoinPackage) moinConnection.getPackage( TestMetaModels.MOIN_MOF_CN, TestMetaModels.MOIN_MOF_TPE_MOIN );
        workspace = getTestHelper( ).getCorePartitionable( ( (Partitionable) mofPackage ) ).get___Workspace( );
        ModelPackage mp = mofPackage.getModel( );
        OclPackage oclp = mofPackage.getOcl( );
        clazz = (MofClass) mp.getMofClass( ).refCreateInstance( );
        clazz.setName( "MyClass" );
        Attribute attribute = (Attribute) mp.getAttribute( ).refCreateInstance( );
        attribute.setName( "myAttribute" );
        clazz.getContents( ).add( attribute );
        attribute.setType( clazz );
        ace = (AttributeCallExp) oclp.getExpressions( ).getAttributeCallExp( ).refCreateInstance( );
        ace.setReferredAttribute( attribute );
        // TODO this is not working anymore
        // clazz.getContents( ).add( ace );
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        moinConnection = null;
        mofPackage = null;
        workspace = null;
        clazz = null;
        ace = null;
    }

    @Test
    public void testConstraintRetrieval( ) {

        Attribute a = null;
        for ( Iterator i = clazz.getContents( ).iterator( ); a == null && i.hasNext( ); ) {
            RefObject ro = (RefObject) i.next( );
            if ( ro instanceof Attribute ) {
                a = (Attribute) ro;
            }
        }
        verify( ace != null, "Expected to have an AttributeCallExp set" );
        verify( a != null, "Expected to find an Attribute myAttribute owned by class " + clazz.getName( ) );
        verify( ace.getReferredAttribute( ).equals( a ), "Attribute referred by OCL constraint doesn't equal " + "attribute myAttribute on class " + clazz.getName( ) );
    }

    /**
     * Creates an {@link OperationCallExp} and attaches it to a "+" operation
     * defined for the primitive type <tt>Integer</tt>.
     */
    @Test
    public void testOperationCallExpression( ) throws Exception {

        ModelPackage mp = mofPackage.getModel( );
        OclPackage oclp = mofPackage.getOcl( );
        PrimitiveTypesPackage ptp = mofPackage.getPrimitiveTypes( );
        MofPackage ptprp = (MofPackage) ptp.refMetaObject( );
        MofClass primitiveType = (MofClass) mp.getPrimitiveType( ).refMetaObject( );

        PrimitiveType integer = (PrimitiveType) ptprp.lookupElementExtended( "Integer" );
        Operation addOnInteger = (Operation) mp.getOperation( ).refCreateInstance( );
        addOnInteger.setName( "+" );
        Parameter a = (Parameter) mp.getParameter( ).refCreateInstance( );
        a.setName( "a" );
        a.setType( integer );
        Parameter b = (Parameter) mp.getParameter( ).refCreateInstance( );
        b.setName( "b" );
        b.setType( integer );
        Parameter ret = (Parameter) mp.getParameter( ).refCreateInstance( );
        ret.setName( "return" );
        ret.setType( integer );
        ret.setDirection( DirectionKindEnum.RETURN_DIR );
        addOnInteger.getContents( ).add( a );
        addOnInteger.getContents( ).add( b );
        addOnInteger.getContents( ).add( ret );
        OperationCallExp oce = (OperationCallExp) oclp.getExpressions( ).getOperationCallExp( ).refCreateInstance( );
        oce.setReferredOperation( addOnInteger );
        IntegerLiteralExp one = (IntegerLiteralExp) oclp.getExpressions( ).getIntegerLiteralExp( ).refCreateInstance( );
        one.setIntegerSymbol( 1 );
        IntegerLiteralExp two = (IntegerLiteralExp) oclp.getExpressions( ).getIntegerLiteralExp( ).refCreateInstance( );
        two.setIntegerSymbol( 2 );
        oce.getArguments( ).add( one );
        oce.getArguments( ).add( two );

        MofClass cls = (MofClass) mp.getMofClass( ).refCreateInstance( );
        cls.setName( "ClassWithOCLConstraint" );
        OclConstraint oc = (OclConstraint) oclp.getAttaching( ).getOclConstraint( ).refCreateInstance( );
        oc.getInvariantOf( ).add( cls );
        cls.getConstraints( ).add( oc );
        cls.getContents( ).add( oc );

        XmiWriter xmiWriter = moinConnection.getXmiWriter( );
        ByteArrayOutputStream bos = new ByteArrayOutputStream( );
        Collection objectsToWrite = new ArrayList( );
        objectsToWrite.add( addOnInteger );
        objectsToWrite.add( a );
        objectsToWrite.add( b );
        objectsToWrite.add( ret );
        objectsToWrite.add( one );
        objectsToWrite.add( two );
        objectsToWrite.add( oce );
        objectsToWrite.add( cls );
        xmiWriter.write( bos, objectsToWrite, "1.2" );
        bos.close( );
        String xmiOutput = bos.toString( );

    }

    // -------------------- attributes --------------------
    /**
     * A class to which a tag is attached
     */
    private MofClass clazz;

    /**
     * The workspace with which all instances are (currently manually)
     * registered
     */
    private AttributeCallExp ace;
}