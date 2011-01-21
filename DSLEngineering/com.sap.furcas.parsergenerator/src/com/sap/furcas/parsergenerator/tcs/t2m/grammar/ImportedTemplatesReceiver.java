package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;

public interface ImportedTemplatesReceiver {

	/**
	 * Should be notified whenever an transitively imported template is found
	 * for which a grammar rule should also be generated.
	 * 
	 * @param importedTemplate the template that should be added to the generation process.
	 */
	public void addAdditionallyImportedTemplate(Template importedTemplate);
	
}
