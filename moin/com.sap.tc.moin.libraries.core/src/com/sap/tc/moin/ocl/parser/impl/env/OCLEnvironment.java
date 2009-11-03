package com.sap.tc.moin.ocl.parser.impl.env;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.omg.ocl.expressions.VariableDeclaration;

import com.sap.tc.moin.ocl.parser.IOCLEnvironment;
import com.sap.tc.moin.ocl.parser.IOCLLookupTables;
import com.sap.tc.moin.ocl.parser.IOCLTypeChecker;
import com.sap.tc.moin.ocl.parser.impl.StringHelper;
import com.sap.tc.moin.ocl.parser.impl.errors.FatalParsingException;
import com.sap.tc.moin.ocl.parser.impl.localization.OclParserMessages;
import com.sap.tc.moin.ocl.utils.OclConstants;
import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclHelper;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.ProcessReport;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.JmiList;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.DirectionKindEnum;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.NameNotFoundException;
import com.sap.tc.moin.repository.mmi.model.Namespace;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.model.StructureField;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationEndImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.AssociationImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.MofPackageInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.NamespaceInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;

/**
 * This class keeps track of variable declaration scopes, the current context
 * and the packages to lookup types.
 */
public class OCLEnvironment implements IOCLEnvironment {

    /**
     * the default context, supplied by Parser#parse()
     */
    private final RefObject defaultContext;

    /**
     * packages for looking up types. Supplied by Parser#parse()
     */
    private final RefPackage[] defaultPackages;

    /**
     * The context's package
     */
    private MofPackage contextPackage;

    /**
     * The helper used to instantiate JMI-classes
     */
    private final MoinJmiCreator jmiCreator;

    /**
     * The ParsingReport used to report errors and warning to
     */
    protected ProcessReport report;

    /**
     * this stack keeps track of nested VariableScopes
     */
    protected final Stack<OCLVariableScope> scopeStack = new Stack<OCLVariableScope>( );

    /**
     * This map is provided externally, and maps a simple model element name to
     * the possible model elements
     */
    private final Map<String, List<ModelElement>> modelElementsByName;

    /**
     * This map is provided externally, and maps a path name to its model
     * element
     */
    private final Map<String, ModelElement> modelElementsByOclQualifiedName;

    /**
     * the current VariableScope
     */
    protected OCLVariableScope currentScope;

    /**
     * The current context
     */
    private RefObject context;

    /**
     * The current type package
     */
    private MofPackage mofTypesPackage;

    private RefPackage refTypesPackage;

    /**
     * @param theReport The ParsingReport to report errors and warnings to
     * @param theJmiCreator the JMICreator for creating JMI objects.
     * @param theDefaultContext if null, the context is determined by the text
     * input to the parser. if not null the text input is only allowed to
     * contain up to one context statement. The referred context in that
     * statement has to match the defaultContext.
     * @param actContextPackage the context package
     * @param theDefaultPackages if empty, the package is determined by the text
     * input to the parser. if not empty the text input is only allowed to
     * contain up to one package statement. The referred package in that
     * statement has to match one of the defaultPackages
     * @param theModelElementsByName the mapping of names to model elements
     * @param theModelElementsByOclQualifiedName the mapping of qualified names
     * to model elements
     */
    public OCLEnvironment( ProcessReport theReport, MoinJmiCreator theJmiCreator, RefObject theDefaultContext, MofPackage actContextPackage, Set<RefPackage> theDefaultPackages, Map<String, List<ModelElement>> theModelElementsByName, Map<String, ModelElement> theModelElementsByOclQualifiedName ) {

        this.modelElementsByName = theModelElementsByName;
        this.modelElementsByOclQualifiedName = theModelElementsByOclQualifiedName;
        this.report = theReport;
        this.jmiCreator = theJmiCreator;
        this.defaultContext = theDefaultContext;
        this.context = theDefaultContext;
        this.contextPackage = actContextPackage;

        // check the context
        if ( this.context != null && !( this.context instanceof Classifier || this.context instanceof Operation || this.context instanceof Attribute ) ) {
            // if the context is not an instance of Classifier, Operation or Attribute, check if its meta-object
            // is an instance of classifier (and set the context to the meta-object!)
            this.context = this.context.refMetaObject( );
            if ( !( this.context instanceof Classifier ) ) {
                // the meta-object however has to be a Classifier
                OclSemanticException ex = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1000 );
                ProcessError error = new ProcessErrorImpl( ex );
                theReport.reportFatalError( error );
                throw new FatalParsingException( ex, error );
            }
        }

