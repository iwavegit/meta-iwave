FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append += "file://mipi_dsi_lcd_180_rotate_iwg27m.patch"
