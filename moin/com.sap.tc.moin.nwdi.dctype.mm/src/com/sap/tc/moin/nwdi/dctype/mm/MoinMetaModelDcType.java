package com.sap.tc.moin.nwdi.dctype.mm;

import java.util.Iterator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.navigator.CommonNavigator;

import com.sap.ide.dii05.jdt.JdtPlugin;
import com.sap.ide.dii05.jdt.type.entity.JdtPpEntityService.EntitySubType;
import com.sap.ide.dii05.jdt.type.entity.JdtPpEntityService.EntityType;
import com.sap.ide.dii05.lib.api.core.IDcProject;
import com.sap.ide.dii05.lib.api.modeledit.DiiConcurrentModelModificationException;
import com.sap.ide.dii05.lib.api.modeledit.DiiLibraryOperationCancelledException;
import com.sap.ide.dii05.lib.api.modeledit.DiiModelEditService;
import com.sap.ide.dii05.lib.api.modeledit.IMeCustomProperty;
import com.sap.ide.dii05.lib.api.modeledit.IMeDcMetadataState;
import com.sap.ide.dii05.lib.api.modeledit.IMeEntity;
import com.sap.ide.dii05.lib.api.modeledit.IMePublicPart;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditFactory;
import com.sap.ide.dii05.lib.api.modeledit.ModelEditPackage;
import com.sap.ide.dii05.lib.api.util.DiiLibraryException;
import com.sap.ide.dii05.model.api.IComponentType;
import com.sap.ide.dii05.model.api.ICustomProperty;
import com.sap.ide.dii05.model.api.IDcMetadataState;
import com.sap.ide.dii05.model.api.IDevelopmentComponent;
import com.sap.ide.dii05.model.api.LocationState;
import com.sap.ide.dii05.model.api.Purpose;
import com.sap.ide.dii05.repository.api.IChangelistProvider;
import com.sap.ide.dii05.ui.api.typefw.ITypeSpecificDcProperties;
import com.sap.mi.fwk.dcfwk.BasicMoinDcType;
import com.sap.mi.fwk.dcfwk.MoinDcOptions;
import com.sap.mi.fwk.dcfwk.MoinFolderInfo;
import com.sap.mi.fwk.dcfwk.MoinProject;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * DC type for MOIN metamodels (i.e. models of metamodel MOF)
 * 
 * @author d031150, d021091, d027044
 */
public final class MoinMetaModelDcType extends BasicMoinDcType {

	private static final Logger stracer = Logger.getLogger(MoinMetaModelDcType.class);

	// DcType for metamodels:
	public static final String DC_TYPE_ID = "com.sap.tc.moin.nwdi.dctype.mm"; //$NON-NLS-1$

	public static final String DC_TYPE_VENDOR = MoinProject.VENDOR_SAP;

	public static final String DC_TYPE_NAMESPACE = "http://xml.sap.com/2007/05/MoinMetaModel"; //$NON-NLS-1$

	// hot_todo: mi.dcfwk does not yet provide an API to register the namespace

	public static final String ID_NATURE = "com.sap.tc.moin.nwdi.dctype.mm.MoinMetaModelNature"; //$NON-NLS-1$

	// MOIN-resource-folders for metamodels:
	// - Flags controlling which kind of MOIN-resource-folder is created:
	public static final boolean DC_RESOURCE_FOLDER = true;

	public static final boolean NO_DC_RESOURCE_FOLDER = false;

	// - Flags controlling the visibility of the folder in the IDE:
	public static final boolean FOLDER_EXCLUDED_IN_IDE = true;

	public static final boolean FOLDER_NOT_EXCLUDED_IN_IDE = false;

	// - Flags controlling the visibility of the folder in the build:
	public static final boolean FOLDER_EXCLUDED_IN_BUILD = true;

	public static final boolean FOLDER_NOT_EXCLUDED_IN_BUILD = false;

	// - DC-resource-folder for metamodel partitions:
	public static final MoinFolderInfo META_MODEL_RESOURCE_FOLDER = new MoinFolderInfo(
			new Path("moin/meta"), DC_RESOURCE_FOLDER); //$NON-NLS-1$

