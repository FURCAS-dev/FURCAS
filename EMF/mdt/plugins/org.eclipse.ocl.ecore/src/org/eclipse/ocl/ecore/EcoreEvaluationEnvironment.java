/**
 * <copyright>
 *
 * Copyright (c) 2005, 2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   C.Damus - 291365
 *   E.D.Willink - 322159
 *
 * </copyright>
 *
 * $Id: EcoreEvaluationEnvironment.java,v 1.11 2010/08/24 16:17:11 ewillink Exp $
 */

package org.eclipse.ocl.ecore;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.ocl.AbstractEvaluationEnvironment;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.LazyExtentMap;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.internal.OCLEcorePlugin;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;
import org.eclipse.ocl.ecore.internal.OCLStatusCodes;
import org.eclipse.ocl.ecore.internal.UMLReflectionImpl;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.internal.l10n.OCLMessages;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.util.ObjectUtil;
import org.eclipse.ocl.util.Tuple;
import org.eclipse.ocl.util.UnicodeSupport;
import org.eclipse.ocl.utilities.PredefinedType;

import com.google.inject.Injector;

/**
 * Implementation of the {@link EvaluationEnvironment} for evaluation of OCL
 * expressions on instances of Ecore models (i.e., on M0 models).
 * 
 * @author Tim Klinger (tklinger)
 * @author Christian W. Damus (cdamus)
 */
