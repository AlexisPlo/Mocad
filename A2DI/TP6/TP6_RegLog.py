import math
import random
from sklearn import datasets
import numpy as np
import matplotlib.pyplot as plt


def datagen(n):
    
    x = np.random.rand(n,2)
    x = np.c_[x, np.ones(n)]
    
    y = np.array([])
    
    for i in range(n):
        inter = -0.5*x[i,0] + 0.75 - x[i,1]
        if inter <= 0:
            newy = 1
        else:
            newy = 0
        distdroite = math.fabs(inter) / math.sqrt(1.25)
        minitheta = math.exp(-math.pow(distdroite,2) / (2*math.pow(0.05,2)))
        if(random.random()<minitheta/2):
            newy = -newy
        y = np.append(y,newy)
    
    x_train = np.array(x[0:int(n*0.2),:])
    y_train = np.array(y[0:int(n*0.2)])
    
    x_test = np.array(x[int(n*0.2):,:])
    y_test = np.array(y[int(n*0.2):])
    
    return x_train, x_test, y_train, y_test
    
    
data_x_train, data_x_test, data_y_train, data_y_test = datagen(300)
    
    
x_moins_test = np.array([data_x_test[i,:] for i in range(len(data_x_test)) if data_y_test[i] == 0])
x_plus_test = np.array([data_x_test[i,:] for i in range(len(data_x_test)) if data_y_test[i] == 1])

plt.plot(x_moins_test[:,0], x_moins_test[:,1], 'b.')
plt.plot(x_plus_test[:,0], x_plus_test[:,1], 'r.')