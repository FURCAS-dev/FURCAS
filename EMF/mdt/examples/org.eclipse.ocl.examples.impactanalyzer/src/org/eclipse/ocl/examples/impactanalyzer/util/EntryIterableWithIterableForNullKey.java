/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.util;

import java.util.Map;

import org.eclipse.ocl.ecore.OperationCallExp;

public class EntryIterableWithIterableForNullKey implements Map.Entry<OperationCallExp, Iterable<AnnotatedEObject>> {
    private final Iterable<AnnotatedEObject> iterable;

    public EntryIterableWithIterableForNullKey(Iterable<AnnotatedEObject> iterable) {
        this.iterable = iterable;
    }

    public OperationCallExp getKey() {
        return null;
    }

    public Iterable<AnnotatedEObject> getValue() {
        return iterable;
    }

    public Iterable<AnnotatedEObject> setValue(Iterable<AnnotatedEObject> value) {
        throw new UnsupportedOperationException("setValue() not supported here");
    }
}
