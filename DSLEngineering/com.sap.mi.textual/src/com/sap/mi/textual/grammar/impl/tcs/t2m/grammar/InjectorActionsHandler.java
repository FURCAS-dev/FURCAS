/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-09-19 13:53:53 +0200 (Fr, 19 Sep 2008) $
 * @version $Revision: 1832 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.mi.textual.grammar.impl.tcs.t2m.grammar;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.furcas.metamodel.TCS.ClassTemplate;
import com.sap.furcas.metamodel.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.TCS.InjectorAction;
import com.sap.furcas.metamodel.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.TCS.PropertyInit;
import com.sap.furcas.metamodel.TCS.PropertyReference;
import com.sap.furcas.metamodel.TCS.QualifiedNamedElement;
import com.sap.mi.textual.common.exceptions.MetaModelLookupException;
import com.sap.mi.textual.common.exceptions.NameResolutionFailedException;
import com.sap.mi.textual.common.exceptions.SyntaxElementException;
import com.sap.mi.textual.common.interfaces.IMetaModelLookup;
import com.sap.mi.textual.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.mi.textual.grammar.exceptions.SyntaxParsingException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.constraints.PropertyInstanceOfConstraint;
import com.sap.mi.textual.grammar.impl.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.mi.textual.moinlookup.util.MetamodelNameResolvingException;
import com.sap.mi.textual.moinlookup.util.RuleNameFinder;
import com.sap.mi.textual.moinlookup.util.TemplateNamingHelper;
import com.sap.mi.textual.tcs.util.MessageHelper;
import com.sap.mi.textual.tcs.util.MetaModelElementResolutionHelper;
import com.sap.mi.textual.tcs.util.SyntaxLookup;
import com.sap.mi.textual.util.TcsUtil;


/**
 * handles separate Injector Actions which have no syntactic representation
 */
public class InjectorActionsHandler<Type> {

	private static final String MQL_QUERY_PREFIX = "MQL:";

	private static final String OCL_QUERY_PREFIX = "OCL:";

	private final SemanticErrorBucket errorBucket;

	private final SyntaxLookup syntaxLookup;

	private final MetaModelElementResolutionHelper<Type> resolutionHelper;

	private final IMetaModelLookup<Type> metaLookup;

	private final TemplateNamingHelper<Type> namingHelper;

	/**
	 * @param handlerConfig
	 */
	public InjectorActionsHandler(
			SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
		errorBucket = handlerConfig.getErrorBucket();
		syntaxLookup = handlerConfig.getSyntaxLookup();
		metaLookup = handlerConfig.getMetaLookup();
		resolutionHelper = handlerConfig.getResolutionHelper();
		namingHelper = handlerConfig.getNamingHelper();
	}

	/**
	 * Adds the element.
	 * 
	 * @param element
	 *            the element
	 * @param buffer
	 *            the buffer
	 * 
	 * @throws SyntaxParsingException
	 *             the syntax parsing exception
	 * @throws MetaModelLookupException
	 *             the meta model lookup exception
	 * @throws SyntaxElementException
	 */
	public void addElement(InjectorActionsBlock block,
			RuleBodyStringBuffer buffer) throws MetaModelLookupException,
			SyntaxElementException {
		Collection<InjectorAction> actions = block.getInjectorActions();
		if (actions == null || actions.size() == 0) {
			return;
		}

		QualifiedNamedElement propertyOwnerTypeTemplate = syntaxLookup
				.getEnclosingQualifiedElement(block);

		// get Type of this Property

		buffer.append('{');
		for (Iterator<InjectorAction> iterator = actions.iterator(); iterator
				.hasNext();) {
			InjectorAction injectorAction = iterator.next();

			if (injectorAction instanceof PropertyInit) {
				PropertyInit propInit = (PropertyInit) injectorAction;
				addPropertyInitAction(block, buffer, propertyOwnerTypeTemplate,
						propInit);

			} else {
				throw new RuntimeException(
						"Unknown subclass of InjectorAction "
								+ injectorAction.getClass());
			}
		}
		buffer.append('}');

	}

