/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: UMLReflection.java,v 1.4 2007/10/15 22:23:12 cdamus Exp $
 */
package org.eclipse.ocl.utilities;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.helper.Choice;


/**
 * An interface providing reflection service for the metaclasses that the
 * OCL borrows from UML.
 * <p>
 * See the {@link Environment} class for a description of the
 * generic type parameters of this interface. 
 * </p>
 * 
 * @author Christian W. Damus (cdamus)
 */
public interface UMLReflection<PK, C, O, P, EL, PM, S, COA, SSA, CT> {

    /**
     * Stereotype applied to classifier invariant constraints.
     * 
     * @see #getStereotype
     */
    String INVARIANT = "invariant"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation precondition constraints.
     * 
     * @see #getStereotype
     */
    String PRECONDITION = "precondition"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation postcondition constraints.
     * 
     * @see #getStereotype
     */
    String POSTCONDITION = "postcondition"; //$NON-NLS-1$

    /**
     * Stereotype applied to operation body conditions.
     * 
     * @see #getStereotype
     */
    String BODY = "body"; //$NON-NLS-1$

    /**
     * Stereotype applied definition expressions.
     * 
     * @see #getStereotype
     */
    String DEFINITION = "definition"; //$NON-NLS-1$

    /**
     * Stereotype applied initial value expressions.
     * 
     * @see #getStereotype
     */
    String INITIAL = "initial"; //$NON-NLS-1$

    /**
     * Stereotype applied derived value expressions.
     * 
     * @see #getStereotype
     */
    String DERIVATION = "derivation"; //$NON-NLS-1$

    /**
     * Stereotype applied to herlp attributes and operations defined by
     * definition constraints.
     */
    String OCL_HELPER = "OclHelper"; //$NON-NLS-1$

    /**
     * Result of {@link #getRelationship} indicating that two classifiers are,
     * in fact, the same type.
     */
    int SAME_TYPE = 1;

    /**
     * Result of {@link #getRelationship} indicating that the first classifier
     * is a strict subtype of the second.
     */
    int STRICT_SUBTYPE = 2;

    /**
     * Mask for testing the result of the {@link #getRelationship} method, to
     * check whether the first classifier is the same type as or a
     * strict subtype of the second.
     */
    int SUBTYPE = SAME_TYPE | STRICT_SUBTYPE;

    /**
     * Result of {@link #getRelationship} indicating that the first classifier
     * is a strict supertype of the second.
     */
    int STRICT_SUPERTYPE = 4;

    /**
     * Mask for testing the result of the {@link #getRelationship} method, to
     * check whether the first classifier is the same type as or a
     * strict supertype of the second.
     */
    int SUPERTYPE = SAME_TYPE | STRICT_SUPERTYPE;

    /**
     * Mask for testing the result of the {@link #getRelationship} method, to
     * check whether the first classifier is related by generalization to the
     * second classifier (being either a supertype or a subtype of it, including
     * possibly the same type).
     */
    int RELATED_TYPE = SAME_TYPE | STRICT_SUBTYPE | STRICT_SUPERTYPE;

    /**
     * Result of {@link #getRelationship} indicating that the first classifier
     * is not related by generalization to the second classifier (being
     * different from it and neither a subtype nor a supertype).
     */
    int UNRELATED_TYPE = 8;
    
    /**
     * Obtains the type of a meta-element (classifier, operation, property,
     * parameter, etc.).  If there is a predefined type provided by OCL (such
     * as Boolean or Set), then it should be returned.  For elements that
     * have multiplicity (properties, parameters, operations), the type that
     * is returned should be an OCL collection type if the element has many
     * multiplicity.
     * 
     * @param metaElement an element of the environment's metamodel
     * 
     * @return its OCL type
     * 
     * @see #isMany(Object)
     */
    C getOCLType(Object metaElement);

    /**
     * Obtains all of the classifiers that generalize the specified classifier.
     * 
     * @param classifier a classifier
     * @return all of its general classifiers, or an empty collection if none
     */
    Collection<? extends C> getAllSupertypes(C classifier);
    
    /**
     * Queries whether the specified meta-element (already known to be a
     * property, parameter, or operation) has multiplicity many.
     * 
     * @param metaElement a property, parameter, or operation
     * @return whether it has many multiplicity
     */
    boolean isMany(Object metaElement);
    
    /**
     * Obtains the OCL type corresponding to the specified type from the
     * environment's type system.  If there is a predefined type provided by
     * OCL (such as Boolean), then it should be returned.  Otherwise,
     * the environment's own type (the original <tt>modelType</tt>) is appropriate.
     * 
     * @param modelType a type in the environment
     * 
     * @return the corresponding OCL pre-defined type, or just <tt>modelType</tt>
     *    if none
     */
    C asOCLType(C modelType);
    
