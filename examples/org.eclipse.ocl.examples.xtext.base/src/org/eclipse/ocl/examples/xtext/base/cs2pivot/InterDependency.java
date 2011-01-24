/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
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
 * $Id: InterDependency.java,v 1.2 2011/01/24 21:00:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.cs2pivot;

import java.util.ArrayList;
import java.util.List;

public class InterDependency<T> extends AbstractDependency<Object>
{
	private Dependency dependency;
	private List<T> dependencies = new ArrayList<T>();
	private List<T> satisfied = new ArrayList<T>();
	
	public InterDependency(String reason, Dependency dependency) {
		super(reason);
		this.dependency = dependency;
	}

	public void addDependency(T dependency) {
		assert satisfied.isEmpty();
		assert !dependencies.contains(dependency);
		dependencies.add(dependency);
	}
	
	@Override
	public boolean canExecute() {
		if ((dependency != null) && !dependency.canExecute()) {
			return false;
		}
		return satisfied.size() >= dependencies.size();
	}
	
	public void setSatisfied(T dependency) {
		assert dependencies.contains(dependency);
		assert !satisfied.contains(dependency);
		satisfied.add(dependency);
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append(super.toString());
		if ((dependency != null) && !dependency.canExecute()) {
			s.append(" BLOCKED");
		}
		s.append(" ");
		s.append(satisfied.size());
		s.append("/");
		s.append(dependencies.size());
		return s.toString();
	}	
}