	// - DC-folder (NO DC-resource-folder !!!) for diagrams needed only during
	// design-time:
	// <sw 08102008> changed due to CSN 0120031469 0003938876 2008:
	// diagrams folder is now a MOIN resource folder but is excluded in build
	public static final MoinFolderInfo DIAGRAM_FOLDER = new MoinFolderInfo(
			new Path("diagrams"), DC_RESOURCE_FOLDER, FOLDER_NOT_EXCLUDED_IN_IDE, FOLDER_EXCLUDED_IN_BUILD); //$NON-NLS-1$

	// DC type version 1: support for folder moin/reginfo and java (containing
	// files for OCL constraint violation messages, custom parser/serializer
	// and textverticalisation)
	private static final MoinFolderInfo META_MODEL_REGINFO_FOLDER = new MoinFolderInfo(new Path("moin/reginfo"), //$NON-NLS-1$
			DC_RESOURCE_FOLDER);
	private static final MoinFolderInfo JAVA_FOLDER = new MoinFolderInfo(new Path("java"), //$NON-NLS-1$
			MoinFolderInfo.DC_FOLDER_TYPE_PACKAGE, false, false, false);

	public static final String PROPERTY_NAME_METAMODEL_VERSION = "metamodelVersion"; //$NON-NLS-1$
	public static final String PROPERTY_NAME_FACILITY_NAME = "facilityName"; //$NON-NLS-1$
	private static final String PROPERTY_NAME_DC_VERSION = "dcTypeVersion"; //$NON-NLS-1$

	private static final String PROPERTY_VALUE_METAMODEL_VERSION = "1.0"; //$NON-NLS-1$
	private static final String PROPERTY_VALUE_FACILITY_NAME = "PF"; //$NON-NLS-1$
	private static final String PROPERTY_VALUE_DC_VERSION = "1"; //$NON-NLS-1$

	private static final String PROJECT_EXPLORER_VIEW_ID = "org.eclipse.ui.navigator.ProjectExplorer"; //$NON-NLS-1$

	public static IComponentType getDcType() {

		IComponentType dcType = MoinProject.getDcType(DC_TYPE_ID, DC_TYPE_VENDOR, null);
		return dcType;
	}

	private ITypeSpecificDcProperties mTypeSpecificDcProperties = null;

	@Override
	protected MoinDcOptions newOptions() {
		return new MetamodelDcOptions();
	}

	@Override
	public String[] getSupportedPublicPartEntityServiceIds(IDevelopmentComponent dc) {
		return new String[] { MetaModelFolderTreeEntityService.ID_SERVICE_META_MODEL_FOLDER_TREE,
				JdtPlugin.JDT_PP_ENTITY_SERVICE_ID };
	}

	@SuppressWarnings("unchecked")
	@Override
	public void configure(IDevelopmentComponent dc, IMeDcMetadataState editableState) throws CoreException {
		super.configure(dc, editableState);
		editableState.setDescription(dc.getDisplayName());

		ModelEditFactory factory = ModelEditPackage.eINSTANCE.getModelEditFactory();
		IMeCustomProperty moinProp = null;
		Iterator it = editableState.getCustomProperties().iterator();
		while (it.hasNext()) {
			IMeCustomProperty prop = (IMeCustomProperty) it.next();
			if (MoinProject.PROP_MOIN.equals(prop.getName())) {
				moinProp = prop;
			}
		}
		if (moinProp == null) {
			stracer.log(Level.SEVERE, "Parent MOIN DC property not found"); //$NON-NLS-1$
			return;
		}

		// Add DC property for the metamodel version
		IMeCustomProperty propMoin = factory.createIMeCustomProperty();
		propMoin.setName(PROPERTY_NAME_METAMODEL_VERSION);
		propMoin.setNamespace(MoinProject.PROP_MOIN_NAMESPACE);
		propMoin.setValue(PROPERTY_VALUE_METAMODEL_VERSION);
		moinProp.getChildren().add(propMoin);

		// Add DC property for the facility name
		propMoin = factory.createIMeCustomProperty();
		propMoin.setName(PROPERTY_NAME_FACILITY_NAME);
		propMoin.setNamespace(MoinProject.PROP_MOIN_NAMESPACE);
		propMoin.setValue(PROPERTY_VALUE_FACILITY_NAME);
		moinProp.getChildren().add(propMoin);

		// Add DC property for the DC version
		propMoin = factory.createIMeCustomProperty();
		propMoin.setName(PROPERTY_NAME_DC_VERSION);
		propMoin.setNamespace(MoinProject.PROP_MOIN_NAMESPACE);
		propMoin.setValue(PROPERTY_VALUE_DC_VERSION);
		moinProp.getChildren().add(propMoin);
	}

