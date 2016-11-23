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

plt.show()


#resdict = {}

# for i in range(1000):
# 	newval = tirage_x(1)
# 	if newval not in resdict:
# 		resdict[newval] = 1
# 	else:
# 		resdict[newval] += 1

# for k, v in resdict.iteritems():

# 	f.write(str(k) + " " + str(v)+"\n")


# print(resdict)
