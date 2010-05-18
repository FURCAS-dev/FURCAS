package com.sap.tc.moin.ocl.ia.events;

import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.jmi.reflect.RefObjectImpl;
import com.sap.tc.moin.repository.events.filter.AndFilter;
import com.sap.tc.moin.repository.events.filter.AssociationFilter;
import com.sap.tc.moin.repository.events.filter.AttributeFilter;
import com.sap.tc.moin.repository.events.filter.ClassFilter;
import com.sap.tc.moin.repository.events.filter.EventFilter;
import com.sap.tc.moin.repository.events.filter.EventTypeFilter;
import com.sap.tc.moin.repository.events.type.AttributeValueEvent;
import com.sap.tc.moin.repository.events.type.ElementChangeEvent;
import com.sap.tc.moin.repository.events.type.ElementCreateEvent;
import com.sap.tc.moin.repository.events.type.ElementDeleteEvent;
import com.sap.tc.moin.repository.events.type.LinkAddEvent;
import com.sap.tc.moin.repository.events.type.LinkChangeEvent;
import com.sap.tc.moin.repository.events.type.LinkRemoveEvent;
import com.sap.tc.moin.repository.events.type.ModelChangeEvent;
import com.sap.tc.moin.repository.mmi.model.Association;
import com.sap.tc.moin.repository.mmi.model.AssociationEnd;
import com.sap.tc.moin.repository.mmi.model.Attribute;
import com.sap.tc.moin.repository.mmi.model.Classifier;
import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;
import com.sap.tc.moin.repository.mmi.model.MofClass;
import com.sap.tc.moin.repository.mmi.model.Reference;
import com.sap.tc.moin.repository.mmi.model.__impl.GeneralizableElementInternal;
import com.sap.tc.moin.repository.mmi.model.__impl.MofClassImpl;
import com.sap.tc.moin.repository.mmi.model.__impl.ReferenceInternal;
import com.sap.tc.moin.repository.mmi.reflect.RefFeatured;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;
import com.sap.tc.moin.repository.shared.util.Tuple.Pair;
import com.sap.tc.moin.repository.spi.core.SpiJmiHelper;
import com.sap.tc.moin.repository.spi.core.Wrapper;

/**
 * The InternalEventFactory creates InternalEvents and takes care that there is
 * at most one instance of a subclass of InternalEvent for each Association,
 * Attribute or MofClass. It actually provides two types of operations: One set
 * is used to turn an ModelChangeEvent instance into a corresponding
 * InternalEvent instance, the other set is used to create a InternalEvent
 * instance for a given ModelElement type.
 */
public class InternalEventFactory {

    /**
     * The default constructor
     */
    public InternalEventFactory( ) {

        // nothing particular
    }

    /**
     * An implementation of the the abstract class DeleteET
     */
    private static final class DeleteETImpl extends DeleteET {

        /**
         * @param mofClass {@link MofClass}
         */
        public DeleteETImpl( MofClass mofClass ) {

            super( mofClass );
        }

        /**
         * @return the filter
         */
        @Override
        public EventFilter getFilter( CoreConnection connection ) {
            return new AndFilter(new EventTypeFilter(ElementDeleteEvent.class),
        	                 new ClassFilter( connection.getWrapperForJmiObject( getMofClass( ) ), true));
        }

        /**
         * @return the class
         */
        @Override
        public Class<? extends InternalEvent> getType( ) {

            return DeleteET.class;
        }
    }

    /**
     * An implementation of the abstract class DeleteRT
     */
    private static final class DeleteRTImpl extends DeleteRT {
	/**
	 * The optional type of the source expression from where the association end is navigated.
	 */
	private MofClass sourceType;

        /**
         * @param connection {@link CoreConnection}
         * @param assocEnd {@link AssociationEnd}
         */
        public DeleteRTImpl( CoreConnection connection, AssociationEnd assocEnd ) {

            super( connection, assocEnd );
        }

