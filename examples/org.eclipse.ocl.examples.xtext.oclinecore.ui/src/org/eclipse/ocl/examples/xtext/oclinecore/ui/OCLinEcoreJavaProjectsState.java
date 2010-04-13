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
 * $Id: OCLinEcoreJavaProjectsState.java,v 1.1 2010/04/13 06:41:28 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.ui;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.xtext.ui.containers.JavaProjectsState;

public class OCLinEcoreJavaProjectsState extends JavaProjectsState
{
	@Override
	protected IPackageFragmentRoot getPackageFragmentRoot(URI uri) {
		if (uri.isArchive()) {
			return getJarWithEntry(uri);
		}
		String platformString = uri.toPlatformString(true);
		if (platformString == null) {
			return null;
		}
		final IFile file = getWorkspaceRoot().getFile(new Path(platformString));
		if (file == null) {
			return getJarWithEntry(uri);
		}
		IPackageFragmentRoot root = getJavaElement(file);
		if (root == null)
			return getJarWithEntry(uri);
		return root;
	}

}
