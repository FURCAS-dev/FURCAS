package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

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
	List<ExceptionWithExpression> excList = tryCreationAndCatchAllRuntimeExceptions(classTcsExpressionList);
	assertEquals(0, excList.size());
    }

    @Test
    public void testProducingNavigationStepsForMetamodelExpressions(){
	List<ExceptionWithExpression> excList = tryCreationAndCatchAllRuntimeExceptions(metamodelExpressionList);
	assertEquals(0, excList.size());
    }

    public List<ExceptionWithExpression> tryCreationAndCatchAllRuntimeExceptions(Collection<OCLExpressionWithContext> expressionList){
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

    public void printExceptions(List<ExceptionWithExpression> excList){
	for(ExceptionWithExpression e : excList){
	    e.print();
	}
    }

    private class ExceptionWithExpression{
	private final Exception e;
	private final OCLExpressionWithContext expr;

	public ExceptionWithExpression(Exception e, OCLExpressionWithContext expr){
	    this.e = e;
	    this.expr = expr;
	}

	public void print(){
	    System.out.println(expr);
	    e.printStackTrace();
	}
    }

    @SuppressWarnings("unchecked")
    private List<ExceptionWithExpression> tryToCreateNavigationPaths(OCLExpressionWithContext expression) {
	List<ExceptionWithExpression> excList = new ArrayList<ExceptionWithExpression>();

	FilterSynthesisImpl filterSynthesizer = new FilterSynthesisImpl(expression.getExpression(), false);
	filterSynthesizer.getSynthesisedFilter();

	Map<EAttribute, Set<PropertyCallExp>> attributeCallExpressions = (Map<EAttribute, Set<PropertyCallExp>>)dirtyReflectionAttributeReader("attributeCallExpressions", filterSynthesizer);
	Map<EReference, Set<NavigationCallExp>> associationEndCallExpressions = (Map<EReference, Set<NavigationCallExp>>)dirtyReflectionAttributeReader("associationEndCallExpressions", filterSynthesizer);

	for (Set<PropertyCallExp> callExpressionSet : attributeCallExpressions.values()) {
	    for (PropertyCallExp callExpression : callExpressionSet) {
		try {
		    PathCache cache = new PathCache(DefaultOppositeEndFinder.getInstance());
		    assertNotNull(cache.getOrCreateNavigationPath((OCLExpression)callExpression.getSource(), expression.getContext(), filterSynthesizer,
			    null));
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
		    PathCache cache = new PathCache(DefaultOppositeEndFinder.getInstance());
		    assertNotNull(cache.getOrCreateNavigationPath((OCLExpression)callExpression.getSource(), expression.getContext(), filterSynthesizer,
			    null));
		} catch (RuntimeException e) {
		    System.out.println(callExpression.getSource());
		    e.printStackTrace();
		    excList.add(new ExceptionWithExpression(e, expression));
		}

	    }
	}

	return excList;
    }


    private Object dirtyReflectionAttributeReader(String attribute, Object target){
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
