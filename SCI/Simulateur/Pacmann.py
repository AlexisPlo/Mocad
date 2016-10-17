import sys
import os
sys.path.append(os.getcwd()+"/..")

import tkinter as tk
from Simulateur.core.SMA import SMA
from Simulateur.core.View import View
from Simulateur.core.Environment import Environment
from Simulateur.particles.Particle import Particle
from Simulateur.hunter.ViewHunter import ViewHunter
from Simulateur.hunter.EnvironmentHunter import EnvironmentHunter
from Simulateur.hunter.SMAHunter import SMAHunter
from Simulateur.hunter.Avatar import Avatar
from Simulateur.hunter.Hunter import Hunter
from Simulateur.hunter.Wall import Wall
from Simulateur.hunter.Pow import Pow


from Simulateur import PacmannProperties
import time

GRIDSIZEX = PacmannProperties.gridsizeX
GRIDSIZEY = PacmannProperties.gridsizeY


TICKSNB = PacmannProperties.tickNb
TICKTIME = PacmannProperties.tickDuration

HUNTERNB = PacmannProperties.hunterNb
POWNB = PacmannProperties.powNb

root = tk.Tk()
v = ViewHunter(800/GRIDSIZEX,800/GRIDSIZEY, master = root)

e = EnvironmentHunter(GRIDSIZEX, GRIDSIZEY, POWNB)

s = SMAHunter(e,v,0 ,TICKSNB, TICKTIME)



#Initiating Walls

for i in range(int((GRIDSIZEY * GRIDSIZEX) / 15)):
	w = Wall(e, s)
	w.addWall()


#Initiating Avatar

ava = Avatar(e, s)

v.setAvatar(ava)
ava.addRandomToEnv()

ava.dijkstraAlg()

#Initiating Hunters

for i in range(HUNTERNB):
	h = Hunter(e, s, ava)
	h.addRandomToEnv()


#Initiating power up

for i in range(POWNB):
	p = Pow(e,s)
	p.addRandomToEnv()



v.drawWidgets(s.env)
v.after(TICKTIME, s.runStep())
v.mainloop()
