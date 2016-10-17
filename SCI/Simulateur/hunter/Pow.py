from Simulateur.core.Agent import Agent



class Pow(Agent):



	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "white", "circle")
		self.direction = "none"


	def isEaten(self):
		self.alive = False
		self.env.agTab[self.posX][self.posY] = None


	def decide(self):
		pass

	def drawOnCanvas(self, can, xmin, ymin, xmax, ymax):
		if self.shape == "circle":
			xperc = int((xmax - xmin)/4)
			yperc = int((ymax - ymin)/4)
			cir = can.create_oval(xmin+xperc,ymin+yperc, xmax-xperc,ymax-xperc, fill = self.color, tags = "agent")
			return cir