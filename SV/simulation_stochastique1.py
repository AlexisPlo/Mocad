import random
import math
import matplotlib.pyplot as plt


def tirage_x(cab):
	n = random.random()
	logn = math.log(1/n)
	return ((logn/cab)) 



c1 = 10

A = 10
B = 0
nexttime = 0

reactTime = []
ATime= []
BTime = []

reactTime.append(0)
ATime.append(A)
BTime.append(B)



while (A > 0):
	a1 = A*c1
	nexttime = nexttime + tirage_x(a1)
	A -= 1
	B += 1
	reactTime.append(nexttime)
	ATime.append(A)
	BTime.append(B)

plt.plot(reactTime, ATime, label='#A')
plt.plot(reactTime, BTime, label='#B')
plt.legend()

plt.figure()



c1 = 10

A = 100
B = 0
nexttime = 0

reactTime = []
ATime= []
BTime = []

reactTime.append(0)
ATime.append(A)
BTime.append(B)



while (A > 0):
	a1 = A*c1
	nexttime = nexttime + tirage_x(a1)
	A -= 1
	B += 1
	reactTime.append(nexttime)
	ATime.append(A)
	BTime.append(B)

plt.plot(reactTime, ATime, label='#A')
plt.plot(reactTime, BTime, label='#B')
plt.legend()

plt.draw()
plt.figure()


c1 = 10

A = 1000
B = 0
nexttime = 0

reactTime = []
ATime= []
BTime = []

reactTime.append(0)
ATime.append(A)
BTime.append(B)



while (A > 0):
	a1 = A*c1
	nexttime = nexttime + tirage_x(a1)
	A -= 1
	B += 1
	reactTime.append(nexttime)
	ATime.append(A)
	BTime.append(B)

plt.plot(reactTime, ATime, label='#A')
plt.plot(reactTime, BTime, label='#B')
plt.legend()

plt.show()