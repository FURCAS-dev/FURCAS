package de.hpi.sam.bp2009.solution.impactAnalyzer.benchmark.execution.measurements;

public class MicroMeasurement extends DefaultMeasurement {
    private boolean beforeWasCalled = false;
    private boolean afterWasCalled = false;
    private long timeBefore = -1;
    private long timeAfter = -1;

    @Override
    public void before() {
	beforeWasCalled = true;
	timeBefore = System.nanoTime();

	assert timeBefore > -1;
    }

    @Override
    public void after() {
	if (!beforeWasCalled)
	    throw new RuntimeException("Before was not called");

	afterWasCalled = true;
	timeAfter = System.nanoTime();

	if (timeAfter < timeBefore)
	    throw new RuntimeException("Method after() appearently was called before calling before()");
    }

    @Override
    public long getResult() {
	if (!(beforeWasCalled && afterWasCalled))
	    return -1;

	return timeAfter - timeBefore;
    }

    public boolean isBeforeWasCalled() {
	return beforeWasCalled;
    }
}