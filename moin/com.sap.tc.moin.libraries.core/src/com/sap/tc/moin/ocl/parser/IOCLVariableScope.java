package com.sap.tc.moin.ocl.parser;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;

import org.omg.ocl.expressions.VariableDeclaration;

/**
 * The variable scope
 */
public interface IOCLVariableScope {

    /**
     * Declares a variable in this scope
     * 
     * @param varDecl the variable to be declared
     */
    void declareVariable( VariableDeclaration varDecl );

    /**
     * Looks up the variable defined by <code>varName</code>
     * 
     * @param varName the name of the variable
     * @return the <code>VariableDeclaration</code> or <code>null</code>
     */
    VariableDeclaration lookupVarByName( String varName );

    /**
     * Looks up an Attribute owned by a variable on the stack.
     * 
     * @param name the name of the Attribute to look up.
     * @return the Attribute or <tt>null</tt> if no such Attribute could be
     * found
     */
    Attribute lookupImplicitAttribute( String name );

    /**
     * Looks up an AssociationEnd owned by a variable on the stack.
     * 
     * @param name the name of the AssociationEnd or Reference
     * @return the AssociationEnd or <tt>null</tt> if no such AssociationEnd
     * could be found.
     */
    AssociationEnd lookupImplicitAssociationEnd( String name );

    /**
     * Finds the VariableDeclaration which can be used to access the implicit
     * AssociationEnd with name name. It always returns the first
     * VariableDeclaration it finds (i.e. the one which has been defined at
     * last).
     * 
     * @param name the name of the attribute
     * @return the VariableDeclaration or <tt>null</tt> if no
     * VariableDeclaration could be found.
     */
    VariableDeclaration findImplicitSourceForAssociation( String name );

    /**
     * Finds the VariableDeclaration which can be used to access the implicit
     * Attribute with name name. It always returns the first VariableDeclaration
     * it finds (i.e. the one which has been defined at last).
     * 
     * @param name the name of the attribute
     * @return the VariableDeclaration or <tt>null</tt> if no
     * VariableDeclaration could be found.
     */
    VariableDeclaration findImplicitSourceForAttr( String name );

    /**
     * Finds the VariableDeclaration which can be used to access the implicit
     * Operation with name opName and arguments args. It always returns the
     * first VariableDeclaration it finds (i.e. the one which has been defined
     * at last).
     * 
     * @param opName the name of the operation
     * @param args the arguments of the operation
     * @param lookupTables the lookup tables
     * @param oclTypeChecker the type checker
     * @return the VariableDeclaration or null if no VariableDeclaration could
     * be found.
     */
    VariableDeclaration findImplicitSourceForOp( String opName, List<Classifier> args, IOCLLookupTables lookupTables, IOCLTypeChecker oclTypeChecker );

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
     * @return a "suitable" VariableDeclaration or <tt>null</tt>
     */
    VariableDeclaration findImplicitSourceForQualifiedAssociation( AssociationEnd end, IOCLTypeChecker oclTypeChecker );

}