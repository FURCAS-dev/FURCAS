package com.sap.mi.gfw.eclipse.internal.util.gef;

import java.util.List;

import org.eclipse.gef.requests.CreationFactory;

import com.sap.mi.gfw.features.IFeature;

public class MultiCreationFactory implements CreationFactory {
	private List<IFeature> features;

	public MultiCreationFactory(List<IFeature> features) {
		this.features = features;
	}

	public Object getNewObject() {
		return features;
	}

	public Object getObjectType() {
		return null;
	}

}
