/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex;

import org.eclipse.emf.emfindex.internal.LoggerImpl;
import org.eclipse.emf.emfindex.query.DefaultQueryExecutorStrategyInitializer;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryExecutorImpl;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorWithStrategies;
import org.eclipse.emf.emfindex.store.IndexUpdater;
import org.eclipse.emf.emfindex.store.IndexUpdaterImpl;
import org.eclipse.emf.emfindex.store.UpdateableIndex;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

/**
 * @author koehnlein
 */
public class EmfIndexModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(IndexInitializer.class).asEagerSingleton();
		bind(Index.class).to(UpdateableIndex.class);
		bind(UpdateableIndex.class).to(MemoryIndexImpl.class).in(Scopes.SINGLETON);
		bind(QueryExecutor.class).to(QueryExecutorImpl.class);
		bind(QueryExecutorWithStrategies.class).to(QueryExecutorImpl.class);
		bind(IndexUpdater.class).to(IndexUpdaterImpl.class);
		bindRuntimeSpecific();
	}

	protected void bindRuntimeSpecific() {
		bind(Logger.class).to(LoggerImpl.class);
		bind(DefaultQueryExecutorStrategyInitializer.class).asEagerSingleton();
	}

}
