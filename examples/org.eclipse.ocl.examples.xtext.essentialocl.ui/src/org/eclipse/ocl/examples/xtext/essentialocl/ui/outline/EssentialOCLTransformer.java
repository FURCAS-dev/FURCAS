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
 * $Id: EssentialOCLTransformer.java,v 1.3 2010/05/22 19:02:22 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.ui.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionTypeCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SquareBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.ui.outline.OCLstdlibTransformer;

/**
 * customization of the default outline structure
 * 
 */
public class EssentialOCLTransformer extends OCLstdlibTransformer
{
	public List<EObject> getChildren(CollectionLiteralExpCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getCollectionLiteralParts());
		return contents;
	}
	
	public List<EObject> getChildren(CollectionTypeCS csElement) {
		return NO_CHILDREN;
	}
		
	public List<EObject> getChildren(InfixExpCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContent(contents, csElement.getSource());
		String op = csElement.getOp();
		ExpCS argument = csElement.getArgument();
		if (".".equals(op) || "->".equals(op)) {
			if (argument instanceof RoundBracketExpCS) {
				addContents(contents, ((RoundBracketExpCS)argument).getArguments());
			}
			else if (argument instanceof SquareBracketExpCS) {
				addContents(contents, ((SquareBracketExpCS)argument).getArguments());
			}
			else {
				addContent(contents, argument);
			}
		}
		else {
			addContent(contents, argument);
		}
		return contents;
	}

	public List<EObject> getChildren(LetExpCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getVariable());
		addContent(contents, csElement.getIn());
		return contents;
	}

	public List<EObject> getChildren(RoundBracketExpCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContent(contents, csElement.getVariable1());
		addContent(contents, csElement.getVariable2());
		addContents(contents, csElement.getArguments());
		return contents;
	}

	public List<EObject> getChildren(SquareBracketExpCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContents(contents, csElement.getArguments());
		return contents;
	}
		
	public List<EObject> getChildren(VariableCS csElement) {
		List<EObject> contents = new ArrayList<EObject>();
		addContent(contents, csElement.getInitExpression());
		return contents;
	}
}
