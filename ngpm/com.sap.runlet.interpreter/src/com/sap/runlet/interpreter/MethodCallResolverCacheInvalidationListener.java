package com.sap.runlet.interpreter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.ocl.examples.eventmanager.EventFilter;
import org.eclipse.ocl.examples.eventmanager.EventManagerFactory;

import data.classes.ClassesPackage;

public class MethodCallResolverCacheInvalidationListener extends AdapterImpl {
    private final MethodCallResolver resolver;

    public MethodCallResolverCacheInvalidationListener(MethodCallResolver resolver) {
        this.resolver = resolver;
    }

    public EventFilter getFilter() {
        // TODO use OCL impact analyzer on an allInstances() expression instead
        EventManagerFactory emf = EventManagerFactory.eINSTANCE;
        EventFilter ownedMethodSignaturesFilter = emf.createStructuralFeatureFilter(ClassesPackage.eINSTANCE.getSignatureOwner_OwnedSignatures());
        EventFilter adaptedToFilter = emf.createStructuralFeatureFilter(ClassesPackage.eINSTANCE.getTypeAdapter_To());
        EventFilter adaptersFilter = emf.createStructuralFeatureFilter(ClassesPackage.eINSTANCE.getTypeAdapter_Adapted());
        // TODO what about watching delegation changes?
        EventFilter allFilter = emf.createOrFilterFor(ownedMethodSignaturesFilter, adaptedToFilter, adaptersFilter);
        return allFilter;
    }

    @Override
    public void notifyChanged(Notification event) {
        resolver.invalidateCache();
        /*
         * TODO do more fine-grained invalidation LinkChangeEvent lce = (LinkChangeEvent) event; ResourceSet conn =
         * lce.getEventTriggerResourceSet(); Association a = (Association) lce.getAffectedMetaObject(conn); if
         * (a.equals(conn.getAssociation(OwnedSignatures.ASSOCIATION_DESCRIPTOR).refMetaObject())) { SignatureOwner owner =
         * (SignatureOwner) conn.getElement(lce.getFirstLinkEndMri().getLri()); MethodSignature sig = (MethodSignature)
         * conn.getElement(lce.getSecondLinkEndMri().getLri()); // TODO invalidate cache for owner; if owner is adapter,
         * invalidate all adapted transitively } else if
         * (a.equals(conn.getAssociation(AdaptedTo.ASSOCIATION_DESCRIPTOR).refMetaObject())) { SapClass c = (SapClass)
         * conn.getElement(lce.getFirstLinkEndMri().getLri()); TypeAdapter adapter = (TypeAdapter)
         * conn.getElement(lce.getSecondLinkEndMri().getLri()); // TODO invalidate cache for owner; if owner is adapter,
         * invalidate all adapted transitively } else if
         * (a.equals(conn.getAssociation(AdaptedTo.ASSOCIATION_DESCRIPTOR).refMetaObject())) { SapClass c = (SapClass)
         * conn.getElement(lce.getFirstLinkEndMri().getLri()); TypeAdapter adapter = (TypeAdapter)
         * conn.getElement(lce.getSecondLinkEndMri().getLri()); // TODO invalidate cache for owner; if owner is adapter,
         * invalidate all adapted transitively }
         */
    }

}
