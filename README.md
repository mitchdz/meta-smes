
To create the build directory and clone sources:
```bash
mkdir -p smes-yocto && cd smes-yocto

# clone sources into poky
git clone git://git.yoctoproject.org/poky -b gatesgarth
git clone https://github.com/Freescale/meta-freescale poky/meta-freescale
git clone https://github.com/mitchdz/meta-smes        poky/meta-smes

# create build directory
mkdir -p smes-build && cd smes-build

# use meta-smes local.conf/bblayers.conf and source oe-init-build-env
sed -i 's/poky/smes/g' ../poky/.templateconf
. ../poky/oe-init-build-env .
```

To create smes-os
```bash
bitbake core-image-smes-os
```
