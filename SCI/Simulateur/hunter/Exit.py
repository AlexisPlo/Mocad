from Simulateur.core.Agent import Agent
import random


class Exit(Agent):


	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "magenta", "circle")
		


	def decide(self):
		pass

	def addWall(self):

		validPos = False
		while(not validPos):
			newX = random.randint(0, self.env.gridsizeX - 1)
			newY = random.randint(0, self.env.gridsizeY - 1)
			validPos = True
			if (self.env.agTab[newX][newY] is not None):
				validPos = False
			if(newX > 0 and self.env.agTab[newX-1][newY] is not None):
				validPos = False
			if(newX < self.env.gridsizeX - 1 and self.env.agTab[newX+1][newY] is not None):
				validPos = False
			if(newY > 0 and self.env.agTab[newX][newY-1] is not None):
				validPos = False
			if(newY < self.env.gridsizeY - 1 and self.env.agTab[newX][newY+1] is not None):
				validPos = False
		self.posX = newX
		self.posY = newY
		self.env.put(self, newX, newY)


	def drawOnCanvas(self, can, xmin, ymin, xmax, ymax):
		xperc = int((xmax - xmin)/4)
		yperc = int((ymax - ymin)/4)
		cir = can.create_rectangle(xmin+xperc,ymin+yperc, xmax-xperc,ymax-xperc, fill = self.color, tags = "agent")
		return cir
