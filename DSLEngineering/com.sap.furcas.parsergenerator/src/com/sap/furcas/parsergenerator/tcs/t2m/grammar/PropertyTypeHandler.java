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

import org.eclipse.emf.ecore.EStructuralFeature;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreateKind;
import com.sap.furcas.metamodel.FURCAS.TCS.AutoCreatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateAsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.CreateInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.DisambiguatePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.FilterPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedLowerPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ForcedUpperPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ImportContextPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.LookInPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ModePArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PartialPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyArg;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.QueryByIdentifierPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.QueryPArg;
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
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 * The Class PropertyTypeHandler.
 * 
 * TODO: once queryByIdentifier is bootrapped and stable, entirely remove QueryPArg and InvertPArg
 */
public class PropertyTypeHandler<Type extends Object> {

    /** The meta lookup. */
    private IMetaModelLookup<Type> metaLookup;

    /** The syntax lookup. */
    private SyntaxLookup syntaxLookup;

    private TemplateNamingHelper<Type> namingHelper;

    private SemanticErrorBucket errorBucket;

    private MetaModelElementResolutionHelper<Type> resolutionHelper;

    private boolean skipDelayedReferences = false;

    /**
     * Instantiates a new property type handler.
     * 
     * @param metaLookup
     *            the meta lookup
     * @param syntaxLookup
     *            the syntax lookup
     * @param namingHelper
     * @param errorBucket
     */
    protected PropertyTypeHandler(IMetaModelLookup<Type> metaLookup, SyntaxLookup syntaxLookup,
            TemplateNamingHelper<Type> namingHelper, SemanticErrorBucket errorBucket) {
        super();
        this.metaLookup = metaLookup;
        this.syntaxLookup = syntaxLookup;
        this.namingHelper = namingHelper;
        this.errorBucket = errorBucket;
        this.resolutionHelper = new MetaModelElementResolutionHelper<Type>(metaLookup);
    }

    /**
     * @param handlerConfig
     */
    protected PropertyTypeHandler(SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
        this(handlerConfig.getMetaLookup(), handlerConfig.getSyntaxLookup(), handlerConfig.getNamingHelper(), handlerConfig
                .getErrorBucket());
    }

    /**
     * Adds the element.
     * 
     * @param prop
     *            the prop
     * @param buffer
     *            the buffer
     * 
     * @throws SyntaxParsingException
     *             the syntax parsing exception
     * @throws MetaModelLookupException
     *             the meta model lookup exception
     */
    public void addElement(Property prop, RuleBodyStringBuffer buffer) throws SyntaxElementException, MetaModelLookupException {
        try {
            String propertyName = getPropertyName(prop);
            PropertyArgs args = new PropertyArgs(prop.getPropertyArgs());

            validateArgs(args);

            // get Owner of this property
            QualifiedNamedElement propertyOwnerTypeTemplate = syntaxLookup.getEnclosingQualifiedElement(prop);

            // get Type of this Property
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty = TcsUtil.getReferencedType(prop, buffer, propertyName,
                    propertyOwnerTypeTemplate, resolutionHelper, metaLookup);

            StringBuilder repeatablePart = new StringBuilder();
            if (args.refersTo != null) { // need resolving of reference
                if (args.oclQueryPArg != null) {
                    addQueriedReferenceCode(prop, repeatablePart, metaModelTypeOfProperty, propertyName, args);
                } else {
                    addRefersToCode(prop, repeatablePart, metaModelTypeOfProperty, propertyName, args);
                }
            } else if (args.asPArg != null && args.oclQueryPArg != null) {
                // it is also allowed to use the query arg while specifying a
                // template for parsing the written reference value.
                addQueriedReferenceCode(prop, repeatablePart, metaModelTypeOfProperty, propertyName, args);
            } else if (args.oclQueryByIdentifierPArg != null) {
                addQueriedReferenceCode(prop, repeatablePart, metaModelTypeOfProperty, propertyName, args);
            } else { // property not to be referenced but used within
                repeatablePart.append(" temp=");
                if (args.asPArg != null) {
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

                        repeatablePart.append(ruleName);
                    } else {
                        repeatablePart.append(args.asPArg.getValue());
                    }
                } else {
                    // use type name for rule name, unless it is a DataType
                    // (then use primitive template for that datatype)

                    PrimitiveTemplate propertyPrimitiveTemplate = syntaxLookup
                            .getDefaultPrimitiveTemplateRule(metaModelTypeOfProperty);
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
                if (args.modePArg != null) {
                    repeatablePart.append(TemplateNamingHelper.getModeSuffix(args.modePArg.getMode()));
                }
                repeatablePart.append(" {setProperty(ret, \"").append(propertyName)
                        .append("\", temp);\nsetParent(temp,ret,\"" + propertyName + "\");}");
            }

            // treat multiplicity
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

            addRepeatableWithMultiplicity(buffer, prop, repeatablePart, multiplicity, args);

        } catch (MetamodelNameResolvingException e) {
            throw new SyntaxElementException(e.getMessage(), prop, e);
            // } catch (SyntaxElementException spe) {
            // throw new
            // SyntaxElementException("Exception while generating grammar for Property "
            // + prop.getName(), prop, spe );
        }
    }

