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
 * $Id: AbstractScopeAdapter.java,v 1.8 2010/05/29 15:30:45 ewillink Exp $
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
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

/**
 * A AbstractScopeAdapter provides the basic behaviour for a family of derived
 * classes that provide additional scope/environment behaviour for corresponding
 * CS elements.
 *
 * @param <T>
 */
public abstract class AbstractScopeAdapter<T extends EObject> extends AdapterImpl implements ScopeAdapter
{	
	private static Map<EPackage, Switch> switchMap = new HashMap<EPackage, Switch>();

	public static void addSwitch(EPackage ePackage, Switch iSwitch) {
		switchMap.put(ePackage, iSwitch);
	}

	public static DocumentScopeAdapter getDocumentScopeAdapter(EObject context) {
		for (ScopeAdapter scopeAdapter = getScopeAdapter(context); scopeAdapter != null; scopeAdapter = scopeAdapter.getParent()) {
			if (scopeAdapter instanceof DocumentScopeAdapter) {
				return (DocumentScopeAdapter) scopeAdapter;
			}
		}
		return null;
	}

	public static ScopeAdapter getScopeAdapter(EObject eObject) {
		if (eObject == null) {
			return null;
		}
		if (eObject.eIsProxy()) {			// Shouldn't happen, but certainly does during development
			return null;
		}
		EList<Adapter> eAdapters = eObject.eAdapters();
		ScopeAdapter adapter = (ScopeAdapter) EcoreUtil.getAdapter(eAdapters, ScopeAdapter.class);
		if (adapter != null) {
			return adapter;
		}
		EClass eClass = eObject.eClass();
		Switch adapterSwitch = switchMap.get(eClass.getEPackage());
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

	protected final ScopeAdapter parent;
	protected final DocumentScopeAdapter document;
	protected long unresolveableModificationCount = -1;
	protected final Class<T> targetClass;
	
	/**
	 * Creates an instance.
	 * @param parent 
	 */
	protected AbstractScopeAdapter(T csElement) {
		this(csElement.eContainer(), csElement);
	}
	
	protected AbstractScopeAdapter(EObject csDocumentElement, T csElement) {
		this(getScopeAdapter(csDocumentElement), csElement);
	}

	@SuppressWarnings("unchecked")
	private AbstractScopeAdapter(ScopeAdapter containerScopeAdapter, T csElement) {
		this.parent = containerScopeAdapter;
		this.document = parent != null ? parent.getDocumentScopeAdapter() : null;	// Seems to be null on Outline refresh ?? thread conflict ??
		this.targetClass = (Class<T>) csElement.getClass();
	}

	public ScopeView computeLookup(EnvironmentView environmentView, ScopeView scopeView) {
		return scopeView.getOuterScope();
	}

	public final void computeLookup(EnvironmentView environmentView, EReference targetReference, TypeBindingsCS bindings) {
		ScopeView scopeView = getInnerScopeView(targetReference, bindings);
		computeLookup(environmentView, scopeView);
	}

	public DocumentScopeAdapter getDocumentScopeAdapter() {
		return document;
	}

	public ScopeView getInnerScopeView(EReference targetReference, TypeBindingsCS bindings) {
		return new BaseScopeView(this, null, targetReference, bindings);
	}

	public ScopeView getOuterScopeView(EReference targetReference, TypeBindingsCS bindings) {
		ScopeAdapter parent = getParent();
		T target = getTarget();
		return new BaseScopeView(parent, target.eContainingFeature(), targetReference, bindings);
	}

	public ScopeAdapter getParent() {
		return parent;
	}

	public final String getSignature() {
		T target = getTarget();
		if (target instanceof ModelElementCS) {
			return ((ModelElementCS)target).getSignature();
		}
		else {
			return target.toString();
		}
	}
	
	public ScopeAdapter getSourceScope(EStructuralFeature containmentFeature) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ".getSourceScope for " + getTarget().eClass().getName()); //$NON-NLS-1$
//		return null;
	}

	public ClassifierCS getSynthesizedType(TypeBindingsCS bindings) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ".getSynthesizedType for " + getTarget().eClass().getName()); //$NON-NLS-1$
//		return null;
	}

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
	
	@Override
	public boolean isAdapterForType(Object type) {
		return type == ScopeAdapter.class;
	}

	public boolean isUnresolvable() {
		return (document == null) || (unresolveableModificationCount >= document.getModificationCount());
	}

	@Override
	public void setTarget(Notifier newTarget) {
		assert (newTarget == null) || targetClass.isAssignableFrom(newTarget.getClass());
		super.setTarget(newTarget);
	}

	public void setUnresolvable() {
		if (document != null) {
			unresolveableModificationCount = document.getModificationCount();
		}
	}

	@Override
	public String toString() {
		return String.valueOf(getSignature());
	}
}
