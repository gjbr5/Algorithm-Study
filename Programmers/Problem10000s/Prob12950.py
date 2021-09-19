def solution(arr1, arr2):
    return [[elem1 + elem2 for elem1, elem2 in zip(row1, row2)] for row1, row2 in zip(arr1, arr2)]


arr1 = [[1, 2], [2, 3]]
arr2 = [[3, 4], [5, 6]]
print(solution(arr1, arr2))
