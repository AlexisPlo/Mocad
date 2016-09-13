import Tkinter as tk

class View(tk.Frame):

	def __init__(self, master=None):
		tk.Frame.__init__(self,master)
		self.grid()
		self.canvasTab = []


	def drawWidgets(self, env):
		for i in range(env.gridsizeX):
			tempTab = []
			for j in range(env.gridsizeY):
				c = tk.Canvas(self, width = 30, height = 30, borderwidth = 1)
				c.grid(column = i, row = j)
				tempTab.append(c)
			self.canvasTab.append(tempTab)

	def updateWidgets(self, env):
		for i in range(env.gridsizeX):
			for j in range(env.gridsizeY):
				self.canvasTab[i][j].delete(tk.ALL)
				if env.agTab[i][j] is not None:
					self.canvasTab[i][j].create_oval(2,2,28,28, fill = env.agTab[i][j].color)
				