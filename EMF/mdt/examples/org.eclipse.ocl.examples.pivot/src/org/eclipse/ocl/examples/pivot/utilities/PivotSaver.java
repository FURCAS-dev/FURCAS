/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: PivotSaver.java,v 1.8 2011/04/25 09:49:15 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.ClassifierType;
import org.eclipse.ocl.examples.pivot.CollectionType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.LambdaType;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.OperationCallExp;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TupleType;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;

/**
 * PivotSaver ensures that all references to specialized types are terminated
 * by local copies of the specialization.
 */
public class PivotSaver
{
	/**
	 * PivotSaveLocateVisitor locates references to shared specializations, so that 
	 * local copies can be created and then replaced by the PivotSaveResolveVisitor.
	 */
	public class PivotSaveLocateVisitor extends AbstractExtendingVisitor<Object, Object>
	{
		protected PivotSaveLocateVisitor() {
			super(null);
		}

		@Override
		public Object visitClass(org.eclipse.ocl.examples.pivot.Class object) {
			for (org.eclipse.ocl.examples.pivot.Class superClass : object.getSuperClasses()) {
				if (superClass.getTemplateBindings().size() > 0) {
					specializingElements.add(object);
					break;
				}
			}
			return null;
		}

		@Override
		public Object visitCollectionType(CollectionType object) {
			Type referredType = object.getElementType();
			if ((referredType != null) && (isOrphanType(referredType))) {
				specializingElements.add(object);
			}
			return super.visitCollectionType(object);
		}

		@Override
		public Object visitLambdaType(LambdaType object) {
			boolean doneIt = false;
			Type referredType = object.getContextType();
			if ((referredType != null) && (isOrphanType(referredType))) {
				specializingElements.add(object);
				doneIt = true;
			}
			if (!doneIt) {
				referredType = object.getResultType();
				if ((referredType != null) && (isOrphanType(referredType))) {
					specializingElements.add(object);
					doneIt = true;
				}
				if (!doneIt) {
					for (Type parameterType : object.getParameterTypes()) {
						if ((parameterType != null) && (isOrphanType(parameterType))) {
							specializingElements.add(object);
							break;
						}
					}
				}
			}
			return super.visitLambdaType(object);
		}

		@Override
		public Object visitLoopExp(LoopExp object) {
			Iteration referredIteration = object.getReferredIteration();
			if ((referredIteration != null) && (isOrphanOperation(referredIteration))) {
				specializingElements.add(object);
			}
			return super.visitLoopExp(object);
		}

		@Override
		public Object visitOperationCallExp(OperationCallExp object) {
			Operation referredOperation = object.getReferredOperation();
			if ((referredOperation != null) && (isOrphanOperation(referredOperation))) {
				specializingElements.add(object);
			}
			return super.visitOperationCallExp(object);
		}

		@Override
		public Object visitTemplateParameterSubstitution(TemplateParameterSubstitution object) {
			ParameterableElement actual = object.getActual();
			if (actual instanceof Type) {
				Type referredType = (Type) actual;
				if (isOrphanType(referredType)) {
					specializingElements.add(object);
				}
			}
			return null;
		}

//		@Override
//		public Object visitType(Type object) {
//			types.put(object.getMoniker(), object);
//			if (isOrphanType(object)) {
//				if (orphanage == null) {
//					orphanage = object.getPackage();
//				}
//			}
//			return null;
//		}

		@Override
		public Object visitTypedElement(TypedElement object) {
			Type referredType = object.getType();
			if ((referredType != null) && (isOrphanType(referredType))) {
				specializingElements.add(object);
			}
			return null;
		}

		@Override
		public Object visitTypeTemplateParameter(TypeTemplateParameter object) {
			for (Type constrainingType : object.getConstrainingTypes()) {
				if (isOrphanType(constrainingType)) {
					specializingElements.add(object);
					break;
				}
			}
			return null;
		}

		public Object visiting(Visitable visitable) {
			return null;
		}
	}
	
	/**
	 * PivotSaveResolveVisitor converts references to shared specializations
	 * to references to local copies.
	 */
	public class PivotSaveResolveVisitor extends AbstractExtendingVisitor<Object, Object>
	{
		protected PivotSaveResolveVisitor() {
			super(null);
		}

