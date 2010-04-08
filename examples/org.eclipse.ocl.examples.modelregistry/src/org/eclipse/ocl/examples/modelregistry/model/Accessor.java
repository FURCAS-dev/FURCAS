/**
 * <copyright>
 *
 * Copyright (c) 2007,2010 E.D.Willink and others.
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
 * $Id: Accessor.java,v 1.2 2010/04/08 06:23:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

/**
 * An Accessor defines a name and associated namespace by which models can be accessed
 * in the model registry. The derived class defines the namespace and should return a
 * distinctive value as getNameSpace().
 */
public interface Accessor<A extends Accessor<A>>
{
	public interface Installer<A extends Accessor<A>>
	{
		public Namespace<A> getNamespace();
	}
	
	public interface Namespace<A extends Accessor<A>>
	{

		/**
		 * Create a new accessor of this namespace for a name  
		 * @return the accessor for name
		 * @throws Exception 
		 */
		public A newInstance(String name) throws Exception;

		/**
		 * Return the name by which this accessor namespace is known.  
		 * @return the human friendly namespace name
		 */
		public String getName();
	}

	/**
	 * Return the name that is accessed.  
	 * @return the accessed name
	 */
	public String getName();
	
	/**
	 * Return the namespace of this accessor.  
	 * @return the accessor namespace
	 */
	public Namespace<A> getNamespace();
}
