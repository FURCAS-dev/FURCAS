package com.sap.tc.moin.repository.core.ocl.editorutils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.sap.tc.moin.friends.ocl.editor.IOclProposal;
import com.sap.tc.moin.repository.exception.MoinLocalizedString;


/**
 * The IOclProposal implementation
 */
public class OCLProposalImpl implements IOclProposal {

    static final String REP_CONTEXT = "context"; //$NON-NLS-1$

    static final String REP_PACKAGE = "package"; //$NON-NLS-1$

    static final String REP_TUPLE = "Tuple()"; //$NON-NLS-1$

    static final String REP_VARASSIGN = "varAssign"; //$NON-NLS-1$

    static final String REP_VARDECL = "varDecl"; //$NON-NLS-1$

    static final String REP_LET = "let"; //$NON-NLS-1$

    static final String REP_IF = "if"; //$NON-NLS-1$

    static final String REP_ONEVARTYPEITER = "oneVarTypeIter"; //$NON-NLS-1$

    static final String REP_ONEVARITER = "oneVarIter"; //$NON-NLS-1$

    static final String REP_TWOVARTYPEITER = "twoVarTypeIter"; //$NON-NLS-1$

    static final String REP_TWOVARITER = "twoVarIter"; //$NON-NLS-1$

    static final String REP_ITERATECONTENT = "iterateContent"; //$NON-NLS-1$

    /** standard priority */
    public static final int STANDARDPRIORITY = 5;

    private String proposalString;

    private MoinLocalizedString localizedProposal;

    private Object[] proposalArgs;

    private String replacement;

    private String additionalInfo;

    private MoinLocalizedString localizedAdditionalInfo;

    private TYPE type;

    private int offset;

    private int delLength;

    private int priority;

    private List<String> params = new ArrayList<String>( 0 );

    private List<String> delimiters = new ArrayList<String>( 0 );

    /**
     * @param proposal proposal
     * @param args arguments
     * @param actReplacement replacement
     * @param info information
     * @param actOffset offset
     * @param actLength length
     * @param actType type
     * @param actPrio priority
     */
    public OCLProposalImpl( MoinLocalizedString proposal, Object[] args, String actReplacement, String info, int actOffset, int actLength, TYPE actType, int actPrio ) {

        this.localizedProposal = proposal;
        this.proposalArgs = args;
        this.replacement = actReplacement;
        this.offset = actOffset;
        this.delLength = actLength;
        this.type = actType;
    }


    /**
     * @param actProposal proposal
     * @param actReplacement replacement
     * @param actOffset offset
     * @param actLength length
     * @param actType type
     * @param actPriority priority
     */
    public OCLProposalImpl( MoinLocalizedString actProposal, String actReplacement, int actOffset, int actLength, TYPE actType, int actPriority ) {

        this.localizedProposal = actProposal;
        this.proposalArgs = null;
        this.replacement = actReplacement;
        this.offset = actOffset;
        this.delLength = actLength;
        this.type = actType;
        this.priority = actPriority;
    }

    /**
     * Used for iterator expression
     * <p>
     * Only the additional info is localized
     * 
     * @param actProposalString proposal
     * @param actReplacement replacement
     * @param actAdditionalInfo info
     * @param actOffset offset
     * @param actLength length
     * @param actType type
     * @param actParams parameters
     * @param actDelimiters delimiters
     */
    public OCLProposalImpl( String actProposalString, String actReplacement, MoinLocalizedString actAdditionalInfo, int actOffset, int actLength, TYPE actType, List<String> actParams, List<String> actDelimiters ) {

        this.proposalString = actProposalString;
        this.replacement = actReplacement;
        this.localizedAdditionalInfo = actAdditionalInfo;
        this.offset = actOffset;
        this.delLength = actLength;
        this.type = actType;
        this.priority = STANDARDPRIORITY;
        if ( actParams != null ) {
            this.params = actParams;
        }
        if ( actDelimiters != null ) {
            this.delimiters = actDelimiters;
        }
    }

