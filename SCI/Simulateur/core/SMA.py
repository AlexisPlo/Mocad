import random
import time
from Simulateur.core.Agent import Agent
from Simulateur.particles.Particle import Particle
from Simulateur.core.Environment import Environment

class SMA:


	def __init__(self, _env, _view, _schedul, _nbTicks):

		self.env = _env
		self.agList = []
		self.newList = []
		self.nbTicks = _nbTicks
		self.schedul = _schedul
		self.view = _view

	def addAgent(self, ag):
				
		self.agList.append(ag)

	def run(self):
		i = 0
		while(i<self.nbTicks or self.nbTicks == 0):
			# self.agList = self.newList
			# self.newList = []
			random.shuffle(self.agList)
			for ag in self.agList:
				ag.decide()
			# for ag in self.agList:
			# 	if ag.alive:
			# 		self.newList.append(ag)
			self.view.updateWidgets(self.env)
			self.view.update()
			time.sleep(0.1)
			i += 1