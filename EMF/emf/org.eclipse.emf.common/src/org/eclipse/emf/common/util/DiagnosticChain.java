/**
 * <copyright>
 *
 * Copyright (c) 2004 IBM Corporation and others.
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
 * $Id: DiagnosticChain.java,v 1.2 2005/06/08 06:19:08 nickb Exp $
 */
package org.eclipse.emf.common.util;

/**
 * An accumulator of diagnostics.
 */
public interface DiagnosticChain
{
  /**
   * Adds the diagnostic to the chain.
   */
  void add(Diagnostic diagnostic);

  /**
   * Adds the {@link Diagnostic#getChildren children} of the diagnostic to the chain.
   */
  void addAll(Diagnostic diagnostic);

  /**
   * If the diagnostic has {@link Diagnostic#getChildren children}, 
   * {@link #addAll add}s those children,
   * otherwise, {@link #add add}s the diagnostic. 
   */
  void merge(Diagnostic diagnostic);
}
