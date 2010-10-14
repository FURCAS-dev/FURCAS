package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.tasks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.internal.OCLStandardLibraryImpl;

import com.sap.emf.ocl.hiddenopposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OCLWithHiddenOpposites;
import com.sap.emf.ocl.hiddenopposites.OppositeEndFinder;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;
import de.hpi.sam.bp2009.solution.impactAnalyzer.ImpactAnalyzer;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.notifications.RawNotification;
import de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.preparation.ocl.OCLExpressionWithContext;

@SuppressWarnings("restriction")
public class ModelSizeVariationBenchmarkTask implements BenchmarkTask{

    private final ImpactAnalyzer ia;
    private final RawNotification rawNotification;
    private Notification notification;
    private Resource model;
    private OCL ocl;

    /**
     * Also store original model in order to evaluate expression on model state before the value changed
     */
    private Resource modelForIaAccuracyDetermination;

    private final LinkedHashMap<String, String> additionalInformation = new LinkedHashMap<String, String>();
    private final LinkedHashMap<String, String> additionalMeasurementInformation = new LinkedHashMap<String, String>();

    private Collection<EObject> result = null;
    private Collection<Object> evaluationResult = null;

    private final ArrayList<Collection<EObject>> allResults = new ArrayList<Collection<EObject>>();

    private final OCLExpressionWithContext expression;
    private final OppositeEndFinder oppositeEndFinder;
    private AllInstanceEvaluationMeasurement allInstanceMeasurement;

    public ModelSizeVariationBenchmarkTask(OCLExpressionWithContext expression, RawNotification notification, ImpactAnalyzer imp, String oclId, String notificationId, String benchmarkTaskId, String optionId, String modelId, OppositeEndFinder oppositeEndFinder) {
    	this.expression = expression;
	rawNotification = notification;
	ia = imp;
	this.oppositeEndFinder = oppositeEndFinder;

	additionalInformation.put("optionId", optionId);
	additionalInformation.put("benchmarkTaskId", benchmarkTaskId);
	additionalInformation.put("notificationId", notificationId);
	additionalInformation.put("oclId", oclId);
	additionalInformation.put("modelId", modelId);
    }

    @Override
    public boolean activate(){
    	// For creating the notification the model is changed. Therefore the
    	// creation of notifications shall be happen just before the benchmark task
    	// is executed.
    	assert getModel() != null;

    	//additionalInformation.put("resourceUri", String.valueOf(getModel().getURI().toString().replaceAll("\t", "")));
    	additionalInformation.put("modelSize", String.valueOf(getModelSize(getModel())));

    	notification = getRawNotification().convertToNotification(getModel());

    	EventFilter filter = null;
    	if(notification != null) {
    	    	filter = ia.createFilterForExpression(false);
    		if(filter.matchesFor(notification)){
    			additionalInformation.put("filtered", "TRUE");
    		}else{
    			additionalInformation.put("filtered", "FALSE");
    		}
    	}

    	setOcl(OCLWithHiddenOpposites.newInstance(getOppositeEndFinder()));

	if(expression.getOclWithPackage() != null){
	    setOcl(OCLWithHiddenOpposites.newInstance( ((EcoreEnvironmentFactoryWithHiddenOpposites) getOcl().getEnvironment().getFactory()).
		    createPackageContext(getOcl().getEnvironment(), expression.getOclWithPackage().getPackage())));
	}

	additionalInformation.putAll(allInstanceMeasurement.getAdditionalInformation());

	boolean eventFilterMatches = false;
	if (notification != null && filter != null) {
	    long beforeFilterMatchCheck = System.nanoTime();
	    eventFilterMatches = filter.matchesFor(notification);
	    long afterFilterMatchCheck = System.nanoTime();
	    additionalInformation.put("eventFilterMatchCheckTime", String.valueOf(afterFilterMatchCheck - beforeFilterMatchCheck));
	}

    	return notification != null && eventFilterMatches;
    }

    @SuppressWarnings("unused")
    private Collection<EObject> getAllInstancesForContext(EClass context) {
	Iterator<EObject> allObjectIterator = model.getAllContents();
	List<EObject> resultSet = new LinkedList<EObject>();

	while(allObjectIterator.hasNext()){
	    EObject next = allObjectIterator.next();
	    if(context.isInstance(next)){
		resultSet.add(next);
	    }
	}

	return resultSet;
    }

