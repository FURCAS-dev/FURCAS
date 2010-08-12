package com.sap.ide.refactoring.ui;

import org.eclipse.ltk.core.refactoring.RefactoringStatusContext;

import com.sap.ide.refactoring.core.reference.ReEvaluationInfo;


public class ReEvaluationStatusContext extends RefactoringStatusContext {

    private final ReEvaluationInfo reEvaluationInfo;

    public ReEvaluationStatusContext(ReEvaluationInfo reEvaluationInfo) {
	this.reEvaluationInfo = reEvaluationInfo;
    }

    @Override
    public Object getCorrespondingElement() {
	return reEvaluationInfo;
    }

}
