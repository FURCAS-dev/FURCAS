package com.sap.tc.moin.ocl.utils.localization;

import com.sap.tc.moin.repository.exception.MoinExternalizedString;
import com.sap.tc.moin.repository.localization.ExternalizedResourceBundleAccessor;


/**
 * <p>
 * <p>Externalized Messages in alphabetical order:
 * <ol>
 * <li>RegisterForNonExistingCategory_XMSG: Application tries to register a listener for the non-existing category: {0}, ignoring registration</li>
 * <li>StartParseBodyExpr_XMSG: Body expression for operation "{0}": starting to parse Expression: "{1}"</li>
 * <li>BuildingMapping_XMSG: Building the category/severity mapping for category "{0}"</li>
 * <li>CategoryNumConstraints_XMSG: Category: "{0}", number of constraints: {1}</li>
 * <li>StartParseExpr_XMSG: Constraint "{0}": starting to parse Expression: "{1}"</li>
 * <li>ConstraintIndexAndName_XMSG: Constraint {0}: {1}</li>
 * <li>AttachException_XMSG: Constraint: "{0}": could not attach the OCL expression "{1}" to its constraint</li>
 * <li>SerializationFailedForTrace_XMSG: Could not serialize the expression; it will not be written to the trace</li>
 * <li>ClassProxyNotFound_XMSG: Couldn&#039;&#039;t find class proxy for type {0}</li>
 * <li>HelperOpsCreationDur_XMSG: Creating helper operations took {0} milliseconds</li>
 * <li>EndCategoryEvaluation_XMSG: Evaluation completed for category {0}</li>
 * <li>EvtReceivedEvtCollListWrapper_XMSG: Event {0} received for EventCollectingListenerWrapper {1}</li>
 * <li>EvtReceivedImmediateWrapper_XMSG: Event {0} received for ImmediateListenerWrapper {1}</li>
 * <li>ViolationMessageExprException_XMSG: Exception during evaluation of the violation message expression</li>
 * <li>ExceptionListenerWrapper_XMSG: Exception when creating ListenerWraper for category {0}</li>
 * <li>ExceptionCreatingCatInvHandler_XMSG: Exception when creating the CategoryInvariantHandler for category {0}</li>
 * <li>ExprDoesNotEvaluateToBool_XMSG: Expression for constraint "{0}" does not evaluate to Boolean</li>
 * <li>InitMofWsRegDur_XMSG: Initialization of the MOF WorkspaceSetRegistry took {0} milliseconds</li>
 * <li>InitOclMMConstraintRegistryDur_XMSG: Initialization of the OclMetamodelConstraintRegistry took {0} milliseconds</li>
 * <li>IgnoringNullListener_XMSG: Listener is null and registration will be ignored</li>
 * <li>CouldNotParseMofConstraint_XMSG: MOF Constraint "{0}" could not be parsed, will be ignored</li>
 * <li>MofConstraintHelperNotParsed_XMSG: MOF Constraint Helper operation "{0}" could not be parsed, will be ignored</li>
 * <li>ConstraintHelperParseNonUnique_XMSG: MOF Constraint Helper operation "{0}" did not parse to exactly one expression, will be ignored</li>
 * <li>CompleteRefVerifyConstraints_XMSG: Method OclRegistryServiceImpl.refVerifyConstraints() completed, {0} violations found</li>
 * <li>CompleteVerifyConstraints_XMSG: Method OclRegistryServiceImpl.verifyConstraints() completed, status: {0} Errors and {1} Warnings</li>
 * <li>CompleteRegSrvVerifyConstraints_XMSG: Method verifyConstraints(Set&lt;PRI&gt, Set&lt;String&gt) completed after {0} nanoseconds, {1} violations were found</li>
 * <li>NoOclConstraintsFound_XMSG: No OCL Constraints found, returning</li>
 * <li>NoConstrainedElsFound_XMSG: No constrained elements for constraint "{0}"</li>
 * <li>NoListener_XMSG: No deferred listener for category {0}, skipping evaluation</li>
 * <li>NoInstancesFound_XMSG: No instances for classifier with MofID {0} or one one of its supertypes found</li>
 * <li>NoLanguageForOclConstraint_XMSG: No language was defined for OclConstraint {0}, the constraint will be ignored</li>
 * <li>NumConstraintsForCat_XMSG: Number of constraints for category "{0}": {1}</li>
 * <li>NumStmtsForCat_XMSG: Number of statements for category "{0}": {1}</li>
 * <li>ConstraintQueryResult_XMSG: OCL Constraint query returned {0} objects and took {1} milliseconds</li>
 * <li>StartQueryMMConstraintRegistry_XMSG: OclMetaModelConstraintWorkspaceSetRegistry&lt;init&gt: Starting constraint query for the OCLMetmodelConstraintRegistry, Connection {0}</li>
 * <li>OclServicEvalOclBody_XMSG: OclServiceImpl.evaluateOclBodyExpression(): Operation name "{0}", context "{1}"</li>
 * <li>OclServiceEvalOclBodyRes_XMSG: OclServiceImpl.evaluateOclBodyExpression(): result "{0}"</li>
 * <li>ParseMofDuratin_XMSG: Parsing of {0} MOIN/MOF Constraints took {1} milliseconds</li>
 * <li>RegisterEvtCollectingWrapper_XMSG: Registering EventCollectingListenerWrapper: {0} with event filter: {1}</li>
 * <li>RegisterListenerOfType_XMSG: Registering a Listener of type "{0}" for category "{1}", listener: {2}</li>
 * <li>EvalResult_XMSG: Result of the evaluation: {0}</li>
 * <li>RtExGetInstMofConstraintChecks_XMSG: RuntimeException getting the instances for MOF Constraint checks</li>
 * <li>SerializedExpression_XMSG: Serialized Expression: "{0}"</li>
 * <li>StartCategoryEvaluation_XMSG: Starting category evaluation for category {0} and {1} partitions</li>
 * <li>StartRefVerifyConstraints_XMSG: Starting method OclRegistryServiceImpl.refVerifyConstraints() for ModelElement {0} </li>
 * <li>StartVerifyConstraints_XMSG: Starting method OclRegistryServiceImpl.verifyConstraints() for ModelElement {0}</li>
 * <li>StartRegSrvVerifyConstraints_XMSG: Starting method verifyConstraints(Set&lt;PRI&gt, Set&lt;Category&gt) for {0} partitions and {1} categories</li>
 * <li>SuccessParse_XMSG: Successfully parsed constraint "{0}", context "{1}", expression "{2}"</li>
 * <li>ReusingMapping_XMSG: The category/severity mapping was already created for category "{0}", re-using it</li>
 * <li>ConstraintRegistryIsEmpty_XMSG: The constraint registry is empty</li>
 * <li>UnexpectedExMultipChecks_XMSG: Unexpected Exception while checking Multiplicity Constraints for Object {0}</li>
 * <li>ExceptionEvalMMPartitions_XMSG: Unexpected Exception while evaluating Metamodel Partition for object: {0}</li>
 * <li>VerifyingMMC_XMSG: Verifying MOIN/MOF constraint "{0}" for ModelElement "{1}"</li>
 * </ol>
 * <p>
 * <p>Message Constants generated from OclServiceTraces.properties
 */
 
