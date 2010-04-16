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
 * $Id: CompleteOCLLabelProvider.java,v 1.2 2010/04/16 18:16:19 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.ClassifierContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.OperationContextDeclCS;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.PropertyContextDeclCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameCS;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class CompleteOCLLabelProvider extends DefaultEObjectLabelProvider {

	@Inject
	public CompleteOCLLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	public String text(ClassifierContextDeclCS ele) {
		PathNameCS contextName = ele.getContextName();
		StringBuffer s = new StringBuffer();
		appendPathName(s, contextName);
		return s.toString();
	}

	protected void appendPathName(StringBuffer s, PathNameCS pathName) {
		for (SimpleNameCS simpleName : pathName.getSimpleNames()) {
			if (s.length() > 0) {
				s.append("::");
			}
			s.append(simpleName.getValue());
		}
	}

	public String text(DocumentCS ele) {
		return "OclInEcore document";
	}

	public String text(OperationContextDeclCS ele) {
		PathNameCS contextName = ele.getContextName();
		StringBuffer s = new StringBuffer();
		appendPathName(s, contextName);
		s.append("()");
		return s.toString();
	}

	public String text(PropertyContextDeclCS ele) {
		PathNameCS contextName = ele.getContextName();
		StringBuffer s = new StringBuffer();
		appendPathName(s, contextName);
		return s.toString();
	}

/*
	//Labels and icons can be computed like this:
	
	String text(MyModel ele) {
	  return "my "+ele.getName();
	}
	 
    String image(MyModel ele) {
      return "MyModel.gif";
    }
*/
}
