/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.store;

import java.io.IOException;

import org.eclipse.emf.emfindex.Index;

/**
 * An index that can be updated and persisted.
 * 
 * A CDO based implementation of the index would only support the {@link Index} interface, as queries would be mapped to
 * CDO queries and there is no need for doubling the information.
 * 
 * @author koehnlein
 */
public interface UpdateableIndex extends Index {

	void save() throws IOException;

	void load() throws IOException;

	<T> T executeUpdateCommand(UpdateCommand<T> updateCommand);

}
