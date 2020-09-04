# Copyright (C) 2016 Freescale Semiconductor
# Copyright 2017-2019 NXP

DESCRIPTION = "i.MX System Controller Firmware"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=228c72f2a91452b8a03c4cab30f30ef9"
SECTION = "BSP"

inherit fsl-eula2-unpack2 pkgconfig deploy

SRC_URI[md5sum] = "e939f40ca655afbdedabfae73863e6da"
SRC_URI[sha256sum] = "18ef3717180ef034c1a3418d7342803f2727e4e09531e0a5db13e6f5244f2058"

BOARD_TYPE ?= "iwg27m"
SC_FIRMWARE_NAME ?= "INVALID"
SC_FIRMWARE_NAME_mx8qm = "mx8qm-${BOARD_TYPE}-scfw-tcm.bin"
SC_FIRMWARE_NAME_mx8qxp = "mx8qx-${BOARD_TYPE}-scfw-tcm.bin"
SC_FIRMWARE_NAME_mx8phantomdxl = "mx8dxl-phantom-${BOARD_TYPE}-scfw-tcm.bin"
SC_FIRMWARE_NAME_mx8dxl = "mx8dxl-${BOARD_TYPE}-scfw-tcm.bin"
SC_FIRMWARE_NAME_mx8dx = "mx8dx-${BOARD_TYPE}-scfw-tcm.bin"

symlink_name = "scfw_tcm.bin"

BOOT_TOOLS = "imx-boot-tools"

do_compile[noexec] = "1"

do_install[noexec] = "1"

do_deploy() {
       if [ "${MACHINE}" = "imx8qm-iwg27m" ]; then
               install -Dm 0644 ${S}/../../../../../../../sources/meta-iwave/recipes-bsp/imx-mkimage/imx-boot/mx8qm-iwg27m-scfw-tcm_4gb.bin ${DEPLOYDIR}/${BOOT_TOOLS}/${SC_FIRMWARE_NAME_mx8qm}
               ln -sf mx8qm-iwg27m-scfw-tcm_4gb.bin ${DEPLOYDIR}/${BOOT_TOOLS}/${symlink_name}
       elif [ "${MACHINE}" = "imx8qm-iwg27m-8gb" ]; then
               install -Dm 0644 ${S}/../../../../../../../sources/meta-iwave/recipes-bsp/imx-mkimage/imx-boot/mx8qm-iwg27m-scfw-tcm_8gb.bin ${DEPLOYDIR}/${BOOT_TOOLS}/${SC_FIRMWARE_NAME_mx8qm}
               ln -sf mx8qm-iwg27m-scfw-tcm_8gb.bin ${DEPLOYDIR}/${BOOT_TOOLS}/${symlink_name}
       fi
}

addtask deploy after do_install

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

COMPATIBLE_MACHINE = "(mx8)"
COMPATIBLE_MACHINE_mx8m = "(^$)"