		/**
		 * Return the resolved variant of referredType, which may require creation
		 * of a local copy of a specialization.
		 */
		protected <T extends Operation> T resolveOperation(T referredOperation) {
			if (!isOrphanOperation(referredOperation)) {
				return referredOperation;
			}
			String moniker = referredOperation.getMoniker();
			Operation operation = operations.get(moniker);
			if (operation != null) {
				@SuppressWarnings("unchecked") 
				T castOperation = (T) operation;
				return castOperation;
			}
			T resolvedOperation = EcoreUtil.copy(referredOperation);
			orphanageClass.getOwnedOperations().add(resolvedOperation);
			operations.put(moniker, resolvedOperation);
			String newMoniker = resolvedOperation.getMoniker();
			assert moniker.equals(newMoniker);
			locateSpecializations(Collections.singletonList(resolvedOperation));
			return resolvedOperation;
		}

		/**
		 * Return the resolved variant of referredType, which may require creation
		 * of a local copy of a specialization.
		 */
		protected <T extends Type> T resolveType(T referredType) {
			if (!isOrphanType(referredType)) {
				return referredType;
			}
			String moniker = referredType.getMoniker();
			Type type = types.get(moniker);
			if (type != null) {
				@SuppressWarnings("unchecked") 
				T castType = (T) type;
				return castType;
			}
			T resolvedType = EcoreUtil.copy(referredType);
			orphanage.getOwnedTypes().add(resolvedType);
			types.put(moniker, resolvedType);
			String newMoniker = resolvedType.getMoniker();
			assert moniker.equals(newMoniker) : newMoniker + " is not equal to " + moniker;
			locateSpecializations(Collections.singletonList(resolvedType));
			return resolvedType;
		}

		@Override
		public Object visitClass(org.eclipse.ocl.examples.pivot.Class object) {
			List<org.eclipse.ocl.examples.pivot.Class> superClasses = object.getSuperClasses();
			for (int i = 0; i < superClasses.size(); i++) {
				org.eclipse.ocl.examples.pivot.Class referredClass = superClasses.get(i);
				org.eclipse.ocl.examples.pivot.Class resolvedClass = resolveType(referredClass);
				if (resolvedClass != null) {
					superClasses.set(i, resolvedClass);
				}
			}
			return null;
		}

		@Override
		public Object visitClassifierType(ClassifierType object) {
			Type referredType = object.getInstanceType();
			Type resolvedType = resolveType(referredType);
			if (resolvedType != null) {
				object.setInstanceType(resolvedType);
			}
			return super.visitClassifierType(object);
		}

		@Override
		public Object visitCollectionType(CollectionType object) {
			Type referredType = object.getElementType();
			Type resolvedType = resolveType(referredType);
			if (resolvedType != null) {
				object.setElementType(resolvedType);
			}
			return super.visitCollectionType(object);
		}

		@Override
		public Object visitLambdaType(LambdaType object) {
			Type referredType = object.getContextType();
			Type resolvedType = resolveType(referredType);
			if (resolvedType != null) {
				object.setContextType(resolvedType);
			}
			referredType = object.getResultType();
			resolvedType = resolveType(referredType);
			if (resolvedType != null) {
				object.setResultType(resolvedType);
			}
			List<Type> parameterTypes = object.getParameterTypes();
			for (int i = 0; i < parameterTypes.size(); i++) {
				referredType = parameterTypes.get(i);
				resolvedType = resolveType(referredType);
				if (resolvedType != null) {
					parameterTypes.set(i, resolvedType);
				}
			}
			return super.visitLambdaType(object);
		}

		@Override
		public Object visitLoopExp(LoopExp object) {
			Iteration referredIteration = object.getReferredIteration();
			Iteration resolvedIteration = resolveOperation(referredIteration);
			if (resolvedIteration != null) {
				object.setReferredIteration(resolvedIteration);
			}
			return null;
		}

		@Override
		public Object visitOperationCallExp(OperationCallExp object) {	// FIXME Obsolete once referredOperation is not a specialization
			Operation referredOperation = object.getReferredOperation();
			Operation resolvedOperation = resolveOperation(referredOperation);
			if (resolvedOperation != null) {
				object.setReferredOperation(resolvedOperation);
			}
			return null;
		}

		@Override
		public Object visitTemplateParameterSubstitution(TemplateParameterSubstitution object) {
			Type referredType = (Type) object.getActual();
			Type resolvedType = resolveType(referredType);
			if (resolvedType != null) {
				object.setActual(resolvedType);
			}
			return null;
		}

