import sys

#board = [
  #['', '', '', '', '', '', '', ''],
  #['', '', '', '', '', '', '', ''],
  #['', '', '', '', '', '', '', ''],
  #['', '', '', '', '', '', '', ''],
  #['', '', '', '', '', '', '', ''],
  #['', '', '', '', '', '', '', ''],
  #['', '', '', '', '', '', '', ''],
  #['', '', '', '', '', '', '', '']
#]

def isSafe(row, col, board):
  #global board

  #check column
  for i in range(0, len(board)):
    if board[i][col] == 'Q':
      return False

  #check diagonal toward top-left
  #print "toward top-left"
  for i, j in zip(range(row, -1, -1), range(col, -1, -1)):
    #print "(" + str(i) + ", " + str(j) + ")"
    if board[i][j] == 'Q':
      return False

  #check diagonal toward bottom-right
  #print "toward bottom-right"
  for i, j in zip(range(row, len(board)), range(col, len(board))):
    #print "(" + str(i) + ", " + str(j) + ")"
    if board[i][j] == 'Q':
      return False

  #check diagonal toward bottom-left
  #print "toward bottom-left"
  for i, j in zip(range(row, len(board)), range(col, -1, -1)):
    #print "(" + str(i) + ", " + str(j) + ")"
    if board[i][j] == 'Q':
      return False
  
  #check diagonal toward top-right
  #print "toward top-right"
  for i, j in zip(range(row, -1, -1), range(col, len(board))):
    #print "(" + str(i) + ", " + str(j) + ")"
    if board[i][j] == 'Q':
      return False

  return True


def place(row, col, board):
  #global board

  board[row][col] = 'Q'

def remove(row, col, board):
  #global board

  board[row][col] = '.'

def printBoard(board):
  #global board

  for row in board:
    print row

def printBoardIndexes(n):
  for row in range(0, n):
    for col in range(0, n):
      sys.stdout.write("(" + str(row) + ", " + str(col) + ") ")
    print

def isFull(board):
  countQueens = 0

  for r in range(0, len(board)-1):
    for c in range(0, len(board)-1):
      if board[r][c] == 'Q':
        countQueens += 1

  if countQueens == 8:
    return True
  else:
    return False


def solveQueens(board):
  solveQueensHelper(board, 0)

def solveQueensHelper(board, currentRow):
  if currentRow >= len(board):
    printBoard(board)
    return True
    print
  else:
    for col in range(0, len(board)):   
      if (isSafe(currentRow, col, board)):
        
        #choose a column
        place(currentRow, col, board)

        #explore
        if solveQueensHelper(board, currentRow+1):
          return True
        
        #un-choose
        remove(currentRow, col, board)
    
    return False

def createBoard(n):
  board = []

  for i in range(0, n):
    board.append([])

    for j in range(0, n):
      board[len(board)-1].append('.')

  return board

if len(sys.argv) != 2:
  print 'Please provide a single integer argument, n'
else:
  solveQueens(createBoard(int(sys.argv[1])))



