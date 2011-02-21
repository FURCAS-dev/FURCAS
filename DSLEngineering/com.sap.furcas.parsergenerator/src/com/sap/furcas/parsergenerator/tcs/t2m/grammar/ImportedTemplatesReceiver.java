package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;

public interface ImportedTemplatesReceiver {

	/**
	 * Should be notified whenever an transitively imported template is found
	 * for which a grammar rule should also be generated.
	 * 
	 * @param templateCausingTransitiveImport the template for which the <tt>importedTemplate</tt> is imported as transitive dependency.
	 * @param importedTemplate the template that should be added to the generation process.
	 * @param importedTemplate 
	 */
	public void addAdditionallyImportedTemplate(Template templateCausingTransitiveImport, Template importedTemplate);
	
}
