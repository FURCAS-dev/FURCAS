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
 * $Id: AbstractScopeAdapter.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scoping.pivot;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.PivotScopeVisitor;
import org.eclipse.ocl.examples.xtext.base.scope.BaseScopeView;
import org.eclipse.ocl.examples.xtext.base.scope.EnvironmentView;
import org.eclipse.ocl.examples.xtext.base.scope.RootScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeView;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;

/**
 * A AbstractScopeAdapter provides the basic behaviour for a family of derived
 * classes that provide additional scope/environment behaviour for corresponding
 * CS elements.
 *
 * @param <T>
 */
public abstract class AbstractScopeAdapter<T extends EObject> implements ScopeAdapter, Adapter.Internal
{	
	private static final Logger logger = Logger.getLogger(AbstractScopeAdapter.class);

	public static RootScopeAdapter getDocumentScopeAdapter(TypeManager typeManager, Element context) {
		for (ScopeAdapter scopeAdapter = getScopeAdapter(typeManager, context); scopeAdapter != null; scopeAdapter = scopeAdapter.getParent()) {
			if (scopeAdapter instanceof RootScopeAdapter) {
				return (RootScopeAdapter) scopeAdapter;
			}
		}
		return null;
	}

	public static RootScopeAdapter getDocumentScopeAdapter(ModelElementCS context) {
		for (ScopeAdapter scopeAdapter = getScopeAdapter(context); scopeAdapter != null; scopeAdapter = scopeAdapter.getParent()) {
			if (scopeAdapter instanceof RootScopeAdapter) {
				return (RootScopeAdapter) scopeAdapter;
			}
		}
		return null;
	}

	public static ScopeAdapter getScopeAdapter(TypeManager typeManager, Element eObject) {
		if (eObject == null) {
			logger.warn("getScopeAdapter for null");
			return null;
		}
		if (eObject.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			logger.warn("getScopeAdapter for proxy " + eObject);
			return null;
		}
		ScopeAdapter adapter = PivotUtil.getAdapter(ScopeAdapter.class, eObject);
		if (adapter != null) {
			return adapter;
		}
//		Resource resource = eObject.eResource();
//		ResourceSet resourceSet = resource.getResourceSet();
		PivotScopeVisitor visitor = new PivotScopeVisitor(typeManager);
		return eObject.accept(visitor);	
	}

	public static ScopeAdapter getScopeAdapter(ModelElementCS csElement) {
		if (csElement == null) {
			logger.warn("getScopeAdapter for null");
			return null;
		}
		if (csElement.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			logger.warn("getScopeAdapter for proxy " + csElement);
			return null;
		}
		Element pivotElement = csElement.getPivot();
		if (pivotElement == null) {
//			logger.warn("getScopeAdapter for null pivot");
			return getScopeCSAdapter(csElement);
		}
		if (pivotElement.eResource() == null) {
//			logger.warn("getScopeAdapter for null resource");
			return getScopeCSAdapter(csElement);
		}
		ScopeAdapter adapter = PivotUtil.getAdapter(ScopeAdapter.class, pivotElement);
		if (adapter != null) {
			return adapter;
		}
		Resource csResource = csElement.eResource();
		if (csResource == null) {
			return null;
		}
		TypeManager typeManager = PivotUtil.getTypeManager(csResource);//		TypeManager typeManager = TypeManager.getAdapter(resourceSet);
		PivotScopeVisitor visitor = new PivotScopeVisitor(typeManager);
		return pivotElement.accept(visitor);	
	}

	public static ScopeCSAdapter getScopeCSAdapter(ElementCS csElement) {
		if (csElement == null) {
			logger.warn("getScopeCSAdapter for null");
			return null;
		}
		if (csElement.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			logger.warn("getScopeCSAdapter for proxy " + csElement);
			return null;
		}
		ScopeCSAdapter adapter = PivotUtil.getAdapter(ScopeCSAdapter.class, csElement, ScopeAdapter.class);
		if (adapter != null) {
			return adapter;
		}
		BaseCSResource csResource = (BaseCSResource) csElement.eResource();
		CS2PivotResourceAdapter resourceAdapter = CS2PivotResourceAdapter.getAdapter(csResource, null);
		CS2Pivot converter = resourceAdapter.getConverter();		
		EClass eClass = csElement.eClass();
		EPackage ePackage = eClass.getEPackage();
		BaseCSVisitor<ScopeCSAdapter, TypeManager> visitor = converter.getScopeVisitor(ePackage);		
		return csElement.accept(visitor);	
	}
	
	protected final TypeManager typeManager;

	/**
	 * The last notifier set to this adapter.
	 */
	protected final T target;

	protected final ScopeAdapter parent;

	protected AbstractScopeAdapter(TypeManager typeManager, ScopeAdapter parent, T target) {
		this.typeManager = typeManager;
		assert typeManager != null;
		this.parent = parent;
		this.target = target;
		target.eAdapters().add(this);
	}

	protected void addLibContents(EnvironmentView environmentView, Type libType, ScopeView scopeView) {
		if (libType == null) {
			return;
		}
		environmentView.addElementsOfScope(typeManager, libType, scopeView);
		if (libType instanceof org.eclipse.ocl.examples.pivot.Class) {
			for (org.eclipse.ocl.examples.pivot.Class superClass : ((org.eclipse.ocl.examples.pivot.Class) libType).getSuperClasses()) {
				addLibContents(environmentView, superClass, scopeView);
			}
		}
	}

	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		return scopeView.getOuterScope();
	}

	public final void computeLookup(EnvironmentView environmentView, EReference targetReference) {
		ScopeView scopeView = getInnerScopeView(targetReference);
		computeLookup(environmentView, scopeView);
	}

	public ScopeView getInnerScopeView(EReference targetReference) {
		return new BaseScopeView(this, null, null, targetReference);
	}

	public ScopeView getOuterScopeView(EReference targetReference) {
		ScopeAdapter parent = getParent();
		return new BaseScopeView(parent, target, target.eContainingFeature(), targetReference);
	}

	public ScopeAdapter getParent() {
		return parent;
	}
	
	public ScopeAdapter getSourceScope(EStructuralFeature containmentFeature) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ".getSourceScope for " + target.eClass().getName()); //$NON-NLS-1$
	}

	public T getTarget() {
		return target;
	}

	public final TypeManager getTypeManager() {
		return typeManager;
	}
	
	public boolean isAdapterForType(Object type) {
		return type == ScopeAdapter.class;
	}

	/**
	 * Does nothing; clients may override so that it does something.
	 */
	public void notifyChanged(Notification msg) {
		// Do nothing.
	}

	public void setTarget(Notifier newTarget) {
		assert newTarget == target;
	}

	public void unsetTarget(Notifier oldTarget) {
		throw new UnsupportedOperationException();
	}
}
