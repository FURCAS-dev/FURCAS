package de.hpi.sam.bp2009.solution.eventManager.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import de.hpi.sam.bp2009.solution.eventManager.Statistics;


public class StatisticsStub extends Statistics {
    @Override
    public void begin(String groupId, Object key) {}
    @Override
    public void end(String groupId, Object key) {}
    @Override
    public void record(String groupId, Object key, long value) {}
    @Override
    public void clear() {}
    @Override
    public List<Record> getRecords(String groupId) {
        return Collections.emptyList();
    }
    @Override
    public Set<String> getGroupIds() {
        return Collections.emptySet();
    }
}
