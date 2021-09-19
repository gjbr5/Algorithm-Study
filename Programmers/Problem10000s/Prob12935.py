def solution(arr):
    del arr[arr.index(min(arr))]
    return arr or [-1]


arr = [4, 3, 2, 1]
print(solution(arr))