public enum OclServiceTraces implements MoinExternalizedString {


    /**
     * Message: "Constraint: "{0}": could not attach the OCL expression "{1}" to its constraint"
     */
    ATTACHEXCEPTION("AttachException_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Building the category/severity mapping for category "{0}""
     */
    BUILDINGMAPPING("BuildingMapping_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Category: "{0}", number of constraints: {1}"
     */
    CATEGORYNUMCONSTRAINTS("CategoryNumConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Couldn&#039;&#039;t find class proxy for type {0}"
     */
    CLASSPROXYNOTFOUND("ClassProxyNotFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method OclRegistryServiceImpl.refVerifyConstraints() completed, {0} violations found"
     */
    COMPLETEREFVERIFYCONSTRAINTS("CompleteRefVerifyConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method verifyConstraints(Set&lt;PRI&gt, Set&lt;String&gt) completed after {0} nanoseconds, {1} violations were found"
     */
    COMPLETEREGSRVVERIFYCONSTRAINTS("CompleteRegSrvVerifyConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Method OclRegistryServiceImpl.verifyConstraints() completed, status: {0} Errors and {1} Warnings"
     */
    COMPLETEVERIFYCONSTRAINTS("CompleteVerifyConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOF Constraint Helper operation "{0}" did not parse to exactly one expression, will be ignored"
     */
    CONSTRAINTHELPERPARSENONUNIQUE("ConstraintHelperParseNonUnique_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraint {0}: {1}"
     */
    CONSTRAINTINDEXANDNAME("ConstraintIndexAndName_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OCL Constraint query returned {0} objects and took {1} milliseconds"
     */
    CONSTRAINTQUERYRESULT("ConstraintQueryResult_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The constraint registry is empty"
     */
    CONSTRAINTREGISTRYISEMPTY("ConstraintRegistryIsEmpty_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOF Constraint "{0}" could not be parsed, will be ignored"
     */
    COULDNOTPARSEMOFCONSTRAINT("CouldNotParseMofConstraint_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Evaluation completed for category {0}"
     */
    ENDCATEGORYEVALUATION("EndCategoryEvaluation_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Result of the evaluation: {0}"
     */
    EVALRESULT("EvalResult_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Event {0} received for EventCollectingListenerWrapper {1}"
     */
    EVTRECEIVEDEVTCOLLLISTWRAPPER("EvtReceivedEvtCollListWrapper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Event {0} received for ImmediateListenerWrapper {1}"
     */
    EVTRECEIVEDIMMEDIATEWRAPPER("EvtReceivedImmediateWrapper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception when creating the CategoryInvariantHandler for category {0}"
     */
    EXCEPTIONCREATINGCATINVHANDLER("ExceptionCreatingCatInvHandler_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected Exception while evaluating Metamodel Partition for object: {0}"
     */
    EXCEPTIONEVALMMPARTITIONS("ExceptionEvalMMPartitions_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception when creating ListenerWraper for category {0}"
     */
    EXCEPTIONLISTENERWRAPPER("ExceptionListenerWrapper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Expression for constraint "{0}" does not evaluate to Boolean"
     */
    EXPRDOESNOTEVALUATETOBOOL("ExprDoesNotEvaluateToBool_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Creating helper operations took {0} milliseconds"
     */
    HELPEROPSCREATIONDUR("HelperOpsCreationDur_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Listener is null and registration will be ignored"
     */
    IGNORINGNULLLISTENER("IgnoringNullListener_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Initialization of the MOF WorkspaceSetRegistry took {0} milliseconds"
     */
    INITMOFWSREGDUR("InitMofWsRegDur_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Initialization of the OclMetamodelConstraintRegistry took {0} milliseconds"
     */
    INITOCLMMCONSTRAINTREGISTRYDUR("InitOclMMConstraintRegistryDur_XMSG"), //$NON-NLS-1$

    /**
     * Message: "MOF Constraint Helper operation "{0}" could not be parsed, will be ignored"
     */
    MOFCONSTRAINTHELPERNOTPARSED("MofConstraintHelperNotParsed_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No constrained elements for constraint "{0}""
     */
    NOCONSTRAINEDELSFOUND("NoConstrainedElsFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No instances for classifier with MofID {0} or one one of its supertypes found"
     */
    NOINSTANCESFOUND("NoInstancesFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No language was defined for OclConstraint {0}, the constraint will be ignored"
     */
    NOLANGUAGEFOROCLCONSTRAINT("NoLanguageForOclConstraint_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No deferred listener for category {0}, skipping evaluation"
     */
    NOLISTENER("NoListener_XMSG"), //$NON-NLS-1$

    /**
     * Message: "No OCL Constraints found, returning"
     */
    NOOCLCONSTRAINTSFOUND("NoOclConstraintsFound_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Number of constraints for category "{0}": {1}"
     */
    NUMCONSTRAINTSFORCAT("NumConstraintsForCat_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Number of statements for category "{0}": {1}"
     */
    NUMSTMTSFORCAT("NumStmtsForCat_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OclServiceImpl.evaluateOclBodyExpression(): Operation name "{0}", context "{1}""
     */
    OCLSERVICEVALOCLBODY("OclServicEvalOclBody_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OclServiceImpl.evaluateOclBodyExpression(): result "{0}""
     */
    OCLSERVICEEVALOCLBODYRES("OclServiceEvalOclBodyRes_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Parsing of {0} MOIN/MOF Constraints took {1} milliseconds"
     */
    PARSEMOFDURATIN("ParseMofDuratin_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registering EventCollectingListenerWrapper: {0} with event filter: {1}"
     */
    REGISTEREVTCOLLECTINGWRAPPER("RegisterEvtCollectingWrapper_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Application tries to register a listener for the non-existing category: {0}, ignoring registration"
     */
    REGISTERFORNONEXISTINGCATEGORY("RegisterForNonExistingCategory_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Registering a Listener of type "{0}" for category "{1}", listener: {2}"
     */
    REGISTERLISTENEROFTYPE("RegisterListenerOfType_XMSG"), //$NON-NLS-1$

    /**
     * Message: "The category/severity mapping was already created for category "{0}", re-using it"
     */
    REUSINGMAPPING("ReusingMapping_XMSG"), //$NON-NLS-1$

    /**
     * Message: "RuntimeException getting the instances for MOF Constraint checks"
     */
    RTEXGETINSTMOFCONSTRAINTCHECKS("RtExGetInstMofConstraintChecks_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Could not serialize the expression; it will not be written to the trace"
     */
    SERIALIZATIONFAILEDFORTRACE("SerializationFailedForTrace_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Serialized Expression: "{0}""
     */
    SERIALIZEDEXPRESSION("SerializedExpression_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Starting category evaluation for category {0} and {1} partitions"
     */
    STARTCATEGORYEVALUATION("StartCategoryEvaluation_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Body expression for operation "{0}": starting to parse Expression: "{1}""
     */
    STARTPARSEBODYEXPR("StartParseBodyExpr_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Constraint "{0}": starting to parse Expression: "{1}""
     */
    STARTPARSEEXPR("StartParseExpr_XMSG"), //$NON-NLS-1$

    /**
     * Message: "OclMetaModelConstraintWorkspaceSetRegistry&lt;init&gt: Starting constraint query for the OCLMetmodelConstraintRegistry, Connection {0}"
     */
    STARTQUERYMMCONSTRAINTREGISTRY("StartQueryMMConstraintRegistry_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Starting method OclRegistryServiceImpl.refVerifyConstraints() for ModelElement {0} "
     */
    STARTREFVERIFYCONSTRAINTS("StartRefVerifyConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Starting method verifyConstraints(Set&lt;PRI&gt, Set&lt;Category&gt) for {0} partitions and {1} categories"
     */
    STARTREGSRVVERIFYCONSTRAINTS("StartRegSrvVerifyConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Starting method OclRegistryServiceImpl.verifyConstraints() for ModelElement {0}"
     */
    STARTVERIFYCONSTRAINTS("StartVerifyConstraints_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Successfully parsed constraint "{0}", context "{1}", expression "{2}""
     */
    SUCCESSPARSE("SuccessParse_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Unexpected Exception while checking Multiplicity Constraints for Object {0}"
     */
    UNEXPECTEDEXMULTIPCHECKS("UnexpectedExMultipChecks_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Verifying MOIN/MOF constraint "{0}" for ModelElement "{1}""
     */
    VERIFYINGMMC("VerifyingMMC_XMSG"), //$NON-NLS-1$

    /**
     * Message: "Exception during evaluation of the violation message expression"
     */
    VIOLATIONMESSAGEEXPREXCEPTION("ViolationMessageExprException_XMSG"); //$NON-NLS-1$

    private final static ExternalizedResourceBundleAccessor ACCESSOR = new ExternalizedResourceBundleAccessor( OclServiceTraces.class );

    private final String myKey;

    private OclServiceTraces( String bundleKey ) {

        this.myKey = bundleKey;
    }

    public String format( Object... args ) {

        return ACCESSOR.format( this.myKey, args );

    }

}  