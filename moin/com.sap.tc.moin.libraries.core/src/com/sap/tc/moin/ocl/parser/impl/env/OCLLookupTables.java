package com.sap.tc.moin.ocl.parser.impl.env;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.PrimitiveType;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.ParameterImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.StructureTypeInternal;
import com.sap.tc.moin.repository.mmi.reflect.JmiException;

import org.omg.ocl.stdlibrary.StdLibraryPackage;
import org.omg.ocl.types.BagType;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;
import org.omg.ocl.types.TupleType;
import org.omg.ocl.types.TypesPackage;
import org.omg.ocl.types.VoidType;
import org.omg.ocl.types.__impl.CollectionTypeInternal;

import com.sap.tc.moin.ocl.parser.IOCLLookupTables;
import com.sap.tc.moin.ocl.parser.IOCLTypeChecker;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.core.jmi.util.MoinMetamodelCode;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * Service with <i>global</i> lookup tables, i.e. tables which are independent
 * of the current context
 */
public class OCLLookupTables implements IOCLLookupTables {

    /**
     * The helper used to instantiate JMI-classes
     */
    private final MoinJmiCreator jmiCreator;

    /**
     * Unfortunately, it is not possible to model the original operation names
     * in Rose/MOF as some of the operations have "invalid" names. Therefore, we
     * have to translate the names to names found in the model, which is done
     * using this hash table.
     */
    private final Map<String, String> opAliases = new HashMap<String, String>( );

    /**
     * This maps from Classifier to Set<Operation>. The Operations stored in
     * this Map are user-defined operations. They will also be looked up in
     * here. This is done in order to have the helper operations for the MOF
     * Constraints parsed without having to actually attach them to the model
     * which is not possible, since these operation are not modeled.
     */
    private final Map<Classifier, Map<String, Operation>> userDefOps = new HashMap<Classifier, Map<String, Operation>>( );

    private final Set<String> libraryOperations = new HashSet<String>( 70 );

    /**
     * The package containing the OCL standard library
     */
    private MofPackageImpl oclStdLibPkg;

    /**
     * Service with <i>global</i> lookup tables, i.e. tables which are
     * independent of the current context
     * 
     * @param theJmiCreator the jmi creator
     */
    public OCLLookupTables( MoinJmiCreator theJmiCreator ) {

        this.jmiCreator = theJmiCreator;

        try {
            // try to obtain the OCL standard library package
            this.oclStdLibPkg = (MofPackageImpl) this.getOclStdLibPkg( );
        } catch ( Exception e ) {
            // Problem obtain the standard OCL library
            OclSemanticException ex = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1100 );
            ProcessError error = new ProcessErrorImpl( ex );
            throw new FatalParsingException( ex, error );
        }

