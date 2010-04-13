/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/*
 * Created on 16.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;

/**
 * This interface stands for an attribute reference of a type.
 */
public interface TypeAttrReference extends TypeReference {

	String toString(int indent, StringBuilder accumSb);

	boolean isMultiValued();

	String getAttrName();

	SpiFqlPrimitiveType getAttrType();
}
