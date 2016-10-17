from Simulateur.core.Agent import Agent
import random


class Hunter(Agent):


	def __init__(self, _env, _sma, _ava):

		Agent.__init__(self, _env, _sma, "red", "circle")
		self.ava = _ava
		


	def decide(self):

		bestPosX = -1
		bestPosY = -1
		bestDist = -1
		
		if self.ava.invincible:
			self.color = "green"
		else:
			self.color = "red"

		for i, j in [(-1,0), (1,0), (0,-1), (0,1)]:

			newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, i, j)
			if newPosX>=0 and newPosY>=0:
				thing = self.env.agTab[newPosX][newPosY]
				if thing is None:
					distance = self.env.dijkstraTab[newPosX][newPosY]
					if (not self.ava.invincible and distance < bestDist) or (self.ava.invincible and distance > bestDist) or bestDist == -1:
						bestDist = distance
						bestPosX = newPosX
						bestPosY = newPosY
					elif distance == bestDist:
						if random.randint(0,1) == 0:
							bestDist = distance
							bestPosX = newPosX
							bestPosY = newPosY
				elif isinstance(thing, Avatar) and not self.ava.invincible:
					self.sma.gameOver()

		if bestPosX != -1:
			self.env.agTab[self.posX][self.posY] = None
			self.addToEnv(bestPosX, bestPosY)
			
	def die(self):
		self.alive = False
		self.env.agTab[self.posX][self.posY] = None


from Simulateur.hunter.Avatar import Avatar

					
