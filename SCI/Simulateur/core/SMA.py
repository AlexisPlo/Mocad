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
		self.actualTick = 0
		self.schedul = _schedul
		self.view = _view
		self.tickTime = _tickTime
		self.traceFile = open('watorTrace', 'w')

	def addAgent(self, ag):
				
		self.newList.append(ag)

	def runStep(self):
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
		
		self.actualTick += 1

		if(self.actualTick<self.nbTicks or self.nbTicks == 0):
			self.view.after(self.tickTime, self.runStep)
		else:
			self.view.master.quit()

	def writeTickLine(self):
		#print("Should not arrive here")
		pass

	#Deactivated for now; not used and makes too large trace
	
	def writeAgentLine(self, message):
		pass

		#self.traceFile.write("Agent " + message + ";\n")