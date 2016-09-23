import random
import time
from Simulateur.core.Agent import Agent
from Simulateur.core.Environment import Environment
import cProfile

class SMA:


	def __init__(self, _env, _view, _schedul, _nbTicks, _tickTime):

		self.env = _env
		self.agList = []
		self.newList = []
		self.nbTicks = _nbTicks
		self.schedul = _schedul
		self.view = _view
		self.tickTime = _tickTime
		self.traceFile = open('watorTrace', 'w')

	def addAgent(self, ag):
				
		self.newList.append(ag)

	def run(self):
		i = 0
		while(i<self.nbTicks or self.nbTicks == 0):
			self.agList = self.newList
			self.writeTickLine()
			self.newList = []
			random.shuffle(self.agList)
			for ag in self.agList:
				if ag.alive:
					ag.decide()
			for ag in self.agList:
				if ag.alive:
					self.newList.append(ag)

			self.view.updateWidgets(self.env)
			self.view.update()
			time.sleep(self.tickTime)
			i += 1


	def writeTickLine(self):
		print("Should not arrive here")

	#Deactivated for now; not used and makes too large trace
	
	def writeAgentLine(self, message):
		pass

		#self.traceFile.write("Agent " + message + ";\n")