        public DeleteRTImpl(CoreConnection connection, AssociationEnd assocEnd, MofClass sourceType) {
	    super(connection, assocEnd);
	    this.sourceType = sourceType;
	}

	/**
         * @return the filter
         */
        @Override
        public EventFilter getFilter( CoreConnection connection ) {
            Association assoc = (Association) ( (RefObjectImpl) this.modelElement ).refImmediateComposite( connection.getSession( ) );
            AssociationFilter assocFilter = new AssociationFilter( assoc );
            EventFilter result;
            if (sourceType == null) {
        	result = assocFilter;
            } else {
        	ClassFilter classFilter = new ClassFilter(sourceType, /* includeSubtypes */ true);
        	result = new AndFilter(assocFilter, classFilter);
            }
            return result;
        }

        /**
         * @return the type
         */
        @Override
        public Class<? extends InternalEvent> getType( ) {

            return DeleteRT.class;
        }
    }

    /**
     * An implementation of the abstract class InsertET
     */
    private static final class InsertETImpl extends InsertET {

        /**
         * @param mofClass {@link MofClass}
         */
        public InsertETImpl( MofClass mofClass ) {

            super( mofClass );
        }

        /**
         * @return the filter
         */
        @Override
        public EventFilter getFilter( CoreConnection connection ) {
            return new AndFilter(new EventTypeFilter(ElementCreateEvent.class),
	                 new ClassFilter( connection.getWrapperForJmiObject( getMofClass( ) ), true));
        }

        /**
         * @return the type
         */
        @Override
        public Class<? extends InternalEvent> getType( ) {

            return InsertET.class;
        }

    }

    /**
     * An implementation of the the abstract class InsertRT
     */
    private static final class InsertRTImpl extends InsertRT {
	/**
	 * The optional type of the source expression from where the association end is navigated.
	 */
	private MofClass sourceType;

        /**
         * @param connection {@link CoreConnection}
         * @param assocEnd {@link AssociationEnd}
         */
        public InsertRTImpl( CoreConnection connection, AssociationEnd assocEnd ) {

            super( connection, assocEnd );
        }

        public InsertRTImpl(CoreConnection connection, AssociationEnd assocEnd, MofClass sourceType) {
            super(connection, assocEnd);
            this.sourceType = sourceType;
	}

	/**
         * @return the filter
         */
        @Override
        public EventFilter getFilter( CoreConnection connection ) {
            Association assoc = (Association) ( (RefObjectImpl) this.modelElement ).refImmediateComposite( connection.getSession( ) );
            AssociationFilter assocFilter = new AssociationFilter( assoc );
            EventFilter result;
            if (sourceType == null) {
        	result = assocFilter;
            } else {
        	ClassFilter classFilter = new ClassFilter(sourceType, /* includeSubtypes */ true);
        	result = new AndFilter(assocFilter, classFilter);
            }
            return result;
        }

        /**
         * @return the type
         */
        @Override
        public Class<? extends InternalEvent> getType( ) {

            return InsertRT.class;
        }

    }

    /**
     * An implementation of the the abstract class UpdateAttribute
     */
    private static final class UpdateAttributeImpl extends UpdateAttribute {
	/**
	 * The optional type of the source expression on which the attribute is evaluated.
	 */
	private MofClass sourceType;

	public UpdateAttributeImpl(CoreConnection connection, Attribute attribute, MofClass sourceType) {
	    super(connection, attribute);
	    this.sourceType = sourceType;
	}
	
        /**
         * @param connection {@link CoreConnection}
         * @param attribute {@link Attribute}
         */
        public UpdateAttributeImpl( CoreConnection connection, Attribute attribute ) {

            super( connection, attribute );
        }

        /**
         * @return the filter
         */

        @Override
        public EventFilter getFilter( CoreConnection connection ) {
            AttributeFilter attrFilter = new AttributeFilter( getMRI( ) );
            EventFilter result;
            if (sourceType == null) {
        	result = attrFilter;
            } else {
        	ClassFilter classFilter = new ClassFilter(sourceType, /* includeSubtypes */ true);
        	result = new AndFilter(attrFilter, classFilter);
            }
            return result;
        }

