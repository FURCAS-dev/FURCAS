package de.hpi.sam.bp2009.solution.eventManager.framework;

import java.lang.ref.WeakReference;

import org.eclipse.emf.common.notify.Adapter;

import de.hpi.sam.bp2009.solution.eventManager.Statistics;
import de.hpi.sam.bp2009.solution.eventManager.StatisticsImpl;
import de.hpi.sam.bp2009.solution.eventManager.filters.AndFilter;

/**
 * A Registration represents a set of events that a listener wants to receive. Due to the fact that one call to
 * register..() on the EventRegistry interface can result in multiple registrations (due to the internal design),
 * registrations can be pooled into a set (the {@link RegistrationSet}).
 * 
 * @author Daniel Vocke (D044825), Axel Uhl (D043530)
 */
class Registration extends AbstractRegistration {

    /**
     * if the registration as listener results in multiple registration instances, those instances will be pooled in the
     * RegistrationSet
     */
    private RegistrationSet _container;
    
    /**
     * A bit field where each bit is taken from the {@link RegistrationManagerTableBased#filterTypeToBitMask} values,
     * representing a table with which this registration is registered. This number can be used as index into
     * the registration sets stored in the filter tables.
     */
    private final int bitSetForTablesRegisteredWith;
    
    /**
     * Optionally stores the <code>AndFilter</code> for which this registration was created.
     * 
     * TODO when one registration covers multiple AndFilters, this needs to change
     */
    private final AndFilter andFilter;

    /**
     * @param listener the listener that registered for events
     * @param bitSetForTablesRegisteredWith a bit set indicating for which tables this listener is registered.
     * This bit set corresponds with what {@link RegistrationManagerTableBased#getTablesForBitSet(int)} takes as
     * an argument.
     * @param andFilter when running in "debug mode" with the {@link Statistics} capturing turned on, the
     * <code>andFilter</code> will be remembered (otherwise, a {@link Registration} doesn't know its filter, hence
     * the filter can eventually get garbage-collected) and will be shown in the {@link #toString()} output.
     */
    Registration(WeakReference<? extends Adapter> listener, ListenerTypeEnum listenerType, int bitSetForTablesRegisteredWith, AndFilter andFilter) {
        super(listener, listenerType);
        this.bitSetForTablesRegisteredWith = bitSetForTablesRegisteredWith;
        if (Statistics.getInstance() instanceof StatisticsImpl) {
            this.andFilter = andFilter;
        } else {
            this.andFilter = null;
        }
    }

    /**
     * Can be used as index into registration arrays, such as those managed by
     * {@link FilterTableEntry}.
     */
    public int getBitSetForTablesRegisteredWith() {
        return bitSetForTablesRegisteredWith;
    }

    /**
     * When a call to register...() on the EventRegistry interface results in multiple Registrations, those
     * Registrations will be pooled in a RegistrationSet. This can happen due to the internal design where "OR
     * connected" filters are splitted into multiple Registrations.
     * 
     * @return the RegistrationSet that pools all Registrations that were created during one registration call
     */
    RegistrationSet getContainer() {
        return _container;
    }

    void setContainer(RegistrationSet container) {
        _container = container;
    }
    
    public String toString() {
        return super.toString()+" bitSet "+bitSetForTablesRegisteredWith;
    }

    public AndFilter getAndFilter() {
        return andFilter;
    }
}