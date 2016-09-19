import random

from Simulateur.core.Agent import Agent


class Shark(Agent):



	def __init__(self, _env, _sma, _breedTime):

		Agent.__init__(self, _env, _sma, "green", "circle")
		self.fishBreedTime = _breedTime
		self.fishBreedCounter = 0

	def decide():
		