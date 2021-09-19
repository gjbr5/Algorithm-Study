def solution(n, lost, reserve):
    clothes = [1 for _ in range(n + 2)]
    for r in reserve:
        clothes[r] += 1
    for l in lost:
        clothes[l] -= 1
    for i in range(1, n + 1):
        if clothes[i] == 0:
            if clothes[i - 1] == 2:
                clothes[i - 1] -= 1
                clothes[i] += 1
            elif clothes[i + 1] == 2:
                clothes[i + 1] -= 1
                clothes[i] += 1
    return n - clothes.count(0)


n = 5
lost = [2, 4]
reserve = [1, 3, 5]
print(solution(n, lost, reserve))