	/**
	 * adds "{setProperty(propName, value);}" for a primitive template and"{setRef(ret, propName, TypeOfProperty, null, null, value, null, null, false, null);}"
	 * if llookup init
	 * 
	 * @param block
	 * @param buffer
	 * @param propertyOwnerTypeTemplate
	 * @param propInit
	 * @throws MetaModelLookupException
	 * @throws SyntaxElementException
	 * @throws MetamodelNameResolvingException
	 */
	private void addPropertyInitAction(InjectorActionsBlock block,
			RuleBodyStringBuffer buffer,
			QualifiedNamedElement propertyOwnerTypeTemplate,
			PropertyInit propInit) throws MetaModelLookupException,
			SyntaxElementException {
		String propName = getPropertyName(propInit);
		if (propName == null || propName.trim().equals("")) {
			errorBucket.addError("Empty property name.", propInit);
			return;
		}
		buffer.append(ObservationDirectivesHelper
                        .getEnterInjectorActionNotification());
		String value = propInit.getValue();
		if (propInit instanceof PrimitivePropertyInit) {
			// TODO refer to and use Primitive template transformer to create
			// required
			// datatype
			buffer.append("setProperty(ret, \"" + propName + "\", " + value
					+ ");");
		} else if (propInit instanceof LookupPropertyInit) {
			boolean isOptional = true;
			// //All property inits are now considered optional as their
			// violation
			// will be error handled through constraint checking.
			// try {
			// isOptional = metaLookup.getMultiplicity(
			// resolutionHelper.resolve(propertyOwnerTypeTemplate),
			// propName).isOptional();
			// } catch (NameResolutionFailedException e) {
			// throw new SyntaxElementException(e.getMessage(), block, e);
			// }
			ResolvedNameAndReferenceBean<Type> metaModelTypeOfPropertyReference = TcsUtil
					.getReferencedType(block, buffer, propName,
							propertyOwnerTypeTemplate, resolutionHelper,
							metaLookup);
			String resolvedTypeOfPropertyName = namingHelper
					.getMetaTypeListParameter(metaModelTypeOfPropertyReference);
			if (value.startsWith(OCL_QUERY_PREFIX)
					|| value.startsWith(MQL_QUERY_PREFIX)) {

				List<String> oclErrors = metaLookup.validateOclQuery(block
						.getParentTemplate(), value.replaceFirst("OCL:", ""),
						block.getParentTemplate().getMetaReference());
				for (String error : oclErrors) {
					errorBucket.addError(error, propInit);
				}

				String javaQuery = value.replaceAll("\\\"", "\\\\\"");
				javaQuery = javaQuery.replaceAll("\r\n", "\"+\"");
				javaQuery = javaQuery.replaceAll("\n", "\"+\"");
				buffer.append("setOclRef(ret, \"" + propName
						+ "\", null, null, \"" + javaQuery + "\", "
						+ isOptional + ");");
			} else {
				buffer.append("setRef(ret, \"" + propName + "\", "
						+ resolvedTypeOfPropertyName + ", null, null, \""
						+ value + "\", null, null, false, null, " + isOptional
						+ ");");
			}

		} else if (propInit instanceof ForeachPredicatePropertyInit) {
			String mode = ((ForeachPredicatePropertyInit) propInit).getMode();

			List<String> oclErrors = metaLookup.validateOclQuery(block
					.getParentTemplate(), value.replaceFirst("OCL:", ""), block
					.getParentTemplate().getMetaReference());
			for (String error : oclErrors) {
				errorBucket.addError(error, propInit);
			}

			String javaQuery = value.replaceAll("\\\"", "\\\\\"");
			javaQuery = javaQuery.replaceAll("\r\n", "\"+\"");
			javaQuery = javaQuery.replaceAll("\n", "\"+\"");
			buffer.append("\n{\n");
			buffer
					.append("List<PredicateSemantic> list = new ArrayList<PredicateSemantic>();\n");
			buffer.append("RuleNameFinder finder = new RuleNameFinder();\n");
			Iterator<PredicateSemantic> semIt = ((ForeachPredicatePropertyInit) propInit)
			.getPredicateSemantic().iterator();
			RuleNameFinder finder = new RuleNameFinder();

			while (semIt.hasNext()) {
				PredicateSemantic next = semIt.next();
				String localMode = mode;
				if (next.getMode() != null) {
					localMode = next.getMode();
				}
				if (next.getWhen() != null) {
					String javaQueryWhen = toString(next.getWhen()).replaceAll("\\\"", "\\\\\"");
					javaQueryWhen = javaQueryWhen.replaceAll("\r\n", "\"+\"");
					javaQueryWhen = javaQueryWhen.replaceAll("\n", "\"+\"");
					buffer.append("list.add(new PredicateSemantic(\""
							+ javaQueryWhen + "\", \""
							+ finder.getRuleName(next.getAs(), localMode)
							+ "\"));\n");
					oclErrors = metaLookup.validateOclQuery(block
							.getParentTemplate(), toString(next.getWhen()).replaceFirst("OCL:", ""), block
							.getParentTemplate().getMetaReference());
					for (String error : oclErrors) {
						errorBucket.addError(error, propInit);
					}
				} else {
					buffer.append("list.add(new PredicateSemantic(null, \""
							+ finder.getRuleName(next.getAs(), localMode)
							+ "\"));\n");
				}
			}
			boolean hasContext = false;
			if (block.getParentTemplate() instanceof ClassTemplate) {
				hasContext = ((ClassTemplate) block.getParentTemplate())
						.isIsContext();
			}
			if (mode == null) {
				buffer.append("setPredicateRef(ret,\"" + propName
						+ "\",null,\"" + javaQuery + "\",list,finder,"
						+ hasContext + ");");
			} else {
				buffer.append("setPredicateRef(ret,\"" + propName + "\",\""
						+ mode + "\",\"" + javaQuery + "\",list,finder,"
						+ hasContext + ");");
			}
			buffer.append("\n}\n");
		}
		buffer.append(ObservationDirectivesHelper
				.getExitInjectorActionNotification());
	}

