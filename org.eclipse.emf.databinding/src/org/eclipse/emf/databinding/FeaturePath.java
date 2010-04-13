/**
 * <copyright> 
 *
 * Copyright (c) 2009 BestSolution.at and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   Tom Schindl <tom.schindl@bestsolution.at> - port to EMF in 262160
 * </copyright>
 *
 * $Id: FeaturePath.java,v 1.1 2009/05/23 11:11:33 tschindl Exp $
 */
package org.eclipse.emf.databinding;

import org.eclipse.emf.ecore.EStructuralFeature;


/**
 * <p><b>PROVISIONAL:</b> This API is subject to arbitrary change, including renaming or removal.</p>
 * 
 * Encapsulate a path to features also known as nested feature like person.name
 * 
 * @since 2.5
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public class FeaturePath
{
  private EStructuralFeature[] featurePath;

  private FeaturePath(EStructuralFeature[] featurePath)
  {
    this.featurePath = featurePath;
  }

  /**
   * @return the path to the feature from the local position
   */
  public EStructuralFeature[] getFeaturePath()
  {
    return featurePath;
  }

  /**
   * Create a feature path from the list of given features
   * 
   * @param featurePath
   *            the list of feature to go from the local instance to the
   *            requested instance
   * @return the path constructed
   */
  public static FeaturePath fromList(EStructuralFeature... featurePath)
  {
    return new FeaturePath(featurePath);
  }
}
