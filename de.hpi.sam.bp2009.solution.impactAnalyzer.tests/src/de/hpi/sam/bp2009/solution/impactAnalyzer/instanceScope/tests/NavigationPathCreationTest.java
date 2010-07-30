package de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.tests;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.NavigationCallExp;
import org.eclipse.ocl.ecore.OCLExpression;
import org.junit.Test;

import com.sap.emf.ocl.hiddenopposites.DefaultOppositeEndFinder;

import de.hpi.sam.bp2009.solution.eventManager.NotificationHelper;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.NotificationResourceLoader;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromClassTcsPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionFromModelPicker;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;
import de.hpi.sam.bp2009.solution.impactAnalyzer.filterSynthesis.FilterSynthesisImpl;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.NavigationStep;
import de.hpi.sam.bp2009.solution.impactAnalyzer.instanceScope.PathCache;

public class NavigationPathCreationTest extends TestCase{
    private Collection<OCLExpressionWithContext> classTcsExpressionList = null;
    private Collection<OCLExpressionWithContext> metamodelExpressionList = null;

    Resource ngpmModel = null;
    List<RawNotification> modifyElementaryTypesTrace = null;


    @Override
    public void setUp(){
	classTcsExpressionList = new OCLExpressionFromClassTcsPicker().pickUpExpressions();
	metamodelExpressionList = new OCLExpressionFromModelPicker().pickUpExpressions();

	ngpmModel = NotificationResourceLoader.loadModel("NgpmModel.xmi");
	modifyElementaryTypesTrace = NotificationResourceLoader.loadTrace("modifyElementaryTypesEventTrace.trace");
    }

    @Test
    public void testProducingNavigationStepsForTcsExpressions(){
	for (OCLExpressionWithContext expression : classTcsExpressionList) {
	    assertNotNull(createNavigationPath(expression));
	}
    }

    @Test
    public void testProducingNavigationStepsForMetamodelExpressions(){
	for(OCLExpressionWithContext expression : metamodelExpressionList){
	    assertNotNull(createNavigationPath(expression));
	}
    }

    @Test
    public void testProducingNavigationStepsForTcsExpressionAttributeOrAssociationEndCalls(){
	for (OCLExpressionWithContext expression : classTcsExpressionList) {
	    FilterSynthesisImpl filterSynthesizer = new FilterSynthesisImpl(expression.getExpression(), false);
	    filterSynthesizer.getSynthesisedFilter();

	    for(RawNotification raw : modifyElementaryTypesTrace){
        	    for(OCLExpression expr : getAttributeOrAssociationEndCalls(raw.convertToNotification(ngpmModel), filterSynthesizer)){
              		PathCache cache = new PathCache(DefaultOppositeEndFinder.getInstance());
                	assertNotNull(cache.getOrCreateNavigationPath(expr, expression.getContext(), filterSynthesizer, null));
        	    }
	    }
	}
    }

    private NavigationStep createNavigationPath(OCLExpressionWithContext expression) {
	FilterSynthesisImpl filterSynthesizer = new FilterSynthesisImpl(expression.getExpression(), false);
	filterSynthesizer.getSynthesisedFilter();

	PathCache cache = new PathCache(DefaultOppositeEndFinder.getInstance());
	return cache.getOrCreateNavigationPath(expression.getExpression(), expression.getContext(), filterSynthesizer, null);
    }

    /**
     * Finds all attribute and association end call expressions in <tt>expression</tt> that are affected by the
     * <tt>changeEvent</tt>. The result is always non-<tt>null</tt> but may be empty.
     */
    private Set<? extends NavigationCallExp> getAttributeOrAssociationEndCalls(Notification changeEvent, FilterSynthesisImpl filterSynthesizer) {
        Set<? extends NavigationCallExp> result;
        if (NotificationHelper.isAttributeValueChangeEvent(changeEvent)) {
            result = filterSynthesizer.getAttributeCallExpressions((EAttribute) NotificationHelper
                    .getNotificationFeature(changeEvent));
        } else if (NotificationHelper.isLinkLifeCycleEvent(changeEvent)) {
            EReference ref = (EReference) NotificationHelper.getNotificationFeature(changeEvent);

            Set<NavigationCallExp> localResult = new HashSet<NavigationCallExp>();
            localResult.addAll(filterSynthesizer.getAssociationEndCallExpressions(ref));
            result = localResult;
        } else {
            result = Collections.emptySet();
        }
        return result;
    }

}
