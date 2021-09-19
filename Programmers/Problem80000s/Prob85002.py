def solution(weights, head2head):
    win = [h2h.count('W') / max(1, len(h2h) - h2h.count('N'))
           for h2h in head2head]
    hwin = [sum([weights[i] < weights[j] and head2head[i][j] == 'W' for j in range(
        len(head2head[i]))]) for i in range(len(head2head))]
    return sorted(range(1, len(weights) + 1), key=lambda x: (win[x-1], hwin[x-1], weights[x-1], -x), reverse=True)


weights = [50, 82, 75, 120]
head2head = ["NLWL", "WNLL", "LWNW", "WWLN"]
print(solution(weights, head2head))
