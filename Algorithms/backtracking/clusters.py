import sys

board = [
  ['0', '0', '0', '0', '0'],
  ['1', '0', '0', '0', '0'],
  ['1', '1', '0', '1', '0'],
  ['0', '1', '0', '1', '1'],
  ['1', '0', '0', '0', '0']
]

def printBoardIndexes():
  global board

  for r in range(0, len(board)):
    for c in range(0, len(board)):
      sys.stdout.write('(' + str(r) + ', ' + str(c) + ')')
    print

def findClustersHelper(

def findClusters(board):
  
