package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.HashSet;

import org.eclipse.emf.common.util.EList;

import com.sap.furcas.metamodel.FURCAS.TCS.RequiredInterfaceTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.metamodel.FURCAS.interfaceconfiguration.Binding;
public class InterfaceSpecification {

	/**
	 * collects all errors that happen during binding specification
	 */
	private SemanticErrorBucket errorBucket;

	private HashSet<Template> interfaceTemplates = new HashSet<Template>();
	
	
	//TODO how to get a configuration of a from an example? 
	
	/**
	 * get a list of templates that are specified by a configuration setting
	 * 
	 * @param bindings2 the collection of bindings defined by a configuration
	 * 
	 * @param requiredInterfaceTemplates the collection of requiredInterfaceTemplates defined by a configuration
	 * 
	 * @return HashSet<Template> a collection of templates that are specified by the
	 *         binding
	 */
	public HashSet<Template> getTemplatesFromBinding(EList<Binding> bindings, HashSet<RequiredInterfaceTemplate> requiredInterfaceTemplates) {
		if (!bindings.isEmpty()) {
			for (Binding binding : bindings) {
				if (binding.getRequireingSyntax() != null
						&& binding.getRequiredTemplate() != null) {
					if (binding.getProvidingSyntax() != null
							&& binding.getProvidedTemplate() != null) {
						if (binding.getProvidedTemplate()
								.getTemplateVisibility().toString()
								.equalsIgnoreCase("public")) {
							if (binding.getProvidingSyntax().getTemplates()
									.contains(binding.getRequiredTemplate())) {
								errorBucket
										.addWarning(
												"the template already exists in the main syntax",
												binding.getRequiredTemplate());
							} else {
								if (requiredInterfaceTemplates.contains(binding.getRequiredTemplate())) {
									interfaceTemplates.add(binding
											.getProvidedTemplate());
								} else {
									errorBucket
									.addWarning(
											"the required template is not defined by the interface in the main syntax:  ",
											binding.getRequiredTemplate());
								}
							}
						} else {
							errorBucket
									.addWarning(
											"the provided template is not offered by the interface in the syntax:  ",
											binding.getProvidingSyntax());
						}
					} else {
						errorBucket
								.addWarning(
										"the binding specification have no requireing syntax or/and required template",
										binding);
					}

				} else {
					errorBucket
							.addError(
									"the binding specification have no providing syntax and/or required syntax ",
									binding);
				}
			}
		}

		return interfaceTemplates;

	}
	

}
