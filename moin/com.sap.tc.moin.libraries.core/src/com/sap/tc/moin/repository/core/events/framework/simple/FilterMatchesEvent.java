package com.sap.tc.moin.repository.core.events.framework.simple;

import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.events.ChangeEventImpl;
import com.sap.tc.moin.repository.core.events.ModelChangeEventImpl;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.CompositionHierarchyFilter;
import com.sap.tc.moin.repository.events.filter.ConnectionFilter;
import com.sap.tc.moin.repository.events.filter.ContainerFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.filter.FilterMatcher;
import com.sap.tc.moin.repository.events.filter.InstanceFilter;
import com.sap.tc.moin.repository.events.filter.NotFilter;
import com.sap.tc.moin.repository.events.filter.OrFilter;
import com.sap.tc.moin.repository.events.filter.PackageFilter;
import com.sap.tc.moin.repository.events.filter.PartitionFilter;
import com.sap.tc.moin.repository.events.filter.SessionFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;
import com.sap.tc.moin.repository.events.type.ChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.PartitionChangeEvent;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public abstract class FilterMatchesEvent implements FilterMatcher {

    /*
     * the one and only public method
     */
    public static boolean matches( ChangeEvent event, EventFilter filter ) {

        if ( filter == null ) {
            return true;
        }

        FilterMatcher matcher = filter.getFilterMatcher( );
        if ( matcher == null ) {
            matcher = matchObjects.get( filter.getClass( ) );
            filter.setFilterMatcher( matcher );
        }
        return matcher.matchesForFilterType( event, filter );
    }

    /*
     * PRIVATE implementation
     */

    private final static Map<Class<? extends EventFilter>, FilterMatchesEvent> matchObjects = new IdentityHashMap<Class<? extends EventFilter>, FilterMatchesEvent>( );

    static {
        // Logical operations (AND, OR NOT)
        matchObjects.put( AndFilter.class, new AndFilterMatchesEvent( ) );
        matchObjects.put( OrFilter.class, new OrFilterMatchesEvent( ) );
        matchObjects.put( NotFilter.class, new NotFilterMatchesEvent( ) );

        // Normal filters
        matchObjects.put( AssociationFilter.class, new AssociationFilterMatchesEvent( ) );
        matchObjects.put( AttributeFilter.class, new AttributeFilterMatchesEvent( ) );
        matchObjects.put( ClassFilter.class, new ClassFilterMatchesEvent( ) );
        matchObjects.put( CompositionHierarchyFilter.class, new CompositionHierarchyFilterMatchesEvent( ) );
        matchObjects.put( EventTypeFilter.class, new EventTypeFilterMatchesEvent( ) );
        matchObjects.put( InstanceFilter.class, new InstanceFilterMatchesEvent( ) );
        matchObjects.put( PackageFilter.class, new PackageFilterMatchesEvent( ) );
        matchObjects.put( PartitionFilter.class, new PartitionFilterMatchesEvent( ) );
        matchObjects.put( ContainerFilter.class, new ContainerFilterMatchesEvent( ) );
        matchObjects.put( ConnectionFilter.class, new ConnectionFilterMatchesEvent( ) );
        matchObjects.put( SessionFilter.class, new SessionFilterMatchesEvent( ) );
    }

    abstract public boolean matchesForFilterType( ChangeEvent event, EventFilter filter );

    /*
     * AndFilterMatchesEvent
     */
    private final static class AndFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            // The AndFilter is false if at least one operand is false.
            // So the operands need only be checked up to the fist one that is
            // false.
            List<EventFilter> operands = ( (AndFilter) filter ).getOperands( );
            for ( int i = 0; i < operands.size( ); i++ ) {
                if ( !matches( event, operands.get( i ) ) ) {
                    return false;
                }
            }
            return true;
        }
    }

    /*
     * OrFilterMatchesEvent
     */
    private final static class OrFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            // The OrFilter is true if at least one operand is true.
            // So the operands need only be checked up to the fist one that is
            // true.
            List<EventFilter> operands = ( (OrFilter) filter ).getOperands( );
            for ( int i = 0; i < operands.size( ); i++ ) {
                if ( matches( event, operands.get( i ) ) ) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
     * NotFilterMatchesEvent
     */
    private final static class NotFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            List<EventFilter> operands = ( (AndFilter) filter ).getOperands( );
            for ( int i = 0; i < operands.size( ); i++ ) {
                return !matches( event, operands.get( i ) );
            }
            return false;
        }
    }

    /*
     * AssociationFilterMatchesEvent
     */
    private final static class AssociationFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( !( event instanceof LinkChangeEvent ) ) {
                return false;
            }
            LRI eventLri = ( (LinkChangeEvent) event ).getAffectedMetaObjectMri( ).getLri( );
            Object filterCriterion = filter.getFilterCriterion( );
            if ( filterCriterion instanceof LRI ) {
                return eventLri.equals( filterCriterion );
            }
            Collection<LRI> filterLris = (Collection<LRI>) filterCriterion;
            return filterLris.contains( eventLri );
        }
    }

    /*
     * AttributeFilterMatchesEvent
     */
    private final static class AttributeFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( !( event instanceof AttributeValueEvent ) ) {
                return false;
            }
            LRI eventLri = ( (AttributeValueEvent) event ).getAffectedMetaObjectMri( ).getLri( );
            Object filterCriterion = filter.getFilterCriterion( );
            if ( filterCriterion instanceof LRI ) {
                return eventLri.equals( filterCriterion );
            }
            Collection<LRI> filterLris = (Collection<LRI>) filterCriterion;
            return filterLris.contains( eventLri );
        }
    }

    /*
     * ClassFilterMatchesEvent
     */
    private final static class ClassFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( !( event instanceof ModelChangeEventImpl ) ) {
                return false;
            }
            Collection<LRI> eventLris = ( (ModelChangeEventImpl) event ).getClassFilterLris( );
            Object filterCriterion = filter.getFilterCriterion( );
            if ( filterCriterion instanceof LRI ) {
                return eventLris.contains( filterCriterion );
            }
            Collection<LRI> filterLris = (Collection<LRI>) filterCriterion;
            return ( !Collections.disjoint( eventLris, filterLris ) );
        }
    }

    /*
     * CompositionHierarchyFilterMatchesEvent
     */
    private final static class CompositionHierarchyFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( !( event instanceof ModelChangeEventImpl ) ) {
                return false;
            }
            Collection<LRI> eventLris = ( (ModelChangeEventImpl) event ).getAffectedElementsLRIsIncludingCompositeParents( );
            Object filterCriterion = filter.getFilterCriterion( );
            if ( filterCriterion instanceof LRI ) {
                return eventLris.contains( filterCriterion );
            }
            Collection<LRI> filterLris = (Collection) filterCriterion;
            return ( !Collections.disjoint( eventLris, filterLris ) );
        }
    }

    /*
     * CompositionHierarchyFilterMatchesEvent
     */
    private final static class EventTypeFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            Object filterCriterion = filter.getFilterCriterion( );
            if ( filterCriterion instanceof Class ) {
                return ( (Class<?>) filterCriterion ).isInstance( event );
            }

            for ( Object obj : (Object[]) filterCriterion ) {
                Class<?> clazz = (Class<?>) obj;
                if ( clazz.isInstance( event ) ) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
     * InstanceFilterMatchesEvent
     */
    private final static class InstanceFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( !( event instanceof ModelChangeEventImpl ) ) {
                return false;
            }
            Collection<LRI> eventLris = ( (ModelChangeEventImpl) event ).getAffectedElementsLris( );
            Object filterCriterion = filter.getFilterCriterion( );
            if ( filterCriterion instanceof LRI ) {
                return eventLris.contains( filterCriterion );
            }
            Collection<LRI> filterLris = (Collection) filterCriterion;
            return ( !Collections.disjoint( eventLris, filterLris ) );
        }
    }

    /*
     * PackageFilterMatchesEvent
     */
    private final static class PackageFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( !( event instanceof ModelChangeEventImpl ) ) {
                return false;
            }
            Collection<LRI> packageLris = (Collection<LRI>) filter.getFilterCriterion( );
            return packageLris.contains( ( (ModelChangeEventImpl) event ).getImmediatePackageExtentLri( ) );
        }
    }

    /*
     * PartitionFilterMatchesEvent
     */
    private final static class PartitionFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( event instanceof PartitionChangeEvent ) {
                Object obj = ( (ChangeEventImpl) event ).getAffectedPartitionsPRIs( );
                if ( obj instanceof PRI ) {
                    return obj.equals( filter.getFilterCriterion( ) );
                }

                if ( obj instanceof List ) {
                    List<PRI> list = (List<PRI>) obj;
                    for ( int i = 0; i < list.size( ); i++ ) {
                        PRI pri = list.get( i );
                        if ( pri.equals( filter.getFilterCriterion( ) ) ) {
                            return true;
                        }
                    }
                    return false;
                }
            } else {
                // former PartitionMembershipFilterMatchesEvent
                Object obj = ( (ChangeEventImpl) event ).getAffectedPartitionsPRIs( );
                if ( obj instanceof PRI ) {
                    return obj.equals( filter.getFilterCriterion( ) );
                }

                if ( obj instanceof List ) {
                    List<PRI> list = (List<PRI>) obj;
                    for ( int i = 0; i < list.size( ); i++ ) {
                        PRI pri = list.get( i );
                        if ( pri.equals( filter.getFilterCriterion( ) ) ) {
                            return true;
                        }
                    }
                    return false;
                }

                return false;
            }

            return false;
        }
    }

    /*
     * ContainerFilterMatchesEvent
     */
    private final static class ContainerFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            if ( event instanceof PartitionChangeEvent ) {
                Object obj = ( (ChangeEventImpl) event ).getAffectedPartitionsPRIs( );
                if ( obj instanceof PRI ) {
                    PRI pri = (PRI) obj;
                    return pri.getContainerName( ).equals( filter.getFilterCriterion( ) );
                }

                if ( obj instanceof List ) {
                    List<PRI> list = (List<PRI>) obj;
                    for ( int i = 0; i < list.size( ); i++ ) {
                        PRI pri = list.get( i );
                        if ( pri.getContainerName( ).equals( filter.getFilterCriterion( ) ) ) {
                            return true;
                        }
                    }
                    return false;
                }
            } else {
                // former PartitionMembershipFilterMatchesEvent
                Object obj = ( (ChangeEventImpl) event ).getAffectedPartitionsPRIs( );
                if ( obj instanceof PRI ) {
                    PRI pri = (PRI) obj;
                    return pri.getContainerName( ).equals( filter.getFilterCriterion( ) );
                }

                if ( obj instanceof List ) {
                    List<PRI> list = (List<PRI>) obj;
                    for ( int i = 0; i < list.size( ); i++ ) {
                        PRI pri = list.get( i );
                        if ( pri.getContainerName( ).equals( filter.getFilterCriterion( ) ) ) {
                            return true;
                        }
                    }
                    return false;
                }

                return false;
            }

            return false;
        }
    }

    /*
     * ConnectionFilterMatchesEvent
     */
    private final static class ConnectionFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            return ( (Wrapper) filter.getFilterCriterion( ) ).unwrap( ) == ( (ChangeEventImpl) event ).eventTriggerConnection;
        }
    }

    /*
     * SessionFilterMatchesEvent
     */
    private final static class SessionFilterMatchesEvent extends FilterMatchesEvent {

        @Override
        public boolean matchesForFilterType( ChangeEvent event, EventFilter filter ) {

            return ( (Wrapper) filter.getFilterCriterion( ) ).unwrap( ) == ( (ChangeEventImpl) event ).eventTriggerConnection.getSession( );
        }
    }

}
