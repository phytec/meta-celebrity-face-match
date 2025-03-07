FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://usb-printer.scc"
KERNEL_FEATURES:append = " usb-printer.scc"
