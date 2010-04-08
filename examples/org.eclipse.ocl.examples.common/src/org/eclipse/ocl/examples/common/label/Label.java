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
 * $Id: Label.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label;


/**
 * Label is a facade for the ILabelGenerator extensible label generators.
 */
public class Label
{
	/**
	 * Generate a label for labelled object using the default global label generator
	 * registartions.
	 * 
	 * @param labelledObject to be labelled
	 * @return the label
	 */
    public static String labelFor(Object labelledObject) {
    	return ILabelGenerator.Registry.INSTANCE.labelFor(labelledObject);
    }
}