# Piosk
Web Kiosk OS for Raspberry Pi.

Based on [TinyQPi](https://github.com/QingLee95/TinyQPi/tree/main).

At start up the Chromium browser (at the moment only) is started as the only application. This image can be used to develop kiosk GUI based on web technologies like Javascript, HTML, CSS....

# Dependencies
- Yocto
    - chromium
    - raspberry pi
    - connman
    - busybox
    - wayland
    - weston
- Raspberry Pi (Tested on 4B)

# TODO's
- Create example web UI
- Video of raspberry pi booting
- Firefox
- WPE webkit
- Screen serial example
- Upload SD Card image

# How to build image
See [build.md](./documentation//build.md).

# How to write image to SD Card
See [write_sd_image.md](./documentation/write_sd_image.md).