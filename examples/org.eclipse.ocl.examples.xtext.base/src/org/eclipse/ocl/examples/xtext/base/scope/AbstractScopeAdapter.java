/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: AbstractScopeAdapter.java,v 1.3 2010/05/09 10:38:01 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

public abstract class AbstractScopeAdapter<T extends EObject> extends AdapterImpl
{	
	public static interface ISwitch {
		<E extends EObject> AbstractScopeAdapter<?> doInPackageSwitch(E eObject);
	}
	
	private static Map<EPackage, ISwitch> switchMap = new HashMap<EPackage, ISwitch>();

	public static void addSwitch(EPackage ePackage, ISwitch iSwitch) {
		switchMap.put(ePackage, iSwitch);
	}

	public static AbstractDocumentScopeAdapter<?> getDocumentScopeAdapter(ElementCS context) {
		for (AbstractScopeAdapter<?> scopeAdapter = AbstractScopeAdapter.getScopeAdapter(context); scopeAdapter != null; scopeAdapter = scopeAdapter.getParent()) {
			if (scopeAdapter instanceof AbstractDocumentScopeAdapter<?>) {
				return (AbstractDocumentScopeAdapter<?>) scopeAdapter;
			}
		}
		return null;
	}

	public static AbstractScopeAdapter<?> getScopeAdapter(EObject eObject) {
		if (eObject == null) {
			return null;
		}
		if (eObject.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			return null;
		}
		EList<Adapter> eAdapters = eObject.eAdapters();
		AbstractScopeAdapter<?> adapter = (AbstractScopeAdapter<?>) EcoreUtil.getAdapter(eAdapters, AbstractScopeAdapter.class);
		if (adapter != null) {
			return adapter;
		}
		EClass eClass = eObject.eClass();
		ISwitch adapterSwitch = switchMap.get(eClass.getEPackage());
		if (adapterSwitch != null) {
			adapter = adapterSwitch.doInPackageSwitch(eObject);
		}
		if (adapter != null) {
			if (adapter.getTarget() == null) {
				eAdapters.add(adapter);
			}
			return adapter;
		}
		return null;
	}

	protected final AbstractScopeAdapter<?> parent;
	protected final AbstractDocumentScopeAdapter<?> document;
	protected final Class<T> targetClass;
	private boolean unresolvable = false;		// Set true after a linking failure
	
	/**
	 * Creates an instance.
	 * @param parent 
	 */
	protected AbstractScopeAdapter(T csElement) {
		this(getScopeAdapter(csElement.eContainer()), csElement);
	}

	@SuppressWarnings("unchecked")
	private AbstractScopeAdapter(AbstractScopeAdapter<?> containerScopeAdapter, T csElement) {
		this.parent = containerScopeAdapter;
		this.document = parent != null ? parent.getDocumentScopeAdapter() : (AbstractDocumentScopeAdapter<?>)this;
		this.targetClass = (Class<T>) csElement.getClass();
	}

	public void createContents(FilteredAccesses descriptions, EStructuralFeature containmentFeature) {}

	public AbstractDocumentScopeAdapter<?> getDocumentScopeAdapter() {
		return document;
	}

	public ScopeAccessor getExclusiveScopeAccessor(EReference targetReference) {
		return new ScopeAccessor(this, null, targetReference);
	}

	public void getInclusiveInheritedContents(FilteredAccesses descriptions) {
		createContents(descriptions, BaseCSTPackage.Literals.MODEL_ELEMENT_CS__ANNOTATIONS);	// Non-null value
	}

	public ScopeAccessor getInclusiveScopeAccessor(EReference targetReference) {
		return new ScopeAccessor(this, BaseCSTPackage.Literals.MODEL_ELEMENT_CS__ANNOTATIONS, targetReference);	// Non-null value
	}

	public AbstractScopeAdapter<?> getParent() {
		return parent;
	}

	public AbstractScopeAdapter<?> getScopeAdapter(String scopeName, boolean isNested) {
		if (isNested) {
			return null;
		}
		AbstractScopeAdapter<?> outerScope = getParent();
		if (outerScope == null) {
			return null;
		}
		return outerScope.getScopeAdapter(scopeName, false);
	}

	/*
	 * Javadoc copied from interface.
	 */
	@Override
	@SuppressWarnings("unchecked")
	public T getTarget() {
		return (T) target;
	}

	/**
	 * Return the source text of the target node.
	 * @return
	 */
	public String getText() {
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(getTarget());
		if (nodeAdapter == null) {
			return null;
		}
		CompositeNode compositeNode = nodeAdapter.getParserNode();
		if (compositeNode == null) {
			return null;
		}
		String string = null;
		StringBuffer s = null;
		for (LeafNode leaf : compositeNode.getLeafNodes()) {
			if (!leaf.isHidden()) {
				String text = leaf.getText();
				if (s != null) {
					s.append(text);
				}
				else if (string != null) {
					s = new StringBuffer();
					s.append(string);
					s.append(text);
				}
				else {
					string = text;
				}
			}
		}
		return s != null ? s.toString() : string;
	}

	/**
	 * Return the type of the target.
	 * 
	 * @return the type or null if unknown
	 */
	public TypeCS getType() {
		return null;
	}
	
	/**
	 * Returns <code>false</code>
	 * 
	 * @param type
	 *            the type.
	 * @return <code>false</code>
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return type == AbstractScopeAdapter.class;
	}

	public boolean isUnresolvable() {
		return unresolvable;
	}

	/*
	 * Javadoc copied from interface.
	 */
	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == null) || targetClass.isAssignableFrom(newTarget.getClass());
		super.setTarget(newTarget);
	}

	public void setUnresolvable() {
		unresolvable  = true;
	}

	@Override
	public String toString() {
		return String.valueOf(getTarget());
	}
}
