def solution(participant, completion):
    h = {hash(p): p for p in participant}
    ans = 0
    for p in participant:
        ans ^= hash(p)
    for c in completion:
        ans ^= hash(c)
    return h[ans]


participant = ["leo", "kiki", "eden"]
completion = ["eden", "kiki"]
print(solution(participant, completion))
