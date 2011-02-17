/**
 * <copyright> 
 *
 * Copyright (c) 2002-2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: CommandStackListener.java,v 1.3 2005/06/08 05:44:08 nickb Exp $
 */
package org.eclipse.emf.common.command;


import java.util.EventObject;


/**
 * A listener to a {@link org.eclipse.emf.common.command.CommandStack}.
 */ 
public interface CommandStackListener
{
  /**
   * Called when the {@link org.eclipse.emf.common.command.CommandStack}'s state has changed.
   * @param event the event.
   */
  void commandStackChanged(EventObject event);
}
