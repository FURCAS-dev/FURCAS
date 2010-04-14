/**
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
 * $Id: EcoretoolsEditPolicyRoles.java,v 1.5 2008/04/28 15:23:59 jlescot Exp $
 */
package org.eclipse.emf.ecoretools.diagram.edit.policies;

/**
 * 
 * Creates an edit policy key to support custom synchronization behavior <br>
 * creation : 10 janv. 08
 * 
 * @author <a href="mailto:gilles.cannenterre@anyware-tech.com">Gilles
 *         Cannenterre</a>
 */
public class EcoretoolsEditPolicyRoles {

	/**
	 * Synchronization on removal Modifyin the semantic model will trigger a
	 * refresh that will only remove orphaned views.
	 */
	public static final String PSEUDO_CANONICAL_ROLE = "PseudoCanonical"; //$NON-NLS-1$

}
