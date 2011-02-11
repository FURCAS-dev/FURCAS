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
 * $Id: OCLstdlibCS2MonikerVisitor.java,v 1.3 2011/02/11 20:00:48 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclstdlib.utilities;

import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2Moniker;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.util.EssentialOCLCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.utilities.EssentialOCLCS2MonikerVisitor;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibClassCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.LibIterationCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.OCLstdlibCSTPackage;
import org.eclipse.ocl.examples.xtext.oclstdlib.oclstdlibCST.PrecedenceCS;
import org.eclipse.ocl.examples.xtext.oclstdlib.util.AbstractExtendingDelegatingOCLstdlibCSVisitor;

public class OCLstdlibCS2MonikerVisitor
	extends AbstractExtendingDelegatingOCLstdlibCSVisitor<Object, CS2Moniker, EssentialOCLCSVisitor<Object, CS2Moniker>>
	implements PivotConstants
{	
	private static final class Factory implements CS2Moniker.Factory
	{
		private Factory() {
			EssentialOCLCS2MonikerVisitor.FACTORY.getClass();
			CS2Moniker.addFactory(OCLstdlibCSTPackage.eINSTANCE, this);
		}
		
		public BaseCSVisitor<?, ?> create(CS2Moniker context) {
			return new OCLstdlibCS2MonikerVisitor(context);
		}
	}

	public static CS2Moniker.Factory FACTORY = new Factory();
		
	@SuppressWarnings("unchecked")
	public OCLstdlibCS2MonikerVisitor(CS2Moniker context) {
		super((EssentialOCLCSVisitor<Object, CS2Moniker>) context.getVisitor(EssentialOCLCSTPackage.eINSTANCE), context);
	}

	@Override
	public Object visitLibClassCS(LibClassCS object) {
		if (PrimitiveType.class.getSimpleName().equals(object.getMetaTypeName())) {
			context.appendNameCS(object);
			return true;
		}
		return super.visitLibClassCS(object);
	}

	@Override
	public Object visitLibIterationCS(LibIterationCS object) {
		context.appendParentCS(object, MONIKER_SCOPE_SEPARATOR);
		context.appendNameCS(object);
		context.appendTemplateParametersCS(object);
		context.appendParametersCS(object.getOwnedIterator(), object.getOwnedAccumulator(), object.getOwnedParameter());
		return true;
	}

	@Override
	public Object visitPrecedenceCS(PrecedenceCS object) {
		context.appendParentCS(object, PRECEDENCE_PREFIX);
		context.appendNameCS(object);
		return true;
	}
}
