class Agent:

	def __init__(self, _env, _sma, _posX, _posY, _pasX, _pasY, _color):
		self.env = env

	def update(self):
		self.env.move(self, self.pasX, self.pasY)def decide(self, type):
