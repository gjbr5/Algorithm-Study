def solution(n):
    return int(''.join(sorted(str(n), reverse=True)))


n = 118372
print(solution(n))
