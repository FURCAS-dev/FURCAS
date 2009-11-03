/**
 * <h1>Consistency test cases</h1>
 * <table BORDER=0 WIDTH="800" >
 * <tr>
 * <td WIDTH="187" BGCOLOR="#9CAECE"><b><font color="#FFFFFF">Item</font></b></td>
 * <td WIDTH="603" BGCOLOR="#9CAECE"><b><font color="#FFFFFF">Value</font></b></td>
 * </tr>
 * <tr>
 * <td WIDTH="187"><font color="#808080">authors</font></td>
 * <td WIDTH="603">Eckart Liemke</td>
 * </tr>
 * <tr>
 * <td WIDTH="187"><font color="#808080">created</font></td>
 * <td WIDTH="603">26.07.2007</td>
 * </tr>
 * <tr>
 * <td WIDTH="187"><font color="#808080">last updated</font></td>
 * <td WIDTH="603">&nbsp;</td>
 * </tr>
 * <tr>
 * <td WIDTH="187"><font color="#808080">distribution list</font></td>
 * <td WIDTH="603">&nbsp;</td>
 * </tr>
 * </table>
 * <h2>Content</h2>
 * <p>
 * This document lists the existing test cases for inconsistencies.
 * </p>
 * <h2>List of test cases and corrections</h2>
 * <h3>Dangling link tests</h3>
 * <table border="1" width="100%" id="table1">
 * <tr>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Test case class</b></font></td>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Method</b></font></td>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Description</b></font></td>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Correction</b></font></td>
 * </tr>
 * <tr>
 * <td>TestInconsistencyFixing</td>
 * <td>testDanglingLinkInconsistencyRecreateElement()</td>
 * <td>Dangling single storage link.</td>
 * <td>Correction done by recreating the missing element.</td>
 * </tr>
 * <tr>
 * <td>&nbsp;</td>
 * <td>testDoubleStorageDanglingLinkWithJmiList()</td>
 * <td>Double storage dangling composite link with JMI list. Composite parent
 * has two children of which one is missing.</td>
 * <td>Correction done by recreating the missing element.</td>
 * </tr>
 * <tr>
 * <td height="34">TestInconsistencyCorrectionHandle</td>
 * <td height="34">testDanglingLinkDuplicateElementInconsistencyLinkDelete()</td>
 * <td height="34">Dangling single storage link.</td>
 * <td height="34">Correction done by deleting the link.</td>
 * </tr>
 * <tr>
 * <td>&nbsp;</td>
 * <td>testLinkDeleteCorrectionLocking()</td>
 * <td>Dangling single storage link. Checks the locking when by trying
 * concurrent changes.</td>
 * <td>Correction done by deleting the link.</td>
 * </tr>
 * <tr>
 * <td>TestInconsistencyCorrectionWithUndo</td>
 * <td>testDanglingLinkDuplicateElementInconsistencyLinkDelete()</td>
 * <td>Dangling single storage link. Correction is done several times with
 * undo/redo.</td>
 * <td>Correction done by deleting the link.</td>
 * </tr>
 * <tr>
 * <td>&nbsp;</td>
 * <td><font color="#9CAECE">testDanglingLinkInconsistencyRecreateElement()</font></td>
 * <td><font color="#9CAECE">Dangling single storage link. </font></td>
 * <td><font color="#9CAECE">Correction done by recreating the missing element.</font></td>
 * </tr>
 * <tr>
 * <td>&nbsp;</td>
 * <td>&nbsp;</td>
 * <td>&nbsp;</td>
 * <td>&nbsp;</td>
 * </tr>
 * <tr>
 * <td>&nbsp;</td>
 * <td>&nbsp;</td>
 * <td>&nbsp;</td>
 * <td>&nbsp;</td>
 * </tr>
 * </table>
 * <h3>Duplicate element tests</h3>
 * <table border="1" width="100%" id="table2">
 * <tr>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Test case class</b></font></td>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Method</b></font></td>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Description</b></font></td>
 * <td bgcolor="#6699FF"><font color="#FFFFFF"><b>Correction</b></font></td>
 * </tr>
 * <tr>
 * <td>TestInconsistencyFixing</td>
 * <td>testDeletionDoubleStorageOneDuplicateElement()</td>
 * <td>Double storage composite link with one duplicate end.</td>
 * <td>Correction is done by deleting the partitions containing the duplicates.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">testDeletionDoubleStorageTwoDuplicateElement()</td>
 * <td height="23">Double storage composite link with both ends duplicated.</td>
 * <td height="23">Correction is done by deleting the partitions containing the
 * duplicates.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">testDoubleStorageDuplicateElementCompositeDeletion()</td>
 * <td height="23">Double storage composite link with two duplicate end. The
 * test checks if the right component is deleted when the parent is deleted. It
 * should be the one stored in the same partition.</td>
 * <td height="23">Correction is done by deleting the duplicate parent. The
 * components are automatically deleted also.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">testDoubleStorageOneDuplicateElementInconsistency()</td>
 * <td height="23">Double storage composite link with one duplicate end. This
 * test also tests the explicit consistency check using a second connection.</td>
 * <td height="23">Correction is done by deleting the partition containing the
 * duplicate elements.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">testSingleStorageDuplicateElementDifferentLinks()</td>
 * <td height="23">Single storage link with one duplicate end. The link is
 * stored at the duplicate end and points to different objects.</td>
 * <td height="23">Correction is done by deleting one of the duplicate
 * elements.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">testSingleStorageOneDuplicateElementInconsistency()</td>
 * <td height="23">Single storage link with one duplicate end. Simple test just
 * checking the events.</td>
 * <td height="23">Correction is done by deleting the duplicate element.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">
 * testSingleStorageOneDuplicateElementInconsistencyIntraPartition()</td>
 * <td height="23">Single storage link with one duplicate end. One of the
 * duplicate is in the same partition as the non-duplicate end. The duplicate
 * element in the same partition is deleted. The link is a cross-partition-link
 * afterwards.</td>
 * <td height="23">Correction is done by deleting the duplicate element.</td>
 * </tr>
 * <tr>
 * <td height="23">TestInconsistencyCorrectionHandles</td>
 * <td height="23">testDeletionDoubleStorageTwoDuplicateElement()</td>
 * <td height="23">Double storage composite link with two duplicate ends.</td>
 * <td height="23">Correction is done using the correction handle which deletes
 * the duplicate elements.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">testSingleStorageOneDuplicateElementUnknownInconsistency()</td>
 * <td height="23">Single storage end with one duplicate end. The duplicate
 * element violation is not visible at once.</td>
 * <td height="23">Correction is done using the element delete correction
 * handle</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">testDoubleStorageDuplicateElementCompositeDeletion()</td>
 * <td height="23">Double storage composite link with duplicate parent.</td>
 * <td height="23">Correction is done by deleting one parent using the
 * correction handle.</td>
 * </tr>
 * <tr>
 * <td height="23">TestInconsistencyCorrectionWithUndo</td>
 * <td height="23">testDeletionDoubleStorageTwoDuplicateElement()</td>
 * <td height="23">Double storage composite link with two duplicate ends. Same
 * as above with undo/redo.</td>
 * <td height="23">Correction is done using the correction handle which deletes
 * the duplicate elements.</td>
 * </tr>
 * <tr>
 * <td height="23">&nbsp;</td>
 * <td height="23">&nbsp;</td>
 * <td height="23">&nbsp;</td>
 * <td height="23">&nbsp;</td>
 * </tr>
 * </table>
 */
package com.sap.tc.moin.repository.test.inconsistency;