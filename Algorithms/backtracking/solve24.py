import sys

def add(num1, num2):
  #print 'adding'
  return num1 + num2

def subtract(num1, num2):
  #print 'subtracting'
  return num1 - num2

def multiply(num1, num2):
  #print 'multiplying'
  return num1 * num2

def divide(num1, num2):
  #print 'dividing'
  return num1 / num2

def solve24Helper(nums, ops, chosen):
  #print nums
  if len(chosen) == 6:
    #parenthesis around first two numbers

    if chosen[1] == divide and int(chosen[2]) == 0:
      return

    res1 = chosen[1](int(chosen[0]), int(chosen[2]))

    if chosen[3] == divide and int(chosen[4]) == 0:
      return

    res2 = chosen[3](res1, int(chosen[4]))

    if chosen[5] == divide and int(nums[0]) == 0:
      return

    finalResult = chosen[5](res2, int(nums[0]))

    if finalResult == 21:
      for i in range(0, len(chosen)):
        if i % 2 == 0:
          if i == 0:
            sys.stdout.write('(')

          sys.stdout.write(chosen[i])

          if i == 2:
            sys.stdout.write(')')
        else:
          if chosen[i] == add:
            sys.stdout.write('+')
          elif chosen[i] == subtract:
            sys.stdout.write('-')
          elif chosen[i] == multiply:
            sys.stdout.write('*')
          else:
            sys.stdout.write('/')
        sys.stdout.write(' ')
     
      sys.stdout.write(nums[0])
      print
    #end parenthesis around first two numbers

    #parenthesis around middle two numbers

    if chosen[3] == divide and int(chosen[4]) == 0:
      return

    res1 = chosen[3](int(chosen[2]), int(chosen[4]))

    if chosen[1] == divide and res1 == 0:
      return

    res2 = chosen[1](int(chosen[0]), res1)

    if chosen[5] == divide and int(nums[0]) == 0:
      return 

    finalResult = chosen[5](res2, int(nums[0]))

    if finalResult == 21:
      for i in range(0, len(chosen)):
        if i % 2 == 0:
          if i == 2:
            sys.stdout.write('(')

          sys.stdout.write(chosen[i])

          if i == 4:
            sys.stdout.write(')')
        else:
          if chosen[i] == add:
            sys.stdout.write('+')
          elif chosen[i] == subtract:
            sys.stdout.write('-')
          elif chosen[i] == multiply:
            sys.stdout.write('*')
          else:
            sys.stdout.write('/')
        sys.stdout.write(' ')
     
      sys.stdout.write(nums[0])
      print
    #end parenthesis around middle two numbers

    #parenthesis around last two numbers
    if chosen[5] == divide and float(nums[0]) == 0:
      return

    res1 = chosen[5](float(chosen[4]), float(nums[0]))

    if chosen[3] == divide and res1 == 0:
      return

    res2 = chosen[3](float(chosen[2]), float(res1))

    if chosen[1] == divide and res2 == 0:
      return

    finalResult = chosen[1](float(chosen[0]), float(res2))
    
    if int(finalResult) == 21:
      for i in range(0, len(chosen)):
        if i % 2 == 0:
          if i == 4:
            sys.stdout.write('(')

          sys.stdout.write(chosen[i])
        else:
          if chosen[i] == add:
            sys.stdout.write('+')
          elif chosen[i] == subtract:
            sys.stdout.write('-')
          elif chosen[i] == multiply:
            sys.stdout.write('*')
          else:
            sys.stdout.write('/')
        sys.stdout.write(' ')
     
      sys.stdout.write(nums[0])
      sys.stdout.write(')')
      print
    #end parenthesis around last two numbers
    
    #parenthesis around first two and last two, and then use results

    if chosen[1] == divide and int(chosen[2]) == 0:
      return

    res1 = chosen[1](int(chosen[0]), int(chosen[2]))

    if chosen[5] == divide and int(nums[0]) == 0:
      return

    res2 = chosen[5](int(chosen[4]), int(nums[0]))

    if chosen[3] == divide and res2 == 0:
      return 

    finalResult = chosen[3](res1, res2)

    if finalResult == 21:
      for i in range(0, len(chosen)):
        if i % 2 == 0:
          if i == 2:
            sys.stdout.write('(')

          sys.stdout.write(chosen[i])

          if i == 4:
            sys.stdout.write(')')
        else:
          if chosen[i] == add:
            sys.stdout.write('+')
          elif chosen[i] == subtract:
            sys.stdout.write('-')
          elif chosen[i] == multiply:
            sys.stdout.write('*')
          else:
            sys.stdout.write('/')
        sys.stdout.write(' ')
     
      sys.stdout.write(nums[0])
      print
    #end parenthesis around middle two numbers


  else:
    #choose a number
    if len(chosen) % 2 == 0:
      #print nums
      for i in range(0, len(nums)):
        #choose
        chosen.append(nums[i])
        nums.pop(i)

        #explore
        solve24Helper(nums, ops, chosen)

        #unchoose
        nums.insert(i, chosen.pop())

    #choose an op
    else:
      for op in ops:
        #choose
        chosen.append(op)

        #explore
        solve24Helper(nums, ops, chosen)

        #unchoose
        chosen.pop()

