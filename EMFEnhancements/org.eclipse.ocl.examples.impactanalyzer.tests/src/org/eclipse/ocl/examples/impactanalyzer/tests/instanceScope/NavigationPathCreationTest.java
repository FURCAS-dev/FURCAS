/*******************************************************************************
 * Copyright (c) 2009, 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.tests.instanceScope;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.PropertyCallExp;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.examples.impactanalyzer.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.configuration.OptimizationActivation;
import org.eclipse.ocl.examples.impactanalyzer.filterSynthesis.FilterSynthesisImpl;
import org.eclipse.ocl.examples.impactanalyzer.impl.OCLFactoryImpl;
import org.eclipse.ocl.examples.impactanalyzer.instanceScope.PathCache;
import org.junit.Test;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromModelPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;

public class NavigationPathCreationTest extends TestCase {
    private Collection<OCLExpressionWithContext> classTcsExpressionList = null;
    private Collection<OCLExpressionWithContext> metamodelExpressionList = null;

    @Override
    public void setUp() {
        classTcsExpressionList = new OCLExpressionFromClassTcsPicker().pickUpExpressions();
        metamodelExpressionList = new OCLExpressionFromModelPicker().pickUpExpressions();
    }

    @Test
    public void testProducingNavigationStepsForTcsExpressions() {
        List<ExceptionWithExpression> excList = tryCreationAndCatchAllRuntimeExceptions(classTcsExpressionList);
        assertEquals(0, excList.size());
    }

    @Test
    public void testProducingNavigationStepsForMetamodelExpressions() {
        List<ExceptionWithExpression> excList = tryCreationAndCatchAllRuntimeExceptions(metamodelExpressionList);
        assertEquals(0, excList.size());
    }

    public List<ExceptionWithExpression> tryCreationAndCatchAllRuntimeExceptions(
            Collection<OCLExpressionWithContext> expressionList) {
        List<ExceptionWithExpression> excList = new ArrayList<ExceptionWithExpression>();

        for (OCLExpressionWithContext expression : expressionList) {
            try {
                excList.addAll(tryToCreateNavigationPaths(expression));
            } catch (RuntimeException e) {
                excList.add(new ExceptionWithExpression(e, expression));
            }
        }

        return excList;
    }

    public void printExceptions(List<ExceptionWithExpression> excList) {
        for (ExceptionWithExpression e : excList) {
            e.print();
        }
    }

    private class ExceptionWithExpression {
        private final Exception e;
        private final OCLExpressionWithContext expr;

        public ExceptionWithExpression(Exception e, OCLExpressionWithContext expr) {
            this.e = e;
            this.expr = expr;
        }

        public void print() {
            System.out.println(expr);
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private List<ExceptionWithExpression> tryToCreateNavigationPaths(OCLExpressionWithContext expression) {
        OCLFactory oclFactory = new OCLFactoryImpl();
        List<ExceptionWithExpression> excList = new ArrayList<ExceptionWithExpression>();

        FilterSynthesisImpl filterSynthesizer = new FilterSynthesisImpl(expression.getExpression(), false,
                com.sap.emf.ocl.util.OCL.newInstance());
        filterSynthesizer.getSynthesisedFilter();

        Map<EAttribute, Set<PropertyCallExp>> attributeCallExpressions = (Map<EAttribute, Set<PropertyCallExp>>) dirtyReflectionAttributeReader(
                "attributeCallExpressions", filterSynthesizer);
        Map<EReference, Set<NavigationCallExp>> associationEndCallExpressions = (Map<EReference, Set<NavigationCallExp>>) dirtyReflectionAttributeReader(
                "associationEndCallExpressions", filterSynthesizer);

        for (Set<PropertyCallExp> callExpressionSet : attributeCallExpressions.values()) {
            for (PropertyCallExp callExpression : callExpressionSet) {
                try {
                    ImpactAnalyzerImplWithPublicInstanceScopeAnalysis ia = new ImpactAnalyzerImplWithPublicInstanceScopeAnalysis(
                            callExpression,
                            /* notifyOnNewContextElements */ true,
                            OptimizationActivation.getOption(), oclFactory);
                    PathCache cache = new PathCache(DefaultOppositeEndFinder.getInstance());
                    cache.initInstanceScopeAnalysis(ia.createInstanceScopeAnalysis());
                    assertNotNull(cache.getOrCreateNavigationPath((OCLExpression) callExpression.getSource(),
                            expression.getContext(), filterSynthesizer, null, oclFactory));
                } catch (RuntimeException e) {
                    System.out.println(callExpression.getSource());
                    e.printStackTrace();
                    excList.add(new ExceptionWithExpression(e, expression));
                }
            }
        }

        for (Set<NavigationCallExp> callExpressionSet : associationEndCallExpressions.values()) {
            for (NavigationCallExp callExpression : callExpressionSet) {
                try {
                    ImpactAnalyzerImplWithPublicInstanceScopeAnalysis ia = new ImpactAnalyzerImplWithPublicInstanceScopeAnalysis(
                            callExpression,
                            /* notifyOnNewContextElements */ true,
                            OptimizationActivation.getOption(), oclFactory);
                    PathCache cache = new PathCache(DefaultOppositeEndFinder.getInstance());
                    cache.initInstanceScopeAnalysis(ia.createInstanceScopeAnalysis());
                    assertNotNull(cache.getOrCreateNavigationPath((OCLExpression) callExpression.getSource(),
                            expression.getContext(), filterSynthesizer, null, oclFactory));
                } catch (RuntimeException e) {
                    System.out.println(callExpression.getSource());
                    e.printStackTrace();
                    excList.add(new ExceptionWithExpression(e, expression));
                }

            }
        }

        return excList;
    }

    private Object dirtyReflectionAttributeReader(String attribute, Object target) {
        try {
            Field field = target.getClass().getDeclaredField(attribute);
            field.setAccessible(true);
            return field.get(target);

        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        throw new RuntimeException("Cannot reflect on " + target);
    }

}
