import random
import math
import matplotlib.pyplot as plt


def tirage_x(cab):
	n = random.random()
	logn = math.log(1/n)
	return ((logn/cab)) 


f = open("resfile","w")

lis = []

for i in range(10000):
	#f.write(str(i) = "\n")
	lis.append(tirage_x(1))



n, bins, patches = plt.hist(lis, bins = 100)

plt.draw()

plt.figure()

lis = []

for i in range(10000):
	#f.write(str(i) = "\n")
	lis.append(tirage_x(10))



n, bins, patches = plt.hist(lis, bins = 100)

plt.draw()

plt.figure()


lis = []

for i in range(10000):
	#f.write(str(i) = "\n")
	lis.append(tirage_x(100))



n, bins, patches = plt.hist(lis, bins = 100)

plt.show()