        /**
         * @return the type
         */
        @Override
        public Class<? extends InternalEvent> getType( ) {

            return UpdateAttribute.class;
        }

    }

    /**
     * This maps from MofClasses to DeleteET events. MofID is used as key.
     */
    private final Map<String, DeleteET> deleteETMap = new Hashtable<String, DeleteET>( );

    /**
     * This maps from a pair containing the association's and the source type's MOF ID
     * to DeleteRT events. The source type's MOF ID may be <tt>null</tt> in case the
     * event is not specific to any source expression / source type.
     */
    private final Map<Pair<String, String>, DeleteRT> deleteRTMap = new Hashtable<Pair<String, String>, DeleteRT>( );

    /**
     * This maps from MofClasses to InsertET events MofID is used as key.
     */
    private final Map<String, InsertET> insertETMap = new Hashtable<String, InsertET>( );

    /**
     * This maps from a pair containing the association's and the source type's MOF ID
     * to InsertRT events. The source type's MOF ID may be <tt>null</tt> in case the
     * event is not specific to any source expression / source type.
     */
    private final Map<Pair<String, String>, InsertRT> insertRTMap = new Hashtable<Pair<String, String>, InsertRT>( );

    /**
     * This maps from a pair containing the attribute's and the source type's MOF ID
     * to UpdateAttribute events. The source type's MOF ID may be <tt>null</tt> in case the
     * event is not specific to any source expression / source type.
     */
    private final Map<Pair<String, String>, UpdateAttribute> updateAttributeMap = new Hashtable<Pair<String, String>, UpdateAttribute>( );

    /**
     * Used internally
     */
    private final static InternalEvent[] EMPTY_EVENT_ARRAY = new InternalEvent[0];

    /**
     * @param clazz {@link MofClass}
     * @return the event
     */
    public DeleteET createDeleteET( MofClass clazz ) {

        if ( this.deleteETMap.containsKey( clazz.refMofId( ) ) ) {
            return this.deleteETMap.get( clazz.refMofId( ) );
        }
        DeleteET dET = new DeleteETImpl( clazz );
        this.deleteETMap.put( clazz.refMofId( ), dET );
        return dET;
    }

    private DeleteET[] createDeleteET( ElementDeleteEvent event ) {

        /**
         * According to the doc we cannot use getAffectedElement here
         */
        MofClass c = (MofClass) event.getMetaObject( event.getEventTriggerConnection( ) );
        if ( c == null ) {
            return new DeleteET[0];
        }
        return new DeleteET[] { createDeleteET( c ) };
    }

    /**
     * @param connection {@link CoreConnection}
     * @param assocEnd {@link AssociationEnd}
     * @return the event
     */
    public DeleteRT createDeleteRT( CoreConnection connection, AssociationEnd assocEnd ) {
        if ( this.deleteRTMap.containsKey( assocEnd.refMofId( ) ) ) {
            return this.deleteRTMap.get( assocEnd.refMofId( ) );
        }
        DeleteRT dRT = new DeleteRTImpl( connection, assocEnd );
        this.deleteRTMap.put( new Pair<String, String>(assocEnd.refMofId( ), /* source type MOF ID */ null), dRT );
        return dRT;
    }

    public InternalEvent createDeleteRT(CoreConnection connection, AssociationEnd assocEnd, MofClassImpl type) {
        if ( this.deleteRTMap.containsKey( assocEnd.refMofId( ) ) ) {
            return this.deleteRTMap.get( assocEnd.refMofId( ) );
        }
        DeleteRT dRT = new DeleteRTImpl( connection, assocEnd, (MofClass) type.createWrapper(connection, /* synchronize */ true) );
        this.deleteRTMap.put( new Pair<String, String>(assocEnd.refMofId( ), type.refMofId()), dRT );
        return dRT;
    }

