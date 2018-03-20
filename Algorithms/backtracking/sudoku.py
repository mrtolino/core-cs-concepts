import sys

board = [
  ['.', '.', '.', '.', '7', '.', '8', '9', '.'],
  ['4', '5', '.', '.', '.', '1', '.', '.', '3'],
  ['.', '.', '8', '.', '.', '9', '.', '.', '.'],
  ['.', '.', '.', '.', '.', '.', '.', '2', '6'],
  ['.', '.', '4', '7', '.', '6', '1', '.', '.'],
  ['1', '9', '.', '.', '.', '.', '.', '.', '.'],
  ['.', '.', '.', '5', '.', '.', '4', '.', '.'],
  ['3', '.', '.', '2', '.', '.', '.', '5', '9'],
  ['.', '8', '5', '.', '1', '.', '.', '.', '.']
]

def contains(num, row):
  global board

  for n in board[row]:
    if n == num:
      return True

  return False

def canBePlaced(num, row, col):
  global board

  #if board position is already occupied, return False
  if board[row][col] != '.':
    return False

  #check row
  for n in board[row]:
    if n == num:
      return False

  #check col
  for i in range(0, len(board)):
    if board[i][col] == num:
      return False

  #check containing square
  for r in range(row - (row % 3), row + (2 - row % 3) + 1):
    for c in range(col - (col % 3), col + (2 - col % 3) + 1):
      if board[r][c] == num:
        return False

  return True

def place(num, row, col):
  global board

  board[row][col] = num

def remove(row, col):
  global board

  board[row][col] = '.'

def printBoard(board):
  for row in board:
    print row

def printBoardIndexes():
  for r in range(0, 9):
    if r % 3 == 0 and r != 0:
      print
    
    for c in range(0, 9):
      if c % 3 == 0 and c != 0:
        sys.stdout.write(" ")
      sys.stdout.write( "(" + str(r) + ", " + str(c) + ")")
    
    print

def solveSudokuHelper(board, row, col):
  if row >= len(board):
    #return True
    printBoard(board)
    print
  else:
    #if there is already a number in this cell, skip it
    if board[row][col] != '.':
      if col == len(board)-1:
        solveSudokuHelper(board, row+1, 0)
      else:
        solveSudokuHelper(board, row, col+1)
    else:
      for num in range(1, 10):
        #choose
        if canBePlaced(str(num), row, col):
          place(str(num), row, col)

          #explore
          if col == len(board)-1:
            solveSudokuHelper(board, row+1, 0)
          else:
            solveSudokuHelper(board, row, col+1)

          #unchoose
          remove(row, col)

def solveSudoku(board):
  solveSudokuHelper(board, 0, 0)

#printBoardIndexes()
solveSudoku(board)
