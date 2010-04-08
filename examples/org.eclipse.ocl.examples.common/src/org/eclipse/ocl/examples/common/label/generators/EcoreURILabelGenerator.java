/**
 * <copyright>
 * 
 * Copyright (c) 2008,2010 E.D.Willink and others.
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
 * $Id: EcoreURILabelGenerator.java,v 1.2 2010/04/08 06:27:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.common.label.generators;

import org.eclipse.emf.common.util.URI;
import org.eclipse.ocl.examples.common.label.AbstractLabelGenerator;

public final class EcoreURILabelGenerator extends AbstractLabelGenerator<URI>
{
	public static void initialize(Registry registry) {
		registry.install(URI.class, new EcoreURILabelGenerator());		
	}
	
	public EcoreURILabelGenerator() {
		super(URI.class);
	}

	public void buildLabelFor(Builder labelBuilder, URI object) {
		labelBuilder.appendString(object.toString());
	}
}