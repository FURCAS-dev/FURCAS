/*******************************************************************************
 * Copyright (c) 2011 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     SAP AG - initial API and implementation
 ******************************************************************************/
package com.sap.furcas.runtime.tcs;

import com.sap.furcas.metamodel.FURCAS.TCS.Block;
import com.sap.furcas.metamodel.FURCAS.TCS.BlockArg;
import com.sap.furcas.metamodel.FURCAS.TCS.EndNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.IndentIncrBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.NbNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNLBArg;
import com.sap.furcas.metamodel.FURCAS.TCS.StartNbNLBArg;

/**
 * Util methods dealing with arguments for {@link Block Blocks}. These control
 * the formatting applied by the pretty printer when it serializes a model.
 */
public class BlockArgumentUtil {

    public static NbNLBArg getNbNLBArg(Block block) {
        for (BlockArg arg : block.getBlockArgs()) {
            if (arg instanceof NbNLBArg) {
                return (NbNLBArg) arg;
            }
        }
        return null;
    }
    
    public static StartNbNLBArg getStartNbNLBArg(Block block) {
        for (BlockArg arg : block.getBlockArgs()) {
            if (arg instanceof StartNbNLBArg) {
                return (StartNbNLBArg) arg;
            }
        }
        return null;
    }
    
    public static IndentIncrBArg getIndentIncrBArg(Block block) {
        for (BlockArg arg : block.getBlockArgs()) {
            if (arg instanceof IndentIncrBArg) {
                return (IndentIncrBArg) arg;
            }
        }
        return null;
    }
    
    public static StartNLBArg getStartNLBArg(Block block) {
        for (BlockArg arg : block.getBlockArgs()) {
            if (arg instanceof StartNLBArg) {
                return (StartNLBArg) arg;
            }
        }
        return null;
    }
    
    public static EndNLBArg getEndNLBArg(Block block) {
        for (BlockArg arg : block.getBlockArgs()) {
            if (arg instanceof EndNLBArg) {
                return (EndNLBArg) arg;
            }
        }
        return null;
    }
    
}
