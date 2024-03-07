meta-celebrity-face-match
================================================================================

This layer contains the Celebrity Face Match Ai Demo for the PHYTEC
phyBOARD-Pollux with phyCORE-i.MX 8MPlus.

The Demo is based on the BSP-Yocto-FSL-i.MX8MP-PD23.1.0 BSP.

All recipes are provided by the MIT licensing Terms unless otherwise noted.

If you experience any problem with this software, please contact our
<support@phytec.de> or the maintainer directly.
Please try to do the following first:

* look in the
  [Yocto Project Bugzilla](http://bugzilla.yoctoproject.org/)
  to see if a problem has already been reported
* look through recent entries of the
  [Yocto mailing list archives](https://lists.yoctoproject.org/pipermail/yocto/)
  to see if other people have run into similar
  problems or had similar questions answered.

Please see the corresponding sections below for details.

Start building
================================================================================
To build the images with the Celebrity Face Match Ai Demo first the build
enviroment needs to be sourced:

 source sources/poky/oe-init-build-env

You will recieve an output with the buildable images.
Start the build with:

 bitbake <image-name>


Images
================================================================================
Images of the build can be found under

 build/deploy/images/<machine>/.


Maintainer
==========

M:  Stefan Riedmüller <s.riedmueller@phytec.de>

Dependencies
============

This layer depends on the PHYTEC BSP-Yocto-FSL-i.MX8MP-PD23.1.0 BSP release.
