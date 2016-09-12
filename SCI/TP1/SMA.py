from random import randint

class SMA:


	def __init__(self, gridSizeX, gridSizeY, _schedul, _nbTicks, nbParticles):
		self.env = Environment(gridSizeX, gridSizeY)
		self.agList = []
		self.nbTicks = nbTicks
		self.schedul = _schedul
		for i in range(nbParticles):
			newX = randint(0, gridSizeX - 1)
			newY = randint(0, gridSizeY - 1)
			while(self.env[newX][newY] is not None)

	def run(self):
		self.