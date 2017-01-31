import math
import random
from sklearn import neighbors
from sklearn import svm
import numpy as np
import matplotlib.pyplot as plt
import h5py as h5
import util



trainfile = h5.File('/home/m2mocad/pernet/Bureau/kaggle_lille1_2017_train.save')
testfile = h5.File('/home/m2mocad/pernet/Bureau/kaggle_lille1_2017_test.save')

i=10

xTrain = trainfile['dataset_1']
yTrain = trainfile['labels']

xTest = testfile['dataset_1']

for i in range(kfold):
    xFold = xTrain[i*kfold:i+1*kfold-1,:]
    yFold = yTrain[i*kfold:i+1*kfold-1]
    model.fit(xFold)
    


print(np.shape(xTrain))
print(np.shape(yTrain))

print(np.shape(xTest))

model = svm.LinearSVC()

model.fit(trainfile['dataset_1'], trainfile['labels'])

print("lol")

res = model.predict(testfile['dataset_1'])

util.toCsv("resSVM.csv", res)
