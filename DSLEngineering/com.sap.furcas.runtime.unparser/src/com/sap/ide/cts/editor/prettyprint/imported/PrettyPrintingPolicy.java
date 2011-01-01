package com.sap.ide.cts.editor.prettyprint.imported;

import java.util.List;

import com.sap.furcas.metamodel.FURCAS.TCS.Alternative;
import com.sap.furcas.metamodel.FURCAS.TCS.SequenceInAlternative;

/**
 * A simple interface that allows clients to participate in the pretty printing
 * process.
 * 
 * TODO: Not yet every place of the pretty printer is policy-enabled. Not every
 * hardcoded decision can already be overruled by a policy.
 * 
 * 
 * @author Stephan Erb (d049157)
 * 
 */
public interface PrettyPrintingPolicy {

    /**
     * The PrettyPrinter uses backtracking to print alternatives as usual.
     * However, it does this in the given order and no longer somewhat random.
     * 
     * @param alternative
     * @return
     */
    public List<SequenceInAlternative> getSequenceElementsOfCurrentAlternativeInPreferredOrder(Alternative alternative);

    /**
     * Allows to adapt the whitespace that is supposed to be printed.
     * 
     * If the policy returns an empty space though it is required to
     * disambiguate symbols then the policy will be gracefully ignored.
     * 
     * @param tcsImpliedWhiteSpace
     * @return
     */
    public String adaptWhiteSpace(String tcsImpliedWhiteSpace);

    public Boolean desiresAdditionalWhiteSpace();

}
