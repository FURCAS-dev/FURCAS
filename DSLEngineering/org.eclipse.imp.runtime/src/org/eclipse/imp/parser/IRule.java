/*******************************************************************************
* Copyright (c) 2007 IBM Corporation.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*    Robert Fuhrer (rfuhrer@watson.ibm.com) - initial API and implementation

*******************************************************************************/

package org.eclipse.imp.parser;

/*
 * Licensed Materials - Property of IBM,
 * (c) Copyright IBM Corp. 1998, 2004  All Rights Reserved
 */

/**
 * @author Claffra
 * 
 */
public interface IRule {
    public abstract String getLeftHandSide();

    public abstract int getSize();

    public abstract int getNumber();

    public abstract String getRightHandSide(int n);

    public abstract boolean isTerminal(int rhsNumber);
}