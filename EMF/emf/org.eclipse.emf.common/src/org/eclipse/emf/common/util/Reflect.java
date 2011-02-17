/**
 * <copyright>
 *
 * Copyright (c) 2010-2011 Ed Merks and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: 
 *   Ed Merks - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Reflect.java,v 1.1 2011/01/17 19:50:26 emerks Exp $
 */
package org.eclipse.emf.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class for helping implement reflective capabilities not available with Google Widget Toolkit,
 * i.e., specifically the ability to {@link Class#isInstance(Object) instance test} and to {@link Array#newInstance(Class, int) create typed arrays}.
 * This is provided in the regular core runtime only to support single sourcing of generated client models that are also targeting the EMF GWT runtime.
 * @since 2.7
 */
public final class Reflect
{
  /**
   * A global registry of helper instances.
   */
  static final Map<Class<?>, Helper> HELPER_REGISTRY = new HashMap<Class<?>, Reflect.Helper>();

  /**
   * An interface implemented by reflective helpers.
   */
  public interface Helper
  {
    /**
     * Do an {@link Class#isInstance(Object) instanceof test}.
     */
    boolean isInstance(Object instance);

    /**
     * Create a {@link Array#newInstance(Class, int) typed array}.
     */
    Object newArrayInstance(int size);
  }
  
  /**
   * Register a helper for the given class.
   */
  public static void register(Class<?> class_, Helper helper)
  {
    HELPER_REGISTRY.put(class_, helper);
  }

  /**
   * Do an {@link Class#isInstance(Object) instanceof test}.
   */
  public static boolean isInstance(Class<?> class_, Object instance)
  {
    Helper helper = HELPER_REGISTRY.get(class_);
    if (helper != null)
    {
      return helper.isInstance(instance);
    }
    else
    {
      return class_.isInstance(instance);
    }
  }
}
