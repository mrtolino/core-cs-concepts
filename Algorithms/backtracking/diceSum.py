import sys
import numpy as np

calls = 0

def diceSumHelper(numDice, desiredSum, chosen):
  global calls
  calls += 1

  if numDice == 0:
    return
  else:  
    for i in range(1, 7):
      #choose i
      chosen.append(i)

      #explore
      if numDice == 1:
        if desiredSum - i == 0:
          print chosen
      else:
        diceSumHelper(numDice-1, desiredSum - i, chosen)

      #unchoose i
      chosen.pop()

def diceSum(numDice, desiredSum):
  diceSumHelper(numDice, desiredSum, [])

diceSum(4,11)
print "Total function calls: " + str(calls)
