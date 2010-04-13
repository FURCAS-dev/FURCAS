/**
 * <copyright> 
 *
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   IBM Corporation - initial API and implementation
 * </copyright>
 *
 * $Id: Util.java,v 1.1 2009/05/23 11:11:33 tschindl Exp $
 */
package org.eclipse.emf.databinding.internal;

/**
 * <p><b>PROVISIONAL:</b> This API is subject to arbitrary change, including renaming or removal.</p>
 * 
 * @since 2.5
 */
public class Util
{

  /**
   * Checks whether the two objects are <code>null</code> -- allowing for
   * <code>null</code>.
   * 
   * @param left
   *            The left object to compare; may be <code>null</code>.
   * @param right
   *            The right object to compare; may be <code>null</code>.
   * @return <code>true</code> if the two objects are equivalent;
   *         <code>false</code> otherwise.
   */
  public static final boolean equals(final Object left, final Object right)
  {
    return left == null ? right == null : ((right != null) && left.equals(right));
  }
}
