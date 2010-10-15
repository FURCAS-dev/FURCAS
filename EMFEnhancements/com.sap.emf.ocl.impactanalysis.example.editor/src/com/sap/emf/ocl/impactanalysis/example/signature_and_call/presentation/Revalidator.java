package com.sap.emf.ocl.impactanalysis.example.signature_and_call.presentation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.ui.action.ValidateAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.ecore.OCLExpression;

import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;
import com.sap.ocl.oppositefinder.query2.Query2OppositeEndFinder;

import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzerFactory;
import de.hpi.sam.bp2009.solution.oclToAst.EAnnotationOCLParser;
import de.hpi.sam.bp2009.solution.oclToAst.OclToAstFactory;
import de.hpi.sam.bp2009.solution.queryContextScopeProvider.impl.ProjectDependencyQueryContextProvider;

public class Revalidator {
    private final EventManager eventManager;
    @SuppressWarnings("unused") // needed to hold on to event adapters to avoid their being GC'ed
    private final Collection<Adapter> adapters;

    public Revalidator(AdapterFactoryEditingDomain editingDomain, EPackage pkg) {
        eventManager = EventManagerFactory.eINSTANCE.createEventManagerFor(editingDomain.getResourceSet());
        adapters = createImpactAnalyzersForInvariants(editingDomain.getResourceSet(), pkg);
    }

    private Collection<Adapter> createImpactAnalyzersForInvariants(ResourceSet resourceSet, EPackage pkg) {
        Collection<Adapter> result = new LinkedList<Adapter>();
        OppositeEndFinder oppositeEndFinder = new Query2OppositeEndFinder(new ProjectDependencyQueryContextProvider());
        for (final OCLExpression invariant : getInvariants(pkg)) {
            final ImpactAnalyzer impactAnalyzer = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(invariant,
                    /* notifyOnNewContextElements */ true, oppositeEndFinder);
            Adapter adapter = new AdapterImpl() {
                @Override
                public void notifyChanged(Notification msg) {
                    // revalidate invariant on context objects that impact analysis will produce:
                    Collection<EObject> revalidateOn = impactAnalyzer.getContextObjects(msg);
                    if (revalidateOn != null && !revalidateOn.isEmpty()) {
                        revalidate(revalidateOn);
                    }
                }
            };
            result.add(adapter);
            eventManager.subscribe(impactAnalyzer.createFilterForExpression(), adapter);
        }
        return result;
    }

    private Collection<OCLExpression> getInvariants(EPackage pkg) {
        Collection<OCLExpression> result = new LinkedList<OCLExpression>();
        EAnnotationOCLParser annotationsParser = OclToAstFactory.eINSTANCE.createEAnnotationOCLParser();
        for (EClassifier cls : pkg.getEClassifiers()) {
            EAnnotation ann = cls.getEAnnotation(EcorePackage.eNS_URI);
            if (ann != null) {
                String spaceSeparatedConstraintNames = ann.getDetails().get("constraints");
                if (spaceSeparatedConstraintNames != null) {
                    String[] constraintNames = spaceSeparatedConstraintNames.split(" ");
                    for (String constraintName : constraintNames) {
                        OCLExpression invariant = annotationsParser.getExpressionFromAnnotationsOf(cls, constraintName);
                        result.add(invariant);
                    }
                }
            }
        }
        return result;
    }

    private void revalidate(Collection<EObject> revalidateOn) {
        ValidateAction validateAction = new ValidateAction();
        IStructuredSelection selection = new StructuredSelection(new ArrayList<EObject>(revalidateOn));
        validateAction.updateSelection(selection);
        validateAction.run();
    }
}
