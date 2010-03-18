/*******************************************************************************
 * Copyright (c) 2008 ikv++ technologies ag and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     ikv++ technologies ag - initial API and implementation
 *******************************************************************************/

package de.ikv.medini.ocl.test.util;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.ikv.medini.ocl.test.OCLTestAdapter;

public class Utilities {

	public static Collection asArrayList(Object value) {
		Collection list = new ArrayList();
		for (int i = 0; i < Array.getLength(value); i++) {
			list.add(Array.get(value, i));
		}
		return list;
	}

	public static String capitalize(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	public static boolean areCollectionsEqual(Collection c1, Collection c2) {
		return c1.containsAll(c2) && c2.containsAll(c1);
	}

	public static boolean areIdentitiesEqual(Collection c1, Collection c2, OCLTestAdapter adapter) {
		Collection c1identities = Utilities.getIdentities(c1, adapter);
		Collection c2identities = Utilities.getIdentities(c2, adapter);
		return Utilities.areCollectionsEqual(c1identities, c2identities);
	}

	public static Collection getIdentities(Collection c, OCLTestAdapter adapter) {
		List result = new ArrayList();
		for (Object o : c) {
			result.add(adapter.getIdentityObject(o));
		}
		return result;
	}

	public static void recursiveRemoveDir(File directory) {
		String[] filelist = directory.list();
		File tmpFile = null;
		if(filelist != null) {
        		for (String element : filelist) {
        			tmpFile = new File(directory.getAbsolutePath(), element);
        			if (tmpFile.isDirectory()) {
        				Utilities.recursiveRemoveDir(tmpFile);
        			} else if (tmpFile.isFile()) {
        				tmpFile.delete();
        			}
        		}
        		directory.delete();
		}
	}
}