    /**
     * Obtains the parent package (or nearest parent package), if any, of the
     * specified package.
     * 
     * @param pkg a package
     * @return the nearest nesting package, or <code>null</code> if the given
     *     package has no nesting package
     *     
     * @see #getNestedPackages
     */
    PK getNestingPackage(PK pkg);
    
    /**
     * Obtains the packages nested within the specified nesting package, if
     * any.
     * 
     * @param pkg a package
     * @return the nested packages, or an empty list if none
     * 
     * @see #getNestingPackage
     */
    List<PK> getNestedPackages(PK pkg);
    
    /**
     * Obtains the package containing (or nearest package of) the specified
     * classifier.
     * 
     * @param classifier a classifier in the model
     * @return the nearest containing package, or <code>null</code> if there
     *    is none
     */
    PK getPackage(C classifier);
    
    /**
     * Obtains the classifiers contained directly within the specified package.
     * 
     * @param pkg a package in the model
     * @return the classifiers in the package, or an empty list if none
     */
    List<C> getClassifiers(PK pkg);
    
    /**
     * Obtains the classifier that declares the specified feature.
     * 
     * @param feature an operation or property
     * @return the classifier that defines the specified feature (should never
     *     be <code>null</code>)
     */
    C getOwningClassifier(Object feature);
    
    /**
     * Retrieves a list of all signal receptions defined by the specified
     * <code>owner</code> classifier.  This must include also signals
     * defined by supertypes of the owner.  This method is used for content-assist.
     * 
     * @param owner the owner type of the signal receptions
     * 
     * @return the available signals (as {@link EClass}es), or an empty list if none
     */     
    List<C> getSignals(C owner);
    
    /**
     * Creates a new <tt>Operation</tt>.
     * Because OCL can only define query operations, a result type must be
     * provided.  This method is used in parsing the definition of additional
     * operations, and in the construction of the OCL standard library types.
     * <p>
     * <b>Note</b> that the new operation must be a
     * {@linkplain #isQuery(Object) query} operation, as OCL can only define
     * queries.
     * </p>
     * 
     * @param name the name of the new operation (must not be <code>null</code>)
     * @param resultType the result type of the operation (not <code>null</code>)
     * @param paramNames the names of the formal parameters of the operaiton
     *     (may be an empty list if no parameters)
     * @param paramTypes the parameter types, corresponding one-for-one with
     *     the parameter names
     * @return the new operation
     * 
     * @see #isQuery(Object)
     */
    O createOperation(String name, C resultType, List<String> paramNames,
            List<C> paramTypes);
    
    /**
     * Obtains the formal parameters (excluding return parameters) of an
     * operation.
     * 
     * @param operation an operation in the model
     * @return the operation's formal parameters, or an empty list if none
     */
    List<PM> getParameters(O operation);
    
    /**
     * Obtains all of the operations defined by and inherited by the specified
     * classifier.  This method will not be called for the types pre-defined by
     * OCL, as their operations are known by the parser.
     * 
     * @param classifier a classifier in the model
     * @return the operations applicable to the specified classifier, or an
     *    empty list if none
     */
    List<O> getOperations(C classifier);
    
    /**
     * Creates a new <tt>Property</tt>.
     * A type must be provided.  This method is used in parsing the
     * definition of additional properties, and in the construction of the OCL
     * standard library types.
     * 
     * @param name the name of the new property (must not be <code>null</code>)
     * @param resultType the type of the property (not <code>null</code>)
     * @return the new property
     */
    P createProperty(String name, C resultType);
    
    /**
     * Obtains all of the attributes defined by and inherited by the specified
     * classifier.  This method will not be called for the types pre-defined by
     * OCL (such as tuple and message types), as their attributes are known by
     * the parser.
     * 
     * @param classifier a classifier in the model
     * @return the attributes applicable to the specified classifier, or an
     *    empty list if none
     */
    List<P> getAttributes(C classifier);
    
    /**
     * Determines whether the specified <code>operation</code> is a query
     * operation.  Query operations are guaranteed not to alter the system; by
     * the nature of the OCL, all queries defined by OCL are queries.
     * 
     * @param operation an operation
     * @return whether it is a query operation
     */
    boolean isQuery(O operation);
    
    /**
     * Queries whether a property or operation is static (applies to a classifier
     * rather than to its instances).
     * 
     * @param feature an operation or a property
     * @return whether it is static
     */
    boolean isStatic(Object feature);
    
    /**
     * Gets the qualifiers of a property representing a UML association end.
     * 
     * @param property a property of the model class
     * @return the qualifiers (as a list of properties), or an
     *     empty list if the property has no qualifiers
     */
    List<P> getQualifiers(P property);

