SUMMARY = "Raspbery Pi Kiosk"
DESCRIPTION = "Wayland web kiosk using chromium and weston"
#No license
LICENSE = "CLOSED"

REQUIRED_MACHINE_FEATURES = "vc4graphics"
REQUIRED_DISTRO_FEATURES = "wayland"
CONFLICT_DISTRO_FEATURES = "x11"

SRC_URI = "file://piosk_chromium_init.sh \
           file://piosk_chromium_init.service \
          "
RDEPENDS:${PN} = "wayland weston-init weston chromium-ozone-wayland"

do_install() {
    # For sysvinit
    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        install -Dm 0755 ${WORKDIR}/piosk_chromium_init.sh ${D}${sysconfdir}/init.d/piosk.sh
    fi

    # For systemd
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
       install -Dm 0755 ${WORKDIR}/piosk_chromium_init.service ${D}${systemd_system_unitdir}/piosk.service
    fi
}

inherit update-rc.d systemd features_check

INITSCRIPT_NAME = "piosk.sh"
# Start/stop after weston (level 20)
INITSCRIPT_PARAMS = "start 98 5 . stop 19 0 1 6 ."

SYSTEMD_SERVICE:${PN} = "piosk.service"