    /**
     * @param args
     */
    private void validateArgs(PropertyArgs args) {
        if (args.refersTo == null) {
            if (args.oclQueryPArg != null && args.asPArg == null) {
                errorBucket.addWarning("Query only possible with refersTo or as", args.oclQueryPArg);
            }
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
        } else {
            if (args.oclQueryPArg != null) {
                if (args.autoCreatePArg != null) {
                    errorBucket.addWarning("AutoCreate ignored when query is given", args.autoCreatePArg);
                }
                if (args.createAsPArg != null) {
                    errorBucket.addWarning("CreateAs ignored when query is given", args.createAsPArg);
                }
                if (args.createInPArg != null) {
                    errorBucket.addWarning("CreateIn ignored when query is given", args.createInPArg);
                }
                if (args.lookInPArg != null) {
                    errorBucket.addWarning("LookIn ignored when query is given", args.lookInPArg);
                }
                if (args.importContextPArg != null) {
                    errorBucket.addWarning("ImportContext ignored when query is given", args.importContextPArg);
                }
            }
            if (args.asPArg != null) {
                errorBucket.addWarning("As only possible without refersTo", args.asPArg);
            }
            if (args.modePArg != null) {
                errorBucket.addWarning("Mode only possible without refersTo", args.modePArg);
            }

        }
    }

    /**
     * @param prop
     * @return
     */
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

    /**
     * @param prop
     * @param repeatablePart
     * @param metaModelTypeOfProperty
     * @param name
     * @param args
     * @throws SyntaxElementException
     * @throws MetaModelLookupException
     */
    private void addQueriedReferenceCode(Property prop, StringBuilder ruleBodyPart,
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfPropertyListName, String propertyName, PropertyArgs args)
            throws SyntaxElementException, MetaModelLookupException {
        // creates temp = ...
        appendRefersToTempPart(prop, ruleBodyPart, metaModelTypeOfPropertyListName, args, true);

        // creates the bit that sets the temp from above as reference to
        // modelElement "ret" of this rule
        
        // TODO: cleanup required: remove oclQueryPArg handling
        String query = null;
        if (args.oclQueryByIdentifierPArg == null) {
            query = args.oclQueryPArg.getQuery() + (args.oclFilterPArg != null ? args.oclFilterPArg.getFilter() : "");
        } else {
            query = args.oclQueryByIdentifierPArg.getQueryByIdentifier() + "->select(" +  args.oclQueryByIdentifierPArg.getFeature() + " = ?)";
        }
        String oclQuery = query.replaceAll("\\\"", "\\\\\"");
        oclQuery = oclQuery.replaceAll("\r\n", "\"+\r\n\"");
        oclQuery = oclQuery.replaceAll("\n", "\"+\n\"");

        validateOclQuery(prop, args, query);

        if (args.refersTo != null) {
            if (!skipDelayedReferences) {
                ruleBodyPart.append(concatBuf(" {setOclRef(ret, \"", propertyName, "\", \"", args.refersTo.getPropertyName(),
                        "\", temp, \"" + oclQuery + "\");}"));
            }
        } else {
            if (!skipDelayedReferences) {
                ruleBodyPart.append(concatBuf(" {setOclRef(ret, \"", propertyName, "\", null, temp, \"" + oclQuery + "\");}"));
            }
        }

    }

    private void validateOclQuery(Property prop, PropertyArgs args, String query) {
        Object context = prop.getParentTemplate().getMetaReference();
        List<String> oclErrors = metaLookup.validateOclQuery(prop.getParentTemplate(), query, context);
        for (String error : oclErrors) {
            errorBucket.addError(error, args.oclQueryPArg);
        }
    }

