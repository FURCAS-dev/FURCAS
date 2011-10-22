/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.prettyprinter;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.AsPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.ClassTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.ReferenceByPArg;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.prettyprinter.exceptions.AmbigousTemplateException;
import com.sap.furcas.prettyprinter.exceptions.NoMatchingTemplateException;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.NameResolutionFailedException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.tcs.MetaModelElementResolutionHelper;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.SyntaxLookup;
import com.sap.furcas.runtime.tcs.TcsUtil;

/**
 * A {@link TemplateFinder} is used to search through the templates of a {@link ConcreteSyntax}. 
 * 
 * @author Stephan Erb
 *
 */
public class TemplateFinder {

    private final SyntaxLookup syntaxLookup;
    private final IMetaModelLookup<EObject> metamodelLookup;
    private final MetaModelElementResolutionHelper<EObject> resolutionHelper;
    
    public TemplateFinder(SyntaxLookup syntaxLookup, IMetaModelLookup<EObject> metamodelLookup) {
        this.syntaxLookup = syntaxLookup;
        this.metamodelLookup = metamodelLookup;
        this.resolutionHelper = new MetaModelElementResolutionHelper<EObject>(metamodelLookup);
    }
    
    public PrimitiveTemplate findPrimitiveTemplate(Property seqElem) {
        AsPArg asParg = PropertyArgumentUtil.getAsPArg(seqElem);
        if (asParg == null) {
            try {
                ResolvedNameAndReferenceBean<EObject> metaElementRef = resolutionHelper.resolve(
                        syntaxLookup.getEnclosingQualifiedElement(seqElem));
                ResolvedNameAndReferenceBean<EObject> metamodelType = metamodelLookup.getFeatureClassReference(
                        metaElementRef, TcsUtil.getPropertyName(seqElem.getPropertyReference()));
                
                ReferenceByPArg refByParg = PropertyArgumentUtil.getReferenceByPArg(seqElem);
                if (refByParg == null) {
                    return syntaxLookup.getDefaultPrimitiveTemplateRule(metamodelType);
                } else {
                    String referenceByQuery = PropertyArgumentUtil.getReferenceByAsOCL(refByParg);
                    EObject type = metamodelLookup.getOclReturnType(metamodelType.getReference(), referenceByQuery);
                    ResolvedNameAndReferenceBean<EObject> metaModelTypeOfQueryResult = metamodelLookup.resolveReferenceName(type);
                    return syntaxLookup.getDefaultPrimitiveTemplateRule(metaModelTypeOfQueryResult);
                }
            } catch (NameResolutionFailedException e) {
                throw new RuntimeException(e);
            } catch (MetaModelLookupException e) {
                throw new RuntimeException(e);
            } catch (SyntaxElementException e) {
                throw new RuntimeException(e);
            }
        } else {
            return (PrimitiveTemplate) asParg.getTemplate();
        }
    }

    public Collection<ContextTemplate> findMatchingContextTemplates(EClass eClass, String mode) {
        Collection<ContextTemplate> templates = new ArrayList<ContextTemplate>(1);
        try {
            ResolvedNameAndReferenceBean<EObject> resolvedName = metamodelLookup.resolveReferenceName(eClass);
            Collection<Template> candidates = syntaxLookup.getTCSTemplate(resolvedName, mode);
            for (Template  candidate : candidates) {
                if (candidate instanceof OperatorTemplate) {
                    templates.add((OperatorTemplate) candidate);
                }
                if (candidate instanceof ClassTemplate && !((ClassTemplate) candidate).isIsAbstract()) {
                    templates.add((ClassTemplate) candidate);
                }
            }
            if (templates.isEmpty() ) {
                for (EClass supertype : eClass.getESuperTypes()) {
                    templates.addAll(findMatchingContextTemplates(supertype, mode));
                }
            }
            return templates;
        } catch (MetaModelLookupException e) {
            throw new RuntimeException(e);
        } catch (SyntaxElementException e) {
            throw new RuntimeException(e);
        }
    }

    public EnumerationTemplate findEnumerationTemplate(Property seqElem) throws NoMatchingTemplateException, AmbigousTemplateException {
        try {
            ResolvedNameAndReferenceBean<EObject> resolvedName = metamodelLookup.resolveReferenceName(TcsUtil.getType(seqElem));
            Collection<EnumerationTemplate> templates = filterFor(syntaxLookup.getTCSTemplate(resolvedName, /*mode*/null),
                    EnumerationTemplate.class);

            if (templates.size() < 1) {
                throw new NoMatchingTemplateException(TcsUtil.getType(seqElem));
            } else if (templates.size() > 1) {
                throw new AmbigousTemplateException(TcsUtil.getType(seqElem), templates.size());
            } else {
                return templates.iterator().next();
            }
        } catch (MetaModelLookupException e) {
            throw new RuntimeException(e);
        } catch (SyntaxElementException e) {
            throw new RuntimeException(e);
        }
    }

    private <E> Collection<E> filterFor(Collection<?> elements, Class<E> clazz) {
        ArrayList<E> result = new ArrayList<E>();
        for (Object e : elements) {
            if (clazz.isInstance(e)) {
                result.add(clazz.cast(e));
            }
        }
        return result;
    }

}
