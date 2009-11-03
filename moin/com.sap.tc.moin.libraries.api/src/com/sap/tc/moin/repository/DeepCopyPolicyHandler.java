package com.sap.tc.moin.repository;

import com.sap.tc.moin.repository.mmi.reflect.RefObject;

/**
 * This interface can be used by DeepCopy clients to control the DeepCopy
 * process. Clients can provide an implementation of this interface in the
 * {@link Connection#deepCopy(java.util.Collection, DeepCopyPolicyHandler, boolean)}
 * method. This way, the default copy policy can be replaced with any other
 * legal one (see
 * {@link DeepCopyPolicyHandler#getDeepCopyingPolicy(RefObject, DeepCopyPolicy, DeepCopyMap)}
 * ).
 * 
 * @see Connection#deepCopy(java.util.Collection, DeepCopyPolicyHandler,
 * boolean)
 * @author D045996
 * <p>
 * This interface <i>is</i> intended to be implemented by clients.
 */
public interface DeepCopyPolicyHandler {

    /**
     * This method is called during the DeepCopy process to determine the Deep
     * Copying policy for each single model element. The default policies can be
     * changed in the following way:
     * <UL>
     * <li>FULL_COPY can be changed to STOP and CUSTOM </li> <li>REF_COPY can be
     * changed to FULL_COPY, STOP and CUSTOM</li> <li>STOP and CUSTOM cannot be
     * changed since they are never default policies.</li>
     * </UL>
     * If the policy handler performs an illegal policy modification, the
     * default policy will be used instead, and the error reported.
     * 
     * @see DeepCopyPolicy
     * @param sourceElement The (wrapped) element to be copied
     * @param defaultPolicy The default policy for this element
     * @param copyMap The mapping table of the already mapped elements
     * @return The Deep Copying policy for the element
     */
    public DeepCopyPolicy getDeepCopyingPolicy( RefObject sourceElement, DeepCopyPolicy defaultPolicy, DeepCopyMap copyMap );

}
