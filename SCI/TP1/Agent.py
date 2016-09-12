class Agent:

	def __init__(self, _env, _sma, _posX, _posY, _pasX, _pasY, _color):
		self.env = env
		self.color = _color
		self.posX = _posX
		self.posY = _posY
		self.pasX = _pasX
		self.pasY = _pasY
		self.sma = _sma

	def update(self):
		
		self.env.move(self, self.pasX, self.pasY)


	def decide(self):
		newPosX = self.posX + self.pasX
		if((newPosX < 0 or newPosX >= self.env.sizeX) and (not self.env.tor) ):
			self.action1()
			return
		newPosY = self.posY + self.pasY
		if((newPosY < 0 or newPosY >= self.env.sizeY) and (not self.env.tor) ):
			self.action2()
			return
		if self.env.tor:
			if newPosX < 0:
				newPosX = self.env.sizeX - 1
			if newPosX >= self.env.sizeX:
				newPosX = 0
			if newPosY < 0:
				newPosY = self.env.sizeY - 1
			if newPosY >= self.env.sizeY:
				newPosY = 0
		if self.env.see(newPosX, newPosY) is not None:
			self.action3(self.env.see(newPosX, newPosY))
			return
		else:
			self.action4(newPosX, newPosY)


	def action1(self):
		self.pasX = -self.pasX

	def action2(self):
		self.pasY = -self.pasY

	def action3(self, ag):
		tempX = self.pasX
		tempY = self.pasY
		self.pasX = ag.pasX
		sef.pasY = ag.pasY
		ag.pasX = tempX
		ag.pasY = tempY

	def action4(self, oldX, oldY, newPosX, newPosY):
		self.env.agTab[oldX, oldY] = None
		self.env.agTab[newPosX, newPosY] = self