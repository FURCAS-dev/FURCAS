package de.hpi.sam.bp2009.solution.eventManager.tests.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

public class EventManagerHelper {
	public static <T> EList<T> getEListFor(T object){
		EList<T> r = new BasicEList<T>();
		r.add(object);
		return r;
	}
}