public class EcoreEvaluationEnvironment
		extends
		AbstractEvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject>
		implements EvaluationEnvironment.Enumerations<EEnumLiteral>,
		EvaluationEnvironmentWithHiddenOpposites {

	private boolean mustCheckOperationReflectionConsistency = true;

    private final OppositeEndFinder oppositeEndFinder;

	/**
	 * Initializes me.
	 */
	public EcoreEvaluationEnvironment() {
		super();
		oppositeEndFinder = createOppositeEndFinder();
	}

	private OppositeEndFinder createOppositeEndFinder() {
		OppositeEndFinder.IProvider provider = getInjector().getInstance(OppositeEndFinder.IProvider.class);
		return provider.createOppositeEndFinder(EPackage.Registry.INSTANCE);
	}
	
	/**
	 * Creates the Dependency Injector for this environment using one or more overriding modules.
	 * 
	 * @return the dependency injector
	 * 
	 * @since 3.1
	 */
	protected Injector getInjector() {
		return OCLEcorePlugin.getInjector();
	}

	/**
	 * @since 3.1
	 */
	protected OppositeEndFinder getOppositeEndFinder() {
		return oppositeEndFinder;
	}

	/**
	 * Initializes me with my parent evaluation environment (nesting scope).
	 * 
	 * @param parent
	 *            my parent (nesting scope); must not be <code>null</code>
	 */
	public EcoreEvaluationEnvironment(
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
		super(parent);
		oppositeEndFinder = ((EcoreEvaluationEnvironment) parent).oppositeEndFinder;
	}

	@Override
	public Object callOperation(EOperation operation, int opcode,
			Object source, Object[] args)
			throws IllegalArgumentException {

		// FIXME: Pull up so that UML environment can benefit.
		if (InvocationBehavior.INSTANCE.appliesTo(operation)) {
			EList<Object> arguments = (args.length == 0)
				? ECollections.emptyEList()
				: new BasicEList.UnmodifiableEList<Object>(args.length, args);

			try {
				Object result;
				// Fix for Bug 322159
				Exception checkFailure;
				if (mustCheckOperationReflectionConsistency
					&& ((checkFailure = checkOperationReflectionConsistency(source)) != null)) {				
					EClass operationClass = operation.getEContainingClass();
					EPackage operationPackage = operationClass.getEPackage();
					OCLEcorePlugin
						.warning(
							OCLStatusCodes.USERMODELSUPPORT_NO_OPERATION_REFLECTION,
							OCLMessages.bind(
								OCLMessages.NoOperationReflection_WARNING_,
								operationPackage.getName()
									+ "::" + operationClass.getName()), //$NON-NLS-1$
							checkFailure);
					result = ((EOperation.Internal) operation)
						.getInvocationDelegate().dynamicInvoke(
							(InternalEObject) source, arguments);
				} else {
					result = ((EObject) source).eInvoke(operation, arguments);
				}
				return coerceValue(operation, result, true);
			} catch (InvocationTargetException e) {
				throw new IllegalArgumentException(e);
			}
		}

		// TODO: WBN to pull up createValue to the superclass as a pass-thru
		// so that subclasses don't have to override callOperation
		return coerceValue(operation,
			super.callOperation(operation, opcode, source, args), true);
	}

	// implements the inherited specification
	@Override
	protected Method getJavaMethodFor(EOperation operation, Object receiver) {
		Method result = null;

		// in the case of infix operators, we need to replace the name with
		// a valid Java name. We will choose the legacy OCL parser names
		// which some clients already depend on
		String operName = operation.getName();
		int opcode = OCLStandardLibraryUtil.getOperationCode(operName);
		switch (opcode) {
			case PredefinedType.PLUS :
				operName = "plus"; //$NON-NLS-1$
				break;
			case PredefinedType.MINUS :
				operName = "minus"; //$NON-NLS-1$
				break;
			case PredefinedType.TIMES :
				operName = "times"; //$NON-NLS-1$
				break;
			case PredefinedType.DIVIDE :
				operName = "divide"; //$NON-NLS-1$
				break;
			case PredefinedType.LESS_THAN :
				operName = "lessThan"; //$NON-NLS-1$
				break;
			case PredefinedType.LESS_THAN_EQUAL :
				operName = "lessThanEqual"; //$NON-NLS-1$
				break;
			case PredefinedType.GREATER_THAN :
				operName = "greaterThan"; //$NON-NLS-1$
				break;
			case PredefinedType.GREATER_THAN_EQUAL :
				operName = "greaterThanEqual"; //$NON-NLS-1$
				break;
		}

		// get containing class for the operation
		EClass container = operation.getEContainingClass();

		// get the corresponding java instance class
		Class<?> containerClass = container.getInstanceClass();

		// get the parameter types as java classes
		EList<EParameter> parms = operation.getEParameters();
		Class<?>[] javaParms = new Class[parms.size()];
		for (int i = 0, n = parms.size(); i < n; i++) {
			EParameter parm = parms.get(i);

			if (parm.isMany()) {
				javaParms[i] = EList.class; // TODO: EList could be suppressed
			} else {
				javaParms[i] = parm.getEType().getInstanceClass();
			}
		}

		// lookup the method on the java class
		try {
			result = containerClass.getMethod(operName, javaParms);
		} catch (NoSuchMethodException e) {
			// do nothing
		}

		return result;
	}

	// implements the inherited specification
	@Override
	protected Object getInvalidResult() {
		return OCLStandardLibraryImpl.INVALID;
	}

	// implements the inherited specification
	public Object navigateProperty(EStructuralFeature property,
			List<?> qualifiers, Object target)
			throws IllegalArgumentException {

		if (target instanceof EObject) {
			EObject etarget = (EObject) target;

			if (etarget.eClass().getEAllStructuralFeatures().contains(property)) {
				return coerceValue(property, etarget.eGet(property), true);
			}
		}

		throw new IllegalArgumentException();
	}

	/**
	 * Obtains the collection kind appropriate for representing the values of
	 * the specified typed element.
	 * 
	 * @param element
	 *            a typed element (property, operation, etc.)
	 * 
	 * @return the collection kind appropriate to the multiplicity, orderedness,
	 *         and uniqueness of the element, or <code>null</code> if it is not
	 *         many
	 */
	private static CollectionKind getCollectionKind(ETypedElement element) {
		EClassifier oclType = UMLReflectionImpl.INSTANCE.getOCLType(element);

		CollectionKind result = null;

		if (oclType instanceof CollectionType<?, ?>) {
			result = ((CollectionType<?, ?>) oclType).getKind();
			ObjectUtil.dispose(oclType); // we created this object
		}

		return result;
	}

	/**
	 * Coerces the value of the specified typed element into the appropriate
	 * representation, derived from the supplied <code>value</code> template.
	 * The <code>value</code> is coerced to the appropriate collection kind for
	 * this element (or scalar if not multi-valued). The original value may
	 * either be used as is where possible or, optionally, copied into the new
	 * collection (if multi-valued).
	 * 
	 * @param element
	 *            a typed element (property, operation, etc.)
	 * @param value
	 *            the computed value of the element
	 * @param copy
	 *            whether to copy the specified value into the resulting
	 *            collection/scalar value
	 * 
	 * @return the value, in the appropriate OCL collection type or scalar form
	 *         as required
	 * 
	 * @see #getCollectionKind(ETypedElement)
	 */
	private Object coerceValue(ETypedElement element, Object value, boolean copy) {
		CollectionKind kind = getCollectionKind(element);

		if (kind != null) {
			if (value instanceof Collection<?>) {
				return copy
					? CollectionUtil.createNewCollection(kind,
						(Collection<?>) value)
					: value;
			} else {
				Collection<Object> result = CollectionUtil
					.createNewCollection(kind);
				result.add(value);
				return result;
			}
		} else {
			if (value instanceof Collection<?>) {
				Collection<?> collection = (Collection<?>) value;
				return collection.isEmpty()
					? null
					: collection.iterator().next();
			} else {
				return value;
			}
		}
	}

	// implements the inherited specification
	public Object navigateAssociationClass(EClassifier associationClass,
			EStructuralFeature navigationSource, Object target)
			throws IllegalArgumentException {

		if (target instanceof EObject) {
			EObject etarget = (EObject) target;

			EReference ref = getAssociationClassReference(etarget,
				(EClass) associationClass);

			if (etarget.eClass().getEAllStructuralFeatures().contains(ref)) {
				return etarget.eGet(ref);
			}
		}

		throw new IllegalArgumentException();
	}

	/**
	 * Retrieves the reference feature in the specified context object that
	 * references the specified association class.
	 * 
	 * @param context
	 *            the context object
	 * @param associationClass
	 *            the association class that it references
	 * @return the reference in question
	 */
	private EReference getAssociationClassReference(EObject context,
			EClass associationClass) {
		EReference result = null;

		StringBuffer nameBuf = new StringBuffer(associationClass.getName());
		UnicodeSupport.setCodePointAt(nameBuf, 0,
			UnicodeSupport.toLowerCase(UnicodeSupport.codePointAt(nameBuf, 0)));
		String name = nameBuf.toString();

		for (EReference next : context.eClass().getEAllReferences()) {
			if (name.equals(next.getName())
				&& (associationClass == next.getEReferenceType())) {
				result = next;
				break;
			}
		}

		return result;
	}

	// implements the inherited specification
	public Tuple<EOperation, EStructuralFeature> createTuple(EClassifier type,
			Map<EStructuralFeature, Object> values) {

		EClass tupleType = (EClass) type;

		EObject tuple = tupleType.getEPackage().getEFactoryInstance()
			.create(tupleType);

		for (Map.Entry<EStructuralFeature, Object> entry : values.entrySet()) {
			EStructuralFeature property = entry.getKey();
			Object value = entry.getValue();

			if (property.isMany() && (value instanceof Collection<?>)) {
				@SuppressWarnings("unchecked")
				Collection<Object> coll = (Collection<Object>) tuple
					.eGet(property);
				coll.addAll((Collection<?>) value);
			} else if ((property.getEType() instanceof CollectionType<?, ?>)
				&& (value instanceof Collection<?>)) {
				// always copy the collection to the correct type
				@SuppressWarnings("unchecked")
				CollectionType<EClassifier, EOperation> collType = (CollectionType<EClassifier, EOperation>) property
					.getEType();
				tuple.eSet(property, CollectionUtil.createNewCollection(
					collType.getKind(), (Collection<?>) value));
			} else {
				tuple.eSet(property, value);
			}
		}

		@SuppressWarnings("unchecked")
		Tuple<EOperation, EStructuralFeature> result = (Tuple<EOperation, EStructuralFeature>) tuple;

		return result;
	}

	// implements the inherited specification
	public Map<EClass, Set<EObject>> createExtentMap(Object object) {
		if (object instanceof EObject) {
			return new LazyExtentMap<EClass, EObject>((EObject) object) {

				// implements the inherited specification
				@Override
				protected boolean isInstance(EClass cls, EObject element) {
					return cls.isInstance(element);
				}
			};
		}

		return Collections.emptyMap();
	}

    // implements the inherited specification
	public boolean isKindOf(Object object, EClassifier classifier) {
		// special case for Integer/UnlimitedNatural and Real which
		// are not related types in java but are in OCL
		if ((object.getClass() == Integer.class)
			&& (classifier.getInstanceClass() == Double.class)) {
			return Boolean.TRUE;
		}

		return classifier.isInstance(object);
	}

	// implements the inherited specification
	public boolean isTypeOf(Object object, EClassifier classifier) {
		if (classifier instanceof EClass && object instanceof EObject) {
			return ((EObject) object).eClass() == classifier;
		} else if (!(object instanceof EObject)
			&& !(classifier instanceof EClass)) {
			return object.getClass() == classifier.getInstanceClass();
		}

		return false;
	}

	// implements the inherited specification
	public EClassifier getType(Object object) {
		return EcoreEnvironmentFactory.oclType(object);
	}

	/**
	 * Ecore implementation of the enumeration literal value.
	 * 
	 * @since 1.2
	 */
	public Enumerator getValue(EEnumLiteral enumerationLiteral) {
		return enumerationLiteral.getInstance();
	}

	/**
	 * Configure the check that an incorrect usage of "Operation Reflection"
	 * false in a genmodel has omitted the eInvoke override. Disabling the
	 * check eliminates the overhead of using Java Reflection to perform
	 * run-time code checking but incurs the risk of mysterious evaluation
	 * malfunctions if the genmodel is wrong.
	 * <p>
	 * The check is enabled by default.
	 *
	 * @param checkDisabled true to disable the check
	 * 
	 * @since 3.1
	 */
	public void setOperationReflectionCheckDisabled(boolean checkDisabled) {
		mustCheckOperationReflectionConsistency = !checkDisabled;
	}

	/**
	 * Check if the provided source object has support for a delegated invocation
	 * of an OCL expression body.
	 * <p>
	 * Missing support is the result of a failure to change the default genmodel
	 * 'Operation Reflection' setting to true.
	 * <p>
	 * Lack of support is tested by checking for a missing override of
	 * {@link org.eclipse.emf.ecore.impl.EOperationImpl#eInvoke(int, EList)}.
	 * 
	 * @param source the object to check
	 * 
	 * @since 3.1
	 * @noextend This interface may be removed in future releases if a better
	 * workaround for Bug 322159 is found.
	 */
	protected Exception checkOperationReflectionConsistency(Object source) {

		try {
			source.getClass().getDeclaredMethod(
				"eInvoke", int.class, EList.class); //$NON-NLS-1$
			return null;
		} catch (NoSuchMethodException e) {
			return e;
		} catch (SecurityException e) {
			throw new IllegalArgumentException(e);
		}
	}

	/**
	 * @since 3.1
	 */
	public Object navigateOppositeProperty(EReference property, Object target) throws IllegalArgumentException {
        Object result;
        if (property.isContainment()) {
            EObject resultCandidate = ((EObject) target).eContainer();
            if (resultCandidate == null) {
                result = null;
            } else {
                // first check if the container is assignment-compatible to the property's owning type:
                if (property.getEContainingClass().isInstance(resultCandidate)) {
                    Object propertyValue = resultCandidate.eGet(property);
                    if (propertyValue == target
                            || (propertyValue instanceof Collection<?> && ((Collection<?>) propertyValue).contains(target))) {
                        // important to create a copy because, e.g., the partial evaluator may modify the resulting collection
                        result = CollectionUtil.createNewBag(Collections.singleton(resultCandidate));
                    } else {
                        result = null;
                    }
                } else {
                    result = null;
                }
            }
        } else {
            result = oppositeEndFinder.navigateOppositePropertyWithForwardScope(property, (EObject) target);
        }
        return result;
    }

}