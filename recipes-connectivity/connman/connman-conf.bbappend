# Disable connman for interface eth0 to prevent DHCP for that interface
# Interface eth0 is set statically by ifupdown

do_install:append() {
    mkdir -p ${D}${sysconfdir}/connman
    cp ${S}/main.conf ${D}${sysconfdir}/connman/main.conf
}
