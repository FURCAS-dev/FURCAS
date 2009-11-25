/**
 * 
 */
package de.hpi.sam.bp2009.testframework.operator;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.ecore.resource.Resource;

import de.hpi.sam.bp2009.testframework.OptionObject;

/**
 * @author tobias.hoppe
 *
 */
public class OclOperator implements Operator {

	/* (non-Javadoc)
	 * @see de.hpi.sam.bp2009.testframework.operator.Operator#execute(org.eclipse.emf.ecore.resource.Resource, java.lang.Object)
	 */
	@Override
	public Resource execute(Resource resource, Object option) {
		if (option instanceof OclOptions){
			return executeQueries(resource, (OclOptions)option);
		}
		return null;
	}

	private Resource executeQueries(Resource resource, OclOptions option) {
		
		for(String con: option.oclConstraints){
			try {
				OclUtil.executeQueryOn(con, resource);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		return null;
	}

	/* (non-Javadoc)
	 * @see de.hpi.sam.bp2009.testframework.operator.Operator#getOptionObjectClass()
	 */
	@Override
	public Class<? extends OptionObject> getOptionObjectClass() {
		return OclOptions.class;
	}

}
