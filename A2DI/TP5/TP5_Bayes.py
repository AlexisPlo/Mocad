# -*- coding: utf-8 -*-
"""
Created on Wed Jan 11 15:30:30 2017

@author: pernet
"""

import math
import random
from sklearn import datasets
import numpy as np
import scipy as sc
import matplotlib.pyplot as plt

data = sc.io.loadmat('20news_w100.mat')
X=data["documents"].toarray()
c=data["newsgroups"][0]-1

n = np.shape(X)[1]
d = np.shape(X)[0]

n_class = 4


def kfold_data():
    