    /**
     * Adds to the rulepart the String "temp=\<rulename\>{setRef(ret,
     * propertyTemplate, propertyType, refersTo.PropertyName, temp,...)". This
     * means that an Object temp is created using either the parsing rule
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
     * @param prop
     * @param ruleBodyPart
     * @param metaModelTypeOfProperty
     * @param refersTo
     * @param asPArg
     * @throws MetaModelLookupException
     * @throws SyntaxParsingException
     * @throws MetamodelNameResolvingException
     * @throws SyntaxElementException
     */
    private void addRefersToCode(Property prop, StringBuilder ruleBodyPart,
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty, String propertyName, PropertyArgs args)
            throws MetaModelLookupException, MetamodelNameResolvingException, SyntaxElementException {
        // appends the temp = ... part
        appendRefersToTempPart(prop, ruleBodyPart, metaModelTypeOfProperty, args, false);

        // now append the part that sets temp as reference of modelelement "ret"
        // of this rule

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

    /**
     * @param prop
     * @param ruleBodyPart
     * @param metaModelTypeOfPropertyReference
     * @param args
     * @param refersTo
     * @throws SyntaxElementException
     * @throws MetaModelLookupException
     */
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
                String propertyName = null;
                if (args.oclQueryByIdentifierPArg == null) {
                    propertyName = args.refersTo.getPropertyName();
                } else {
                    propertyName = args.oclQueryByIdentifierPArg.getFeature();
                }
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

    /**
     * @param argPropertyName
     * @return
     */
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

    /**
     * helper method to deal with multiplicity. Add the repeatable part to the
     * buffer, and indicates expected multiplicity of this part.
     * 
     * @param buffer
     * @param repeatablePart
     * @param multiplicity
     * @param args
     * @throws SyntaxParsingException
     * @throws MetaModelLookupException
     * @throws MetamodelNameResolvingException
     */
    protected void addRepeatableWithMultiplicity(RuleBodyStringBuffer buffer, Property prop, StringBuilder repeatablePart,
            MultiplicityBean multiplicity, PropertyArgs args) throws SyntaxElementException, MetaModelLookupException {
        boolean isInMulti = false;
        if (prop != null && prop.getElementSequence() instanceof SequenceInAlternative
                && ((SequenceInAlternative) prop.getElementSequence()).getAlternativeContainer().isIsMulti()) {
            if (multiplicity.getUpperBound() != -1) {
                errorBucket
                        .addError(
                                "Alternative isMulti is only allows if all directly contained properties have an upper multiplicity of UNBOUNDED!",
                                prop);
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
        // (xyz)((separator)xyz)* must be used instead, and (()*)? instead of
        // ()*
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
                // TODO: Check for property Args that are being ignored (i.e.
                // separator)
                buffer.append('(');
                if (lowerBound == 0) {
                    if (disambiguation != null) {
                        buffer.append('(');
                        buffer.append(disambiguation);
                        buffer.append(")=>");
                    }
                }
                buffer.append(repeatablePart.toString());
                // now either add unlimited optional part including the
                // separator, or n times () () ()?
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

        /** The separator. */
        public SeparatorPArg separator;

        /** The refers to. */
        public RefersToPArg refersTo;

        /** The forced lower. */
        public ForcedLowerPArg forcedLower;

        /** The forced upper. */
        public ForcedUpperPArg forcedUpper;

        /** The as p arg. */
        public AsPArg asPArg;

        public LookInPArg lookInPArg;

        public AutoCreatePArg autoCreatePArg;

        public CreateAsPArg createAsPArg;

        public CreateInPArg createInPArg;

        public ImportContextPArg importContextPArg;

        public ModePArg modePArg;

        public PartialPArg partialPArg;

        private QueryPArg oclQueryPArg;

        private FilterPArg oclFilterPArg;

        private QueryByIdentifierPArg oclQueryByIdentifierPArg;

        private DisambiguatePArg disambiguatePArg;
        

        /**
         * Instantiates a new property args.
         * 
         * @param prop
         *            the prop
         * @throws SyntaxParsingException
         * @throws SyntaxElementException
         */
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
                } else if (propertyArg instanceof QueryPArg) {
                    if (oclQueryPArg != null) {
                        throw new SyntaxElementException("Double definition of queryParg", oclQueryPArg);
                    }
                    oclQueryPArg = (QueryPArg) propertyArg;
                } else if (propertyArg instanceof FilterPArg) {
                    if (oclFilterPArg != null) {
                        throw new SyntaxElementException("Double definition of filterParg", oclFilterPArg);
                    }
                    oclFilterPArg = (FilterPArg) propertyArg;
                } else if (propertyArg instanceof QueryByIdentifierPArg) {
                    if (oclQueryByIdentifierPArg != null) {
                        throw new SyntaxElementException("Double definition of queryByIdentifierPArg", oclQueryByIdentifierPArg);
                    }
                    oclQueryByIdentifierPArg = (QueryByIdentifierPArg) propertyArg;
                } else if (propertyArg instanceof DisambiguatePArg) {
                    if (disambiguatePArg != null) {
                        throw new SyntaxElementException("Double definition of disambiguateParg", oclQueryPArg);
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