        // define a list of primitive library operations and their aliases
        this.setupOpNameAliases( );
    }

    /**
     * Initializes the set of all aliases for symbolic operations and the other
     * library functions for fast retrieval
     */
    private void setupOpNameAliases( ) {

        // 10
        this.opAliases.put( OclConstants.A_PLUS, OclConstants.OP_PLUSSTDLIB );
        this.libraryOperations.add( OclConstants.OP_PLUSSTDLIB );
        this.opAliases.put( OclConstants.A_MINUS, OclConstants.OP_MINUSSTDLIB );
        this.libraryOperations.add( OclConstants.OP_MINUSSTDLIB );
        this.opAliases.put( OclConstants.A_MULT, OclConstants.OP_MULTSTDLIB );
        this.libraryOperations.add( OclConstants.OP_MULTSTDLIB );
        this.opAliases.put( OclConstants.A_DIV, OclConstants.OP_DIVSTDLIB );
        this.libraryOperations.add( OclConstants.OP_DIVSTDLIB );
        this.opAliases.put( OclConstants.A_LT, OclConstants.OP_LTSTDLIB );
        this.libraryOperations.add( OclConstants.OP_LTSTDLIB );
        this.opAliases.put( OclConstants.A_GT, OclConstants.OP_GTSTDLIB );
        this.libraryOperations.add( OclConstants.OP_GTSTDLIB );
        this.opAliases.put( OclConstants.A_LTEQ, OclConstants.OP_LTEQSTDLIB );
        this.libraryOperations.add( OclConstants.OP_LTEQSTDLIB );
        this.opAliases.put( OclConstants.A_GTEQ, OclConstants.OP_GTEQSTDLIB );
        this.libraryOperations.add( OclConstants.OP_GTEQSTDLIB );
        this.opAliases.put( OclConstants.A_N, OclConstants.OP_N );
        this.libraryOperations.add( OclConstants.OP_N );
        this.opAliases.put( OclConstants.A_EQ, OclConstants.OP_EQSTDLIB );
        this.libraryOperations.add( OclConstants.OP_EQSTDLIB );
        this.opAliases.put( OclConstants.A_NEQ, OclConstants.OP_NOTEQSTDLIB );
        this.libraryOperations.add( OclConstants.OP_NOTEQSTDLIB );

        // 60
        this.libraryOperations.add( OclConstants.OP_ALLINSTANCES );
        this.libraryOperations.add( OclConstants.OP_OCLISNEW );
        this.libraryOperations.add( OclConstants.OP_OCLISUNDEFINED );
        this.libraryOperations.add( OclConstants.OP_OCLISINVALID );
        this.libraryOperations.add( OclConstants.OP_OCLASTYPE );
        this.libraryOperations.add( OclConstants.OP_OCLISTYPEOF );
        this.libraryOperations.add( OclConstants.OP_OCLISKINDOF );
        this.libraryOperations.add( OclConstants.OP_ASSET );
        this.libraryOperations.add( OclConstants.OP_TOSTRING );
        this.libraryOperations.add( OclConstants.OP_SIZE );
        this.libraryOperations.add( OclConstants.OP_INCLUDES );
        this.libraryOperations.add( OclConstants.OP_EXCLUDES );
        this.libraryOperations.add( OclConstants.OP_COUNT );
        this.libraryOperations.add( OclConstants.OP_INCLUDESALL );
        this.libraryOperations.add( OclConstants.OP_EXCLUDESALL );
        this.libraryOperations.add( OclConstants.OP_ISEMPTY );
        this.libraryOperations.add( OclConstants.OP_NOTEMPTY );
        this.libraryOperations.add( OclConstants.OP_SUM );
        this.libraryOperations.add( OclConstants.OP_PRODUCT );
        this.libraryOperations.add( OclConstants.OP_ASBAG );
        this.libraryOperations.add( OclConstants.OP_ASSEQUENCE );
        this.libraryOperations.add( OclConstants.OP_ASORDEREDSET );
        this.libraryOperations.add( OclConstants.OP_OR );
        this.libraryOperations.add( OclConstants.OP_AND );
        this.libraryOperations.add( OclConstants.OP_XOR );
        this.libraryOperations.add( OclConstants.OP_NOT );
        this.libraryOperations.add( OclConstants.OP_IMPLIES );
        this.libraryOperations.add( OclConstants.OP_ABS );
        this.libraryOperations.add( OclConstants.OP_FLOOR );
        this.libraryOperations.add( OclConstants.OP_ROUND );
        this.libraryOperations.add( OclConstants.OP_MAX );
        this.libraryOperations.add( OclConstants.OP_MIN );
        this.libraryOperations.add( OclConstants.OP_INTDIVSTDLIB );
        this.libraryOperations.add( OclConstants.OP_LONGDIVSTDLIB );
        this.libraryOperations.add( OclConstants.OP_NEGSTDLIB );
        this.libraryOperations.add( OclConstants.OP_UNION );
        this.libraryOperations.add( OclConstants.OP_INTERSECTION );
        this.libraryOperations.add( OclConstants.OP_INCLUDING );
        this.libraryOperations.add( OclConstants.OP_EXCLUDING );
        this.libraryOperations.add( OclConstants.OP_SYMMDIF );
        this.libraryOperations.add( OclConstants.OP_FLATTEN );
        this.libraryOperations.add( OclConstants.OP_APPEND );
        this.libraryOperations.add( OclConstants.OP_PREPEND );
        this.libraryOperations.add( OclConstants.OP_INSERTAT );
        this.libraryOperations.add( OclConstants.OP_SUBORDEREDSET );
        this.libraryOperations.add( OclConstants.OP_AT );
        this.libraryOperations.add( OclConstants.OP_INDEXOF );
        this.libraryOperations.add( OclConstants.OP_FIRST );
        this.libraryOperations.add( OclConstants.OP_LAST );
        this.libraryOperations.add( OclConstants.OP_SUBSEQUENCE );
        this.libraryOperations.add( OclConstants.OP_MINUS );
        this.libraryOperations.add( OclConstants.OP_MOD );
        this.libraryOperations.add( OclConstants.OP_CONCAT );
        this.libraryOperations.add( OclConstants.OP_SUBSTRING );
        this.libraryOperations.add( OclConstants.OP_TOINTEGER );
        this.libraryOperations.add( OclConstants.OP_TODOUBLE );
        this.libraryOperations.add( OclConstants.OP_MATCHES );
        this.libraryOperations.add( OclConstants.OP_TOUPPER );
        this.libraryOperations.add( OclConstants.OP_TOLOWER );
    }

    /**
     * @return the package containing the OCL Standard Library with all its
     * operations.
     * @throws JmiException
     */
    private MofPackage getOclStdLibPkg( ) throws JmiException {

        return this.jmiCreator.getPackage( StdLibraryPackage.PACKAGE_DESCRIPTOR ).refMetaObject( );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLLookupTables#defineUserDefOperation
     * (com.sap.tc.moin.repository.mmi.model.Classifier, com.sap.tc.moin.repository.mmi.model.Operation)
     */
    public void defineUserDefOperation( Classifier owner, Operation userDefOp ) {

        Map<String, Operation> operations = this.userDefOps.get( owner );
        if ( operations == null ) {
            operations = new Hashtable<String, Operation>( );
            this.userDefOps.put( owner, operations );
        }
        operations.put( userDefOp.getName( ), userDefOp );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLLookupTables#lookupUserDefOperation
     * (com.sap.tc.moin.repository.mmi.model.Classifier, java.lang.String, java.util.List,
     * com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker)
     */
    public Operation lookupUserDefOperation( Classifier owner, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker ) {

        Map<String, Operation> operations = this.userDefOps.get( owner );
        if ( operations == null ) {
            return null;
        }
        Operation op = operations.get( opName );

        if ( ( op != null ) && oclTypeChecker.argumentsConform( op, args ) ) {
            return op;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLLookupTables#lookupFeature(javax
     * .jmi.model.Classifier, java.lang.String)
     */
    public ModelElement lookupFeature( Classifier type, String name ) throws OclSemanticException {

        Set<ModelElement> features = this.lookupFeatureByName( type, name );
        int size = features.size( );
        if ( size == 0 ) {
            // no features found
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1007, new Object[] { name, StringHelper.toPathName( type.getQualifiedName( ) ) } );
        } else if ( size > 1 ) {
            // ambiguous
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1006, new Object[] { StringHelper.toPathName( type.getQualifiedName( ) ), name } );
        } else {
            return features.iterator( ).next( );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLLookupTables#lookupFeature(javax
     * .jmi.model.Classifier, java.lang.String)
     */
    public ModelElement lookupOptFeature( Classifier type, String name ) throws OclSemanticException {

        Set<ModelElement> features = this.lookupFeatureByName( type, name );
        int size = features.size( );
        if ( size == 0 ) {
            return null;
        } else if ( size > 1 ) {
            // ambiguous
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1006, new Object[] { StringHelper.toPathName( type.getQualifiedName( ) ), name } );
        } else {
            return features.iterator( ).next( );
        }
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.IOCLLookupTables#lookupFeatureByName(javax
     * .jmi.model.Classifier, java.lang.String)
     */
    public Set<ModelElement> lookupFeatureByName( Classifier type, String name ) {

        Set<ModelElement> result = new HashSet<ModelElement>( 1 );

        if ( type instanceof MofClass ) {

            CoreConnection connection = this.jmiCreator.getConnection( );
            SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );

            // a MofClass can have attributes and references, or can be referred
            // by association ends. First, we try to find an attribute
            List<Attribute> attributes = jmiHelper.getAttributes( connection.getSession( ), (MofClass) type, true );

            for ( Iterator<Attribute> i = attributes.iterator( ); i.hasNext( ); ) {
                Attribute a = i.next( );
                if ( a.getName( ).equals( name ) ) {
                    result.add( a );
                }
            }

            if ( result.size( ) > 0 ) {
                return result;
            }

            // maybe name is a reference?
            List<Reference> references = jmiHelper.getReferences( connection.getSession( ), (MofClass) type, true );
            for ( Iterator<Reference> i = references.iterator( ); i.hasNext( ); ) {
                ReferenceImpl r = (ReferenceImpl) i.next( );
                if ( r.getName( ).equals( name ) ) {
                    result.add( r.getReferencedEnd( this.jmiCreator.getConnection( ) ) );
                }
            }

            if ( result.size( ) > 0 ) {
                return result;
            }

            // maybe it is an association end name?
            Set<AssociationEnd> associationEnds = jmiHelper.getAssociationEnds( connection.getSession( ), type, true );
            for ( Iterator<AssociationEnd> i = associationEnds.iterator( ); i.hasNext( ); ) {
                AssociationEnd a = ( (AssociationEndImpl) i.next( ) ).otherEnd( connection );
                if ( a.getName( ).equals( name ) ) {
                    result.add( a );
                }
            }

        } else if ( type instanceof StructureTypeInternal ) {
            CoreConnection conn = this.jmiCreator.getConnection( );
            StructureTypeInternal st = (StructureTypeInternal) type;
            List<GeneralizableElement> supertypes = st.allSupertypes( conn );
            // the meaning of feature lookup is all top-level contents in all
            // other cases. This is used
            // in tuple handling for instance
            JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) type ).getContents( conn );
            for ( int i = 0, n = contents.size( conn.getSession( ) ); i < n; i++ ) {
                ModelElement e = contents.get( conn.getSession( ), i );
                if ( e.getName( ).equals( name ) ) {
                    result.add( e );
                }
            }

            while ( result.isEmpty( ) ) {
                for ( GeneralizableElement superstruct : supertypes ) {
                    JmiList<ModelElement> stcontents = (JmiList<ModelElement>) ( (NamespaceInternal) superstruct ).getContents( conn );
                    for ( int i = 0, n = stcontents.size( conn.getSession( ) ); i < n; i++ ) {
                        ModelElement e = stcontents.get( conn.getSession( ), i );
                        if ( e.getName( ).equals( name ) ) {
                            result.add( e );
                        }
                    }
                }
            }
        } else {
            // the meaning of feature lookup is all top-level contents in all
            // other cases. This is used
            // in tuple handling for instance
            CoreConnection conn = this.jmiCreator.getConnection( );
            JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) type ).getContents( conn );
            for ( int i = 0, n = contents.size( conn.getSession( ) ); i < n; i++ ) {
                ModelElement e = contents.get( conn.getSession( ), i );
                if ( e.getName( ).equals( name ) ) {
                    result.add( e );
                }
            }
        }

        return result;
    }

    /**
     * Methods searches for an operation with opName, arguments args on the
     * classifier type within the standard OCL library. If none exists, null is
     * returned. This method only applies for standard library operations
     * formulated on primitive types or collection types!
     */
    private Operation lookupStdLibOp( Classifier type, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker, OclSemanticException[] messages ) {

        // unfortunately, we have to translate some operation names because
        // their names were not allowed when
        // serializing the models
        String realOpName = this.getRealOpName( type, opName, args );

        if ( !this.libraryOperations.contains( realOpName ) ) {
            return null;
        }

        CoreConnection conn = this.jmiCreator.getConnection( );

        ModelElement me;
        try {
            Classifier oclType = null;
            try {
                if ( type instanceof BagType ) {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, OclConstants.T_BAGTYPESTDLIB );
                } else if ( type instanceof SetType ) {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, OclConstants.T_SETTYPESTDLIB );
                } else if ( type instanceof SequenceType ) {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, OclConstants.T_SEQUENCETYPESTDLIB );
                } else if ( type instanceof OrderedSetType ) {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, OclConstants.T_ORDEREDSETTYPESTDLIB );
                } else if ( type instanceof CollectionType ) {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, OclConstants.T_COLLTYPESTDLIB );
                } else if ( type instanceof PrimitiveType ) {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, type.getName( ) + OclConstants.STDLIBSUFFIX );
                } else if ( type instanceof VoidType ) {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, OclConstants.T_OCLVOIDSTDLIB );
                } else if ( type instanceof TupleType ) {
                    // we currently only support the universal operation on
                    // tuple types
                    oclType = this.jmiCreator.getAnyClass( );
                    // TODO it should really be the following (which should sub
                    // type OclAny!
                    // oclType = (Classifier)
                    // this.oclStdLibPkg.lookupElement("TupleTypeStdLib");
                } else {
                    oclType = (Classifier) this.oclStdLibPkg.lookupElement( conn, type.getName( ) );
                }
            } catch ( NameNotFoundException e ) {
                // in all other cases, we have non-library type for which all
                // the operations
                // defined on OclAny are available
                oclType = this.jmiCreator.getAnyClass( );
            }

            // lookup the actual operation
            me = MoinMetamodelCode.lookupElementExtended( conn, oclType, (RefObjectImpl) oclType, realOpName );
        } catch ( NameNotFoundException e ) {
            me = null;
        } catch ( JmiException e ) {
            me = null;
        }

        // now we get the operation
        if ( me instanceof Operation ) {
            Operation originalOp = (Operation) me;
            JmiList<ModelElement> opContents = (JmiList<ModelElement>) ( (NamespaceInternal) originalOp ).getContents( conn );
            List<Classifier> inputParameterTypes = new ArrayList<Classifier>( opContents.size( conn.getSession( ) ) );
            for ( int i = 0, n = opContents.size( conn.getSession( ) ); i < n; i++ ) {
                Object o = opContents.get( conn.getSession( ), i );
                if ( o instanceof Parameter ) {
                    ParameterImpl p = (ParameterImpl) o;
                    if ( p.getDirection( ) == DirectionKindEnum.IN_DIR ) {
                        Classifier parType = this.getModelType( p.getType( conn ) );
                        inputParameterTypes.add( parType );
                    }
                }
            }

            if ( oclTypeChecker.argumentsMatch( args, inputParameterTypes ) ) {

                // We might have a hit. We still have to further check if the
                // found types are constrained enough
                // Observe that we have a problem with return types and cannot
                // make them more specific as we have no
                // control on the different operation types. NOTE: This
                // introduces a hole in the type system and should
                // be caught at runtime!
                if ( this.stdLibOperationOk( realOpName, type, args, oclTypeChecker, messages ) ) {
                    return originalOp;
                }
            }
        }
        return null;

    }

    /**
     * This method further checks the type constraints of some library
     * operations as the meta-model for the standard library is not quite
     * accurate enough
     */
    private boolean stdLibOperationOk( String opName, Classifier sourceType, List<Classifier> argTypes, IOCLTypeChecker oclTypeChecker, OclSemanticException[] messages ) {

        if ( opName.equals( OclConstants.OP_EQSTDLIB ) || opName.equals( OclConstants.OP_NOTEQSTDLIB ) ) {
            Classifier argType = argTypes.get( 0 );
            // equals requires conformant types
            if ( !( oclTypeChecker.typesConform( argType, sourceType ) || oclTypeChecker.typesConform( sourceType, argType ) ) ) {
                if ( messages.length > 0 ) {
                    messages[1] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1028, new Object[] { StringHelper.toString( sourceType ), StringHelper.toString( argType ) } );
                }
                return false;
            }

        } else if ( opName.equals( OclConstants.OP_OCLASTYPE ) || opName.equals( OclConstants.OP_OCLISKINDOF ) || opName.equals( OclConstants.OP_OCLISTYPEOF ) ) {
            Classifier argType = argTypes.get( 0 );
            // the argument has to be a type expression
            if ( !( argType.equals( this.jmiCreator.getOclTypeClass( ) ) ) ) {
                if ( messages.length > 0 ) {
                    messages[1] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1029, new Object[] { opName } );
                }
                return false;
            }

        } else if ( opName.equals( OclConstants.OP_INCLUDES ) || opName.equals( OclConstants.OP_EXCLUDES ) || opName.equals( OclConstants.OP_COUNT ) || opName.equals( OclConstants.OP_INCLUDING ) || opName.equals( OclConstants.OP_APPEND ) || opName.equals( OclConstants.OP_PREPEND )
                    || opName.equals( OclConstants.OP_INDEXOF ) ) {
            Classifier argType = argTypes.get( 0 );
            // the argument's type has to be conform to the type of the
            // collection
            if ( !( oclTypeChecker.typesConform( argType, ( (CollectionTypeInternal) sourceType ).getElementType( this.jmiCreator.getConnection( ) ) ) ) ) {
                if ( messages.length > 0 ) {
                    messages[1] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1030, new Object[] { opName, StringHelper.toString( argType ), StringHelper.toString( ( (CollectionTypeInternal) sourceType ).getElementType( this.jmiCreator.getConnection( ) ) ) } );
                }
                return false;
            }

        } else if ( opName.equals( OclConstants.OP_INCLUDESALL ) || opName.equals( OclConstants.OP_EXCLUDESALL ) || opName.equals( OclConstants.OP_N ) || opName.equals( OclConstants.OP_SYMMDIF ) ) {
            Classifier argType = argTypes.get( 0 );
            // the element type of the argument has to be conform to the element
            // type of the collection or the other way around
            Classifier type1 = ( (CollectionTypeInternal) argType ).getElementType( this.jmiCreator.getConnection( ) );
            Classifier type2 = ( (CollectionTypeInternal) sourceType ).getElementType( this.jmiCreator.getConnection( ) );

            if ( ( !oclTypeChecker.typesConform( type1, type2 ) ) || ( !oclTypeChecker.typesConform( type2, type1 ) ) ) {
                if ( messages.length > 0 ) {
                    messages[1] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1031, new Object[] { opName, StringHelper.toString( type1 ), StringHelper.toString( type2 ) } );
                }
                return false;
            }
        } else if ( opName.equals( OclConstants.OP_UNION ) || opName.equals( OclConstants.OP_INTERSECTION ) ) {
            Classifier argType = argTypes.get( 0 );
            // the element type of the argument has to be conform to the element
            // type of the collection or the other way around
            CollectionTypeInternal collTypeArg = (CollectionTypeInternal) argType;
            CollectionTypeInternal collTypeSource = (CollectionTypeInternal) sourceType;
            Classifier type1 = collTypeArg.getElementType( this.jmiCreator.getConnection( ) );
            Classifier type2 = collTypeSource.getElementType( this.jmiCreator.getConnection( ) );

            // check that if we have a bag or set as source, we also have a bag
            // or set as argument
            if ( collTypeSource instanceof BagType || collTypeSource instanceof SetType ) {
                if ( !( collTypeArg instanceof BagType || collTypeArg instanceof SetType ) ) {
                    if ( messages.length > 0 ) {
                        messages[1] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1032, new Object[] { opName, StringHelper.toString( (Classifier) collTypeSource ), StringHelper.toString( (Classifier) collTypeArg ) } );
                    }
                    return false;
                }
            }

            // compare the element types
            if ( !( oclTypeChecker.typesConform( type1, type2 ) || oclTypeChecker.typesConform( type2, type1 ) ) ) {
                if ( messages.length > 0 ) {
                    messages[1] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1031, new Object[] { opName, StringHelper.toString( type1 ), StringHelper.toString( type2 ) } );
                }
                return false;
            }

        } else if ( opName.equals( OclConstants.OP_INSERTAT ) ) {
            Classifier argType = argTypes.get( 1 );
            // the argument's type has to be conform to the type of the
            // collection
            if ( !( oclTypeChecker.typesConform( argType, ( (CollectionTypeInternal) sourceType ).getElementType( this.jmiCreator.getConnection( ) ) ) ) ) {
                if ( messages.length > 0 ) {
                    messages[1] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1030, new Object[] { opName, StringHelper.toString( argType ), StringHelper.toString( ( (CollectionTypeInternal) sourceType ).getElementType( this.jmiCreator.getConnection( ) ) ) } );
                }
                return false;
            }
        }
        // otherwise we're definitely fine
        return true;
    }

    /**
     * Returns the "real" type for a given Ocl standard library type. We have to
     * do this conversion because the standard library only
     * 
     * @param oclType
     * @return the type
     */
    private Classifier getModelType( Classifier oclType ) {

        String typeName = oclType.getName( );
        // check if the package is correct
        if ( ( (RefObjectImpl) oclType ).refImmediateComposite( this.jmiCreator.getSession( ) ).equals( this.oclStdLibPkg ) ) {
            // handle the primitive types
            if ( OclConstants.T_INTEGERSTDLIB.equals( typeName ) ) {
                return this.jmiCreator.getIntClass( );
            } else if ( OclConstants.T_LONGSTDLIB.equals( typeName ) ) {
                return this.jmiCreator.getLongClass( );
            } else if ( OclConstants.T_FLOATSTDLIB.equals( typeName ) ) {
                return this.jmiCreator.getFloatClass( );
            } else if ( OclConstants.T_DOUBLESTDLIB.equals( typeName ) ) {
                return this.jmiCreator.getDoubleClass( );
            } else if ( OclConstants.T_OCLANYSTDLIB.equals( typeName ) ) {
                return this.jmiCreator.getAnyClass( );
            } else if ( OclConstants.T_STRINGSTDLIB.equals( typeName ) ) {
                return this.jmiCreator.getStringClass( );
            } else if ( OclConstants.T_BOOLEANSTDLIB.equals( typeName ) ) {
                return this.jmiCreator.getBoolClass( );
            } else {
                // non-primitive types
                MofPackageImpl oclTypes = (MofPackageImpl) this.jmiCreator.getPackage( TypesPackage.PACKAGE_DESCRIPTOR ).refMetaObject( );

                // look for type (which we expect to find)
                ModelElement me = null;
                try {
                    me = oclTypes.lookupElement( this.jmiCreator.getConnection( ), oclType.getName( ) );
                } catch ( NameNotFoundException e ) {
                    // $JL-EXC$ nothing
                } catch ( JmiException e ) {
                    // $JL-EXC$ nothing
                }

                if ( me instanceof Classifier ) {
                    // we only expect a classifier
                    return (Classifier) me;
                }

                // Internal Error - should not happen
                throw new MoinLocalizedBaseRuntimeException( OclParserMessages.STDLIBTYPENOTFOUND );
            }
        }

        // the type wasn't actually form the OCL Std Library
        return oclType;
    }

    /**
     * Unfortunately, it is not possible to model the original operation names
     * in Rose/MOF as some of the operations have "invalid" names. Therefore, we
     * have to translate the names to names found in the model.
     * 
     * @param type The type on which the operation is defined
     * @param opName the name of the operation
     * @param args the argument types of the operation
     * @return the name of the operation as found in the model
     */
    private String getRealOpName( Classifier type, String opName, List<Classifier> args ) {

        String realOpName = opName;
        if ( OclConstants.A_MINUS.equals( opName ) ) {
            if ( args.size( ) == 0 ) {
                realOpName = OclConstants.OP_NEGSTDLIB;
            } else {
                realOpName = OclConstants.OP_MINUSSTDLIB;
            }
        } else if ( OclConstants.OP_DIV.equals( opName ) ) {
            if ( type.equals( this.jmiCreator.getIntClass( ) ) ) {
                realOpName = OclConstants.OP_INTDIVSTDLIB;
            } else {
                realOpName = OclConstants.OP_LONGDIVSTDLIB;
            }
        } else {
            if ( this.opAliases.containsKey( opName ) ) {
                realOpName = this.opAliases.get( opName );
            }
        }
        return realOpName;
    }

    public Operation lookupOperation( Classifier pType, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker ) {

        return this.lookupOperation( pType, opName, args, oclTypeChecker, new OclSemanticException[0] );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLLookupTables#lookupOperation(
     * com.sap.tc.moin.repository.mmi.model.Classifier, java.lang.String, java.util.List,
     * com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker)
     */
    public Operation lookupOperation( Classifier pType, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker, OclSemanticException[] messages ) {

        CoreConnection conn = this.jmiCreator.getConnection( );
        // obtain the non-alias type
        Classifier type = conn.getCoreJmiHelper( ).getNonAliasType( conn.getSession( ), pType );

        // TODO this is because of MTI rule types, which are anonymous by
        // themselves
        if ( type.getName( ) == null ) {
            return null;
        }

        // first check for a library operation on the library types
        Operation op = this.lookupStdLibOp( type, opName, args, oclTypeChecker, messages );

        // then, we look for a MOF operation (this may override a library
        // operation if not defined
        // on a non-library type). Notice that
        // the container may be null for OCL-generated typed collections like
        // Set etc. Moreover,
        // user-defined MOF operations get precedence over library operations
        // (and thus may redefine them!)
        // We issue a warning
        Namespace container = (Namespace) ( (RefObjectImpl) type ).refImmediateComposite( this.jmiCreator.getSession( ) );
        if ( container != null && ( !( container.getName( ).equals( OclConstants.P_STDLIBRARY ) ) ) ) {
            Operation userMofOp = this.lookupMofOperation( type, opName, args, oclTypeChecker );
            if ( userMofOp != null ) {
                if ( op != null && messages.length > 0 ) {
                    messages[0] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1026, new Object[] { opName } );
                }
                op = userMofOp;
            }
        }

        // finally, check also for a user-defined operation, which again
        // overrides MOF operations
        Operation userDefOp = this.lookupUserDefOperation( type, opName, args, oclTypeChecker );
        if ( userDefOp != null ) {
            if ( op != null && messages.length > 0 ) {
                messages[0] = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1027, new Object[] { opName } );
            }
            op = userDefOp;
        }

        // return whatever we have found
        return op;
    }

    /**
     * Looks up an operation on a MOF type
     * 
     * @param type in which to lookup the operation
     * @param opName the name of the operation
     * @param args the types of the arguments
     * @return the operation if found or <tt>null</tt>
     */
    private Operation lookupMofOperation( Classifier type, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker ) {

        ModelElement me;
        try {
            me = MoinMetamodelCode.lookupElementExtended( this.jmiCreator.getConnection( ), type, (RefObjectImpl) type, opName );
        } catch ( NameNotFoundException e1 ) {
            // no such operation found
            return null;
        }
        if ( me instanceof Operation ) {
            Operation op = (Operation) me;
            // if the name and the types matches
            if ( op.getName( ).equals( opName ) && oclTypeChecker.argumentsConform( op, args ) ) {
                return op;
            }
        }
        return null;
    }
}
