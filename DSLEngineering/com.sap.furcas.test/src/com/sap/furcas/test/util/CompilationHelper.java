/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.test.util;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;

public class CompilationHelper {

    public static String getSourceRoot(Class<?> c) {
        try {
            String classContainerPath = URLDecoder.decode(c
                    .getProtectionDomain().getCodeSource().getLocation()
                    .getPath(), "UTF-8");
            if (!classContainerPath.endsWith(".jar")) {
                classContainerPath += "bin/";
            }

            return new File(classContainerPath).getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
}
