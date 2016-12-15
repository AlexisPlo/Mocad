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
            y = np.append(y,1)
        else:
            y = np.append(y,-1)
    
    x_train = np.array(x[0:int(n*0.1),:])
    y_train = np.array(y[0:int(n*0.1)])
    
    x_test = np.array(x[int(n*0.1):,:])
    y_test = np.array(y[int(n*0.1):])
    
    return x_train, x_test, y_train, y_test


def ptrain(x_train, y_train):
        
    theta = np.random.random(3) 
    
    corrected = True
    
    while corrected:
        corrected = False    
        for i in range(len(x_train)):
            nonlin = np.sign(np.dot(theta.T, x_train[i,:]))
            if nonlin != y_train[i]:
                corrected = True
                theta = theta + np.dot(y_train[i], x_train[i,:])
                
    return theta
    
def ptest(x, theta):
    return np.sign(np.dot(theta.T, x))
   
   
def get_test_err(x_train, x_test, y_train, y_test):
    theta = ptrain(x_train, y_train)
    errors = 0
    for i in range(len(x_test)):
        prediction = ptest(x_test[i,:],theta)
        if (prediction != y_test[i]):
            errors += 1
    return 100 * errors / len(y_test) 
    



data_x_train, data_x_test, data_y_train, data_y_test = datagen(445)


x_moins_train = np.array([data_x_train[i,:] for i in range(len(data_x_train)) if data_y_train[i] == -1])
x_plus_train = np.array([data_x_train[i,:] for i in range(len(data_x_train)) if data_y_train[i] == 1])

plt.plot(x_moins_train[:,0], x_moins_train[:,1], 'b.')
plt.plot(x_plus_train[:,0], x_plus_train[:,1], 'r.')

realtheta = ptrain(data_x_train, data_y_train)

print(realtheta)

xline = np.arange(0,1,0.1)
yline = -(realtheta[0] * xline + realtheta[2])/realtheta[1]

plt.plot(xline, yline, 'g-')

plt.figure()

x_moins_test = np.array([data_x_test[i,:] for i in range(len(data_x_test)) if data_y_test[i] == -1])
x_plus_test = np.array([data_x_test[i,:] for i in range(len(data_x_test)) if data_y_test[i] == 1])

plt.plot(x_moins_test[:,0], x_moins_test[:,1], 'b.')
plt.plot(x_plus_test[:,0], x_plus_test[:,1], 'r.')


xline = np.arange(0,1,0.1)
yline = -(realtheta[0] * xline + realtheta[2])/realtheta[1]

plt.plot(xline, yline, 'g-')



plt.figure()

errorTab = []

for i in range(10000):
    data_x_train, data_x_test, data_y_train, data_y_test = datagen(445)
    errorTab.append(get_test_err(data_x_train, data_x_test, data_y_train, data_y_test))

bins_perc = np.arange(0,20,0.5)
hist_perc, bins_perc = np.histogram(errorTab, bins=bins_perc)

plt.bar(bins_perc[:-1], hist_perc, 0.5, color = '#FC6FCB', edgecolor='#0CFA28')


plt.show()