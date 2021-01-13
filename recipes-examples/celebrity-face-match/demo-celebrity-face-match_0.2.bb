# Copyright (C) 2020 Stefan Riedmueller <s.riedmueller@phytec.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Celebrity Face Match Ai Demo"
HOMEPAGE = "https://www.phytec.de"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI = " \
    git://github.com/phytec/demo-celebrity-face-match;branch=main \
    file://demo-celebrity-face-match.service \
"

SRCREV = "7687234cafabdd82b5fe4f3212842aaacfd88a81"

S = "${WORKDIR}/git"
INSTALL_DIR = "${D}${datadir}/${PN}"

inherit systemd

SYSTEMD_SERVICE_${PN} = "demo-celebrity-face-match.service"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install() {
    install -Dm 0644 ${WORKDIR}/demo-celebrity-face-match.service ${D}${systemd_system_unitdir}/demo-celebrity-face-match.service

    install -d ${D}${datadir}/${PN}
    for f in ${S}/*.py; do \
        install -Dm 0644 $f ${D}${datadir}/${PN}/
    done
}

RDEPENDS_${PN} += " \
    demo-celebrity-face-match-data \
    opencv \
    python3 \
    python3-fcntl \
    python3-pygobject \
    tensorflow-lite \
    gstreamer1.0-plugins-good \
"

FILES_${PN} = " \
    ${datadir}/${PN} \
    ${systemd_system_unitdir}/* \
"
