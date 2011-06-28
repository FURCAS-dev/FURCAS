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
 * $Id: EssentialOCLPivot2CS.java,v 1.2 2011/01/24 21:31:46 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BasePivot2CS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseReferenceVisitor;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;


public class EssentialOCLPivot2CS extends BasePivot2CS
{	
	private static final class Factory implements Pivot2CS.Factory
	{
		private Factory() {
			BasePivot2CS.FACTORY.getClass();
			Pivot2CS.addFactory(this);
		}

		public EssentialOCLDeclarationVisitor createDeclarationVisitor(Pivot2CSConversion converter) {
			return new EssentialOCLDeclarationVisitor(converter);
		}

		public BaseReferenceVisitor createReferenceVisitor(Pivot2CSConversion converter) {
			return new BaseReferenceVisitor(converter);
		}

		public EClass[] getEClasses() {
			return new EClass[]{};
		}
	}

	public static Pivot2CS.Factory FACTORY = new Factory();
		
	public EssentialOCLPivot2CS(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, TypeManager typeManager) {
		super(cs2pivotResourceMap, typeManager);
	}
}
