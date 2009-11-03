package com.sap.mi.tools.diagnostics.internal;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.sap.mi.tools.diagnostics.internal.model.MoinNode;
import com.sap.mi.tools.diagnostics.internal.model.PartitionableNode;
import com.sap.mi.tools.diagnostics.internal.properties.MoinBeanPropertySource;
import com.sap.mi.tools.diagnostics.internal.properties.PartitionableNodePropertySource;

/**
 * Factory for various adapters, mainly property-related
 * 
 * @author d031150
 */
public class DiagnosticsAdapterFactory implements IAdapterFactory {

	@SuppressWarnings("unchecked")
	public Object getAdapter(final Object adaptableObject, Class adapterType) {
		if (adapterType.isInstance(adaptableObject)) {
			return adaptableObject;
		}

		if (adapterType == IPropertySource.class) {
			// MoinNode -> IProperytSource
			if (adaptableObject instanceof MoinNode) {
				MoinNode node = (MoinNode) adaptableObject;
				return new MoinBeanPropertySource(node.getDelegate(), node.getClient());
			}
			// PartitionableNode -> IProperytSource
			else if (adaptableObject instanceof PartitionableNode) {
				PartitionableNode node = (PartitionableNode) adaptableObject;
				return new PartitionableNodePropertySource(node);
			}
		}

		// view -> IPropertySheetPage
		else if (IPropertySheetPage.class == adapterType) {
			if (adaptableObject instanceof IViewPart) {
				if (DiagnosticsPlugin.ID_VIEW.equals(((IViewPart) adaptableObject).getSite().getId()))
					return DiagnosticsPropertySheetPage.INSTANCE;
			}
		}
		return null;
	}

	public Class<?>[] getAdapterList() {
		return new Class<?>[] { IPropertySource.class, IPropertySheetPage.class };
	}

	private static final class DiagnosticsPropertySheetPage extends TabbedPropertySheetPage {
		static TabbedPropertySheetPage INSTANCE = new DiagnosticsPropertySheetPage();
		private DiagnosticsPropertySheetPage() {
			super(new DiagnosticsPropertySheetContributor());
		}
	}

	private static final class DiagnosticsPropertySheetContributor implements ITabbedPropertySheetPageContributor {
		public String getContributorId() {
			return DiagnosticsPlugin.ID_VIEW;
		}
	}

}
