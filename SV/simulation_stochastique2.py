import random
import math
import matplotlib.pyplot as plt


def tirage_x(cab):
	n = random.random()
	logn = math.log(1/n)
	return ((logn/cab)) 



c1 = 3.3
c2 = 3.3
c3 = 3.3

A = 100
B = 100
C = 100
nexttime = 0

reactTime = []
ATime= []
BTime = []
CTime = []

reactTime.append(0)
ATime.append(A)
BTime.append(B)
CTime.append(C)



while (A > 0 and B > 0) or (B > 0 and C > 0) or (C > 0 and A > 0):
	a1 = A * B * c1
	a2 = B * C * c2
	a3 = C * A * c3
	nexttime = nexttime + tirage_x(a1+a2+a3)

	tirage_react = random.random()

	if tirage_react < a1/(a1+a2+a3):
		A -= 1
	elif tirage_react < (a1+a2)/(a1+a2+a3):
		B -= 1
	else:
		C -= 1
	reactTime.append(nexttime)
	ATime.append(A)
	BTime.append(B)
	CTime.append(C)

plt.plot(reactTime, ATime, label="#A")
plt.plot(reactTime, BTime, label="#B")
plt.plot(reactTime, CTime, label="#C")
plt.legend()

plt.figure()


c1 = 6
c2 = 3
c3 = 1

A = 100
B = 100
C = 100
nexttime = 0

reactTime = []
ATime= []
BTime = []
CTime = []

reactTime.append(0)
ATime.append(A)
BTime.append(B)
CTime.append(C)



while (A > 0 and B > 0) or (B > 0 and C > 0) or (C > 0 and A > 0):
	a1 = A * B * c1
	a2 = B * C * c2
	a3 = C * A * c3
	nexttime = nexttime + tirage_x(a1+a2+a3)

	tirage_react = random.random()

	if tirage_react < a1/(a1+a2+a3):
		A -= 1
	elif tirage_react < (a1+a2)/(a1+a2+a3):
		B -= 1
	else:
		C -= 1
	reactTime.append(nexttime)
	ATime.append(A)
	BTime.append(B)
	CTime.append(C)

plt.plot(reactTime, ATime, label="#A")
plt.plot(reactTime, BTime, label="#B")
plt.plot(reactTime, CTime, label="#C")
plt.legend()

plt.figure()


c1 = 4
c2 = 4
c3 = 2

A = 100
B = 100
C = 100
nexttime = 0

reactTime = []
ATime= []
BTime = []
CTime = []

reactTime.append(0)
ATime.append(A)
BTime.append(B)
CTime.append(C)



while (A > 0 and B > 0) or (B > 0 and C > 0) or (C > 0 and A > 0):
	a1 = A * B * c1
	a2 = B * C * c2
	a3 = C * A * c3
	nexttime = nexttime + tirage_x(a1+a2+a3)

	tirage_react = random.random()

	if tirage_react < a1/(a1+a2+a3):
		A -= 1
	elif tirage_react < (a1+a2)/(a1+a2+a3):
		B -= 1
	else:
		C -= 1
	reactTime.append(nexttime)
	ATime.append(A)
	BTime.append(B)
	CTime.append(C)

plt.plot(reactTime, ATime, label="#A")
plt.plot(reactTime, BTime, label="#B")
plt.plot(reactTime, CTime, label="#C")
plt.legend()

plt.show()