import random

from Simulateur.core.Agent import Agent


class Hunter(Agent):



	def __init__(self, _env, _sma):

		Agent.__init__(self, _env, _sma, "black", "circle")