    /**
     * Determines whether the specified <code>type</code> is an association
     * class.
     * 
     * @param type a classifier in the model
     * @return whether it is an association class
     */
    boolean isAssociationClass(C type);
    
    /**
     * Obtains the association class of which the specified <tt>property</tt>
     * is an end, if any.
     * 
     * @param property a property
     * @return the association class, or <code>null</code> if the property
     *     is not an end of an association class
     */
    C getAssociationClass(P property);
    
    /**
     * Obtains the ends of the specified association class as a list of
     * properties.  This association class was already determined to be such by
     * the {@link #isAssociationClass} method.
     * 
     * @param associationClass a classifier representing an association class
     * @return the properties representing its member ends (the
     *     association roles)
     * 
     * @see #isAssociationClass
     */
    List<P> getMemberEnds(C associationClass);
    
    /**
     * Queries whether the specified model element is an operation.
     * 
     * @param metaElement a model element
     * @return whether it is an operation
     */
    boolean isOperation(Object metaElement);
    
    /**
     * Queries whether the specified model element is a property.
     * 
     * @param metaElement a model element
     * @return whether it is a property
     */
    boolean isProperty(Object metaElement);
    
    /**
     * Queries whether the specified model element is a classifier.
     * 
     * @param metaElement a model element
     * @return whether it is a classifier
     */
    boolean isClassifier(Object metaElement);
    
    /**
     * Queries whether the specified model element is a class.
     * 
     * @param metaElement a model element
     * @return whether it is a class
     */
    boolean isClass(Object metaElement);
    
    /**
     * Queries whether the specified model element is a data type.
     * 
     * @param metaElement a model element
     * @return whether it is a data type
     */
    boolean isDataType(Object metaElement);
    
    /**
     * Queries whether the specified model element is a stereotype.  Note that
     * a metamodel is not required to support stereotypes.
     * 
     * @param type a type in the model
     * @return whether it is a stereotype
     */
    boolean isStereotype(C type);
    
    /**
     * Obtains the application (stereotype instance) of the specified stereotype
     * applied to the given base element, if the stereotype is indeed applied.
     * 
     * @param baseElement a model element
     * @param stereotype a stereotype applied to the element
     * 
     * @return the stereotype instance if the stereotype is applied to it, or
     *     <code>null</code> if the stereotype is not applied
     */
    Object getStereotypeApplication(Object baseElement, C stereotype);
    
    /**
     * Queries whether the specified classifier is an enumeration.
     * 
     * @param type a type in the model
     * @return whether it is an enumeration
     */
    boolean isEnumeration(C type);
    
    /**
     * Obtains the enumeration declaring the specified literal.
     * 
     * @param enumerationLiteral an enumeration literal
     * 
     * @return the literal's declaring enumeration (should not be <code>null</code>)
     */
    C getEnumeration(EL enumerationLiteral);
    
    /**
     * Obtains the literals declared by the specified enumeration type.
     * This type was already determined to be an {@link #isEnumeration enumeration}.
     * 
     * @param enumerationType an enumeration
     * @return its literals, or an empty set if it has none
     */
    List<EL> getEnumerationLiterals(C enumerationType);
    
    /**
     * Obtains the named literal of an enumeration.
     * This type was already determined to be an {@link #isEnumeration enumeration}.
     * 
     * @param enumerationType an enumeration
     * @param literalName the name of a literal
     * @return the matching enumeration literal, or <code>null</code> if the
     *     specified name does not match an existing literal
     */
    EL getEnumerationLiteral(C enumerationType, String literalName);
    
    /**
     * Queries whether the specified type is a comparable (fully ordered)
     * data type.  Instances of a comparable type can be compared using the
     * {@literal <, <=, >, and >=} operations. 
     * 
     * @param type a type in the model
     * @return whether it is comparable
     */
    boolean isComparable(C type);

    /**
     * Creates a <tt>CallOperationAction</tt> referencing the specified
     * operation.
     * 
     * @param operation the operation that is called
     * @return the <tt>CallOperationAction</tt>
     */
    COA createCallOperationAction(O operation);
    
    /**
     * Obtains the called operation referenced by the specified call action.
     * 
     * @param callOperationAction an operation-call action
     * @return the called operation (should not be <code>null</code>)
     */
    O getOperation(COA callOperationAction);

    /**
     * Creates a <tt>SendSignalAction</tt> referencing the specified
     * signal.
     * 
     * @param signal the signal that is send
     * @return the <tt>SendSignalAction</tt>
     */
    SSA createSendSignalAction(C signal);
    
