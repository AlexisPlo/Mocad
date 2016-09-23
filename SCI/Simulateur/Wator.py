import sys
import os
sys.path.append(os.getcwd()+"/..")
print(os.getcwd())

from Simulateur.core.SMA import SMA
from Simulateur.core.View import View
from Simulateur.core.Environment import Environment
from Simulateur.particles.Particle import Particle
from Simulateur.wator.Fish import Fish
from Simulateur.wator.Shark import Shark
from Simulateur.wator.SMAWator import SMAWator


from Simulateur import WatorProperties
import time

GRIDSIZEX = WatorProperties.gridsizeX
GRIDSIZEY = WatorProperties.gridsizeX


TICKSNB = WatorProperties.tickNb
TICKTIME = WatorProperties.tickDuration
SHARKNB = WatorProperties.sharknb
FISHNB = WatorProperties.fishnb

FISHOFFSPRINGTIME = WatorProperties.fishoffspringtime

SHARKOFFSPRINGTIME = WatorProperties.sharkoffspringtime
SHARKSTARVETIME = WatorProperties.sharkstarvetime


TOR = WatorProperties.toric


v = View(800/GRIDSIZEX,800/GRIDSIZEY)

e = Environment(GRIDSIZEX, GRIDSIZEY, TOR)

s = SMAWator(e,v,0 ,TICKSNB, TICKTIME)

for i in range(FISHNB):
	f = Fish(e, s, FISHOFFSPRINGTIME)
	f.addRandomToEnv()

for i in range(SHARKNB):
	sh = Shark(e,s,SHARKOFFSPRINGTIME,SHARKSTARVETIME)
	sh.addRandomToEnv()

v.drawWidgets(s.env)
s.run()
v.update()
time.sleep(1)
