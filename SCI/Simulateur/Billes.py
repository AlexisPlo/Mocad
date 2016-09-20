from Simulateur.core.SMA import SMA
from Simulateur.core.View import View
from Simulateur.core.Environment import Environment
from Simulateur.particles.Particle import Particle
import time

GRIDSIZEX = 100
GRIDSIZEY = 60


TICKSNB = 0
PARTICLENB = 100

TOR = False


v = View()

e = Environment(GRIDSIZEX, GRIDSIZEY, TOR)

s = SMA(e,v,0 ,TICKSNB)

for i in range(PARTICLENB):
	p = Particle(e, s)
	p.addRandomToEnv()
	s.addAgent(p)

v.drawWidgets(s.env)
s.run()
v.update()
time.sleep(1)
