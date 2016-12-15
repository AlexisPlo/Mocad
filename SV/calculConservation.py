import numpy as np


lisB1 = np.array([1,0,1,1,1])
lisB2 = np.array([0,1,1,2,0])


for i in range(11):

	for j in range(11):

		res = np.add((i-5) * lisB1 , (j-5) * lisB2)
		for num in res:
			print(num)
		print("\n")