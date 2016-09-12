class Environment:
    
	def __init__(self, _gridsizeX, _gridsizeY, _tor):
        self.agTab = [[None for i in _gridsizeY] for i in _gridsizeX]
        self.tor = _tor