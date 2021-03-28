SUMMARY = "Smart Doorbell"
DESCRIPTION = "Simple smart doorbell project."
HOMEPAGE = "https://github.com/C-HGP/Smart-Doorbell"
SECTION = "Smart Applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=66c38f2d527b36de886475403576a10c"

DEPENDS = "i2c-tools"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/lvoytek/Smart-Doorbell.git;protocol=ssh;branch=driver-linux \
           file://makefile_add_optimization_remove_missing_files.patch \
           "

PV = "1.0+${SRCPV}"

S = "${WORKDIR}/git"

# Makefile uses DESTDIR to determine where to install to
EXTRA_OEMAKE = "DESTDIR=${D}"

## do not parallel thread
PARALLEL_MAKE = ""

do_compile() {
	cd ${S}; oe_runmake
}

do_install() {
	cd ${S}; oe_runmake install
}

FILES_${PN} = "\
        ${base_libdir} \
        "

INSANE_SKIP_${PN}-dev += "dev-elf"
INSANE_SKIP_${PN} += "ldflags"
INSANE_SKIP_${PN}-dev += "ldflags"
