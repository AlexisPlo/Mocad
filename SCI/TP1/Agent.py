class Agent:

	def __init__(self, _env, _sma, _posX, _posY, _pasX, _pasY, _color):
		self.env = _env
		self.color = _color
		self.posX = _posX
		self.posY = _posY
		self.pasX = _pasX
		self.pasY = _pasY
		self.sma = _sma

	def update(self):
		self.decide()


	def decide(self):
		newPosX = self.posX + self.pasX
		newPosY = self.posY + self.pasY
		if((newPosX < 0 or newPosX >= self.env.gridsizeX) and (not self.env.tor) ):
			if(newPosY < 0 or newPosY >= self.env.gridsizeY):			
				self.action1()
			else:
				self.action2()
			return
		if((newPosY < 0 or newPosY >= self.env.gridsizeY) and (not self.env.tor) ):
			self.action3()
			return
		if self.env.tor:
			if newPosX < 0:
				newPosX = self.env.gridsizeX - 1
			if newPosX >= self.env.gridsizeX:
				newPosX = 0
			if newPosY < 0:
				newPosY = self.env.gridsizeY - 1
			if newPosY >= self.env.gridsizeY:
				newPosY = 0
		if self.env.see(newPosX, newPosY) is not None:
			self.action4(self.env.see(newPosX, newPosY))
			return
		else:
			self.action5(self.posX, self.posY, newPosX, newPosY)


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