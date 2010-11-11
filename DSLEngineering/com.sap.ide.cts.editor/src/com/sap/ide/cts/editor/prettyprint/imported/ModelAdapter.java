/**
 * Copyright (c) 2008 INRIA.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     INRIA - initial API and implementation
 *
 * $Id: ModelAdapter.java,v 1.3 2008/06/25 12:48:35 fjouault Exp $
 */

package com.sap.ide.cts.editor.prettyprint.imported;

import java.util.Iterator;

/**
 * 
 * @author Fr�d�ric Jouault
 * @author Mika�l Barbero
 * 
 */
public interface ModelAdapter {

    public String getString(Object me, String propName);

    public boolean getBool(Object me, String propName);

    public boolean getBoolUndefinedIsFalse(Object me, String propName);

    public int getInt(Object me, String propName);

    public Iterator<?> getCol(Object me, String propName);

    public Object getME(Object me, String propName);

    public String getName(Object me);

    public String getEnumLiteralName(Object me);

    public Object get(Object me, String propName);

    public String getTypeName(Object me);

    public Object getMetaobject(Object me);

    public Object refImmediateComposite(Object me);

    public boolean isAModelElement(Object o);

    public boolean isPrimitive(Object value);

    public boolean isEnumLiteral(Object value);

    public String nextString(Iterator<?> i);

}
