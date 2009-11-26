package com.sap.tc.logging.interfaces;

/**
 * Title:        Logging
 * Description:  Logging API
 * Copyright:    Copyright (c) 2008
 * Company:      SAP AG.
 *               Sofia, Bulgaria
 *               All rights reserved.
 *
 *               This software is the confidential and proprietary information
 *               of SAP AG. ("Confidential Information").  You shall
 *               not disclose such Confidential Information and shall use it
 *               only in accordance with the terms of the license agreement
 *               you entered into with SAP AG.
 * @version      $Id:$
 */

public interface IDeployRuntimeInfoProvider {

    public String getCsnComponentByDcName(String dcName);

}
