/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 Eclipse Modeling Project and others.
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
 * $Id: OCLTextProvider.java,v 1.1 2010/03/11 14:52:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.editor.ocl.ui.imp;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.examples.editor.util.TextProvider;
import org.eclipse.ocl.expressions.OCLExpression;

public class OCLTextProvider implements TextProvider
{
	public String getText(Object object) {
		if (object instanceof OperationCallExp) {
			OperationCallExp operationCallExp = (OperationCallExp) object;
			OCLExpression<EClassifier> source = operationCallExp.getSource();
			if (source == null)
				return "";
			EClassifier type = source.getType();
			if (type instanceof CollectionType)
				return "->";
			else
				return ".";
		}
		return null;
	}
}
