import random

from Simulateur.core.Agent import Agent


class Avatar(Agent):



	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "green", "circle")
		self.direction = "none"


	def decide(self):

		if self.direction == "up":
			pasX = 0
			pasY = 1
		elif self.direction == "down":
			pasX = 0
			pasY = -1
		elif self.direction == "left":
			pasX = -1
			pasY = 0
		elif self.direction == "right":
			pasX = 1
			pasY = 0
		else:
			pasX = 0
			pasY = 0

		newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, pasX, pasY)

		if newPosX>=0 and newPosY >=0:
			thing = self.env.agTab[newPosX][newPosY]
			if thing is None:
				#If empty square, moving to new position
				self.env.agTab[self.posX][self.posY] = None
				self.addToEnv(newPosX, newPosY)
				self.dijkstraAlg()

			elif isInstance(thing, Hunter):
				#If coliding a Hunter, launching the end of the game
				self.sma.gameover()

			




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
		toProcessTab.append(self.posX, self.posY)
		actualScore = 0

		while len(toProcessTab) > 0:
			newTab = []
			for pos in toProcessTab:

				newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, -1, 0)
				if newPosX>=0 and newPosY>=0:
					
