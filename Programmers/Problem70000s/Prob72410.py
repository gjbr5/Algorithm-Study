def solution(new_id):
    # 1, 2 단계
    answer = [c for c in new_id.lower() if c in 'abcdefghijklmnopqrstuvwxyz0123456789-_.']
    
    # 3단계
    tmp = ['.']
    for c in answer:
        if not c == tmp[-1] == '.':
            tmp.append(c)
    answer = tmp
    
    # 4단계
    while answer and answer[-1] == '.':
        answer.pop()
    while answer and answer[0] == '.':
        answer.pop(0)
    
    # 5단계
    if not answer:
        answer = ['a']
    
    # 6단계
    if len(answer) >= 16:
        answer = answer[:15]
        while answer[-1] == '.':
            answer.pop()
    
    # 7단계
    while len(answer) <= 2:
        answer.append(answer[-1])

    return ''.join(answer)


new_id = "...!@BaT#*..y.abcdefghijklm"
print(solution(new_id))