package com.sap.tc.moin.ocl.utils.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.__impl.AttributeImpl;

import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.TupleType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;
import org.omg.ocl.types.__impl.TupleTypeImpl;

import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;

/**
 * This class provides some methods for serializing Classifiers and qualified
 * names used in OclSerailizer and Ocl2TextTW.
 */
class SerializationHelper {

    private final static List<String> primitiveTypes = new ArrayList<String>( );

    static {
        primitiveTypes.add( OclConstants.PKG_PRTP );
    }

    /**
     * Turns a qualified name into a string. It transforms fully qualified names
     * into package local names according to the package names in
     * <tt>packageNames</tt>.
     * 
     * @param qName the fully qualified name
     * @param packageNames a list of package names
     * @return a String representation of the package local name of qName or the
     * fully qualified representation if qName does not match a package name
     * in</tt> packageNames</tt>
     */
    public String qNameToLocalString( List<String> qName, List<List<String>> packageNames ) {

        List<String> localName = getPackageLocalName( qName, packageNames );

        StringBuilder s = new StringBuilder( );
        int index = 0;
        for ( Iterator<String> i = localName.iterator( ); i.hasNext( ); index++ ) {
            if ( index > 0 ) {
                s.append( OclConstants.PATHSEP );
            }
            s.append( i.next( ) );

        }
        return s.toString( );

    }

    /**
     * Serializes a fully qualified name to a String representing the fully
     * qualified name
     * 
     * @param qName the fully qualified name
     * @return a String representing qName
     */
    public String qNameToString( List<String> qName ) {

        return qNameToLocalString( qName, new ArrayList<List<String>>( ) );
    }

    /**
     * Determines the package local name of a type.
     * 
     * @param qName the fully qualified name of a type
     * @param packageNames a list of package names
     * @return a qualified name which is local to a package in
     * <tt>packageNames</tt> or to the primitive types package.
     */
    public List<String> getPackageLocalName( List<String> qName, List<List<String>> packageNames ) {

        // primitive types are always used with package local names
        if ( isTypeInPackage( primitiveTypes, qName ) ) {
            // Real in OCL is called Float in MOF :-/
            if ( qName.get( 1 ).equals( OclConstants.T_FLOAT ) ) {
                List<String> real = new ArrayList<String>( );
                real.add( OclConstants.T_REAL );
                return real;
            }
            return qName.subList( primitiveTypes.size( ), qName.size( ) );
        }
        // search through the packageNames
        for ( List<String> packageName : packageNames ) {
            if ( isTypeInPackage( packageName, qName ) ) {
                return qName.subList( packageName.size( ), qName.size( ) );
            }
        }
        return qName;
    }

    /**
     * Serializes a Classifier. The name of the classifier is converted into a
     * package local name according to the package names in
     * <tt>packageNames</tt>. If the name of the classifier does not match a
     * package its global name is used.
     * 
     * @param connection the core connection
     * @param c The Classifier to be serialized
     * @param packageNames the List of Package names
     * @return a String representing the Classifier
     */
    public String classifierToLocalString( CoreConnection connection, Classifier c, List<List<String>> packageNames ) {

        if ( c instanceof TupleType ) {
            TupleTypeImpl tt = (TupleTypeImpl) c;
            String s = "Tuple ("; //$NON-NLS-1$
            int index = 0;
            JmiList<ModelElement> contents = (JmiList<ModelElement>) tt.getContents( connection );
            for ( int i = 0, n = contents.size( connection.getSession( ) ); i < n; i++ ) {
                Object o = contents.get( connection.getSession( ), i );
                if ( o instanceof Attribute ) {
                    AttributeImpl a = (AttributeImpl) o;
                    if ( index > 0 ) {
                        s += ", " + a.getName( ) + ":" + classifierToLocalString( connection, a.getType( connection ), packageNames ); //$NON-NLS-1$ //$NON-NLS-2$
                    } else {
                        s += a.getName( ) + ":" + classifierToLocalString( connection, a.getType( connection ), packageNames ); //$NON-NLS-1$
                    }
                }
            }
            s += ")"; //$NON-NLS-1$
            return s;
        } else if ( c instanceof CollectionType ) {
            // the name of the Collection type is the part at the beginning
            // up to the parenthesis
            String name = c.getName( ).substring( 0, c.getName( ).indexOf( "(" ) ); //$NON-NLS-1$
            Classifier elementType = ( (CollectionTypeInternal) c ).getElementType( connection );
            return name + "(" + classifierToLocalString( connection, elementType, packageNames ) + ")"; //$NON-NLS-1$ //$NON-NLS-2$
        } else {
            return qNameToLocalString( MoinMetamodelCode.getQualifiedName( connection, c, (RefObjectImpl) c ), packageNames );
        }
    }

    /**
     * Serializes a Classifier.
     * 
     * @param connection the core connection
     * @param c The Classifier to be serialized
     * @return a String representing the Classifier
     */
    public String classifierToString( CoreConnection connection, Classifier c ) {

        return classifierToLocalString( connection, c, new ArrayList<List<String>>( ) );
    }

    /**
     * Checks whether typeName starts with packageName
     * 
     * @param packageName the fully qualified name of a package
     * @param typeName the fully qualified name of a type
     * @return true if typeName starts with packageName
     */
    private boolean isTypeInPackage( List<String> packageName, List<String> typeName ) {

        int index = 0;
        if ( packageName.size( ) >= typeName.size( ) ) {
            // the package name is longer than the name of the type
            return false;
        }
        for ( String partialName : packageName ) {
            if ( !partialName.equals( typeName.get( index ) ) ) {
                // parts of the names are different
                return false;
            }
        }
        return true;
    }
}