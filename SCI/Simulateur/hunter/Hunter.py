from Simulateur.core.Agent import Agent


class Hunter(Agent):


	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "red", "circle")
		


	def decide(self):

		bestPosX = -1
		bestPosY = -1



		newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, 0, 1)
		if newPosX>=0 and newPosY>=0:
			thing = self.env.agTab[newPosX][newPosY]
			if thing is None:
				distance = self.env.dijkstraTab[newPosX][newPosY]
				if distance < bestDist or bestDist = -1:
					bestDist = distance
					bestPosX = newPosX
					bestPosY = newPosY
					