	private String toString(OCLExpression when) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param propInit
	 * @return
	 */
	private static String getPropertyName(PropertyInit propInit) {
		PropertyReference propRef = propInit.getPropertyReference();
		if (propRef != null) {
			if (propRef.getName() != null) {
				return propRef.getName();
			} else {
				EStructuralFeature strucFeat = propRef.getStrucfeature();
				if (strucFeat != null) {
					return strucFeat.getName();
				}
			}
		}
		return null;
	}

	/**
	 * util method that looks up the type of a referenced object, and also
	 * considers the context of the current template sequence.
	 * 
	 * @param block
	 * @param buffer
	 * @param name
	 * @param propertyOwnerTypeTemplate
	 * @return
	 * @throws MetaModelLookupException
	 * @throws SyntaxElementException
	 */
	protected ResolvedNameAndReferenceBean<Type> getReferencedType(
			InjectorActionsBlock block, RuleBodyStringBuffer buffer,
			String name, QualifiedNamedElement propertyOwnerTypeTemplate)
			throws MetaModelLookupException, SyntaxElementException {

		// check for instanceof constraint context in current buffer
		List<RuleBodyPropertyConstraint> constraints = buffer
				.getCurrentConstraints();

		ResolvedNameAndReferenceBean<Type> substitutePropertyType = null;
		for (Iterator<RuleBodyPropertyConstraint> iterator = constraints
				.iterator(); iterator.hasNext();) {
			RuleBodyPropertyConstraint ruleBodyPropertyConstraint = iterator
					.next();
			if (ruleBodyPropertyConstraint instanceof PropertyInstanceOfConstraint) {
				PropertyInstanceOfConstraint instOfConst = (PropertyInstanceOfConstraint) ruleBodyPropertyConstraint;
				if (instOfConst.getPropertyName().equals(name)) {
					List<String> substitutePropertyTypeName = instOfConst
							.getTypename();
					substitutePropertyType = resolutionHelper
							.resolve(substitutePropertyTypeName);
					// the last in the list wins, that's fine, since they can
					// overrule each other.
				}
			}
		}

		ResolvedNameAndReferenceBean<Type> metaElementRef;
		try {
			metaElementRef = resolutionHelper
					.resolve(propertyOwnerTypeTemplate);
		} catch (NameResolutionFailedException e) {
			throw new SyntaxElementException(e.getMessage(), block, e);
		}
		ResolvedNameAndReferenceBean<Type> realMetaModelTypeOfPropertyTemplate = metaLookup
				.getFeatureClassReference(metaElementRef, name);

		// realMetaModelTypeOfPropertyTemplate =
		// syntaxLookup.getTCSTemplate(propertyTypeName);

		if (realMetaModelTypeOfPropertyTemplate == null) {
			throw new SyntaxElementException("Type "
					+ MessageHelper.getTemplateName(propertyOwnerTypeTemplate)
					+ " has no feature " + name, block);
		}

		ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty;
		if (substitutePropertyType != null) {
			// check in Metamodel that new ownername is subclass of previous
			// one, else
			// error
			if (metaLookup.isSubTypeOf(substitutePropertyType,
					realMetaModelTypeOfPropertyTemplate)) {
				metaModelTypeOfProperty = substitutePropertyType;
			} else {
				throw new SyntaxElementException("Conditional subtype "
						+ substitutePropertyType + " of feature " + name
						+ " is not a subtype of expected type "
						+ realMetaModelTypeOfPropertyTemplate, block);
			}

		} else {
			metaModelTypeOfProperty = realMetaModelTypeOfPropertyTemplate;
		}

		return metaModelTypeOfProperty;
	}
}
