package com.sap.ide.refactoring.core.execution.participation;

import com.sap.ide.refactoring.core.reference.ReEvaluationInfo;

public class ReferenceReEvalContributionInfo extends ContributionInfo {

    public final ReEvaluationInfo reEvalInfo;

    public ReferenceReEvalContributionInfo(ReEvaluationInfo reEvalInfo) {
	super(reEvalInfo.asRefactoringStatus());
	this.reEvalInfo = reEvalInfo;
    }

}
