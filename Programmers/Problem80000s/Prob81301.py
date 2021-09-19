def solution(s):
    mapping = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for num, word in enumerate(mapping):
        s = s.replace(word, str(num))
    return int(s)


s = "one4seveneight"
print(solution(s))