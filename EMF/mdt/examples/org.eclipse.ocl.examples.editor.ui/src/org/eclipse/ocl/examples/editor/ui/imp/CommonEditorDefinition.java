/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonEditorDefinition.java,v 1.2 2010/03/22 01:13:55 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.examples.common.utils.EcoreUtils;
import org.eclipse.ocl.examples.editor.AbstractNode;
import org.eclipse.ocl.examples.editor.Behavior;
import org.eclipse.ocl.examples.editor.EcoreNode;
import org.eclipse.ocl.examples.editor.EditorDefinition;
import org.eclipse.ocl.examples.editor.EditorFactory;
import org.eclipse.ocl.examples.editor.EditorPackage;
import org.eclipse.ocl.examples.editor.JavaNode;
import org.eclipse.ocl.examples.editor.OutlineGroup;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;

/**
 * CommonEditorDefinition, typically instantiated in an
 * editing plugin, provides facilities to use the model-defined editor
 * definition provided by URL as its construction argument.
 */
public class CommonEditorDefinition implements IResourceChangeListener, IResourceDeltaVisitor
{
	public static CommonEditorDefinition create(ICommonPlugin plugin, String editorFile) {
		URI editorURI = URI.createPlatformPluginURI(plugin.getBundle().getSymbolicName() + "/" + editorFile, true);
		return new CommonEditorDefinition(editorURI);			
	}

	protected final URI editorURI;
    protected EditorDefinition editorDefinition = null;
	private Map<EClassifier, EcoreNode> ecoreMap = null;
	private Map<Class<?>, JavaNode> javaMap = null;
	private Set<URI> editorURIs = null;			// Closure of EditorDefinition._extends
	private Map<OutlineGroup, Integer> outlineGroupToCategory = null;
	private List<OutlineGroup> categoryToOutlineGroup = null;

    public CommonEditorDefinition(URI editorURI) {
    	this.editorURI = editorURI;
		EditorPackage.eINSTANCE.getClass();
		if (editorURI != null)
			ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
    }

    public void dispose() {
    	if (editorURI != null)
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
    }
    
	protected EcoreNode findEcoreClass(EClass subType) {
		if (ecoreMap != null) {
			for (EClass superType : subType.getESuperTypes()) {
				EcoreNode ecoreNode = ecoreMap.get(superType);
				if (ecoreNode != null)
					return ecoreNode; 
				ecoreNode = findEcoreClass(superType);
				if (ecoreNode != null)
					return ecoreNode; 
			}
		}
		return null;
	}

	protected JavaNode findJavaClass(Class<?> subClass) {
		if (javaMap != null) {
			Class<?> superClass = subClass.getSuperclass();
			if (superClass != null) {
				JavaNode javaNode = javaMap.get(superClass);
				if (javaNode != null)
					return javaNode; 
				javaNode = findJavaClass(superClass);
				if (javaNode != null)
					return javaNode; 
			}
			for (Class<?> superInterface : subClass.getInterfaces()) {
				JavaNode javaNode = javaMap.get(superInterface);
				if (javaNode != null)
					return javaNode; 
				javaNode = findJavaClass(superInterface);
				if (javaNode != null)
					return javaNode; 
			}
		}
		return null;
	}

	public <T extends Behavior> T getBehavior(Object object, Class<T> behaviorClass) {
		for (AbstractNode node = getNode(object); node != null; node = node.getBase()) {
			for (Behavior behavior : node.getBehavior()) {
				if (behaviorClass.isAssignableFrom(behavior.getClass())) {
					@SuppressWarnings("unchecked")
					T castBehavior = (T) behavior;
					return castBehavior;
				}
			}
		}
		return null;
	}
	
	public int getCategory(OutlineGroup outlineGroup) {
		if (categoryToOutlineGroup == null) {
			categoryToOutlineGroup = new ArrayList<OutlineGroup>();
			outlineGroupToCategory = new HashMap<OutlineGroup, Integer>();
			outlineGroupToCategory.put(null, Integer.valueOf(0));
			categoryToOutlineGroup.add(null);
		}
		Integer category = outlineGroupToCategory.get(outlineGroup);
		if (category != null)
			return category.intValue();
		int size = categoryToOutlineGroup.size();
		outlineGroupToCategory.put(outlineGroup, Integer.valueOf(size));
		categoryToOutlineGroup.add(outlineGroup);
		return size;
	}

