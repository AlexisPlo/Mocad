import random
from Environment import Environment
from Agent import Agent

class SMA:


	def __init__(self, gridSizeX, gridSizeY, _schedul, _nbTicks, nbParticles):
		self.env = Environment(gridSizeX, gridSizeY, False)
		self.agList = []
		self.nbTicks = _nbTicks
		self.schedul = _schedul
		for i in range(nbParticles):
			newX = random.randint(0, gridSizeX - 1)
			newY = random.randint(0, gridSizeY - 1)
			while(self.env.agTab[newX][newY] is not None):
				newX = random.randint(0, gridSizeX - 1)
				newY = random.randint(0, gridSizeY - 1)
			dir = random.randint(0,7)
			if dir == 0:
				pasX = 1
				pasY = 1
			elif dir == 1:
				pasX = 1
				pasY = 0
			elif dir == 2:
				pasX = 1
				pasY = -1
			elif dir == 3:
				pasX = 0
				pasY = -1
			elif dir == 4:
				pasX = -1
				pasY = -1
			elif dir == 5:
				pasX = -1 
				pasY = 0
			elif dir == 6:
				pasX = -1
				pasY = 1
			elif dir == 7:
				pasX = 0
				pasY = 1
				
			newAg = Agent(self.env, self, newX, newY, pasX, pasY, 0)
			self.agList.append(newAg)
			self.env.agTab[newX][newY] = newAg

	def run(self):
		for i in range(self.nbTicks):
			random.shuffle(self.agList)
			for ag in self.agList:
				ag.update()
				print(ag.posX)
				print(ag.posY)
				print(ag.pasX)
				print(ag.pasY)
			self.env.display()
			