    /**
     * Obtains the sent signal referenced by the specified send action.
     * 
     * @param sendSignalAction a signal-send action
     * @return the sent signal (should not be <code>null</code>)
     */
    C getSignal(SSA sendSignalAction);

    /**
     * Creates a <tt>Constraint</tt>.
     * 
     * @return the new <tt>Constraint</tt>
     */
    CT createConstraint();
    
    /**
     * Obtains the stereotype (one of the constants defined by this interface)
     * that identifies the kind of the specified constraint.
     * 
     * @param constraint a constraint
     * @return its stereotype (should not be <code>null</code>)
     */
    String getStereotype(CT constraint);
    
    /**
     * Sets the stereotype (one of the constants defined by this interface)
     * that identifies the kind of the specified constraint.
     * 
     * @param constraint a constraint
     * @param stereotype its stereotype (must not be <code>null</code>)
     */
    void setStereotype(CT constraint, String stereotype);
    
    /**
     * Obtains the name of a constraint.
     * 
     * @param constraint a constraint
     * @return the constraint name
     */
    String getConstraintName(CT constraint);
    
    /**
     * Sets the name of a constraint.
     * 
     * @param constraint a constraint
     * @param name the constraint name
     */
    void setConstraintName(CT constraint, String name);
    
    /**
     * Creates an <tt>ExpressionInOCL</tt>.
     * 
     * @return the new <tt>ExpressionInOCL</tt>
     */
    ExpressionInOCL<C, PM> createExpressionInOCL();
    
    /**
     * Obtains the specification of a constraint, if it is an
     * <tt>ExpressionInOCL</tt>.
     * 
     * @param constraint a constraint
     * @return its specification as an <tt>ExpressionInOCL</tt>, or <code>null</code>
     *    if it has none or it is not an <tt>ExpressionInOCL</tt>
     */
    ExpressionInOCL<C, PM> getSpecification(CT constraint);
    
    /**
     * Sets the specification of a constraint.
     * 
     * @param constraint a constraint
     * @param specification its specification
     */
    void setSpecification(CT constraint, ExpressionInOCL<C, PM> specification);
    
    /**
     * Obtains the constraint owning the given specification, if any.
     * 
     * @param specification a constraint specification
     * @return the constraint that it specifies, or <code>null</code> if none
     */
    CT getConstraint(ExpressionInOCL<C, PM> specification);
    
    /**
     * Obtains the list of element constraint by a constraint, as a list of
     * {@link EObject}s.  This list is modifiable.
     * 
     * @param constraint a constraint
     * @return its constrained elements
     */
    List<EObject> getConstrainedElements(CT constraint);
    
    /**
     * Obtains the name of an element, if it is a named element.
     * 
     * @param namedElement a named element
     * 
     * @return the named element's name, or <code>null</code> if it is not
     *     a named element
     */
    String getName(Object namedElement);
    
    /**
     * Obtains the qualified name of an element ("::"-separated), if it is a
     * named element.
     * 
     * @param namedElement a named element
     * 
     * @return the named element's qualified name, or <code>null</code> if
     *     it is not a named element
     */
    String getQualifiedName(Object namedElement);
    
    /**
     * Obtains the user-presentable description of an element.
     * For typed elements, this should be the type name and for enumeration
     * literals, the enumeration name.  For other elements,
     * it should be the name (optionally localized) of the metaclass of the
     * element.
     * This description is used in the presentation of content-assist
     * {@link Choice}s.
     * 
     * @param namedElement a named element
     * 
     * @return the named element's description
     */
    String getDescription(Object namedElement);
    
    /**
     * Obtains the least common general classifier of two classifiers, if they
     * have any in common.
     * 
     * @param type1 a classifier in the model
     * @param type2 another classifier in the model
     * 
     * @return the least common supertype, or <code>null</code> if none.
     *    This result (if any) must be a type in the user model; an
     *    implementation must not return <tt>OclAny</tt> in the case that
     *    there is no common supertype
     */
    C getCommonSuperType(C type1, C type2);
    
    /**
     * Obtains the relationship (according to generalization) between two
     * classifiers in the user model.
     * 
     * @param type1 a classifier in the model
     * @param type2 another classifier in the model
     * 
     * @return one of the relationship constants defined by this class
     */
    int getRelationship(C type1, C type2);

    /**
     * Sets the name of the specified typed element.
     * 
     * @param element a typed element
     * @param name the type element's name
     * 
     * @see TypedElement#getName()
     */
    void setName(TypedElement<C> element, String name);
    
    /**
     * Sets the type of the specified typed element.
     * 
     * @param element a typed element
     * @param type the type element's type
     * 
     * @see TypedElement#getType()
     */
    void setType(TypedElement<C> element, C type);
}
