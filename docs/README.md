# meta-smes

## About
meta-smes is the meta-layer to create core-image-smes-os

## Building

To create the build directory and clone sources:
```bash
repo init -u https://source.codeaurora.org/external/imx/imx-manifest  -b imx-linux-zeus -m imx-5.4.3-2.0.0.xml
repo sync
git clone https://github.com/mitchdz/meta-smes sources/meta-smes
MACHINE=imx8mmevk DISTRO=fsl-imx-wayland source imx-setup-release.sh -b build
bitbake-layers add-layer ../sources/meta-smes
```

To create smes-os
```bash
bitbake core-image-smes-os
```


## Note
For consecutive builds, source the setup-environment like so:
```bash
source setup-environment build
```