    @Override
    public void beforeCall() {
    	assert additionalMeasurementInformation.size() == 0;
    	assert result == null;
    	assert evaluationResult == null;

    	evaluationResult = new ArrayList<Object>();

    	if(notification == null) {
	    throw new RuntimeException("notification cannot be created");
	}

    	((AllInstanceCallCountingOppositeEndFinder)getOppositeEndFinder()).resetAll();
    }

    @Override
    public Collection<EObject> call() throws Exception {
	result = ia.getContextObjects(notification);
	return result;
    }

    @Override
    public void callEvaluation() {
	/*for(EObject affectedElement : result){
	    evaluationResult.add(getOcl().evaluate(affectedElement, expression.getExpression()));
	}*/
    }

    @Override
    public void afterCall() {
	assert result != null;
	assert evaluationResult != null;

	int allInstancesCalls = ((AllInstanceCallCountingOppositeEndFinder)getOppositeEndFinder()).getAllInstancesCalled();
	additionalMeasurementInformation.put("noIaAllInstanceCalls", String.valueOf(allInstancesCalls));

	int findOppositeEndsCalls = ((AllInstanceCallCountingOppositeEndFinder)getOppositeEndFinder()).getFindOppositeEndsCalled();
	additionalMeasurementInformation.put("noIaFindOppositeEndsCalls", String.valueOf(findOppositeEndsCalls));

	int getAllOppositeEndsCalls = ((AllInstanceCallCountingOppositeEndFinder)getOppositeEndFinder()).getGetAllOppositeEndsCalled();
	additionalMeasurementInformation.put("noIaGetAllOppositeEndsCalls", String.valueOf(getAllOppositeEndsCalls));

	((AllInstanceCallCountingOppositeEndFinder)getOppositeEndFinder()).resetAll();

	additionalMeasurementInformation.put("noContextObjects", String.valueOf(result.size()));

	int noOfInvalidEvaluations = getNoOfInvalidEvaluations(evaluationResult);
	additionalMeasurementInformation.put("noInvalidEvals", String.valueOf(noOfInvalidEvaluations));

	long timeToEvaluate = 0;
	long timeToEvaluateWithoutInvalidResults = 0;
	for(EObject affectedElement : result){
	    long before = System.nanoTime();
	    Object result = getOcl().evaluate(affectedElement, expression.getExpression());
	    long after = System.nanoTime();
	    evaluationResult.add(result);
	    timeToEvaluate = timeToEvaluate + (after - before);
	    if(result == null || !result.equals(OCLStandardLibraryImpl.INSTANCE.getInvalid())){
		timeToEvaluateWithoutInvalidResults = timeToEvaluateWithoutInvalidResults + (after - before);
	    }
	}
	additionalInformation.put("evaluationTimeAfter", String.valueOf(new Long(timeToEvaluate)));
	additionalInformation.put("evaluationTimeWoInvalid", String.valueOf(new Long(timeToEvaluateWithoutInvalidResults)));

	evaluationResult = null;

	allResults.add(result);
	result = null;
    }


    public boolean deactivate() {
	Collection<EObject> result = allResults.get(0);

	if (result != null) {
	    List<Object> beforeEvaluationResult = evaluateOnAffectedElement(result);
	    additionalInformation.put("beforeNoInvalidEvals", String.valueOf(getNoOfInvalidEvaluations(beforeEvaluationResult)));

	    // Change model by creating a real notification through changing the
	    // original model
	    rawNotification.convertToNotification(getModelForIaAccuracyDetermination());

	    List<Object> afterEvaluationResult = evaluateOnAffectedElement(result);
	    additionalInformation.put("afterNoInvalidEvals", String.valueOf(getNoOfInvalidEvaluations(afterEvaluationResult)));

	    additionalInformation.put("noEqualResultsBeforeAndAfter",String.valueOf(getNumberOfEqualResults(beforeEvaluationResult, afterEvaluationResult)));
	}

	return true;
    }


