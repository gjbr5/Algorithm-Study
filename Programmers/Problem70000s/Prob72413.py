def solution(n, s, a, b, fares):
    s -= 1
    a -= 1
    b -= 1
    graph = [[float('inf') if x != y else 0 for x in range(n)]
             for y in range(n)]
    for f in fares:
        graph[f[0] - 1][f[1] - 1] = f[2]
        graph[f[1] - 1][f[0] - 1] = f[2]
    for mid in range(n):
        for start in range(n):
            for end in range(n):
                graph[start][end] = min(
                    graph[start][end], graph[start][mid] + graph[mid][end])
    answer = min([graph[s][m] + graph[m][a] + graph[m][b] for m in range(n)])
    answer = min(answer, graph[s][a] + graph[s][b])
    return answer


n = 6
s = 4
a = 6
b = 2
fares = [[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [
    5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]
print(solution(n, s, a, b, fares))
