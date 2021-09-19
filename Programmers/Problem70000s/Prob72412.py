from copy import deepcopy
from bisect import bisect_left


def solution(info, query):
    group = {'chicken': [], 'pizza': []}
    group = {'junior': group, 'senior': deepcopy(group)}
    group = {'backend': group, 'frontend': deepcopy(group)}
    group = {'cpp': group, 'java': deepcopy(group), 'python': deepcopy(group)}

    for i in info:
        i = i.split()
        group[i[0]][i[1]][i[2]][i[3]].append(int(i[4]))
    for lang in group:
        for job in group[lang]:
            for career in group[lang][job]:
                for food in group[lang][job][career]:
                    group[lang][job][career][food].sort()

    def cnt_grp(grp, qry, pos):
        if pos == len(qry) - 1:
            return len(grp) - bisect_left(grp, int(qry[pos]))
        elif qry[pos] == 'and':
            return cnt_grp(grp, qry, pos + 1)
        elif qry[pos] != '-':
            return cnt_grp(grp[qry[pos]], qry, pos + 1)
        else:
            return sum([cnt_grp(grp[g], qry, pos + 1) for g in grp])

    return [cnt_grp(group, qry.split(), 0) for qry in query]


info = ["java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150",
        "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"]
query = ["java and backend and junior and pizza 100", "python and frontend and senior and chicken 200",
         "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"]
print(solution(info, query))
