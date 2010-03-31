/*
 * Util.java Copyright 2002 Sun Microsystems, Inc. All rights reserved. Use is
 * subject to license terms.
 */

package com.sap.tc.moin.repository.test.jmitck.gentests.mapping;

import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This Package is just a quick tool to help generate some tests. Don't expect
 * it to be readable!
 */
@SuppressWarnings( "nls" )
public class GenPkg {

    private String m2;

    private List<TdFile> tdFileList = new ArrayList<TdFile>( );

    private String pkgPrefix;

    private String filePrefix;

    private File rootDir;

    private int idnum = 1;

    public GenPkg( ) {

    }

    private FilenameFilter classfileFilter = new FilenameFilter( ) {

        public boolean accept( File dir, String name ) {

            return name.endsWith( ".class" );
        }
    };

    public void getGeneratorFor( String pkg, String prefix, File root, String metamodel ) {

        //       List prefixSegments = segment(prefix);
        //       for (Iterator i = prefixSegment.iterator(); i.hasNext();) {
        //       String seg = (String) i.next();

        this.pkgPrefix = prefix.replace( '/', '.' ) + "." + pkg.replace( '/', '.' );
        this.filePrefix = prefix + "/" + pkg;
        this.m2 = prefix.replace( '/', '.' ) + "." + metamodel;
        rootDir = root;
        File pkgDir = new File( root, filePrefix );

        System.err.println( "Generating everyting in " + pkgDir.getAbsolutePath( ) );
        String[] classfiles = pkgDir.list( classfileFilter );
        System.err.println( "Total of " + classfiles.length + " classfiles" );

        for ( int i = 0; i < classfiles.length; i++ ) {
            String classfile = classfiles[i];
            classfile = classfile.substring( 0, classfile.lastIndexOf( "." ) );
            generateFor( classfile );
        }
    }

    public void generateFor( String clsName ) {

        System.err.println( "Processing " + pkgPrefix + "." + clsName );
        try {
            Class<?> cls = Class.forName( pkgPrefix + "." + clsName );
            if ( cls.getInterfaces( ).length == 0 ) {
                generateForNoExtends( );
            } else if ( com.sap.tc.moin.repository.mmi.reflect.RefAssociation.class.isAssignableFrom( cls ) ) {
                generateForAssoc( cls );
            } else if ( com.sap.tc.moin.repository.mmi.reflect.RefPackage.class.isAssignableFrom( cls ) ) {
                generateForPkg( cls );
            } else if ( com.sap.tc.moin.repository.mmi.reflect.RefException.class.isAssignableFrom( cls ) ) {
                generateForExc( cls );
            } else if ( com.sap.tc.moin.repository.mmi.reflect.RefObject.class.isAssignableFrom( cls ) ) {
                generateForCls( cls );
            } else if ( com.sap.tc.moin.repository.mmi.reflect.RefClass.class.isAssignableFrom( cls ) ) {
                generateForClsCls( cls );
            } else if ( com.sap.tc.moin.repository.mmi.reflect.RefStruct.class.isAssignableFrom( cls ) ) {
                generateForStruct( cls );
            } else if ( com.sap.tc.moin.repository.mmi.reflect.RefEnum.class.isAssignableFrom( cls ) ) {
                generateForEnum( cls );

                //       } else if (!cls.isInterface() && cls.getName().endsWith("Enum")) {
                //       generateForEnumImpl(cls);
                //       } else if (extendsRefPkg(ifs[0])) {
                //       generateForPkgSub(cls);
            } else {

                //       Class[] ifs = cls.getInterfaces();
                //       if (ifs.length == 0) {
                //       generateForNoExtends(cls);
                //       } else if (ifs[0] == com.sap.tc.moin.repository.mmi.reflect.RefAssociation.class) {
                //       generateForAssoc(cls);
                //       } else if (ifs[0] == com.sap.tc.moin.repository.mmi.reflect.RefPackage.class) {
                //       generateForPkg(cls);
                //       } else if (ifs[0] == com.sap.tc.moin.repository.mmi.reflect.RefException.class) {
                //       generateForExc(cls);
                //       } else if (ifs[0] == com.sap.tc.moin.repository.mmi.reflect.RefObject.class) {
                //       generateForCls(cls);
                //       } else if (ifs[0] == com.sap.tc.moin.repository.mmi.reflect.RefClass.class) {
                //       generateForClsCls(cls);
                //       } else if (ifs[0] == com.sap.tc.moin.repository.mmi.reflect.RefStruct.class) {
                //       generateForStruct(cls);
                //       } else if (!cls.isInterface() && cls.getName().endsWith("Enum")) {
                //       generateForEnumImpl(cls);
                //       } else if (extendsRefPkg(ifs[0])) {
                //       generateForPkgSub(cls);
                //       } else {

                System.err.println( "Don't Know What to do With " + cls.getName( ) );
            }
        } catch ( Throwable th ) {
            th.printStackTrace( );
        }
    }

