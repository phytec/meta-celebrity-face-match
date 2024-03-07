FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI:append = " \
    file://0001-Sconstruct-Add-prefix-and-PREFIX-variable-to-be-comp.patch \
"

SCONS_MAXLINELENGTH = ""
