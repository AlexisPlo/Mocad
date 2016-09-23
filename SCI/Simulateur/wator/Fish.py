import random

from Simulateur.core.Agent import Agent


class Fish(Agent):



	def __init__(self, _env, _sma, _breedTime):

		Agent.__init__(self, _env, _sma, "green", "circle")
		self.fishBreedTime = _breedTime
		self.fishBreedCounter = 0

	def decide(self):

		self.color = "blue"
		
		#Updating breeding counter
		
		self.fishBreedCounter += 1
		if self.fishBreedCounter > self.fishBreedTime:
			self.fishBreedCounter = self.fishBreedTime

		#Scanning Moore neighbourhood

		freeSpotDirection = []

		for direction in range(8):
			pasX, pasY = Agent.mooreNeiStep[direction]
			newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, pasX, pasY)
			if newPosX>=0 and newPosY>=0:
				thing = self.env.agTab[newPosX][newPosY]
				if thing is None:
					freeSpotDirection.append(direction)


		if len(freeSpotDirection) > 0:

			#Moving

			pasX, pasY = Agent.mooreNeiStep[freeSpotDirection[random.randint(0, len(freeSpotDirection) - 1)]]
			newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, pasX, pasY)
			
			oldPosX = self.posX
			oldPosY = self.posY

			self.move(newPosX, newPosY)

			if(self.fishBreedCounter >= self.fishBreedTime):

				#Breeding

				self.createOffspring(oldPosX, oldPosY)


	def move(self, newPosX, newPosY):
		self.env.agTab[self.posX][self.posY] = None
		self.addToEnv(newPosX, newPosY)




	def createOffspring(self, posX, posY):
		self.fishBreedCounter = 0
		newFish = Fish(self.env, self.sma, self.fishBreedTime)
		newFish.addToEnv(posX, posY)
		self.sma.writeAgentLine("Born Fish")