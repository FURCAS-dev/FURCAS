package de.hpi.sam.bp2009.testframework.generator.dynamicemf;
import de.hpi.sam.bp2009.testframework.OptionObject;

public interface Generator {
	public org.eclipse.emf.ecore.resource.Resource generate(Object options);
	public Class<? extends OptionObject> getOptionObjectClass();
}
