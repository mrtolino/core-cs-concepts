import sys

def printAllBinaryHelper(digits, output):
  if digits == 0:
    print output
  else:
    printAllBinaryHelper(digits - 1, output + "0")
    printAllBinaryHelper(digits - 1, output + "1")

    
def printAllBinary(digits):
  printAllBinaryHelper(digits, "")

printAllBinary(3)
