-- Calculates sum of combinations from 1 to n.
-- n < 30 by task condition
-- sum of combinations, because in original task it's possible to have
-- elements which organized in combination but has different amount.
calculateCombinations :: Integer -> Integer -> Integer
calculateCombinations n 1 = n
calculateCombinations n k
    | n <= 0 = -1
    | k <= 0 = -1
    | n > 30 = -1
    | k > 30 = -1
    | otherwise = (fac n `div` (fac k * fac (n - k))) 
        + calculateCombinations n (k - 1)

-- calculates factorial
fac :: Integer -> Integer
fac 1 = 1
fac n = n * fac (n - 1)