	public EditorDefinition getEditorDefinition() {
		if ((editorDefinition == null) && (editorURI != null)) {
			try {
				ResourceSet resourceSet = new ResourceSetImpl();
			    resourceSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap());
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("editor", new XMIResourceFactoryImpl());
				Resource resource = resourceSet.createResource(editorURI);
				resource.load(null);
				editorDefinition = (EditorDefinition) resource.getContents().get(0);
				installEditorDefinition(editorDefinition);
			} catch (Exception e) {
				OCLExamplesEditorPlugin.logError("Failed to load '" + editorURI.toString() + "'", e);
			} finally {
				if (editorDefinition == null)
					editorDefinition = EditorFactory.eINSTANCE.createEditorDefinition();			
			}
		}
		return editorDefinition;
	}

	protected Set<URI> getEditorURIs() {
		if (editorURIs == null) {
			editorURIs = new HashSet<URI>();
			getEditorURIs(editorURIs, editorDefinition);
		}
		return editorURIs;
	}
	
	private void getEditorURIs(Set<URI> editorURIs, EditorDefinition editorDefinition) {
		URI uri = editorDefinition.eResource().getURI();
		if (editorURIs.add(uri)) {
			for (EditorDefinition extendedDefinition : editorDefinition.getExtends())
				getEditorURIs(editorURIs, extendedDefinition);
		}		
	}
	
	public OutlineGroup getOutlineGroup(int category) {
		if (categoryToOutlineGroup == null)
			return null;
		else if (category >= categoryToOutlineGroup.size())
			return null;
		else
			return categoryToOutlineGroup.get(category);
	}

	protected void installEditorDefinition(EditorDefinition editorDefinition) {
		EcoreUtil.resolveAll(editorDefinition);
	    Map<EObject, Collection<Setting>> unresolvedMap = EcoreUtil.UnresolvedProxyCrossReferencer.find(editorDefinition);
		String diagnosis = EcoreUtils.diagnoseUnresolvedProxies(EcoreUtil.getURI(editorDefinition), unresolvedMap);
		if (diagnosis != null)
			OCLExamplesEditorPlugin.logError(diagnosis, null);
		for (AbstractNode node : editorDefinition.getNode()) {
			if (node instanceof EcoreNode) {
				if (ecoreMap == null)
					ecoreMap = new HashMap<EClassifier, EcoreNode>();
				EcoreNode ecoreNode = (EcoreNode)node;
				EClassifier ecoreKey = ecoreNode.getElement();
				if (!ecoreMap.containsKey(ecoreKey))
					ecoreMap.put(ecoreKey, ecoreNode);
			}
			else if (node instanceof JavaNode) {
				if (javaMap == null)
					javaMap = new HashMap<Class<?>, JavaNode>();
				try {
					JavaNode javaNode = (JavaNode)node;
					Class<?> javaKey = Class.forName(javaNode.getName());
					if (!javaMap.containsKey(javaKey))
						javaMap.put(javaKey, javaNode);
				} catch (ClassNotFoundException e) {
					OCLExamplesEditorPlugin.logError("In '" + editorDefinition.getLanguage() + "'.editor definition", e);
				}
			}
		}
		for (EditorDefinition ed : editorDefinition.getExtends())
			installEditorDefinition(ed);
	}

	protected EcoreNode getEcoreNode(EClass ecoreClass) {
		if (ecoreMap == null)
			return null;
		EcoreNode ecoreNode = ecoreMap.get(ecoreClass);
		if (ecoreNode != null)
			return ecoreNode; 
		if (ecoreMap.containsKey(ecoreClass))
			return null;
		ecoreNode = findEcoreClass(ecoreClass);
		ecoreMap.put(ecoreClass, ecoreNode); 
		return ecoreNode;
	}

	protected JavaNode getJavaNode(Class<?> javaClass) {
		if (javaMap == null)
			return null;
		JavaNode javaNode = javaMap.get(javaClass);
		if (javaNode != null)
			return javaNode; 
		if (javaMap.containsKey(javaClass))
			return null;
		javaNode = findJavaClass(javaClass);
		javaMap.put(javaClass, javaNode); 
		return javaNode;
	}

	public AbstractNode getNode(Object object) {
		if (object == null)
			return null;
		if (editorDefinition == null)
			getEditorDefinition();
		AbstractNode node = null;
		if (object instanceof EObject)
			node = getEcoreNode(((EObject)object).eClass());
		if (node == null)
			node = getJavaNode(object.getClass());			
		return node;
	}

	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			IResourceDelta delta = event.getDelta();
			try {
				delta.accept(this);
			} catch (CoreException e) {
			}
		}
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (resource instanceof IFile) {
			int deltaKind = delta.getKind();
			if ((deltaKind == IResourceDelta.REMOVED)
			 || (deltaKind == IResourceDelta.CHANGED)
			 || (deltaKind == IResourceDelta.REPLACED)) {
		        URI fileURI = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		        int fileSegments = fileURI.segmentCount();
		        for (URI uri : getEditorURIs()) {
			        int editorSegments = uri.segmentCount();
			        if (editorSegments == fileSegments) {
			        	int i = editorSegments;
			        	while (--i > 0)
			        		if (!fileURI.segment(i).equals(uri.segment(i)))
			        			break;
						if (i <= 0) {
							editorDefinition = null;
							if (ecoreMap != null) {
								ecoreMap.clear();
							}
							if (javaMap != null) {
								javaMap.clear();
							}
							return false;
						}
			        }
		        }
			}
		}
		return true;
	}
}
