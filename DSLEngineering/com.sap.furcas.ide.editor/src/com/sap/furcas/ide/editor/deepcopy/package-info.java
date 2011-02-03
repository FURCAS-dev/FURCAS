/**
 * Classes related to deep copying of model elements.
 * 
 * While {@link com.sap.tc.moin.repository.Connection#deepCopy(java.util.Collection, com.sap.tc.moin.repository.DeepCopyPolicyHandler, boolean)} 
 * implements the basic algorithm, this package provides a generic {@link com.sap.tc.moin.repository.DeepCopyPolicyHandler}
 * with several heuristics to make the implementation of model specific handlers as easy
 * as possible.
 *  
 * @author D049157
 */
package com.sap.furcas.ide.editor.deepcopy;