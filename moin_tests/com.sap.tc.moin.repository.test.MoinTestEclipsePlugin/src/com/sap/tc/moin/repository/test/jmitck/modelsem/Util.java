package com.sap.tc.moin.repository.test.jmitck.modelsem;

import static com.sap.tc.moin.repository.shared.util.SunSystemPropertyKeys.LINE_SEPARATOR;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidCallException;
import com.sap.tc.moin.repository.mmi.reflect.InvalidNameException;
import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;

/**
 * Provides a number of utility methods for test setup, execution, and
 * reporting.
 */
@SuppressWarnings( "nls" )
public class Util {

    public static String EOL = System.getProperty( LINE_SEPARATOR );

    private static Map<String, Class<?>> typeAbbrevMap;

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, Util.class );

    static {
        staticInit( );
    }

    /**
     * Returns a method with the given name defined in the type of the given
     * object, with the given return type. The return type is provided to
     * distinguish between same-named methods when the search spans a number of
     * unrelated types.
     * 
     * @param obj an <code>Object</code> the object that the method may be
     * defined for
     * @param returnType the type that the method returns
     * @param methodName a the simple name of the method
     * @return a <code>Method</code> the found method, or null, if not found
     */
    public static Method findMethod( Object obj, Class<?> returnType, String methodName ) {

        return findMethod( obj.getClass( ), returnType, methodName );
    }

    /**
     * Returns a method with the given name defined in the given type, with the
     * given return type. The return type is provided to distinguish between
     * same-named methods when the search spans a number of unrelated types.
     * 
     * @param cls the class to look into for the method
     * @param returnType the type that the method returns
     * @param methodName a the simple name of the method
     * @return a <code>Method</code> the found method, or null, if not found
     */
    public static Method findMethod( Class<?> cls, Class<?> returnType, String methodName ) {

        Method[] mlist = cls.getMethods( );
        for ( int i = 0; i < mlist.length; i++ ) {
            Method m = mlist[i];
            Class<?> expectedType = m.getReturnType( );
            if ( ( ( returnType == expectedType ) || ( returnType.isAssignableFrom( expectedType ) ) ) && methodName.equals( m.getName( ) ) ) {
                return m;
            }
        }
        return null;
    }

    /**
     * Returns the type specified by the provided string. Allows for specifying
     * primitive types by the names <code>int, String,
     * boolean</code>, etc; also allows for specifying the java primitive
     * wrappers by simple name, such as <code>Integer,
     * Boolean</code>, etc.
     * 
     * @param typeName the name of the type, either the fully-qualified java
     * name, or the simple name of a primitive type
     * @return a <code>Class</code> the Java class corresponding to the input
     * @throws TestErrorException, if the type cannot be determined
     */
    public static Class<?> getType( String typeName ) {

        Class<?> type = getStdClass( typeName );
        if ( type == null ) {
            try {
                type = Class.forName( typeName );
            } catch ( ClassNotFoundException cnfe ) {
                log.trace( cnfe, MoinSeverity.INFO, "" );
                throw new TestErrorException( "Unknown type " + type + " specified in test" );
            }
        }
        return type;
    }

    /**
     * Returns all but the last segment of a dot-qualified name.
     * <p>
     * <b>Example</b>
     * <table>
     * <tr>
     * <td><b>Input</b></td>
     * <td><b>Output</b></td>
     * <tr>
     * <td>com.sap.tc.moin.repository.test.jmitck.tst.containment.PkgX</td>
     * <td>com.sap.tc.moin.repository.test.jmitck.tst.containment</td>
     * <tr>
     * <td>com.sap.tc.moin.repository.test.jmitck.tst.containment.PkgX.attrZ</td>
     * <td>com.sap.tc.moin.repository.test.jmitck.tst.containment.PkgX</td>
     * <tr>
     * <td>Containment</td>
     * <td>""</td>
     * 
     * @param fullName a string to parse
     * @return the qualification portion of the input (may be an empty String)
     */
    public static String qualificationOf( String fullName ) {

        String answer = null;
        int pos = fullName.lastIndexOf( "." );
        if ( pos != -1 ) {
            answer = fullName.substring( 0, pos );
        } else {
            answer = "";
        }
        return answer;
    }

    /**
     * Returns the last segment of a dot-qualified name.
     * <p>
     * <b>Example</b>
     * <table>
     * <tr>
     * <td><b>Input</b></td>
     * <td><b>Output</b></td>
     * <tr>
     * <td>com.sap.tc.moin.repository.test.jmitck.tst.containment.PkgX</td>
     * <td>PkgX</td>
     * <tr>
     * <td>com.sap.tc.moin.repository.test.jmitck.tst.containment.PkgX.attrZ</td>
     * <td>attrZ</td>
     * <tr>
     * <td>Containment</td>
     * <td>Containment</td>
     * 
     * @param fullName a string to parse
     * @return the simpleName of the input full name. Will return the input
     * string, when the input has no '.' separator
     */
    public static String simpleNameOf( String fullName ) {

        String answer = null;
        int pos = fullName.lastIndexOf( "." );
        if ( pos != -1 ) {
            answer = fullName.substring( pos + 1 );
        } else {
            answer = fullName;
        }
        return answer;
    }

    /**
     * Returns the first segment of a dot-qualified name.
     * <p>
     * <b>Example</b>
     * <table>
     * <tr>
     * <td><b>Input</b></td>
     * <td><b>Output</b></td>
     * <tr>
     * <td>com.sap.tc.moin.repository.test.jmitck.tst.containment.PkgX</td>
     * <td>com</td>
     * <tr>
     * <td>PkgX.attrZ</td>
     * <td>PkgX</td>
     * <tr>
     * <td>Containment</td>
     * <td>Containment</td>
     * 
     * @param fullName a string to parse
     * @return the first segment of the input full name. Will return the input
     * string, when the input has no '.' separator
     */
    public static String firstSegmentOf( String fullName ) {

        String answer = null;
        int pos = fullName.indexOf( "." );
        if ( pos != -1 ) {
            answer = fullName.substring( 0, pos );
        } else {
            answer = fullName;
        }
        return answer;
    }

    private static Class<?> getStdClass( String typeName ) {

        return typeAbbrevMap.get( typeName );
    }

    private static void staticInit( ) {

        typeAbbrevMap = new HashMap<String, Class<?>>( );
        typeAbbrevMap.put( "void", Void.TYPE );
        typeAbbrevMap.put( "", Void.TYPE );
        typeAbbrevMap.put( "&nbsp;", Void.TYPE );
        typeAbbrevMap.put( "int", Integer.TYPE );
        typeAbbrevMap.put( "boolean", Boolean.TYPE );
        typeAbbrevMap.put( "byte", Byte.TYPE );
        typeAbbrevMap.put( "char", Character.TYPE );
        typeAbbrevMap.put( "double", Double.TYPE );
        typeAbbrevMap.put( "float", Float.TYPE );
        typeAbbrevMap.put( "long", Long.TYPE );
        typeAbbrevMap.put( "String", String.class );
        typeAbbrevMap.put( "short", Short.TYPE );

        typeAbbrevMap.put( "Integer", Integer.class );
        typeAbbrevMap.put( "Boolean", Boolean.class );
        typeAbbrevMap.put( "Byte", Byte.class );
        typeAbbrevMap.put( "Character", Character.class );
        typeAbbrevMap.put( "Double", Double.class );
        typeAbbrevMap.put( "Float", Float.class );
        typeAbbrevMap.put( "Long", Long.class );
        typeAbbrevMap.put( "String", String.class );
        typeAbbrevMap.put( "Short", Short.class );
    }

    /**
     * Returns the element in the metamodel which is an element contained by the
     * metaobject corresponding to the input object, with a name corresponding
     * to the input string. Can be used to get the Attribute instance of a
     * RefObject instance, the AssociationEnd object corresponding to a
     * RefAssociation instance, etc.
     * 
     * @param modElement element of a model, from which the metamodel element
     * will be found
     * @param fullName the fully-qualified name of the ModelElement to be
     * returned.
     * @return the ModelElement instance
     * @throws TestErrorException, of the element could not be found
     */
    public static RefObject getMetaFeature( RefBaseObject modElement, String fullName ) {

        String featureName = simpleNameOf( fullName );
        ModelElement metaClass = null;
        try {
            metaClass = (ModelElement) modElement.refMetaObject( );
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            throw new TestErrorException( "Encountered exception " + th.getClass( ).getName( ) + " when accessing the JMI meta-object of a " + modElement.getClass( ).getName( ) + " instance" );
        }
        if ( metaClass == null ) {
            throw new TestErrorException( "Method refMetaObject() invoked on a " + modElement.getClass( ).getName( ) + " instance returned null" );

        }
        try {
            GeneralizableElement ge = (GeneralizableElement) modElement.refMetaObject( );
            return ge.lookupElementExtended( featureName );
        } catch ( NameNotFoundException nnfe ) {
            log.trace( nnfe, MoinSeverity.INFO, "" );
            throw new TestErrorException( "Test parameter error: the metamodel " + "element " + featureName + " is not a direct or inherited feature " + "of the " + metaClass.getName( ) + " metamodel type" );

        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "" );
            throw new TestErrorException( "Encountered exception " + th.getClass( ).getName( ) + "with message: " + th.getMessage( ) + "while looking up the feature " + featureName );
        }
    }

    /**
     * Returns a String representation of the object, for reporting purposes
     * 
     * @param obj an object
     * @return a String representation of the object
     */
    public static String asString( Object obj ) {

        if ( obj instanceof RefBaseObject ) {
            return refBaseObjectAsString( (RefObject) obj );
        } else {
            if ( obj == null ) {
                return "null";
            } else {
                return obj.toString( );
            }
        }
    }

    /**
     * Returns the type name of a RefBaseObject instance, as defined in the
     * metamodel. The name is the dot-notation, fully-qualified name of the
     * instance's metaobject.
     * 
     * @param rbo a <code>RefBaseObject</code> value
     * @return the type name of the value, as defined in the metamodel
     */
    public static String typeName( RefBaseObject rbo ) {

        RefObject metaClass = rbo.refMetaObject( );
        if ( metaClass == null ) {
            System.out.println( ">>>>>> Util::typeName metaClass is null: " + rbo );
        }
        return dotNotation( ( (ModelElement) metaClass ).getQualifiedName( ) );
    }

    /**
     * Returns a String representation of the RefBaseObject, for reporting
     * purposes. The general form is "&lt;object-info&gt; : &lt;type-name&gt;".
     * For any RefbaseObject input, the fully-qualified name of its metaobject
     * provides the type name (such as Model.Package). For inputs which
     * correspond to the ModelElement type, the fully qualified name serves as
     * the object info.
     * <p>
     * <em>Note</em> a more descriptive string could be provided by using
     * Javabeans introspection to access all the attributes of objects; but this
     * approach would make output much larger.
     * 
     * @param rbo a <code>RefBaseObject</code> value
     * @return a String representation of the input
     */
    public static String refBaseObjectAsString( RefBaseObject rbo ) {

        if ( rbo == null ) {
            return "null";
        }
        String answer = null;
        try {
            String type = typeName( rbo );
            if ( rbo instanceof RefPackage ) {
                answer = "a RefPackage subtype instance representing " + type;
            } else if ( rbo instanceof RefAssociation ) {
                answer = "a RefAssociation subtype instance representing " + type;
            } else if ( rbo instanceof RefClass ) {
                answer = "a RefClass subtype instance representing " + type;
            } else {
                String name = null;
                if ( rbo instanceof ModelElement ) {
                    name = dotNotation( ( (ModelElement) rbo ).getQualifiedName( ) );
                } else {
                    // name = "an instance of ";
                    name = "id=" + rbo.refMofId( );
                }
                answer = name + " : " + type;
            }
        } catch ( Throwable th ) {
            log.trace( th, MoinSeverity.INFO, "Exception while generating a print name for a RefObject " + "- did not halt test" );
            answer = " undetermined RefObject";
        }
        return answer;
    }

    /**
     * Returns the RefPackage instance named by the fully-qualified name.
     * 
     * @param name the fully-qualified name of the RefPackage of interest. The
     * name is the fully-qualified name of the Model.Package metaobject of the
     * RefPackage.
     * @param top the top-level RefPackage to search within.
     * @return the RefPackage corresponding to the name, or null, if a
     * RefPackage corresponding to the name could not be found.
     */
    public static RefPackage getRefPackage( String name, RefPackage top ) {

        List<String> nameSegments = parseQualifiedName( name );
        /*
         * String pkgName = ((ModelElement) top.refMetaObject()).getName(); if
         * (nameSegments.get(0).equals(pkgName)) { if (nameSegments.size() < 2)
         * { return top; } log.trace(MoinSeverity.DEBUG, "Stripped first segment
         * from " + name + " to find RefPackage in " + pkgName);
         * nameSegments.remove(0); } else { log.trace(MoinSeverity.DEBUG, "Using
         * name " + name + " to find RefPackage in " + pkgName); }
         */
        return findRefPackage( nameSegments, top );
    }

    private static RefPackage findRefPackage( List<String> nameSegments, RefPackage top ) {

        RefPackage next = top;
        Iterator<String> it = nameSegments.iterator( );
        String pkgName = ( (ModelElement) top.refMetaObject( ) ).getName( );
        // if clustered, restart the iterator
        if ( !pkgName.equals( it.next( ) ) ) {
            it = nameSegments.iterator( );
        }

        for ( ; it.hasNext( ); ) {
            try {
                log.trace( MoinSeverity.DEBUG, "RefPackage.refPackage::: in " + typeName( top ) + " looking for " + pkgName + " returned " + ( ( next == null ) ? "null" : typeName( next ) ) );
                if ( next == null ) {
                    return null;
                }
                if ( !pkgName.equals( ( (ModelElement) next.refMetaObject( ) ).getName( ) ) ) {
                    for ( Iterator<RefPackage> i = top.refAllPackages( ).iterator( ); i.hasNext( ); ) {
                        log.trace( MoinSeverity.DEBUG, refBaseObjectAsString( i.next( ) ) );
                    }
                }
                pkgName = it.next( );
                next = next.refPackage( pkgName );
            } catch ( InvalidCallException ice ) {
                log.trace( ice, MoinSeverity.INFO, "Could not find pkgName " + pkgName + " within " + refBaseObjectAsString( next ) );
                return null;
            } catch ( InvalidNameException ice ) {
                log.trace( ice, MoinSeverity.INFO, "Could not find pkgName " + pkgName + " within " + refBaseObjectAsString( next ) );
                return null;
            }
        }
        return next;
    }

    /**
     * Returns the RefAssociation instance named by the fully-qualified name.
     * 
     * @param name the fully-qualified name of the RefAssociation of interest.
     * The name is the fully-qualified name of the Model.Association metaobject
     * of the RefAssociation.
     * @param top the top-level RefPackage to search within.
     * @return the RefAssociation corresponding to the name, or null, if a
     * RefAssociation corresponding to the name could not be found.
     */
    public static RefAssociation getRefAssociation( String name, RefPackage top ) {

        RefAssociation answer = null;
        List<String> nameSegments = parseQualifiedName( name );
        if ( nameSegments.size( ) < 2 ) {
            log.trace( MoinSeverity.INFO, "Attempting to find RefAssociation with a " + "single-segment name: " + name );
            return null;
        }
        String lastSegment = nameSegments.remove( nameSegments.size( ) - 1 );
        RefPackage pkg = findRefPackage( nameSegments, top );
        if ( pkg == null ) {
            log.trace( MoinSeverity.DEBUG, "Could not find the package in search for RefAssociation " + name + " within " + refBaseObjectAsString( top ) );
            return null;
        }
        try {
            answer = pkg.refAssociation( lastSegment );
            log.trace( MoinSeverity.DEBUG, "RefPackage.refAssociation::: in " + typeName( pkg ) + " looking for " + lastSegment + " returned " + ( ( answer == null ) ? "null" : typeName( answer ) ) );
            if ( ( answer != null ) && !lastSegment.equals( ( (ModelElement) answer.refMetaObject( ) ).getName( ) ) ) {
                for ( Iterator<RefAssociation> i = pkg.refAllAssociations( ).iterator( ); i.hasNext( ); ) {
                    log.trace( MoinSeverity.DEBUG, refBaseObjectAsString( i.next( ) ) );
                }
            }
        } catch ( InvalidCallException ice ) {
            log.trace( ice, MoinSeverity.INFO, "Could not find segment " + lastSegment + " within " + refBaseObjectAsString( pkg ) );
        } catch ( InvalidNameException ice ) {
            log.trace( ice, MoinSeverity.INFO, "Could not find segment " + lastSegment + " within " + refBaseObjectAsString( pkg ) );
        }
        if ( answer == null ) {
            log.trace( MoinSeverity.INFO, "The last segment of the name " + name + " did not designate a RefAssociation" );
        }
        return answer;
    }

    /**
     * Returns the RefClass instance named by the fully-qualified name.
     * 
     * @param name the fully-qualified name of the RefClass of interest. The
     * name is the fully-qualified name of the Model.MofClass metaobject of the
     * RefClass.
     * @param top the top-level RefPackage to search within.
     * @return the RefClass corresponding to the name, or null, if a RefClass
     * corresponding to the name could not be found.
     */
    public static RefClass getRefClass( String name, RefPackage top ) {

        RefClass answer = null;
        List<String> nameSegments = parseQualifiedName( name );
        if ( nameSegments.size( ) < 2 ) {
            log.trace( MoinSeverity.INFO, "Attempting to find RefClass with a " + "single-segment name: " + name );
            return null;
        }
        String lastSegment = nameSegments.remove( nameSegments.size( ) - 1 );
        RefPackage pkg = findRefPackage( nameSegments, top );
        if ( pkg == null ) {
            log.trace( MoinSeverity.DEBUG, "Could not find the package in search for RefClass " + name + " within " + refBaseObjectAsString( top ) );
            return null;
        }
        try {
            answer = pkg.refClass( lastSegment );
            log.trace( MoinSeverity.DEBUG, "RefPackage.refClass::: in " + typeName( pkg ) + " looking for " + lastSegment + " returned " + ( ( answer == null ) ? "null" : typeName( answer ) ) );
            if ( ( answer != null ) && !lastSegment.equals( ( (ModelElement) answer.refMetaObject( ) ).getName( ) ) ) {
                for ( Iterator<RefClass> i = pkg.refAllClasses( ).iterator( ); i.hasNext( ); ) {
                    log.trace( MoinSeverity.DEBUG, refBaseObjectAsString( i.next( ) ) );
                }
            }
        } catch ( InvalidCallException ice ) {
            log.trace( ice, MoinSeverity.INFO, "Could not find segment " + lastSegment + " within " + refBaseObjectAsString( pkg ) );
        } catch ( InvalidNameException ice ) {
            log.trace( ice, MoinSeverity.INFO, "Could not find segment " + lastSegment + " within " + refBaseObjectAsString( pkg ) );
        }
        if ( answer == null ) {
            log.trace( MoinSeverity.INFO, "The last segment of the name " + name + " did not designate a RefClass" );
        }
        return answer;
    }

    /**
     * Returns the input name as a list of segments, parsed on the '.'
     * separator.
     * 
     * @param qname a <code>String</code> value
     * @return a <code>List</code> of Strings parsed from the value. The number
     * of elements equals one more than the number of '.' occurances in the
     * input value
     */
    public static List<String> parseQualifiedName( String qname ) {

        List<String> answer = new ArrayList<String>( );
        StringTokenizer st = new StringTokenizer( qname, "." );
        while ( st.hasMoreTokens( ) ) {
            answer.add( st.nextToken( ).trim( ) );
        }
        return answer;
    }

    /**
     * Returns a qualified name as a String, with segments separated by '.'
     * 
     * @param qname a <code>List</code> of String name segments
     * @return the concatenation of the Strings in the list, with a '.' between
     * each segment.
     */
    public static String dotNotation( List<String> qname ) {

        StringBuffer sb = new StringBuffer( );
        for ( int i = 0; i < qname.size( ); i++ ) {
            if ( i > 0 ) {
                sb.append( "." );
            }
            sb.append( qname.get( i ) );
        }
        return sb.toString( );
    }

    /**
     * Returns a String describing an exception instance, a convenience
     * reporting purposes.
     * 
     * @param th a <code>Throwable</code> exception instance
     * @return a String representation of the exception instance
     */
    public static String showExc( Throwable th ) {

        return "exception " + th.getClass( ).getName( ) + " with the message " + th.getMessage( );
    }

    /**
     * Compares two Collections, returning true if they are equal. The two
     * collections are considered equal if
     * <ul>
     * <li>both are null; or
     * <li>Each of the following:
     * <ul>
     * <li>both collections are the same size; and
     * <li>every element in the first collection is contained in the second
     * collection, according to the contains method on Collections.
     * </ul>
     * </ul>
     * <p>
     * <em>Note</em> that ordering is never considered in this test. Even if
     * bothe c1 and c2 were List types, it could not be know whether they were
     * required to conform to the List requirements of JMI.
     * 
     * @param c1 a <code>Collection</code> value
     * @param c2 a <code>Collection</code> value
     * @return true, only if the two collections are equal.
     */
    public static boolean equalCollections( Collection<?> c1, Collection<?> c2 ) {

        // only one of c1 and c2 are null, return false;
        if ( ( c1 == null ) ^ ( c2 == null ) ) {
            return false;
        }
        // at this point, if c1 is null, then c2 is also
        if ( c1 == null ) {
            return true;
        }
        if ( c1.size( ) != c2.size( ) ) {
            return false;
        }
        for ( Iterator<?> i = c1.iterator( ); i.hasNext( ); ) {
            Object ele = i.next( );
            if ( !c2.contains( ele ) ) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares two Lists, returning true if the two lists are eqaul.
     * 
     * @param c1 a <code>List</code> value
     * @param c2 a <code>List</code> value
     * @return a <code>boolean</code> value
     */
    /**
     * Compares two Lists, returning true if the two lists are equal. The two
     * lists are considered equal if
     * <ul>
     * <li>both are null; or
     * <li>Each of the following:
     * <ul>
     * <li>both lists are the same size; and
     * <li>every element in the first list is equal to the element in the same
     * position in the second second list.
     * </ul>
     * </ul>
     * <p>
     * 
     * @param c1 a <code>List</code> value
     * @param c2 a <code>List</code> value
     * @return true, only if the two lists are equal.
     */
    public static boolean equalLists( List<?> c1, List<?> c2 ) {

        // only one of c1 and c2 are null, return false;
        if ( ( c1 == null ) ^ ( c2 == null ) ) {
            return false;
        }
        // at this point, if c1 is null, then c2 is also
        if ( c1 == null ) {
            return true;
        }
        if ( c1.size( ) != c2.size( ) ) {
            return false;
        }
        for ( int i = 0; i < c1.size( ); i++ ) {
            if ( !c1.get( i ).equals( c2.get( i ) ) ) {
                return false;
            }
        }
        return true;
    }

}
