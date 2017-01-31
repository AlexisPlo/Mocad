import math
import random
from sklearn import datasets
import numpy as np
import matplotlib.pyplot as plt
import util

res = []

for i in range(4000):
    res.append(random.randint(0,1))
    
util.toCsv("random.csv", res)