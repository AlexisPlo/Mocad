from Simulateur.core.SMA import SMA
from Simulateur.wator.Fish import Fish
from Simulateur.wator.Shark import Shark

class SMAWator(SMA):


	def __init__(self, _env, _view, _schedul, _nbTicks, _tickTime):

		SMA.__init__(self, _env, _view, _schedul, _nbTicks, _tickTime)


	def writeTickLine(self):

		nbShark = 0
		nbFish = 0
		for Ag in self.agList:
			if isinstance(Ag, Fish):
				nbFish += 1
			elif isinstance(Ag, Shark):
				nbShark += 1
		self.traceFile.write("Tick " + str(nbFish) + " " + str(nbShark) + ";\n")

