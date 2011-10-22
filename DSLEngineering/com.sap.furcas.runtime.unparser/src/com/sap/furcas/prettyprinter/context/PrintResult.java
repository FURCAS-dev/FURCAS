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
package com.sap.furcas.prettyprinter.context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import com.sap.furcas.metamodel.FURCAS.TCS.SequenceElement;
import com.sap.furcas.metamodel.FURCAS.textblocks.DocumentNode;
import com.sap.furcas.metamodel.FURCAS.textblocks.TextBlock;
import com.sap.furcas.prettyprinter.Formatter.FormatRequest;
import com.sap.furcas.prettyprinter.PrettyPrinter;
import com.sap.furcas.prettyprinter.TextBlocksFactory;

/**
 * The {@link PrettyPrinter} encapsulates the result of its recursive serialization method calls
 * in form of {@link PrintResult}s.
 * 
 * The final result of the pretty printing progress is yield by the combination of all performed
 * recurisve methods calls. {@link PrintResult}s can therefore be merged 
 * (see {@link ResultContainer#merge(PrintResult)}).
 *  
 * @author Stephan Erb
 *
 */
public abstract class PrintResult {
    
    
    protected final List<DocumentNode> nodes;
    
    protected boolean syntacticContribution;
    protected List<FormatRequest> formatRequests;
    
    
    public PrintResult(List<DocumentNode> nodes, List<FormatRequest> formatRequests) {
        this.nodes = nodes;
        this.formatRequests = formatRequests;
    }

    public boolean hasSyntacticContribution() {
        return syntacticContribution;
    }
    
    public boolean hasSyntacticContribution(boolean contribution) {
        return syntacticContribution = contribution;
    }
    
    /**
     * Add formatting (e.g., leading spaced, indentation) applicable for the next
     * element to be printed, following this result object.  
     */
    public void appendFormatRequest(FormatRequest request) {
        formatRequests.add(request);
    }

    /**
     * Add formatting (e.g., leading spaced, indentation) applicable for the next
     * element to be printed, following this result object.  
     */
    public void appendFormatRequests(Collection<FormatRequest> requests) {
        formatRequests.addAll(requests);
    }
    
    public void removeFormatRequests(Collection<FormatRequest> requests) {
        formatRequests.removeAll(requests);
    }
    
    public List<DocumentNode> getNodes() {
        return nodes;
    }
    
    /**
     * Used if a serialization method did not produce any result. 
     */
    public static class NullResult extends PrintResult {
        
        public NullResult() {
            super(Collections.<DocumentNode>emptyList(), Collections.<FormatRequest>emptyList());
            syntacticContribution = false;
        }
        
        @Override
        public boolean hasSyntacticContribution() {
            return false;
        }
    }
    
    
    /**
     * Used if a serialization method produced a result.
     */
    public static class LeafResult extends PrintResult {
        
        public LeafResult(List<DocumentNode> nodes) {
            super(nodes, new ArrayList<FormatRequest>());
            syntacticContribution = true;
        }
        
        public LeafResult(TextBlock node, List<FormatRequest> formatRequests, boolean syntacticContribution) {
            super(Collections.<DocumentNode>singletonList(node), formatRequests);
            this.syntacticContribution = syntacticContribution;
        }
    }
    
    /**
     * Used if several sub-result shall be combined/merged into a single result.
     */
    public static class ResultContainer extends PrintResult {
        
        private final List<Integer> chosenAlternatives = new ArrayList<Integer>();
        private Collection<FormatRequest> formattingBetweenElements = new ArrayList<FormatRequest>();
        
        private int indentationLevelIncrement = 0;
        private int alternativeNestingLevelIncrement = 0;
        private int alternativesNestingLevel = 0;
        
        public ResultContainer(List<FormatRequest> formatRequests) {
            super(new ArrayList<DocumentNode>(), formatRequests);
            syntacticContribution = false;
        }
        
        public void merge(PrintResult subResult) {
            if (subResult.hasSyntacticContribution()) {
                syntacticContribution = true;
                nodes.addAll(subResult.nodes);
                formatRequests = subResult.formatRequests;
            }
            if (subResult instanceof ResultContainer) {
                ResultContainer subContainer = (ResultContainer) subResult;
                if (subContainer.chosenAlternatives != null) {
                    chosenAlternatives.addAll(subContainer.chosenAlternatives);
                }
            }
        }
        
        /**
         * @param seqElem  
         */
        public void mergeChosenAlternative(SequenceElement seqElem, int choice, PrintResult subResult) {
            alternativesNestingLevel++;
            chosenAlternatives.add(-alternativesNestingLevel); // marker to indicate nesting
            chosenAlternatives.add(choice);
            merge(subResult);
            chosenAlternatives.add(-alternativesNestingLevel); // marker to indicate nesting
            alternativesNestingLevel--;
        }
        
        public List<Integer> getChosenAlternatives() {
            return chosenAlternatives;
        }
        
        public void configureIndentationLevelIncrement(int i) {
            this.indentationLevelIncrement = i;
        }

        public void configureFormattingBetweenBlockElements(Collection<FormatRequest> requests) {
            this.formattingBetweenElements = requests;
        }

        public void configureAlternativeNestingLevel(int i, PrintContext context) {
            this.alternativeNestingLevelIncrement = i;
            this.alternativesNestingLevel = context.getAlternativeNestingLevel();
        }
                        
        /**
         * Create a {@link PrintContext} representing everything that has been pretty printed so far.
         * This encompasses all information encapusalted in the given context together
         * with all sub-results that have been printed and merged into this result object.
         */
        public PrintContext asSubContext(final PrintContext context) {
            return new PrintContext() {
                @Override
                public int getPriority() {
                    return context.getPriority();
                }
                @Override
                public List<FormatRequest> getPendingFormattingRequest() {
                    return formatRequests;
                }
                @Override
                public int getNextOffset() {
                    return TextBlocksFactory.getLengthOf(getNodes(), context.getNextOffset());
                }
                @Override
                public int getIndenationLevel() {
                    return context.getIndenationLevel() + indentationLevelIncrement;
                }
                @Override
                public EObject getContextElementMatchingTag(String tag) {
                    return context.getContextElementMatchingTag(tag);
                }
                @Override
                public Collection<FormatRequest> getBlockFormattingBetweenElements() {
                    return formattingBetweenElements;
                }
                @Override
                public int getAlternativeNestingLevel() {
                    return context.getAlternativeNestingLevel() + alternativeNestingLevelIncrement;
                }
            };
        }

    }

}