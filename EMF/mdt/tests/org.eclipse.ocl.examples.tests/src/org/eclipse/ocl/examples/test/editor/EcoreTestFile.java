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
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: EcoreTestFile.java,v 1.3 2010/04/25 06:50:09 ewillink Exp $
 */
package org.eclipse.ocl.examples.test.editor;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

public interface EcoreTestFile
{
	EClass createEClass(EPackage ePackage, String name);

	EPackage createEPackage(EPackage parentPackage, String name);

}
