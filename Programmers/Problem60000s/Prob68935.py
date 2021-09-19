def solution(n):
    ternary = 0
    while n:
        ternary *= 10
        ternary += n % 3
        n //= 3
    for i in map(int, str(ternary)):
        n *= 3
        n += i
    return n


n = 45
print(solution(n))