    private DeleteRT[] createDeleteRT( LinkRemoveEvent event ) {

        CoreConnection conn = getCoreConnection( event.getEventTriggerConnection( ) );
        RefFeatured metaObject = event.getAffectedMetaObject( conn );
        if ( metaObject == null ) {
            return new DeleteRT[0];
        }
        Set<DeleteRT> resultset = new HashSet<DeleteRT>( );
        if ( metaObject instanceof Association ) {
            Association assoc = (Association) event.getAffectedMetaObject( conn );
            List<AssociationEnd> ends = conn.getCoreJmiHelper( ).getAssociationEnds( conn.getSession( ), assoc );
            resultset.add( createDeleteRT( conn, ends.get( 0 ) ) );
            resultset.add( createDeleteRT( conn, ends.get( 1 ) ) );
        } else if ( metaObject instanceof Reference ) {
            Reference ref = (Reference) metaObject;
            resultset.add( createDeleteRT( conn, ref.getExposedEnd( ) ) );
            resultset.add( createDeleteRT( conn, ref.getReferencedEnd( ) ) );
        }
        DeleteRT[] result = new DeleteRT[resultset.size( )];
        resultset.toArray( result );
        return result;
    }

    /**
     * @param clazz {@link MofClass}
     * @return the event
     */
    public InsertET createInsertET( MofClass clazz ) {

        if ( this.insertETMap.containsKey( clazz.refMofId( ) ) ) {
            return this.insertETMap.get( clazz.refMofId( ) );
        }
        InsertET iET = new InsertETImpl( clazz );
        this.insertETMap.put( clazz.refMofId( ), iET );
        return iET;
    }

    /**
     * @param event the MOIN event
     * @return the internal event
     */
    private InsertET[] createInsertET( ElementCreateEvent event ) {

        RefFeatured obj = event.getAffectedElement( event.getEventTriggerConnection( ) );
        if ( obj == null ) {
            return new InsertET[0];
        }
        return new InsertET[] { createInsertET( (MofClass) obj.refMetaObject( ) ) };
    }

    /**
     * @param connection {@link CoreConnection}
     * @param assocEnd {@link AssociationEnd}
     * @return the event
     */
    public InsertRT createInsertRT( CoreConnection connection, AssociationEnd assocEnd ) {
        if ( this.insertRTMap.containsKey( assocEnd.refMofId( ) ) ) {
            return this.insertRTMap.get( assocEnd.refMofId( ) );
        }
        InsertRT dRT = new InsertRTImpl( connection, assocEnd );
        this.insertRTMap.put( new Pair<String, String>(assocEnd.refMofId( ), /* source type MOF ID */ null), dRT );
        return dRT;
    }

    public InternalEvent createInsertRT(CoreConnection connection, AssociationEnd assocEnd, MofClassImpl type) {
        if ( this.insertRTMap.containsKey( assocEnd.refMofId( ) ) ) {
            return this.insertRTMap.get( assocEnd.refMofId( ) );
        }
        InsertRT dRT = new InsertRTImpl( connection, assocEnd, (MofClass) type.createWrapper(connection, /* synchronize */ true) );
        this.insertRTMap.put( new Pair<String, String>(assocEnd.refMofId( ), type.refMofId()), dRT );
        return dRT;
    }

    private InsertRT[] createInsertRT( LinkAddEvent event ) {

        CoreConnection conn = getCoreConnection( event.getEventTriggerConnection( ) );
        RefFeatured metaObject = event.getAffectedMetaObject( conn );
        if ( metaObject == null ) {
            return new InsertRT[0];
        }
        Set<InsertRT> resultset = new HashSet<InsertRT>( );
        if ( metaObject instanceof Association ) {

            Association assoc = (Association) event.getAffectedMetaObject( conn );
            List<AssociationEnd> ends = conn.getCoreJmiHelper( ).getAssociationEnds( conn.getSession( ), assoc );
            resultset.add( createInsertRT( conn, ends.get( 0 ) ) );
            resultset.add( createInsertRT( conn, ends.get( 1 ) ) );
        } else if ( metaObject instanceof ReferenceInternal ) {
            ReferenceInternal ref = (ReferenceInternal) metaObject;
            resultset.add( createInsertRT( conn, ref.getExposedEnd( conn ) ) );
            resultset.add( createInsertRT( conn, ref.getReferencedEnd( conn ) ) );
        }
        InsertRT[] result = new InsertRT[resultset.size( )];
        resultset.toArray( result );
        return result;
    }

