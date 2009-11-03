package com.sap.tc.moin.ocl.parser;

import java.util.List;
import java.util.Set;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.ModelElement;
import com.sap.tc.moin.repository.mmi.model.Operation;

import com.sap.tc.moin.ocl.utils.jmi.OclSemanticException;

/**
 * The lookup interface
 */
public interface IOCLLookupTables {

    /**
     * Defines an operation on a Classifier without attaching in it terms of
     * MOF.
     * <p>
     * The definition is not persisted and will be gone after this parser run.
     * 
     * @param owner The owner of the user-defined operation
     * @param userDefOp the user-defined operation
     */
    void defineUserDefOperation( Classifier owner, Operation userDefOp );

    /**
     * User-defined operations are transient, they are gone when the environment
     * is destroyed
     * 
     * @param owner the owner of the user-defined operation
     * @param opName the name of the operation to lookup
     * @param args the list of argument types
     * @param oclTypeChecker the type checker
     * @return the operation identified by name opName or null if no such
     * operation was found.
     */
    Operation lookupUserDefOperation( Classifier owner, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker );

    /**
     * Looks up a feature (i.e. Attribute, AssociationEnd) on a type. First it
     * looks for Attribute, then for References and at last for AssociationEnds.
     * 
     * @param type type to lookup things
     * @param name name fo the feature
     * @return the Attribute or AssociationEnd
     * @throws OclSemanticException if no such feature has been found or
     * <tt>name</tt> identifies more than one <tt>AssociationEnd</tt>
     */
    ModelElement lookupFeature( Classifier type, String name ) throws OclSemanticException;

    /**
     * Looks up a feature (i.e. Attribute, AssociationEnd) on a type. First it
     * looks for Attribute, then for References and at last for AssociationEnds.
     * 
     * @param type type to lookup things
     * @param name name fo the feature
     * @return the Attribute or AssociationEnd if found, null otherwise
     * @throws OclSemanticException if <tt>name</tt> identifies more than one
     * <tt>AssociationEnd</tt>
     */
    ModelElement lookupOptFeature( Classifier type, String name ) throws OclSemanticException;

    /**
     * Looks up a feature (i.e. Attribute, AssociationEnd) on a type. First it
     * looks for Attribute, then for References and at last for AssociationEnds.
     * 
     * @param type type to lookup things
     * @param name name fo the feature
     * @return a collection of features: it is empty if no features were found,
     * and has more than one element if there are ambiguities
     */
    Set<ModelElement> lookupFeatureByName( Classifier type, String name );

    /**
     * Looks up an operation with name <code>opName</code> defined on type
     * <code>type</code>. It returns null if the operation cannot be found!
     * 
     * @param pType the classifier
     * @param opName the operation name
     * @param args the arguments
     * @param oclTypeChecker the type checker
     * @return the operation, or null
     */
    Operation lookupOperation( Classifier pType, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker );

    /**
     * Similar to
     * {@link #lookupOperation(Classifier, String, List, IOCLTypeChecker)} but
     * with the possibility to provide a more dedicated error message and
     * warning message (warning in position 0 and error in position 1)
     * 
     * @param pType the classifier
     * @param opName the operation name
     * @param args the arguments
     * @param oclTypeChecker the type checker
     * @param messages the messages
     * @return the operation, or null
     */
    Operation lookupOperation( Classifier pType, String opName, List<Classifier> args, IOCLTypeChecker oclTypeChecker, OclSemanticException[] messages );

}