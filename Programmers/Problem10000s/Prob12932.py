def solution(n):
    return list(map(int, reversed(str(n))))


n = 12345
print(solution(n))
