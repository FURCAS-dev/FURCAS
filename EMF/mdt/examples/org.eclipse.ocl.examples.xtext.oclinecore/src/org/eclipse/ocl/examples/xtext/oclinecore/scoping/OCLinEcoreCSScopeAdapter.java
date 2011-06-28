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
 * $Id: OCLinEcoreCSScopeAdapter.java,v 1.3 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.scoping;

import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.essentialocl.scoping.EssentialOCLCSScopeAdapter;

public class OCLinEcoreCSScopeAdapter<CS extends MonikeredElementCS, P extends MonikeredElement> extends EssentialOCLCSScopeAdapter<CS, P>
{
	public OCLinEcoreCSScopeAdapter(TypeManager typeManager, CS csElement, Class<P> pivotClass) {
		super(typeManager, csElement, pivotClass);
	}
	
}
