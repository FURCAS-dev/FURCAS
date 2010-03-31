package com.sap.tc.moin.repository.test.ocl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.TupleType;

import com.sap.tc.moin.ocl.parser.impl.env.OCLEnvironment;
import com.sap.tc.moin.ocl.parser.impl.env.OCLLookupTables;
import com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.shared.util.ProcessReportImpl;
import com.sap.tc.moin.repository.test.ocl.base.BaseOclEvaluationTest;

/**
 * This class test the Environment. It tests the following:
 * <ul>
 * <li>lookup of variables</li>
 * <li>lookup of operations</li>
 * <li>lookup of attributes</li>
 * <li>lookup of associations</li>
 * <li>type conformance</li>
 * </ul>
 * 
 * @author Thomas Hettel (D039141)
 */
public class TestEnvironment extends BaseOclEvaluationTest {

    private static final List<Classifier> EMPTY_CLASSIFIER = Collections.emptyList( );

    private OCLEnvironment env;

    private OCLTypeChecker oclTypeChecker;

    private OCLLookupTables oclLookupTables;

    @Override
    @Before
    public void beforeTestMethod( ) throws Exception {

        super.beforeTestMethod( );
        // TODO type mapping tables?
        Set<RefPackage> typePackages = new HashSet<RefPackage>( );
        typePackages.add( this.svcIntPkg );
        synchronized ( this.syncObjectForWrite ) {
            // get an OCL type checker
            oclTypeChecker = new OCLTypeChecker( this.myJmiCreator );

            // get an OCL lookup table service
            oclLookupTables = new OCLLookupTables( this.myJmiCreator );

            // get the environment
            env = new OCLEnvironment( new ProcessReportImpl( ), this.myJmiCreator, this.svcIntPkg.refMetaObject( ), null, typePackages, null, null );
        }
    }

    @Override
    @After
    public void afterTestMethod( ) throws Exception {

        super.afterTestMethod( );
        this.env = null;
    }

    /**
     * Looksup opeations defined on the primitive types
     * 
     * @throws Exception
     */
    @Test
    public void testPrimitiveTypes( ) throws Exception {

        Classifier integer = this.myJmiCreator.getIntClass( );
        Classifier real = this.myJmiCreator.getFloatClass( );
        // test integer
        Operation op = this.oclLookupTables.lookupOperation( integer, "abs", EMPTY_CLASSIFIER, oclTypeChecker );
        verify( op != null, "Operation 'abs' must not be null" );
        verify( op.getName( ).equals( "abs" ), "Operation 'abs' must not have name 'abs'" );

        List<Classifier> args = new ArrayList<Classifier>( );
        args.add( integer );
        op = this.oclLookupTables.lookupOperation( integer, "min", args, oclTypeChecker );
        verify( op != null, "Operation 'min' must not be null" );
        verify( op.getName( ).equals( "min" ), "Operation 'min' must not have name 'min'" );

        op = this.oclLookupTables.lookupOperation( integer, "oclIsNew", EMPTY_CLASSIFIER, oclTypeChecker );
        verify( op != null, "Operation 'oclIsNew' must not be null" );
        verify( op.getName( ).equals( "oclIsNew" ), "Operation 'oclIsNew' must not have name 'oclIsNew'" );
        // test Float
        args.clear( );
        args.add( real );
        op = this.oclLookupTables.lookupOperation( real, "min", args, oclTypeChecker );
        verify( op != null, "Operation 'min' must not be null" );
        verify( op.getName( ).equals( "min" ), "Operation 'min' must not have name 'min'" );

        // test collectionTypes
        CollectionType col;
        synchronized ( this.syncObjectForWrite ) {
            col = this.myJmiCreator.createBagType( integer );
        }
        args.clear( );
        args.add( col );
        op = this.oclLookupTables.lookupOperation( col, "=", args, oclTypeChecker );
        verify( op != null, "Operation '=' must not be null" );
        verify( op.getName( ).equals( "equalsStdLib" ), "Operation '=' must have name 'equalsStdLib'" );

        args.clear( );
        args.add( integer );
        op = this.oclLookupTables.lookupOperation( col, "including", args, oclTypeChecker );
        verify( op != null, "Operation 'including' must not be null" );
        verify( op.getName( ).equals( "including" ), "Operation 'size' must not have name 'including'" );

    }

