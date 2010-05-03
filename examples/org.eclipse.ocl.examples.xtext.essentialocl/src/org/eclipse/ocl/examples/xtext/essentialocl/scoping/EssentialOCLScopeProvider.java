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
 * $Id: EssentialOCLScopeProvider.java,v 1.2 2010/05/03 05:38:02 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.essentialocl.scoping;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.scope.AbstractScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.BaseScopeProvider;
import org.eclipse.ocl.examples.xtext.base.scoping.DefaultScopeAdapter;
import org.eclipse.ocl.examples.xtext.base.scoping.EmptyScopeAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ArrowExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.BooleanLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.CollectionLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.DotExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InfixExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvalidLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.LetExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NestedExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NullLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.NumberLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.PathNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.RoundBracketExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SelfExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.SimpleNameExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.StringLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.TupleLiteralExpCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.VariableCS;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.util.EssentialOCLCSTSwitch;
import org.eclipse.ocl.examples.xtext.oclstdlib.scoping.OCLstdlibScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class EssentialOCLScopeProvider extends OCLstdlibScopeProvider
{
	static {
		AbstractScopeAdapter.addSwitch(EssentialOCLCSTPackage.eINSTANCE, new EssentialOCLScopeSwitch());
	}
	
	public static class EssentialOCLScopeSwitch
		extends EssentialOCLCSTSwitch<AbstractScopeAdapter<? extends EObject>>
		implements AbstractScopeAdapter.ISwitch
	{	
		@Override
		public AbstractScopeAdapter<? extends EObject> caseArrowExpCS(ArrowExpCS eObject) {
			return new ArrowExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseBooleanLiteralExpCS(BooleanLiteralExpCS eObject) {
			return new BooleanLiteralExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseCollectionLiteralExpCS(CollectionLiteralExpCS eObject) {
			return new CollectionLiteralExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseDotExpCS(DotExpCS eObject) {
			return new DotExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseInfixExpCS(InfixExpCS eObject) {
			return new InfixExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseInvalidLiteralExpCS(InvalidLiteralExpCS eObject) {
			return new InvalidLiteralExpScopeAdapter(eObject);
		}

		@Override
		public LetExpScopeAdapter caseLetExpCS(LetExpCS eObject) {
			return new LetExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseNestedExpCS(NestedExpCS eObject) {
			return new NestedExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseNullLiteralExpCS(NullLiteralExpCS eObject) {
			return new NullLiteralExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseNumberLiteralExpCS(NumberLiteralExpCS eObject) {
			return new NumberLiteralExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> casePathNameExpCS(PathNameExpCS eObject) {
			return new PathNameExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseRoundBracketExpCS(RoundBracketExpCS eObject) {
			EObject container = eObject.eContainer();
			if (container instanceof DotExpCS)
				return new DotOperationCallExpScopeAdapter(eObject);
			else if (container instanceof ArrowExpCS)
				return new ArrowOperationCallExpScopeAdapter(eObject);
			else
				return null;
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseSelfExpCS(SelfExpCS eObject) {
			return new SelfExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseSimpleNameExpCS(SimpleNameExpCS eObject) {
			return new SimpleNameExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseStringLiteralExpCS(StringLiteralExpCS eObject) {
			return new StringLiteralExpScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<? extends EObject> caseTupleLiteralExpCS(TupleLiteralExpCS eObject) {
			return new TupleLiteralExpScopeAdapter(eObject);
		}

		@Override
		public VariableScopeAdapter caseVariableCS(VariableCS eObject) {
			return new VariableScopeAdapter(eObject);
		}

		@Override
		public AbstractScopeAdapter<?> defaultCase(EObject eObject) {
			return new DefaultScopeAdapter((ElementCS) eObject);
		}

		public AbstractScopeAdapter<?> doInPackageSwitch(EObject eObject) {
			return doSwitch(eObject.eClass(), eObject);
		}
	}
}