    @SuppressWarnings("unchecked")
    private int getNumberOfEqualResults(List<Object> result1, List<Object> result2) {
	int equalCounter = 0;

	assert result1.size() == result2.size();

	for (int i = 0; i < result1.size(); i++) {
	    Object elementInResult1 = result1.get(i);
	    Object elementInResult2 = result2.get(i);

	    if (elementInResult1 instanceof EList<?> && elementInResult2 instanceof EList<?>) {
		if (((EList<EObject>) elementInResult1).containsAll((EList<EObject>) elementInResult2)
		&& ((EList<EObject>) elementInResult2).containsAll((EList<EObject>) elementInResult1)) {
		    equalCounter++;

		}
	    } else if (elementInResult1 instanceof EObject && elementInResult2 instanceof EObject && EcoreUtil.equals((EObject) elementInResult1, (EObject) elementInResult2)) {
		    equalCounter++;
	    } else {
		if (elementInResult1.equals(elementInResult2)) {
		    equalCounter++;
		}
	    }
	}

	return equalCounter;
    }

    private List<Object> evaluateOnAffectedElement(Collection<EObject> result) {
	List<Object> evaluationResult = new LinkedList<Object>();
	for(EObject affectedElement : result){
	    EObject element = getElementWithSameIdOutOfAnotherResource(model, affectedElement, getModelForIaAccuracyDetermination());
	    evaluationResult.add(ocl.evaluate(element, expression.getExpression()));
	}
	return evaluationResult;
    }

    private EObject getElementWithSameIdOutOfAnotherResource(Resource model2, EObject affectedElement, Resource originalModel2) {
	String id = model2.getURIFragment(affectedElement);
	return originalModel2.getEObject(id);
    }

    public int getNoOfInvalidEvaluations(Collection<Object> evaluationResult) {
	int invalidEvaluationCounter = 0;
	for(Object result : evaluationResult){
	    if(result != null && result.equals(OCLStandardLibraryImpl.INSTANCE.getInvalid())){
		invalidEvaluationCounter++;
	    }
	}
	return invalidEvaluationCounter;
    }

    public Notification getNotification(){
	return notification;
    }

    @Override
    public String toString(){
	return getAdditionalInformation().toString();
    }

    public Notification getRecentNotificiation() {
	return notification;
    }

    @Override
    public Map<String, String> getAdditionalInformation() {
    	return additionalInformation;
    }

    private int getModelSize(Resource resource){
	int resourceSize = 0;
	TreeIterator<EObject> iterator = resource.getAllContents();
	while(iterator.hasNext()){
	    iterator.next();
	    resourceSize++;
	}
	return resourceSize;
    }

    @Override
    public Map<String, String> getAdditionalMeasurementInformation() {
	LinkedHashMap<String, String> result = new LinkedHashMap<String,String>();
	result.putAll(additionalMeasurementInformation);
	additionalMeasurementInformation.clear();
	return result;
    }

	public void setModel(Resource model) {


		this.model = model;
	}

	public Resource getModel() {
		return model;
	}

	@Override
	public Object getResult() {
	    return result;
	}

	public void setOcl(OCL ocl) {
	    this.ocl = ocl;
	}

	public OCL getOcl() {
	    return ocl;
	}

	public void setEvaluationResult(Collection<Object> evaluationResult) {
	    this.evaluationResult = evaluationResult;
	}

	public Collection<Object> getEvaluationResult() {
	    return evaluationResult;
	}

	public void setResult(Collection<EObject> result) {
	    this.result = result;
	}

	public RawNotification getRawNotification() {
	    return rawNotification;
	}

	public OCLExpressionWithContext getExpression() {
	    return expression;
	}

	public void setModelForIaAccuracyDetermination(Resource modelForIaAccuracyDetermination) {
	    this.modelForIaAccuracyDetermination = modelForIaAccuracyDetermination;
	}

	public Resource getModelForIaAccuracyDetermination() {
	    return modelForIaAccuracyDetermination;
	}

	public OppositeEndFinder getOppositeEndFinder() {
	    return oppositeEndFinder;
	}

	public void setAllInstanceEvaluationMeasurement(AllInstanceEvaluationMeasurement measurement) {
	    this.allInstanceMeasurement = measurement;
	}
}
