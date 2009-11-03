package com.sap.mi.gfw.eclipse.internal.policy;

import org.eclipse.gef.EditPolicy;

import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProvider;
import com.sap.mi.gfw.eclipse.internal.config.IConfigurationProviderHolder;

/**
 * All EditPolicies must be created with this IEditPolicyFactory. This provides an easy way to exchange the standard EditPolicies with
 * specific implementations.
 */
public interface IEditPolicyFactory extends IConfigurationProviderHolder {

	/**
	 * Disposes this object and frees all resources. This object will be unusable afterwards.
	 */
	public void dispose();

	// ================ EditPolicies for Shape EditParts =====================

	/**
	 * Creates an EditPolicy, which 'forbids' any Layout dependent Commands. All methods of this EditPolicy return null, which is different
	 * from using no EditPolicy at all, because it will create a visible feedback that the requests are forbidden. This EditPolicy can for
	 * example be used for those EditParts, which do not have any children. It forbids commands for the following requests:
	 * <ul>
	 * <li>A child EditPart shall be moved from another parent-EditPart into this parent-EditPart.</li>
	 * <li>A child EditPart shall be moved inside this parent-EditPart.</li>
	 * <li>A new child EditPart shall be created inside this parent-EditPart (with the CreationTool).</li>
	 * </ul>
	 */
	public EditPolicy createShapeForbidLayoutEditPolicy();

	/**
	 * Creates an EditPolicy, where the Layout of the EditParts is important: they must have an XYLayout. It assumes, that this EditPart is
	 * a parent, whose children can be added/deleted/moved. It creates commands for the following requests:
	 * <ul>
	 * <li>A child EditPart shall be moved from another parent-EditPart into this parent-EditPart.</li>
	 * <li>A child EditPart shall be moved inside this parent-EditPart (resized or changed XY-position).</li>
	 * <li>A new child EditPart shall be created inside this parent-EditPart (with the CreationTool).</li>
	 * </ul>
	 */
	public EditPolicy createShapeXYLayoutEditPolicy();

	/**
	 * Creates an EditPolicy, which gives feedback for if an EditPart is selected. It does not create any commands. It can be used for
	 * example to do the following:
	 * <ul>
	 * <li>Highlight the selected EditPart.</li>
	 * </ul>
	 */
	public EditPolicy createShapeHighlightEditPolicy();

	// ============== EditPolicies for Connection EditParts ==================

	/**
	 * Creates an EditPolicy give feedback for if a ConnectionEditPart is selected. This includes the connection-handles at the start/end of
	 * the connection. It does not create any commands. It can be used for example to do the following:
	 * <ul>
	 * <li>Create selection-handles at the beginning/end of the selected ConnectionEditPart.</li>
	 * <li>Highlight the selected ConnectionEditPart.</li>
	 * </ul>
	 */
	public EditPolicy createConnectionHighlightEditPolicy();

	// ================= EditPolicies for any EditParts ======================

	/**
	 * Creates an EditPolicy to handle direct-editing of EditParts. Typically not the complete EditPart shall be edited directly, but only
	 * one control of it (e.g. one Label). For this control an appropiate CellEditor would usually be shown. It creates commands for the
	 * following requests:
	 * <ul>
	 * <li>An EditPart shall be edited directly.</li>
	 * </ul>
	 */
	public EditPolicy createDirectEditPolicy();

	/**
	 * Creates an EditPolicy to handle the deletion of EditParts. It creates commands for the following requests:
	 * <ul>
	 * <li>An EditPart shall be deleted.</li>
	 * </ul>
	 */
	public EditPolicy createModelObjectDeleteEditPolicy(IConfigurationProvider configurationProvider);

	public EditPolicy createConnectionEditPolicy();

	public EditPolicy createConnectionBendpointsEditPolicy();

	public EditPolicy createConnectionDeleteEditPolicy(IConfigurationProvider configurationProvider);

}