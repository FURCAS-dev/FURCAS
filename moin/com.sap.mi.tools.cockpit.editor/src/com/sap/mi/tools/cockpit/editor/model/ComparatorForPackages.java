package com.sap.mi.tools.cockpit.editor.model;

import java.util.Comparator;
import java.util.List;

/**
 * @author d003456
 *
 */
public class ComparatorForPackages implements Comparator<List<String>> {

	public int compare(List<String> o1, List<String> o2) {
		String str1 = ""; //$NON-NLS-1$
		String str2 = ""; //$NON-NLS-1$
		for (String string : o1) {
			str1 = str1 + string;
		}
		for (String string2 : o2) {
			str2 = str2 + string2;
		}
		return str1.compareTo(str2);
	}

}
