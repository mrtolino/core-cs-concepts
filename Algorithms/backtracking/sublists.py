def sublistsHelper(givenList, chosen):
  if len(givenList) == 0:
    return
  else:
    for i in range(0, len(givenList)):
      #choose
      chosen.append(givenList[i])
      givenList.pop(i)

      #explore

      #un-choose
          

def sublists(givenList):
  sublistsHelper(givenList, [])

sublists(["Jane", "Bob", "Matt", "Sara"])
