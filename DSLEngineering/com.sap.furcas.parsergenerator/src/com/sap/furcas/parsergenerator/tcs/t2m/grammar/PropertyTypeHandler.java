/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2010-05-20 15:12:26 +0200 (Do, 20 Mai 2010) $
 * @version $Revision: 9718 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import static com.sap.furcas.parsergenerator.util.StringConcatUtil.concatBuf;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportContextPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupScopePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PartialPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PostfixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrefixPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.RefersToPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.SeparatorPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Sequence;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyQuantityConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.furcas.parsergenerator.util.TcsUtil;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.MultiplicityBean;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.parser.exceptions.SyntaxParsingException;
import com.sap.furcas.runtime.tcs.MessageHelper;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.MetamodelNameResolvingException;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 * The Class PropertyTypeHandler.
 * 
 */
public class PropertyTypeHandler<Type extends Object> {

    private IMetaModelLookup<Type> metaLookup;
    private SyntaxLookup syntaxLookup;
    private TemplateNamingHelper<Type> namingHelper;
    private SemanticErrorBucket errorBucket;
    private MetaModelElementResolutionHelper<Type> resolutionHelper;

    private boolean skipDelayedReferences = false;
    
    protected PropertyTypeHandler(IMetaModelLookup<Type> metaLookup, SyntaxLookup syntaxLookup,
            TemplateNamingHelper<Type> namingHelper, SemanticErrorBucket errorBucket) {
        this.metaLookup = metaLookup;
        this.syntaxLookup = syntaxLookup;
        this.namingHelper = namingHelper;
        this.errorBucket = errorBucket;
        this.resolutionHelper = new MetaModelElementResolutionHelper<Type>(metaLookup);
    }

    protected PropertyTypeHandler(SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
        this(handlerConfig.getMetaLookup(), handlerConfig.getSyntaxLookup(), handlerConfig.getNamingHelper(),
                handlerConfig.getErrorBucket());
    }

    public void addElement(Property prop, RuleBodyStringBuffer buffer) throws SyntaxElementException, MetaModelLookupException {
        try {
            StringBuilder ruleBodyPart = new StringBuilder();

            // get Owner of this property
            QualifiedNamedElement propertyOwnerTypeTemplate = syntaxLookup.getEnclosingQualifiedElement(prop);

            // get Type of this Property
            String propertyName = getPropertyName(prop);
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty = TcsUtil.getReferencedType(prop, buffer, propertyName,
                    propertyOwnerTypeTemplate, resolutionHelper, metaLookup);
            
            PropertyArgs args = new PropertyArgs(prop.getPropertyArgs());
            validateArgs(args);

            if (args.referenceByPArg != null) {
                addQueriedReferenceCode(prop, ruleBodyPart, metaModelTypeOfProperty, propertyName, args);
            } else if (args.refersTo != null) {
               addRefersToCode(prop, ruleBodyPart, metaModelTypeOfProperty, propertyName, args);
            } else {
                // property not to be referenced but used within
                ruleBodyPart.append(" temp=");
                if (args.asPArg != null) {
                    addAsTemplateCode(args, ruleBodyPart);
                } else {
                    addTypeDependentTemplateCode(prop, args, metaModelTypeOfProperty, ruleBodyPart);
                }
                if (args.modePArg != null) {
                    ruleBodyPart.append(TemplateNamingHelper.getModeSuffix(args.modePArg.getMode()));
                }
                ruleBodyPart.append(" {setProperty(ret, \"").append(propertyName).append("\", temp);\nsetParent(temp,ret,\"" + propertyName + "\");}");
            }
            handleMultiplicity(prop, buffer, propertyName, args, propertyOwnerTypeTemplate, ruleBodyPart);

        } catch (MetamodelNameResolvingException e) {
            throw new SyntaxElementException(e.getMessage(), prop, e);
        }
    }

