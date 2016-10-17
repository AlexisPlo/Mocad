import sys

from Simulateur.core.SMA import SMA



class SMAHunter(SMA):


	def __init__(self, _env, _view, _schedul, _nbTicks, _tickTime):

		SMA.__init__(self, _env, _view, _schedul, _nbTicks, _tickTime)



	def gameOver(self):
		print("YOU LOSE!")
		sys.exit()
		
	def gameWon(self):
		print("YOU WIN!")
		sys.exit()