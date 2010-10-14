package com.sap.runlet.abstractinterpreter.repository;

import java.util.Date;
import java.util.UUID;

import com.sap.runlet.abstractinterpreter.util.NanoDate;

public class SnapshotImpl implements Snapshot {
    private static final long serialVersionUID = 42100858883222733L;
    private NanoDate timestamp;
    private UUID uuid;
    
    public SnapshotImpl() {
	timestamp = new NanoDate();
	uuid = UUID.randomUUID();
    }
    
    @Override
    public Date when() {
	return timestamp;
    }

    public UUID getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
	return getUuid()+" from "+when();
    }
    
    public boolean equals(Object o) {
	return this.getUuid().equals(((SnapshotImpl) o).getUuid());
    }
    
    public int hashCode() {
	return getUuid().hashCode();
    }
}
