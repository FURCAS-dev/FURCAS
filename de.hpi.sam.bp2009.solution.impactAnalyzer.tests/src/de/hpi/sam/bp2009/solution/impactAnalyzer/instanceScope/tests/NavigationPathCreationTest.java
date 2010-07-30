package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;

import junit.framework.TestCase;

import org.junit.Test;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;

import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromModelPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache;

public class NavigationPathCreationTest extends TestCase{
    private Collection<OCLExpressionWithContext> classTcsExpressionList = null;
    private Collection<OCLExpressionWithContext> metamodelExpressionList = null;

    @Override
    public void setUp(){
	classTcsExpressionList = new OCLExpressionFromClassTcsPicker().pickUpExpressions();
	metamodelExpressionList = new OCLExpressionFromModelPicker().pickUpExpressions();
    }

    @Test
    public void testProducingNavigationStepsForTcsExpressions(){
	for(OCLExpressionWithContext expression : classTcsExpressionList){
	    createNavigationPath(expression);
	}
    }

    @Test
    public void testProducingNavigationStepsForMetamodelExpressions(){
	for(OCLExpressionWithContext expression : metamodelExpressionList){
	    createNavigationPath(expression);
	}
    }

    private void createNavigationPath(OCLExpressionWithContext expression) {
	FilterSynthesisImpl filterSynthesizer = new FilterSynthesisImpl(expression.getExpression(), false);
	filterSynthesizer.getSynthesisedFilter();

	PathCache cache = new PathCache(DefaultOppositeEndFinder.getInstance());
	cache.getOrCreateNavigationPath(expression.getExpression(), expression.getContext(), filterSynthesizer, null);
    }

}
