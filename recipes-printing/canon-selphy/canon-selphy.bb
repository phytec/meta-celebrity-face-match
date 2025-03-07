DESCRIPTION = "Install and setup Canon SELPHY printers"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://setup-default-printer \
    file://canon-selphy-cp1500.service \
"

S = "${WORKDIR}"

inherit systemd

SYSTEMD_SERVICE:${PN} = "canon-selphy-cp1500.service"

RDEPENDS:${PN} += "ipp-usb cups cups-filters"

do_install() {
    install -Dm 755 ${S}/setup-default-printer ${D}/${bindir}/setup-default-printer
    install -Dm 644 ${S}/canon-selphy-cp1500.service ${D}/${systemd_system_unitdir}/canon-selphy-cp1500.service
}

FILES:${PN} = " \
    ${bindir}/setup-default-printer \
    ${systemd_system_unitdir}/canon-selphy-cp1500.service \
"
