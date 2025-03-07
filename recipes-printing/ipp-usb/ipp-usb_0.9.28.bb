DESCRIPTION = "Allows using the IPP protocol over USB"
HOMEPAGE = "https://github.com/OpenPrinting/ipp-usb"

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=35b61b5975388824d233d3f4ee283ad0"

GO_IMPORT = "import"

SRC_URI = " \
    git://github.com/OpenPrinting/ipp-usb.git;protocol=https;branch=master \
    file://0001-systemd-udev-Fix-path-to-ipp-usb.patch \
"
SRCREV = "4b39c447f5ab9be4a6626cd56539d6742a48db01"
UPSTREAM_CHECK_COMMITS = "1"

S = "${WORKDIR}/git"

DEPENDS += "libusb avahi glibc"

inherit go
inherit pkgconfig

do_compile() {
    export GOARCH="${TARGET_GOARCH}"
    export GOPATH="${S}/src/import:${S}/src/import/vendor"
    export GOROOT="${STAGING_DIR_NATIVE}/${nonarch_libdir}/${HOST_SYS}/go"

    export CGO_ENABLED="1"
    export CGO_CFLAGS="${CFLAGS} --sysroot=${STAGING_DIR_TARGET}"
    export CGO_LDFLAGS="${LDFLAGS} --sysroot=${STAGING_DIR_TARGET}"

    oe_runmake -C src/${GO_IMPORT}
}

do_install() {
    install -Dm 755 ${S}/src/${GO_IMPORT}/ipp-usb ${D}/${bindir}/ipp-usb
    install -Dm 644 ${S}/src/${GO_IMPORT}/ipp-usb.conf ${D}/${sysconfdir}/ipp-usb/ipp-usb.conf
    install -Dm 644 ${S}/src/${GO_IMPORT}/systemd-udev/71-ipp-usb.rules ${D}/${nonarch_base_libdir}/udev/rules.d/71-ipp-usb.rules
    install -Dm 644 ${S}/src/${GO_IMPORT}/systemd-udev/ipp-usb.service ${D}/${systemd_system_unitdir}/ipp-usb.service
    install -Dm 644 ${S}/src/${GO_IMPORT}/ipp-usb-quirks/* -t ${D}/${datadir}/ipp-usb/quirks
}

deltask compile_ptest_base

FILES:${PN} += " \
    ${bindir}/ipp-usb \
    ${sysconfdir}/ipp-usb/ipp-usb.conf \
    ${nonarch_base_libdir}/udev/rules.d/71-ipp-usb.rules \
    ${systemd_system_unitdir}/ipp-usb.service \
    ${datadir}/ipp-usb/quirks/ \
"

INSANE_SKIP:${PN} += "ldflags already-stripped"
