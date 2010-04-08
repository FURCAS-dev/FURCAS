/**
 * <copyright>
 *
 * Copyright (c) 2008,2010 E.D.Willink and others.
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
 * $Id: CommonASTVisitor.java,v 1.2 2010/04/08 06:26:14 ewillink Exp $
 */
package org.eclipse.ocl.examples.parser.utils;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.examples.common.plugin.OCLExamplesCommonPlugin;

/**
 * CommonCSTVisitor defines a default visitor to an Ecore
 * (EObject or Resource or ResourceSet) AST using EObject.eContents(),
 * Resource.getContents(), ResourceSet.getResources() to perform tree descent.
 */
public abstract class CommonASTVisitor<T, N> implements ICommonASTVisitor<T, N>
{
	protected final Class<N> nodeClass;
	protected T result = null;
	
	/**
	 * Construct a visit for a tree of objects that subtype nodeClass.
	 */
	protected CommonASTVisitor(Class<N> nodeClass) {
		this.nodeClass = nodeClass;
	}

	/**
	 * Perform the visit of object.
	 * <br>
	 * The default implementation returns the result of invoking visit, if the
	 * object satisfies the node class predicate, or unexpectedVisit if not.
	 */
	public T enter(Object object) {
		if (object == null)
			return null;
		else if (nodeClass.isAssignableFrom(object.getClass())) {
			@SuppressWarnings("unchecked")
			N astNode = (N) object;
			return visit(astNode);
		}
		else if (object instanceof Collection<?>) {
			Collection<?> collection = (Collection<?>)object;
			return enterCollection(collection);
		} else
			return unexpectedVisit(object);
	}

	/**
	 * Perform the visit to an object that procvers to a Collection rather
	 * than an N as contracted.
	 * <br>
	 * The default implementation invokes unexpectedVisit.
	 */
	protected T enterCollection(Collection<?> collection) {
		return unexpectedVisit(collection);
	}

	/**
	 * Perform any post-order activity at the end of a visit to astNode.
	 * Return the visit result.
	 * <br>
	 * Default result is returned from the result field.
	 */
	protected T postVisit(N astNode) {
		return result;
	}

	/**
	 * Perform any pre-order activity at the start of a visit to astNode.
	 * Return true to continue with the visit, false to inhibit the
	 * visit to astNode and its children.
	 * <br>
	 * Default implementation returns true.
	 */
	protected boolean preVisit(N astNode) {
		return true;
	}

	/**
	 * Perform any activity associated with visiting an astNode that does
	 * not satisfy the AST tree node type predicate.
	 * <br>
	 * Default logs an error.
	 */
	protected T unexpectedVisit(Object astNode) {
		OCLExamplesCommonPlugin.logError("Unexpected visit to a '" + astNode.getClass().getName() + "' by a '" + getClass().getSimpleName() + "'", null);
		return null;
	}

	/**
	 * Perform the visit to astNode returning an appropriate result.
	 * <br>
	 * The default implementation first invokes preVisit, which may return
	 * to curtail the visit. One of visitEObject, visitResource,
	 * visitResourceSet or else vistNode to perform the actual
	 * visit. Finally postVisit is invoked to provide the return.
	 */
	public T visit(N astNode) {
		if (!preVisit(astNode))
			return null;
		if (astNode instanceof EObject)
			visitEObject(astNode);
		else if (astNode instanceof Resource)
			visitResource((Resource)astNode);
		else if (astNode instanceof ResourceSet)
			visitResourceSet((ResourceSet)astNode);
		else
			vistNode(astNode);
		return postVisit(astNode);		
	}

	/**
	 * Perform the node visit to an EObject astNode.
	 * <br>
	 * The default implementation enters each of astNode.eContents().
	 */
	protected void visitEObject(N astNode) {
		for (EObject eObject : ((EObject)astNode).eContents())
			enter(eObject);
	}

	/**
	 * Perform the node visit to a non-EObject, non-Ressource, non-ResourceSet astNode.
	 * <br>
	 * The default implementation logs an error.
	 */
	protected void vistNode(Object astNode) {
		OCLExamplesCommonPlugin.logError("Unimplemented visit to a '" + astNode.getClass().getName() + "' by a '" + getClass().getSimpleName() + "'", null);
	}

	/**
	 * Perform the node visit to an Resource astNode.
	 * <br>
	 * The default implementation enters each of astNode.getContents().
	 */
	protected void visitResource(Resource astNode) {
		for (EObject eObject : astNode.getContents())
			enter(eObject);
	}

	/**
	 * Perform the node visit to an ResourceSet astNode.
	 * <br>
	 * The default implementation enters each of astNode.getResources().
	 */
	protected void visitResourceSet(ResourceSet astNode) {
		for (Resource resource : astNode.getResources())
			enter(resource);
	}
}