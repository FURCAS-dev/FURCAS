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
 * $Id: OCLinEcorePivot2CS.java,v 1.3 2011/01/24 22:28:40 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.pivot2cs;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.BaseReferenceVisitor;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CS;
import org.eclipse.ocl.examples.xtext.base.pivot2cs.Pivot2CSConversion;
import org.eclipse.ocl.examples.xtext.essentialocl.pivot2cs.EssentialOCLPivot2CS;


public class OCLinEcorePivot2CS extends EssentialOCLPivot2CS
{	
	private static final class Factory implements Pivot2CS.Factory
	{
		private Factory() {
			EssentialOCLPivot2CS.FACTORY.getClass();
			Pivot2CS.addFactory(this);
		}

		public OCLinEcoreDeclarationVisitor createDeclarationVisitor(Pivot2CSConversion converter) {
			return new OCLinEcoreDeclarationVisitor(converter);
		}

		public BaseReferenceVisitor createReferenceVisitor(Pivot2CSConversion converter) {
			return new BaseReferenceVisitor(converter);
		}

		public EClass[] getEClasses() {
			return new EClass[]{ PivotPackage.Literals.CONSTRAINT };
		}
	}

	public static Pivot2CS.Factory FACTORY = new Factory();
		
	public OCLinEcorePivot2CS(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, TypeManager typeManager) {
		super(cs2pivotResourceMap, typeManager);
	}
}
