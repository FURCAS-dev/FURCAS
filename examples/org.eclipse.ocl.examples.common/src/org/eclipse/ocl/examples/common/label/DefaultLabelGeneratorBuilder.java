/**
 * <copyright>
 * 
 * Copyright (c) 2007,2010 Eclipse Modeling Project and others.
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
 * $Id: DefaultLabelGeneratorBuilder.java,v 1.1 2010/03/11 13:54:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label;

import java.util.Map;

/**
 * DefaultLabelGeneratorBuilder builds the label on behalf of a
 * ILabelGenerator.Registry using a StringBuilder.
 */
public class DefaultLabelGeneratorBuilder extends AbstractLabelGeneratorBuilder
{	
	protected final StringBuilder s = new StringBuilder();
	
	public DefaultLabelGeneratorBuilder(ILabelGenerator.Registry registry, Map<ILabelGenerator.Option<?>, Object> options) {
		super(registry, options);
	}

	public void appendString(String string) {
		s.append(string);
	}

	@Override
	public String toString() {
		return s.toString();
	}
}