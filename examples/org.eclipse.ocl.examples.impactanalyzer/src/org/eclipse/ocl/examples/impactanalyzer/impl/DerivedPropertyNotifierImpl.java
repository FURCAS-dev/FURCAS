/*******************************************************************************
 * Copyright (c) 2010 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package org.eclipse.ocl.examples.impactanalyzer.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.OppositeEndFinder;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.impactanalyzer.DerivedPropertyNotifier;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluator;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;
import org.eclipse.ocl.examples.impactanalyzer.ValueNotFoundException;
import org.eclipse.ocl.examples.impactanalyzer.configuration.ActivationOption;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;

/**
 * Used to observe and filter for model changes that affect derived properties
 * defined by OCL expression. Construct an instance for a single
 * {@link EStructuralFeature} or all properties of an {@link EPackage} and
 * {@link #subscribe(EventManager) subscribe} for change notifications at an
 * {@link EventManager}. When changes affecting a derived property's value are
 * received, the actual changes are determined, and new {@link Notification}s
 * are created for those objects on which the derived property's value did
 * change.
 * <p>
 * 
 * To achieve this service, this class makes use of an {@link ImpactAnalyzer}
 * for each derivation expression. This allows us to construct event filters
 * catching the subset of change notifications which may affect the derivation
 * expression's value. The {@link ImpactAnalyzer} is then used to further reduce
 * the number of possible context objects on which to check for actual changes.
 * The changes observed are then assembled into an according change
 * {@link Notification} for the derived property itself and forwarded by calling
 * {@link EObject#eNotify(Notification)} on the object where it changed.
 * 
 * @author Martin Hanysz, Axel Uhl
 * 
 */
public class DerivedPropertyNotifierImpl implements DerivedPropertyNotifier {
    private final OCLFactory oclFactory;
    private final Set<DerivedPropertyAdapter> adapters = new HashSet<DerivedPropertyAdapter>();
	private final OppositeEndFinder oppositeEndFinder;
	private final ActivationOption impactAnalyzerConfiguration;

    public DerivedPropertyNotifierImpl(ActivationOption impactAnalyzerConfiguration,
    		OppositeEndFinder oppositeEndFinder, OCLFactory oclFactory,
    		EStructuralFeature... derivedProperties) {
    	this.oclFactory = oclFactory;
    	this.oppositeEndFinder = oppositeEndFinder;
    	this.impactAnalyzerConfiguration = impactAnalyzerConfiguration;
		for (EStructuralFeature derivedProperty : derivedProperties) {
			if (!derivedProperty.isDerived()) {
				throw new IllegalArgumentException(
						"Given property must be derived");
			}
			adapters.add(new DerivedPropertyAdapter(derivedProperty));
		}
    }

	public void subscribe(EventManager eventManager) {
    	for (DerivedPropertyAdapter adapter : adapters) {
    		adapter.subscribe(eventManager);
    	}
    }
    
	public void unsubscribe(EventManager eventManager) {
    	for (DerivedPropertyAdapter adapter : adapters) {
    		eventManager.unsubscribe(adapter);
    	}
    }
    
	/**
	 * From the derived {@link EStructuralFeature} passed to the constructor,
	 * extracts the OCL expression. When {@link #subscribe(EventManager)
	 * subscribing} for events affecting that expression's value, an
	 * {@link ImpactAnalyzer} is created for the expression, and the
	 * {@link ImpactAnalyzer#createFilterForExpression() event filter} is
	 * obtained and subscribed at the {@link EventManager} given as argument.
	 * <p>
	 * 
	 * When the respective {@link Notification}s are received, the
	 * {@link ImpactAnalyer}'s
	 * {@link ImpactAnalyzer#getContextObjects(Notification)} method is used to
	 * determine the candidate objects for which the derived property may have
	 * changed value. Then, uses the {@link PartialEvaluator} to compute before
	 * and after image of the property. For those contexts where it really
	 * changed value, a new {@link Notification} is constructed, indicating the
	 * derived property's change. It is then
	 * {@link EObject#eNotify(Notification) notified} by context object that
	 * changed, for each context object where it changed.
	 * 
	 * @author Martin Hanysz, Axel Uhl
	 */
	private class DerivedPropertyAdapter implements Adapter {
	    private Notifier target;
	    private ImpactAnalyzer ia;
	    private final EStructuralFeature property;
	    private final OCLExpression derivationExp;
	    
