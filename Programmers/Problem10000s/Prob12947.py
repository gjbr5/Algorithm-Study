def solution(x):
    return x % sum(map(int, str(x))) == 0


arr = 10
print(solution(arr))
