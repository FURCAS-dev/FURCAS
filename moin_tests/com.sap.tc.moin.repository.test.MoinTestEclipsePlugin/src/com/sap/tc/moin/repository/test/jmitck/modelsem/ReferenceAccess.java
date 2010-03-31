package com.sap.tc.moin.repository.test.jmitck.modelsem;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.mmi.xmi.XmiReader;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.test.jmitck.TestErrorException;
import com.sap.tc.moin.repository.test.jmitck.javatest.TestDescription;

/**
 * Provides support for defining tests on References and Association Links.
 */
@SuppressWarnings( "nls" )
public class ReferenceAccess extends FeatureAccess {

    private static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_TEST, MoinLocationEnum.MOIN_TEST, ReferenceAccess.class );

    protected String referenceGetMethod;

    protected String linkGetMethod;

    protected String referenceSetMethod;

    protected String linkSetMethod;

    protected String referenceTypeName;

    protected String otherEndTypeName;

    protected String associationName;

    protected Class<?> referenceType;

    protected Class<?> otherEndType;

    protected RefObject otherEnd;

    protected RefAssociation assoc;

    @Override
    public void init( ClassLoader loader, TestDescription td, PrintWriter trOut, List<RefPackage> refPackageList, String prefix, XmiReader xmiReader ) {

        super.init( loader, td, trOut, refPackageList, prefix, xmiReader );
        this.referenceTypeName = getParam( "referenceTypeName", true );
        this.otherEndTypeName = getParam( "otherEndTypeName", true );
        referenceGetMethod = getParam( "referenceGetMethod", false );
        linkGetMethod = getParam( "linkGetMethod", false );
        if ( ( referenceGetMethod == null ) && ( linkGetMethod == null ) ) {
            String s = "Must specify either \"referenceGetMethod\" or " + "\"linkGetMethod\" parameters for this test";
            throw new TestErrorException( s );
        }
        if ( ( referenceGetMethod != null ) && ( linkGetMethod != null ) ) {
            String s = "Cannot specify both \"referenceGetMethod\" or " + "\"linkGetMethod\" parameters for this test";
            throw new TestErrorException( s );
        }
        referenceSetMethod = getParam( "referenceSetMethod", false );
        linkSetMethod = getParam( "linkSetMethod", false );
        if ( ( referenceSetMethod != null ) && ( linkSetMethod != null ) ) {
            String s = "Cannot specify both \"referenceSetMethod\" or " + "\"linkSetMethod\" parameters for this test";
            throw new TestErrorException( s );
        }
    }

    protected String nameOfGetMethod( ) {

        return ( isLinkGet( ) ) ? linkGetMethod : referenceGetMethod;
    }

    protected String nameOfSetMethod( ) {

        return ( isLinkSet( ) ) ? linkSetMethod : referenceSetMethod;
    }

    protected String showLink( RefObject referenceEnd ) {

        StringBuffer sb = new StringBuffer( );
        if ( isLinkGet( ) ) {
            sb.append( "link of association " + associationName + " is now between reference end " + Util.refBaseObjectAsString( referenceEnd ) + " and other end " + Util.refBaseObjectAsString( otherEnd ) );
        } else {
            sb.append( "reference of object " + Util.refBaseObjectAsString( otherEnd ) + " is now " + Util.refBaseObjectAsString( referenceEnd ) );
        }
        return sb.toString( );
    }

    protected RefBaseObject getGetTargetObject( ) {

        if ( isLinkGet( ) ) {
            return getAssoc( );
        } else {
            return otherEnd;
        }
    }

    protected Object getSetTargetObject( ) {

        if ( isLinkSet( ) ) {
            return getAssoc( );
        } else {
            return otherEnd;
        }
    }

    protected RefAssociation getAssoc( ) {

        if ( assoc == null ) {
            // find the association
            associationName = getParam( "associationName", true );
            assoc = instanceFactory.getAssociation( associationName );
        }
        return assoc;
    }

    protected Method getGetMethod( boolean isMv ) {

        Method m = null;
        if ( isReflectiveTest( ) ) {
            if ( isLinkGet( ) ) {
                m = getRefQueryMethod( isStrReflectiveTest );
            } else {
                m = getRefGetValueMethod( isStrReflectiveTest );
            }
        } else {
            Class<?> returnType;
            if ( isMv ) {
                returnType = Collection.class;
            } else {
                returnType = referenceType;
            }
            if ( isLinkGet( ) ) {
                m = findMethod( getGetTargetObject( ), returnType, linkGetMethod );
            } else {
                m = findMethod( getGetTargetObject( ), returnType, referenceGetMethod );
            }
        }
        return m;
    }

    protected Method getSetMethod( boolean isMv ) {

        if ( isLinkSet( ) ) {
            if ( isReflectiveTest( ) ) {
                return getRefAddLinkMethod( );
            } else {
                // since the method name is always "add", we just ignore the 
                // actual value of the linkSetMethod parameter
                return findMethod( getAssoc( ), Boolean.TYPE, "add" );
            }
        } else {
            if ( isMv ) {
                return getAddMethod( );
            } else {
                if ( isReflectiveTest( ) ) {
                    return getRefSetValueMethod( isStrReflectiveTest );
                } else {
                    return findMethod( otherEnd, Void.TYPE, referenceSetMethod );
                }
            }
        }
    }

    protected Object[] getGetParams( ) {

        List<Object> params = new ArrayList<Object>( );
        if ( isReflectiveTest( ) ) {
            Object designator = null;
            String metaStr = null;
            RefBaseObject searchTarget = null;
            if ( isLinkGet( ) ) {
                metaStr = getParam( "metaAssocEnd", true );
                searchTarget = getAssoc( );
            } else {
                metaStr = getParam( "metaReference", true );
                searchTarget = otherEnd;
            }
            if ( isStrReflectiveTest ) {
                designator = Util.simpleNameOf( metaStr );
            } else {
                designator = Util.getMetaFeature( searchTarget, metaStr );
            }
            params.add( designator );
        }
        if ( isLinkGet( ) ) {
            params.add( otherEnd );
        }
        return params.toArray( new Object[] {} );
    }

    protected Object[] getSetParams( RefObject reference ) {

        List<Object> params = new ArrayList<Object>( );
        if ( isReflectiveTest( ) ) {
            Object designator = null;
            String metaStr = null;
            if ( !isLinkSet( ) ) {
                metaStr = getParam( "metaReference", true );
                if ( isStrReflectiveTest ) {
                    designator = Util.simpleNameOf( metaStr );
                } else {
                    designator = Util.getMetaFeature( otherEnd, metaStr );
                }
                params.add( designator );
            }
        }
        if ( isLinkSet( ) ) {
            boolean referenceIsFirstEnd = getBooleanParam( "referenceIsFirstEnd", true );
            if ( referenceIsFirstEnd ) {
                params.add( reference );
                params.add( otherEnd );
            } else {
                params.add( otherEnd );
                params.add( reference );
            }
        } else {
            params.add( reference );
        }
        return params.toArray( new Object[] {} );
    }

    protected boolean isLinkGet( ) {

        return ( linkGetMethod != null );
    }

    protected boolean isLinkSet( ) {

        return ( linkSetMethod != null );
    }

    protected static Method getRefQueryMethod( boolean isStrDesignator ) {

        Class<?> designator = ( isStrDesignator ) ? String.class : RefObject.class;
        try {
            return RefAssociation.class.getMethod( "refQuery", new Class[] { designator, RefObject.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected static Method getRefAddLinkMethod( ) {

        try {
            return RefAssociation.class.getMethod( "refAddLink", new Class[] { RefObject.class, RefObject.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected static Method getRefRemoveLinkMethod( ) {

        try {
            return RefAssociation.class.getMethod( "refRemoveLink", new Class[] { RefObject.class, RefObject.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected static Method getRefSetValueMethod( boolean isStringArg ) {

        Class<?> designator = ( isStringArg ) ? String.class : RefObject.class;

        try {
            return RefFeatured.class.getMethod( "refSetValue", new Class[] { designator, Object.class } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected static Method getRefGetValueMethod( boolean isStringArg ) {

        Class<?> designator = ( isStringArg ) ? String.class : RefObject.class;

        try {
            return RefFeatured.class.getMethod( "refGetValue", new Class[] { designator } );
        } catch ( NoSuchMethodException nsme ) {
            log.trace( nsme, MoinSeverity.INFO, "" );
            return null;
        }
    }

    protected int countValues( Collection<?> c, Object val ) {

        int count = 0;
        for ( Iterator<?> i = c.iterator( ); i.hasNext( ); ) {
            if ( val.equals( i.next( ) ) ) {
                count++;
            }
        }
        return count;
    }

    protected RefObject makeOtherEnd( ) {

        otherEndType = Util.getType( otherEndTypeName );
        String strOtherEndInits = getParam( "otherEndInitializer", false );
        String otherEndCreator = getParam( "otherEndCreator", false );
        String otherEndXmi = getParam( "otherEndXmi", false );
        return (RefObject) makeRefObject( otherEndType, strOtherEndInits, otherEndCreator, otherEndXmi );
    }

}
