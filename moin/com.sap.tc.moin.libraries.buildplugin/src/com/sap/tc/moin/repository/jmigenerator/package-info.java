/**
 * The Moin JMI Generator.
 * <p>
 * The Moin JMI Generator is used to convert the JMI classes out of the Moin
 * meta models. In order to do so, an instance of the Generator must be
 * obtained. Since the constructor does not accept any parameters, this is
 * trivial. In the next step, a list of {@link JmiGeneratorModelElementWrapper}s
 * is created.
 * <p>
 * There are two methods for this purpose:
 * {@link JmiGenerator#createObjectList(java.util.Set)} that takes as argument a
 * Set of {@link ModelPartition}s or
 * {@link JmiGenerator#createObjectTree(java.util.Set)} that requires a Set of
 * (top-level) {@link MofPackage}s. The first one simply returns a List of
 * JmiGeneratorWrappers, whereas the latter returns a hierarchy representing the
 * containment hierarchy of the packages provided. Since the wrapper extends
 * TreeNode, this hierarchy can be easily visualized which might be useful for
 * debugging or such.
 * <p>
 * The actual code generation is done for each wrapper by executing
 * {@link JmiGeneratorModelElementWrapper#createCode(JmiGenerationKind[])} where
 * the parameter represents a filter. The result of this is a List of
 * {@link JmiGeneratorPathCodePair} which may be empty (for example, nothing
 * would be generated for a MofException and {@link JmiGenerationKind#CLASS}).
 * <p>
 * The {@link JmiGeneratorPathCodePair} represents a tuple of File information
 * (relative path and file name/extension) and a String representing the file
 * content. This information can be used to create the files on the file system.
 */

package com.sap.tc.moin.repository.jmigenerator;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerator;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorModelElementWrapper;
import com.sap.tc.moin.repository.jmigenerator.JmiGeneratorPathCodePair;

