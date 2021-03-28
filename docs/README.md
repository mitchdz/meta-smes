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
repo init -u https://source.codeaurora.org/external/imx/imx-manifest  -b imx-linux-zeus -m imx-5.4.3-2.0.0.xml
repo sync
git clone https://github.com/mitchdz/meta-smes sources/meta-smes
MACHINE=imx8mmevk DISTRO=fsl-imx-wayland source imx-setup-release.sh -b build
echo 'IMAGE_INSTALL_append = "packagegroup-iot-ids-imx8mm"' >> conf/local.conf
bitbake-layers add-layer ../sources/meta-smes
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