    /**
     * @param actProposalString proposal
     * @param actReplacement replacement
     * @param actAdditionalInfo info
     * @param actOffset offset
     * @param actLength length
     * @param actType type
     * @param actPrio priority
     * @param actParams parameters
     * @param actDelimiters delimiters
     */
    public OCLProposalImpl( String actProposalString, String actReplacement, MoinLocalizedString actAdditionalInfo, int actOffset, int actLength, TYPE actType, int actPrio, List<String> actParams, List<String> actDelimiters ) {

        this.proposalString = actProposalString;
        this.replacement = actReplacement;
        this.localizedAdditionalInfo = actAdditionalInfo;
        this.offset = actOffset;
        this.delLength = actLength;
        this.type = actType;
        this.priority = actPrio;
        if ( actParams != null ) {
            this.params = actParams;
        }
        if ( actDelimiters != null ) {
            this.delimiters = actDelimiters;
        }
    }

    /**
     * @param actProposalString proposal
     * @param actReplacement replacement
     * @param actAdditionalInfo info
     * @param actOffset offset
     * @param actLength length
     * @param actType type
     * @param actPriority priority
     * @param actParams parameters
     * @param actDelimiters delimiters
     */
    public OCLProposalImpl( String actProposalString, String actReplacement, String actAdditionalInfo, int actOffset, int actLength, TYPE actType, int actPriority, List<String> actParams, List<String> actDelimiters ) {

        this.proposalString = actProposalString;
        this.replacement = actReplacement;
        this.additionalInfo = actAdditionalInfo;
        this.offset = actOffset;
        this.delLength = actLength;
        this.type = actType;
        this.priority = actPriority;
        if ( actParams != null ) {
            this.params = actParams;
        }
        if ( actDelimiters != null ) {
            this.delimiters = actDelimiters;
        }
    }

    /**
     * @param actProposal proposal
     * @param actArgs arguments
     * @param actReplacement replacement
     * @param actAdditionalInfo info
     * @param actOffset offset
     * @param actLength length
     * @param actType type
     * @param actPriority priority
     * @param actParams parameters
     * @param actDelimiters delimiters
     */
    public OCLProposalImpl( MoinLocalizedString actProposal, Object[] actArgs, String actReplacement, String actAdditionalInfo, int actOffset, int actLength, TYPE actType, int actPriority, List<String> actParams, List<String> actDelimiters ) {

        this.localizedProposal = actProposal;
        this.proposalArgs = actArgs;
        this.replacement = actReplacement;
        this.additionalInfo = actAdditionalInfo;
        this.offset = actOffset;
        this.delLength = actLength;
        this.type = actType;
        this.priority = actPriority;
        if ( actParams != null ) {
            this.params = actParams;
        }
        if ( actDelimiters != null ) {
            this.delimiters = actDelimiters;
        }
    }

    public TYPE getType( ) {

        return this.type;
    }


    public String getProposalString( Locale locale ) {

        if ( this.localizedProposal != null ) {
            String pattern = this.localizedProposal.getLocalizedMessage( locale );
            if ( this.proposalArgs != null && this.proposalArgs.length > 0 ) {
                MessageFormat format = new MessageFormat( pattern, locale );
                return format.format( this.proposalArgs );
            }
            return pattern;
        }
        return this.proposalString;
    }


    public int getDelLength( ) {

        return this.delLength;
    }

    public int getOffset( ) {

        return this.offset;
    }

    public String getReplacement( ) {

        return this.replacement;
    }

    public int compareTo( IOclProposal o ) {

        if ( this.priority > o.getPriority( ) )
            return 1;
        if ( this.priority < o.getPriority( ) )
            return -1;
        return this.getProposalString( Locale.ENGLISH ).compareTo( o.getProposalString( Locale.ENGLISH ) );

    }

    public List<String> getDelimiters( ) {

        return this.delimiters;
    }

    public List<String> getParams( ) {

        return this.params;
    }

    public int getPriority( ) {

        return this.priority;
    }

    public String getAdditionalinfo( Locale locale ) {

        if ( this.localizedAdditionalInfo != null ) {
            return this.localizedAdditionalInfo.getLocalizedMessage( locale );
        }
        return this.additionalInfo;
    }

}
