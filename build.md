# How to build image

1. Pull repository -> structure of directory should be
    ```bash
    .
    ├── artifacts
    ├── build
    └── sources
        ├── activate_bb
        ├── meta-openembedded
        ├── meta-raspberrypi
        ├── meta-piosk
        ├── poky
        └── README.md
   ```
2. Change "LAYERS_PATH" in meta-piosk/conf/templates/bblayers.conf.sample to your local directory   
3. ```git submodule update --init --recursive``` in ./sources
4. ```source sources/activate_bb build``` in ./
5. ```bitbake piosk4b```  in ./build

Step 5 can take a few hours!

The image will be in **./artifacts/*.sdimg** flash it to a sdcard of ssd and insert in the Raspberry Pi.

# Static ip on eth0

Add following line to **./build/conf/local.conf** when building image

```
DISTROOVERRIDE:append = ":static_eth0"
```
After this the raspberry pi will be accessible on eth0 via the static ip 192.168.1.3/24.

# Configured wifi out of the box on wlan0
Add following line to **./build/conf/local.conf** when building image

```
DISTROOVERRIDES:append = ":configured_wifi"
# Fill in wifi name
WIFI_NAME = ""
# Fill in wifi password
WIFI_PWD = ""
```

The Raspberry pi will startup with wifi already connected.

# Create SD image with swap partition

```
source sources/activate_bb 

wic create sdimage-tinyqpi -e tinyqpi4b
```
This will create a root partition + swap partition of 3GB. If you like to change the size see meta-tinyqpi/wic/sdimage-tiyqpi.wks
