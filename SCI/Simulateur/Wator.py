import sys
import os
sys.path.append(os.getcwd()+"/..")

import tkinter as tk
from Simulateur.core.SMA import SMA
from Simulateur.core.View import View
from Simulateur.core.Environment import Environment
from Simulateur.particles.Particle import Particle
from Simulateur.wator.Fish import Fish
from Simulateur.wator.Shark import Shark
from Simulateur.wator.SMAWator import SMAWator
from Simulateur.hunter.ViewHunter import ViewHunter


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

root = tk.Tk()
v = View(800/GRIDSIZEX,800/GRIDSIZEY, master = root)

e = Environment(GRIDSIZEX, GRIDSIZEY, TOR)

s = SMAWator(e,v,0 ,TICKSNB, TICKTIME)

for i in range(FISHNB):
	f = Fish(e, s, FISHOFFSPRINGTIME)
	f.addRandomToEnv()

for i in range(SHARKNB):
	sh = Shark(e,s,SHARKOFFSPRINGTIME,SHARKSTARVETIME)
	sh.addRandomToEnv()

v.drawWidgets(s.env)
v.after(100, s.runStep())
v.mainloop()