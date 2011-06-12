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
package com.sap.furcas.ide.editor.contentassist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.jface.text.contentassist.ICompletionProposal;


public class CompletionProposalHelper {

    private static class CompletionProposalsComparator implements Comparator<ICompletionProposal> {

        /**
         * proposals that start with the prefix come first
         */
        private final String prefix;

        public CompletionProposalsComparator(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public int compare(ICompletionProposal a, ICompletionProposal b) {
            boolean aTop = a.getDisplayString().startsWith(prefix);
            boolean bTop = b.getDisplayString().startsWith(prefix);

            if (aTop && bTop) {
                return a.getDisplayString().compareTo(b.getDisplayString());
            }

            if (aTop) {
                return -1;
            }

            if (bTop) {
                return 1;
            }

            // !aTop and !bTop
            return a.getDisplayString().compareTo(b.getDisplayString());
        }
    };
    
    public static boolean containsDisplayString(List<ICompletionProposal> proposals, String displayString) {
        for (ICompletionProposal p : proposals) {
            if (p.getDisplayString().equals(displayString)) {
                return true;
            }
        }
    
        return false;
    }

    public static List<ICompletionProposal> removeDuplicates(List<ICompletionProposal> input) {
    
        if (input == null) {
            return null;
        }
    
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
    
        for (ICompletionProposal proposal : input) {
            if (!containsDisplayString(results, proposal.getDisplayString())) {
                results.add(proposal);
            }
        }
    
        return results;
    }

    public static List<ICompletionProposal> removeNullValues(List<ICompletionProposal> input) {
        if (input == null) {
            return null;
        }
    
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
    
        for (ICompletionProposal proposal : input) {
            if (proposal != null) {
                results.add(proposal);
            }
        }
    
        return results;
    }

    public static List<ICompletionProposal> sortProposals(List<ICompletionProposal> input, String prefix) {
        if (input == null) {
            return null;
        }
    
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>(input);
    
        Collections.sort(results, new CompletionProposalsComparator(prefix));
    
        return results;
    
    }

    public static List<ICompletionProposal> prefixFilter(List<ICompletionProposal> input, String prefix) {
    
        List<ICompletionProposal> results = new ArrayList<ICompletionProposal>();
        for (ICompletionProposal proposal : input) {
            if (proposal.getDisplayString().startsWith(prefix)) {
                results.add(proposal);
            }
        }
    
        return results;
    }

    public static ICompletionProposal[] proposalListAsArray(List<ICompletionProposal> proposalList) {
        if (proposalList == null) {
            return null;
        }
        return proposalList.toArray(new ICompletionProposal[proposalList.size()]);
    }

}
