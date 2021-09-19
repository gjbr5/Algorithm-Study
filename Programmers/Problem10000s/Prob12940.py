def gcd(a, b):
    return gcd(b, a % b) if b else a


def solution(n, m):
    g = gcd(n, m)
    l = n // g * m
    return [g, l]


n = 3
m = 12
print(solution(n, m))
