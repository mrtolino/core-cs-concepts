def permuteHelper(strings, chosen):
  if len(strings) == 0:
    print chosen
  else:
    for i in range(0, len(strings)):
      #choose
      chosen.append(strings[i])
      strings.pop(i)

      #explore
      permuteHelper(strings, chosen) 

      #un-choose
      strings.insert(i, chosen.pop())

def permute(strings):
  permuteHelper(strings, [])

permute(["a", "b", "c", "d"])
