DESCRIPTION = "Add packages for iot-ids on imx8mm"
LICENSE = "CLOSED"

inherit packagegroup

RDEPENDS_${PN} += "\
    smart-doorbell \
    opencsd \
    iot-ids \
    "