    /**
     * @param connection {@link CoreConnection}
     * @param attr the MOIN attribute
     * @return the internal update attribute
     */
    public UpdateAttribute createUpdateAttribute( CoreConnection connection, Attribute attr ) {

        if ( this.updateAttributeMap.containsKey( attr.refMofId( ) ) ) {
            return this.updateAttributeMap.get( attr.refMofId( ) );
        }
        UpdateAttribute updAttr = new UpdateAttributeImpl( connection, attr );
        this.updateAttributeMap.put( new Pair<String, String>(attr.refMofId( ), /* source type MOF ID */ null), updAttr );
        return updAttr;
    }

    /**
     * Creates an internal attribute value change event of type {@link UpdateAttribute} specifically
     * with the source type of the expression on which the attribute is "called." This helps to
     * produce a more specific event handler that selects change events only if they occur on
     * the classifier of the source expression (or subtypes thereof). 
     */
    public UpdateAttribute createUpdateAttribute( CoreConnection connection, Attribute attr, MofClassImpl sourceType ) {

        if ( this.updateAttributeMap.containsKey( attr.refMofId( ) ) ) {
            return this.updateAttributeMap.get( attr.refMofId( ) );
        }
        UpdateAttribute updAttr = new UpdateAttributeImpl( connection, attr, (MofClass) sourceType.createWrapper(connection, /* synchronize */ true) );
        this.updateAttributeMap.put( new Pair<String, String>(attr.refMofId( ), sourceType.refMofId()), updAttr );
        return updAttr;
    }

    private UpdateAttribute[] createUpdateAttribute( CoreConnection connection, AttributeValueEvent event ) {

        Attribute attr = event.getAffectedMetaObject( event.getEventTriggerConnection( ) );
        if ( attr == null ) {
            return new UpdateAttribute[0];
        }
        return new UpdateAttribute[] { createUpdateAttribute( connection, attr ) };
    }

    /**
     * Creates the internal event or events from the MOIN event
     * 
     * @param connection {@link CoreConnection}
     * @param event {@link ModelChangeEvent}
     * @return the internal event(s) (Link changes are reflected by two internal
     * events)
     */
    public InternalEvent[] createEvents( CoreConnection connection, ModelChangeEvent event ) {

        if ( event instanceof AttributeValueEvent ) {
            return createUpdateAttribute( connection, (AttributeValueEvent) event );
        }
        if ( event instanceof LinkRemoveEvent ) {
            return createDeleteRT( (LinkRemoveEvent) event );
        }
        if ( event instanceof LinkAddEvent ) {
            return createInsertRT( (LinkAddEvent) event );
        }
        if ( event instanceof ElementCreateEvent ) {
            return createInsertET( (ElementCreateEvent) event );
        }
        if ( event instanceof ElementDeleteEvent ) {
            return createDeleteET( (ElementDeleteEvent) event );
        }
        return EMPTY_EVENT_ARRAY;
    }