    /**
     * Use type name for rule name. If it is a DataTyp, then use primitive template for that datatype.
     */
    private void addTypeDependentTemplateCode(Property prop, PropertyArgs args,
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty, StringBuilder repeatablePart)
            throws SyntaxElementException {
        PrimitiveTemplate propertyPrimitiveTemplate = syntaxLookup.getDefaultPrimitiveTemplateRule(metaModelTypeOfProperty);
        if (propertyPrimitiveTemplate != null) {
            repeatablePart.append(namingHelper.getRuleName(propertyPrimitiveTemplate));
        } else {
            String propertyTemplateRule = namingHelper.buildRuleName(metaModelTypeOfProperty);
            String modeArg = args.modePArg != null ? args.modePArg.getMode() : null;
            if (syntaxLookup.getTCSTemplate(metaModelTypeOfProperty, modeArg) == null) {
                errorBucket.addError("Syntax does not define a rule for " + metaModelTypeOfProperty + " with mode "
                        + modeArg, prop);
            }
            repeatablePart.append(propertyTemplateRule);
        }
    }

    private void addAsTemplateCode(PropertyArgs args, StringBuilder ruleBodyPart) throws SyntaxElementException {
        if (args.asPArg.getTemplate() != null) {
            Template asTemplate = args.asPArg.getTemplate();
            String ruleName = null;
            if (asTemplate instanceof ClassTemplate) {
                ClassTemplate cAsTemplate = (ClassTemplate) asTemplate;
                if (cAsTemplate.getMode() != null) {
                    ruleName = namingHelper.getRuleNameForMode(cAsTemplate, cAsTemplate.getMode());
                } else {
                    ruleName = namingHelper.getRuleName(cAsTemplate);
                }
            } else if (asTemplate instanceof PrimitiveTemplate) {
                PrimitiveTemplate pAsTemplate = (PrimitiveTemplate) asTemplate;
                ruleName = namingHelper.getRuleName(pAsTemplate);
            } else if (asTemplate instanceof EnumerationTemplate) {
                EnumerationTemplate eAsTemplate = (EnumerationTemplate) asTemplate;
                ruleName = namingHelper.getRuleName(eAsTemplate);
            }

            ruleBodyPart.append(ruleName);
        } else {
            ruleBodyPart.append(args.asPArg.getValue());
        }
    }

    private void validateArgs(PropertyArgs args) {
        if (args.refersTo != null) {
            errorBucket.addWarning("RefersTo is deprecated. Please use referenceBy and lookupScope instead.", args.refersTo);
            if (args.asPArg != null) {
                errorBucket.addWarning("As only possible without refersTo", args.asPArg);
                if (args.modePArg != null) {
                    errorBucket.addWarning("Mode only possible without refersTo", args.modePArg);
                }
            }
        }
        if (args.refersTo == null) {
            if (args.autoCreatePArg != null) {
                errorBucket.addWarning("AutoCreate only possible with refersTo", args.autoCreatePArg);
            }
            if (args.createAsPArg != null) {
                errorBucket.addWarning("CreateAs only possible with refersTo", args.createAsPArg);
            }
            if (args.createInPArg != null) {
                errorBucket.addWarning("CreateIn only possible with refersTo", args.createInPArg);
            }
            if (args.lookInPArg != null) {
                errorBucket.addWarning("LookIn only possible with refersTo", args.lookInPArg);
            }
            if (args.importContextPArg != null) {
                errorBucket.addWarning("ImportContext only possible with refersTo", args.importContextPArg);
            }
        }
        if (args.referenceByPArg == null) {
            if (args.prefixPArg != null) {
                errorBucket.addWarning("Prefix can only be used together with referenceBy. It is ignored otherwise.", args.prefixPArg);
            }
            if (args.postfixPArg != null) {
                errorBucket.addWarning("Postfix can only be used together with referenceBy. It is ignored otherwise.", args.postfixPArg);
            }
        }
        if (args.referenceByPArg != null && args.lookupScopePArg == null) {
            errorBucket.addError("ReferenceBy does only work when lookupScope is defined.", args.referenceByPArg);
        }
        if (args.lookupScopePArg != null && (args.referenceByPArg == null)) {
            errorBucket.addError("LookupScope does only work in concunction with referenceBy.", args.lookupScopePArg);
        }
    }

