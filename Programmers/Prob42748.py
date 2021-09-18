def solution(array, commands):
    answer = []
    for i, j, k in commands:
        i -= 1
        k -= 1
        answer.append(sorted(array[i:j])[k])
    return answer


array = [1, 5, 2, 6, 3, 7, 4]
commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]]
print(solution(array, commands))
