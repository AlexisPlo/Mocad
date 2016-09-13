class Agent:

	def __init__(self, _env, _sma, _posX, _posY, _color):
		self.env = _env
		self.color = _color
		self.posX = _posX
		self.posY = _posY
		self.pasX = _pasX
		self.pasY = _pasY
		self.sma = _sma

	def update(self):
		self.decide()





	def action1(self):
		self.pasX = -self.pasX
		self.pasY = -self.pasY

	def action2(self):
		self.pasX = -self.pasX
		
	def action3(self):
		self.pasY = -self.pasY

	def action4(self, ag):
		tempX = self.pasX
		tempY = self.pasY
		self.pasX = ag.pasX
		self.pasY = ag.pasY
		ag.pasX = tempX
		ag.pasY = tempY

	def action5(self, oldX, oldY, newPosX, newPosY):
		self.env.agTab[oldX][oldY] = None
		self.env.agTab[newPosX][newPosY] = self
		self.posX = newPosX
		self.posY = newPosY