	    /**
	     * Creates an adapter that can be {@link #subscribe(EventManager) subscribed} for
	     * events signaling potential changes of the derived property's value.
	     * 
	     * @param property a {@link EStructuralFeature#isDerived() derived} property
	     */
	    public DerivedPropertyAdapter(EStructuralFeature property) {
			this.property = property;
			this.derivationExp = SettingBehavior.INSTANCE.getFeatureBody(
					oclFactory.createOCL(oppositeEndFinder), this.property);
	    }
	    
		/**
		 * subscribe at the event manager to get notified about changes that
		 * match the created filter (i.e. may have impact on the derivation
	     * expression)
	     */
	    public void subscribe(EventManager eventManager) {
	    	eventManager.subscribe(getImpactAnalyzer().createFilterForExpression(), this);
	    }
	    
	    private ImpactAnalyzer getImpactAnalyzer() {
	    	if (ia == null) {
	    		// notifications are also created for new context elements because
	    		// their derived property is conceptually set at the time of creation
				ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(
						derivationExp, /* notifyOnNewContextElements */true,
						oppositeEndFinder, impactAnalyzerConfiguration,
						oclFactory);
			}
	    	return ia;
	    }

	    @SuppressWarnings("unchecked")
		public void notifyChanged(Notification notification) {
			if (notification.isTouch()) {
				// in case of a "touch" that did not change anything, just do
				// nothing
				return;
			}
			Collection<EObject> impact = getImpactAnalyzer().getContextObjects(notification);
			if (impact.size() > 0) {
				// calculate the exact change
				for (EObject context : impact) {
					Object resultPre = null;
					Object resultPost = null;
					try {
						// comment recommends using #getInstance(set), but this
						// method is not present at the time of this
						// implementation.
						PartialEvaluator prePartEv = PartialEvaluatorFactory.INSTANCE
								.createPartialEvaluator(notification,
										DefaultOppositeEndFinder.getInstance(),
										oclFactory);
						PartialEvaluator postPartEv = PartialEvaluatorFactory.INSTANCE
								.createPartialEvaluator(
										DefaultOppositeEndFinder.getInstance(),
										oclFactory);
						resultPre = prePartEv.evaluate(context, derivationExp);
						resultPost = postPartEv
								.evaluate(context, derivationExp);
					} catch (ValueNotFoundException e) {
						// since the self context of the expression is known,
						// there should be no unknown variables
						throw new RuntimeException(
								"During the partial evaluation of a derived property expression, an unknown variable was found.");
					}

					// in case of an unset feature, resultPre will be null which
					// will cause a null pointer exception when calling .equals
					// therefore we need to check this case explicitly
					if ((resultPre == null && resultPost != null)
							|| !resultPre.equals(resultPost)) {
						// calculate the delta between pre change and post
						// change
						// to determine which notification to send.
						Object oldValue = resultPre;
						Object newValue = resultPost;
						int eventType;
						if (property.isMany()) {
							// handle list features
							List<EObject> preList;
							List<EObject> postList;
							if (resultPre instanceof List<?>
									&& resultPost instanceof List<?>) {
								// this is as much typechecking as possible ->
								// supressed warnings for "unchecked"
								preList = (ArrayList<EObject>) resultPre;
								postList = (ArrayList<EObject>) resultPost;
							} else {
								throw new ClassCastException(
										"The values of a many valued feature are not type of EList as they should.");
							}
							if (preList.size() == postList.size()) {
								eventType = Notification.MOVE;
							} else if (preList.size() < postList.size()) {
								if (preList.size() + 1 == postList.size()) {
									eventType = Notification.ADD;
								} else {
									eventType = Notification.ADD_MANY;
								}
							} else {
								if (preList.size() == postList.size() + 1) {
									eventType = Notification.REMOVE;
								} else {
									eventType = Notification.REMOVE_MANY;
								}
							}
						} else {
							// handle single valued features
							if (property.isUnsettable()) {
								if (resultPost == null) {
									eventType = Notification.UNSET;
								} else {
									eventType = Notification.SET;
								}
							} else {
								eventType = Notification.SET;
							}
						}
						Notification changeNoti = new ENotificationImpl(
								(InternalEObject) context, eventType, property,
								oldValue, newValue);
						context.eNotify(changeNoti);
					}
				}
			}
		}

		public Notifier getTarget() {
			return target;
		}

		public void setTarget(Notifier newTarget) {
			target = newTarget;
		}

		public boolean isAdapterForType(Object type) {
			return type == DerivedPropertyNotifierImpl.class;
		}
	}
}
