package com.sap.tc.moin.ocl.utils.jmi;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.EnumerationType;
import com.sap.tc.moin.repository.mmi.model.EvaluationKind;
import com.sap.tc.moin.repository.mmi.model.MofPackage;
import com.sap.tc.moin.repository.mmi.model.Operation;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import org.omg.ocl.attaching.OclConstraint;
import org.omg.ocl.expressions.AttributeCallExp;
import org.omg.ocl.expressions.BooleanLiteralExp;
import org.omg.ocl.expressions.CollectionItem;
import org.omg.ocl.expressions.CollectionLiteralExp;
import org.omg.ocl.expressions.CollectionLiteralPart;
import org.omg.ocl.expressions.CollectionRange;
import org.omg.ocl.expressions.EnumLiteralExp;
import org.omg.ocl.expressions.IfExp;
import org.omg.ocl.expressions.IntegerLiteralExp;
import org.omg.ocl.expressions.IterateExp;
import org.omg.ocl.expressions.IteratorExp;
import org.omg.ocl.expressions.LetExp;
import org.omg.ocl.expressions.OclExpression;
import org.omg.ocl.expressions.OperationCallExp;
import org.omg.ocl.expressions.RealLiteralExp;
import org.omg.ocl.expressions.StringLiteralExp;
import org.omg.ocl.expressions.TupleLiteralExp;
import org.omg.ocl.expressions.TypeExp;
import org.omg.ocl.expressions.VariableDeclaration;
import org.omg.ocl.expressions.VariableExp;
import org.omg.ocl.types.BagType;
import org.omg.ocl.types.CollectionType;
import org.omg.ocl.types.OrderedSetType;
import org.omg.ocl.types.SequenceType;
import org.omg.ocl.types.SetType;
import org.omg.ocl.types.TupleType;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreSession;
import com.sap.tc.moin.repository.mmi.descriptors.PackageDescriptor;
import com.sap.tc.moin.repository.ocl.notification.OclManagerException;

/**
 * This is the interface used primarily by the parser to create the syntax trees
 * and by impact analysis to create the reverse navigation paths
 * <p>
 * Depending on the use case (metamodel constraint management, impact analysis,
 * OCL services), the underlying implementation may differ with respect to
 * handling of JMI objects.
 * 
 * @author d022737
 */

public interface MoinJmiCreator {

    /**
     * @return the current connection
     */
    public CoreConnection getConnection( );


    /**
     * @return the {@link CoreSession}
     */
    public CoreSession getSession( );

    /**
     * @param <T> type
     * @param packageDescriptor descriptor
     * @return the package
     */
    public <T extends RefPackage> T getPackage( PackageDescriptor<T> packageDescriptor );

    /**
     * Finds a package by it's qualified name
     * 
     * @param pkgName package name
     * @return the package, or null
     */
    public RefPackage findPackage( String[] pkgName );

    /**
     * Primitive type classifer: Integer
     * 
     * @return the Integer classifier
     */
    public Classifier getIntClass( );

    /**
     * Primitive type classifer: Long
     * 
     * @return the Long classifier
     */
    public Classifier getLongClass( );

    /**
     * Primitive type classifer: Double
     * 
     * @return the Double classifier
     */
    public Classifier getDoubleClass( );

    /**
     * Primitive type classifer: Boolean
     * 
     * @return the Boolean classifier
     */
    public Classifier getBoolClass( );

    /**
     * Primitive type classifer: Real
     * 
     * @return the Real classifier
     */
    public Classifier getFloatClass( );

    /**
     * Primitive type classifer: String
     * 
     * @return the String classifier
     */
    public Classifier getStringClass( );

    /**
     * Type classifer: Any
     * 
     * @return the Any classifier
     */
    public Classifier getAnyClass( );

    /**
     * Create a Bag of a given type
     * 
     * @param elementType the type for the Bag
     * @return the Bag
     */
    public BagType createBagType( Classifier elementType );