    /**
     * tests the lookup of variables.
     * 
     * @throws Exception
     */
    @Test
    public void testDeclareVariable( ) throws Exception {

        VariableDeclaration var1;
        VariableDeclaration var2;
        VariableDeclaration var3;
        synchronized ( this.syncObjectForWrite ) {
            Classifier integer = this.myJmiCreator.getIntClass( );
            // define some variable in different scopes
            this.env.enterNewVariableScope( );
            var1 = this.myJmiCreator.createVariableDeclaration( "var1", integer, null );
            this.env.declareVariable( var1 );
            this.env.enterNewVariableScope( );
            var2 = this.myJmiCreator.createVariableDeclaration( "var2", integer, null );
            this.env.declareVariable( var2 );
            var3 = this.myJmiCreator.createVariableDeclaration( "var3", integer, null );
            this.env.declareVariable( var3 );
        }
        VariableDeclaration var;
        // find var3
        var = this.env.lookupVarByName( "var3" );
        verify( var3.equals( var ), "wrong variable" );
        // find var2
        var = this.env.lookupVarByName( "var2" );
        verify( var2.equals( var ), "wrong variable" );
        // find var1
        var = this.env.lookupVarByName( "var1" );
        verify( var1.equals( var ), "wrong variable" );
        // leave last scope
        this.env.leaveVariableScope( );
        var = this.env.lookupVarByName( "var3" );
        verify( var == null, "var3 is not meant to be found." );
        var = this.env.lookupVarByName( "var2" );
        verify( var == null, "var2 is not meant to be found." );
        var = this.env.lookupVarByName( "var1" );
        verify( var1.equals( var ), "wrong variable" );
    }

    /**
     * tests the lookup of classifiers by pathname
     * 
     * @throws Exception
     */
    @Test
    public void testLookupByPathName( ) throws Exception {

        RefClass mc = this.svcIntPkg.getMessage( coreConnection );
        MofClassInternal mofC = (MofClassInternal) mc.refMetaObject( );
        // TODO can a pathname be something different than a list of Strings?
        List<String> pathName = mofC.getQualifiedName( coreConnection );
        Classifier c = this.env.lookupClassifierByPathName( pathName );
        verify( mofC.equals( c ), "error" );
        // TODO lookup more!
        mofC = (MofClassInternal) this.svcIntPkg.getOneWayInteractions( coreConnection ).refMetaObject( );
        pathName = mofC.getQualifiedName( coreConnection );
        c = this.env.lookupClassifierByPathName( pathName );
        verify( mofC.equals( c ), "error" );
    }

    /**
     * empty?
     */
    @Test
    public void testLookupImplAttr( ) {

        // TODO empty?
    }

    /**
     * tests the lookup of implicit references to association ends
     * 
     * @throws Exception
     */
    @Test
    public void testLookupImpAssociation( ) throws Exception {

        this.env.enterNewVariableScope( );
        // this.env.setTypesPackage(svcIntPkg);
        Classifier integer = this.myJmiCreator.getIntClass( );
        VariableDeclaration var1;

        Classifier c;

        VariableDeclaration var2;
        synchronized ( this.syncObjectForWrite ) {
            var1 = this.myJmiCreator.createVariableDeclaration( "var1", integer, null );
            List<String> pathName = new ArrayList<String>( );
            pathName.add( "ServiceInteractions" );
            pathName.add( "Message" );
            c = this.env.lookupClassifierByPathName( pathName );
            pathName.add( "isFault" );
            ModelElement e = this.env.lookupModelElementByPathName( pathName );
            verify( e instanceof Attribute, "'isFault' must be an Attribute" );
            var2 = this.myJmiCreator.createVariableDeclaration( "var2", c, null );
        }
        this.env.declareVariable( var2 );
        this.env.declareVariable( var1 );
        AssociationEnd assEnd = this.env.lookupImplicitAssociationEnd( "triggers" );
        Classifier cEnd = ( (AssociationEndImpl) MoinMetamodelCode.otherEnd( coreConnection, (AssociationEndImpl) assEnd ) ).getType( coreConnection );
        verify( c.equals( cEnd ), "" );
    }

