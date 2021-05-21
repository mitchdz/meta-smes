# meta-smes

Secure Middleware for Embedded Systems

## About
meta-smes is the meta layer for the iot-ids project

meta-smes aims to be a lightweight secure operating system for IoT that
includes an IDS


## Building
Install repo to your system if you do not have it
```bash
mkdir ~/bin/
curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
chmod a+x ~/bin/repo
export PATH=~/bin/:$PATH
```

To create the build directory and clone sources:
```bash
repo init -u https://source.codeaurora.org/external/imx/imx-manifest \
    -b imx-linux-gatesgarth \
    -m imx-5.10.9-1.0.0.xml
repo sync -j$(nproc)

# clone extra layers
git clone https://github.com/mitchdz/meta-smes sources/meta-smes
git clone -b gatesgarth https://git.yoctoproject.org/git/meta-arm sources/meta-arm

# setup build environment
MACHINE=imx8mmevk DISTRO=fsl-imx-wayland source imx-setup-release.sh -b build

# add meta-smes local.conf additions
cat ../sources/meta-smes/conf/local.conf.append >> conf/local.conf

# add extra layers
bitbake-layers add-layer ../sources/meta-smes
bitbake-layers add-layer ../sources/meta-arm/meta-arm-toolchain
bitbake-layers add-layer ../sources/meta-arm/meta-arm
```

To create the image
```bash
bitbake core-image-base
```

We need to add our special devicetree source file to the kernel build.
To do that, we need to replace the old .dtsi file with our new one, and force
the kernel to recompile.
```bash
cp ../sources/meta-smes/recipes-kernel/linux/files/imx8mm.dtsi \
    tmp/work-shared/imx8mmevk/kernel-source/arch/arm64/boot/dts/freescale/
cp ../sources/meta-smes/recipes-kernel/linux/files/imx8mm-evk.dtsi \
    tmp/work-shared/imx8mmevk/kernel-source/arch/arm64/boot/dts/freescale/
bitbake -c compile -f linux-imx
bitbake core-image-base
```

Now the resulting image will have our special devicetree source include file in it.

The final image will be located at *tmp/deploy/images/imx8mmevk/core-image-base-imx8mmevk.wic.bz2*

To extract the image, execute the following
```bash
$ bunzip2 -dk core-image-base-imx8mmevk.wic
```

## Note
For consecutive builds, source the setup-environment like so:
```bash
source setup-environment build
```
