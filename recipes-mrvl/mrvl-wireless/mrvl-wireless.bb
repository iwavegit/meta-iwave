DESCRIPTION = "Firmware For Marvel 8987 wireless chipset"
LICENSE = "CLOSED"

S = "${WORKDIR}"

FILES_${PN} = "${base_libdir}/firmware/mrvl ${base_libdir}/modules/mrvl"

PACKAGES += " ${PN}-firmware ${PN}-modules"

PROVIDES += "${PN}"

SRC_URI = "file://sduart8987_combo_jody-w2-sdiouart.bin \
          file://WlanCalData_ext_5pF.conf \
          file://mlan_jody-w2-sdiouart.ko \
          file://sd8987_jody-w2-sdiouart.ko \
          file://hci_uart_jody-w2-sdiouart.ko"

do_install() {
    install -d ${D}${base_libdir}/firmware/mrvl
    install -m 0777 ${WORKDIR}/sduart8987_combo_jody-w2-sdiouart.bin ${D}${base_libdir}/firmware/mrvl/
    install -m 0777 ${WORKDIR}/WlanCalData_ext_5pF.conf ${D}${base_libdir}/firmware/mrvl/
    install -d ${D}${base_libdir}/modules/mrvl
    install -m 0777 ${WORKDIR}/mlan_jody-w2-sdiouart.ko ${D}${base_libdir}/modules/mrvl/
    install -m 0777 ${WORKDIR}/hci_uart_jody-w2-sdiouart.ko ${D}${base_libdir}/modules/mrvl/
    install -m 0777 ${WORKDIR}/sd8987_jody-w2-sdiouart.ko ${D}${base_libdir}/modules/mrvl/
}

# These libraries shouldn't get installed in world builds unless something
# explicitly depends upon them.
EXCLUDE_FROM_WORLD = "1"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"
