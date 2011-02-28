/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-09-19 13:53:53 +0200 (Fr, 19 Sep 2008) $
 * @version $Revision: 1832 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m.grammar;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ForeachPredicatePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorAction;
import com.sap.furcas.metamodel.FURCAS.TCS.InjectorActionsBlock;
import com.sap.furcas.metamodel.FURCAS.TCS.LookupPropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PredicateSemantic;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitivePropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyInit;
import com.sap.furcas.metamodel.FURCAS.TCS.PropertyReference;
import com.sap.furcas.metamodel.FURCAS.TCS.QualifiedNamedElement;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.PropertyInstanceOfConstraint;
import com.sap.furcas.parsergenerator.tcs.t2m.grammar.constraints.RuleBodyPropertyConstraint;
import com.sap.furcas.parsergenerator.util.TcsUtil;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.tcs.MessageHelper;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.RuleNameFinder;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TemplateNamingHelper;

/**
 * handles separate Injector Actions which have no syntactic representation
 */
public class InjectorActionsHandler<Type> {

    private static final String OCL_QUERY_PREFIX = "OCL:";
    private final SemanticErrorBucket errorBucket;
    private final SyntaxLookup syntaxLookup;
    private final MetaModelElementResolutionHelper<Type> resolutionHelper;
    private final IMetaModelLookup<Type> metaLookup;
    private final TemplateNamingHelper<Type> namingHelper;

    /**
     * @param handlerConfig
     */
    public InjectorActionsHandler(SyntaxElementHandlerConfigurationBean<Type> handlerConfig) {
        errorBucket = handlerConfig.getErrorBucket();
        syntaxLookup = handlerConfig.getSyntaxLookup();
        metaLookup = handlerConfig.getMetaLookup();
        resolutionHelper = handlerConfig.getResolutionHelper();
        namingHelper = handlerConfig.getNamingHelper();
    }

    public void addElement(InjectorActionsBlock block, RuleBodyStringBuffer buffer) throws MetaModelLookupException,
            SyntaxElementException {
        Collection<InjectorAction> actions = block.getInjectorActions();
        if (actions == null || actions.size() == 0) {
            return;
        }

        Template propertyOwnerTypeTemplate = syntaxLookup.getEnclosingQualifiedElement(block);

        buffer.append('{');
        for (Iterator<InjectorAction> iterator = actions.iterator(); iterator.hasNext();) {
            InjectorAction injectorAction = iterator.next();

            if (injectorAction instanceof PropertyInit) {
                PropertyInit propInit = (PropertyInit) injectorAction;
                addPropertyInitAction(block, buffer, propertyOwnerTypeTemplate, propInit);

            } else {
                throw new RuntimeException("Unknown subclass of InjectorAction " + injectorAction.getClass());
            }
        }
        buffer.append('}');

    }

    /**
     * adds "{setProperty(propName, value);}" for a primitive template and
     * "{setRef(ret, propName, TypeOfProperty, null, null, value, null, null, false, null);}" if lookup init
     */
    private void addPropertyInitAction(InjectorActionsBlock block, RuleBodyStringBuffer buffer,
            QualifiedNamedElement propertyOwnerTypeTemplate, PropertyInit propInit) throws MetaModelLookupException,
            SyntaxElementException {
        String propName = getPropertyName(propInit);
        if (propName == null || propName.trim().equals("")) {
            errorBucket.addError("Empty property name.", propInit);
            return;
        }
        buffer.append(ObservationDirectivesHelper.getEnterInjectorActionNotification());
        String value = propInit.getValue();
        if (propInit instanceof PrimitivePropertyInit) {
            // TODO refer to and use Primitive template transformer to create
            // required
            // datatype
            buffer.append("setProperty(ret, \"" + propName + "\", " + value + ");");
        } else if (propInit instanceof LookupPropertyInit) {
            // //All property inits are now considered optional as their
            // violation will be error handled through constraint checking.
            boolean isOptional = true;
            ResolvedNameAndReferenceBean<Type> metaModelTypeOfPropertyReference = TcsUtil.getReferencedType(block, buffer,
                    propName, propertyOwnerTypeTemplate, resolutionHelper, metaLookup);
            String resolvedTypeOfPropertyName = namingHelper.getMetaTypeListParameter(metaModelTypeOfPropertyReference);
            
            if (value.startsWith(OCL_QUERY_PREFIX)) {
                validateOclQuery(block.getParentTemplate(), value, propInit);
                String oclQuery = TcsUtil.escapeMultiLineOclQuery(value);
                buffer.append("setOclRef(ret, \"" + propName + "\", null, null, \"" + oclQuery + "\", " + isOptional + ");");
            } else {
                buffer.append("setRef(ret, \"" + propName + "\", " + resolvedTypeOfPropertyName + ", null, null, \"" + value
                        + "\", null, null, false, null, " + isOptional + ");");
            }

        } else if (propInit instanceof ForeachPredicatePropertyInit) {
            String mode = ((ForeachPredicatePropertyInit) propInit).getMode();

            buffer.append("\n{\n");
            buffer.append("List<PredicateSemantic> list = new ArrayList<PredicateSemantic>();\n");
            buffer.append("RuleNameFinder finder = new RuleNameFinder();\n");
            Iterator<PredicateSemantic> semIt = ((ForeachPredicatePropertyInit) propInit).getPredicateSemantic().iterator();
            RuleNameFinder finder = new RuleNameFinder();

            while (semIt.hasNext()) {
                PredicateSemantic next = semIt.next();
                String localMode = mode;
                if (next.getMode() != null) {
                    localMode = next.getMode();
                }
                if (next.getWhen() != null) {
                    validateOclQuery(block.getParentTemplate(), next.getWhen(), propInit);
                    String oclQueryWhen = TcsUtil.escapeMultiLineOclQuery(next.getWhen());
                    buffer.append("list.add(new PredicateSemantic(\"" + oclQueryWhen + "\", \""
                            + finder.getRuleName(next.getAs(), localMode) + "\"));\n");
                } else {
                    buffer.append("list.add(new PredicateSemantic(null, \"" + finder.getRuleName(next.getAs(), localMode)
                            + "\"));\n");
                }
            }
            boolean hasContext = false;
            if (block.getParentTemplate() instanceof ClassTemplate) {
                hasContext = ((ClassTemplate) block.getParentTemplate()).isIsContext();
            }
            validateOclQuery(block.getParentTemplate(), value, propInit);
            String oclQuery = TcsUtil.escapeMultiLineOclQuery(value);
            if (mode == null) {
                buffer.append("setPredicateRef(ret,\"" + propName + "\",null,\"" + oclQuery + "\",list,finder," + hasContext
                        + ");");
            } else {
                buffer.append("setPredicateRef(ret,\"" + propName + "\",\"" + mode + "\",\"" + oclQuery + "\",list,finder,"
                        + hasContext + ");");
            }
            buffer.append("\n}\n");
        }
        buffer.append(ObservationDirectivesHelper.getExitInjectorActionNotification());
    }

