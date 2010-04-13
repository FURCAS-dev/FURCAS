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
 * $Id: OCLinEcoreContainerStateProvider.java,v 1.1 2010/04/13 06:41:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;


public class OCLinEcoreContainerStateProvider implements IAllContainersState.Provider {

	private IAllContainersState containerState = new OCLinEcoreJavaProjectsState();

	public IAllContainersState get(IResourceDescriptions context) {
		return containerState;
	}

}