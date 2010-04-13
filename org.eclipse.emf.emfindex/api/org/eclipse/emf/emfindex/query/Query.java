/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.emf.emfindex.query;


/**
 * A query that can be executed wihtin a {@link QueryCommand} using a
 * {@link QueryExecutor} returning a given {@link <DescriptorType>}.
 * 
 * Implementations of this class are usually plain data objects. The implementor
 * is responsible for providing an appropriate {@link QueryExecutorStrategy}
 * that defines the execution logic.
 * 
 * @author koehnlein
 */
public interface Query<DescriptorType> {

}
