def solution(word):
    answer = 0
    mult = [781, 156, 31, 6, 1]
    for i in range(len(word)):
        if word[i] == 'A':
            answer += 1
        elif word[i] == 'E':
            answer += mult[i] + 1
        elif word[i] == 'I':
            answer += mult[i] * 2 + 1
        elif word[i] == 'O':
            answer += mult[i] * 3 + 1
        else:
            answer += mult[i] * 4 + 1
    return answer


word = "AAAAE"
print(solution(word))