    /**
     * Creates a Boolean Literal Expression from a String
     * 
     * @param literal the literal
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public BooleanLiteralExp createBooleanLiteralExp( String literal ) throws OclSemanticException;

    /**
     * This is here mainly for convenience
     * 
     * @param name the name
     * @param annotation the annotation (long text), may be empty
     * @param expression the OCL expression as String representation
     * @param evaluationPolicy the evaluation policy (immediate or deferred)
     * @return the newly created OCL constraint
     */
    public OclConstraint createOclConstraint( String name, String annotation, String expression, EvaluationKind evaluationPolicy );

    /**
     * @return the invalid classifier
     */
    public Classifier getOclInvalidClass( );

    /**
     * Type classifer: null (OclVoid)
     * 
     * @return the null classifier
     */
    public Classifier getOclVoidClass( );

    /**
     * The "OclUndefined" instance of the OclUndefined classifier
     * 
     * @throws OclSemanticException Exception
     * @return the Undefined variable
     */
    public VariableDeclaration getOclInvalidVariable( ) throws OclSemanticException;

    /**
     * The "null" instance of the OclVoid classifier
     * 
     * @throws OclSemanticException Exception
     * @return the Undefined variable
     */
    public VariableDeclaration getOclNullVariable( ) throws OclSemanticException;

    /**
     * Type classifer: Type
     * 
     * @return the Type classifier
     */
    public Classifier getOclTypeClass( );

    /**
     * Create a Set of a given type
     * 
     * @param elementType the type for the Set
     * @return the Set
     */
    public SetType createSetType( Classifier elementType );

    /**
     * Create a OrderedSet of a given type
     * 
     * @param elementType the type for the OrderedSet
     * @return the OrderedSet
     */
    public OrderedSetType createOrderedSetType( Classifier elementType );

    /**
     * Create a Sequence of a given type
     * 
     * @param elementType the type for the Sequence
     * @return the Sequence
     */
    public SequenceType createSequenceType( Classifier elementType );

    /**
     * Creates a String Literal Expression from a String
     * 
     * @param literal literal
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public StringLiteralExp createStringLiteralExp( String literal ) throws OclSemanticException;

    /**
     * Creates a Real Literal Expression from a String
     * 
     * @param literal literal
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public RealLiteralExp createRealLiteralExp( String literal ) throws OclSemanticException;

    /**
     * Creates an Integer Literal Expression from a String
     * 
     * @param literal literal
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public IntegerLiteralExp createIntegerLiteralExp( String literal ) throws OclSemanticException;

    /**
     * Creates a Tuple Literal Expression
     * 
     * @param content content
     * @param name the name for the TupleType
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public TupleLiteralExp createTupleLiteralExp( List<VariableDeclaration> content, String name ) throws OclSemanticException;

    /**
     * Creates an Enumeration Literal Expressions
     * 
     * @param type the type for the Enumeration
     * @param literal literal
     * @return the Expression
     * @throws OclSemanticException literal
     */
    public EnumLiteralExp createEnumLiteralExp( EnumerationType type, String literal ) throws OclSemanticException;

    /**
     * Creates a Collection Literal Expressions
     * 
     * @param type the type for the Enumeration
     * @param content content
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public CollectionLiteralExp createCollectionLiteralExp( CollectionType type, List<CollectionLiteralPart> content ) throws OclSemanticException;

    /**
     * Creates a variable declaration
     * 
     * @param varName the name of the variable
     * @param type the type of the variable
     * @param initExp the initializing expression, may be null
     * @return the new variable
     * @throws OclSemanticException Exception
     */
    public VariableDeclaration createVariableDeclaration( String varName, Classifier type, OclExpression initExp ) throws OclSemanticException;

