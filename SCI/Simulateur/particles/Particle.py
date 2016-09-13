import Simulateur.core.agent

class Particle(Agent):


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