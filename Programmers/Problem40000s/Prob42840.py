def solution(answers):
    a, b, c = 0, 0, 0
    a_ans = [1, 2, 3, 4, 5]
    b_ans = [2, 1, 2, 3, 2, 4, 2, 5]
    c_ans = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    pa, pb, pc = 0, 0, 0
    for ans in answers:
        if a_ans[pa] == ans:
            a += 1
        if b_ans[pb] == ans:
            b += 1
        if c_ans[pc] == ans:
            c += 1
        pa = (pa + 1) % 5
        pb = (pb + 1) % 8
        pc = (pc + 1) % 10
    ans = []
    if max(a, b, c) == a:
        ans.append(1)
    if max(a, b, c) == b:
        ans.append(2)
    if max(a, b, c) == c:
        ans.append(3)
    return ans


answers = [1, 2, 3, 4, 5]
print(solution(answers))
