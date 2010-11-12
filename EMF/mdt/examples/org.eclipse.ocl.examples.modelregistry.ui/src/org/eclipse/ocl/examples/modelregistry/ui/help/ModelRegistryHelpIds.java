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
 * $Id: ModelRegistryHelpIds.java,v 1.2 2010/04/13 16:04:15 ewillink Exp $
 */
package org.eclipse.ocl.examples.modelregistry.ui.help;

public interface ModelRegistryHelpIds
{
	enum General {
		ACCESSOR_KIND,
		ACCESSOR_NAME,
		MODEL_URI,
		SERIALIZATION
	};
	enum PropertyPage {
		OVERVIEW,
		REMOVE,
		EDIT,
		ADD,
		TABLE
	};
	enum RegistrationDialog {
		OVERVIEW,
		BROWSE_WORKSPACE,
		BROWSE_REGISTERED_PACKAGES,
		BROWSE_FILE_SYSTEM
	};
}
