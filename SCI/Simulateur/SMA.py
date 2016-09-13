import random
import time
from Environment import Environment
from Agent import Agent

class SMA:


	def __init__(self, gridSizeX, gridSizeY, _schedul, _nbTicks, nbParticles, _tor, _view):
		colors=['black','red','blue','green','cyan', 'yellow', 'magenta']
		colorIndex = 0
		self.env = Environment(gridSizeX, gridSizeY, _tor)
		self.agList = []
		self.nbTicks = _nbTicks
		self.schedul = _schedul
		self.view = _view
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
				
			newColor = colors[colorIndex]
			colorIndex += 1
			if colorIndex >= len(colors):
				colorIndex = 0

			newAg = Agent(self.env, self, newX, newY, pasX, pasY, newColor)
			self.agList.append(newAg)
			self.env.agTab[newX][newY] = newAg

	def run(self):
		for i in range(self.nbTicks):
			random.shuffle(self.agList)
			for ag in self.agList:
				ag.update()
			self.view.updateWidgets(self.env)
			self.view.update()
			time.sleep(1)
			