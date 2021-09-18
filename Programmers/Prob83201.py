def solution(scores):
    n = len(scores)
    scores = [[s[i] for s in scores] for i in range(n)]
    sscores = [sorted(s) for s in scores]
    for i in range(n):
        if scores[i][i] < sscores[i][1] or scores[i][i] > sscores[i][-2]:
            scores[i].pop(i)
    return ''.join(map(grade, scores))


def grade(scores):
    score = sum(scores) / len(scores)
    if score >= 90:
        return 'A'
    elif score >= 80:
        return 'B'
    elif score >= 70:
        return 'C'
    elif score >= 50:
        return 'D'
    else:
        return 'F'


scores = [[100, 90, 98, 88, 65], [50, 45, 99, 85, 77], [
    47, 88, 95, 80, 67], [61, 57, 100, 80, 65], [24, 90, 94, 75, 65]]
print(solution(scores))
