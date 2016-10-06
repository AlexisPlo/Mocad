

from Simulateur.core.SMA import SMA



class SMAHunter(SMA):


	def __init__(self, _env, _view, _schedul, _nbTicks, _tickTime):

		SMA.__init__(self, _env, _view, _schedul, _nbTicks, _tickTime)



	def gameOver(self):
		self.view.master.quit()