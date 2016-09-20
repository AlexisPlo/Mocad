import random

from Simulateur.core.Agent import Agent

colors = ['black','red','blue','green','cyan', 'yellow', 'magenta']
		
colorIndex = 0

class Particle(Agent):



	def __init__(self, _env, _sma):

		global colors
		global colorIndex

		newColor = colors[colorIndex]
		colorIndex += 1
		if colorIndex >= len(colors):
			colorIndex = 0

		Agent.__init__(self, _env, _sma, newColor, "circle")

		dir = random.randint(0,7)
		self.pasX, self.pasY = Agent.mooreNeiStep[dir]



	def decide(self):
		newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY,self.pasX, self.pasY)
		if newPosX == -1:
			if newPosY == -1:
				self.demiTourXY()
			else:
				self.demiTourX()
		elif newPosY == -1:
			self.demiTourY()
		elif self.env.agTab[newPosX][newPosY] is not None:
			self.exchangeDir(self.env.agTab[newPosX][newPosY])
		else:
			self.move(self.posX, self.posY, newPosX, newPosY)


	def demiTourXY(self):
		self.pasX = -self.pasX
		self.pasY = -self.pasY

	def demiTourX(self):
		self.pasX = -self.pasX
		
	def demiTourY(self):
		self.pasY = -self.pasY

	def exchangeDir(self, ag):
		tempX = self.pasX
		tempY = self.pasY
		self.pasX = ag.pasX
		self.pasY = ag.pasY
		ag.pasX = tempX
		ag.pasY = tempY

	def move(self, oldX, oldY, newPosX, newPosY):
		self.env.agTab[oldX][oldY] = None
		self.env.put(self, newPosX, newPosY)
		self.posX = newPosX
		self.posY = newPosY