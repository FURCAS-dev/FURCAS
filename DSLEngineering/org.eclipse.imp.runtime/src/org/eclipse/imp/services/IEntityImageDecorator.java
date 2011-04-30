/*******************************************************************************
* Copyright (c) 2009 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation
*******************************************************************************/
package org.eclipse.imp.services;


public interface IEntityImageDecorator {
    /**
     * @return an array containing DecorationDescriptors for all possible decoration attributes
     */
    public DecorationDescriptor[] getAllDecorations();

    /**
     * @return a bit-wise OR of the decoration attributes for the given entity.
     * The implementation is free to define the set of valid attributes,
     * though their range is restricted to what will fit in a 32-bit int.
     */
    int getDecorationAttributes(Object entity);
}