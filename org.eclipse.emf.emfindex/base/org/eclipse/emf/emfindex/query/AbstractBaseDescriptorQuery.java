/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.query;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author koehnlein
 */
public abstract class AbstractBaseDescriptorQuery<DescriptorType> implements Query<DescriptorType>{

	private Map<String, Serializable> userDataEquals;
	
	public void setUserDataEquals(String key, Serializable value) {
		if(userDataEquals == null) {
			userDataEquals = new HashMap<String, Serializable>();
		}
		userDataEquals.put(key, value);
	}
	
	public Map<String, Serializable> getUserDataEquals() {
		return userDataEquals;
	}
	
}
