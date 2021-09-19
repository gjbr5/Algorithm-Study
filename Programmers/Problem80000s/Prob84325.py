def solution(table, languages, preference):
    answer = []
    for t in table:
        l = t.split()
        score = 0
        for lg, pf in zip(languages, preference):
            if lg in l:
                score += (6 - l.index(lg)) * pf
        answer += [(-score, l[0])]
    answer.sort()
    return answer[0][1]


table = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
         "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]
languages = ["PYTHON", "C++", "SQL"]
preference = [7, 5, 5]
print(solution(table, languages, preference))
