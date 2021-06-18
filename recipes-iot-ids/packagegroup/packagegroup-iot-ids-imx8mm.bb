DESCRIPTION = "Add packages for iot-ids on imx8mm"
LICENSE = "CLOSED"

inherit packagegroup

RDEPENDS_${PN} += "\
    smart-doorbell-driver \
    opencsd \
    iot-ids \
    openssl \
    openssh \
    openssh-keygen \
    openssh-scp \
    openssh-sftp-server \
    openssh-ssh \
    openssh-sftp \
    perf \
    apache2 \
    "
