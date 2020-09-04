# Copyright (c) 2020 iWave Systems Technologies Pvt. Ltd.

DESCRIPTION = "iwtest files"
PROVIDES += "${PN}"
LICENSE = "GPLv2+"

COMPATIBLE_MACHINE = "(imx8qm-iwg27m|imx8qm-iwg27m-8gb)"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

LIC_FILES_CHKSUM = "file://GPL-2;md5=94d55d512a9ba36caa9b7df079bae19f"

SRC_URI = "file://mipi_dsi_rotate.sh file://GPL-2 file://tfr.mp4 file://weston"
FILES_${PN} = "iwtest /etc/default"
S = "${WORKDIR}"

do_install() {
    mkdir -p ${D}/iwtest ${D}/etc/default
    install -m 0644 ${S}/tfr.mp4 ${D}/iwtest
    install -m 0644 ${S}/mipi_dsi_rotate.sh ${D}/iwtest
    chmod   +x ${D}/iwtest/*

    install -m 0644 ${S}/weston ${D}/etc/default
    chmod   +x ${D}/etc/default/weston
}