    protected static String getPropertyName(Property prop) {
        PropertyReference propRef = prop.getPropertyReference();
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

    private void addQueriedReferenceCode(Property prop, StringBuilder ruleBodyPart,
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfPropertyListName, String propertyName, PropertyArgs args)
            throws SyntaxElementException, MetaModelLookupException {
        // creates temp = ...
        appendRefersToTempPart(prop, ruleBodyPart, metaModelTypeOfPropertyListName, args, true);
        
        validateOclQuery(prop, args.lookupScopePArg, args.lookupScopePArg.getQuery());
        Type type = metaModelTypeOfPropertyListName.getReference();
        validateOclQuery(args.referenceByPArg, type, PropertyArgumentUtil.getReferenceByAsOCL(args.referenceByPArg));

        String query = PropertyArgumentUtil.getCombinedReferenceByLookupOCLQuery(args.referenceByPArg, args.lookupScopePArg, args.prefixPArg, args.postfixPArg);
        query = TcsUtil.escapeMultiLineOclQuery(query);
        
        // creates the bit that sets the temp from above as reference to modelElement "ret" of this rule
        String propURI = ObservationDirectivesHelper.getId(prop);
        if (args.refersTo != null) {
            if (!skipDelayedReferences) {
                ruleBodyPart.append(concatBuf(" {setOclRef(ret, \"", propertyName, "\", \"", args.refersTo.getPropertyName(),
                        "\", temp, \"" + query + "\", \""+propURI+"\");}"));
            }
        } else {
            if (!skipDelayedReferences) {
                ruleBodyPart.append(concatBuf(" {setOclRef(ret, \"", propertyName, "\", null, temp, \"" + query
                        + "\", \""+propURI+"\");}"));
            }
        }
    }
    
    private void validateOclQuery(PropertyArg argument, Type parsingContext, String query) {
        List<Diagnostic> oclErrors = metaLookup.validateOclQuery(parsingContext, query);
        for (Diagnostic error : oclErrors) {
        	if(error.getSeverity() == Diagnostic.ERROR) {
        	    errorBucket.addError("Error: " + error.getMessage() + " in OCL query: \"" + query + "\"", argument);
        	} else if(error.getSeverity() == Diagnostic.WARNING) {
        		errorBucket.addWarning("Warning: " + error.getMessage() + " in OCL query " + query, argument);
        	}
        }
    }

    private void validateOclQuery(Property prop, PropertyArg argument, String query) {
        List<Diagnostic> oclErrors = metaLookup.validateOclQuery(prop.getParentTemplate(), query);
        for (Diagnostic error : oclErrors) {
            if(error.getSeverity() == Diagnostic.ERROR) {
                errorBucket.addError("Error: " + error.getMessage() + " in OCL query: \"" + query + "\"", argument);
            } else if(error.getSeverity() == Diagnostic.WARNING) {
                    errorBucket.addWarning("Warning: " + error.getMessage() + " in OCL query " + query, argument);
            }
    }
    }

    /**
     * Adds to the rulepart the String "temp=\<rulename\>{setRef(ret,
     * propertyTemplate, propertyType, refersTo.PropertyName, temp,...)".
     * 
     * This means that an Object temp is created using either the parsing rule
     * provided as AsPArg or inferred from the metamodel, and then this temp
     * object is used to reference a different object in a delayed way. Meaning
     * we create a delayed reference to be resolved after parsing, where we will
     * try to locate a ModelElement Y of type propertyType, which has an
     * attribute named refersTo.propertyName of value temp. If we find this
     * ModelElement Y, we will set the reference from ModelElment ret with name
     * retpropertyName. As an example, if we parsed Java: "String x;", then we
     * would set the property "Type" of the ModelElement Variable x to that
     * DataType, which has name = "String".
     * 
     */
    private void addRefersToCode(Property prop, StringBuilder ruleBodyPart,
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty, String propertyName, PropertyArgs args)
            throws MetaModelLookupException, MetamodelNameResolvingException, SyntaxElementException {
        // appends the temp = ... part
        appendRefersToTempPart(prop, ruleBodyPart, metaModelTypeOfProperty, args, false);

        // now append the part that sets temp as reference of modelelement "ret" of this rule

        String resolvedTypeOfPropertyName = namingHelper.getMetaTypeListParameter(metaModelTypeOfProperty);

        String lookIn = null; // may be null in the String allowed
        if (args.lookInPArg != null) {
            Collection<String> argPropertyName = args.lookInPArg.getPropertyName();
            lookIn = "\"" + createDotSeparatedList(argPropertyName) + "\"";
        }
        String autoCreate = "\"never\""; // default value
        if (args.autoCreatePArg != null) {
            AutoCreateKind value = args.autoCreatePArg.getValue();
            autoCreate = "\"" + value.toString() + "\"";
        }
        String createAs = null; // may be null in String allowed
        if (args.createAsPArg != null) {
            // type to be created, may be illegal name or unqualified
            createAs = namingHelper.getMetaTypeListParameter(args.createAsPArg.getName());
            // createAs = "\"" + qualifiedname + "\"";
        }
        String createIn = null; // may be null in String allowed
        if (args.createInPArg != null) {
            Collection<String> argPropertyName = args.createInPArg.getPropertyName();
            createIn = "\"" + createDotSeparatedList(argPropertyName) + "\"";
        }
        if (!skipDelayedReferences) {
            ruleBodyPart.append(concatBuf(" {setRef(ret, \"", propertyName, "\", ", resolvedTypeOfPropertyName, ", \"",
                    args.refersTo.getPropertyName(), "\", temp, " + lookIn + ", " + autoCreate + ", " + createAs + ", "
                            + (args.importContextPArg != null) + ", " + createIn + ");}"));
        }
    }

    private void appendRefersToTempPart(Property prop, StringBuilder ruleBodyPart,
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfPropertyReference, PropertyArgs args,
            boolean primitivesOnly) throws SyntaxElementException, MetaModelLookupException {
        // example:
        // temp=identifier {setRef(ret, "author", "Author", "name", temp, null, "never", null, false, null);}
        // meaning create a delayed reference, where after all model elements have been created,
        // the model injector will set Article.author = Author x with x.name = temp

        ruleBodyPart.append(" temp=");

        // what Parser rule to call to create the key value for the referred object
        if (args.asPArg != null) {
            if (args.asPArg.getTemplate() != null) {
                ruleBodyPart.append(namingHelper.getRuleNameForTemplate(args.asPArg.getTemplate()));
            } else {
                String asRule = args.asPArg.getValue();
                if (!syntaxLookup.hasPrimitiveRule(asRule)) {
                    errorBucket.addError("Unknown As reference " + args.asPArg, args.asPArg);
                }
                ruleBodyPart.append(asRule);
            }
        } else if (args.referenceByPArg != null) {
            Type type = metaLookup.getOclReturnType(metaModelTypeOfPropertyReference.getReference(), PropertyArgumentUtil.getReferenceByAsOCL(args.referenceByPArg));
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfQueryResult = metaLookup.resolveReferenceName(type);
            PrimitiveTemplate propertyPrimitiveTemplate = syntaxLookup.getDefaultPrimitiveTemplateRule(metaModelTypeOfQueryResult);
            if (propertyPrimitiveTemplate == null) {
                errorBucket.addError("Syntax does not define a rule for " + metaModelTypeOfQueryResult
                        + " which is the return type of the referenceBy expression " + PropertyArgumentUtil.getReferenceByAsOCL(args.referenceByPArg), prop);
            } else {
                ruleBodyPart.append(propertyPrimitiveTemplate.getTemplateName());
            }
        } else {
            PrimitiveTemplate propertyPrimitiveTemplate = syntaxLookup.getDefaultPrimitiveTemplateRule(metaModelTypeOfPropertyReference);
            // if this is null, then there is no primitive template for this, so
            // we need to consider PropertyType as a non-primitive
            boolean isPrimitive = (propertyPrimitiveTemplate != null);

            // need to find out what type the property is of (i.e.
            // Article.author is of Type Author)
            if (isPrimitive) { // if primitive use the default primitive template
                ruleBodyPart.append(propertyPrimitiveTemplate.getTemplateName());
            } else {
                String propertyName = args.refersTo.getPropertyName();
                ResolvedNameAndReferenceBean<Type> referredFeatureType = metaLookup.getFeatureClassReference(metaModelTypeOfPropertyReference, propertyName);
                if (referredFeatureType == null) {
                    errorBucket.addError("Type " + metaModelTypeOfPropertyReference + " has no feature " + propertyName, prop);
                } else {
                    PrimitiveTemplate primTemp = syntaxLookup.getDefaultPrimitiveTemplateRule(referredFeatureType);
                    if (primTemp != null) {
                        ruleBodyPart.append(primTemp.getTemplateName());
                    } else {
                        String calledRuleName = namingHelper.buildRuleName(referredFeatureType);
                        // TODO: check if we need to consider mode here
                        Collection<Template> checkTemplates = syntaxLookup.getTCSTemplate(referredFeatureType, null);
                        if (checkTemplates == null) {
                            errorBucket.addError("Syntax does not define a rule for " + referredFeatureType, prop);
                        }
                        for (Template checkTemplate : checkTemplates) {
                            if (primitivesOnly && !(checkTemplate instanceof PrimitiveTemplate)) {
                                errorBucket.addError("Query only possible for primitive feature references "
                                        + referredFeatureType, prop);
                            }
                        }
                        ruleBodyPart.append(calledRuleName);
                    }
                }
            }
        }
    }

    private static String createDotSeparatedList(Collection<String> argPropertyName) {
        StringBuilder builder = new StringBuilder();
        for (Iterator<String> iterator = argPropertyName.iterator(); iterator.hasNext();) {
            builder.append(iterator.next());

            if (iterator.hasNext()) {
                builder.append('.');
            }
        }
        return builder.toString();
    }
    
    private void handleMultiplicity(Property prop, RuleBodyStringBuffer buffer, String propertyName, PropertyArgs args,
            QualifiedNamedElement propertyOwnerTypeTemplate, StringBuilder ruleBodyPart) throws MetaModelLookupException,
            SyntaxElementException {
        MultiplicityBean multiplicity = null;
        try {
            ResolvedNameAndReferenceBean<Type> refBean = resolutionHelper.resolve(propertyOwnerTypeTemplate);
            multiplicity = metaLookup.getMultiplicity(refBean, propertyName);
        } catch (NameResolutionFailedException e) {
            throw new SyntaxElementException("Type " + MessageHelper.getTemplateName(propertyOwnerTypeTemplate)
                    + " could not be resolved.", e);
        }
        if (multiplicity == null) {
            throw new SyntaxElementException("Type " + propertyOwnerTypeTemplate + ", feature " + propertyName
                    + " returned null as multiplicity.", prop, null);
        }

        if (multiplicity.getUpperBound() > -1 && multiplicity.getLowerBound() > multiplicity.getUpperBound()) {
            throw new SyntaxElementException("Multiplicity of  type " + propertyOwnerTypeTemplate + ", feature "
                    + propertyName + " is inconsistent in metamodel, lower bound is greater than upper bound: "
                    + multiplicity.getLowerBound() + ">" + multiplicity.getUpperBound(), prop, null);
        }
        addRepeatableWithMultiplicity(buffer, prop, ruleBodyPart, multiplicity, args);
    }

    /**
     * Helper method to deal with multiplicity. Add the repeatable part to the
     * buffer, and indicates expected multiplicity of this part.
     */
    protected void addRepeatableWithMultiplicity(RuleBodyStringBuffer buffer, Property prop, StringBuilder repeatablePart,
            MultiplicityBean multiplicity, PropertyArgs args) throws SyntaxElementException, MetaModelLookupException {
        boolean isInMulti = false;
        if (prop != null && prop.getElementSequence() instanceof SequenceInAlternative
                && ((SequenceInAlternative) prop.getElementSequence()).getAlternativeContainer().isIsMulti()) {
            if (multiplicity.getUpperBound() != -1) {
                errorBucket.addError("Alternative isMulti is only allows if all directly contained" +
                        "properties have an upper multiplicity of UNBOUNDED!", prop);
            }
            isInMulti = true;
        }

        /**
         * now, there are several cases to consider (), not optional, not
         * multiple ()?, optional, not multiple
         * 
         * Multiple cases:
         * 
         * lowerbound = 0 means (...)? = isoptional lowerbound = 1 means ()...
         * lowerbound > 3 means ()()()...
         * 
         * For ... in the above upperbound = -1 means ()* upperbound = 3 mean
         * ()()?()? for lowerbound = 1
         * 
         */
        // but because of the separator, + is not really usable,
        // (xyz)((separator)xyz)* must be used instead, and (()*)? instead of ()*
        boolean isMultiple = multiplicity.getUpperBound() > 1 || multiplicity.getUpperBound() < 0;
        boolean isOptional = multiplicity.isOptional();

        // propertyConstraints may override the native multiplicity. This is the
        // case when
        // the current sequence is within a isDefinedExp ore OneExp, where
        // optionality is checked.
        List<RuleBodyPropertyConstraint> constraints = buffer.getCurrentConstraints();
        for (RuleBodyPropertyConstraint constraint : constraints) {
            if (constraint instanceof PropertyQuantityConstraint) {
                PropertyQuantityConstraint quantityConstraint = (PropertyQuantityConstraint) constraint;

                if (quantityConstraint.getPropertyName().equals(getPropertyName(prop))) {
                    if (quantityConstraint.getKey() == PropertyQuantityConstraint.ISDEFINED_KEY) {
                        if (quantityConstraint.isValue() == true) {
                            if (!isMultiple) {
                                isOptional = false;
                                // Like TCS, still allow optional
                                // multivaluedelements to remain optional.
                            }
                        } else {
                            throw new SyntaxElementException("Property used within context where it is not defined.", prop);
                        }
                    } else if (quantityConstraint.getKey() == PropertyQuantityConstraint.ONE_KEY) {
                        if (quantityConstraint.isValue() == true) {
                            isMultiple = false;
                            isOptional = false;
                        } else {
                            // keep multiplicity as from metamodel
                        }
                    } else {
                        // should never happen
                        throw new RuntimeException("Unknown property constraint key: " + quantityConstraint.getKey());
                    }
                }
            }
        }

        if (isMultiple) {
            // cases: (xyz ((SEP)xyz)* ), (xyz ((SEP)xyz)* ) ?,
            // (xyz((SEP)xyz)((SEP)xyz)((SEP)xyz)+)

            // lowerbound variable as combination of metamodel information and
            // syntax information
            int lowerBound = 0;
            if (multiplicity.getLowerBound() > lowerBound) {
                lowerBound = multiplicity.getLowerBound();
            }
            if (args.forcedLower != null) {
                lowerBound = args.forcedLower.getValue();
            }
            // upperbound variable as combination of metamodel information and
            // syntax information
            int upperBound = multiplicity.getUpperBound();
            boolean isUpperUnbounded = multiplicity.getUpperBound() < 0;

            if (args.forcedUpper != null) {
                upperBound = args.forcedUpper.getValue();
                isUpperUnbounded = false;
            }
            String disambiguation = null;
            if (args.disambiguatePArg != null) {
                disambiguation = args.disambiguatePArg.getDisambiguation();
            }

            if (lowerBound > 1 && !isInMulti) {
                buffer.append('(', repeatablePart.toString());
                for (int i = 0; i < lowerBound - 1; i++) {
                    buffer.append(' ');
                    appendBitWithSeparator(buffer, repeatablePart, args.separator, disambiguation);
                }

                // now either make the last element repeatable unlimited times,
                // or add ()?()?()? for the remaining optional times it may
                // occur
                if (isUpperUnbounded) {
                    buffer.append('+'); // add + to the last brackets
                } else {
                    for (int i = lowerBound; i < upperBound; i++) {
                        buffer.append(' ');
                        appendBitWithSeparator(buffer, repeatablePart, args.separator, disambiguation);
                        buffer.append('?');
                    }
                }

                buffer.append(')');
            } else { // lowerbound = 0 or 1
                // TODO: Check for property Args that are being ignored (i.e. separator)
                buffer.append('(');
                if (lowerBound == 0) {
                    if (disambiguation != null) {
                        buffer.append('(');
                        buffer.append(disambiguation);
                        buffer.append(")=>");
                    }
                }
                buffer.append(repeatablePart.toString());
                // now either add unlimited optional part including the separator, or n times () () ()?
                if (!isInMulti) {
                    if (isUpperUnbounded) {
                        buffer.append(' ');
                        appendBitWithSeparator(buffer, repeatablePart, args.separator, disambiguation);
                        buffer.append("* "); // add * to the inner brackets
                    } else {
                        for (int i = 0; i < upperBound - 1; i++) {
                            buffer.append(' ');
                            appendBitWithSeparator(buffer, repeatablePart, args.separator, disambiguation);
                            buffer.append('?');
                        }
                    }
                }
                buffer.append(')');

                if (isOptional == true) {
                    if (lowerBound == 0) {
                        buffer.append("? ");
                    }
                }
            }
        } else { // not multiple
            buffer.append('(', repeatablePart.toString(), ')');

            // TODO: compare forcedLower with Metamodel, generate warning

            // add ? or not
            if (isOptional == true) {
                if (args.forcedLower == null || args.forcedLower.getValue() == 0) {
                    buffer.append("? ");
                }
            }
        }

    }

    /**
     * helper method to add "((%Separator%) %repeatablePart%)" to the buffer.
     * 
     * @param buffer
     * @param repeatablePart
     * @param disambiguate
     *            If not <tt>null</tt>, this will be surrounded with "(...)=>"
     *            and prepended to the <tt>repeatablePart</tt>. Use a non-
     *            <tt>null</tt> value here in case the grammar specifies a
     *            disambiguation for the property and this occurrence is
     *            optional. Then, the disambiguation works between matching the
     *            optional property and the right context.
     * @param args
     * @throws SyntaxParsingException
     * @throws MetaModelLookupException
     * @throws MetamodelNameResolvingException
     */
    protected static void appendBitWithSeparator(RuleBodyStringBuffer buffer, StringBuilder repeatablePart,
            SeparatorPArg separatorArg, String disambiguate) throws MetaModelLookupException {
        buffer.append('('); // close with )*

        // check Separator
        if (separatorArg != null) {

            Sequence separator = null;
            separator = separatorArg.getSeparatorSequence();
            if (separator != null) {
                buffer.append(ObservationDirectivesHelper.getEnterSeparatorSequenceNotification());
                buffer.addToRuleFragment(separator);
                buffer.append(ObservationDirectivesHelper.getExitSeparatorSequenceNotification());
            }
        }

        if (disambiguate != null) {
            buffer.append('(');
            buffer.append(disambiguate);
            buffer.append(")=>");
        }
        buffer.append(repeatablePart.toString(), ')');
    }

    /**
     * Utility wrapper for the PArg List attached to a Property in TCS. TCS has
     * a List of PArgs attached to Properties just as a modeling convention, in
     * reality only one of each PArg type can be present, therefore this is
     * equivalent to a bean where each type of arg is either set or not
     * 
     * @author C5107456
     */
    protected static final class PropertyArgs {

        public SeparatorPArg separator;
        
        public ForcedLowerPArg forcedLower;
        public ForcedUpperPArg forcedUpper;

        public AsPArg asPArg;

        public RefersToPArg refersTo;
        public LookInPArg lookInPArg;
        public AutoCreatePArg autoCreatePArg;
        public CreateAsPArg createAsPArg;
        public CreateInPArg createInPArg;
        public ImportContextPArg importContextPArg;

        public ModePArg modePArg;
        public PartialPArg partialPArg;
        
        public LookupScopePArg lookupScopePArg;
        public ReferenceByPArg referenceByPArg;
        public PrefixPArg prefixPArg;
        public PostfixPArg postfixPArg;
        
        public DisambiguatePArg disambiguatePArg;
        

        protected PropertyArgs(Collection<PropertyArg> args) throws SyntaxElementException {
            if (args == null) {
                return;
            }
            for (PropertyArg propertyArg : args) {
                if (propertyArg instanceof SeparatorPArg) {
                    if (separator != null) {
                        throw new SyntaxElementException("Double definition of separator", propertyArg);
                    }
                    separator = (SeparatorPArg) propertyArg;
                    // TODO validate contents here and below, add to error
                    // bucket else
                } else if (propertyArg instanceof RefersToPArg) {
                    if (refersTo != null) {
                        throw new SyntaxElementException("Double definition of RefersToPArg", propertyArg);
                    }
                    refersTo = (RefersToPArg) propertyArg;
                } else if (propertyArg instanceof ForcedLowerPArg) {
                    if (forcedLower != null) {
                        throw new SyntaxElementException("Double definition of ForcedLowerPArg", propertyArg);
                    }
                    forcedLower = (ForcedLowerPArg) propertyArg;
                } else if (propertyArg instanceof ForcedUpperPArg) {
                    if (forcedUpper != null) {
                        throw new SyntaxElementException("Double definition of ForcedLowerPArg", propertyArg);
                    }
                    forcedUpper = (ForcedUpperPArg) propertyArg;

                } else if (propertyArg instanceof AsPArg) {
                    if (asPArg != null) {
                        throw new SyntaxElementException("Double definition of AsPArg", propertyArg);
                    }
                    asPArg = (AsPArg) propertyArg;
                } else if (propertyArg instanceof LookInPArg) {
                    if (lookInPArg != null) {
                        throw new SyntaxElementException("Double definition of LookInPArg", propertyArg);
                    }
                    lookInPArg = (LookInPArg) propertyArg;
                } else if (propertyArg instanceof AutoCreatePArg) {
                    if (autoCreatePArg != null) {
                        throw new SyntaxElementException("Double definition of AutoCreatePArg", propertyArg);
                    }
                    autoCreatePArg = (AutoCreatePArg) propertyArg;
                } else if (propertyArg instanceof CreateAsPArg) {
                    if (createAsPArg != null) {
                        throw new SyntaxElementException("Double definition of CreateAsPArg", propertyArg);
                    }
                    createAsPArg = (CreateAsPArg) propertyArg;
                } else if (propertyArg instanceof CreateInPArg) {
                    if (createInPArg != null) {
                        throw new SyntaxElementException("Double definition of CreateInPArg", propertyArg);
                    }
                    createInPArg = (CreateInPArg) propertyArg;
                } else if (propertyArg instanceof ImportContextPArg) {
                    if (importContextPArg != null) {
                        throw new SyntaxElementException("Double definition of ImportContextPArg", propertyArg);
                    }
                    importContextPArg = (ImportContextPArg) propertyArg;
                } else if (propertyArg instanceof ModePArg) {
                    if (modePArg != null) {
                        throw new SyntaxElementException("Double definition of ImportContextPArg", propertyArg);
                    }
                    modePArg = (ModePArg) propertyArg;
                } else if (propertyArg instanceof LookupScopePArg) {
                    if (lookupScopePArg != null) {
                        throw new SyntaxElementException("Double definition of lookupScopePArg", lookupScopePArg);
                    }
                    lookupScopePArg = (LookupScopePArg) propertyArg;
                } else if (propertyArg instanceof ReferenceByPArg) {
                    if (referenceByPArg != null) {
                        throw new SyntaxElementException("Double definition of referenceByPArg", referenceByPArg);
                    }
                    referenceByPArg = (ReferenceByPArg) propertyArg;
                } else if (propertyArg instanceof PrefixPArg) {
                    if (prefixPArg != null) {
                        throw new SyntaxElementException("Double definition of prefixPArg", prefixPArg);
                    }
                    prefixPArg = (PrefixPArg) propertyArg;
                } else if (propertyArg instanceof PostfixPArg) {
                    if (postfixPArg != null) {
                        throw new SyntaxElementException("Double definition of postfixPArg", postfixPArg);
                    }
                    postfixPArg = (PostfixPArg) propertyArg;
                } else if (propertyArg instanceof DisambiguatePArg) {
                    if (disambiguatePArg != null) {
                        throw new SyntaxElementException("Double definition of disambiguateParg", disambiguatePArg);
                    }
                    disambiguatePArg = (DisambiguatePArg) propertyArg;
                } else if (propertyArg instanceof PartialPArg) {
                    if (partialPArg != null) {
                        throw new SyntaxElementException("Double definition of partialPArg", partialPArg);
                    }
                    partialPArg = (PartialPArg) propertyArg;
                } else {
                    throw new RuntimeException("PropertyArg type not supported yet:" + propertyArg.getClass());
                }
            }
        }
    }

    public void setSkipDelayedReferences(boolean skipDelayedReferences) {
        this.skipDelayedReferences = skipDelayedReferences;
    }

}
