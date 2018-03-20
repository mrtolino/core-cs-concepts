import sys

charDict = [
  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
  'w', 'x', 'y', 'z'
]

def permuteHelper(n, chosen, dictionary):
  if n == 0:
    print chosen
  else:
    for c in dictionary:
      #choose
        chosen = chosen + str(c)

      #explore
        permuteHelper(n-1, chosen, dictionary)

      #unchoose
        chosen = chosen[:len(chosen)-1]

def permute(n, dictionary):
  permuteHelper(n, "", dictionary)

permute(5, charDict)
