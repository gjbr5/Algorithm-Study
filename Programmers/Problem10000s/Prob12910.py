def solution(arr, divisor):
    answer = sorted([x for x in arr if x % divisor == 0])
    return answer if answer else [-1]


arr = [5, 9, 7, 10]
divisor = 5
print(solution(arr, divisor))
