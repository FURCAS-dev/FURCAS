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

import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.opposites.DefaultOppositeEndFinder;
import org.eclipse.ocl.ecore.opposites.EcoreEnvironmentFactoryWithHiddenOpposites;
import org.eclipse.ocl.examples.eventmanager.EventManager;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzer;
import org.eclipse.ocl.examples.impactanalyzer.ImpactAnalyzerFactory;
import org.eclipse.ocl.examples.impactanalyzer.util.OCLFactory;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluator;
import org.eclipse.ocl.examples.impactanalyzer.PartialEvaluatorFactory;
import org.eclipse.ocl.examples.impactanalyzer.ValueNotFoundException;

/**
 * The {@link DerivedPropertyAdapter} adds the ability to emit change {@link Notification}s to derived properties. To achieve this
 * it makes use of an {@link ImpactAnalyzer} for the derivation expression that aggregates changes to the derivation expression
 * into an according change {@link Notification} of the property itself.
 * 
 * @author Martin Hanysz
 * 
 */
public class DerivedPropertyAdapter implements Adapter {
    private Notifier target;
    private final ImpactAnalyzer ia;
    private final EventManager em;
    private final EStructuralFeature property;
    private final OCLExpression derivationExp;
    private final OCLFactory oclFactory = OCLFactory.INSTANCE;

    public DerivedPropertyAdapter(EStructuralFeature derivedProperty) {
        if(!derivedProperty.isDerived()){
            throw new IllegalArgumentException("Given property must be derived");
        }
        
        this.property = derivedProperty;
        //TODO: verify if OCL.newInstance() doesn't break things because the IA will build it's own instance
        this.derivationExp = SettingBehavior.INSTANCE.getFeatureBody(OCL.newInstance(), this.property);
        this.em = EventManagerFactory.eINSTANCE.getEventManagerFor(property.eResource().getResourceSet()); // probably wrong if instance model does not share the resource set with the meta model
        this.ia = ImpactAnalyzerFactory.INSTANCE.createImpactAnalyzer(derivationExp, true, this.oclFactory);
        
        // subscribe at the event manager to get notified about changes that match the created filter (i.e. may have impact on the derivation expression)
        this.em.subscribe(ia.createFilterForExpression(), this);
    }

    @SuppressWarnings("unchecked")
    public void notifyChanged(Notification notification) {
        if (notification.isTouch()){
            // in case of a "touch" that did not change anything, just do nothing
            return;
        }
        
        Collection<EObject> impact = ia.getContextObjects(notification);
        if (impact.size() > 0) {
            // calculate the exact change
            for (EObject context : impact) {
                Object resultPre = null;
                Object resultPost = null;
                try {
                    // comment recommends using #getInstance(set), but this method is not present at the time of this implementation.
                    PartialEvaluator prePartEv = PartialEvaluatorFactory.INSTANCE.createPartialEvaluator(notification, DefaultOppositeEndFinder.getInstance(), oclFactory);
                    PartialEvaluator postPartEv = PartialEvaluatorFactory.INSTANCE.createPartialEvaluator(DefaultOppositeEndFinder.getInstance(), oclFactory);
                    resultPre = prePartEv.evaluate(context, derivationExp);
                    resultPost = postPartEv.evaluate(context, derivationExp);
                } catch (ValueNotFoundException e) {
                    // since the self context of the expression is known, there should be no unknown variables
                    throw new RuntimeException("During the partial evaluation of a derived property expression, an unknown variable was found.");
                }
                if (!resultPre.equals(resultPost)) {
                    // calculate the delta between pre change and post change
                    // to determine which notification to send.
                    Object oldValue = resultPre;
                    Object newValue = resultPost;
                    int eventType;
                    if (property.isMany()) {
                        // handle list features
                        EList<EObject> preList;
                        EList<EObject> postList;
                        if(resultPre instanceof EList<?> && resultPost instanceof EList<?>){
                            // this is as much typechecking as possible -> supressed warnings for "unchecked"
                            preList = (EList<EObject>) resultPre;
                            postList = (EList<EObject>) resultPost;
                        }else{
                            throw new ClassCastException("The values of a many valued feature are not type of EList as they should.");
                        }
                        if(preList.size() == postList.size()){
                            eventType = Notification.MOVE;
                        }else if(preList.size() < postList.size()){
                            if(preList.size() + 1 == postList.size()){
                                eventType = Notification.ADD;
                            }else{
                                eventType = Notification.ADD_MANY;
                            }
                        }else{
                            if(preList.size() == postList.size() + 1){
                                eventType = Notification.REMOVE;
                            }else{
                                eventType = Notification.REMOVE_MANY;
                            }
                        }
                    } else {
                        // handle single valued features
                        if (property.isUnsettable()) {
                            if(context.eIsSet(property)){
                                eventType = Notification.SET;
                            }else{
                                eventType = Notification.UNSET;
                            }
                        } else {
                            eventType = Notification.SET;
                        }
                    }
                    Notification changeNoti = new ENotificationImpl((InternalEObject) context, eventType, property, oldValue, newValue);
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
        return type == DerivedPropertyAdapter.class;
    }
}
