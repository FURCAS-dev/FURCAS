/**
 * <copyright>
 *
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: FormattingHelper.java,v 1.2 2007/11/06 20:02:10 cdamus Exp $
 */
package org.eclipse.ocl.lpg;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

/**
 * A FormattingHelper provides string contributions to problem messages endeavouring
 * to be as helpful as possible even when faced with malformed or null objects. 
 */
public interface FormattingHelper
{	 
	/**
	 * Return the Java class name of object. e.g. "org.eclipse.ocl.FormattingHelper".
	 * @param object to be formatted
	 * @return non-null string describing the class of object
	 */
	public String formatClass(Object object);

	/**
	 * Return the Ecore class name of object. e.g. "EOperation"
	 * @param object to be formatted
	 * @return non-null string describing the Ecore class of object
	 */
	public String formatEClassName(EObject eObject);

	/**
	 * Return the name of object. e.g. "name". The name may be obtained by
	 * using known name methods such as ENamedElement.getName().
	 * @param object to be formatted
	 * @return non-null string describing the name of object
	 */
	public String formatName(Object object);

    /**
     * Return the qualified name of an object. e.g. "A::B::name".
     * @param object to be formatted
     * @return non-null string describing the qualified name of the object
     */
	public String formatQualifiedName(Object object);
	
	/**
	 * Return a hierarchical path name. e.g. "A::B::C"
	 * @param pathName to be formatted
	 * @return non-null string describing the pathName
	 */
	public String formatPath(List<String> pathName);

	/**
	 * Return a hierarchically named name. e.g. "A::B::C.D"
	 * @param pathName to be formatted
	 * @param name to be suffixed
	 * @return non-null string describing the class of object
	 */
	public String formatPath(List<String> pathName, String name);

	/**
	 * Return the string. e.g. "string"
	 * @param string to be formatted
	 * @return non-null string describing string
	 */
	public String formatString(String string);
	
	/**
	 * Return the type of object. e.g. "Set(String)".  The type may be obtained by
	 * using known type methods such as ETypedElement.getType().
	 * @param object to be formatted
	 * @return non-null string describing the type of object
	 */
	public String formatType(Object type);
}