def solve24(nums):
  #solve24Helper(nums, [add, subtract, multiply, divide], [])
  solve24HelperBT(nums, [add, subtract, multiply, divide], [0, 1], 0, len(nums))

def solve24HelperBT(nums, ops, parenPos, prevAcc, acc, count):
  if len(nums) == 0:
    if acc == 24:
      print 24
    elif prevAcc + acc == 24:
      print 24
    elif prevAcc - acc == 24:
      print 24
    elif prevAcc * acc == 24:
      print 24
    elif prevAcc / acc == 24:
      print 24
    else:
      print 'No solution!'
    #return acc
  else:
    for i in range(0, len(nums)):
      for o in range(0, len(ops)):
        for p in range(0, len(parenPos)):
          #choose an operand, operation, and paren position
          num = nums.pop(i)
          op = ops.pop(o)
          pos = parenPos.pop(p)

          #explore
          if pos == 0:
            solve24HelperBT(nums, ops, parenPos, 0, op(float(acc), float(num)), count)

            #acc = solve24HelperBT(nums, ops, parenPos, op(float(acc), float(num)), count)
            
            #if len(nums) == count-1 and acc == 24:
              #print acc
              #return 0
            #else:
              #return acc

          elif pos == 1:
            prevAcc = acc

            solve24HelperBT(nums, ops, parenPos, prevAcc, float(num), count)
            print result
            acc = op(float(acc), float(result))
            if len(nums) == count-1 and acc == 24:
              print acc
              return 0
            else:
              return acc
        
          #unchoose
          nums.insert(i, num)
          ops.insert(o, op)
          parenPos.insert(p, pos)
  
          if len(nums) == count-1 and acc == 24:
            print acc
            return 0
          else:
            return acc


          print "PRINTING"
          print nums
    print nums
    return 0
    """
    #add
    acc = solve24HelperBT(nums, acc + float(num), count)
    if len(nums) == count-1 and acc == 24:
    #print the operation made by this function call
    print 'add1 worked'

    acc = acc + solve24HelperBT(nums, float(num), count)
    if len(nums) == count-1 and acc == 24:
      print 'add2 worked'

    #subtract
    acc = solve24HelperBT(nums, acc - float(num), count)
    if len(nums) == count-1 and acc == 24:
      print 'sub1 worked'

    acc = acc - solve24HelperBT(nums, float(num), count)
    if len(nums) == count-1 and acc == 24:
      print 'sub2 worked'

    #multiply
    acc = solve24HelperBT(nums, acc * float(num), count)
    if len(nums) == count-1 and acc == 24:
      print 'mult1 worked'

    acc = acc * solve24HelperBT(nums, float(num), count)
    if len(nums) == count-1 and acc == 24:
      print 'mult2 worked'

    #divide
    acc = solve24HelperBT(nums, acc / float(num), count)
    if len(nums) == count-1 and acc == 24:
      print 'div1 worked'

    acc = acc / solve24HelperBT(nums, float(num), count)
    if len(nums) == count-1 and acc == 24:
      print 'div2 worked'

    """

if len(sys.argv) != 5:
  print 'invalid parameters'
else:
  solve24(sys.argv[1:])

