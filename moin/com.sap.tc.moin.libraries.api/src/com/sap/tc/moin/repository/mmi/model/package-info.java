/**
 * Provides the "tailored" interfaces for the MOF Model (also known as the
 * metametamodel or M3 for short). This is the "abstraction language" used to
 * define metamodels. The M3 is used to define information models for metadata
 * (referred to as metamodels, or M2 for short). The MOF Model provides a set of
 * modeling elements that are used for constructing metamodels. The "tailored"
 * (i.e. generated) interfaces allow to do the following in a strongly typed way
 * instead of having to use generic {@link com.sap.tc.moin.repository.mmi.reflect "reflective"}
 * methods:
 * <ul>
 * <li> Create, update, access, navigate and invoke operations on class proxy
 * objects.
 * <li> Query and update links using association objects.
 * <li> Navigate MOF package structure.
 * </ul> <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.mmi.model;