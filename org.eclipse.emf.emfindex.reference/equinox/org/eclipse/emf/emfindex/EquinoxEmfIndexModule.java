/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import org.eclipse.emf.emfindex.internal.EquinoxLoggerImpl;
import org.eclipse.emf.emfindex.internal.QueryExecutorStrategyRegistryReader;

/**
 * @author koehnlein
 */
public class EquinoxEmfIndexModule extends EmfIndexModule {

	@Override
	protected void bindRuntimeSpecific() {
		bind(Logger.class).to(EquinoxLoggerImpl.class);
		bind(QueryExecutorStrategyRegistryReader.class).asEagerSingleton();
	}
}
