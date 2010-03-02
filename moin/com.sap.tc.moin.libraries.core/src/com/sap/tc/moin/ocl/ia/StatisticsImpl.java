package com.sap.tc.moin.ocl.ia;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.ocl.expressions.OclExpression;

import com.sap.tc.moin.ocl.evaluator.stdlib.impl.OclTypeImpl;
import com.sap.tc.moin.ocl.ia.instancescope.InstanceScopeAnalysis;
import com.sap.tc.moin.ocl.ia.instancescope.NavigationStep;
import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.OclExpressionRegistrationWrapper;
import com.sap.tc.moin.repository.core.ocl.service.impl.OclExpressionRegistrationImpl;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;
import com.sap.tc.moin.repository.shared.util.Tuple.Triple;

public class StatisticsImpl extends Statistics {
    private List<Record> records = new LinkedList<Record>();
    private Map<Record, Integer> numberOfAllInstancesCalls = new HashMap<Record, Integer>();
    private Map<String, Long> classScopeAnalysisDurationInNanosecondsForRegistrationWithName = new HashMap<String, Long>();
    private Map<String, Map<ModelChangeEvent, List<Long>>> instanceScopeAnalysisDurationInNanosecondsForRegistrationWithName =
	new HashMap<String, Map<ModelChangeEvent, List<Long>>>();
    private Map<String, Map<ModelChangeEvent, List<Integer>>> instanceScopeAnalysisNumberOfAffectedElements =
	new HashMap<String, Map<ModelChangeEvent, List<Integer>>>();
    private Map<String, List<Long>> evaluationTimes = new HashMap<String, List<Long>>();
    private OclExpressionRegistration currentlyHandlingEventFor;
    private ModelChangeEvent currentlyHandlingEvent;
    private Object currentObjectForSelf;
    private Map<NavigationStep, Integer> stepBag = new HashMap<NavigationStep, Integer>();
    private Map<Triple<InstanceScopeAnalysis, OclExpression, NavigationStep>, Long> timeToComputeNavigationStepInNanoseconds = new HashMap<Triple<InstanceScopeAnalysis, OclExpression, NavigationStep>, Long>();
    private Map<Set<MofClass>, Integer> haveintersectingSubclassCalls = new HashMap<Set<MofClass>, Integer>();
    
