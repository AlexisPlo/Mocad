class Environment:
	
	def __init__(self, _gridsizeX, _gridsizeY, _tor):
		self.gridsizeX = _gridsizeX
		self.gridsizeY = _gridsizeY
		self.agTab = [[None for i in range(_gridsizeY)] for j in range(_gridsizeX)]
		self.tor = _tor
		
	def display(self):
		for j in range(self.gridsizeY):
			line = ""
			for i in range(self.gridsizeX):
				if self.agTab[i][j] is not None:
					line = line + "O"
				else:
					line = line + "X"
			print(line)
		print()

	def isUsableNeighbour(self, posX, posY, hourlyPos):
		if self.tor:
			return True
		else:
			if (hourlyPos in [7,0,1]) and posY <= 0:
				return False
			elif (hourlyPos in [1,2,3]) and posX >= self.gridsizeX:
				return False
			elif (hourlyPos in [3,4,5]) and posY >= self.gridsizeY:
				return False
			elif (hourlyPos in [5,6,7]) and posX <= 0:
				return False
			else:
				return True


	def put(self, ag, posX, posY):
		if self.agTab[posX][posY] is None:
			self.agTab[posX][posY] = ag
		else:
			raise Exception("Overlapping with already present agent")

			
	def getNextCoord(self, posX, posY, pasX, pasY):


		if self.tor:

			newPosX = (posX + pasX + self.gridsizeX) % self.gridsizeX
			newPosY = (posY + pasY + self.gridsizeY) % self.gridsizeY

		else:

			newPosX = (posX + pasX)
			newPosY = (posY + pasY)
			if newPosX < 0 or newPosX >= self.gridsizeX:
				newPosX = -1
			if newPosY < 0 or newPosY >= self.gridsizeY:
				newPosY = -1


		return newPosX, newPosY