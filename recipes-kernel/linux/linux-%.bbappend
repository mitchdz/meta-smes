FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SMES_CONFIG_URI = "file://enable_coresight.cfg"
SMES_CONFIG_URI += "file://imx8mq.dtsi"

SRC_URI_append = "${@d.getVar('SMES_CONFIG_URI') if bb.data.inherits_class('kernel', d) else ''}"
