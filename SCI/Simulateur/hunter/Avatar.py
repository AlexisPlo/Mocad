import random

from Simulateur.core.Agent import Agent
from Simulateur.hunter.Pow import Pow



class Avatar(Agent):



	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "yellow", "circle")
		self.direction = "none"
		self.invincible = False
		self.invinCounter = 0



	def decide(self):

		if self.direction == "up":
			pasX = 0
			pasY = -1
		elif self.direction == "down":
			pasX = 0
			pasY = 1
		elif self.direction == "left":
			pasX = -1
			pasY = 0
		elif self.direction == "right":
			pasX = 1
			pasY = 0
		else:
			pasX = 0
			pasY = 0

		if self.invinCounter > 0:
			self.invinCounter -= 1
			if self.invinCounter == 0:
				self.invincible = False

		newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, pasX, pasY)

		if newPosX>=0 and newPosY >=0:
			thing = self.env.agTab[newPosX][newPosY]
			if thing is None:
				#If empty square, moving to new position
				self.env.agTab[self.posX][self.posY] = None
				self.addToEnv(newPosX, newPosY)
				self.dijkstraAlg()

			if isinstance(thing, Pow):
				thing.isEaten()
				self.invincible = True
				self.invinCounter = 5
				self.env.agTab[self.posX][self.posY] = None
				self.addToEnv(newPosX, newPosY)
				self.dijkstraAlg()

			elif isinstance(thing, Hunter):
				#If coliding a Hunter, launching the end of the game
				self.sma.gameOver()

			




	def setDirUp(self):
		self.direction = "up"

	def setDirDown(self):
		self.direction = "down"

	def setDirLeft(self):
		self.direction = "left"

	def setDirRight(self):
		self.direction = "right"


	#Using Dijkstra to spread distances to the Avatar around the environment
	def dijkstraAlg(self):
		toProcessTab = []
		toProcessTab.append((self.posX, self.posY))
		actualScore = 0

		self.env.resetDijkstra()

		while len(toProcessTab) > 0:
			
			newTab = []
			for pos in toProcessTab:

				self.env.dijkstraTab[pos[0]][pos[1]] = actualScore

				for i, j in [(-1,0), (1,0), (0,-1), (0,1)]:

					newPosX, newPosY = self.env.getNextCoord(pos[0], pos[1], i, j)
					if newPosX>=0 and newPosY>=0:
						thing = self.env.agTab[newPosX][newPosY]
						if not isinstance(thing, Avatar) and self.env.dijkstraTab[newPosX][newPosY] == -1:
							newTab.append((newPosX, newPosY))
							self.env.dijkstraTab[newPosX][newPosY] = -2

			actualScore += 1
			toProcessTab = newTab


from Simulateur.hunter.Hunter import Hunter