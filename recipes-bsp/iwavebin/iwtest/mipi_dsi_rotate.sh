#! /bin/sh                                                     
if [[( $(cat /sys/class/drm/card0-DSI-1/modes) = '1080x1920' ) || ( $(cat /sys/class/drm/card0-DSI-1/modes) = '720x1280' )]];
then
/usr/bin/psplash -a 180 -f 0
else
/usr/bin/psplash -n
fi
