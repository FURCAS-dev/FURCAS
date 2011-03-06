/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
 * $Id: ConsoleContext.java,v 1.3 2011/03/05 18:17:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.model;

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;

public interface ConsoleContext extends IDocument
{
//	ModelingLevel getModelingLevel();
	EObject getOCLContext();
//	IOCLFactory<Object> getOCLFactory();
	Map<String, EClassifier> getOCLParameters();
//	void setModelingLevel(ModelingLevel level);
	void setContext(EClassifier context, Map<String, EClassifier> parameters);
}