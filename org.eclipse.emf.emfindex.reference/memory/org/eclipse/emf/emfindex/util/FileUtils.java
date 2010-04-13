/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.emfindex.util;

import java.io.File;

/**
 * @author koehnlein
 *
 */
public class FileUtils {

	public static void deleteRecursively(File file) {
		if(file.isDirectory()) {
			for(File child: file.listFiles()) {
				deleteRecursively(child);
			}
		}
		file.delete();
	}
}
