import tkinter as tk

from Simulateur.core.View import View

class ViewHunter(View):


	def keyPressed(self, event):


		if(event.keysym == "Up"):
			self.av.setDirUp()
		elif(event.keysym == "Down"):
			self.av.setDirDown()
		elif(event.keysym == "Left"):
			self.av.setDirLeft()
		elif(event.keysym == "Right"):
			self.av.setDirRight()




	def __init__(self, _wid, _hei, master=None):

		View.__init__(self, _wid, _hei, master, "#207")
		self.focus_set()
		self.bind("<Key>", self.keyPressed)


	def setAvatar(self, _av):
		self.av = _av