        // If no default package is given and no classifier tables are given, we have a problem
        if ( theDefaultPackages.isEmpty( ) && theModelElementsByName.isEmpty( ) && theModelElementsByOclQualifiedName.isEmpty( ) ) {
            OclSemanticException ex = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0506 );
            ProcessError error = new ProcessErrorImpl( ex );
            theReport.reportFatalError( error );
            throw new FatalParsingException( ex, error );
        }

        // if default packages are provided, set them
        if ( theDefaultPackages.size( ) > 0 ) {
            this.defaultPackages = new RefPackage[theDefaultPackages.size( )];
            theDefaultPackages.toArray( this.defaultPackages );
        } else {
            this.defaultPackages = new RefPackage[0];
        }

        // set the current context package
        if ( this.context != null && this.contextPackage == null ) {
            RefFeatured parent = ( (RefObjectImpl) this.context ).refImmediateComposite( this.jmiCreator.getSession( ) );
            while ( parent != null ) {
                if ( parent instanceof MofPackage ) {
                    this.contextPackage = (MofPackage) parent;
                    break;
                }
                if ( parent instanceof RefObject ) {
                    parent = ( (RefObjectImpl) parent ).refImmediateComposite( this.jmiCreator.getSession( ) );
                } else {
                    parent = null;
                }
            }
        }

        // we need to set the invalid variable
        try {
            defineOclInvalidVariable( );
        } catch ( OclSemanticException e ) {
            ProcessError error = new ProcessErrorImpl( e );
            theReport.reportFatalError( error );
            throw new FatalParsingException( e, error );
        }

        // we need to set the null variable
        try {
            defineOclNullVariable( );
        } catch ( OclSemanticException e ) {
            ProcessError error = new ProcessErrorImpl( e );
            theReport.reportFatalError( error );
            throw new FatalParsingException( e, error );
        }
    }

    /**
     * Defines OclUndefined as a variable in a new VariableScope.
     */
    private void defineOclInvalidVariable( ) throws OclSemanticException {

        this.enterNewVariableScope( );
        VariableDeclaration oclUndefinedDecl = this.jmiCreator.getOclInvalidVariable( );
        this.declareVariable( oclUndefinedDecl );
    }

    /**
     * Defines OclUndefined as a variable in a new VariableScope.
     */
    private void defineOclNullVariable( ) throws OclSemanticException {

        this.enterNewVariableScope( );
        VariableDeclaration oclUndefinedDecl = this.jmiCreator.getOclNullVariable( );
        this.declareVariable( oclUndefinedDecl );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#getReport()
     */
    public ProcessReport getReport( ) {

        return this.report;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#getJmiCreator()
     */
    public MoinJmiCreator getJmiCreator( ) {

        return this.jmiCreator;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#declareVariable(org
     * .omg.ocl.expressions.VariableDeclaration)
     */
    public void declareVariable( VariableDeclaration varDecl ) throws OclSemanticException {

        // check whether a variable with the same name is already defined
        VariableDeclaration prevVarDecl = this.currentScope.lookupVarByName( varDecl.getVarName( ) );
        if ( prevVarDecl != null ) {
            // a variable with this name has already been defined
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0202, new Object[] { varDecl.getVarName( ) } );
        }

        this.currentScope.declareVariable( varDecl );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#enterNewVariableScope
     * ()
     */
    public void enterNewVariableScope( ) {

        this.currentScope = new OCLVariableScope( this.jmiCreator.getConnection( ) );
        this.scopeStack.push( this.currentScope );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * findImplicitSourceForAssociation(java.lang.String)
     */
    public VariableDeclaration findImplicitSourceForAssociation( String name ) {

        for ( int i = this.scopeStack.size( ) - 1; i >= 0; i-- ) {
            // go through the stack from top to bottom
            OCLVariableScope s = this.scopeStack.get( i );
            VariableDeclaration varDecl = s.findImplicitSourceForAssociation( name );
            if ( varDecl != null ) {
                return varDecl;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#findImplicitSourceForAttr
     * (java.lang.String)
     */
    public VariableDeclaration findImplicitSourceForAttr( String name ) {

        for ( int i = this.scopeStack.size( ) - 1; i >= 0; i-- ) {
            // go through the stack from top to bottom
            OCLVariableScope s = this.scopeStack.get( i );
            VariableDeclaration varDecl = s.findImplicitSourceForAttr( name );
            if ( varDecl != null ) {
                return varDecl;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#getContext()
     */
    public RefObject getContext( ) {

        if ( this.context == null ) {
            return this.defaultContext;
        }
        return this.context;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#leaveVariableScope()
     */
    public void leaveVariableScope( ) {

        if ( !this.scopeStack.empty( ) ) {
            this.currentScope = this.scopeStack.pop( );
        } else {
            OclSemanticException ex = new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1005 );
            ProcessError error = new ProcessErrorImpl( ex );
            this.report.reportFatalError( error );
            throw new FatalParsingException( ex, error );
        }
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * findImplicitSourceForQualifiedAssociationEnd
     * (com.sap.tc.moin.repository.mmi.model.AssociationEnd,
     * com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker)
     */
    public VariableDeclaration findImplicitSourceForQualifiedAssociationEnd( AssociationEnd end, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException {

        // go through the stack from top to bottom
        for ( int i = this.scopeStack.size( ) - 1; i >= 0; i-- ) {

            OCLVariableScope s = this.scopeStack.get( i );
            VariableDeclaration varDecl = s.findImplicitSourceForQualifiedAssociation( end, oclTypeChecker );
            if ( varDecl != null ) {
                return varDecl;
            }
        }

        throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1011, new Object[] { StringHelper.toPathName( end.getQualifiedName( ) ) } );
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * lookupImplicitAssociationEnd(java.lang.String)
     */
    public AssociationEnd lookupImplicitAssociationEnd( String name ) {

        for ( int i = this.scopeStack.size( ) - 1; i >= 0; i-- ) {
            // go through the stack from top to bottom
            OCLVariableScope s = this.scopeStack.get( i );
            AssociationEnd a = s.lookupImplicitAssociationEnd( name );
            if ( a != null ) {
                return a;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#lookupImplicitAttribute
     * (java.lang.String)
     */
    public Attribute lookupImplicitAttribute( String name ) {

        for ( int i = this.scopeStack.size( ) - 1; i >= 0; i-- ) {
            // go through the stack from top to bottom
            OCLVariableScope s = this.scopeStack.get( i );
            Attribute a = s.lookupImplicitAttribute( name );
            if ( a != null ) {
                return a;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#reset()
     */
    public void reset( ) throws OclSemanticException {

        this.currentScope = null;
        this.scopeStack.clear( );
        // we have "OclUndefined" as a ubiquitous variable
        // so we make sure it is always there
        defineOclInvalidVariable( );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#setContext(javax.
     * jmi.reflect.RefObject)
     */
    public void setContext( RefObject theContext ) throws OclSemanticException {

        if ( this.defaultContext != null && !this.defaultContext.equals( theContext ) && !this.defaultContext.equals( ( (RefObjectImpl) theContext ).refImmediateComposite( this.jmiCreator.getSession( ) ) ) ) {
            // we also allow child contexts, e.g. attributes or operations if the default context is a class
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0504, new Object[] { theContext, this.defaultContext } );
        }
        this.context = theContext;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#setPackage(java.util
     * .List)
     */
    public void setPackage( List<String> name ) throws OclSemanticException {


        this.mofTypesPackage = null;
        this.refTypesPackage = null;
        RefPackage refPkg;
        // create an array for the name
        String[] nameArr = new String[name.size( )];
        name.toArray( nameArr );

        String oclname = StringHelper.toPathName( name );
        Object pkg = this.modelElementsByOclQualifiedName.get( oclname );
        if ( pkg != null && pkg instanceof MofPackage ) {
            this.mofTypesPackage = (MofPackage) pkg;
            return;
        }


        refPkg = this.jmiCreator.findPackage( nameArr );
        if ( refPkg == null ) {
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0507, new Object[] { StringHelper.toPathName( nameArr ) } );
        }

        // if there are defaultpackages supplied the looked-up
        // package has to match one of the defaultPackages
        if ( this.defaultPackages != null ) {
            // go through all supplied packages and test if they match
            for ( int i = 0; i < this.defaultPackages.length; i++ ) {
                if ( this.defaultPackages[i] == null ) {
                    continue;
                }
                if ( this.defaultPackages[i].equals( refPkg ) ) {
                    this.refTypesPackage = refPkg;
                    // we found a match and are done
                    return;
                }
            }
            if ( this.defaultPackages.length == 0 ) {
                // the array of default packages is empty
                this.refTypesPackage = refPkg;
                return;
            }
            // the package does not match one of the defaultpackage
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_0508, new Object[] { OclConstants.EMPTY, refPkg } );
        }
        this.refTypesPackage = refPkg;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#getDefaultContext()
     */
    public RefObject getDefaultContext( ) {

        return this.defaultContext;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#findImplicitSourceForOp
     * (java.lang.String, java.util.List,
     * com.sap.tc.moin.ocl.parser.impl.env.OCLLookupTables,
     * com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker)
     */
    public VariableDeclaration findImplicitSourceForOp( String opName, List<Classifier> args, IOCLLookupTables oclLookupTables, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException {

        VariableDeclaration result = findOptImplicitSourceForOp( opName, args, oclLookupTables, oclTypeChecker );
        if ( result != null ) {
            return result;
        }
        throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1016, new Object[] { opName, StringHelper.toString( args ) } );

    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.IOCLEnvironment#findOptImplicitSourceForOp
     * (java.lang.String, java.util.List,
     * com.sap.tc.moin.ocl.parser.IOCLLookupTables,
     * com.sap.tc.moin.ocl.parser.IOCLTypeChecker)
     */
    public VariableDeclaration findOptImplicitSourceForOp( String opName, List<Classifier> args, IOCLLookupTables oclLookupTables, IOCLTypeChecker oclTypeChecker ) {

        for ( int i = this.scopeStack.size( ) - 1; i >= 0; i-- ) {
            // go through the stack from top to bottom
            OCLVariableScope s = this.scopeStack.get( i );
            VariableDeclaration varDecl = s.findImplicitSourceForOp( opName, args, oclLookupTables, oclTypeChecker );
            if ( varDecl != null ) {
                return varDecl;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * lookupClassifierByPathName(java.util.List)
     */
    public Classifier lookupClassifierByPathName( List<String> pathName ) {

        if ( pathName.size( ) == 1 ) {
            // lookup a local type
            String localName = pathName.get( 0 );
            if ( localName.equals( OclConstants.T_OCLANY ) ) {
                return this.jmiCreator.getAnyClass( );
            } else if ( localName.equals( OclConstants.T_STRING ) ) {
                return this.jmiCreator.getStringClass( );
            } else if ( localName.equals( OclConstants.T_BOOLEAN ) ) {
                return this.jmiCreator.getBoolClass( );
            } else if ( localName.equals( OclConstants.T_INTEGER ) ) {
                return this.jmiCreator.getIntClass( );
            } else if ( localName.equals( OclConstants.T_FLOAT ) ) {
                return this.jmiCreator.getFloatClass( );
            } else if ( localName.equals( OclConstants.T_LONG ) ) {
                return this.jmiCreator.getLongClass( );
            } else if ( localName.equals( OclConstants.T_DOUBLE ) ) {
                return this.jmiCreator.getDoubleClass( );
            } else if ( localName.equals( OclConstants.T_OCLTYPE ) ) {
                return this.jmiCreator.getOclTypeClass( );
            } else if ( localName.equals( OclConstants.T_OCLVOID ) ) {
                return this.jmiCreator.getOclVoidClass( );
            } else if ( localName.equals( OclConstants.T_OCLINVALID ) ) {
                return this.jmiCreator.getOclInvalidClass( );
            } else if ( localName.equals( OclConstants.T_OCLUNDEFINED ) ) {
                return this.jmiCreator.getOclVoidClass( );
            }
        }

        Classifier foundInContextPackage = null;
        if ( this.contextPackage != null ) {
            // check if the name is relative to the context package
            CoreConnection conn = this.jmiCreator.getConnection( );
            Namespace currentNamespace = this.contextPackage;
            for ( String currentNameComponent : pathName ) {
                if ( foundInContextPackage instanceof EnumerationType ) {
                    // we don't lookup past enumeration types
                    return foundInContextPackage;
                }
                foundInContextPackage = null;

                if ( currentNamespace == null ) {
                    break;
                }
                JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) currentNamespace ).getContents( conn );
                currentNamespace = null;
                for ( int i = 0, n = contents.size( conn.getSession( ) ); i < n; i++ ) {
                    ModelElement contentObject = contents.get( conn.getSession( ), i );
                    String name = contentObject.getName( );
                    if ( name.equals( currentNameComponent ) ) {
                        if ( contentObject instanceof Namespace ) {
                            currentNamespace = (Namespace) contentObject;
                        }
                        if ( contentObject instanceof Classifier ) {
                            foundInContextPackage = (Classifier) contentObject;
                        } else if ( contentObject instanceof StructureField ) {
                            foundInContextPackage = ( (StructureField) contentObject ).getType( );
                        }
                        break;
                    }
                }

            }

            if ( foundInContextPackage != null ) {
                return foundInContextPackage;
            }
        }

        ModelElement found = this.lookupModelElementByPathName( pathName );
        if ( found instanceof Classifier ) {
            return (Classifier) found;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#lookupConstantByPathName
     * (java.util.List)
     */
    public Constant lookupConstantByPathName( List<String> pathName ) {

        Constant foundInContextPackage = null;
        if ( this.contextPackage != null ) {
            // check if the name is relative to the context package
            CoreConnection conn = this.jmiCreator.getConnection( );
            Namespace currentNamespace = this.contextPackage;
            for ( String currentNameComponent : pathName ) {

                if ( currentNamespace == null ) {
                    break;
                }
                foundInContextPackage = null;
                JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) currentNamespace ).getContents( conn );
                for ( int i = 0, n = contents.size( conn.getSession( ) ); i < n; i++ ) {
                    ModelElement contentObject = contents.get( conn.getSession( ), i );
                    String name = contentObject.getName( );
                    if ( name.equals( currentNameComponent ) ) {
                        if ( contentObject instanceof Namespace ) {
                            currentNamespace = (Namespace) contentObject;
                        } else {
                            currentNamespace = null;
                        }
                        if ( contentObject instanceof Constant ) {
                            foundInContextPackage = (Constant) contentObject;
                        }
                        break;
                    }
                }

            }

            if ( foundInContextPackage != null ) {
                return foundInContextPackage;
            }
        }

        ModelElement found = this.lookupModelElementByPathName( pathName );
        if ( found != null && found instanceof Constant ) {
            return (Constant) found;
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#lookupReturnParameter
     * (java.util.List, java.lang.String)
     */
    public Parameter lookupReturnParameter( List<String> className, String opName ) {

        Classifier cls = lookupClassifierByPathName( className );
        if ( cls == null ) {
            return null;
        }
        CoreConnection conn = this.jmiCreator.getConnection( );
        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) cls ).getContents( conn );
        for ( int i = 0, n = contents.size( conn.getSession( ) ); i < n; i++ ) {
            Object feature = contents.get( conn.getSession( ), i );
            if ( feature instanceof Operation && opName.equals( ( (Operation) feature ).getName( ) ) ) {
                JmiList<ModelElement> featureContents = (JmiList<ModelElement>) ( (NamespaceInternal) feature ).getContents( conn );
                for ( int j = 0, o = featureContents.size( conn.getSession( ) ); j < o; j++ ) {
                    Object content = featureContents.get( conn.getSession( ), j );
                    if ( content instanceof Parameter ) {
                        Parameter param = (Parameter) content;
                        if ( param.getDirection( ).equals( DirectionKindEnum.RETURN_DIR ) ) {
                            return param;
                        }
                    }
                }
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#lookupInParameter
     * (java.util.List, java.lang.String, java.lang.String,
     * com.sap.tc.moin.repository.mmi.model.Classifier)
     */
    public Parameter lookupInParameter( List<String> className, String opName, String parName, Classifier type ) {

        Classifier cls = lookupClassifierByPathName( className );

        CoreConnection conn = this.jmiCreator.getConnection( );
        JmiList<ModelElement> contents = (JmiList<ModelElement>) ( (NamespaceInternal) cls ).getContents( conn );
        for ( int i = 0, n = contents.size( conn.getSession( ) ); i < n; i++ ) {
            Object feature = contents.get( conn.getSession( ), i );
            if ( feature instanceof Operation && opName.equals( ( (Operation) feature ).getName( ) ) ) {
                JmiList<ModelElement> featureContents = (JmiList<ModelElement>) ( (NamespaceInternal) feature ).getContents( conn );
                for ( int j = 0, o = featureContents.size( conn.getSession( ) ); j < o; j++ ) {
                    Object content = featureContents.get( conn.getSession( ), j );
                    if ( content instanceof Parameter ) {
                        Parameter param = (Parameter) content;
                        if ( parName.equals( param.getName( ) ) && param.getDirection( ).equals( DirectionKindEnum.IN_DIR ) ) {
                            return param;
                        }
                    }
                }
            }
        }

        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#lookupVarByName(java
     * .lang.String)
     */
    public VariableDeclaration lookupVarByName( String name ) {

        for ( int i = this.scopeStack.size( ) - 1; i >= 0; i-- ) {
            // go through the stack from top to bottom
            OCLVariableScope s = this.scopeStack.get( i );
            VariableDeclaration decl = s.lookupVarByName( name );
            if ( decl != null ) {
                return decl;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * lookupModelElementByPathName(java.util.List)
     */
    public ModelElement lookupModelElementByPathName( List<String> pathName ) {

        // for the result
        ModelElement me = null;
        CoreConnection connection = this.jmiCreator.getConnection( );
        SpiJmiHelper jmiHelper = connection.getCoreJmiHelper( );
        if ( this.refTypesPackage != null ) {
            // If an explicit typesPackage was provided, use it to find the element

            // first redefine the path name
            List<String> fullPathName = OclHelper.qualifiedName(pathName, this.refTypesPackage );

            // go and find the Model Element
            me = jmiHelper.findElementByQualifiedName( connection.getSession( ), fullPathName, this.refTypesPackage.refOutermostPackage( ) );
        } else if ( this.mofTypesPackage != null ) {
            // first redefine the path name
            List<String> fullPathName = qualifiedName( pathName, this.mofTypesPackage );


            // go and find the Model Element
            me = jmiHelper.findElementByQualifiedName( connection.getSession( ), fullPathName, this.mofTypesPackage.refOutermostPackage( ) );
        } else {
            // no package context given. So, lookup types in the supplied context package.
            if ( pathName.size( ) == 1 && this.contextPackage != null ) {
                // the path name is immediate

                try {
                    me = ( (MofPackageInternal) this.contextPackage ).lookupElement( this.jmiCreator.getConnection( ), pathName.get( 0 ) );
                } catch ( NameNotFoundException e ) {
                    // $JL-EXC$ if this does not work, continue
                }
            }

            if ( me == null ) {
                for ( int i = 0; i < this.defaultPackages.length; i++ ) {
                    me = OclHelper.findModelElementRecursive(jmiCreator.getConnection(), pathName, this.defaultPackages[i] );
                    if ( me != null ) {
                        break;
                    }

                }
            }
        }

        // not yet found, use the provided lookup tables to find the element
        if ( me == null && pathName.size( ) == 1 && this.modelElementsByName != null ) {
            List<ModelElement> modelElements = this.modelElementsByName.get( pathName.get( 0 ) );
            // we want to make sure the classifier name is unique
            if ( modelElements != null && modelElements.size( ) == 1 ) {
                me = modelElements.get( 0 );
            }
        }

        // we might have had an ambiguity, so check in the full table
        if ( me == null && pathName.size( ) > 1 && this.modelElementsByOclQualifiedName != null ) {
            StringBuilder oclQualifiedName = new StringBuilder( );
            for ( Iterator<String> it = pathName.iterator( ); it.hasNext( ); ) {
                oclQualifiedName.append( it.next( ) );
                if ( it.hasNext( ) ) {
                    oclQualifiedName.append( OclConstants.PATHSEP );
                }
            }
            me = this.modelElementsByOclQualifiedName.get( oclQualifiedName.toString( ) );

        }

        // let's have a look at the connection (at the risk of having ambiguous package names)
        if ( me == null && pathName.size( ) > 1 ) {

            String[] packageName = new String[pathName.size( ) - 1];
            pathName.subList( 0, pathName.size( ) - 1 ).toArray( packageName );
            // throws an Exception if package name is ambiguous
            RefPackage pkg = connection.getPackage( null, packageName );

            if ( pkg != null ) {
                me = OclHelper.findModelElementRecursive(jmiCreator.getConnection(), pathName, pkg.refOutermostPackage( ) );
            }
        }
        // return result
        return me;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * lookupImplicitQualifiedAssociationEnd(java.lang.String, java.util.List)
     */
    public AssociationEnd lookupImplicitQualifiedAssociationEnd( String endName, List<String> qualifiedAssocName ) throws OclSemanticException {

        Association association = (Association) this.lookupModelElementByPathName( qualifiedAssocName );
        if ( association == null ) {
            // specified Association does not exist
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1009, new Object[] { StringHelper.toPathName( qualifiedAssocName ) } );
        }

        try {
            return (AssociationEnd) association.lookupElement( endName );
        } catch ( NameNotFoundException e2 ) {
            // name does not specify an AssociationEnd
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1010, new Object[] { endName, StringHelper.toPathName( qualifiedAssocName ) } );
        }
    }

    private AssociationEndImpl lookupOptImplicitQualifiedAssociationEnd( String endName, List<String> qualifiedAssocName ) throws OclSemanticException {

        AssociationImpl association = (AssociationImpl) this.lookupModelElementByPathName( qualifiedAssocName );
        if ( association == null ) {
            // specified Association does not exist
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1009, new Object[] { StringHelper.toPathName( qualifiedAssocName ) } );
        }

        try {
            return (AssociationEndImpl) association.lookupElement( this.jmiCreator.getConnection( ), endName );
        } catch ( NameNotFoundException e2 ) {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * lookupExplicitQualifiedAssociationEnd(com.sap.tc.moin.repository.mmi.model.Classifier,
     * java.lang.String, java.util.List,
     * com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker)
     */
    public AssociationEnd lookupExplicitQualifiedAssociationEnd( Classifier type, String endName, List<String> qualifiedAssocName, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException {

        AssociationEnd end = this.lookupImplicitQualifiedAssociationEnd( endName, qualifiedAssocName );

        // the source's type has to conform to the opposite AssociationEnd's type
        if ( !oclTypeChecker.typesConform( type, end.otherEnd( ).getType( ) ) ) {
            // source's type does not conform to the associationEnd's type
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1008, new Object[] { StringHelper.toString( type ), StringHelper.toString( end.otherEnd( ).getType( ) ) } );
        }
        return end;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.ocl.parser.impl.env.IOCLEnvironment#
     * lookupExplicitQualifiedAssociationEnd(com.sap.tc.moin.repository.mmi.model.Classifier,
     * java.lang.String, java.util.List,
     * com.sap.tc.moin.ocl.parser.impl.env.OCLTypeChecker)
     */
    public AssociationEnd lookupOptExplicitQualifiedAssociationEnd( Classifier type, String endName, List<String> qualifiedAssocName, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException {

        AssociationEndImpl end = this.lookupOptImplicitQualifiedAssociationEnd( endName, qualifiedAssocName );
        AssociationEndImpl otherEnd = (AssociationEndImpl) end.otherEnd( this.jmiCreator.getConnection( ) );
        // the source's type has to conform to the opposite AssociationEnd's type
        if (!oclTypeChecker.typesConform( type, otherEnd.getType( this.jmiCreator.getConnection( ) ) ) ) {
            // source's type does not conform to the associationEnd's type
            throw new OclSemanticException( OclParserMessages.MOIN_OCL_PARSER_1008, new Object[] { StringHelper.toString( type ), StringHelper.toString( end.otherEnd( ).getType( ) ) } );
        }
        return end;
    }

    private List<String> qualifiedName( List<String> pathName, MofPackage pkg ) {

        int pathLen = pathName.size( );
        List<String> pkgName = ( (MofPackageImpl) pkg ).getQualifiedName( this.jmiCreator.getConnection( ) );
        int pkgLen = pkgName.size( );
        String pkgLastPart = pkgName.get( pkgLen - 1 );
        List<String> qName = new ArrayList<String>( );
        qName.addAll( pkgName );
        int match;
        for ( match = 0; match < pathLen; match++ ) {
            String s = pathName.get( match );
            if ( pkgLastPart.equals( s ) ) {
                break;
            }
        }
        if ( match == pathLen ) {
            qName.addAll( pathName );
        } else {
            qName.addAll( pathName.subList( match + 1, pathLen ) );
        }
        return qName;
    }
}
