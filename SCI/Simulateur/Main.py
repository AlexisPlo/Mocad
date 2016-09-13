from SMA import SMA
from View import View
import time

GRIDSIZEX = 10
GRIDSIZEY = 10

PARTICLENB = 10
TICKSNB = 20

TOR = False


v = View()

sysma = SMA(GRIDSIZEX,GRIDSIZEY,0,TICKSNB,PARTICLENB,TOR,v)
v.drawWidgets(sysma.env)
sysma.run()
v.update()
time.sleep(1)
