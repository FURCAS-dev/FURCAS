package com.sap.tc.moin.ocl.evaluator.stdlib.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.TupleType;

import com.sap.tc.moin.ocl.evaluator.localization.MoinOclEvaluatorMessages;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclAny;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclFactory;
import com.sap.tc.moin.ocl.evaluator.stdlib.OclType;
import com.sap.tc.moin.ocl.ia.Statistics;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.core.mofrom.MoinMofRomServicesImpl;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinUnsupportedOperationException;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.__impl.ClassifierInternal;
import com.sap.tc.moin.repository.mql.FromEntry;
import com.sap.tc.moin.repository.mql.FromType;
import com.sap.tc.moin.repository.mql.MQLPreparedQuery;
import com.sap.tc.moin.repository.mql.MQLProcessor;
import com.sap.tc.moin.repository.mql.MQLQuery;
import com.sap.tc.moin.repository.mql.MQLResultSet;
import com.sap.tc.moin.repository.mql.QueryScopeProvider;
import com.sap.tc.moin.repository.mql.SelectAlias;
import com.sap.tc.moin.repository.mql.SelectEntry;

/**
 * {@link OclType} implementation.
 */
public class OclTypeImpl extends BaseOclAny implements OclType {

    private final Classifier underlyingClassifier;

    /**
     * Create a new OclType that wraps the supplied
     * <code>underlyingClassifier</code>.
     * 
     * @throws IllegalArgumentException Thrown if
     * <code>underlyingClassifier</code> is <code>null</code>.
     */
    OclTypeImpl( Classifier theType ) {

        if ( theType == null ) {
            throw new MoinLocalizedBaseRuntimeException( MoinOclEvaluatorMessages.UNDERLYINGVALUENOTNULL );
        }
        this.underlyingClassifier = theType;
    }

    /* Specified by interface */
    public Object getWrappedObject( ) {

        return getWrappedClassifier( );
    }

    /* Specified by interface */
    public Classifier getWrappedClassifier( ) {

        return this.underlyingClassifier;
    }

    /* Specified by interface */
    @Override
    public OclAny callOperation( CoreConnection connection, String opName, OclAny[] args ) {

        if ( OclConstants.OP_ALLINSTANCES.equals( opName ) ) {
            return evaluateAllInstances( connection );
        }
        return super.callOperation( connection, opName, args );
    }

    /**
     * Implementation of the allInstances operation.
     * 
     * @param connection
     */
    private OclAny evaluateAllInstances( CoreConnection connection ) {

        // this function is not defined for primitive types, tuple types and
        // collection types
        if ( this.underlyingClassifier instanceof TupleType || this.underlyingClassifier instanceof PrimitiveType || this.underlyingClassifier instanceof CollectionType ) {
            return OclInvalidImpl.OCL_INVALID;
        }

        // for invalid and null, there is only one instance ever
        String classname = this.underlyingClassifier.getName( );
        HashSet<OclAny> objects = new HashSet<OclAny>( );
        if ( OclConstants.T_OCLVOIDSTDLIB.equals( classname ) ) {
            objects.add( OclVoidImpl.OCL_UNDEFINED );
            return OclFactory.instance( ).createSetFromOclAnyObjects( objects );
        }

        if ( OclConstants.T_OCLINVALIDSTDLIB.equals( classname ) ) {
            objects.add( OclInvalidImpl.OCL_INVALID );
            return OclFactory.instance( ).createSetFromOclAnyObjects( objects );
        }

        Set<RefObjectImpl> allInstances = getAllInstances( connection, ( (ClassifierInternal) this.underlyingClassifier ).getQualifiedName( connection ) );
        return OclFactory.instance( ).createSetFromRefObjects( allInstances );
    }

    @Override
    // TODO: Remove this once this class doesn't implement OclAny
    protected boolean isUnderlyingValueKindOf( CoreConnection connection, Classifier classifier ) {

        throw new MoinUnsupportedOperationException( "isUnderlyingValueKindOf" ); //$NON-NLS-1$
    }

    // TODO: Remove this once this class doesn't implement OclAny
    @Override
    protected boolean isUnderlyingValueTypeOf( CoreConnection connection, Classifier classifier ) {

        throw new MoinUnsupportedOperationException( "isUnderlyingValueTypeOf" ); //$NON-NLS-1$
    }

    @Override
    protected OclAny evaluateAsToString( CoreConnection connection ) {

        List<String> pathName = MoinMetamodelCode.getQualifiedName( connection, this.underlyingClassifier, (RefObjectImpl) this.underlyingClassifier );
        StringBuilder stringValue = new StringBuilder( );
        for ( Object pathPart : pathName ) {
            stringValue.append( OclConstants.PATHSEP );
            stringValue.append( pathPart );
        }
        stringValue.deleteCharAt( 0 );
        stringValue.deleteCharAt( 0 );

        return new OclStringImpl( stringValue.toString( ) );
    }

    public static Set<RefObjectImpl> getAllInstances( CoreConnection connection, List<String> classQname ) {
	Set<MRI> foundMris = getAllInstancesMris(connection, classQname);
        Set<RefObjectImpl> instances = new HashSet<RefObjectImpl>( );
        if ( !foundMris.isEmpty( ) ) {
            for ( MRI mri : foundMris ) {
                RefObjectImpl element = (RefObjectImpl) connection.getElement( mri );
                if(element != null) {
                    instances.add( element );
                }
            }
        }
        return instances;
    }

    public static Set<MRI> getAllInstancesMris(CoreConnection connection, List<String> classQname) {
	Statistics.getInstance().allInstancesCalled(classQname);
        Set<MRI> foundMris = new HashSet<MRI>( );

        String[] className = new String[classQname.size( )];
        classQname.toArray( className );

        MQLProcessor processor = connection.getMQLProcessor( );
        // everything except MOF
        FromType typeType = new FromType( "constraint", className, false ); //$NON-NLS-1$

        FromEntry[] fromEntries = new FromEntry[] { typeType };

        // we only need the MRIs
        SelectAlias selectMris = new SelectAlias( "constraint" ); //$NON-NLS-1$

        SelectEntry[] selectEntries = new SelectEntry[] { selectMris };

        // the actual query
        MQLQuery query = new MQLQuery( selectEntries, fromEntries );

        MQLPreparedQuery preparedQuery = processor.prepare( query );

        MQLResultSet foundConstraints = processor.execute( preparedQuery );

        for ( int i = 0; i < foundConstraints.getSize( ); i++ ) {
            foundMris.add( foundConstraints.getMri( i, "constraint" ) ); //$NON-NLS-1$
        }
        if ( className[0].equals( "Model" ) || className[0].equals( "OCL" ) ) { //$NON-NLS-1$//$NON-NLS-2$

            // merge with MOF stuff
            QueryScopeProvider queryScopeProvider = processor.getInclusiveCriScopeProvider( new CRI[] { connection.getSession( ).getMoin( ).getMofRomCri( ) } );
            typeType = new FromType( "constraint", className, MoinMofRomServicesImpl.MOFROM_MODELPARTITION_CONTAINER_NAME, true, queryScopeProvider ); //$NON-NLS-1$

            fromEntries = new FromEntry[] { typeType };

            // the actual query
            query = new MQLQuery( selectEntries, fromEntries );

            preparedQuery = processor.prepare( query );

            foundConstraints = processor.execute( preparedQuery );

            for ( int i = 0; i < foundConstraints.getSize( ); i++ ) {
                foundMris.add( foundConstraints.getMri( i, "constraint" ) ); //$NON-NLS-1$
            }
        }
	return foundMris;
    }
}
