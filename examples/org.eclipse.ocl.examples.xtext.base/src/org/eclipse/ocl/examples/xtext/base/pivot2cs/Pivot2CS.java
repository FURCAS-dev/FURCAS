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
 * $Id: Pivot2CS.java,v 1.2 2011/01/24 21:00:30 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.pivot2cs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.Namespace;
import org.eclipse.ocl.examples.pivot.internal.impl.MonikeredElementImpl;
import org.eclipse.ocl.examples.pivot.utilities.AbstractConversion;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.MonikeredElementCSImpl;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;

/**
 * CS2Pivot manages the equivalence between a Concrete Syntax Resources
 * and their corresponding Pivot Resources creating a CS2PivotConversion
 * to update.
 */
public class Pivot2CS extends AbstractConversion implements Adapter
{	
	private static final Logger logger = Logger.getLogger(Pivot2CS.class);

	public static interface Factory {
		BaseDeclarationVisitor createDeclarationVisitor(Pivot2CSConversion converter);
		BaseReferenceVisitor createReferenceVisitor(Pivot2CSConversion converter);
		EClass[] getEClasses();
	}

	private static Map<EClass, Factory> factoryMap = new HashMap<EClass, Factory>();
	
	public static void addFactory(Factory factory) {
		for (EClass eClass : factory.getEClasses()) {
			factoryMap.put(eClass, factory);
		}
	}

	public static Pivot2CS findAdapter(ResourceSet resourceSet) {
		if (resourceSet == null) {
			return null;
		}
		return PivotUtil.getAdapter(Pivot2CS.class, resourceSet);
	}

	public static List<ILeafNode> getDocumentationNodes(ICompositeNode node) {
		List<ILeafNode> documentationNodes = null;
		for (INode childNode : node.getChildren()) {
			if (!(childNode instanceof ILeafNode)) {
				break;
			}
			ILeafNode leafNode = (ILeafNode) childNode;
			EObject grammarElement = leafNode.getGrammarElement();
			if (!(grammarElement instanceof TerminalRule)) {
				break;
			}
			TerminalRule terminalRule = (TerminalRule) grammarElement;
			String name = terminalRule.getName();
			if ("DOCUMENTATION".equals(name)) {
				if (documentationNodes == null) {
					documentationNodes = new ArrayList<ILeafNode>();
				}
				documentationNodes.add(leafNode);
			}
			else if ("WS".equals(name)) {
			}
			else if ("SL_COMMENT".equals(name)) {
			}
			else if ("ML_COMMENT".equals(name)) {
			}
			else {
				break;
			}
		}
		return documentationNodes;
	}
	
	protected final TypeManager typeManager;
	
	/**
	 * Mapping of each CS resource to its corresponding pivot Resource.
	 */
	protected final Map<? extends Resource, ? extends Resource> cs2pivotResourceMap;
	
	/**
	 * The pivot element for CS monikers
	 */
	protected final Map<String, MonikeredElement> moniker2PivotMap;
	
	/**
	 * The pivot element for CS monikers
	 */
	protected Map<String, MonikeredElementCS> moniker2PivotCSMap1 = null;
	
	/**
	 * The new pivot element to alias map.
	 */
	protected final Map<EObject, String> aliasMap = new HashMap<EObject, String>();
	
	public Pivot2CS(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, TypeManager typeManager) {
		this.cs2pivotResourceMap = cs2pivotResourceMap;
		this.typeManager = typeManager;
		moniker2PivotMap = typeManager.computeMoniker2PivotMap(getPivotResources());
		typeManager.getPivotResourceSet().eAdapters().add(this);	// FIXME Dispose somehow
	}
	
	public Pivot2CS(Pivot2CS aConverter) {
		this.cs2pivotResourceMap = aConverter.cs2pivotResourceMap;
		this.typeManager = aConverter.typeManager;
		moniker2PivotMap = typeManager.computeMoniker2PivotMap(getPivotResources());
	}

//	public Map<String, MonikeredElementCS> computeMoniker2CSMap() {
//		if (moniker2PivotCSMap == null) {
//			moniker2PivotCSMap = computeMoniker2CSMap(getCSResources());
//		}
//		return moniker2PivotCSMap;
//	}

