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
 * $Id: ElementValue.java,v 1.3 2011/03/12 13:21:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.values;

import org.eclipse.ocl.examples.pivot.Element;

public interface ElementValue<E extends Element> extends ObjectValue
{
	E getElement();
}
