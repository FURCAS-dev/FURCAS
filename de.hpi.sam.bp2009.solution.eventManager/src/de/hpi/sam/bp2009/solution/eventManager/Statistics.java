package de.hpi.sam.bp2009.solution.eventManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;



/**
 * To gather statistics about the OCL Impact Analysis, set the system property
 * <tt>com.sap.tc.moin.ocl.ia.statistics</tt> to <tt>true</tt>.
 *
 */
public abstract class Statistics {
    private static Statistics instance;
    
    public static class Record {
        private Object key;
        private long timeInNanoSeconds;

        public Record(Object key, long timeInNanoSeconds) {
            super();
            this.key = key;
            this.timeInNanoSeconds = timeInNanoSeconds;
        }

        public Object getKey() {
            return key;
        }

        public long getTimeInNanoSeconds() {
            return timeInNanoSeconds;
        }

    }

    public static Statistics getInstance() {
	if (instance == null) {
	    String sysProp = System.getProperty("de.hpi.sam.bp2009.statistics");
	    if (sysProp != null && (sysProp.toLowerCase().equals("true") ||
		    sysProp.toLowerCase().equals("yes"))) {
		instance = new StatisticsImpl();
	    } else {
		instance = new StatisticsStub();
	    }
	}
	return instance;
    }

    public abstract void begin(String groupId, Object key);
    public abstract void end(String groupId, Object key);
    public abstract List<Record> getRecords(String groupId);
    public abstract Set<String> getGroupIds();
    
    public double getAverageTime(String groupId) {
        int count = 0;
        long sum = 0;
        for (Record r : getRecords(groupId)) {
            sum += r.getTimeInNanoSeconds();
            count++;
        }
        return ((double) sum) / (double) count;
    }
    
    public String averageTimeAsSV(String columnSeparator) {
        StringBuilder result = new StringBuilder();
        for (String groupId : getGroupIds()) {
            result.append(groupId);
            result.append(columnSeparator);
            result.append(getAverageTime(groupId));
            result.append('\n');
        }
        return result.toString();
    }
    
    public String averageTimeAsCVS() {
        return averageTimeAsSV(", ");
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
                sb.append(r.getTimeInNanoSeconds());
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
