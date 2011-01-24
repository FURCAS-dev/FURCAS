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
 * $Id: EssentialOCLCS2Pivot.java,v 1.2 2011/01/24 21:31:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.cs2pivot;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BaseCS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2Pivot;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.scope.ScopeCSAdapter;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;


public class EssentialOCLCS2Pivot extends BaseCS2Pivot
{	
	private static final class Factory implements CS2Pivot.Factory
	{
		private Factory() {
			BaseCS2Pivot.FACTORY.getClass();
			CS2Pivot.addFactory(this);
		}

		public EssentialOCLLeft2RightVisitor createLeft2RightVisitor(CS2PivotConversion converter) {
			return new EssentialOCLLeft2RightVisitor(converter);
		}

		public EssentialOCLPostOrderVisitor createPostOrderVisitor(CS2PivotConversion converter) {
			return new EssentialOCLPostOrderVisitor(converter);
		}

		public EssentialOCLPreOrderVisitor createPreOrderVisitor(CS2PivotConversion converter) {
			return new EssentialOCLPreOrderVisitor(converter);
		}

		public BaseCSVisitor<ScopeCSAdapter, TypeManager> createScopeVisitor(TypeManager typeManager) {
			return new EssentialOCLScopeVisitor(typeManager);
		}

		public EPackage getEPackage() {
			return EssentialOCLCSTPackage.eINSTANCE;
		}
	}

	public static CS2Pivot.Factory FACTORY = new Factory();
		
	public EssentialOCLCS2Pivot(Map<? extends Resource, ? extends Resource> cs2pivotResourceMap, TypeManager typeManager) {
		super(cs2pivotResourceMap, typeManager);
	}
}