    /**
     * Creates a Variable Expression from a Variable declaration
     * 
     * @param varDecl {@link VariableDeclaration}
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public VariableExp createVariableExp( VariableDeclaration varDecl ) throws OclSemanticException;

    /**
     * Creates a Type Expression from a Type
     * 
     * @param refType the type
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public TypeExp createTypeExp( Classifier refType ) throws OclSemanticException;

    /**
     * Create an AssociationCallExpExt from an OclExpression
     * 
     * @param source {@link OclExpression}
     * @param assocEnd {@link AssociationEnd}
     * @param withAtPre <code>true</code> if @pre should be generated
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public OclExpression createAssociationCallExpExt( OclExpression source, AssociationEnd assocEnd, boolean withAtPre ) throws OclSemanticException;

    /**
     * Create a Precondition Expression
     * 
     * @param source {@link OclExpression}
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public OclExpression createAtPre( OclExpression source ) throws OclSemanticException;

    /**
     * Gets the return type of an operation
     * 
     * @param operation {@link Operation}
     * @return the type if the return parameter is unique, else a Tuple
     * @throws OclSemanticException Exception
     */
    public Classifier getReturnType( Operation operation ) throws OclSemanticException;

    /**
     * Creates a helper operation (one that is not part of the meta model)
     * 
     * @param owner the container of the operation
     * @param operationName the name
     * @param parameters the input parameters
     * @param returnParameter the return parameter
     * @return the newly created operation
     * @throws OclSemanticException if a semantic error occurs
     */
    public Operation createHelperOperation( RefObject owner, String operationName, List<Parameter> parameters, Parameter returnParameter ) throws OclSemanticException;

    /**
     * Attaches the body to the helper operation
     * 
     * @param bodyExpression {@link OclExpression}
     * @param o {@link Operation}
     */
    public void addBodyToHelper( OclExpression bodyExpression, Operation o );

    /**
     * Change the type of a variable declaration
     * 
     * @param varDec {@link VariableDeclaration}
     * @param newType {@link Classifier}
     */
    public void changeType( VariableDeclaration varDec, Classifier newType );

    /**
     * Change the inExpression of a LetExpression
     * 
     * @param let {@link LetExp}
     * @param in {@link OclExpression}
     */
    public void changeIn( LetExp let, OclExpression in );

    /**
     * Change the type of an OCL Expression
     * 
     * @param varDec {@link OclExpression}
     * @param newType {@link Classifier}
     */
    public void changeType( OclExpression varDec, Classifier newType );

    /**
     * Gets a standard library operation identified by type and operation names
     * 
     * @param typeName the (unqualified) name of the type
     * @param operationName the name of the operation
     * @return the standard library operation
     * @throws OclSemanticException if the operation or the type can not be
     * found
     */
    public Operation getStdLibraryOperation( String typeName, String operationName ) throws OclSemanticException;

    /**
     * Creates an OperationCallExpression
     * 
     * @param op the operation
     * @param source the source
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public OperationCallExp createOperationCallExp( Operation op, OclExpression source ) throws OclSemanticException;

    /**
     * Creates an OperationCallExpression
     * 
     * @param op the operation
     * @param source the source
     * @param arguments the list of arguments (may be emtpy)
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public OperationCallExp createOperationCallExp( Operation op, OclExpression source, List<OclExpression> arguments ) throws OclSemanticException;

    /**
     * Creates an OperationCallExpression
     * 
     * @param op the operation
     * @param source the source
     * @param arg the argument
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public OperationCallExp createOperationCallExp( Operation op, OclExpression source, OclExpression arg ) throws OclSemanticException;

    /**
     * Creates an AttributeCallExpressionExp
     * 
     * @param source {@link OclExpression}
     * @param attribute {@link Attribute}
     * @param withAtPre <code>true</code> if @pre should be generated
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public OclExpression createAttributeCallExpExt( OclExpression source, Attribute attribute, boolean withAtPre ) throws OclSemanticException;

    /**
     * Creates an AttributeCallExpression
     * 
     * @param source {@link OclExpression}
     * @param attribute {@link Attribute}
     * @param withAtPre <code>true</code> if @pre should be generated
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public AttributeCallExp createAttributeCallExp( OclExpression source, Attribute attribute, boolean withAtPre ) throws OclSemanticException;

    /**
     * Creates an Attribute of a given type
     * 
     * @param name name
     * @param type {@link Classifier}
     * @return the Attribute
     * @throws OclSemanticException Exception
     */
    public Attribute createAttribute( String name, Classifier type ) throws OclSemanticException;

