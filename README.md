
To create the build directory and clone sources:
```bash
mkdir -p smes-yocto && cd smes-yocto

git clone git://git.yoctoproject.org/poky -b gatesgarth
git clone https://github.com/Freescale/meta-freescale poky/meta-freescale
git clone https://github.com/mitchdz/meta-smes poky/meta-smes

mkdir -p smes-build && cd smes-build

sed -i 's/poky/smes/g' ../poky/.templateconf
. ../poky/oe-init-build-env .

bitbake-layers add-layer \
  ../poky/meta-freescale \
  ../poky/meta-smes
```

To create smes-os
```bash
bitbake core-image-smes-os
```
