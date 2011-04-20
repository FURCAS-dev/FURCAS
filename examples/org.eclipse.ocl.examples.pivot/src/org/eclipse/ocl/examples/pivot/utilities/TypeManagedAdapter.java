/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: TypeManagedAdapter.java,v 1.1 2011/04/20 19:02:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import org.eclipse.emf.common.notify.Adapter;

public interface TypeManagedAdapter extends Adapter.Internal
{		
	void dispose();
	boolean isAdapterFor(TypeManager typeManager);
}