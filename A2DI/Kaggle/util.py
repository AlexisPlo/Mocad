def toCsv(filename, res):
    f = open(filename, 'w')

    f.write('# Id,#Class\n')
    
    for i in range(4000):
        f.write(str(i) + "," + str(int(res[i])) + "\n")
        
    f.close()