    public void generateForPkg( Class<?> cls ) {

        TdFile tdfile = new TdFile( cls, "Package Interface Generation" );
        String src = "PackageGen";
        Class<?> sclass = cls.getInterfaces( )[0];
        String title = null;
        String extendsList = null;
        if ( sclass == com.sap.tc.moin.repository.mmi.reflect.RefPackage.class ) {
            title = "Mof Package interface extends RefPackage";
            extendsList = "com.sap.tc.moin.repository.mmi.reflect.RefPackage";
        } else {
            title = "Mof Package Subtype extends super package's RefPackage";
            extendsList = typeArrayAsString( cls.getInterfaces( ) );
        }
        tdfile.tdList.add( makeExtends( cls, src, extendsList, title ) );

        tdfile.tdList.add( makeExists( cls, src, "Mof Package generates type" ) );

        tdfile.tdList.add( makeIsInterface( cls, src, "Mof Package generated type is interface" ) );

        tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "Mof Package interface has no nested types" ) );
        tdfile.tdList.add( makeContainsMethodCount( cls, src, "Mof Package interface method count" ) );
        tdfile.tdList.add( makeContainsFieldCount( cls, src, "Mof Package interface field count" ) );

        Method[] methods = cls.getDeclaredMethods( );
        for ( int i = 0; i < methods.length; i++ ) {
            Method m = methods[i];
            Class<?> retType = m.getReturnType( );
            String mtitle = null;
            if ( com.sap.tc.moin.repository.mmi.reflect.RefClass.class.isAssignableFrom( retType ) ) {
                mtitle = "Mof Package class access method";
            } else {
                mtitle = "Mof Package static feature method";
            }
            tdfile.tdList.add( makeMethodExists( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodReturns( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodThrows( m, src, mtitle ) );
        }
        tdFileList.add( tdfile );
    }

    public void generateForNoExtends( ) {
    }

    public void generateForAssoc( Class<?> cls ) {

        TdFile tdfile = new TdFile( cls, "Association Interface Generation" );
        String src = "AssociationGen";
        String title = "Association generates RefAssociation subtype interface";
        tdfile.tdList.add( makeExists( cls, src, "Mof Association generates type" ) );
        tdfile.tdList.add( makeExtends( cls, src, "com.sap.tc.moin.repository.mmi.reflect.RefAssociation", title ) );
        tdfile.tdList.add( makeIsInterface( cls, src, "Mof Association generated type is interface" ) );
        tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "Mof Association interface has no nested types" ) );
        tdfile.tdList.add( makeContainsMethodCount( cls, src, "Mof Association interface number of methods" ) );
        tdfile.tdList.add( makeContainsFieldCount( cls, src, "Mof Association interface has no fields" ) );

        Method[] methods = cls.getDeclaredMethods( );
        for ( int i = 0; i < methods.length; i++ ) {
            Method m = methods[i];
            String mtitle = "Mof Association method";
            tdfile.tdList.add( makeMethodExists( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodReturns( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodThrows( m, src, mtitle ) );
        }
        tdFileList.add( tdfile );
    }

    public void generateForExc( Class<?> cls ) {

        TdFile tdfile = new TdFile( cls, "Mof Exception Class Generation" );
        String src = "ExceptionGen";
        //       String title = "Mof Exception generates Exception class";
        tdfile.tdList.add( makeExists( cls, src, "Mof Exception generates class" ) );
        tdfile.tdList.add( makeExtends( cls, src, "com.sap.tc.moin.repository.mmi.reflect.RefException", "MofException generated class extends JmiException" ) );
        tdfile.tdList.add( makeIsInterface( cls, src, "Mof Exceptiom generated type is a class", false ) );
        tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "Mof Exception class has no nested types" ) );
        tdfile.tdList.add( makeContainsMethodCount( cls, src, "Mof Exception class number of methods" ) );
        tdfile.tdList.add( makeContainsFieldCount( cls, src, "Mof Exception class number of fields" ) );
        tdfile.tdList.add( makeContainsCtorCount( cls, src, "Mof Exception class number of constructors" ) );

        Constructor<?>[] constructors = cls.getDeclaredConstructors( );
        for ( int i = 0; i < constructors.length; i++ ) {
            Constructor<?> ctor = constructors[i];
            String ctitle = "Mof Exception class constructor";
            tdfile.tdList.add( makeConstructorExists( ctor, src, ctitle ) );
            tdfile.tdList.add( makeConstructorThrows( ctor, src, ctitle ) );
            tdfile.tdList.add( makeConstructorIsPublic( ctor, src, ctitle ) );
        }

        Method[] methods = cls.getDeclaredMethods( );
        for ( int i = 0; i < methods.length; i++ ) {
            Method m = methods[i];
            if ( Modifier.isPublic( m.getModifiers( ) ) ) {
                String mtitle = "Mof Exception class method";
                tdfile.tdList.add( makeMethodExists( m, src, mtitle ) );
                tdfile.tdList.add( makeMethodReturns( m, src, mtitle ) );
                tdfile.tdList.add( makeMethodThrows( m, src, mtitle ) );
                tdfile.tdList.add( makeMethodIsPublic( m, src, mtitle ) );
                tdfile.tdList.add( makeMethodIsStatic( m, src, mtitle, false ) );
                tdfile.tdList.add( makeMethodIsFinal( m, src, mtitle, false ) );
                tdfile.tdList.add( makeMethodIsAbstract( m, src, mtitle, false ) );
            }
        }
        tdFileList.add( tdfile );
    }

    public void generateForCls( Class<?> cls ) {

        TdFile tdfile = new TdFile( cls, "Class Interface Generation" );
        String src = "ClassGen";
        Class<?> sclass = cls.getInterfaces( )[0];
        String title = null;
        String extendsList = null;
        tdfile.tdList.add( makeExists( cls, src, "Mof Class generates type" ) );

        if ( sclass == com.sap.tc.moin.repository.mmi.reflect.RefPackage.class ) {
            title = "Mof Class interface extends RefObject";
            extendsList = "com.sap.tc.moin.repository.mmi.reflect.RefObject";
        } else {
            title = "Mof Class interface extends supertype's RefObject subtype";
            extendsList = typeArrayAsString( cls.getInterfaces( ) );
        }
        tdfile.tdList.add( makeExtends( cls, src, extendsList, title ) );
        tdfile.tdList.add( makeIsInterface( cls, src, "Mof Class generated type is interface" ) );
        tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "Mof Class interface has no nested types" ) );
        tdfile.tdList.add( makeContainsMethodCount( cls, src, "Mof Class interface number of methods" ) );
        tdfile.tdList.add( makeContainsFieldCount( cls, src, "Mof Class interface number of fields" ) );

        Method[] methods = cls.getDeclaredMethods( );
        for ( int i = 0; i < methods.length; i++ ) {
            Method m = methods[i];
            String mtitle = "Mof Class method";
            tdfile.tdList.add( makeMethodExists( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodReturns( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodThrows( m, src, mtitle ) );
        }
        tdFileList.add( tdfile );

        Field[] fields = cls.getDeclaredFields( );
        for ( int i = 0; i < fields.length; i++ ) {
            Field f = fields[i];
            String ftitle = "Mof Class field";
            tdfile.tdList.add( makeFieldExists( f, src, ftitle ) );
            tdfile.tdList.add( makeFieldTypedAs( f, src, ftitle ) );
        }
        tdFileList.add( tdfile );
    }

    public void generateForClsCls( Class<?> cls ) {

        TdFile tdfile = new TdFile( cls, "Class Proxy Interface Generation" );
        String src = "ClassProxyGen";
        String title = "ClassProxy generates RefClass subtype interface";
        tdfile.tdList.add( makeExists( cls, src, "Mof Class generates ClassProxy type" ) );
        tdfile.tdList.add( makeExtends( cls, src, "com.sap.tc.moin.repository.mmi.reflect.RefClass", title ) );
        tdfile.tdList.add( makeIsInterface( cls, src, "Mof Class generated ClassProxy type is interface" ) );
        tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "Mof Class generated ClassProxy interface has no nested types" ) );
        tdfile.tdList.add( makeContainsMethodCount( cls, src, "Mof Class generated ClassProxy interface number of methods" ) );
        tdfile.tdList.add( makeContainsFieldCount( cls, src, "Mof Class generated ClassProxy interface number of fields" ) );

        Method[] methods = cls.getDeclaredMethods( );
        for ( int i = 0; i < methods.length; i++ ) {
            Method m = methods[i];
            String mtitle = "Mof ClassProxy method";
            tdfile.tdList.add( makeMethodExists( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodReturns( m, src, mtitle ) );
            tdfile.tdList.add( makeMethodThrows( m, src, mtitle ) );
        }
        tdFileList.add( tdfile );
    }

    public void generateForStruct( Class<?> cls ) {

        TdFile tdfile = new TdFile( cls, "Struct Interface Generation" );
        String src = "StructGen";
        tdfile.tdList.add( makeExists( cls, src, "StructureType generates type" ) );
        tdfile.tdList.add( makeExtends( cls, src, "com.sap.tc.moin.repository.mmi.reflect.RefStruct", "StructureType generates RefStruct subtype interface" ) );
        tdfile.tdList.add( makeIsInterface( cls, src, "StructureType generated type is interface" ) );
        tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "StructureType interface has no nested types" ) );
        tdfile.tdList.add( makeContainsMethodCount( cls, src, "StructureTpe interface number of methods equals number of fields" ) );
        tdfile.tdList.add( makeContainsFieldCount( cls, src, "StructureTpe interface has no fields" ) );

        Method[] methods = cls.getDeclaredMethods( );
        for ( int i = 0; i < methods.length; i++ ) {
            Method m = methods[i];
            String title = "StructureType method";
            tdfile.tdList.add( makeMethodExists( m, src, title ) );
            tdfile.tdList.add( makeMethodReturns( m, src, title ) );
            tdfile.tdList.add( makeMethodThrows( m, src, title ) );
        }
        tdFileList.add( tdfile );

    }

    public void generateForEnum( Class<?> cls ) {

        if ( cls.isInterface( ) ) {
            TdFile tdfile = new TdFile( cls, "Enum Interface Generation" );
            String src = "EnumGen";
            tdfile.tdList.add( makeExists( cls, src, "EnumType generates type" ) );
            tdfile.tdList.add( makeExtends( cls, src, "com.sap.tc.moin.repository.mmi.reflect.RefEnum", "EnumType generates RefEnum subtype interface" ) );
            tdfile.tdList.add( makeIsInterface( cls, src, "EnumType generated type is interface" ) );
            tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "EnumType interface has no nested types" ) );
            tdfile.tdList.add( makeContainsMethodCount( cls, src, "EnumType interface has no methods" ) );
            tdfile.tdList.add( makeContainsFieldCount( cls, src, "EnumType interface has no fields" ) );
            tdFileList.add( tdfile );
        } else {
            TdFile tdfile = new TdFile( cls, "Enum Implementation Class Generation" );
            String src = "EnumImplGen";
            tdfile.tdList.add( makeExists( cls, src, "EnumType generates implementation class" ) );
            tdfile.tdList.add( makeImplements( cls, src, "EnumType generates RefEnum subtype interface" ) );
            tdfile.tdList.add( makeIsInterface( cls, src, "EnumType generated implementation is a class", false ) );
            tdfile.tdList.add( makeContainsTypeCount( cls, src, 0, "EnumType implementation class has no nested types" ) );
            tdfile.tdList.add( makeContainsMethodCount( cls, src, "EnumType implementation method count" ) );
            tdfile.tdList.add( makeContainsFieldCount( cls, src, "EnumType implementation field count" ) );
            Method[] methods = cls.getDeclaredMethods( );
            for ( int i = 0; i < methods.length; i++ ) {
                Method m = methods[i];
                if ( Modifier.isPublic( m.getModifiers( ) ) ) {
                    String title = "EnumType implementation class method";
                    tdfile.tdList.add( makeMethodExists( m, src, title ) );
                    tdfile.tdList.add( makeMethodReturns( m, src, title ) );
                    tdfile.tdList.add( makeMethodThrows( m, src, title ) );
                    tdfile.tdList.add( makeMethodIsPublic( m, src, title ) );
                    tdfile.tdList.add( makeMethodIsStatic( m, src, title, Modifier.isStatic( m.getModifiers( ) ) ) );
                    tdfile.tdList.add( makeMethodIsFinal( m, src, title, false ) );
                    tdfile.tdList.add( makeMethodIsAbstract( m, src, title, false ) );
                }
            }
            Constructor<?>[] constructors = cls.getDeclaredConstructors( );
            for ( int i = 0; i < constructors.length; i++ ) {
                Constructor<?> ctor = constructors[i];
                if ( Modifier.isPublic( ctor.getModifiers( ) ) ) {

                    String ctitle = "Mof Exception class constructor";
                    tdfile.tdList.add( makeConstructorExists( ctor, src, ctitle ) );
                    tdfile.tdList.add( makeConstructorThrows( ctor, src, ctitle ) );
                    tdfile.tdList.add( makeConstructorIsPublic( ctor, src, ctitle ) );
                }
            }
            tdFileList.add( tdfile );
        }
    }

    private TD makeExtends( Class<?> c, String src, String extendsList, String title ) {

        TD td = new TD( c.getName( ), src, "Extends" );
        td.metamodel = m2;
        td.addParam( "testType", "typeExtends" );
        td.addParam( "typeName", c.getName( ) );
        td.addParam( "extends", extendsList );
        td.title = title;
        return td;
    }

    private TD makeImplements( Class<?> c, String src, String title ) {

        TD td = new TD( c.getName( ), src, "Implements" );
        Class<?> interf = c.getInterfaces( )[0];
        td.metamodel = m2;
        td.addParam( "testType", "typeImplements" );
        td.addParam( "typeName", c.getName( ) );
        td.addParam( "implements", interf.getName( ) );
        td.title = title;
        return td;
    }

    private TD makeExists( Class<?> c, String src, String title ) {

        return makeExists( c, src, title, true );
    }

    private TD makeExists( Class<?> c, String src, String title, boolean expected ) {

        TD td = new TD( c.getName( ), src, "Exists" );
        td.metamodel = m2;
        td.addParam( "testType", "typeExists" );
        td.addParam( "typeName", c.getName( ) );
        td.addParam( "expected", String.valueOf( expected ) );
        td.title = title;
        return td;
    }

    private TD makeIsInterface( Class<?> c, String src, String title ) {

        return makeIsInterface( c, src, title, true );
    }

    private TD makeIsInterface( Class<?> c, String src, String title, boolean expected ) {

        TD td = new TD( c.getName( ), src, "IsInterface" );
        td.metamodel = m2;
        td.addParam( "testType", "typeIsInterface" );
        td.addParam( "typeName", c.getName( ) );
        td.addParam( "expected", String.valueOf( expected ) );
        td.title = title;
        return td;
    }

    private TD makeContainsTypeCount( Class<?> c, String src, int count, String title ) {

        TD td = new TD( c.getName( ), src, "ContainsTypeCount" );
        td.metamodel = m2;
        td.addParam( "testType", "typeContainsTypeCount" );
        td.addParam( "typeName", c.getName( ) );
        td.addParam( "containedTypeCount", String.valueOf( count ) );
        td.title = title;
        return td;
    }

    private TD makeContainsMethodCount( Class<?> c, String src, String title ) {

        TD td = new TD( c.getName( ), src, "ContainsMethodCount" );
        td.metamodel = m2;
        td.addParam( "testType", "typeContainsMethodCount" );
        td.addParam( "typeName", c.getName( ) );
        int count = c.getDeclaredMethods( ).length;
        td.addParam( "containedMethodCount", String.valueOf( count ) );
        td.title = title;
        return td;
    }

    private TD makeContainsFieldCount( Class<?> c, String src, String title ) {

        TD td = new TD( c.getName( ), src, "ContainsFieldCount" );
        td.metamodel = m2;
        td.addParam( "testType", "typeContainsFieldCount" );
        td.addParam( "typeName", c.getName( ) );
        int count = c.getDeclaredFields( ).length;
        td.addParam( "containedFieldCount", String.valueOf( count ) );
        td.title = title;
        return td;
    }

    private TD makeContainsCtorCount( Class<?> c, String src, String title ) {

        TD td = new TD( c.getName( ), src, "ContainsCtorCount" );
        td.metamodel = m2;
        td.addParam( "testType", "typeContainsCtorCount" );
        td.addParam( "typeName", c.getName( ) );
        int count = c.getDeclaredConstructors( ).length;
        td.addParam( "containedCtorCount", String.valueOf( count ) );
        td.title = title;
        return td;
    }

    private TD makeMethodExists( Method m, String src, String title ) {

        return makeMethodExists( m, src, title, true );
    }

    private TD makeMethodExists( Method m, String src, String title, boolean expected ) {

        String fullMethodName = makeFullMemberName( m );
        String argTypes = typeArrayAsString( m.getParameterTypes( ) );
        String idMethodName = fullMethodName + "#" + argTypes + "#";
        TD td = new TD( idMethodName, src, "Exists" );
        td.metamodel = m2;
        td.addParam( "testType", "methodExists" );
        td.addParam( "methodName", fullMethodName );
        td.addParam( "expected", String.valueOf( expected ) );
        td.addParam( "argTypes", argTypes );
        td.title = title + " exists";
        return td;
    }

    private TD makeMethodReturns( Method m, String src, String title ) {

        String fullMethodName = makeFullMemberName( m );
        String argTypes = typeArrayAsString( m.getParameterTypes( ) );
        String idMethodName = fullMethodName + "#" + argTypes + "#";
        TD td = new TD( idMethodName, src, "Returns" );
        td.metamodel = m2;
        td.addParam( "testType", "methodReturns" );
        td.addParam( "methodName", fullMethodName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " returns";

        Class<?> retType = m.getReturnType( );
        td.addParam( "returnType", retType.getName( ) );
        return td;
    }

    private TD makeMethodThrows( Method m, String src, String title ) {

        String fullMethodName = makeFullMemberName( m );
        String argTypes = typeArrayAsString( m.getParameterTypes( ) );
        String idMethodName = fullMethodName + "#" + argTypes + "#";
        TD td = new TD( idMethodName, src, "Throws" );
        td.metamodel = m2;
        td.addParam( "testType", "methodThrows" );
        td.addParam( "methodName", fullMethodName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " throws exceptions";

        Class<?>[] excTypes = m.getExceptionTypes( );
        List<Class<?>> checkExc = new ArrayList<Class<?>>( );
        for ( int i = 0; i < excTypes.length; i++ ) {
            if ( !java.lang.RuntimeException.class.isAssignableFrom( excTypes[i] ) ) {
                checkExc.add( excTypes[i] );
            }
        }
        td.addParam( "exceptions", typeArrayAsString( checkExc.toArray( new Class[] {} ) ) );
        return td;
    }

    private TD makeMethodIsPublic( Method m, String src, String title ) {

        return makeMethodIsPublic( m, src, title, true );
    }

    private TD makeMethodIsPublic( Method m, String src, String title, boolean expected ) {

        String fullMethodName = makeFullMemberName( m );
        String argTypes = typeArrayAsString( m.getParameterTypes( ) );
        String idMethodName = fullMethodName + "#" + argTypes + "#";
        TD td = new TD( idMethodName, src, "IsPublic" );
        td.metamodel = m2;
        td.addParam( "testType", "methodIsPublic" );
        td.addParam( "methodName", fullMethodName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " is public";
        td.addParam( "expected", String.valueOf( expected ) );
        return td;
    }

    private TD makeMethodIsStatic( Method m, String src, String title, boolean expected ) {

        String fullMethodName = makeFullMemberName( m );
        String argTypes = typeArrayAsString( m.getParameterTypes( ) );
        String idMethodName = fullMethodName + "#" + argTypes + "#";
        TD td = new TD( idMethodName, src, "IsStatic" );
        td.metamodel = m2;
        td.addParam( "testType", "methodIsStatic" );
        td.addParam( "methodName", fullMethodName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " is static";
        td.addParam( "expected", String.valueOf( expected ) );
        return td;
    }

    private TD makeMethodIsFinal( Method m, String src, String title, boolean expected ) {

        String fullMethodName = makeFullMemberName( m );
        String argTypes = typeArrayAsString( m.getParameterTypes( ) );
        String idMethodName = fullMethodName + "#" + argTypes + "#";
        TD td = new TD( idMethodName, src, "IsFinal" );
        td.metamodel = m2;
        td.addParam( "testType", "methodIsFinal" );
        td.addParam( "methodName", fullMethodName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " is final";
        td.addParam( "expected", String.valueOf( expected ) );
        return td;
    }

    private TD makeMethodIsAbstract( Method m, String src, String title, boolean expected ) {

        String fullMethodName = makeFullMemberName( m );
        String argTypes = typeArrayAsString( m.getParameterTypes( ) );
        String idMethodName = fullMethodName + "#" + argTypes + "#";
        TD td = new TD( idMethodName, src, "IsAbstract" );
        td.metamodel = m2;
        td.addParam( "testType", "methodIsAbstract" );
        td.addParam( "methodName", fullMethodName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " is abstract";
        td.addParam( "expected", String.valueOf( expected ) );
        return td;
    }

    private TD makeConstructorExists( Constructor<?> ctor, String src, String title ) {

        return makeConstructorExists( ctor, src, title, true );
    }

    private TD makeConstructorExists( Constructor<?> ctor, String src, String title, boolean expected ) {

        String typeName = ctor.getDeclaringClass( ).getName( );
        String argTypes = typeArrayAsString( ctor.getParameterTypes( ) );
        TD td = new TD( typeName + "_ctor#" + argTypes + "#", src, "Exists" );
        td.metamodel = m2;
        td.addParam( "testType", "ctorExists" );
        td.addParam( "typeName", typeName );
        td.addParam( "expected", String.valueOf( expected ) );
        td.addParam( "argTypes", argTypes );
        td.title = title + " exists";
        return td;
    }

    private TD makeConstructorThrows( Constructor<?> ctor, String src, String title ) {

        String typeName = ctor.getDeclaringClass( ).getName( );
        String argTypes = typeArrayAsString( ctor.getParameterTypes( ) );
        TD td = new TD( typeName + "_ctor#" + argTypes + "#", src, "Throws" );
        td.metamodel = m2;
        td.addParam( "testType", "ctorExists" );
        td.addParam( "typeName", typeName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " throws exceptions";

        Class<?>[] excTypes = ctor.getExceptionTypes( );
        td.addParam( "exceptions", typeArrayAsString( excTypes ) );
        return td;
    }

    private TD makeConstructorIsPublic( Constructor<?> ctor, String src, String title ) {

        return makeConstructorIsPublic( ctor, src, title, true );
    }

    private TD makeConstructorIsPublic( Constructor<?> ctor, String src, String title, boolean expected ) {

        String typeName = ctor.getDeclaringClass( ).getName( );
        String argTypes = typeArrayAsString( ctor.getParameterTypes( ) );
        TD td = new TD( typeName + "_ctor#" + argTypes + "#", src, "IsPublic" );

        td.metamodel = m2;
        td.addParam( "testType", "ctorIsPublic" );
        td.addParam( "typeName", typeName );
        td.addParam( "argTypes", argTypes );
        td.title = title + " is public";
        td.addParam( "expected", String.valueOf( expected ) );
        return td;
    }

    private TD makeFieldExists( Field f, String src, String title ) {

        return makeFieldExists( f, src, title, true );
    }

    private TD makeFieldExists( Field f, String src, String title, boolean expected ) {

        String fullFieldName = makeFullMemberName( f );
        TD td = new TD( fullFieldName, src, "Exists" );
        td.metamodel = m2;
        td.addParam( "testType", "fieldExists" );
        td.addParam( "fieldName", fullFieldName );
        td.addParam( "expected", String.valueOf( expected ) );
        td.title = title + " exists";
        return td;
    }

    private TD makeFieldTypedAs( Field f, String src, String title ) {

        String fullFieldName = makeFullMemberName( f );
        TD td = new TD( fullFieldName, src, "TypedAs" );
        td.metamodel = m2;
        td.addParam( "testType", "fieldTypedAs" );
        td.addParam( "fieldName", fullFieldName );
        td.addParam( "fieldType", f.getType( ).getName( ) );
        td.title = title + " is typed as";
        return td;
    }

    private static String typeArrayAsString( Class<?>[] types ) {

        StringBuffer sb = new StringBuffer( );
        for ( int i = 0; i < types.length; i++ ) {
            if ( i > 0 ) {
                sb.append( "," );
            }
            sb.append( types[i].getName( ) );
        }
        if ( sb.length( ) == 0 ) {
            sb.append( "&nbsp;" );
        }
        return sb.toString( );
    }

    private static String makeFullMemberName( Member m ) {

        return m.getDeclaringClass( ).getName( ) + "." + m.getName( );
    }

    public static class TD {

        public String metamodel;

        public String title;

        // public Map params = new HashMap();
        public List<String[]> params = new ArrayList<String[]>( );

        public String id;

        public TD( String name, String src, String id ) {

            // this.id = name + "" + id;
            this.id = name + "$" + src + "$" + id;
        }

        public void addParam( String k, String v ) {

            params.add( new String[] { k, v } );
        }

    }

    public static class TdFile {

        public String title;

        public String pkg;

        public String clsName;

        public List<TD> tdList = new ArrayList<TD>( );

        public TdFile( Class<?> cls, String title ) {

            this.title = title;
            clsName = cls.getName( );
            this.pkg = clsName.substring( 0, clsName.lastIndexOf( "." ) );
        }

    }

    public static void main( String[] args ) {

        File root = new File( args[3] );
        GenPkg gp = new GenPkg( );
        gp.getGeneratorFor( args[0], args[1], root, args[2] );
        gp.writeFiles( );
    }

    public void writeFiles( ) {

        int testcount = 0;
        for ( Iterator<TdFile> i = tdFileList.iterator( ); i.hasNext( ); ) {
            TdFile tdfile = i.next( );

            File thisDir = new File( rootDir, "tests/" + tdfile.pkg.replace( '.', '/' ) );
            if ( !thisDir.exists( ) ) {
                if ( !thisDir.mkdirs( ) ) {
                    System.err.println( "Could not create directory " + thisDir.getAbsolutePath( ) );
                    continue;
                }
            }
            String className = tdfile.clsName.substring( tdfile.clsName.lastIndexOf( '.' ) + 1 );

            File htmlfile = new File( thisDir, className + ".html" );
            PrintWriter pw = null;
            try {
                pw = new PrintWriter( new FileWriter( htmlfile ), true );
            } catch ( IOException ioe ) {
                System.err.println( "Could not create a stream for " + htmlfile.getAbsolutePath( ) );
                continue;
            }
            pw.println( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">" );
            pw.println( "<HTML>" );
            pw.println( "<HEAD>" );
            pw.println( "<TITLE>" + "Test Specifications and Descriptions for Generation of " + tdfile.clsName + "</TITLE>" );
            pw.println( "<style type=\"text/css\">" );
            pw.println( "<!--" );
            pw.println( ".TestDescription {  background-color: #FFFFCC}" );
            pw.println( "-->" );
            pw.println( "</style>" );
            pw.println( "</HEAD>" );
            pw.println( "<H1>" + "Test Specifications and Descriptions for Generation of " + tdfile.clsName + "</H1>" );
            for ( Iterator<TD> j = tdfile.tdList.iterator( ); j.hasNext( ); ) {
                testcount++;
                TD td = j.next( );
                pw.println( "<P>" );
                pw.println( "<TABLE BORDER=1 CLASS=TestDescription id=" + nextId( ) + ">" );
                pw.println( "  <TR>" );
                pw.println( "    <TD> <B>title</B>" );
                pw.println( "    <TD>" + td.title );
                pw.println( "  <TR>" );
                pw.println( "    <TD><b>metamodel</b>" );
                pw.println( "    <TD>" + td.metamodel );
                for ( Iterator<String[]> k = td.params.iterator( ); k.hasNext( ); ) {
                    String[] str = k.next( );
                    pw.println( "  <TR>" );
                    pw.println( "    <TD><b>" + str[0] + "</b>" );
                    pw.println( "    <TD>" + str[1] );
                }
                pw.println( "</table>" );
            }
            pw.println( "<P>" );
            pw.println( "<HR>" );
            pw.println( "<EM>&copy; 2002 Sun Microsystems, Inc. All Rights Reserved.</EM>" );
            pw.println( "</BODY>" );
            pw.println( "</HTML>" );
            pw.flush( );
            pw.close( );
            resetId( );
        }
        System.err.println( "==> GENERATED " + testcount + " TESTS" );
    }

    private String nextId( ) {

        idnum++;
        return "Test" + String.valueOf( idnum );
    }

    private void resetId( ) {

        idnum = 1;
    }
}
