
# Create a bootable SD Card
1. Download image from release
2. ```tar -xzf piosk.tar.gz```
3. Compare sha1sum of image with piosk_image_sha1sum

## Write rpi-sdimg to the SD card in Linux

1. Insert SD card
2. ```lsblk``` see where it is mounted
3. Use ```dd``` to write the image to the SD card
4. Insert SD card in Raspberry Pi

## Example
- Image = piosk4b-raspberrypi4-64.rootfs.rpi-sdimg
- SD Card = /dev/mmcblk0

Write:
```bash
sudo dd if=./piosk4b-raspberrypi4-64.rootfs.rpi-sdimg of=/dev/mmcblk0 bs=4M conv=fsync status=progress
```