	@SuppressWarnings("unchecked")
	private static IMeEntity createJavaPackageTreeEntryEntity() {
		ModelEditFactory factory = ModelEditPackage.eINSTANCE.getModelEditFactory();
		IMeEntity entity = factory.createIMeEntity();
		entity.setName("/"); //$NON-NLS-1$
		entity.setCaption("JMI classes");
		entity.setDescription("All java code generated by the MOIN JMI generator");
		entity.setEntityType(EntityType.TYPE_JAVA_PACKAGE_TREE);
		entity.setEntitySubtype(EntitySubType.SUBTYPE_CLASS);
		entity.getIncludes().add("*/**"); //$NON-NLS-1$
		return entity;
	}

	private static class MetamodelDcOptions extends MoinDcOptions {
		@Override
		public String[] getNatures() {

			return new String[] { ID_NATURE };
		}

		@Override
		public boolean isPublicPartCreationChangeable(Purpose publicPartPurpose) {
			return false;
		}

		@Override
		public boolean getPublicPartCreationDefault(Purpose publicPartPurpose) {
			return true;
		}

		@Override
		public MoinFolderInfo[] getFolders() throws CoreException {
			return new MoinFolderInfo[] { META_MODEL_RESOURCE_FOLDER, DIAGRAM_FOLDER, META_MODEL_REGINFO_FOLDER,
					JAVA_FOLDER };
		}

		@SuppressWarnings("unchecked")
		@Override
		public IMePublicPart[] getPublicParts(IDevelopmentComponent dc, IChangelistProvider changelistProvider)
				throws CoreException {
			// Create metamodel folder tree entries
			IMePublicPart[] pps = MoinProject.getPublicPartsForModelFolderTree(new MetamodelPublicPartOptions(), dc,
					MetaModelFolderTreeEntityService.TYPE_META_MODEL_FOLDER_TREE, changelistProvider);

			// Create Java sources entries
			for (int i = 0; i < pps.length; i++) {
				IMeEntity entity = createJavaPackageTreeEntryEntity();
				pps[i].getEntities().add(entity);
			}
			return pps;
		}
	}

	@Override
	public ITypeSpecificDcProperties getTypeSpecificDcProperties() {
		if (mTypeSpecificDcProperties == null) {
			mTypeSpecificDcProperties = new MMTypeSpecificDcProperties();
		}
		return mTypeSpecificDcProperties;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sap.ide.dii05.ui.api.typefw.BasicDcTypeDelegate#updateProjectSettings
	 * (com.sap.ide.dii05.lib.api.core.IDcProject,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public IStatus updateProjectSettings(final IDcProject dcProject, IProgressMonitor monitor) {
		// Refresh the project node in the project explorer to update the
		// "Used Metamodels"
		// node. Switched to UI thread is necessary because in case of DC
		// dependency removal
		// the call happens in a worker only.
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				if (window != null) {
					// Find the project explorer view (in case no window is
					// found do nothing)
					IViewPart projectExplorer = window.getActivePage().findView(PROJECT_EXPLORER_VIEW_ID);
					if (projectExplorer instanceof CommonNavigator) {
						CommonNavigator navigator = (CommonNavigator) projectExplorer;
						// Refresh the project node only
						navigator.getCommonViewer().refresh(dcProject.getProject());
					}
				}
			}
		});

