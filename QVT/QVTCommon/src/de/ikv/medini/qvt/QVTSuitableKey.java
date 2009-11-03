/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.qvt;

import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;

/**
 * Attributes a key to an object template. Instead of instantiating the object template's metaclass, the key is used to look up an existing instance.
 * 
 * @author kiegeland
 * 
 */
public class QVTSuitableKey {

	public QVTSuitableKey(Key key, ObjectTemplateExp template) {
		this.key = key;
		this.template = template;
	}

	private Key key;

	private ObjectTemplateExp template;

	/**
	 * 
	 */
	private boolean useOppositeProperty;

	public void setUseOppositeProperty(boolean b) {
		this.useOppositeProperty = b;
	}

	public Key getKey() {
		return this.key;
	}

	public boolean getUseOppositeProperty() {
		return this.useOppositeProperty;
	}

}
