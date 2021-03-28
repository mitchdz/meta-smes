SUMMARY = "IOT IDS implementation"
DESCRIPTION = "Lightweight IDS made for IoT devices."
HOMEPAGE = ""
SECTION = "Smart Applications"
LICENSE = "CLOSED"

inherit pkgconfig cmake

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/nadir-amin/Embedded_IDS.git;protocol=ssh;branch=main"

PV = "1.0+${SRCPV}"
S = "${WORKDIR}/git"

do_compile_prepend() {
    cd ${S}; cmake ./
}

do_compile() {
    cd ${S}; oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/Embedded_IDS/Embedded_IDS ${D}${bindir}
}

FILES_${PN} = "${bindir}"
