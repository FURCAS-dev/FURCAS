package com.sap.tc.moin.ocl.parser;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.MultiplicityType;
import com.sap.tc.moin.repository.mmi.model.Operation;

/**
 * The type checker
 */
public interface IOCLTypeChecker {

    /**
     * Creates a OCL type for a type and a multiplicity. MOF uses
     * <tt>MultiplicityType</tt> to specify whether an parameter, attribute, ...
     * is in fact a Collection. This method returns a proper COL type in respect
     * of the multiplicity which can be a subClass of <tt>CollectionType</tt> or
     * another <tt>Classifier</tt>.
     * 
     * @param mt the multiplicity
     * @param type the type
     * @return a subclass of <tt>CollectionType</tt> or another
     * <tt>Classifier</tt>
     */
    Classifier createOclType( MultiplicityType mt, Classifier type );

    /**
     * Checks whether parsed argument list conforms to arguments of operation.
     * Conformance means type conformance here.
     * 
     * @param op The operation to be checked
     * @param args The list of arguments parsed from the OCL expression
     * @return true if args conform to the arguments defined for op
     */
    boolean argumentsConform( Operation op, List<Classifier> args );

    /**
     * Checks whether the arguments in the two lists match.
     * 
     * @param definedArgs
     * @param providedArgs
     * @return true or false
     */
    boolean argumentsMatch( List<Classifier> definedArgs, List<Classifier> providedArgs );

    /**
     * Determines the common supertype of type1 and type2
     * 
     * @param type1
     * @param type2
     * @return the common supertype or <code>oclUndefined</code> if no common
     * supertype exists
     */
    Classifier commonSuperType( Classifier type1, Classifier type2 );

    /**
     * Determines the return type of an operation. If, for some reason, none
     * could be found oclUndefined is returned. If the operation has in/out or
     * out paramters a Tuple is returned with tuple parts matching the names of
     * parameters. The return paramter is named "result" in the tuple.
     * 
     * @param operation
     * @return the return type of the operation or oclUndefined.
     */
    Classifier getReturnType( Operation operation );

    /**
     * Checks whether two classifiers are conformant.
     * <p>
     * The following rules apply: <tt>type1</tt> conforms to <tt>type2</tt> if
     * <ul>
     * <li> <code>type1</code> is a simple type and <code>type2</code> is
     * <code>OclAny</code></li>
     * <li><code>type1</code> are equal <code>type2</code></li>
     * <li><code>type1</code> is subtype of <code>type2</code></li>
     * <li>if <code>type1</code> and <code>type2</code> are collections - the
     * collection types have to be equal and the element types must conform</li>
     * <li>OrderedSet conforms to Set if the element types conform</li>
     * <li>if <code>type1</code> and <code>type2</code> are tuples tuple parts
     * of <code>type1</code> must conform to tuple parts of <code>type2</code>
     * if they have the same name</li>
     * </ul>
     * <b>NOTA BENE:</b> It really checks that <code>type1</code> conforms to
     * <code>type2</code> and not the other way around! E.g.
     * <code>typesConform(Integer, OclAny)</code> returns <code>true</code>, but
     * <code>typesConform(OclAny, Integer)</code> returns <code>false</code>!
     * 
     * @param type1
     * @param type2
     * @return true if type1 conforms to type2
     */
    boolean typesConform( Classifier type1, Classifier type2 );

}