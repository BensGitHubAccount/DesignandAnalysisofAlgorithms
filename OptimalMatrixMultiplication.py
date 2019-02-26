# -*- coding: utf-8 -*-
"""
Created on Tue Feb 26 08:34:34 2019

@author: Benjamin Craver
"""

import numpy as np 

np.random.seed(7)

numArrays = 100
p = np.random.randint(1,20,numArrays)

#A = []
#for i in range(1,len(p)):
#    A.append(np.random.randint(1,100,(p[i-1],p[i])))

costs = np.ones((numArrays,numArrays))
costs = costs*np.inf

for i in range(numArrays):
    costs[i,i] = 0
for leng in range(2,numArrays+1):
    for start in range(numArrays - leng + 1):
        end = start + leng - 1
        vals = []    
        for k in range(start, end):
            vals.append(costs[start, k] + costs[k+1, end] + (p[start-1] * p[k] * p[end]))     
        costs[start, end] = min(vals)        
             
print('min cost is: ' + str(costs[0,end]))
