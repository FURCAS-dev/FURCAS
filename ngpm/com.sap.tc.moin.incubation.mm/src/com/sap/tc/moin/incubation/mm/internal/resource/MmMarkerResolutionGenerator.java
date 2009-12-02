package com.sap.tc.moin.incubation.mm.internal.resource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.osgi.framework.Constants;

import com.sap.tc.logging.Location;
import com.sap.tc.moin.incubation.mm.internal.Activator;

public final class MmMarkerResolutionGenerator implements IMarkerResolutionGenerator2 {

	private static final IMarkerResolution[] NO_FIXES = new IMarkerResolution[0];

	@Override
	public boolean hasResolutions(IMarker marker) {
		String missingPackageString = getMissingPackageString(marker);
		return missingPackageString != null;
	}

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		String missingPackageString = getMissingPackageString(marker);
		if (missingPackageString != null) {
			String[] packages = missingPackageString.split(MmBuilder.PACKAGELIST_SEPARATOR.trim());
			return new IMarkerResolution[] { new MissingExportFix(packages) };
		}
		return NO_FIXES;
	}

	private String getMissingPackageString(IMarker marker) {
		try {
			String markerType = marker.getType();
			if (MmBuilder.MARKER_TYPE_PROBLEM.equals(markerType)) {
				String attribute = (String) marker.getAttribute(MmBuilder.MARKER_ATT_MISSING_PACKAGES);
				return attribute != null ? attribute.trim() : null;
			}
		} catch (CoreException e) {
			Activator.error(null, e, Location.getLocation(this));
		}
		return null;
	}

	public static final class MissingExportFix implements IMarkerResolution {

		private final String[] packages;

		public MissingExportFix(String[] packages) {
			this.packages = packages;
		}

		@Override
		public String getLabel() {
			return "Add missing package exports to manifest";
		}

		@Override
		public void run(IMarker marker) {
			IFile manifestFile = (IFile) marker.getResource();
			try {
				Manifest manifest = readManifest(manifestFile);
				Attributes attributes = manifest.getMainAttributes();
				String exportPackageValue = attributes.getValue(Constants.EXPORT_PACKAGE);
				StringBuilder exportedPackages = new StringBuilder(exportPackageValue != null ? exportPackageValue : "");

				for (String pack : packages) {
					if (exportedPackages.length() > 0) {
						exportedPackages.append(',');
					}
					exportedPackages.append(pack.trim());
				}

				attributes.putValue(Constants.EXPORT_PACKAGE, exportedPackages.toString());

				writeManifest(manifest, manifestFile);
			} catch (Exception e) {
				Activator.error(null, e, Location.getLocation(this));
			}
		}

		private Manifest readManifest(IFile manifestFile) throws CoreException, IOException {
			InputStream contents = null;
			try {
				contents = manifestFile.getContents();
				Manifest manifest = new Manifest(contents);
				return manifest;
			} finally {
				if (contents != null) {
					contents.close();
				}
			}
		}

		private void writeManifest(Manifest manifest, IFile manifestFile) throws CoreException, IOException {
			ByteArrayOutputStream content = new ByteArrayOutputStream();
			try {
				manifest.write(content);
				manifestFile.setContents(new ByteArrayInputStream(content.toByteArray()), true, false, null);
			} finally {
				content.close();
			}
		}
	}

}
