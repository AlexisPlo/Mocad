import math
import random
from sklearn import datasets
import numpy as np
import matplotlib.pyplot as plt


data_x = np.random.rand(100,2)
data_x = np.c_[data_x, np.ones(100)]

data_y = np.array([])

for i in range(100):
    inter = -0.5*data_x[i,0] + 0.75 - data_x[i,1]
    if inter <= 0:
        data_y = np.append(data_y,1)
    else:
        data_y = np.append(data_y,-1)
        
        
x_moins = np.array([data_x[i,:] for i in range(100) if data_y[i] == -1])
x_plus = np.array([data_x[i,:] for i in range(100) if data_y[i] == 1])



data_x_train = np.array([data_x[i,:] for i in range(80)])
data_y_train = np.array([data_y[i] for i in range(80)])

data_x_test = np.array([data_x[i+80,:] for i in range(20)])
data_y_test = np.array([data_y[i+80] for i in range(20)])


def ptrain(x_train, y_train):
        
    theta = np.random.random(3) 
    
    corrected = True
    
    while corrected:
        print('lol')
        corrected = False    
        for i in range(80):
            nonlin = np.sign(np.dot(theta.T, x_train[i,:]))
            if nonlin != y_train[i]:
                corrected = True
                theta = theta + np.dot(y_train[i], x_train[i,:])
                
    return theta
    




plt.plot(x_moins[:,0], x_moins[:,1], 'b.')
plt.plot(x_plus[:,0], x_plus[:,1], 'r.')

realtheta = ptrain(data_x_train, data_y_train)

print(realtheta)

xline = np.arange(0,1,0.1)
yline = -(realtheta[0] * xline + realtheta[2])/realtheta[1]

plt.plot(xline, yline, 'g-')

plt.show()