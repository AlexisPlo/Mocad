import random

from Simulateur.core.Agent import Agent

class Shark(Agent):



	def __init__(self, _env, _sma, _breedTime, _starveTime):

		Agent.__init__(self, _env, _sma, "magenta", "square")
		self.sharkBreedTime = _breedTime
		self.sharkBreedCounter = 0
		self.sharkStarveTime = _starveTime
		self.sharkStarveCounter = 0

	def decide():

