package com.sap.mi.tools.cockpit.editor.model;

import java.util.Comparator;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * Compares partitions with containers. Not suitable for comparing containers
 * (folders).
 * 
 * @author d003456
 * 
 */
public class ComparatorForPartitions implements Comparator<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(String o1, String o2) {

		if (o1 == o2 || o1.equals(o2)) {
			return 0;
		}

		if (o1 == null) {
			return -1;
		} else if (o2 == null) {
			return 1;
		}

		IPath p1 = new Path(o1);
		IPath p2 = new Path(o2);

		int p1Segs = p1.segmentCount();
		int p2Segs = p2.segmentCount();

		int matchedSegs = p1.matchingFirstSegments(p2);

		int res = -999999;
		//
		// p1 = { 1 / 2 / 3 / 4 / 5 }
		// p2 = { 1 / 2 / 3 / 4 }
		// or
		// p1 = { 1 / 2 / 3 / 4 / 5 }
		// p2 = { 1 / 2 / 3 / 6 }
		// p1 > p2
		//
		if (matchedSegs == p2Segs && p1Segs > matchedSegs || matchedSegs == p2Segs - 1 && p1Segs > p2Segs) {
			res = 1;
		}
		//
		// p1 = { 1 / 2 / 3 / 4 }
		// p2 = { 1 / 2 / 3 / 4 / 5 }
		// or
		// p1 = { 1 / 2 / 3 / 6}
		// p2 = { 1 / 2 / 3 / 4 / 5}
		// p1 < p2
		//
		else if (matchedSegs == p1Segs && p2Segs > matchedSegs || matchedSegs == p1Segs - 1 && p2Segs > p1Segs) {
			res = -1;
		}
		//
		// p1 = { 1 / 2 / 8 / 4 / 5}
		// p2 = { 1 / 2 / 3 / 4 / 5 }
		// p1 > p2
		//
		else if (matchedSegs < p1Segs && matchedSegs < p2Segs || matchedSegs == 1 && (p1Segs == 1 && p2Segs == 1)) {
			res = p1.segment(matchedSegs).compareTo(p2.segment(matchedSegs));
		}
		//
		// this should never happen
		//
		else if (res == -999999) {
			throw new IllegalStateException("String \"" + o1 + "\" and string \"" + o2 + "\" could not be compared"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}

		return res;
	}

}
