package com.sap.tc.moin.repository.core.checks;

import com.sap.tc.moin.repository.ocl.freestyle.OclRegistration;

/**
 * The "Java coded" constraint registration
 */
public interface JavaCodedConstraintRegistration extends OclRegistration {

    /**
     * Enumeration of the possible values
     */
    public enum Constraints {
        /** The meta object must not be null */
        MetaObjectNotNull,
        /** The MOF ID must not be null */
        MofIdNotNull,
        /** Must have storage on one end */
        MustHaveStorageOnOneEnd,
        /** No support for double storage */
        NoDoubleStorage,
        /**
         * Cross-metamodel associations where the association is in a different
         * metamodel than the MofClass at the storage end are not allowed.
         */
        NoStorageInOtherMetamodel,
        /** Substitute names not allowed */
        NoSubstituteNames,
        /** Package prefixes are only allowed for toplevel packages */
        PackagePrefixOnlyForToplevelPackage,
        /** Overflow */
        Overflow,
        /** Underflow */
        Underflow,
        /** Rules for model element names */
        ValidName,
        /** The workspace must not be null */
        WorkspaceNotNull
    }
}
