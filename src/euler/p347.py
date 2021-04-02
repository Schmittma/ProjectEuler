from sympy import primerange, sieve
from numba import jit
import math
import time

@jit
def M(p, q, N):
    i = 1
    result = 0

    while True:
        
        p_pow = p**i
        if (p_pow * q) > N:
            break

        j = 1

        while True:
            p_times_q = p_pow * (q**j) 
            if p_times_q > N:
                break
            
            result = max(result, p_times_q)
            j += 1

        i += 1

    return result


# 2^5 * 3^x = 100
# 100 / 2^5 = 3^x
# log3(100 / 2^5) = x -> x = 1.49 -> 1
# 2^5 * 3^1 = 96
@jit
def M2(p, q, N):
    i = 1
    result = 0

    while True:
        
        p_pow = p**i
        if (p_pow * q) > N:
            break

        j = int(math.log(N/p_pow) / math.log(q))
        p_times_q = p_pow * (q**j) 

        result = max(result, p_times_q)

        i += 1

    return result


MAX = 100

primes = list(primerange(1, (MAX/2)))
sum = 0

start = time.time()

for i in range(len(primes)):
    for j in range(i+1, len(primes)):
        sum += M(primes[i], primes[j], MAX)

print ("Sum: " + str(sum))
print("Time: " + str(int((time.time() - start) * 100) / 100) + " s")