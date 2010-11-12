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
 * $Id: CompleteOCLDescriptionLabelProvider.java,v 1.1 2010/04/13 06:36:41 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.completeocl.ui.labeling;

import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;

/**
 * Provides labels for a IEObjectDescriptions and IResourceDescriptions.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class CompleteOCLDescriptionLabelProvider extends DefaultDescriptionLabelProvider {

/*
	//Labels and icons can be computed like this:
	
	String text(IEObjectDescription ele) {
	  return "my "+ele.getName();
	}
	 
    String image(IEObjectDescription ele) {
      return ele.getEClass().getName() + ".gif";
    }	 
*/

}
