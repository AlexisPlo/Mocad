import random

from Simulateur.core.Agent import Agent

class Shark(Agent):



	def __init__(self, _env, _sma, _breedTime, _starveTime):

		Agent.__init__(self, _env, _sma, "magenta", "circle")
		self.sharkBreedTime = _breedTime
		self.sharkBreedCounter = 0
		self.sharkStarveTime = _starveTime
		self.sharkStarveCounter = _starveTime

	def decide():

		self.color = "red"
		
		#Updating breeding counter
		
		self.sharkBreedCounter += 1
		if self.sharkBreedCounter > self.sharkBreedTime:
			self.sharkBreedCounter = self.sharkBreedTime
		self.sharkStarveCounter -= 1

		#Scanning Moore neighbourhood

		freeSpotDirection = []
		fishSpotDirection = []

		for(direction in range(8)){
			pasX, pasY = mooreNeiStep[direction]
			newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, self.pasX, self.pasY)
			if newPosX>=0 and newPosY >=0:
				thing = self.env.agTab[newPosX][newPosY]
				if thing is None:
					freeSpotDirection.append(direction)
				elif isinstance(thing, Fish):
					fishSpotDirection.append(direction)
		}

		moved = False
		oldPosX = self.posX
		oldPosY = self.posY

		if len(fishSpotDirection) > 0:

			#Eating

			pasX, pasY = mooreNeiStep[random.randint(0, len(freeSpotDirection) - 1)]
			newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, self.pasX, self.pasY)

			gonnaDieFish = self.env.agTab[newPosX][newPosY]
			gonnaDieFish.alive = False
			self.env.agTab[newPosX][newPosY] = None

			self.move(newPosX, newPosY)

			self.sharkStarveCounter = self.sharkStarveTime
			moved = True

		elif sharkStarveCounter <= 0:

			#Dying

			self.alive = False
			self.env.agTab[self.posX][self.posY] = None





		elif len(freeSpotDirection) > 0:

			#Moving
			
			pasX, pasY = mooreNeiStep[random.randint(0, len(freeSpotDirection) - 1)]
			newPosX, newPosY = self.env.getNextCoord(self.posX, self.posY, self.pasX, self.pasY)
		

			self.move(newPosX, newPosY)

			moved = True

		if moved and (self.sharkBreedCounter >= self.sharkBreedTime):
			self.createOffspring(oldPosX, oldPosY)


	def move(self, newPosX, newPosY):
		self.env.agTab[self.posX, self.posY] = None
		self.addToEnv(newPosX, newPosY)




	def createOffSpring(self, posX, posY):
		self.sharkBreedCounter = 0
		newFish = Fish(self.env, self.sma, self.breedTime)
		newFish.addToEnv(posX, posY)
