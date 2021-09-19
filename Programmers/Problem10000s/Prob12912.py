def solution(a, b):
    if a > b:
        a, b = b, a
    return b * (b + 1) // 2 - (a - 1) * a // 2


a = 3
b = 5
print(solution(a, b))
