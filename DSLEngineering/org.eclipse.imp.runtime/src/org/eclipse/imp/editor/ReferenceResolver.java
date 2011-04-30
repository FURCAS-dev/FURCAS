/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.editor;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.imp.parser.IParseController;
import org.eclipse.imp.services.IReferenceResolver;

/**
 * Provides a default implementation for (most of) the the IReferenceResolver interface,
 * the purpose of which is to support the creation of hyperlinks between nodes in an AST.
 * 
 * The principal methods remaining for the user to implement are
 * 		public Object getLinkTarget(Object node, IParseController parseController)
 * and
 * 		public String getLinkText(Object node)
 * which will currently return not-very-useful values.
 * 
 * @author sutton
 */
public abstract class ReferenceResolver implements IReferenceResolver {

	protected Set<Class<?>> fSourceTypes = new HashSet<Class<?>>();
	
	public ReferenceResolver() { }
	
	public ReferenceResolver(Collection<Class<?>> sourceTypes)
	{
	    fSourceTypes.addAll(sourceTypes);
	}
	
	public void setSourceTypes(Collection<Class<?>> sourceTypes) {
	    fSourceTypes.clear();
	    fSourceTypes.addAll(sourceTypes);
	}
	
	public void addSourceType (Class<?> type)
	{
	    fSourceTypes.add(type);
	}

	public void removeSourceType(Class<?> type)
	{
	    fSourceTypes.remove(type);
	}

	// If you don't wish to enumerate the source types for hyperlinks
	// then fSourceTypes can be ignored and this method can be 
	// overridden in the language-specific concrete subclass so as
	// to return an appropriate value in some other way
	public boolean hasSuitableLinkSourceType(Object node) {
		return fSourceTypes.contains(node.getClass());
	}
	
	public abstract Object getLinkTarget(Object node, IParseController parseController);
	
	public abstract String getLinkText(Object node);
}
