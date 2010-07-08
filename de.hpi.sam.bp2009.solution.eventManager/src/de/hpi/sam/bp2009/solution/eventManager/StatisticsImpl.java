package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatisticsImpl extends Statistics {
    private Map<String, List<Record>> records = new HashMap<String, List<Record>>();
    private Map<List<Object>, Long> running = new HashMap<List<Object>, Long>();

    @Override
    public void begin(String groupId, Object key) {
        List<Object> groupIdAndKey = Arrays.asList(groupId, key);
        if (running.containsKey(groupIdAndKey)) {
            throw new RuntimeException("beginning an already running measurement: "+groupIdAndKey);
        }
        running.put(groupIdAndKey, System.nanoTime());
    }

    @Override
    public void end(String groupId, Object key) {
        long endTime = System.nanoTime();
        List<Object> groupIdAndKey = Arrays.asList(groupId, key);
        Long startTime = running.get(groupIdAndKey);
        if (startTime == null) {
            throw new RuntimeException("ending a measurement that hasn't been started: "+groupIdAndKey);
        }
        List<Record> recordsForGroupId = records.get(groupId);
        if (recordsForGroupId == null) {
            recordsForGroupId = new LinkedList<Record>();
            records.put(groupId, recordsForGroupId);
        }
        recordsForGroupId.add(new Record(key, endTime-startTime));
        running.remove(groupIdAndKey);
    }

    @Override
    public List<Record> getRecords(String groupId) {
        return records.get(groupId);
    }

    @Override
    public Set<String> getGroupIds() {
        return records.keySet();
    }
    
}
