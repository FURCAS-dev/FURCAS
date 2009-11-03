package com.sap.mi.tools.diagnostics.internal.model;

import java.util.ArrayList;
import java.util.List;

import com.sap.mi.fwk.ui.mbeans.EditorRegistryEntryMBean;
import com.sap.mi.fwk.ui.mbeans.EditorRegistryMBean;
import com.sap.mi.tools.diagnostics.internal.MoinJmxClient;
import com.sap.mi.tools.diagnostics.internal.messages.DiagnosticsMessages;

/**
 * The editor registry
 * 
 * @author d024127
 */
public class EditorRegistryNode extends DelegateNode {

	EditorRegistryMBean bean;

	public EditorRegistryNode(MoinJmxClient client) {
		super(null, client);
		this.bean = client.getEditorRegistry();
	}

	@Override
	public Object[] getChildren() {
		List<ClassNode> result = new ArrayList<ClassNode>();
		EditorRegistryEntryMBean[] beans = ((MoinJmxClient) getDelegate()).getRegisteredClassBeans();
		for (EditorRegistryEntryMBean bean : beans) {
			result.add(new ClassNode(this, bean));
		}
		return result.toArray();
	}

	@Override
	public String getText() {
		return DiagnosticsMessages.EditorRegistryNode_label;
	}

	public void reload() {
		if (bean != null) {
			bean.reload();
		}
	}
}