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
 * $Id: CompleteOCLLabelProvider.java,v 1.4 2010/05/09 10:37:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.labeling;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.ocl.examples.xtext.completeocl.completeOCLCST.CompleteOCLDocumentCS;
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

//	public String text(ClassifierContextDeclCS ele) {
//		return ele.getClassifier().getName();
//		PathNameCS contextName = ele.getClassifier().getName();
//		StringBuffer s = new StringBuffer();
//		appendPathName(s, contextName);
//		return s.toString();
//	}

	public String text(CompleteOCLDocumentCS ele) {
		return "OclInEcore document";
	}

//	public String text(OperationContextDeclCS ele) {
//		return ele.getOperation().getName();
//		PathNameCS contextName = ele.getContextName();
//		StringBuffer s = new StringBuffer();
//		appendPathName(s, contextName);
//		s.append("()");
//		return s.toString();
//	}

//	public String text(PropertyContextDeclCS ele) {
//		return ele.getProperty().getName();
//		PathNameCS contextName = ele.getContextName();
//		StringBuffer s = new StringBuffer();
//		appendPathName(s, contextName);
//		return s.toString();
//	}

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
