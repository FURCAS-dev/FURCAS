package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.parsergenerator.util.VarStringBuffer;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

public class SemanticDisambiguateHandler {

	private final Collection<? extends Template> templates;
	private final SemanticErrorBucket errorBucket;
	private final TemplateNamingHelper<?> namingHelper;
	private final ArrayList<String> usedSyntacticDisambiguates;
	private boolean listHasSyntacticDisambiguate;
	private boolean listHasSemanticDisambiguate;
	private boolean firstSemanticDisambiguate;

	public SemanticDisambiguateHandler(
			Collection<? extends Template> templates,
			SemanticErrorBucket errorBucket,
			TemplateNamingHelper<?> namingHelper) {
		this.templates = templates;
		this.errorBucket = errorBucket;
		this.namingHelper = namingHelper;
		usedSyntacticDisambiguates = new ArrayList<String>();
		firstSemanticDisambiguate = true;
		analyze();
	}

	private void analyze() {
		listHasSyntacticDisambiguate = false;
		for (Template subtemp : templates) {
			if (!listHasSyntacticDisambiguate && hasSyntacticDisambiguate(subtemp))
				listHasSyntacticDisambiguate = true;
			if (!listHasSemanticDisambiguate && subtemp.getSemDisambiguate() != null)
				listHasSemanticDisambiguate = true;
		}
	}

	public boolean shouldUseSemanticDisambiguate(
			Template templateWithSyntacticDisambiguate) {
		if (!listHasSemanticDisambiguate)
			return false;
		boolean relevantSemDisambFound = false;
		for (Template subtemp : templates) {
			if (templateWithSyntacticDisambiguate.equals(subtemp))
				continue;
			if (hasSyntacticDisambiguate(subtemp)) {
				// TODO implement a more tolerant comparison that can also handle whitespace differences
				if (subtemp.getDisambiguateV3().equals(
						templateWithSyntacticDisambiguate.getDisambiguateV3())) {
					if (subtemp.getSemDisambiguate() != null)
						relevantSemDisambFound = true;
					else {
						errorBucket.addError(
								"A subtemplate misses a SemanticDisambiguate",
								subtemp);
						return false;
					}
				}
			} else if (subtemp.getSemDisambiguate() != null)
				relevantSemDisambFound = true;
			else {
				errorBucket.addError(
						"A subtemplate misses a SemanticDisambiguate", subtemp);
				return false;
			}
		}
		return relevantSemDisambFound;
	}

	public boolean addSemanticDisambiguateRule(Template template,
			VarStringBuffer rulebody,
			RuleBodyBufferFactory ruleBodyBufferFactory,
			ClassTemplate operatorParentTemplate, String metaObjectListParam, boolean addedSemanticDisambiguateRule)
			throws MetaModelLookupException {
		if (hasSyntacticDisambiguate(template)) {
			if (usedSyntacticDisambiguates.contains(template
					.getDisambiguateV3()))
				return false;
			else {
				usedSyntacticDisambiguates.add(template.getDisambiguateV3());
				if (!firstSemanticDisambiguate)
					rulebody.append("\n  | ");
				// add disambiguation rule
				rulebody.append("(" + template.getDisambiguateV3() + ")=>("); // b2
			}
		}
		if (!listHasSyntacticDisambiguate && !firstSemanticDisambiguate)
			return false;
		if (!firstSemanticDisambiguate && !hasSyntacticDisambiguate(template))
			rulebody.append("\n  | ");

		String semOcl = template.getSemDisambiguate();
		String opnameParameter = "null";
		Sequence sequence;
		
		//placeholder replacement
		//TODO refactor this to ClassTemplate and OperatorTemplate in a common superclass
		boolean isOperatorTemplate = template instanceof OperatorTemplate;
		if (isOperatorTemplate)
			sequence = ((OperatorTemplate) template).getTemplateSequence();
		else
			sequence = ((ClassTemplate) template).getTemplateSequence();
		// TODO change this character to a better intuitive version maybe ${...}
		// TODO support more than one use of a feature 
		int beginRef = semOcl.indexOf("${");
		String semReference = null;
		if (beginRef >= 0)
			semReference = semOcl.substring(beginRef + 2, semOcl.indexOf('}',
					beginRef + 1));
		
		//find a rule representation for temporary parsing 
		String rulePrefix = ruleBodyBufferFactory
				.getNewRuleBodyForSemDisambiguate(sequence, semReference);
		if(rulePrefix != null)
			rulebody.append(rulePrefix);
		
		// collect templatenames and ocls for all subtemplates
		rulebody.append("\n{List<SemanticDisambRuleData> semDisambRuleData = "
				+ "new ArrayList<SemanticDisambRuleData>();\n");
		for (Template subtemp : templates) {
			if (hasSyntacticDisambiguate(template)) {
				if (!template.getDisambiguateV3().equals(
						subtemp.getDisambiguateV3()))
					continue;
			}
			String ruleName;
			try {
				// TODO check if it is better to make a superclass and call
				// only one of the instance of parts to remove the instanceof call
				if (subtemp instanceof OperatorTemplate) {
					ruleName = namingHelper.getRuleName(subtemp);
					opnameParameter = "opName";
				} else {
					ruleName = namingHelper.getRuleNameForMode(subtemp,
							((ClassTemplate) subtemp).getMode());
				}
			} catch (SyntaxElementException ex) {
				errorBucket.addException(ex);
				return false;
			}
			if (subtemp.getSemDisambiguate() == null)
				errorBucket.addError("No semantic disambiguate in template.",
						subtemp);
			else {
				rulebody
						.append("semDisambRuleData.add(new SemanticDisambRuleData(\""
								+ ruleName
								+ "\",\""
								+ subtemp.getSemDisambiguate() + "\"));\n");
			}
		}

		if (isOperatorTemplate) {
			rulebody.append("Object lefthand = ret;\n");
			String proxyStr = ClassTemplateHandler
					.createModelElementProxyString(operatorParentTemplate,
							true, metaObjectListParam);
			rulebody.append(proxyStr);
			rulebody
					.append("setSemDisambiguate(ret,lefthand,"
							+ opnameParameter
							+ ",semRef,semDisambRuleData,false, (ANTLR3LocationToken)firstToken);\n}");

		} else {
			rulebody
					.append("setSemDisambiguate(ret,null,"
							+ opnameParameter
							+ ",semRef,semDisambRuleData,false, (ANTLR3LocationToken)firstToken);\n}");
		}
		if (hasSyntacticDisambiguate(template))
			rulebody.append(")");
		firstSemanticDisambiguate = false;
		return true;
	}

	public boolean subtemplatesHaveSemanticDisambiguate() {
		for (Template subtemp : templates) {
			if (subtemp.getSemDisambiguate() != null) {
				return true;
			}
		}
		return false;
	}

	private boolean hasSyntacticDisambiguate(Template template) {
		return template.getDisambiguateV3() != null;
	}
}
