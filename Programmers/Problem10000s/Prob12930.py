def solution(s):
    return ' '.join(map(lambda word: ''.join(word[i].lower() if i % 2 else word[i].upper() for i in range(len(word))), s.split(' ')))


s = "try hello world"
print(solution(s))
