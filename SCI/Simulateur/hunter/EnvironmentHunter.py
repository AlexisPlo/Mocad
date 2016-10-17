from Simulateur.core.Environment import Environment
from Simulateur.hunter.Exit import Exit

class EnvironmentHunter(Environment):


	def __init__(self, _gridsizeX, _gridsizeY, _powCounter):


		Environment.__init__(self, _gridsizeX, _gridsizeY, False)
		self.dijkstraTab = [[-1 for j in range(_gridsizeY)] for i in range(_gridsizeX)]
		self.powCounter = _powCounter


	def resetDijkstra(self):

		self.dijkstraTab = [[-1 for j in range(self.gridsizeY)] for i in range(self.gridsizeX)]
		
		
	def removePow(self, sma):
		self.powCounter -= 1
		if self.powCounter == 0:
			self.createExit(sma)
			
	def createExit(self, sma):
	
		ex = Exit(self, sma)
		ex.addRandomToEnv()