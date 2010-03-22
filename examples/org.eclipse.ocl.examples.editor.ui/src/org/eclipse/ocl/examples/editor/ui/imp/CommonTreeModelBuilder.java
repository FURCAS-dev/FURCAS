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
 * $Id: CommonTreeModelBuilder.java,v 1.2 2010/03/22 01:15:07 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ui.imp;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.imp.editor.ModelTreeNode;
import org.eclipse.imp.services.base.TreeModelBuilderBase;
import org.eclipse.ocl.examples.editor.AbstractOutlineElement;
import org.eclipse.ocl.examples.editor.OutlineBehavior;
import org.eclipse.ocl.examples.editor.OutlineElement;
import org.eclipse.ocl.examples.editor.OutlineGroup;
import org.eclipse.ocl.examples.editor.ui.ICreationFactory;
import org.eclipse.ocl.examples.editor.ui.OCLExamplesEditorPlugin;
import org.eclipse.ocl.examples.parser.utils.CommonASTVisitor;

public class CommonTreeModelBuilder extends TreeModelBuilderBase
{
	public static final Integer DEFAULT_CATEGORY = Integer.valueOf(ModelTreeNode.DEFAULT_CATEGORY);		// Presumed to be 0

	protected class CommonASTModelVisitor<N> extends CommonASTVisitor<Object, N>
	{
		protected final CommonEditorDefinition editorDefinition;
		protected final Class<OutlineBehavior> outlineBehaviorClass;

		public CommonASTModelVisitor(CommonEditorDefinition editorDefinition, Class<N> nodeClass) {
			this(editorDefinition, nodeClass, OutlineBehavior.class);
		}
		
		public CommonASTModelVisitor(CommonEditorDefinition editorDefinition, Class<N> nodeClass, Class<OutlineBehavior> outlineBehaviorClass) {
			super(nodeClass);
			this.editorDefinition = editorDefinition;
			this.outlineBehaviorClass = outlineBehaviorClass;
		}

		@Override
		protected Object enterCollection(Collection<?> collection) {
			for (Object o : collection)
				enter(o);
			return null;
		}

		protected void enterElement(N astNode, AbstractOutlineElement element) {
			if (element instanceof OutlineElement)
				enterOutlineElement(astNode, ((OutlineElement) element));
			else if (element instanceof OutlineGroup)
				enterOutlineGroup(astNode, ((OutlineGroup) element));
			else
				unexpectedEnterOutline(astNode, element);
		}

		protected void enterOutlineElement(N astNode, OutlineElement element) {
			if (astNode instanceof EObject) {
				EStructuralFeature feature = element.getFeature();
				if ((feature != null) && !feature.eIsProxy()) {	// Occurs for bad mnodels
					Object selection = ((EObject)astNode).eGet(feature, false);
					enter(selection);
					return;
				}
			}
			unexpectedEnterOutline(astNode, element);
		}

		protected void enterOutlineGroup(N astNode, OutlineGroup group) {
			EList<AbstractOutlineElement> elements = group.getElements();
			if (!elements.isEmpty()) {					// Non-dummy group
				boolean isEmpty = true;
				for (AbstractOutlineElement childElement : elements) {
					if (!isEmpty(astNode, childElement))
						isEmpty = false;
						break;
				}
				if (!isEmpty) {
					try {
						boolean isHidden = group.isHidden();
						boolean isFlat = (group.getName() == null) && (group.getImage() == null);
						if (isHidden)
							categoryStack.push(editorDefinition.getCategory(group));
						else if (isEmpty)
							categoryStack.push(DEFAULT_CATEGORY);
						else {
							if (!isFlat)
								pushSubItem(group, categoryStack.peek());
							else
								createSubItem(group, categoryStack.peek());							
							categoryStack.push(DEFAULT_CATEGORY);
						}
						for (AbstractOutlineElement childElement : elements)
							enterElement(astNode, childElement);
						if (!isHidden && !isEmpty && !isFlat)
							popSubItem();
					} finally {
						categoryStack.pop();
					}
				}
			}
		}

		protected boolean isEmpty(N astNode, AbstractOutlineElement element) {
			if (element instanceof OutlineElement)
				return isEmptyOutlineElement(astNode, ((OutlineElement) element));
			else if (element instanceof OutlineGroup)
				return isEmptyOutlineGroup(astNode, ((OutlineGroup) element));
			else
				return false;
		}

