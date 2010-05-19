/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class NotificationIdentifierBuilder {

    protected NotificationIdentifierBuilder() {
        super();
    }

    public Set<NotificationIdentifier> buildFrom(Notification noti) {
        Set<NotificationIdentifier> rList = new HashSet<NotificationIdentifier>();

        rList.addAll(buildIdentifier(noti.getNotifier(), noti.getEventType(), noti.getFeature(), noti.getNewValue(), noti
                .getOldValue(), noti.isReset(), noti.isTouch()));

        return rList;
    }

    /**
     * Creates a list of identifiers for the given parameters
     * 
     * @param notifier
     *            notifier of the {@link Notification}
     * @param eventType
     *            {@link Notification#getEventType()}
     * @param feature
     *            {@link Notification#getFeature()}
     * @param newValue
     *            {@link Notification#getNewValue()}
     * @param oldValue
     *            {@link Notification#getOldValue()}
     * @param isReset
     *            {@link Notification#isReset()}
     * @param isTouch
     *            {@link Notification#isTouch()}
     * @return
     */
    private Collection<NotificationIdentifier> buildIdentifier(Object notifier, int eventType, Object feature, Object newValue,
            Object oldValue, boolean isReset, boolean isTouch) {
        Collection<NotificationIdentifier> resultList = new HashSet<NotificationIdentifier>();
        NotificationIdentifier result = EventManagerFactory.eINSTANCE.createNotificationIdentifier();

        if (feature instanceof EReference && ((EReference) feature).isContainment()) {
            result.setContainment(true);
            switch (eventType) {
            case Notification.ADD: {
                callBuildIdentifierForAContainmentRef(newValue, resultList, true);
                break;
            }
            case Notification.REMOVE: {
                callBuildIdentifierForAContainmentRef(newValue, resultList, false);
                break;
            }
            default: {
                // REMOVE_MANY or ADD_MANY
                EList<?> addedElementObjects = (EList<?>) newValue;
                boolean addMany = eventType == Notification.ADD_MANY;
                for (Object addedO : addedElementObjects) {
                    callBuildIdentifierForAContainmentRef(addedO, resultList, addMany);
                }
            }
            }
        }
        if (notifier instanceof EObject) {
            result.setNotifierClassURI(EcoreUtil.getURI(((EObject) notifier).eClass()));
        }
        result.setEventType(eventType);

        if (feature instanceof EObject) {
            result.setFeatureURI(EcoreUtil.getURI(((EObject) feature)));
        }
        result.setReset(isReset);

        result.setTouch(isTouch);
        if (feature instanceof EReference) {
            generateAllClassURIs(newValue, result.getNewValueClassURIs());

            generateAllClassURIs(oldValue, result.getOldValueClassURIs());
        }
        resultList.add(result);
        return resultList;
    }

    /**
     * Create a recursive call of the buildIdentifier function termination condition: no additional filled containment references
     * for the newValue object/-s
     * 
     * @param newValue
     * @param resultList
     * @param add
     */
    private void callBuildIdentifierForAContainmentRef(Object newValue, Collection<NotificationIdentifier> resultList, boolean add) {
        EObject addedElement = (EObject) newValue;
        EList<EReference> allCon = addedElement.eClass().getEAllContainments();
        for (EReference containmentReference : allCon) {
            generateIdentifierForRef(resultList, addedElement, containmentReference, add);
        }
        Set<EStructuralFeature> allFeatures = new HashSet<EStructuralFeature>(addedElement.eClass().getEAllStructuralFeatures());
        allFeatures.removeAll(allCon);
        for (EStructuralFeature f : allFeatures) {
            if (f instanceof EReference) {
                EReference ref = (EReference) f;
                generateIdentifierForRef(resultList, addedElement, ref, add);

            } else {
                Object valueToSet = addedElement.eGet(f);
                /*
                 * If the the value that should be set is the default value no identifier is necessary
                 */
                if (valueToSet == null && f.getDefaultValue() == null || f.getDefaultValue() != null
                        && f.getDefaultValue().equals(valueToSet)) {
                    return;
                } else {
                    resultList.addAll(buildIdentifier(addedElement, Notification.SET, f, addedElement.eGet(f), f
                            .getDefaultValue(), false, false));
                }
            }
        }
    }

    /**
     * Creates an ADD or ADD_MANY identifier for the given Reference on the given object, if the reference to handle is
     * empty/null, no identifier will be added to the list
     * 
     * @param resultList
     *            the list to add identifiers
     * @param addedElement
     *            the element which hold the reference
     * @param reference
     *            the class of the reference
     */
    private void generateIdentifierForRef(Collection<NotificationIdentifier> resultList, EObject addedElement,
            EReference reference, boolean add) {
        Object valueObject = addedElement.eGet(reference);
        if (reference.isMany()) {
            if (!((EList<?>) valueObject).isEmpty()) {
                resultList.addAll(buildIdentifier(addedElement, add ? Notification.ADD_MANY : Notification.REMOVE_MANY,
                        reference, add ? valueObject : new BasicEList<EObject>(), add ? new BasicEList<EObject>() : valueObject,
                        false, true));
            }
        } else if (valueObject != null) {
            resultList.addAll(buildIdentifier(addedElement, add ? Notification.ADD : Notification.REMOVE, reference,
                    add ? valueObject : new BasicEList<EObject>(), add ? new BasicEList<EObject>() : valueObject, false, true));
        }
    }

    /**
     * Adds for all {@link EObject}s from the given valueObject the EClass to the given list
     * 
     * @param valueObject
     * @param set
     */
    private void generateAllClassURIs(Object valueObject, Set<URI> set) {
        if (valueObject instanceof EObject) {
            set.add(EcoreUtil.getURI(((EObject) valueObject).eClass()));
        } else if (valueObject instanceof EList<?>) {
            for (Object o : (EList<?>) valueObject) {
                if (o instanceof EObject) {
                    set.add(EcoreUtil.getURI(((EObject) o).eClass()));
                }
            }
        } else if (valueObject == null) {
            return;
        } else {
            throw new IllegalArgumentException("Notification Value is not of expected types");
        }

    }

} // NotificationIdentifierBuilderImpl
