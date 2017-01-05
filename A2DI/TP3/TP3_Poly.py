import math
import random
from sklearn import datasets
import numpy as np
import matplotlib.pyplot as plt


allx = np.linspace(-10.0, 10.0, num=90)

ally = []

for x in allx:
    ally.append(np.random.normal(math.sin(x)/x, 0.05))
    
    
plt.plot(allx, ally, "r.")

X_train=[]
X_test=[]
Y_train=[]
Y_test=[]

i=0
for x in allx:
    if i%3==0:
        X_train.append(x)
    else:
        X_test.append(x)
    i += 1
    
i=0
for y in ally:
    if i%3==0:
        Y_train.append(y)
    else:
        Y_test.append(y)
    i += 1
    
    
#X_train = np.vstack((X_train, np.ones(len(X_train))))
#
#print(X_train)
#
#inter = np.dot(X_train, X_train.T)
#inter = np.linalg.inv(inter)
#inter = np.dot(inter, X_train)
#theta = np.dot(inter, Y_train)

#print(theta)
#
#xline = np.arange(0,5,0.1)
#yline = xline*theta[0] + theta[1]
#
#plt.plot(xline, yline)