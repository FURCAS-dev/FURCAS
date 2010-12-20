/**
 * <copyright>
 *
 * Copyright (c) 2009,2010 SAP AG and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Axel Uhl - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: EvaluationVisitorImpl.java,v 1.1 2010/12/15 17:32:44 ewillink Exp $
 */
package org.eclipse.ocl.ecore;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.AbstractEnvironmentFactory;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.EnvironmentFactory;
import org.eclipse.ocl.EvaluationEnvironment;
import org.eclipse.ocl.EvaluationVisitor;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.utilities.VisitorExtension;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLSyntaxHelper;
import org.eclipse.ocl.parser.OCLAnalyzer;
import org.eclipse.ocl.parser.OCLFactoryWithHistory;
import org.eclipse.ocl.parser.backtracking.OCLBacktrackingParser;
import org.eclipse.ocl.types.CollectionType;
import org.eclipse.ocl.util.CollectionUtil;
import org.eclipse.ocl.utilities.Visitor;


/**
 * @since 3.1
 */
public class EvaluationVisitorImpl
		extends
		org.eclipse.ocl.EvaluationVisitorImpl<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter, EObject,
		CallOperationAction, SendSignalAction, Constraint,
		EClass, EObject> implements VisitorExtension<Object> {

	/**
	 * A lazily-initialized {@link OCL} instance, used for performance improvements during
	 * cache lookups by {@link #getOperationBody(EOperation)} and {@link #getPropertyBody(EStructuralFeature)}
	 */
	private LazyOCL lazyOCL;

	public EvaluationVisitorImpl(
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
			Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
		super(env, evalEnv, extentMap);
	}

	/**
	 * Callback for a PropertyCallExp visit. Evaluates the source of the
	 * expression and then reflectively gets the value of the property on the
	 * result. For example, in "self.foo", "self" is the source and would be
	 * evaluated first, then the value of the property "foo" would be accessed
	 * on that object.
	 */
	@SuppressWarnings("unchecked")
    public Object visitOppositePropertyCallExp(OppositePropertyCallExp pc) {
		EReference property = pc.getReferredOppositeProperty();
		OCLExpression<EClassifier> source = pc.getSource();
		// evaluate source
		Object context = source.accept(getVisitor());
		// if source is undefined, result is OclInvalid
		if (isUndefined(context)) {
            return getInvalid();
        }
		Object result = ((EvaluationEnvironmentWithHiddenOpposites) getEvaluationEnvironment())
			.navigateOppositeProperty(property, context);
		if ((pc.getType() instanceof CollectionType<?, ?>)
			&& !(result instanceof Collection<?>)) {
			// this was an XSD "unspecified multiplicity".  Now that we know what
			//    the multiplicity is, we can coerce it to a collection value
			CollectionKind kind = ((CollectionType<EClassifier, EOperation>) pc.getType()).getKind();
			Collection<Object> collection = CollectionUtil.createNewCollection(kind);
			if (result != null) {
				collection.add(result);
			}
			result = collection;
		}
		return result;
	}

	@Override
	protected OCLExpression<EClassifier> getOperationBody(EOperation operation) {
		OCLExpression<EClassifier> result;
		try {
			result = InvocationBehavior.INSTANCE.getOperationBody(
				null, operation);
		} catch (IllegalArgumentException e) {
			result = InvocationBehavior.INSTANCE.getOperationBody(OCL.newInstance(getEnvironment().getFactory()), operation);
		}
//		OCLExpression<EClassifier> result = InvocationBehavior.INSTANCE.getOperationBody(
//			getLazyOCL(), operation);
		if (result == null) {
			result = super.getOperationBody(operation);
		}
		return result;
	}

	@Override
	protected OCLExpression<EClassifier> getPropertyBody(
			EStructuralFeature property) {
		OCLExpression<EClassifier> result;
		try {
			result = SettingBehavior.INSTANCE.getFeatureBody(
				null, property);
		} catch (IllegalArgumentException e) {
			result = SettingBehavior.INSTANCE.getFeatureBody(OCL.newInstance(getEnvironment().getFactory()), property);
		}
//		OCLExpression<EClassifier> result = SettingBehavior.INSTANCE.getFeatureBody(
//			getLazyOCL(), property);
		if (result == null) {
			result = super.getPropertyBody(property);
		}
		return result;
	}

	private LazyOCL getLazyOCL() {
		if (lazyOCL == null) {
			lazyOCL = new LazyOCL(getEnvironment().getFactory());
		}
		return lazyOCL;
	}

	/**
	 * Allows {@link EvaluationVisitorImpl#getPropertyBody(EStructuralFeature)}
	 * and {@link EvaluationVisitorImpl#getOperationBody(EOperation)} to pass a
	 * valid {@link OCL} instance whose initialization is inexpensive. It
	 * inherits from {@link OCL}. While initializing the base class, only
	 * <code>null</code> values are produced by the
	 * {@link #phonyEnvironmentFactory phony environment factory} passed to the
	 * base class constructor. All {@link OCL} operations are overridden here,
	 * particularly the {@link #createOCLHelper()} operation required by
	 * {@link EvaluationVisitorImpl#getPropertyBody(EStructuralFeature)} and
	 * {@link EvaluationVisitorImpl#getOperationBody(EOperation)}. When the first
	 * call is received, the real {@link OCL} delegate is initialized, using the
	 * {@link EnvironmentFactory} passed to the constructor.
	 * 
	 * @author Axel Uhl
	 * 
	 */
	private static class LazyOCL extends OCL {
		/**
		 * The {@link OCL} instance which will only get created upon first access and will then be used as delegate
		 */
		private OCL ocl;
		
		/**
		 * An environment factory used for the fast construction of the base class part, using all <code>null</code>
		 * values. This is possible because no base class operations are ever invoked as all methods are overridden
		 * here in such a way that they first ensure construction of a real, valid and properly initialized {@link OCL}
		 * object using the {@link EnvironmentFactory} passed to the constructor.
		 */
		private static final EnvironmentFactory<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> phonyEnvironmentFactory = new AbstractEnvironmentFactory<
		EPackage, EClassifier, EOperation, EStructuralFeature,
		EEnumLiteral, EParameter,
		EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>() {
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment() {
				return null;
			}
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createPackageContext(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
					List<String> pathname) {
				return null;
			}
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> loadEnvironment(
					Resource resource) {
				return null;
			}
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createClassifierContext(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
					EClassifier context) {
				return null;
			}
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createInstanceContext(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
					Object context) {
				return null;
			}
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOperationContext(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
					EOperation operation) {
				return null;
			}
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createAttributeContext(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent,
					EStructuralFeature property) {
				return null;
			}
			public Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEnvironment(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> parent) {
				return null;
			}
			public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment() {
				return null;
			}
			public EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> createEvaluationEnvironment(
					EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> parent) {
				return null;
			}
			public EvaluationVisitor<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createEvaluationVisitor(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
					EvaluationEnvironment<EClassifier, EOperation, EStructuralFeature, EClass, EObject> evalEnv,
					Map<? extends EClass, ? extends Set<? extends EObject>> extentMap) {
				return null;
			}
			public OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOCLAnalyzer(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment,
					String input) {
				return null;
			}
			public OCLAnalyzer<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> createOCLAnalyzer(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment,
					OCLBacktrackingParser parser) {
				return null;
			}
			public OCLFactoryWithHistory createOCLFactoryWithHistory(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
				return null;
			}
			public OCLSyntaxHelper createOCLSyntaxHelper(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
				return null;
			}
			public Visitor<Boolean, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> createValidationVisitor(
					Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environment) {
				return null;
			}
			@Override
			protected EPackage lookupPackage(List<String> pathname) {
				return null;
			}
			@Override
			protected EClassifier getClassifier(Object context) {
				return null;
			}
		};
		private final EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> envFactory;
		protected LazyOCL(
				EnvironmentFactory<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> environmentFactory) {
			super(phonyEnvironmentFactory);
			this.envFactory = environmentFactory;
		}
		
		/**
		 * Constructs the {@link OCL} instance using the {@link EnvironmentFactory} passed to this object's
		 * constructor for the {@link OCL#newInstance(EnvironmentFactory)} call. The resulting object is assigned
		 * to {@link #ocl}.
		 */
		private void createOCL() {
			ocl = OCL.newInstance(envFactory);
		}

		@Override
		public Helper createOCLHelper() {
			if (ocl == null) {
				createOCL();
			}
			return ocl.createOCLHelper();
		}

		@Override
		public Query createQuery(Constraint constraint) {
			if (ocl == null) {
				createOCL();
			}
			return ocl.createQuery(constraint);
		}

		@Override
		public Query createQuery(OCLExpression<EClassifier> query) {
			if (ocl == null) {
				createOCL();
			}
			return ocl.createQuery(query);
		}
		
	}

}
