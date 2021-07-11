SUMMARY = "the implementation of SOME/IP"

#LICENSE = "MPL-2.0 & Unknown"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=815ca599c9df247a0c7f619bab123dad "
#                    file://LICENSE_boost;md5=55a0dc970982f51bfe9b4c6ae0a68d1e"

SRC_URI = "git://github.com/GENIVI/vsomeip.git;protocol=https \
           file://0001-modify-the-CMakeLists.patch \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "3.1.20.3"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

S = "${WORKDIR}/git"

DEPENDS = "dlt-daemon boost"

inherit cmake lib_package gitpkgv

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

PACKAGES_remove += "${PN}-bin"
FILES_${PN}-dev += "${libdir}/cmake"

BBCLASSEXTEND = "nativesdk"

do_install_append() {
    mv ${D}/usr/etc ${D}
}