import math
import random
from sklearn import datasets
import numpy as np
import matplotlib.pyplot as plt


taille_h = np.loadtxt("taille_h.txt")
taille_f = np.loadtxt("taille_f.txt")

bins_all = np.arange(150) + 100


(dec_h, bins_h) = np.histogram(taille_h, bins=bins_all)
dec_h = dec_h *(1/np.shape(taille_h)[0])
plt.bar(bins_h[:-1], dec_h)

plt.figure()

(dec_f, bins_f) = np.histogram(taille_f, bins=bins_all)
dec_f = dec_f * (1/ np.shape(taille_f)[0])
plt.bar(bins_f[:-1], dec_f)

plt.figure()

px2h = 0.505
px2f = 0.495



lmargemp = px2h * dec_h + px2f * dec_f

plt.bar(bins_all[:-1], lmargemp)


plt.figure()






plt.show()