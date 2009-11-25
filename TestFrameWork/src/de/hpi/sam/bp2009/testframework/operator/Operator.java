/**
 * 
 */
package de.hpi.sam.bp2009.testframework.operator;

import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.testframework.OptionObject;

/**
 * @author tobias.hoppe
 *
 */
public interface Operator {
	
	public Resource execute(Resource resource, Object option);
	public Class<? extends OptionObject> getOptionObjectClass();

}
