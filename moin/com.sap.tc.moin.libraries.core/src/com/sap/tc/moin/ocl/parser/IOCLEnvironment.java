package com.sap.tc.moin.ocl.parser;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.Constant;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Parameter;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import org.omg.ocl.expressions.VariableDeclaration;

import com.sap.tc.moin.ocl.utils.jmi.MoinJmiCreator;
import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;
import com.sap.tc.moin.repository.ProcessReport;

/**
 * The Parser environment
 */
public interface IOCLEnvironment {

    /**
     * @return the report
     */
    ProcessReport getReport( );

    /**
     * @return the JMI Creator
     */
    MoinJmiCreator getJmiCreator( );

    /**
     * Declares a variable in the current scope
     * 
     * @param varDecl the variable to be declared
     * @throws OclSemanticException
     */
    void declareVariable( VariableDeclaration varDecl ) throws OclSemanticException;

    /**
     * Enters a new, empty variable scope
     */
    void enterNewVariableScope( );

    /**
     * Finds the VariableDeclaration which can be used to access the implicit
     * AssociationEnd with name name. It always returns the first
     * VariableDeclaration it finds (i.e. the one which has been defined most
     * recently).
     * 
     * @param name the name of the AssociationEnd
     * @return the VariableDeclaration or <code>null</code> if no
     * VariableDeclaration could be found.
     */
    VariableDeclaration findImplicitSourceForAssociation( String name );

    /**
     * Finds the VariableDeclaration which can be used to access the implicit
     * Attribute with name <tt>name</tt>. It always returns the first
     * VariableDeclaration it finds (i.e. the one which has been defined most
     * recently).
     * 
     * @param name the name of the attribute
     * @return the VariableDeclaration or <code>null</code> if no
     * VariableDeclaration could be found.
     */
    VariableDeclaration findImplicitSourceForAttr( String name );

    /**
     * Returns the context of current ocl expression. (the default context is
     * none is set)
     * 
     * @return the context of the current OCL expression
     */
    RefObject getContext( );

    /**
     * Leaves the current scope. All variables declared in the current scope are
     * not longer visible. Previous variables, which had been hidden by
     * variables declared in the current scope get visible again.
     */
    void leaveVariableScope( );