    /**
     * Get the affected elements
     * 
     * @param event {@link ModelChangeEvent}
     * @param cls {@link Classifier}
     * @return a set of RefFeatured
     */
    public Set<RefObject> getAffectedElements( ModelChangeEvent event, Classifier cls ) {

        Set<RefObject> result = new HashSet<RefObject>( );
        RefObject obj;
        CoreConnection conn;
        Connection econn = event.getEventTriggerConnection( );
        if ( econn instanceof Wrapper<?> ) {
            conn = (CoreConnection) ( (Wrapper<?>) econn ).unwrap( );
        } else {
            conn = (CoreConnection) econn;
        }

        if ( event instanceof ElementDeleteEvent ) {
            // return the empty Set
            return result;
        }

        if ( event instanceof ElementChangeEvent ) {
            obj = ( (ElementChangeEvent) event ).getAffectedElement( conn );
            if ( obj != null ) {
                result.add( obj );
            }
        } else {
            if ( event instanceof AttributeValueEvent ) {
                obj = ( (AttributeValueEvent) event ).getAffectedMetaObject( conn );
                if ( obj != null ) {
                    result.add( (RefObject) ( (Attribute) obj ).refImmediateComposite( ) );
                }
            } else {
                if ( event instanceof LinkChangeEvent ) {

                    MRI objMri = ( (LinkChangeEvent) event ).getStoredLinkEndMri( );
                    if ( objMri != null ) {
                        obj = (RefObject) conn.getElement( objMri );
                        if ( obj != null ) {
                            Classifier metaObject = (Classifier) obj.refMetaObject( );

                            if ( metaObject.equals( cls ) || ( (GeneralizableElementInternal) metaObject ).allSupertypes( conn ).contains( cls ) ) {
                                result.add( obj );
                            }
                        }
                    }
                    LRI objLri = ( (LinkChangeEvent) event ).getNonStoredLinkEndLri( );
                    if ( objLri != null ) {
                        obj = (RefObject) conn.getElement( objLri );
                        if ( obj != null ) {
                            Classifier metaObject = (Classifier) obj.refMetaObject( );

                            if ( metaObject.equals( cls ) || ( (GeneralizableElementInternal) metaObject ).allSupertypes( conn ).contains( cls ) ) {
                                result.add( obj );
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Creates a Set of <tt>InsertET</tt>s for a MofClass and all its
     * subclasses.
     * 
     * @param connection the core connection
     * @param clazz the class for which to create <tt>InsertET</tt>
     * @return a Set of <tt>InsertET</tt>s
     */
    public Set<InsertET> createAllInsertET( CoreConnection connection, MofClass clazz ) {

        Set<InsertET> iETs = new HashSet<InsertET>( );
        iETs.add( createInsertET( clazz ) );
        SpiJmiHelper jh = connection.getCoreJmiHelper( );
        Collection<GeneralizableElement> subTypes = jh.getAllSubtypes( connection, clazz );
        for ( Iterator<GeneralizableElement> i = subTypes.iterator( ); i.hasNext( ); ) {
            GeneralizableElement o = i.next( );
            if ( o instanceof MofClass ) {
                iETs.add( createInsertET( (MofClass) o ) );
            }
        }
        return iETs;
    }

    /**
     * Creates a Set of <tt>DeleteET</tt>s for a MofClass and all its
     * subclasses.
     * 
     * @param connection the core connection
     * @param clazz the class for which to create <tt>InsertET</tt>
     * @return a Set of <tt>InsertET</tt>s
     */
    public Set<DeleteET> createAllDeleteET( CoreConnection connection, MofClass clazz ) {

        Set<DeleteET> dETs = new HashSet<DeleteET>( );
        dETs.add( createDeleteET( clazz ) );
        SpiJmiHelper jh = connection.getCoreJmiHelper( );
        Collection<GeneralizableElement> subTypes = jh.getAllSubtypes( connection, clazz );
        for ( Iterator<GeneralizableElement> i = subTypes.iterator( ); i.hasNext( ); ) {
            GeneralizableElement o = i.next( );
            if ( o instanceof MofClass ) {
                dETs.add( createDeleteET( (MofClass) o ) );
            }
        }
        return dETs;
    }

    /**
     * resets the factory
     */
    public void reset( ) {

        this.deleteETMap.clear( );
        this.deleteRTMap.clear( );
        this.insertETMap.clear( );
        this.insertRTMap.clear( );
        this.updateAttributeMap.clear( );
    }

    private CoreConnection getCoreConnection( Connection connection ) {

        if ( connection instanceof Wrapper<?> ) {
            return (CoreConnection) ( (Wrapper<?>) connection ).unwrap( );
        }
        return (CoreConnection) connection;
    }

}