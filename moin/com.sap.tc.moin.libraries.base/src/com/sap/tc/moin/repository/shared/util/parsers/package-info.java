/**
 * This package contains base functionality for all parsers used in MOIN. This
 * includes an abstract CstNode from which all generated nodes derive frome. All
 * general LPG messages are internationalized here. Moreover, two main LPG
 * templates which are shared among all parsers are kept here. Finally, the
 * AbstractAstBuilder is the base class for all visitors, which contains common
 * functionality with regard to error reporting as well as down and up maps.
 */
package com.sap.tc.moin.repository.shared.util.parsers;