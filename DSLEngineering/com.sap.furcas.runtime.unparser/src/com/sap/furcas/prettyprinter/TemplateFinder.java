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
import com.sap.furcas.metamodel.FURCAS.TCS.ContextTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.EnumerationTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.OperatorTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.PrimitiveTemplate;
import com.sap.furcas.metamodel.FURCAS.TCS.Property;
import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.exceptions.SyntaxElementException;
import com.sap.furcas.runtime.common.interfaces.IMetaModelLookup;
import com.sap.furcas.runtime.common.interfaces.ResolvedNameAndReferenceBean;
import com.sap.furcas.runtime.tcs.PropertyArgumentUtil;
import com.sap.furcas.runtime.tcs.SyntaxLookup;

/**
 * @author Stephan Erb
 *
 */
public class TemplateFinder {

    private final SyntaxLookup syntaxLookup;
    private final IMetaModelLookup<EObject> metamodelLookup;
    
    public TemplateFinder(SyntaxLookup syntaxLookup, IMetaModelLookup<EObject> metamodelLookup) {
        this.syntaxLookup = syntaxLookup;
        this.metamodelLookup = metamodelLookup;
    }
    
    public PrimitiveTemplate findPrimitiveTemplate(Property seqElem) {
        AsPArg asParg = PropertyArgumentUtil.getAsPArg(seqElem);
        if (asParg == null) {
            // FIXME!
            return null;  // syntaxLookup.getDefaultPrimitiveTemplateRule(metaModelTypeOfPropertyReference);
        } else {
            return (PrimitiveTemplate) asParg.getTemplate();
        }
    }

    public Collection<ContextTemplate> findMatchingContextTemplates(EObject modelElement, String mode) {
        EClass eClass = modelElement.eClass();
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

    /**
     * @param seqElem
     * @return
     */
    public EnumerationTemplate findEnumerationTemplate(Property seqElem) {
        // TODO Auto-generated method stub
        return null;
    }

}