		@Override
		public Object visitTypeTemplateParameter(TypeTemplateParameter object) {
			List<Type> constrainingTypes = object.getConstrainingTypes();
			for (int i = 0; i < constrainingTypes.size(); i++) {
				Type referredType = constrainingTypes.get(i);
				Type resolvedType = resolveType(referredType);
				if (resolvedType != null) {
					constrainingTypes.set(i, resolvedType);
				}
			}
			return null;
		}

		@Override
		public Object visitTypedElement(TypedElement object) {
			Type referredType = object.getType();
			Type resolvedType = resolveType(referredType);
			if (resolvedType != null) {
				object.setType(resolvedType);
			}
			return null;
		}

		public Object visiting(Visitable visitable) {
			throw new IllegalArgumentException("Unsupported " + visitable.eClass().getName() + " for PivotSaver Resolve pass");
		}
	}
	
	protected final Resource resource;
	
	/**
	 * The save visitor that identifies type references.
	 */
	private PivotSaveLocateVisitor locateVisitor = new PivotSaveLocateVisitor();

	/**
	 * The moniker to type map for types defined with the saved resource.
	 */
	private Map<String, Type> types = new HashMap<String, Type>();

	/**
	 * The moniker to operation map for operations defined with the saved resource.
	 */
	private Map<String, Operation> operations = new HashMap<String, Operation>();

	/**
	 * TypedElements that refer to specializations.
	 */
	private List<Element> specializingElements = new ArrayList<Element>();

	/**
	 * The extra package for copies of specializations.
	 */
	private org.eclipse.ocl.examples.pivot.Package orphanage = null;

	/**
	 * The extra package for copies of specializations.
	 */
	private org.eclipse.ocl.examples.pivot.Class orphanageClass = null;
	
	public PivotSaver(Resource resource) {
		this.resource = resource;
	}

	protected org.eclipse.ocl.examples.pivot.Package getOrphanPackage(Resource resource) {
		if (orphanage == null) {
			orphanage = PivotFactory.eINSTANCE.createPackage();
			orphanage.setName(PivotConstants.ORPHANAGE_NAME);
			orphanage.setMoniker(PivotConstants.ORPHANAGE_NAME);
			resource.getContents().add(orphanage);
			orphanageClass = PivotFactory.eINSTANCE.createClass();
			orphanageClass.setName(PivotConstants.ORPHANAGE_NAME);
//			orphanageClass.setMoniker(PivotConstants.ORPHANAGE_NAME);
			orphanage.getOwnedTypes().add(orphanageClass);
		}
		return orphanage;
	}

	protected boolean isOrphanOperation(Operation operation) {		// FIXME Non-static PivotUtils
		// FIXME surely an orphan is one for which eResource() is null,
		//  or one that is in the orphanage.
		if (operation.getTemplateBindings().size() > 0) {
			return true;
		}
		return false;
	}

	protected boolean isOrphanType(Type type) {		// FIXME Non-static PivotUtils
		// FIXME surely an orphan is one for which eResource() is null,
		//  or one that is in the orphanage.
		if (type.getTemplateBindings().size() > 0) {
			return true;
		}
		if (type instanceof LambdaType) {
			return true;
		}
		if (type instanceof TupleType) {
			return true;
		}
		return false;
	}

	/**
	 * Prepare a pivot resource for save by redirecting all type references to
	 * specializations to local copies of the specializations.
	 */
	public org.eclipse.ocl.examples.pivot.Package localizeSpecializations() {
		locateSpecializations(resource.getContents());
		if (specializingElements.size() > 0) {
			orphanage = getOrphanPackage(resource);
			PivotSaveResolveVisitor resolveVisitor = new PivotSaveResolveVisitor();
			for (int i = 0; i < specializingElements.size(); i++) {	// Domain may grow
				Element element = specializingElements.get(i);
				resolveVisitor.safeVisit(element);
			}
			List<Type> ownedTypes = orphanage.getOwnedTypes();
			List<Type> sorted = PivotUtil.sortByMoniker(new ArrayList<Type>(ownedTypes));
			ownedTypes.clear();
			ownedTypes.addAll(sorted);
		}
//		TypeManager.setMonikerAsID(Collections.singletonList(resource));
		return orphanage;
	}

	protected void locateSpecializations(List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			if (eObject instanceof Visitable) {
				locateVisitor.safeVisit((Visitable) eObject);
			}
			locateSpecializations(eObject.eContents());
		}
	}
}