    /**
     * @throws Exception
     */
    @Test
    public void testTupleConformance( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            List<VariableDeclaration> vardecs1 = new Vector<VariableDeclaration>( );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "a", this.myJmiCreator.getIntClass( ), null ) );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            List<VariableDeclaration> vardecs2 = new Vector<VariableDeclaration>( );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "a", this.myJmiCreator.getIntClass( ), null ) );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            TupleType tuple1 = this.myJmiCreator.createTupleType( vardecs1, "dummy1" );
            TupleType tuple2 = this.myJmiCreator.createTupleType( vardecs2, "dummy2" );
            verify( this.oclTypeChecker.typesConform( tuple1, tuple2 ), "Tuple conformance failed" );
        }
    }

    /**
     * @throws Exception
     */
    @Test
    public void testTupleConformance2( ) throws Exception {

        /*
         * order of the attriubtes should not matter
         */

        synchronized ( this.syncObjectForWrite ) {
            List<VariableDeclaration> vardecs1 = new Vector<VariableDeclaration>( );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "a", this.myJmiCreator.getIntClass( ), null ) );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            List<VariableDeclaration> vardecs2 = new Vector<VariableDeclaration>( );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "a", this.myJmiCreator.getIntClass( ), null ) );
            TupleType tuple1 = this.myJmiCreator.createTupleType( vardecs1, "dummy1" );
            TupleType tuple2 = this.myJmiCreator.createTupleType( vardecs2, "dummy2" );
            verify( this.oclTypeChecker.typesConform( tuple1, tuple2 ), "Tuple conformance failed" );
        }
    }

    /**
     * @throws Exception anything
     */
    @Test
    public void testTupleConformance3( ) throws Exception {

        /*
         * order of the attriubtes should not matter. types of the individual
         * attributes should not matter as long as they conform.
         */

        synchronized ( this.syncObjectForWrite ) {
            List<VariableDeclaration> vardecs1 = new Vector<VariableDeclaration>( );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "a", this.myJmiCreator.getIntClass( ), null ) );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            List<VariableDeclaration> vardecs2 = new Vector<VariableDeclaration>( );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "a", this.myJmiCreator.getFloatClass( ), null ) );
            TupleType tuple1 = this.myJmiCreator.createTupleType( vardecs1, "dummy1" );
            TupleType tuple2 = this.myJmiCreator.createTupleType( vardecs2, "dummy2" );
            verify( this.oclTypeChecker.typesConform( tuple1, tuple2 ), "Tuple conformance failed" );
        }
    }

    /**
     * @exception Exception
     */
    @Test
    public void testTupleNoConformance( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            /*
             * order of the attriubtes should not matter Names of attriubtes
             * should matter!!
             */
            List<VariableDeclaration> vardecs1 = new Vector<VariableDeclaration>( );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "a", this.myJmiCreator.getIntClass( ), null ) );
            vardecs1.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            List<VariableDeclaration> vardecs2 = new Vector<VariableDeclaration>( );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "c", this.myJmiCreator.getIntClass( ), null ) );
            vardecs2.add( this.myJmiCreator.createVariableDeclaration( "b", this.myJmiCreator.getStringClass( ), null ) );
            TupleType tuple1 = this.myJmiCreator.createTupleType( vardecs1, "dummy1" );
            TupleType tuple2 = this.myJmiCreator.createTupleType( vardecs2, "dummy2" );
            verify( !this.oclTypeChecker.typesConform( tuple1, tuple2 ), "Tuple conformance failed" );
        }
    }

    /**
     * tests type conformance of primitive types
     * 
     * @throws Exception
     */
    @Test
    public void testTypeConformance( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            List<String> x = new ArrayList<String>( );
            x.add( "OclAny" );
            Classifier any = this.env.lookupClassifierByPathName( x );

            x.clear( );
            x.add( "Integer" );
            Classifier integer = this.env.lookupClassifierByPathName( x );

            x.clear( );
            x.add( "Float" );
            Classifier real = this.env.lookupClassifierByPathName( x );

            x.clear( );
            x.add( "OclVoid" );
            Classifier undefined = this.env.lookupClassifierByPathName( x );

            if ( !this.oclTypeChecker.typesConform( integer, real ) ) {
                flop( "Integer does not conform to Float" );
            }

            if ( !this.oclTypeChecker.typesConform( integer, any ) ) {
                flop( "Integer does not conform to OclAny" );
            }

            if ( !this.oclTypeChecker.typesConform( undefined, integer ) ) {
                flop( "OclUndefined does not conform to integer" );
            }

            if ( !this.oclTypeChecker.typesConform( undefined, undefined ) ) {
                flop( "OclUndefined does not conform to OclUndefined" );
            }

            if ( this.oclTypeChecker.typesConform( any, undefined ) ) {
                flop( "OclAny conforms to OclUndefined" );
            }

            if ( !this.oclTypeChecker.typesConform( any, any ) ) {
                flop( "OclAny does not conform to OclAny" );
            }
        }
    }

    /**
     * Looks up the special operations which are accessible on some types and
     * not on others. oclIsTypeOf, oclIsKindOf, oclAsType and allInstances are
     * looked up on some of the primitive types and some model elements.
     * 
     * @throws Exception
     */
    @Test
    public void testOperationLookup( ) throws Exception {

        synchronized ( this.syncObjectForWrite ) {
            Operation op = null;
            List<Classifier> args = new Vector<Classifier>( );
            /*
             * lookup stuff on OclAny
             */
            // find oclIsTypeOf on OclAny
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            op = this.oclLookupTables.lookupOperation( this.myJmiCreator.getAnyClass( ), "oclIsTypeOf", args, oclTypeChecker );
            args.clear( );
            this.verify( op != null, "oclIsTypeOf not found on OclAny" );

            // find oclIsKindOf on OclAny
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            op = this.oclLookupTables.lookupOperation( this.myJmiCreator.getAnyClass( ), "oclIsKindOf", args, oclTypeChecker );
            args.clear( );
            this.verify( op != null, "oclIsKindOf not found on OclAny" );

            // lookup allInstances on OclAny
            // this should fail!
            try {
                op = this.oclLookupTables.lookupOperation( this.myJmiCreator.getAnyClass( ), "allInstances", args, oclTypeChecker );
            } catch ( Exception e ) {
                op = null;
            }
            args.clear( );
            this.verify( op == null, "allInstances found on OclAny" );

            /*
             * lookup stuff on primitive type
             */
            // find oclIsTypeOf on Integer
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            op = this.oclLookupTables.lookupOperation( this.myJmiCreator.getIntClass( ), "oclIsTypeOf", args, oclTypeChecker );
            args.clear( );
            this.verify( op != null, "oclIsTypeOf not found on Integer" );

            // find oclIsKindOf on Float
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            op = this.oclLookupTables.lookupOperation( this.myJmiCreator.getFloatClass( ), "oclIsKindOf", args, oclTypeChecker );
            args.clear( );
            this.verify( op != null, "oclIsKindOf not found on Float" );

            // lookup allInstances on OclAny
            // this should fail!
            try {
                op = this.oclLookupTables.lookupOperation( this.myJmiCreator.getFloatClass( ), "allInstances", args, oclTypeChecker );
            } catch ( Exception e ) {
                op = null;
            }
            args.clear( );
            this.verify( op == null, "allInstances found on Float" );

            /*
             * lookup stuff on collections
             */
            CollectionType col = this.myJmiCreator.createSetType( this.myJmiCreator.getIntClass( ) );

            // find oclIsTypeOf on Set(Integer)
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            try {
                op = this.oclLookupTables.lookupOperation( col, "oclIsTypeOf", args, oclTypeChecker );
            } catch ( Exception e2 ) {
                op = null;
            }
            args.clear( );
            this.verify( op == null, "oclIsTypeOf found on Set(Integer)" );

            // find oclIsKindOf on Set(Integer)
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            try {
                op = this.oclLookupTables.lookupOperation( col, "oclIsKindOf", args, oclTypeChecker );
            } catch ( Exception e1 ) {
                op = null;
            }
            args.clear( );
            this.verify( op == null, "oclIsKindOf found on Set(Integer)" );

            // lookup allInstances on Set(Integer)
            // this should fail!
            try {
                op = this.oclLookupTables.lookupOperation( col, "allInstances", args, oclTypeChecker );
            } catch ( Exception e ) {
                op = null;
            }
            args.clear( );
            this.verify( op == null, "allInstances found on Set(Integer)" );

            /*
             * lookup stuff on Message
             */
            List<String> pathName = ( (ClassifierInternal) this.svcIntPkg.getMessage( coreConnection ).refMetaObject( ) ).getQualifiedName( coreConnection );
            Classifier msg = this.env.lookupClassifierByPathName( pathName );

            // find oclIsTypeOf on OclAny
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            op = this.oclLookupTables.lookupOperation( msg, "oclIsTypeOf", args, oclTypeChecker );
            args.clear( );
            this.verify( op != null, "oclIsTypeOf not found on Message" );

            // find oclIsKindOf on OclAny
            args.add( this.myJmiCreator.getOclTypeClass( ) );
            op = this.oclLookupTables.lookupOperation( msg, "oclIsKindOf", args, oclTypeChecker );
            args.clear( );
            this.verify( op != null, "oclIsKindOf not found on Message" );

            // lookup allInstances on OclAny
            // this should fail!

            op = this.oclLookupTables.lookupOperation( msg, "allInstances", args, oclTypeChecker );

            args.clear( );
            this.verify( op == null, "allInstances not found on Message" );
        }
    }

}