    private static class Record {
	public Record(OclExpressionRegistration registration, ModelChangeEvent event, List<String> allInstancesQName, Object elementForSelf) {
	    super();
	    this.registration = registration;
	    this.event = event;
	    this.allInstancesQName = allInstancesQName;
	    this.elementForSelf = elementForSelf;
	}
	public OclExpressionRegistration registration;
	public ModelChangeEvent event;
	public List<String> allInstancesQName;
	public Object elementForSelf; // could be a proxy or a RefObject
	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((allInstancesQName == null) ? 0 : allInstancesQName.hashCode());
	    result = prime * result + ((elementForSelf == null) ? 0 : elementForSelf.hashCode());
	    result = prime * result + ((event == null) ? 0 : event.hashCode());
	    result = prime * result + ((registration == null) ? 0 : registration.hashCode());
	    return result;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Record other = (Record) obj;
	    if (allInstancesQName == null) {
		if (other.allInstancesQName != null)
		    return false;
	    } else if (!allInstancesQName.equals(other.allInstancesQName))
		return false;
	    if (elementForSelf == null) {
		if (other.elementForSelf != null)
		    return false;
	    } else if (!elementForSelf.equals(other.elementForSelf))
		return false;
	    if (event == null) {
		if (other.event != null)
		    return false;
	    } else if (!event.equals(other.event))
		return false;
	    if (registration == null) {
		if (other.registration != null)
		    return false;
	    } else if (!registration.equals(other.registration))
		return false;
	    return true;
	}
	
	
    }

    public void receivedEvent(OclExpressionRegistration oclExpressionRegistration, ModelChangeEvent event) {
	currentlyHandlingEventFor = oclExpressionRegistration;
	currentlyHandlingEvent = event;
    }

    @Override
    public void doneWithEvent(OclExpressionRegistrationImpl oclExpressionRegistrationImpl, ModelChangeEvent mce) {
	currentlyHandlingEventFor = null;
	currentlyHandlingEvent = null;
    }
    public void allInstancesCalled(List<String> classQname) {
	if (currentlyHandlingEventFor != null && currentlyHandlingEvent != null) {
	    Record record = new Record(currentlyHandlingEventFor, currentlyHandlingEvent, classQname,
		    currentObjectForSelf);
	    records.add(record);
	    if (numberOfAllInstancesCalls.containsKey(record)) {
		numberOfAllInstancesCalls.put(record, numberOfAllInstancesCalls.get(record)+1);
	    } else {
		numberOfAllInstancesCalls.put(record, 1);
	    }
	} else {
	    // System.err.println("allInstances called outside of global delayed reference resolver");
	    int i = 0; i++;
	}
    }

    public String toString() {
	StringBuilder result = new StringBuilder();
	Set<String> distinctOclExpressions = new HashSet<String>();
	result.append("OCL Expression\t#Event\t#allInstanceType\telementForSelf\tcount\n");
	for (Record record : numberOfAllInstancesCalls.keySet()) {
	    result.append("  ");
	    distinctOclExpressions.add(record.registration.getOclExpression());
	    result.append(record.registration.getOclExpression().replace('\n', ' ').replace('\r', ' ').replace('\t', ' '));
	    result.append('\t');
	    result.append(record.event);
	    result.append('\t');
	    result.append(Arrays.toString(record.allInstancesQName.toArray()));
	    result.append('\t');
	    result.append(record.elementForSelf);
	    result.append('\t');
	    result.append(numberOfAllInstancesCalls.get(record));
	    result.append('\n');
	}
	result.append("Summary: ");
	result.append(numberOfAllInstancesCalls.keySet().size());
	result.append(" distinct event/call/expression/context combinations with ");
	result.append(distinctOclExpressions.size());
	result.append(" distinct OCL expressions");
	return result.toString();
    }

    public void setCurrentObjectForSelf(Object elementForSelf) {
	this.currentObjectForSelf = elementForSelf;
    }

    /**
     * Produces a human-readable representation of the statistics gathered so far for the registration
     * passed.
     */
    public String toString(OclExpressionRegistration registration, Connection conn) {
	CoreConnection coreConnection;
	if (conn instanceof ConnectionWrapper) {
	    coreConnection = ((ConnectionWrapper) conn).unwrap();
	} else {
	    coreConnection = (CoreConnection) conn;
	}
	if (registration instanceof OclExpressionRegistrationWrapper) {
	    registration = ((OclExpressionRegistrationWrapper) registration).unwrap();
	}
	StringBuilder result = new StringBuilder();
	result.append("Expression: ");
	result.append(registration.getOclExpression().replace("\n", "\n             "));
	result.append("\n  Class scope analysis took ");
	result.append(classScopeAnalysisDurationInNanosecondsForRegistrationWithName.get(registration.getName()));
	result.append("ns\n  ");
	result.append(getNumberOfEvents(registration));
	result.append(" events handled by instance scope analysis\n  ");
	result.append(getInstanceScopePathConstructionTimeInNanoseconds(registration));
	result.append("ns instance scope path construction time\n");
	result.append(getAverageInstanceScopeAnalysisTimeInNanoseconds(registration));
	result.append("ns average instance scope analysis time\n  ");
	result.append("allInstances() calls:\n");
	for (Record record : getDistinctRecords(registration)) {
	    result.append("    ");
	    result.append(record.allInstancesQName);
	    result.append(": ");
	    result.append(numberOfAllInstancesCalls.get(record));
	    result.append('\n');
	}
	if (registration.getContext() instanceof MofClass) {
	    result.append("  Number of all context instances: ");
	    List<String> contextQualifiedName = ((MofClass) registration.getContext()).getQualifiedName();
	    if (contextQualifiedName.size() == 2 && contextQualifiedName.get(0).equals("Reflect") &&
		    contextQualifiedName.get(1).equals("Element")) {
		// can't query all instances of Reflect::Element
		result.append("<ENTIRE_REPOSITORY_CONTENT>");
	    } else {
		result.append(OclTypeImpl.getAllInstancesMris(coreConnection,
			((MofClass) registration.getContext()).getQualifiedName()).size());
	    }
	    result.append('\n');
	}
	return result.toString();
    }

    /**
     * Produces a human-readable representation of the statistics gathered so far for the registration
     * passed.
     */
    public String toCsv(OclExpressionRegistration registration, Connection conn) {
	CoreConnection coreConnection;
	if (conn instanceof ConnectionWrapper) {
	    coreConnection = ((ConnectionWrapper) conn).unwrap();
	} else {
	    coreConnection = (CoreConnection) conn;
	}
	if (registration instanceof OclExpressionRegistrationWrapper) {
	    registration = ((OclExpressionRegistrationWrapper) registration).unwrap();
	}
	StringBuilder result = new StringBuilder();
	result.append(registration.getOclExpression().replace('\t', ' ').replace('\n', ' ').replace('\r', ' '));
	result.append('\t');
	result.append(classScopeAnalysisDurationInNanosecondsForRegistrationWithName.get(registration.getName()));
	result.append('\t');
	result.append(getNumberOfEvents(registration));
	result.append('\t');
	result.append(getInstanceScopePathConstructionTimeInNanoseconds(registration));
	result.append('\t');
	result.append(getAverageInstanceScopeAnalysisTimeInNanoseconds(registration));
	result.append('\t');
	result.append(getAverageNumberOfAffectedElements(registration));
	result.append('\t');
	result.append(getNumberOfEvaluations(registration));
	result.append('\t');
	result.append(getAverageEvaluationTime(registration));
	result.append('\t');
	int allInstancesCalls = 0;
	for (Record record : getDistinctRecords(registration)) {
	    allInstancesCalls += numberOfAllInstancesCalls.get(record);
	}
	result.append(allInstancesCalls);
	result.append('\t');
	if (registration.getContext() instanceof MofClass) {
	    List<String> contextQualifiedName = ((MofClass) registration.getContext()).getQualifiedName();
	    if (contextQualifiedName.size() == 2 && contextQualifiedName.get(0).equals("Reflect") &&
		    contextQualifiedName.get(1).equals("Element")) {
		// can't query all instances of Reflect::Element
		result.append("<ENTIRE_REPOSITORY_CONTENT>");
	    } else {
		result.append(OclTypeImpl.getAllInstancesMris(coreConnection,
			((MofClass) registration.getContext()).getQualifiedName()).size());
	    }
	}
	return result.toString();
    }

    private int getNumberOfEvents(OclExpressionRegistration registration) {
	Map<ModelChangeEvent, List<Long>> instanceScopeAnalyses = instanceScopeAnalysisDurationInNanosecondsForRegistrationWithName
		.get(registration.getName());
	int result = 0;
	if (instanceScopeAnalyses != null) {
	    for (ModelChangeEvent mce : instanceScopeAnalyses.keySet()) {
		result += instanceScopeAnalyses.get(mce).size();
	    }
	}
	return result;
    }

    private long getAverageInstanceScopeAnalysisTimeInNanoseconds(OclExpressionRegistration registration) {
	Map<ModelChangeEvent, List<Long>> instanceScopeAnalyses = instanceScopeAnalysisDurationInNanosecondsForRegistrationWithName
		.get(registration.getName());
	long sum = 0;
	int count = 0;
	if (instanceScopeAnalyses != null) {
	    for (ModelChangeEvent mce : instanceScopeAnalyses.keySet()) {
		for (long duration : instanceScopeAnalyses.get(mce)) {
		    sum += duration;
		    count++;
		}
	    }
	}
	long result = 0;
	if (sum != 0) {
	    result = sum / count;
	}
	return result;
    }

    private long getInstanceScopePathConstructionTimeInNanoseconds(OclExpressionRegistration registration) {
	try {
	    Field impactAnalyzer = OclExpressionRegistrationImpl.class.getDeclaredField("analyzer");
	    impactAnalyzer.setAccessible(true);
	    InstanceScopeAnalysis ia = (InstanceScopeAnalysis) impactAnalyzer.get(registration);
	    long result = 0;
	    for (Triple<InstanceScopeAnalysis, OclExpression, NavigationStep> key : timeToComputeNavigationStepInNanoseconds.keySet()) {
		if (key.getA() == ia) {
		    result += timeToComputeNavigationStepInNanoseconds.get(key);
		}
	    }
	    return result;
	} catch (Exception e) {
	    throw new RuntimeException(e);
	}
    }

    private double getAverageNumberOfAffectedElements(OclExpressionRegistration registration) {
	Map<ModelChangeEvent, List<Integer>> instanceScopeAnalyses = instanceScopeAnalysisNumberOfAffectedElements
		.get(registration.getName());
	int sum = 0;
	int count = 0;
	if (instanceScopeAnalyses != null) {
	    for (ModelChangeEvent mce : instanceScopeAnalyses.keySet()) {
		for (int numberOfAffectedElements : instanceScopeAnalyses.get(mce)) {
		    sum += numberOfAffectedElements;
		    count++;
		}
	    }
	}
	double result = 0;
	if (sum != 0) {
	    result = (double) sum / (double) count;
	}
	return result;
    }

    private Set<Record> getDistinctRecords(OclExpressionRegistration registration) {
	Set<Record> result = new HashSet<Record>();
	for (Record record : numberOfAllInstancesCalls.keySet()) {
	    if (record.registration.getName().equals(registration.getName())) {
		result.add(record);
	    }
	}
	return result;
    }

    public void instanceScopeAnalysisPerformed(OclExpressionRegistration registration, ModelChangeEvent mce,
	    long timeInNanoseconds, int numberOfAffectedElements) {
	Map<ModelChangeEvent, List<Long>> eventsForRegistrationName = instanceScopeAnalysisDurationInNanosecondsForRegistrationWithName
		.get(registration.getName());
	if (eventsForRegistrationName == null) {
	    eventsForRegistrationName = new HashMap<ModelChangeEvent, List<Long>>();
	    instanceScopeAnalysisDurationInNanosecondsForRegistrationWithName.put(registration.getName(),
		    eventsForRegistrationName);
	}
	List<Long> list = eventsForRegistrationName.get(mce);
	if (list == null) {
	    list = new ArrayList<Long>();
	    eventsForRegistrationName.put(mce, list);
	}
	list.add(timeInNanoseconds);

	Map<ModelChangeEvent, List<Integer>> eventsForRegistrationName2 = instanceScopeAnalysisNumberOfAffectedElements
		.get(registration.getName());
	if (eventsForRegistrationName2 == null) {
	    eventsForRegistrationName2 = new HashMap<ModelChangeEvent, List<Integer>>();
	    instanceScopeAnalysisNumberOfAffectedElements.put(registration.getName(),
		    eventsForRegistrationName2);
	}
	List<Integer> list2 = eventsForRegistrationName2.get(mce);
	if (list2 == null) {
	    list2 = new ArrayList<Integer>();
	    eventsForRegistrationName2.put(mce, list2);
	}
	list2.add(numberOfAffectedElements);
    }

    public void classScopeAnalysisPerformed(OclExpressionRegistration registration, long timeInNanoseconds) {
	classScopeAnalysisDurationInNanosecondsForRegistrationWithName.put(registration.getName(), timeInNanoseconds);
    }

    private int getNumberOfEvaluations(OclExpressionRegistration registration) {
	List<Long> list = evaluationTimes.get(registration.getName());
	if (list == null) {
	    // try OCL expression string as key; evaluation in AdapterJMIHelper uses this approach
	    list = evaluationTimes.get(getAlternativeRegistrationName(registration));
	}
	return (list == null) ? 0 : list.size();
    }

    private String getAlternativeRegistrationName(OclExpressionRegistration registration) {
	return ""+((MofClass) registration.getContext()).getQualifiedName()+" "+
	    	registration.getOclExpression();
    }
    
    private long getAverageEvaluationTime(OclExpressionRegistration registration) {
	long sum = 0;
	int count = 0;
	long result = 0;
	List<Long> list = evaluationTimes.get(registration.getName());
	if (list == null) {
	    // try OCL expression string as key; evaluation in AdapterJMIHelper uses this approach
	    list = evaluationTimes.get(getAlternativeRegistrationName(registration));
	}
	if (list != null) {
	    for (long l : list) {
		sum += l;
		count++;
	    }
	    result = sum / count;
	}
	return result;
    }
    
    @Override
    public void evaluated(OclExpressionRegistrationImpl registration, long l) {
	List<Long> list = evaluationTimes.get(registration.getName());
	if (list == null) {
	    list = new ArrayList<Long>();
	    evaluationTimes.put(registration.getName(), list);
	}
	list.add(l);
    }

    @Override
    public String getCsvHeader() {
	return "Expression\tClass scope analysis (ns)\tevents\tinstance scope path construction (ns)\tavg instance scope (ns)\tavg affected elements\t#evals\tavg eval time (ns)\tallInstances()\tcontext elements\n";
    }

    @Override
    public void stepPerformed(NavigationStep step) {
	Integer count = stepBag.get(step);
	if (count == null) {
	    count = 1;
	} else {
	    count++;
	}
	stepBag.put(step, count);
    }

    @Override
    public Map<NavigationStep, Integer> getStepsInfo() {
	return Collections.unmodifiableMap(stepBag);
    }

    @Override
    public void instanceScopeNavigationStepComputed(InstanceScopeAnalysis instanceScopeAnalyzer, OclExpression exp,
	    NavigationStep step, long timeInNanoseconds) {
	timeToComputeNavigationStepInNanoseconds.put(new Triple<InstanceScopeAnalysis, OclExpression, NavigationStep>(
		instanceScopeAnalyzer, exp, step), timeInNanoseconds);
    }

    @Override
    public void haveIntersectingSubclassTreeCalled(MofClass a, MofClass b) {
	Set<MofClass> mcs = new HashSet<MofClass>();
	mcs.add(a);
	mcs.add(b);
	Integer count = haveintersectingSubclassCalls.get(mcs);
	if (count == null) {
	    count = 0;
	}
	haveintersectingSubclassCalls.put(mcs, count+1);
    }

}
