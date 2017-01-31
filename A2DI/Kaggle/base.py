import math
import random
from sklearn import neighbors
from sklearn import svm
import numpy as np
import matplotlib.pyplot as plt
import h5py as h5



trainfile = h5.File('/home/m2mocad/pernet/Bureau/kaggle_lille1_2017_train.save')
testfile = h5.File('/home/m2mocad/pernet/Bureau/kaggle_lille1_2017_test.save')

i=10

xTrain = trainfile['dataset_1']
yTrain = trainfile['labels']

xTest = testfile['dataset_1']


print(np.shape(xTrain))
print(np.shape(yTrain))

print(np.shape(xTest))

model = neighbors.KNeighborsClassifier()

model.fit(trainfile['dataset_1'], trainfile['labels'])

print("lol")

res = model.predict(testfile['dataset_1'])


f = open('cheat.csv', 'w')

f.write('# Id,#Class\n')

for i in range(4000):
    f.write(str(i) + "," + str(res[i]) + "\n")
    
f.close()
    
#np.savetxt('cheat.csv', res, fmt=, header='Id,#Class')