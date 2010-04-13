/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import static org.eclipse.emf.emfindex.util.StringUtils.concat;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.emfindex.Index;
import org.eclipse.emf.emfindex.Logger;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorStrategy;
import org.eclipse.emf.emfindex.query.spi.QueryExecutorWithStrategies;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author koehnlein
 */
@Singleton
public class QueryExecutorImpl implements QueryExecutorWithStrategies {

	private static final String CAN_EXECUTE_METHOD_NAME = "canExecute";

	private List<QueryExecutorStrategy<?, ?, ?>> strategies;

	@Inject
	private Logger logger;
	
	private Index index;
	
	@Inject
	public QueryExecutorImpl(Index index) {
		this.strategies = new ArrayList<QueryExecutorStrategy<?,?,?>>();
		this.index = index;
	}
	
	@SuppressWarnings("unchecked")
	public <DescriptorType, QueryType extends Query<DescriptorType>, IndexType> QueryResult<DescriptorType> execute(
			QueryType query) {
		QueryExecutorStrategy<DescriptorType, QueryType, IndexType> strategy = findMatchingStrategy(query, (IndexType) index);
		if (strategy != null) {
			return strategy.execute(query, (IndexType) index);
		}
		throw new IllegalStateException(concat("No strategy for query: ", query, "   index: ", index));
	}

	@SuppressWarnings("unchecked")
	private <DescriptorType, QueryType extends Query<DescriptorType>, IndexType> QueryExecutorStrategy<DescriptorType, QueryType, IndexType> findMatchingStrategy(
			Query<DescriptorType> query, IndexType index) {
		for (QueryExecutorStrategy<?, ?, ?> strategy : strategies) {
			Class<? extends QueryExecutorStrategy> strategyClass = strategy.getClass();
			Method[] methods = strategyClass.getMethods();
			for (Method method : methods) {
				if (!Modifier.isAbstract(method.getModifiers()) && method.getName().equals(CAN_EXECUTE_METHOD_NAME)) {
					try {
						Type[] parameterTypes = method.getGenericParameterTypes();
						if (parameterTypes.length == 2 && isMatchingParameterType(parameterTypes[0], query.getClass())
								&& isMatchingParameterType(parameterTypes[1], index.getClass())
								&& method.getReturnType().equals(Boolean.TYPE)) {
							Boolean canExecute;
							canExecute = (Boolean) method.invoke(strategy, new Object[] {query, index});
							if (canExecute)
								return (QueryExecutorStrategy<DescriptorType, QueryType, IndexType>) strategy;
						}
					} catch (Exception e) {
						logger.logError("Error resolving QueryExecutorStrategy", e);
					}
				}
			}
		}
		return null;
	}
	
	private boolean isMatchingParameterType(Type declaredType, Class<?> argumentType) {
		if(declaredType instanceof Class<?>) {
			Class<?> declaredClass = (Class<?>) declaredType;
			if(declaredClass.getTypeParameters().length == 0) 
				return declaredClass.isAssignableFrom(argumentType);
		}
		return false;
		
	}

	public void addQueryExecutorStrategy(
			QueryExecutorStrategy<?, ? extends Query<?>, ? extends Index> queryExecutorStrategy, int priority) {
		// TODO implement priorities
		strategies.add(queryExecutorStrategy);
		queryExecutorStrategy.init(this);
	}

	public void removeQueryExecutorStrategy(
			QueryExecutorStrategy<?, ? extends Query<?>, ? extends Index> queryExecutorStrategy, int priority) {
		// TODO implement priorities
		strategies.remove(queryExecutorStrategy);
	}

	public Index getIndex() {
		return index;
	}
}
