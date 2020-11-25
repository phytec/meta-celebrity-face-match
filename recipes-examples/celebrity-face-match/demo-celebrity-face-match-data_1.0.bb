# Copyright (C) 2020 Stefan Riedmueller <s.riedmueller@phytec.de>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Celebrity Face Match Demo Data"
DESCRIPTION = "This recipe collects the required data for the Celebrity \
               Face Match Demo like models, face detection cascader, \
               celebrity faces and their embeddings."
HOMEPAGE = "https://www.phytec.de"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    ftp://ftp.phytec.de/pub/Software/Linux/Applications/${BPN}-${PV}.tar.gz;unpack=false \
"
SRC_URI[md5sum] = "ad0cd27eced09901bd20ca43ab9e94db"
SRC_URI[sha256sum] = "b23001c4aea7621958654059e7d750799334bb3e0f994adb585166b56beb419c"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

DEMO_PN := "${@'-'.join(d.getVar('PN').split('-')[:-1])}"
INSTALL_DIR := "${D}${datadir}/${DEMO_PN}"

do_install() {
    echo ${INSTALL_DIR}
    install -d ${INSTALL_DIR}
    tar --no-same-owner -xzpf ${WORKDIR}/${PN}-${PV}.tar.gz -C ${INSTALL_DIR}
}

FILES_${PN} = " \
    ${datadir}/ \
"
