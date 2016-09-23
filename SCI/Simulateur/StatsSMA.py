import re
import matplotlib.pyplot as plt


traceFile = open('watorTrace', 'r')

tickTab = []
nbFishTab = []
nbSharkTab = []
tick = 0

for line in traceFile:

	match = re.match(r"Tick (\d+) (\d+);", line)
	if match:
		totalAgent = int(match.group(1)) + int(match.group(2))
		nbFishTab.append(float(match.group(1)) / totalAgent)
		nbSharkTab.append(float(match.group(2)) / totalAgent)
		tickTab.append(tick)
		tick += 1


traceFile.close()

plt.plot(tickTab, nbFishTab, 'b-')
plt.plot(tickTab, nbSharkTab, 'r-')
plt.show()