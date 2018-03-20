main = do
  putStrLn "Enter a string: "
  word <- getLine
  putStrLn (test word)

test :: String -> String
test s = s

permute :: String -> ()
permute s = permuteHelper s []

permuteHelper :: String -> [String] -> ()
permuteHelper s chosen = ()

test2 s = test2Helper s 5

test2Helper s count = 
  if count == 0 
    then show s 
  else show (test2Helper s (count-1))