		protected boolean isEmptyOutlineElement(N astNode, OutlineElement element) {
			if (astNode instanceof EObject) {
				EStructuralFeature feature = element.getFeature();
				if ((feature != null) && !feature.eIsProxy()) {
					Object selection = ((EObject)astNode).eGet(feature, false);
					if (feature.isMany() && (selection instanceof Collection<?>))
						return ((Collection<?>)selection).isEmpty();
				}
			}
			return false;
		}

		protected boolean isEmptyOutlineGroup(N astNode, OutlineGroup group) {
			EList<AbstractOutlineElement> elements = group.getElements();
			if (elements.isEmpty())
				return true;
			for (AbstractOutlineElement childElement : elements)
				if (!isEmpty(astNode, childElement))
					return false;
			return true;
		}
		
		@Override
		public Object postVisit(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, outlineBehaviorClass);
			boolean isHidden = (behavior != null) && behavior.isHidden();
			if (!isHidden)
				popSubItem();
			categoryStack.pop();
			return super.postVisit(astNode);
		}

		@Override
		public boolean preVisit(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, outlineBehaviorClass);
			boolean isHidden = (behavior != null) && behavior.isHidden();
			if (isHidden) {
				categoryStack.push(DEFAULT_CATEGORY);
				return true;
			}
			boolean isTerminal = (behavior != null) && behavior.getElements().isEmpty();
			return preVisit(astNode, isTerminal);
		}

		protected boolean preVisit(N astNode, boolean isTerminal) {
			if (isTerminal) {
				createSubItem(astNode, categoryStack.peek());
				return false;
			}
			else {				
				pushSubItem(astNode, categoryStack.peek());
				categoryStack.push(DEFAULT_CATEGORY);
				return true;
			}
		}
		
		protected void unexpectedEnterOutline(N astNode, AbstractOutlineElement element) {
			OCLExamplesEditorPlugin.logError("Unexpected enter outline for a '" + element.getClass().getName() + "' at a '" + astNode.getClass().getSimpleName() + "' by a '" + getClass().getSimpleName() + "'", null);
		}

		@Override
		public Object visit(N astNode) {
			int size = categoryStack.size();
			Object result = super.visit(astNode);
			assert size == categoryStack.size();
			return result;
		}

		@Override
		public void visitEObject(N astNode) {
			OutlineBehavior behavior = editorDefinition.getBehavior(astNode, outlineBehaviorClass);
			if (behavior != null) {
				EList<AbstractOutlineElement> elements = behavior.getElements();
				if (!elements.isEmpty()) {					// Explicit outline
					for (AbstractOutlineElement element : elements)
						enterElement(astNode, element);
					return;
				}
			}
			super.visitEObject(astNode);					// Default containment outline
		}
	}

	protected final ICreationFactory creationFactory;
	protected final boolean showAST;
	protected final Map<Object, ModelTreeNode> itemMap = new HashMap<Object, ModelTreeNode>();
	protected final Stack<Integer> categoryStack;
	
	public CommonTreeModelBuilder(ICreationFactory creationFactory, boolean showAST) {
		this.creationFactory = creationFactory;
		this.showAST = showAST;
		categoryStack = new Stack<Integer>();
		categoryStack.push(Integer.valueOf(ModelTreeNode.DEFAULT_CATEGORY));
	}

	protected CommonASTModelVisitor<Notifier> createASTVisitor(CommonEditorDefinition editorDefinition) {
		return new CommonASTModelVisitor<Notifier>(editorDefinition, Notifier.class);
	}

	@Override
	protected ModelTreeNode createSubItem(Object n, int category) {
		ModelTreeNode item = super.createSubItem(n, category);
		itemMap.put(n, item);
		return item;
	}

	@Override
	protected ModelTreeNode createTopItem(Object n, int category) {
		ModelTreeNode item = super.createTopItem(n, category);
		itemMap.clear();
		itemMap.put(n, item);
		return item;
	}

	public ICreationFactory getCreationFactory() {
		return creationFactory;
	}

	public ModelTreeNode getItem(Object n) {
		return itemMap.get(n);
	}
	
	public ICommonPlugin getPlugin() {
		return creationFactory.getPlugin();
	}

	@Override
	public void visitTree(Object root) {
		if (root instanceof ICommonParseResult)
			root = showAST ? ((ICommonParseResult) root).getAST() : ((ICommonParseResult) root).getCST();
		CommonEditorDefinition editorDefinition = getPlugin().getEditorDefinition();
		createASTVisitor(editorDefinition).enter(root);
	}
}