    /**
     * Create a Tuple Type
     * 
     * @param vardecls variable declarations
     * @param tupleName the name of the TupleType
     * @return the TupleType
     * @throws OclSemanticException Exception
     */
    public TupleType createTupleType( List<VariableDeclaration> vardecls, String tupleName ) throws OclSemanticException;

    /**
     * Creates a Collection Item
     * 
     * @param itemExp {@link OclExpression}
     * @return the Collection Item
     * @throws OclSemanticException Exception
     */
    public CollectionItem createCollectionItem( OclExpression itemExp ) throws OclSemanticException;

    /**
     * Creates a Return parameter
     * 
     * @param paramName parameter name
     * @param type {@link Classifier}
     * @return the Parameter
     */
    public Parameter createReturnParameter( String paramName, Classifier type );

    /**
     * Creates an input Parameter
     * 
     * @param paramName parameter name
     * @param type {@link Classifier}
     * @return the Parameter
     */
    public Parameter createInParameter( String paramName, Classifier type );

    //    /**
    //     * Creates a LetExpression
    //     * 
    //     * @param varDecl
    //     * @return the LetExprssion
    //     */
    //    public LetExp createLetExp(VariableDeclaration varDecl);

    /**
     * Creates in IteratorExpression
     * 
     * @param opName operation name
     * @param source {@link OclExpression}
     * @param iter1 {@link VariableDeclaration}
     * @param iter2 {@link VariableDeclaration}
     * @param body {@link OclExpression}
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public IteratorExp createIteratorExp( String opName, OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, OclExpression body ) throws OclSemanticException;

    /**
     * Creates an Iterate Expression
     * 
     * @param source {@link OclExpression}
     * @param iter1 {@link VariableDeclaration}
     * @param iter2 {@link VariableDeclaration}
     * @param accu {@link VariableDeclaration}
     * @param body {@link OclExpression}
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public IterateExp createIterate( OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, VariableDeclaration accu, OclExpression body ) throws OclSemanticException;

    /**
     * Creates an Iterate Expression
     * 
     * @param opName operation name
     * @param source {@link OclExpression}
     * @param iter1 {@link VariableDeclaration}
     * @param iter2 {@link VariableDeclaration}
     * @param accu {@link VariableDeclaration}
     * @param body {@link OclExpression}
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public IterateExp createIterateExp( String opName, OclExpression source, VariableDeclaration iter1, VariableDeclaration iter2, VariableDeclaration accu, OclExpression body ) throws OclSemanticException;

    /**
     * Creates a Collection Range
     * 
     * @param first {@link OclExpression}
     * @param last {@link OclExpression}
     * @param rangeType {@link Classifier}
     * @return the range
     * @throws OclSemanticException Exception
     */
    public CollectionRange createCollectionRange( OclExpression first, OclExpression last, Classifier rangeType ) throws OclSemanticException;

    /**
     * Creates an If Expression
     * 
     * @param condExp {@link OclExpression}
     * @param thenExp {@link OclExpression}
     * @param elseExp {@link OclExpression}
     * @param type {@link Classifier}
     * @return the expression
     * @throws OclSemanticException Exception
     */
    public IfExp createIfExp( OclExpression condExp, OclExpression thenExp, OclExpression elseExp, Classifier type ) throws OclSemanticException;

    /**
     * Creates a LetExpression
     * 
     * @param expression {@link OclExpression}
     * @param declaration {@link VariableDeclaration}
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public LetExp createLetExp( OclExpression expression, VariableDeclaration declaration ) throws OclSemanticException;

    /**
     * Creates a LetExpression
     * 
     * @param declaration {@link VariableDeclaration}
     * @return the Expression
     * @throws OclSemanticException Exception
     */
    public LetExp createLetExp( VariableDeclaration declaration ) throws OclSemanticException;

    /**
     * Only to be used by the XMI converter
     * 
     * @param createIfNotFound <code>true</code> if the package should be
     * created if it doesn't exist yet
     * @return the MofPackage
     * @throws OclManagerException Exception
     */
    public MofPackage getOrCreatePackageForGeneratedObjects( boolean createIfNotFound ) throws OclManagerException;

}
