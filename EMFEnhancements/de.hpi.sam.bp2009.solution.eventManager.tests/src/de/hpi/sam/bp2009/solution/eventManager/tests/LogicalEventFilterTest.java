package de.hpi.sam.bp2009.solution.eventManager.tests;

import de.hpi.sam.bp2009.solution.eventManager.filters.EventFilter;

public abstract class LogicalEventFilterTest extends EventFilterTest {
    protected EventFilter trueFilter;
    protected EventFilter falseFilter;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    public void setUp() {
        super.setUp();
        this.trueFilter = new TrueFilter();
        this.falseFilter = new FalseFilter();
    }

}
