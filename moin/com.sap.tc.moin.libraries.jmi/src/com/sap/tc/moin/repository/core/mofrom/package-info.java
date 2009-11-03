/**
 * This documents the problems and findings we had when we developed the MofRom
 * for MOIN.
 * <h1>Issue GetReferencedEndEndlessLoop</h1>
 * <p>
 * Author: d024227, Date: 2005-11-24
 * <p>
 * We cache the References and Attributes (we call them here "metaObjects" for
 * short) of a Class and make them accessible by their name. This info is
 * available and accessible on all {@link RefClass RefClasses}. The Info is
 * calculated lazily and then cached. We ran into a problem when we tried to
 * calculate this for the MOF the first time the info was requested:
 * <ul>
 * <li>Endless recursion when trying to get the metaObjects for
 * {@link MofClass}. This is executed by the Class proxy of {@link MofClass},
 * the Java Class {@link MofClassClassImpl}</li>
 * <li>{@link MofClassClass} in the implementation of
 * {@link RefClassImpl#get___AttributeOrReferenceByName}) tries to get all
 * References and calls for a Reference the method
 * {@link com.sap.tc.moin.repository.mmi.model.Reference#getReferencedEnd()} to get the
 * {@link AssociationEnd}</li>
 * <li>Ultimately the ReferenceImpl is called again to find out the
 * {@link AssociationEnd} for something</li>
 * <li>For all calls to get the referencedEnd the Class proxy
 * {@link ReferenceClassImpl} is called to fill the cache of its metaObjects
 * </li>
 * </ul>
 * <p>
 * <b>Resolution </b>: Precalculate these metaObjects in the {@link MoinMofRom}
 * and set them on the class proxy
 * <h1>Issue GetAssociationEndsEndlessLoop</h1>
 * <p>
 * Author: d024227, Date: 2005-11-24
 * <p>
 * Endless recursion when trying to determine the
 * {@link Association Association's} {@link AssociationEnd AssociationEnds}.
 * Endless loop because the request
 * {@link JmiHelperImpl#isEndStored(AssociationEnd)} navigates the {@link Contains}
 * {@link Association} to get the relevant tags holding the according
 * information. For the Contains Association itself the
 * {@link JmiHelperImpl#isEndStored(AssociationEnd)} info is required too.
 * <p>
 * First try to get that resolved was to cache the stored info on the
 * {@link Association}. But in some cases there is just the
 * {@link AssociationEnd} provided so that first the {@link Association} was to
 * be calculated with {@link com.sap.tc.moin.repository.mmi.model.AssociationEnd#getContainer()}
 * which ultimately led to navigating the {@link Contains} {@link Association}
 * which requires to determine the storage of its ends -> <b>recursion </b>
 * <p>
 * <b>Resolution </b>:
 * <ul>
 * <li>Precalculate the {@link AssociationEnd AssociationEnds} for an
 * {@link Association} for all MOF {@link Association Associations} </li>
 * <li>Precalculate the storage info for all
 * {@link AssociationEnd AssociationEnds} </li>
 * <li>There is a specialization of both {@link AssociationEnd} and
 * {@link Association} which is instantiated by the MofRom.</li>
 * </ul>
 * <p>
 * <h1>Issue RefBaseObjectOrderOfInitialization</h1>
 * <p>
 * Author: d024227, Date: 2005-11-24
 * <p>
 * There is a specific sequence which need to be followed in order to initialize
 * a RefBaseObject properly. The sequence found may not be changed easily.
 * <p>
 * There was a problem to find the proper order of initializing a base class. It
 * boils down to the order of the two properties {@link RefObject metaObject}
 * and {@link Workspace}:
 * <ul>
 * <li>The Workspace was needed to calculate the Reference for the provided
 * MOIN {@link RefObject metaObject}.</li>
 * <li>The {@link RefObject metaObject} was needed when the constraints for
 * partitions were checked. When assigning the {@link Workspace} also the
 * {@link NoPartition} was assigned.</li>
 * </ul>
 * <p>
 * <b>Resolution </b>:
 * <ul>
 * <br>
 * Sequence:
 * <li>Set Workspace</li>
 * <li>Set MetaObject</li>
 * </ul>
 * <br>
 * The checks for the partition assignment were switched of - they are not
 * necessary when creating an object from scratch
 */
package com.sap.tc.moin.repository.core.mofrom;