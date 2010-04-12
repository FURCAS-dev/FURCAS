/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.impl;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import de.hpi.sam.bp2009.solution.eventManager.AttributeMultiValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.AttributeValueChangeEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.ElementDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerFactory;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventMappper;
import de.hpi.sam.bp2009.solution.eventManager.LinkCreateEvent;
import de.hpi.sam.bp2009.solution.eventManager.LinkDeleteEvent;
import de.hpi.sam.bp2009.solution.eventManager.ModelChangeEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Mappper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EventMappperImpl extends EObjectImpl implements EventMappper {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventMappperImpl() {
		super();
	}



	/**
	 * Creates an {@link AttributeValueChangeEvent} for an SET notification
	 * @param notification the emf notification
	 * @param attr the attribute type (upperbound=1)
	 * @return the {@link AttributeValueChangeEvent}
	 */
	private AttributeValueChangeEvent createAttributeValueChange(
			Notification notification, EAttribute attr) {
		// TODO Test and verify unchecked cast
		AttributeValueChangeEvent event = EventManagerFactory.eINSTANCE.createAttributeValueChangeEvent();
		configureAttributeChange(notification, attr, event);
		
		return event;
		
	}



	/**
	 * Helper method that capsules the basic mapping mechansim for an {@link AttributeValueChangeEvent}
	 * @param notification emf notification which gets evaluated
	 * @param attr attribute type handled in the notification
	 * @param event event to configure
	 */
	private void configureAttributeChange(Notification notification,
			EAttribute attr, AttributeValueChangeEvent event) {
		event.setChangedAttribute(attr);
		event.setBefore(notification.getOldValue());
		event.setAfter(notification.getNewValue());
		event.setSourceObject((EObject) notification.getNotifier());
	}

	/**
	 * Creates an {@link AttributeValueChangeEvent} for an notification which contains a many-eventtype for an attribute
	 * @param notification the emf notification to evaluate
	 * @param attr the attribute type handled in the notification
	 * @param add is it an ADD_MANY notification (otherwise REMOVE_MANY)
	 * @return an collection containing one {@link AttributeMultiValueChangeEvent} 
	 */
	private Collection<? extends AttributeValueChangeEvent> createAttributeValueChanges(
			Notification notification, EAttribute attr, boolean add) {
		//TODO discuss if one event for a add event is enough
		HashSet<AttributeValueChangeEvent> result = new HashSet<AttributeValueChangeEvent>();
		AttributeMultiValueChangeEvent event = EventManagerFactory.eINSTANCE.createAttributeMultiValueChangeEvent();
		configureAttributeChange(notification, attr, event);
		event.setAdd(add);
		result.add(event);
		
		return result;
	}

	/** 
	 * Creates an {@link ElementCreateEvent} for an SET notification of an containment feature
	 * @param notification the emf notification
	 * @param ref reference type, which is containment
	 * @return the {@link ElementCreateEvent} event
	 */
	private ElementCreateEvent createElementCreateEvent(
			Notification notification, EReference ref) {
		// TODO Test and verify unchecked cast
		ElementCreateEvent event = EventManagerFactory.eINSTANCE.createElementCreateEvent();
		event.setSourceObject((EObject)notification.getNewValue());
		event.setContainingElement((EObject)notification.getNotifier());
		return event;
	}

	/**
	 * Create a collection of {@link ElementCreateEvent} for an given ADD_MANY notification of a containment feature 
	 * @param notification the emf notification
	 * @param ref the reference type isContainment and Upperbound >1
	 * @return the {@link ElementCreateEvent}s
	 */
	private Collection<? extends ElementCreateEvent> createElementCreateEvents(
			Notification notification, EReference ref) {
		// TODO Test and verify unchecked cast
		HashSet<ElementCreateEvent> result = new HashSet<ElementCreateEvent>();

		EList<EObject> newbies= (EList<EObject>) notification.getNewValue();
		for(EObject newbie: newbies){
			ElementCreateEvent event= EventManagerFactory.eINSTANCE.createElementCreateEvent();
			event.setSourceObject(newbie);
			event.setContainingElement((EObject)notification.getNotifier());
			result.add(event);
		}
		return result;
	}

	/**
	 * Creates an {@link ElementDeleteEvent} for an SET to NULL or an UNSET notification
	 * @param notification the emf notification
	 * @param ref the reference type isContainment
	 * @return the {@link ElementDeleteEvent}
	 */
	private ElementDeleteEvent createElementDeleteEvent(
			Notification notification, EReference ref) {
		// TODO Test and verify unchecked cast
		ElementDeleteEvent event= EventManagerFactory.eINSTANCE.createElementDeleteEvent();
		event.setSourceObject((EObject)notification.getOldValue());
		event.setContainingElement((EObject)notification.getNotifier());
		return event;
	}

	/**
	 * Creates a Collection of {@link ElementDeleteEvent}s for an given REMOVE_MANY notification
	 * @param notification the emf notification
	 * @param ref the reference type isContainment and UpperBound>1
	 * @return {@link ElementDeleteEvent}s
	 */
	private Collection<? extends ElementDeleteEvent> createElementDeleteEvents(
			Notification notification, EReference ref) {
		// TODO Test and verify unchecked cast
		HashSet<ElementDeleteEvent> result = new HashSet<ElementDeleteEvent>();

		EList<EObject> castAways= (EList<EObject>) notification.getOldValue();
		for(EObject castAway: castAways){
			ElementDeleteEvent event= EventManagerFactory.eINSTANCE.createElementDeleteEvent();
			event.setSourceObject(castAway);
			event.setContainingElement((EObject)notification.getNotifier());
			result.add(event);
		}
		return result;
	}

	/**
	 * Creates an LinkCreateEvent for an SET notification for a reference
	 * @param notification the emf notification
	 * @param ref the setted reference
	 * @return the {@link LinkCreateEvent}
	 */
	private LinkCreateEvent createLinkCreateEvent(Notification notification,
			EReference ref) {
		// TODO Auto-generated method stub
		LinkCreateEvent event= EventManagerFactory.eINSTANCE.createLinkCreateEvent();
		event.setSourceObject((EObject)notification.getNotifier());
		event.setChangedReference(ref);
		event.setCorrespondingObject((EObject)notification.getNewValue());
		return event;
	}

	/**
	 * @param notification
	 * @param ref
	 * @return
	 */
	private Collection<? extends LinkCreateEvent> createLinkCreateEvents(
			Notification notification, EReference ref) {
		// TODO Auto-generated method stub
		HashSet<LinkCreateEvent> result = new HashSet<LinkCreateEvent>();

		EList<EObject> newbies= (EList<EObject>) notification.getNewValue();
		for(EObject newbie: newbies){
			LinkCreateEvent event= EventManagerFactory.eINSTANCE.createLinkCreateEvent();
			event.setSourceObject((EObject)notification.getNotifier());
			event.setCorrespondingObject(newbie);
			event.setChangedReference(ref);
			result.add(event);
		}
		return result;
	}

	private LinkDeleteEvent createLinkDeleteEvent(Notification notification,
			EReference ref) {
		// TODO Auto-generated method stub
		LinkDeleteEvent event= EventManagerFactory.eINSTANCE.createLinkDeleteEvent();
		event.setSourceObject((EObject)notification.getNotifier());
		event.setChangedReference(ref);
		event.setCorrespondingObject((EObject) notification.getOldValue());
		return event;
	}

	private Collection<? extends LinkDeleteEvent> createLinkDeleteEvents(
			Notification notification, EReference ref) {
		// TODO Auto-generated method stub
		HashSet<LinkDeleteEvent> result = new HashSet<LinkDeleteEvent>();

		EList<EObject> castAways= (EList<EObject>) notification.getOldValue();
		for(EObject castAway: castAways){
			LinkDeleteEvent event= EventManagerFactory.eINSTANCE.createLinkDeleteEvent();
			event.setCorrespondingObject(castAway);
			event.setSourceObject((EObject)notification.getNotifier());
			event.setChangedReference(ref);
			result.add(event);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EventManagerPackage.Literals.EVENT_MAPPPER;
	}



	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList<ModelChangeEvent> mapNotificationToEvent(Notification notification) {
		EList<ModelChangeEvent> result=new BasicEList<ModelChangeEvent>();
		
		switch (notification.getEventType()){
			case Notification.SET:{
				if(notification.getNewValue()==null){
					if(notification.getFeature() instanceof EReference){
						EReference ref= (EReference)notification.getFeature();
						if(ref.isContainment()){
							result.add(createElementDeleteEvent(notification, ref));
						}
						result.add(createLinkDeleteEvent(notification, ref));
					}else if(notification.getFeature() instanceof EAttribute){
						EAttribute attr = (EAttribute) notification.getFeature();
						result.add(createAttributeValueChange(notification, attr));
					}else{
						System.err.println("Not handled notification" + notification);
					}
					break;
				}
			}			
			case Notification.ADD:{
				if(notification.getFeature() instanceof EReference){
					EReference ref= (EReference)notification.getFeature();
					if(ref.isContainment()){
						result.add(createElementCreateEvent(notification, ref));
					}
					result.add(createLinkCreateEvent(notification, ref));
				}else if(notification.getFeature() instanceof EAttribute){
					EAttribute attr = (EAttribute) notification.getFeature();
					result.add(createAttributeValueChange(notification, attr));
				}else{
					System.err.println("Not handled notification" + notification);
				}
				break;
			}
			case Notification.REMOVE: {
				if(notification.getFeature() instanceof EReference){
					EReference ref= (EReference)notification.getFeature();
					if(ref.isContainment()){
						result.add(createElementDeleteEvent(notification, ref));
					}
					result.add(createLinkDeleteEvent(notification, ref));
				}else if(notification.getFeature() instanceof EAttribute){
					EAttribute attr = (EAttribute) notification.getFeature();
					result.add(createAttributeValueChange(notification, attr));
				}else{
					System.err.println("Not handled notification" + notification);
				}
				break;
			}
			case Notification.REMOVE_MANY:{
				if(notification.getFeature() instanceof EReference){
					EReference ref= (EReference)notification.getFeature();
					if(ref.isContainment()){
						result.addAll(createElementDeleteEvents(notification, ref));
					}
					result.addAll(createLinkDeleteEvents(notification, ref));
				}else if(notification.getFeature() instanceof EAttribute){
					EAttribute attr = (EAttribute) notification.getFeature();
					result.addAll(createAttributeValueChanges(notification, attr, false));
				}else{
					System.err.println("Not handled notification" + notification);
				}
				break;
			}
			case Notification.ADD_MANY:{
				if(notification.getFeature() instanceof EReference){
					EReference ref= (EReference)notification.getFeature();
					if(ref.isContainment()){
						result.addAll(createElementCreateEvents(notification, ref));
					}
					result.addAll(createLinkCreateEvents(notification, ref));
				}else if(notification.getFeature() instanceof EAttribute){
					EAttribute attr = (EAttribute) notification.getFeature();
					result.addAll(createAttributeValueChanges(notification, attr, true));
				}else{
					System.err.println("Not handled notification" + notification);
				}
				break;
			}
			default:
				System.err.println("Not handled notification" + notification);
				break;
		}
		
		return result;
		
	}

} //EventMappperImpl
