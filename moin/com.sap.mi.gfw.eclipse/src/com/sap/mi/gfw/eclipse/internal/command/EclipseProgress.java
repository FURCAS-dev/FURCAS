package com.sap.mi.gfw.eclipse.internal.command;

import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.mi.gfw.features.IProgress;

public class EclipseProgress implements IProgress {
	private IProgressMonitor eclipseProgressMonitor;

	public EclipseProgress(IProgressMonitor eclipseProgressMonitor, int total) {
		super();

		setEclipseProgressMonitor(eclipseProgressMonitor);

		eclipseProgressMonitor.beginTask(getClass().getName(), total);
	}

	public void addProgress(int work) {
		getEclipseProgressMonitor().worked(work);
	}

	private IProgressMonitor getEclipseProgressMonitor() {
		return eclipseProgressMonitor;
	}

	private void setEclipseProgressMonitor(IProgressMonitor eclipseProgressMonitor) {
		this.eclipseProgressMonitor = eclipseProgressMonitor;
	}
}
