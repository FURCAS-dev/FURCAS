/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-03 16:11:26 +0200 (Do, 03 Apr 2008) $
 * @version $Revision: 767 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.sap.furcas.metamodel.TCS.EnumLiteralMapping;
import com.sap.furcas.metamodel.TCS.EnumerationTemplate;
import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.textual.common.exceptions.SyntaxElementException;
import com.sap.furcas.textual.common.interfaces.IMetaModelLookup;
import com.sap.furcas.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.textual.tcs.MessageHelper;
import com.sap.furcas.textual.tcs.MetaModelElementResolutionHelper;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.rules.ClassProductionRule;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;

/**
 * The Class PrimitiveTemplateHandler.
 */
public class EnumerationTemplateHandler<Type extends Object> {

	private static final String INIT_STRING = "java.lang.Object ret=null;";
	private static final String RETURN_STRING = "Object ret2";

	/** The writer. */
	private ANTLR3GrammarWriter writer;

	/** The meta lookup. */
	private IMetaModelLookup<Type> metaLookup;

	private TemplateNamingHelper<Type> namingHelper;
    private MetaModelElementResolutionHelper<Type> resolutionHelper;

	/**
	 * Instantiates a new primitive template handler.
	 * 
	 * @param writer
	 *            the writer
	 * @param syntaxLookup
	 * @param metaLookup
	 * @param namingHelper
	 * @param resHelper 
	 */
    protected EnumerationTemplateHandler(ANTLR3GrammarWriter writer,
			IMetaModelLookup<Type> metaLookup, TemplateNamingHelper<Type> namingHelper, MetaModelElementResolutionHelper<Type> resHelper) {
		this.writer = writer;
		this.metaLookup = metaLookup;
		this.namingHelper = namingHelper;
		this.resolutionHelper = resHelper;
	}

	/**
     * @param handlerConfig
     */
    protected EnumerationTemplateHandler(
            SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
        this(handlerConfig.getWriter(),
                handlerConfig.getMetaLookup(),                
                handlerConfig.getNamingHelper(),                
                handlerConfig.getResolutionHelper());
    }

    /**
	 * Adds the template.
	 * 
	 * @param funcTemplate
	 *            the function template in the syntax
	 * @throws SyntaxParsingException
	 * @throws MetaModelLookupException
	 */
	public void addTemplate(EnumerationTemplate enumTemplate,
			RuleBodyBufferFactory ruleBodyBufferFactory)
			throws SyntaxElementException, MetaModelLookupException {
		// i.e. (('always') {ret = createEnumLiteral("always");}|
		// ('ifmissing') {ret = createEnumLiteral("ifmissing");} )
		StringBuilder rulebody;
		try {
		ResolvedNameAndReferenceBean<Type> refbean = resolutionHelper.resolve(enumTemplate);
		if (enumTemplate.isAutomatic()) {
		    
			List<String> literalsFromMM = metaLookup
					.getEnumLiterals(refbean);
			rulebody = new StringBuilder(literalsFromMM.size() * 60);
			rulebody.append('(');
			for (Iterator<String> iterator = literalsFromMM.iterator(); iterator
					.hasNext();) {
				String literal = iterator.next();
				rulebody.append('(');
				String rulefragment = "'" + literal + "'";
				rulebody.append(rulefragment);
				rulebody.append(')');

				rulebody.append("{ret = createEnumLiteral(");
				// other than TCS, use the metamodel enum reference
				rulebody.append(namingHelper.getMetaTypeListParameter(refbean));
				rulebody.append(", \"");

				rulebody.append(literal);
				rulebody.append("\");}");

				if (iterator.hasNext()) {
					rulebody.append("\n | ");
				}
			}
		} else {

			Collection<EnumLiteralMapping> mappings = enumTemplate.getMappings();
			rulebody = new StringBuilder(mappings.size() * 60);
			rulebody.append('(');
			for (Iterator<EnumLiteralMapping> iterator = mappings.iterator(); iterator
					.hasNext();) {
				EnumLiteralMapping enumLiteralMapping = iterator.next();

				rulebody.append('(');
				String rulefragment = ruleBodyBufferFactory
						.getNewRuleBodyFragment(enumLiteralMapping.getElement());
				rulebody.append(rulefragment);
				rulebody.append(')');

				rulebody.append("{ret = createEnumLiteral(");
				// other than TCS, use the metamodel enum reference
				rulebody.append(namingHelper.getMetaTypeListParameter(refbean));
				rulebody.append(", \"");

				rulebody.append(enumLiteralMapping.getLiteral().getName());
				rulebody.append("\");}");

				if (iterator.hasNext()) {
					rulebody.append("\n | ");
				}
			}
		}
		rulebody.append(')');

		rulebody.append("\n{\n  ret2=ret;\n}");
		writer.addRule(new ClassProductionRule(namingHelper
				.getRuleName(enumTemplate), RETURN_STRING, INIT_STRING,
				rulebody.toString(), null));

	
	} catch (NameResolutionFailedException e) {
        throw new SyntaxElementException("Enumeration could not be resolved: "+ MessageHelper.getTemplateName(enumTemplate), enumTemplate, e);
    } 
	}
}
