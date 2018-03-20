factorial :: Integer -> Integer -> Integer
factorial 0 acc = acc
factorial 1 acc = acc
factorial n acc = factorial (n-1) (n * acc)
--factorial n = product [1..n]



fibonacci :: Integer -> Integer -> Integer -> Integer
fibonacci 0 n1 n2 = 1
fibonacci 1 _ _ = 1
fibonacci n n1 n2 = 


{-fibonacci n = 
  if n == 0 
    then 0
  else if n == 1
    then 1
  else fibonacci (n-1) + fibonacci (n-2)
-}
addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

addTwoTo3 :: Int -> Int -> Int 
addTwoTo3 y z = addThree 3 y z

--sum' :: (Num a) => [a] -> a
--sum' [] = 0
--sum' (x:xs) = x + sum' (xs)
sum' :: (Num a) => [a] -> a
sum' [] = 0
sum' (x:xs)
  | length xs == 0 = x
  | otherwise = x + sum' xs

data Day = Monday | Tuesday | Wednesday | Thursday | Friday | Saturday
           | Sunday deriving (Eq, Ord, Show, Read, Bounded, Enum)

powersOfTwo = [2^n | n <- [1..]]

multiplesOfFour = [2*n+1 | n <- [1..]]

permutations = []


