package com.sap.tc.moin.ocl.ia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.ocl.freestyle.OclExpressionRegistration;

public class Statistics {
    private static Statistics instance;
    public List<Record> records = new LinkedList<Record>();
    public Map<Record, Integer> numberOfAllInstancesCalls = new HashMap<Record, Integer>();
    private OclExpressionRegistration currentlyHandlingEventFor;
    private ModelChangeEvent currentlyHandlingEvent;
    private Object currentObjectForSelf;
    
    public static class Record {
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

    public static Statistics getInstance() {
	if (instance == null) {
	    instance = new Statistics();
	}
	return instance;
    }
    
    public void receivedEvent(OclExpressionRegistration oclExpressionRegistration, ModelChangeEvent event) {
	currentlyHandlingEventFor = oclExpressionRegistration;
	currentlyHandlingEvent = event;
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

}
