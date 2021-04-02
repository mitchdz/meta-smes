# meta-smes

## About
meta-smes is the meta-layer to create core-image-smes-os

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
repo init -u https://source.codeaurora.org/external/imx/imx-manifest -b imx-linux-gatesgarth -m imx-5.10.9-1.0.0.xml
repo sync
git clone https://github.com/mitchdz/meta-smes sources/meta-smes
git clone -b gatesgarth https://git.yoctoproject.org/git/meta-arm sources/meta-arm
MACHINE=imx8mmevk DISTRO=fsl-imx-wayland source imx-setup-release.sh -b build
echo 'IMAGE_INSTALL_append = "packagegroup-iot-ids-imx8mm perf"' >> conf/local.conf
echo 'PACKAGECONFIG_append_pn-perf = " coresight"' >> conf/local.conf
bitbake-layers add-layer ../sources/meta-smes
bitbake-layers add-layer ../sources/meta-arm
bitbake-layers add-layer ../sources/meta-arm/meta-arm-toolchain
```

To create the image
```bash
bitbake core-image-base
```


## Note
For consecutive builds, source the setup-environment like so:
```bash
source setup-environment build
```
