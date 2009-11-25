/**
 * 
 */
package de.hpi.sam.bp2009.testframework.result;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author tobias.hoppe
 *
 */
public interface Result {
	public boolean add(Resource resource, Object generatorOptions, Object operatorOptions, long l, LinkedHashMap<Long, Long> memoryUsage);
	public void show();
}
