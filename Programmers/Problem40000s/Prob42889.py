def solution(N, stages):
    cleared = [0] * (N + 1)
    for stage in stages:
        cleared[stage - 1] += 1
    ncleared = [*cleared]
    for i in range(len(cleared) - 1, 0, -1):
        cleared[i - 1] += cleared[i]
    fail_rate = [n / max(1, c) for n, c in zip(ncleared, cleared)]
    return sorted(range(1, N + 1), key=lambda x: (-fail_rate[x - 1], x))


N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
print(solution(N, stages))