	public Map<String, MonikeredElementCS> computeMoniker2CSMap(Collection<? extends Resource> csResources) {
		Map<String, MonikeredElementCS> map = new HashMap<String, MonikeredElementCS>();
		for (Resource csResource : csResources) {
			for (Iterator<EObject> it = csResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof MonikeredElementCS) {
					MonikeredElementCS monikeredElement = (MonikeredElementCS) eObject;
					String moniker = monikeredElement.getMoniker();
					assert moniker != null;
					MonikeredElementCS oldMonikeredElement = map.get(moniker);
					if (monikeredElement instanceof NamedElementCS) {
						if (oldMonikeredElement instanceof NamedElementCS) {
							logger.warn("Duplicate CS '" + moniker + "'");
						}
						else {
							map.put(moniker, monikeredElement);
						}
					}
					else if (oldMonikeredElement == null){
						map.put(moniker, monikeredElement);
					}
				}
			}
		}
		return map;
	}	

	public void declareAlias(Namespace pivotElement, PackageCS csElement) {
		aliasMap.put(pivotElement, AliasAdapter.getAlias(csElement));
	}

	public Collection<? extends Resource> getCSResources() {
		return cs2pivotResourceMap.keySet();
	}

	public Factory getFactory(EClass eClass) {
		return factoryMap.get(eClass);
	}

	public Set<String> getMonikers() {
		return moniker2PivotMap.keySet();
	}
	
	public MonikeredElement getPivotElement(String moniker) {
		return moniker2PivotMap.get(moniker);
	}

	public Resource getPivotResource(Resource csResource) {
		return cs2pivotResourceMap.get(csResource);
	}

	public Collection<? extends Resource> getPivotResources() {
		return cs2pivotResourceMap.values();
	}

	public Notifier getTarget() {
		return typeManager.getPivotResourceSet();
	}

	public TypeManager getTypeManager() {
		return typeManager;
	}

	public boolean isAdapterForType(Object type) {
		return type == Pivot2CS.class;
	}

	public void notifyChanged(Notification notification) {
		// Do nothing.
	}
	
	public MonikeredElement putPivotElement(String moniker, MonikeredElement pivotElement) {
		MonikeredElement oldElement = moniker2PivotMap.put(moniker, pivotElement);
		if (oldElement != null) {
			assert oldElement == pivotElement;
		}
		return oldElement;
	}

//	public void refreshAliasMap(Resource csResource) {
//		Resource pivotResource = cs2pivotResourceMap.get(csResource);
//		AliasAdapter.getAdapter(pivotResource).refreshMap(aliasMap);
//	}

	/**
	 * Reset all the CS monikers for test purposes.
	 */
	public void resetCSMonikers() {
		for (Resource pivotResource : getCSResources()) {
			for (Iterator<EObject> it = pivotResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof MonikeredElementCSImpl) {
					((MonikeredElementCSImpl)eObject).resetMoniker();
				}
			}
		}
	}

	/**
	 * Reset all the pivot monikers for test purposes.
	 */
	public void resetPivotMonikers() {
		for (Resource pivotResource : getPivotResources()) {
			for (Iterator<EObject> it = pivotResource.getAllContents(); it.hasNext(); ) {
				EObject eObject = it.next();
				if (eObject instanceof MonikeredElementImpl) {
					((MonikeredElementImpl)eObject).resetMoniker();
				}
			}
		}
	}

	public void setTarget(Notifier newTarget) {
		assert newTarget == typeManager.getPivotResourceSet();
	}
	
	public void update() {
		Pivot2CSConversion conversion = new Pivot2CSConversion(this);
		conversion.update(getCSResources());
	}

	public BaseDeclarationVisitor createDefaultDeclarationVisitor(Pivot2CSConversion conversion) {
		return new BaseDeclarationVisitor(conversion);
	}

	public BaseReferenceVisitor createDefaultReferenceVisitor(Pivot2CSConversion conversion) {
		return new BaseReferenceVisitor(conversion);
	}
}