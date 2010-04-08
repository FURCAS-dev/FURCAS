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
 * $Id: AbstractLabelGeneratorBuilder.java,v 1.2 2010/04/08 06:27:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ocl.examples.common.label.ILabelGenerator.Registry;

/**
 * AbstractLabelGeneratorBuilder builds the formatted description on behalf of a
 * ILabelGenerator.Builder.
 */
public abstract class AbstractLabelGeneratorBuilder implements ILabelGenerator.Builder
{	
	protected final ILabelGenerator.Registry registry;
	protected Map<ILabelGenerator.Option<?>, Object> options = null;
	
	protected AbstractLabelGeneratorBuilder(ILabelGenerator.Registry registry, Map<ILabelGenerator.Option<?>, Object> options) {
		this.registry = registry;
		this.options = options;
	}

	public void appendObject(Object object) {
		registry.buildSubLabelFor(this, object);
	}

	public void buildLabelFor(Object object) {
		registry.buildLabelFor(this, object);
	}

	@SuppressWarnings("unchecked")
	public <T> T getOption(ILabelGenerator.Option<T> option) {
		return options != null ? (T) options.get(option) : null;
	}

	public Registry getRegistry() {
		return registry;
	}

	public <T> void setOption(ILabelGenerator.Option<T> option, T value) {
		if (options == null)
			options = new HashMap<ILabelGenerator.Option<?>, Object>();
		options.put(option, value);
	}	
}