    private void validateOclQuery(Template template, String query, PropertyInit propInit) {
        List<Diagnostic> oclErrors = metaLookup.validateOclQuery(template, query);
        for (Diagnostic error : oclErrors) {
            if(error.getSeverity() == Diagnostic.ERROR) {
                errorBucket.addError("Error: " + error.getMessage() + " in OCL query: \"" + query + "\"", propInit);
            } else if(error.getSeverity() == Diagnostic.WARNING) {
                errorBucket.addWarning("Warning: " + error.getMessage() + " in OCL query " + query, propInit);
            }
    }
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
    protected ResolvedNameAndReferenceBean<Type> getReferencedType(InjectorActionsBlock block, RuleBodyStringBuffer buffer,
            String name, QualifiedNamedElement propertyOwnerTypeTemplate) throws MetaModelLookupException, SyntaxElementException {

        // check for instanceof constraint context in current buffer
        List<RuleBodyPropertyConstraint> constraints = buffer.getCurrentConstraints();

        ResolvedNameAndReferenceBean<Type> substitutePropertyType = null;
        for (Iterator<RuleBodyPropertyConstraint> iterator = constraints.iterator(); iterator.hasNext();) {
            RuleBodyPropertyConstraint ruleBodyPropertyConstraint = iterator.next();
            if (ruleBodyPropertyConstraint instanceof PropertyInstanceOfConstraint) {
                PropertyInstanceOfConstraint instOfConst = (PropertyInstanceOfConstraint) ruleBodyPropertyConstraint;
                if (instOfConst.getPropertyName().equals(name)) {
                    List<String> substitutePropertyTypeName = instOfConst.getTypename();
                    substitutePropertyType = resolutionHelper.resolve(substitutePropertyTypeName);
                    // the last in the list wins, that's fine, since they can
                    // overrule each other.
                }
            }
        }

        ResolvedNameAndReferenceBean<Type> metaElementRef;
        try {
            metaElementRef = resolutionHelper.resolve(propertyOwnerTypeTemplate);
        } catch (NameResolutionFailedException e) {
            throw new SyntaxElementException(e.getMessage(), block, e);
        }
        ResolvedNameAndReferenceBean<Type> realMetaModelTypeOfPropertyTemplate = metaLookup.getFeatureClassReference(
                metaElementRef, name);

        // realMetaModelTypeOfPropertyTemplate =
        // syntaxLookup.getTCSTemplate(propertyTypeName);

        if (realMetaModelTypeOfPropertyTemplate == null) {
            throw new SyntaxElementException("Type " + MessageHelper.getTemplateName(propertyOwnerTypeTemplate)
                    + " has no feature " + name, block);
        }

        ResolvedNameAndReferenceBean<Type> metaModelTypeOfProperty;
        if (substitutePropertyType != null) {
            // check in Metamodel that new ownername is subclass of previous
            // one, else
            // error
            if (metaLookup.isSubTypeOf(substitutePropertyType, realMetaModelTypeOfPropertyTemplate)) {
                metaModelTypeOfProperty = substitutePropertyType;
            } else {
                throw new SyntaxElementException("Conditional subtype " + substitutePropertyType + " of feature " + name
                        + " is not a subtype of expected type " + realMetaModelTypeOfPropertyTemplate, block);
            }

        } else {
            metaModelTypeOfProperty = realMetaModelTypeOfPropertyTemplate;
        }

        return metaModelTypeOfProperty;
    }
}
