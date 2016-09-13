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

	def put(self, ag, posX, posY):
		if self.agTab[posX][posY] is None:
			self.agTab[posX][posY] = ag
		else:
			

			
	def see(self, posX, posY):
		return self.agTab[posX][posY]