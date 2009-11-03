package com.sap.mi.fwk.ui.test.commands;

import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

public class TestMoinCommand extends Command {

    private static final TracerI sTracer = TracingManager.getTracer(TestMoinCommand.class);

    private long cycles;

    public TestMoinCommand(long cycles, Connection co, String desc) {
        super(co, desc);
        this.cycles = cycles;
    }

    @Override
    public Collection<PartitionOperation> getAffectedPartitions() {
        return new ArrayList<PartitionOperation>();
    }

    public void doExecute() {
        if (canExecute()) {
            System.out.print(getDescription() + ": MOIN execute: " + cycles + " ... ");
            try {
                Thread.sleep(cycles);
            } catch (Exception e) {
                sTracer.debug("Caught exception." + e);
            }
            System.out.println("done");
        }
    }

	@Override
	public boolean canExecute() {
		return true;
	}
}
