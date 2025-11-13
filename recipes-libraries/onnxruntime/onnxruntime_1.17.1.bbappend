FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://0001-cmake-deps.txt-Fix-eigen-hash-value.patch \
"
