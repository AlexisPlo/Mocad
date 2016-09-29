import random

from Simulateur.core.Agent import Agent


class Avatar(Agent):



	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "magenta", "circle")
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

	def setDirUp(self):
		self.direction = "up"

	def setDirDown(self):
		self.direction = "down"

	def setDirLeft(self):
		self.direction = "left"

	def setDirRight(self):
		self.direction = "right"