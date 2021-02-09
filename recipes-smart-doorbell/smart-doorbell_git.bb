SUMMARY = "Smart Doorbell"
DESCRIPTION = "Simple smart doorbell project."
HOMEPAGE = "https://github.com/C-HGP/Smart-Doorbell"
SECTION = "Smart Applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=66c38f2d527b36de886475403576a10c"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/lvoytek/Smart-Doorbell.git;protocol=ssh;branch=main"

PV = "1.0+${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OEMAke = "'CC=${CC}'"

do_install () {
	oe_runmake
}



