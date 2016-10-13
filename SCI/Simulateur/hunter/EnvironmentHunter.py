from Simulateur.core.Environment import Environment

class EnvironmentHunter(Environment):


	def __init__(self, _gridsizeX, _gridsizeY):


		Environment.__init__(self, _gridsizeX, _gridsizeY, False)
		self.dijkstraTab = [[-1 for j in range(_gridsizeY)] for i in range(_gridsizeX)]


	def resetDijkstra(self):

		self.dijkstraTab = [[-1 for j in range(self.gridsizeY)] for i in range(self.gridsizeX)]