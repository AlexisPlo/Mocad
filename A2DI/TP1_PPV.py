import math
from sklearn import datasets
import numpy as np


data = datasets.load_iris()

nbdata = data.data.shape[0]



print(data.data.shape)
print(np.array(data.target).shape)

fulldata = np.c_[data.data, data.target]

print(fulldata.shape)

np.random.shuffle(fulldata)

x_full = fulldata[:,:-1]
y_full = fulldata[:,-1]




x_learn = x_full[0:int(nbdata/2),:]
x_test = x_full[int(nbdata/2):,:]

y_learn = y_full[0:int(nbdata/2)]
y_test = y_full[int(nbdata/2):]

def distance(x, y):
    dim = len(x)
    if len(y) == dim:
        res = 0
        for i in range(dim):
            res = res + math.pow(x[i] - y[i],2)
        res = math.sqrt(res)
        return res
    else:
        return -1



def kppv(newx, learnx, learny, k):
    learnsize = len(learny)
    disttab = []
    for i in range(learnsize):
        disttab.append(np.linalg.norm(newx - learnx[i,:]))
    print(disttab)
    bestindex = np.argsort(disttab)
    print(learny)
    print(bestindex)
    neitargets = []
    for i in range(k):
        neitargets.append(learny[bestindex[i]])
    print(neitargets)
    classcount = np.bincount(neitargets)
    chosenclass = np.argmax(classcount)
    return chosenclass
    
print(kppv(x_test[71,:], x_learn, y_learn, 7))
    
        
    