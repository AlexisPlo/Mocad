from Simulateur.core.Agent import Agent


class Hunter(Agent):


	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "red", "circle")
		


	def decide(self):

		bestPosX = -1
		bestPosY = -1
		bestDist = -1

		for i, j in [(-1,0), (1,0), (0,-1), (0,1)]:

			newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, i, j)
			if newPosX>=0 and newPosY>=0:
				thing = self.env.agTab[newPosX][newPosY]
				if thing is None:
					distance = self.env.dijkstraTab[newPosX][newPosY]
					if distance < bestDist or bestDist == -1:
						bestDist = distance
						bestPosX = newPosX
						bestPosY = newPosY
				elif isinstance(thing, Avatar):
					self.sma.gameOver()

		if bestPosX != -1:
			self.env.agTab[self.posX][self.posY] = None
			self.addToEnv(newPosX, newPosY)


from Simulateur.hunter.Avatar import Avatar
                        
                        
					
