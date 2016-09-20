import random

from Simulateur.core.Environment import Environment



class Agent:

	mooreNeiStep = [(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1),(-1,0),(-1,1)]

	def __init__(self, _env, _sma, _color, _shape):
		self.env = _env
		self.color = _color
		self.sma = _sma
		self.shape = _shape
		self.alive = True
		self.sma.addAgent(self)

	def addRandomToEnv(self):
		newX = random.randint(0, self.env.gridsizeX - 1)
		newY = random.randint(0, self.env.gridsizeY - 1)
		while(self.env.agTab[newX][newY] is not None):
			newX = random.randint(0, self.env.gridsizeX - 1)
			newY = random.randint(0, self.env.gridsizeY - 1)
		self.posX = newX
		self.posY = newY
		self.env.put(self, newX, newY)

	def addToEnv(self, _posX, _posY):
		self.env.put(self, _posX, _posY)
		self.posX = _posX
		self.posY = _posY


	def drawOnCanvas(self, can):
		if self.shape == "circle":
			can.create_oval(2,2, 9,9, fill = self.color)

