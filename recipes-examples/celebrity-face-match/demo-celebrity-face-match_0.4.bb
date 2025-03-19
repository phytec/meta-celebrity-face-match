# Copyright (C) 2020 Stefan Riedmueller <s.riedmueller@phytec.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Celebrity Face Match Ai Demo"
HOMEPAGE = "https://www.phytec.de"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI = " \
    git://github.com/phytec/demo-celebrity-face-match;branch=${BRANCH};protocol=https \
    file://demo-celebrity-face-match.service \
"

BRANCH = "main"
SRCREV = "89b6ca51d233fb1eabe0b80be192081dea017245"

S = "${WORKDIR}/git"

DEPENDS += "gtk+3"

inherit meson pkgconfig systemd

SYSTEMD_SERVICE:${PN} = "demo-celebrity-face-match.service"

do_install:append() {
    install -Dm 0644 ${WORKDIR}/${BPN}.service ${D}${systemd_system_unitdir}/${BPN}.service
}

RDEPENDS:${PN} += " \
    demo-celebrity-face-match-data \
    opencv \
    python3 \
    python3-fcntl \
    python3-pygobject \
    python3-pycups \
    tensorflow-lite \
    gstreamer1.0-plugins-good \
"

FILES:${PN} = " \
    ${bindir}/${BPN} \
    ${PYTHON_SITEPACKAGES_DIR}/demo_celebrity_face_match/ \
    ${systemd_system_unitdir}/${BPN}.service \
"
