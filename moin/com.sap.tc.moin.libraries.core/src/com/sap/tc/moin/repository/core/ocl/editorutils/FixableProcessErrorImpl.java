package com.sap.tc.moin.repository.core.ocl.editorutils;

import com.sap.tc.moin.friends.ocl.editor.FixableProcessError;
import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.repository.ProcessError;
import com.sap.tc.moin.repository.shared.util.ProcessErrorImpl;


/**
 * In addition to a normal process report, this contains some OCL proposals that
 * can be used to fix the expression
 */
public class FixableProcessErrorImpl extends ProcessErrorImpl implements FixableProcessError {

    private static final long serialVersionUID = 1L;

    private transient IOclProposal[] fixes;

    /**
     * @param error error
     * @param actFixes fix proposals
     */
    public FixableProcessErrorImpl( ProcessError error, IOclProposal[] actFixes ) {

        this( error.getRootCause( ), error.getStartLine( ), error.getStartColumn( ), error.getEndLine( ), error.getEndColumn( ), error.getStartPosition( ), error.getEndPosition( ), actFixes );

    }


    private FixableProcessErrorImpl( Exception e, int startLine, int startColumn, int endLine, int endColumn, int startPosition, int endPosition, IOclProposal[] actFixes ) {

        super( e, startLine, startColumn, endLine, endColumn, startPosition, endPosition );
        this.fixes = actFixes;
    }


    /**
     * @return the fixes; note that this will return null after going over the
     * wire
     */
    public IOclProposal[] getFixes( ) {

        return this.fixes;
    }

}
