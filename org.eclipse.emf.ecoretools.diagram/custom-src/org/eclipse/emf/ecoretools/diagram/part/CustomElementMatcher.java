/***********************************************************************
 * Copyright (c) 2008 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Anyware Technologies - initial API and implementation
 *
 * $Id: CustomElementMatcher.java,v 1.5 2008/04/28 08:41:33 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

/**
 * Initializes the EcoreToolsClientContext <br>
 * creation : 17 avr. 2008
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class CustomElementMatcher implements IElementMatcher {

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.IElementMatcher#matches(org.eclipse.emf.ecore.EObject)
	 */
	public boolean matches(EObject object) {
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(object);
		if (domain == null) {
			return false;
		}
		String id = domain.getID();
		if ((id == null) || (id != null && id.length() < 2)) {
			return false;
		}
		int endString = id.indexOf(EcoreDocumentProvider.id_separator);
		String domainBaseID = id.substring(0, (endString > 0) ? endString : 1);
		if (EcoreDocumentProvider.editingDomainBaseID.equals(domainBaseID)) {
			return true;
		}
		return false;
	}

}