		return super.updateProjectSettings(dcProject, monitor);
	}

	private static final class MetamodelPublicPartOptions extends MetamodelDcOptions {
		@Override
		public MoinFolderInfo[] getFolders() throws CoreException {
			// Only the resource folder (moin/meta) shall be
			// added to the public parts
			return new MoinFolderInfo[] { META_MODEL_RESOURCE_FOLDER };
		}
	}

	private final class MMTypeSpecificDcProperties implements ITypeSpecificDcProperties {

		private Text mText = null;

		public MMTypeSpecificDcProperties() {
			super();
		}

		public Control createPropertiesPage(Composite parent, IDevelopmentComponent dc, LocationState displayState) {
			FormToolkit toolkit = new FormToolkit(parent.getDisplay());
			parent.setLayoutData(new GridData(GridData.FILL_BOTH));

			Composite composite = toolkit.createComposite(parent);
			GridLayout grid = new GridLayout(2, false);
			composite.setLayout(grid);
			composite.setLayoutData(new GridData(GridData.FILL_BOTH));

			toolkit.createLabel(composite, "Metamodel Version");

			mText = toolkit.createText(composite, getVersion(dc));
			mText.setData("name", "metamodelVersionText"); //$NON-NLS-1$ //$NON-NLS-2$
			mText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			mText.setText(getVersion(dc));
			if (LocationState.INACTIVE == displayState.getValue()) {
				mText.setEditable(false);
			}
			mText.addModifyListener(new VersionModifyListener(dc));

			return parent;
		}

		public String getDescription() {
			return "Properties of the metamodel DC";
		}

		public boolean hasPropertiesPage() {
			return true;
		}

		public void selectionChanged(IDevelopmentComponent selectedDc, LocationState locState) {
			mText.setText(getVersion(selectedDc));
			mText.setEditable(LocationState.ACTIVE == locState.getValue());
		}

		public void setFocus() {
			mText.setFocus();
		}

		public void updateShownProperties() {
			mText.redraw();
		}

		private String getVersion(IDevelopmentComponent dc) {
			ICustomProperty versionProp = getVersionProperty(dc.getLocalState());
			if (versionProp == null) {
				return "<ERROR>";
			}

			String value = versionProp.getValue();
			if (value == null) {
				value = ""; //$NON-NLS-1$
			}
			return value;
		}

		private ICustomProperty getVersionProperty(IDcMetadataState dcState) {
			ICustomProperty moinProp = null;
			Iterator<?> it = dcState.getCustomProperties().iterator();
			while (it.hasNext()) {
				ICustomProperty prop = (ICustomProperty) it.next();
				if (MoinProject.PROP_MOIN.equals(prop.getName())) {
					moinProp = prop;
				}
			}
			if (moinProp == null) {
				return null;
			}

			ICustomProperty versionProp = null;
			it = moinProp.getChildren().iterator();
			while (it.hasNext()) {
				ICustomProperty prop = (ICustomProperty) it.next();
				if (PROPERTY_NAME_METAMODEL_VERSION.equals(prop.getName())) {
					versionProp = prop;
				}
			}

			return versionProp;
		}

		public class VersionModifyListener implements ModifyListener {

			private IDevelopmentComponent mDc = null;

			public VersionModifyListener(IDevelopmentComponent dc) {
				super();
				mDc = dc;
			}

			public void modifyText(ModifyEvent event) {
				if (event.getSource() instanceof Text) {
					Text text = (Text) event.getSource();
					String newVersion = text.getText();
					String oldVersion = getVersion(mDc);
					if (oldVersion == null || !oldVersion.equals(newVersion)) {
						IMeDcMetadataState edc = null;
						try {
							edc = DiiModelEditService.getEditableState(mDc.getLocalState(), null);
						} catch (DiiLibraryOperationCancelledException e) {
							text.removeModifyListener(this);
							text.setText(oldVersion);
							text.addModifyListener(this);
							return;
						} catch (DiiLibraryException e) {
							stracer.log(Level.SEVERE, "Cannot get changable version property", e); //$NON-NLS-1$
						}
						Iterator<?> it = edc.getCustomProperties().iterator();
						IMeCustomProperty moinProp = null;
						while (it.hasNext()) {
							IMeCustomProperty prop = (IMeCustomProperty) it.next();
							if (MoinProject.PROP_MOIN.equals(prop.getName())) {
								moinProp = prop;
							}
						}
						if (moinProp == null) {
							text.setText("<ERROR>");
							return;
						}

						IMeCustomProperty versionProp = null;
						it = moinProp.getChildren().iterator();
						while (it.hasNext()) {
							IMeCustomProperty prop = (IMeCustomProperty) it.next();
							if (PROPERTY_NAME_METAMODEL_VERSION.equals(prop.getName())) {
								versionProp = prop;
							}
						}
						if (versionProp == null) {
							text.setText("<ERROR>");
							return;
						}

						versionProp.setValue(newVersion);

						try {
							DiiModelEditService.commitChanges(edc);
						} catch (DiiConcurrentModelModificationException e) {
							stracer.log(Level.SEVERE, "Cannot commit changed version", e); //$NON-NLS-1$
						} catch (DiiLibraryException e) {
							stracer.log(Level.SEVERE, "Cannot commit changed version", e); //$NON-NLS-1$
						}
					}
				}
			}
		}
	}
}
