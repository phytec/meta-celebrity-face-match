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
SRC_URI[md5sum] = "aec68e42fb424d4d299997559f44388b"
SRC_URI[sha256sum] = "4c7f187e605fb85f6b777cb868e03defc16b4b12a936ae2d396cfa75766c149f"

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
