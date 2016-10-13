import tkinter as tk

class View(tk.Frame):



	def __init__(self, _wid, _hei, master=None, colour="cyan"):
		tk.Frame.__init__(self,master)
		self.grid()
		self.rectangleTab = []
		self.containsAgentTab = []
		self.wid = _wid
		self.hei = _hei
		self.col = colour



	def drawWidgets(self, env):
		self.can = tk.Canvas(self, width =  (self.wid+ 1) * env.gridsizeX , height = (self.hei + 1) * env.gridsizeY, borderwidth = 0)
		for i in range(env.gridsizeX):
			tempTab = []
			for j in range(env.gridsizeY):
				rect = self.can.create_rectangle(i*(self.wid+1),j*(self.hei+1),i*(self.wid+1)+ self.wid,j*(self.hei+1)+self.hei,fill=self.col)
				tempTab.append(rect)
			self.rectangleTab.append(tempTab)
			self.containsAgentTab = [[False for j in range(env.gridsizeY)] for i in range(env.gridsizeX)]
		self.can.grid()

	def updateWidgets(self, env):
		self.can.delete("agent")
		for i in range(env.gridsizeX):
			for j in range(env.gridsizeY):
				if env.agTab[i][j] is not None:
					env.agTab[i][j].drawOnCanvas(self.can, i*(self.wid+1) +1,j*(self.hei+1)+1,i*(self.wid+1)+ self.wid -1,j*(self.hei+1)+self.hei-1)



