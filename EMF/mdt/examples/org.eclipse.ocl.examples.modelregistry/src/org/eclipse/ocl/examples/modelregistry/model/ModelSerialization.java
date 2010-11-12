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
 * $Id: ModelSerialization.java,v 1.2 2010/04/08 06:23:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.model;

/**
 * A ModelSerialisation defines the serialization of a model by an informal name such as "XML"
 * and a corresponding Resource.Factory implementation that creates and loads
 * models of that serialization.
 */
public interface ModelSerialization
{
	/**
	 * Return the name of the resource factory class.  
	 * @return the resource factory class name.
	 */
	public String getFactoryClassName();

	/**
	 * Return the name of the model serialization.  
	 * @return the model serialization name
	 */
	public String getName();
}
