/***********************************************************************
 * Copyright (c) 2009 Anyware Technologies
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Jacques Lescot (Anyware Technologies) - initial API and implementation
 *
 * $Id: INavigationListener.java,v 1.1 2009/03/19 14:35:15 jlescot Exp $
 **********************************************************************/
package org.eclipse.emf.ecoretools.diagram.part;

import org.eclipse.gmf.runtime.notation.Diagram;


/**
 * Listener that are notified of navigation events
 * 
 * @author <a href="mailto:jacques.lescot@anyware-tech.com">Jacques LESCOT</a>
 */
public interface INavigationListener
{
    /**
     * Method called when the current diagram changes
     * @param newDiagram
     */
    void diagramChanged(Diagram newDiagram);
}
