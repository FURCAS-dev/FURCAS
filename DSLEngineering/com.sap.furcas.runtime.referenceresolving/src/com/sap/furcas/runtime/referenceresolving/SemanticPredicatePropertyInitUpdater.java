package com.sap.furcas.runtime.referenceresolving;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;

import com.sap.furcas.metamodel.FURCAS.TCS.Template;
import com.sap.furcas.runtime.common.util.ContextAndForeachHelper;

/**
 * Used to set a property by executing one of multiple possible templates that have non-empty but equal syntax. Which template to
 * use is determined by an OCL expression evaluated in the context of the element whose property is to be set.
 * 
 * @author Axel Uhl (D043530)
 * 
 */
public class SemanticPredicatePropertyInitUpdater extends AbstractFurcasOCLBasedModelUpdater {
    private final List<SemanticDisambRuleData> predicates;
    private final Template containingTemplate;

    public class SemanticDisambRuleData {
        private final Template templateToInvoke;
        private final String ocl;

        public SemanticDisambRuleData(Template templateToInvoke, String ocl) {
            super();
            this.templateToInvoke = templateToInvoke;
            this.ocl = ocl;
        }

        public String getOCL() {
            return ocl;
        }

        public Template getTemplateToInvoke() {
            return templateToInvoke;
        }
    }

    protected SemanticPredicatePropertyInitUpdater(EStructuralFeature propertyToUpdate, OppositeEndFinder oppositeEndFinder,
            List<SemanticDisambRuleData> predicates, Template containingTemplate) {
        super(propertyToUpdate, oppositeEndFinder, /* expression TODO */ null, /* notifyOnNewContextElements TODO */ true, /* TODO */ SelfKind.SELF);
        this.predicates = predicates;
        this.containingTemplate = containingTemplate;
    }

    @Override
    public void notify(OCLExpression expression, Collection<EObject> affectedContextObjects, OppositeEndFinder oppositeEndFinder) {
        // TODO Implement SemanticPredicatePropertyInitUpdater.notify(...)

    }

    @Override
    public Collection<OCLExpression> getTriggerExpressionsWithoutContext() {
        Collection<OCLExpression> result = new LinkedList<OCLExpression>();
        Helper oclHelper = com.sap.emf.ocl.util.OCL.newInstance(getOppositeEndFinder()).createOCLHelper();
        for (SemanticDisambRuleData predicate : predicates) {
            try {
                oclHelper.setContext(ContextAndForeachHelper.getParsingContext(predicate.getOCL(), containingTemplate));
                result.add(oclHelper.createQuery(ContextAndForeachHelper.prepareOclQuery(predicate.getOCL())));
            } catch (ParserException e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