    /**
     * Find the implicit source for an qualified AssociationEnd in this scope.
     * When having an qualified AssociationEnd we are not interested in
     * References. We have an AssociationEnd which we want to navigate and we
     * try to find the suitable source for that navigation. The source is
     * suitable if the source's type conforms to the type of the opposite
     * AssociationEnd. We return the first VariableDeclation which is suitable.
     * 
     * @param end the AssociationEnd to navigate
     * @param oclTypeChecker the type checker
     * @return a "suitable" VariableDeclaration
     * @throws OclSemanticException if no implicit source can be found
     */
    VariableDeclaration findImplicitSourceForQualifiedAssociationEnd( AssociationEnd end, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException;

    /**
     * Looks up an AssociationEnd owned by a variable on the stack.
     * 
     * @param name the name of the AssociationEnd
     * @return the AssociationEnd or <code>null</code> if not found
     */
    AssociationEnd lookupImplicitAssociationEnd( String name );

    /**
     * Looks up an Attribute owned by a variable on the stack.
     * 
     * @param name the name of the Attribute to look up.
     * @return the Attribute or <code>null</code> if not found
     */
    Attribute lookupImplicitAttribute( String name );

    /**
     * deletes all variable declarations.
     * 
     * @throws OclSemanticException
     */
    void reset( ) throws OclSemanticException;

    /**
     * Sets the current context. If a context has been supplied to the parser
     * <tt>context</tt> must match it, otherwise an Exception will be thrown.
     * 
     * @param theContext The context to set.
     * @throws OclSemanticException if <tt>context</tt> does not match the
     * supplied context.
     */
    void setContext( RefObject theContext ) throws OclSemanticException;

    /**
     * Sets the current package to lookup types. If there have been any Packages
     * supplied to the parser, this package has to match one of the supplied
     * packages. Otherwise an Excpetion will be thrown.
     * 
     * @param name the pathname of the package
     * @throws OclSemanticException is thrown if the package identified by
     * <tt>name</tt> does not match one of the supplied packages.
     */
    void setPackage( List<String> name ) throws OclSemanticException;

    /**
     * @return Returns the defaultContext.
     */
    RefObject getDefaultContext( );

    /**
     * Finds the VariableDeclaration which can be used to access the implicit
     * operation with name opName. It always returns the first
     * VariableDeclaration it finds (i.e. the one which has been defined at
     * last).
     * 
     * @param opName the name of the operation
     * @param args the arguments of the operation
     * @param oclLookupTables the type checker
     * @param oclTypeChecker the type checker
     * @return the VariableDeclaration
     * @throws OclSemanticException if no implicit source for this operation has
     * been found
     */
    VariableDeclaration findImplicitSourceForOp( String opName, List<Classifier> args, IOCLLookupTables oclLookupTables, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException;

    /**
     * Finds the VariableDeclaration which can be used to access the implicit
     * operation with name opName. It always returns the first
     * VariableDeclaration it finds (i.e. the one which has been defined at
     * last) or null if none is found at all
     * 
     * @param opName the name of the operation
     * @param args the arguments of the operation
     * @param oclLookupTables the lookpu tables
     * @param oclTypeChecker the type checker
     * @return the VariableDeclaration or null if no such implicit source is
     * found
     */
    VariableDeclaration findOptImplicitSourceForOp( String opName, List<Classifier> args, IOCLLookupTables oclLookupTables, IOCLTypeChecker oclTypeChecker );

    /**
     * Looks up a pathname and returns its type
     * 
     * @param pathName
     * @return the classifier identified by the path name or null if it does not
     * exist
     */
    Classifier lookupClassifierByPathName( List<String> pathName );

    /**
     * Looks up a pathname and returns its constant
     * 
     * @param pathName
     * @return the constant identified by the path name
     */
    Constant lookupConstantByPathName( List<String> pathName );

    /**
     * Looks for the return parameter and returns null if none exists
     * 
     * @param className the fully qualified class name
     * @param opName the operation name
     * @return the return parameter
     */
    Parameter lookupReturnParameter( List<String> className, String opName );

    /**
     * Looks for input parameter of provided name and type. Return null if none
     * found
     * 
     * @param className the fully qualified class name
     * @param opName the operation name
     * @param parName the parameter name
     * @param type the parameter type
     * @return the parameter
     */
    Parameter lookupInParameter( List<String> className, String opName, String parName, Classifier type );

    /**
     * Looks up the variable defined by <code>name</code>
     * 
     * @param name the name of the variable
     * @return the <code>VariableDeclaration</code> or <code>null</code> if
     * not found
     */
    VariableDeclaration lookupVarByName( String name );

    /**
     * Looks up a ModelElement by its qualified name.
     * 
     * @param pathName the qualified name (may be fully qualified)
     * @return the ModelElement identified by the fully qualified name
     * <tt>pathName</tt>
     */
    ModelElement lookupModelElementByPathName( List<String> pathName );

    /**
     * Looks up a qualified AssociationEnd. Use this method if you have an
     * implicit source
     * 
     * @param endName the name of the AssociationEnd
     * @param qualifiedAssocName the fully qualified name of the Association
     * @return the AssociationEnd with name <tt>endName</tt> which belongs to
     * the Association identified by <tt>qualifiedAssocName</tt>
     * @throws OclSemanticException if <tt>qualifiedAssocName</tt> does not
     * identify an Association, <tt>endName</tt> is not a name of an
     * AssociationEnd
     */
    AssociationEnd lookupImplicitQualifiedAssociationEnd( String endName, List<String> qualifiedAssocName ) throws OclSemanticException;

    /**
     * Looks up a qualified AssociationEnd. Use this if you have an explicit
     * source.
     * 
     * @param type from which the AssociationEnd can be navigated
     * @param endName the name of the AssociationEnd
     * @param qualifiedAssocName the fully qualified name of the Association
     * @param oclTypeChecker the type checker
     * @return the AssociationEnd with name <tt>endName</tt> which belongs to
     * the Association identified by <tt>qualifiedAssocName</tt>
     * @throws OclSemanticException if <tt>qualifiedAssocName</tt> does not
     * identify an Association, <tt>endName</tt> is not a name of an
     * AssociationEnd or if <tt>type</tt> does not conform to the type of the
     * opposite end of <tt>endName</tt>.
     */
    AssociationEnd lookupExplicitQualifiedAssociationEnd( Classifier type, String endName, List<String> qualifiedAssocName, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException;

    /**
     * Looks up a qualified AssociationEnd. Use this if you have an explicit
     * source.
     * 
     * @param type from which the AssociationEnd can be navigated
     * @param endName the name of the AssociationEnd
     * @param qualifiedAssocName the fully qualified name of the Association
     * @param oclTypeChecker the type checker
     * @return the AssociationEnd with name <tt>endName</tt> which belongs to
     * the Association identified by <tt>qualifiedAssocName</tt>. Null is
     * returned if endName does not exist on the association
     * @throws OclSemanticException if <tt>qualifiedAssocName</tt> does not
     * identify an Association or if <tt>type</tt> does not conform to the
     * type of the opposite end of <tt>endName</tt>.
     */
    AssociationEnd lookupOptExplicitQualifiedAssociationEnd( Classifier type, String endName, List<String> qualifiedAssocName, IOCLTypeChecker oclTypeChecker ) throws OclSemanticException;

}