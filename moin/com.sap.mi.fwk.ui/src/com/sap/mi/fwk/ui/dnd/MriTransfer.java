package com.sap.mi.fwk.ui.dnd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.TransferData;

import com.sap.mi.fwk.internal.tracing.MiLocations;
import com.sap.mi.fwk.ui.internal.MiFwkUIPlugin;
import com.sap.tc.moin.repository.MRI;
import com.tssap.util.trace.TracerI;
import com.tssap.util.trace.TracingManager;

/**
 * SWT {@link Transfer} for transporting a number of {@link MRI}-addressable
 * objects. Expected data class is {@link MriTransferData}. In copy/paste
 * scenario, use the {@link ModelClipboard} facility, or for a complete flow,
 * {@link CopyPasteActionGroup}.
 * 
 * @author d031150
 */
public class MriTransfer extends ByteArrayTransfer {

	private static final String TYPE_NAME = "MRI-transfer-format"; //$NON-NLS-1$
	private static final int TYPE_ID = registerType(MriTransfer.TYPE_NAME);
	private static final String MRI_SEP = "#?#"; //$NON-NLS-1$
	private static final String CHARSET = "UTF-8"; //$NON-NLS-1$

	private static final MriTransfer sInstance = new MriTransfer();

	private static final TracerI sTracer = TracingManager.getTracer(MiLocations.MI_MODELHANDLING);

	/**
	 * @return the singleton instance
	 */
	public static MriTransfer getInstance() {
		return MriTransfer.sInstance;
	}

	@Override
	protected int[] getTypeIds() {
		return new int[] { MriTransfer.TYPE_ID };
	}

	@Override
	protected String[] getTypeNames() {
		return new String[] { MriTransfer.TYPE_NAME };
	}

	@Override
	protected void javaToNative(final Object data, final TransferData transferData) {
		if (data == null) {
			return;
		}
		final MriTransferData realData = (MriTransferData) data;
		if (realData.getMriStrings().isEmpty()) {
			return;
		}
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final DataOutputStream dataOut = new DataOutputStream(out);
		try {
			final byte[] bytes = toTransferBytes(realData.getMriStrings());
			dataOut.writeInt(bytes.length);
			dataOut.write(bytes);
			super.javaToNative(out.toByteArray(), transferData);
		} catch (final IOException e) {
			MiFwkUIPlugin.logError(e, MriTransfer.sTracer);
		} finally {
			try {
				dataOut.close();
				out.close();
			} catch (final IOException e) { // $JL-EXC$
			}
		}
	}

	@Override
	protected Object nativeToJava(final TransferData transferData) {
		ByteArrayInputStream in = null;
		DataInputStream dataIn = null;

		try {
			final byte[] bytes = (byte[]) super.nativeToJava(transferData);
			if (bytes == null || bytes.length == 0) {
				return null;
			}
			in = new ByteArrayInputStream(bytes);
			dataIn = new DataInputStream(in);
			final int len = dataIn.readInt();
			final byte[] mriBytes = new byte[len];
			dataIn.readFully(mriBytes);
			final List<String> mriStrings = fromTransferBytes(mriBytes);
			return new MriTransferData(mriStrings);
		} catch (final IOException e) {
			MiFwkUIPlugin.logError(e, MriTransfer.sTracer);
			return null;
		} finally {
			try {
				if (in != null) {
					in.close();
					dataIn.close();
				}
			} catch (final IOException e) {
				MriTransfer.sTracer.error("Error while reading stream", e); //$NON-NLS-1$
			}
		}
	}

	private byte[] toTransferBytes(final List<String> mriStrings) throws IOException {
		final StringBuilder b = new StringBuilder();
		for (final Iterator<String> iter = mriStrings.iterator(); iter.hasNext();) {
			final String s = iter.next();
			b.append(s);
			if (iter.hasNext()) {
				b.append(MriTransfer.MRI_SEP);
			}
		}
		return b.toString().getBytes(MriTransfer.CHARSET);
	}

	private List<String> fromTransferBytes(final byte[] bytes) throws IOException {
		final String all = new String(bytes, MriTransfer.CHARSET);
		final String[] parts = all.split(Pattern.quote(MriTransfer.MRI_SEP));
		return Arrays.asList(parts);
	}

	@Override
	public String toString() {
		return MriTransfer.TYPE_NAME;
	}

	private MriTransfer() {
	}
}