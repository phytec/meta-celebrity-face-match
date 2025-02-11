require recipes-images/images/phytec-vision-image.bb

SUMMARY =  "PHYTEC's AiKit Celebrity Face Match Demo image"
LICENSE = "MIT"

PREFERRED_VERSION_onnxruntime = "1.16.1"

IMAGE_INSTALL += "\
    packagegroup-imx-ml \
    demo-celebrity-face-match \
"
