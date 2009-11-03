/**
 * Providing information about deployed metamodels. <br>
 * The metamodels are imported into MOIN repository in special deployment step.
 * The process is using scenario-related functionality, d.B. in Eclipse scenario
 * the metamodel provided as Eclipse plug-in and the deployment process starts
 * during MOIN startup. In Java Server scenario the metamodel deployment is
 * triggered by system administrator using deployment view.
 * <p>
 * The metamodel package contains the interfaces describing:
 * <p>
 * - Metamodel catalog - provides the list of already deployed metamodels.
 * <p>
 * - Metamodel info - provides the detail information about deployed metamodel,
 * e.g. container name, vendor name, metamodel version. <br>
 * <br>
 * This API is for SAP-internal use only and subject to change
 */
package com.sap.tc.moin.repository.metamodels;