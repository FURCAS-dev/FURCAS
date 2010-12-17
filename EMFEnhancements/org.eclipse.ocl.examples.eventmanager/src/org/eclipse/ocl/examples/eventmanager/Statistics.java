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
package org.eclipse.ocl.examples.eventmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.ocl.examples.eventmanager.util.StatisticsImpl;
import org.eclipse.ocl.examples.eventmanager.util.StatisticsStub;

/**
 * To gather statistics about the OCL Impact Analysis and EMF Event Manager, set the system property
 * <tt>org.eclipse.ocl.examples.impactanalyzer.statistics</tt> to <tt>true</tt>. Otherwise, calls to
 * {@link #getInstance()} will return a mock object whose methods don't do anything and therefore should not contribute
 * significantly to overall performance characteristics. If the system property is set, however, statistics will be
 * gathered and can obtained at the end of a test / measurement run by using methods on the result of
 * {@link Statistics#getInstance()} such as {@link #getAverage(String)} passing in any of the <code>groupId</code>s
 * returned by {@link #getGroupIds()}. All individual records of a group can be obtained by {@link #getRecords(String)}.
 */
public abstract class Statistics {
    private static Statistics instance;
    
    public static class Record {
        private Object key;
        private long value;

        public Record(Object key, long timeInNanoSeconds) {
            super();
            this.key = key;
            this.value = timeInNanoSeconds;
        }

        public Object getKey() {
            return key;
        }

        public long getValue() {
            return value;
        }

    }

    public static Statistics getInstance() {
	if (instance == null) {
	    String sysProp = System.getProperty("org.eclipse.ocl.examples.impactanalyzer.statistics");
	    if (sysProp != null && (sysProp.toLowerCase().equals("true") ||
		    sysProp.toLowerCase().equals("yes"))) {
		instance = new StatisticsImpl();
	    } else {
		instance = new StatisticsStub();
	    }
	}
	return instance;
    }

    /**
     * Starts measuring a time span until {@link #end(String, Object)} is called with equal <code>groupId</code>
     * and <code>key</code>. Averages can be computed later for different keys with equal <code>groupId</code>.
     */
    public abstract void begin(String groupId, Object key);
    public abstract void end(String groupId, Object key);
    
    /**
     * Records a single value (could be a time measured other than with {@link #begin(String, Object)} and
     * {@link #end(String, Object)}, but could also be any other quantity over which later aggregation may
     * be performed.
     */
    public abstract void record(String groupId, Object key, long value);
    
    public abstract List<Record> getRecords(String groupId);
    public abstract Set<String> getGroupIds();
    public abstract void clear();
    
    public double getAverage(String groupId) {
        int count = 0;
        long sum = 0;
        if (getRecords(groupId) != null) {
            for (Record r : getRecords(groupId)) {
                sum += r.getValue();
                count++;
            }
            return ((double) sum) / (double) count;
        } else {
            return 0;
        }
    }
    
    public String averageAsSV(String columnSeparator) {
        StringBuilder result = new StringBuilder();
        for (String groupId : getGroupIds()) {
            result.append(groupId);
            result.append(columnSeparator);
            result.append(getAverage(groupId));
            result.append('\n');
        }
        return result.toString();
    }
    
    public String averageAsCVS() {
        return averageAsSV(", ");
    }
    
    /**
     * Keys are the group IDs, values are the CSV lists for the group whose ID is the entry's key
     */
    public Map<String, String> asCSVMapByGroupId() {
        return asSVMapByGroupId(", ");
    }
    
    public Map<String, String> asSVMapByGroupId(String columnSeparator) {
        Map<String, String> result = new HashMap<String, String>();
        for (String groupId : getGroupIds()) {
            StringBuilder sb = new StringBuilder();
            for (Record r : getRecords(groupId)) {
                sb.append(r.getKey());
                sb.append(columnSeparator);
                sb.append(r.getValue());
                sb.append('\n');
            }
            result.put(groupId, sb.toString());
        }
        return result;
    }
    
    public String asSV(String columnSeparator) {
        StringBuilder result = new StringBuilder();
        for (Entry<String, String> entry : asSVMapByGroupId(columnSeparator).entrySet()) {
            result.append(entry.getKey());
            result.append(columnSeparator);
            result.append(entry.getValue());
        }
        return result.toString();
    }
    
    public String asCSV() {
        return asSV(", ");
    }
    
}
