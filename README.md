meta-celebrity-face-match
=========================

This layer contains the Celebrity Face Match AI Demo for the PHYTEC
phyBOARD-Pollux with phyCORE-i.MX 8M Plus.

The demo is based on the
[BSP-Yocto-NXP-i.MX8MP-PD24.1.0](https://download.phytec.de/Software/Linux/BSP-Yocto-i.MX8MP/BSP-Yocto-NXP-i.MX8MP-PD24.1.0/).

Start building
--------------

To build the images with the Celebrity Face Match AI Demo first the build
environment needs to be sourced:
```
source sources/poky/oe-init-build-env
```
You will receive an output with the buildable images. Start the build with:
```
bitbake phytec-facematch-image
```

Images
------

Images of the build can be found under
```
build/deploy/images/<MACHINE>/
```

Maintainer
----------

* Stefan Riedmüller `s.riedmueller@phytec.de`
* Martin Schwan `m.schwan@phytec.de`

Support
-------

If you experience any problem with this software, please contact us via
[support@phytec.de](mailto:support@phytec.de) or the maintainer directly. Please
try to do the following first:

* Look in the [Yocto Project Bugzilla](http://bugzilla.yoctoproject.org/) to see
  if a problem has already been reported
* Look through recent entries of the
  [Yocto mailing list archives](https://lists.yoctoproject.org/pipermail/yocto/)
  to see if other people have run into similar problems or had similar questions
  answered.

License
-------

All recipes are provided under the MIT licensing terms, unless otherwise noted.
