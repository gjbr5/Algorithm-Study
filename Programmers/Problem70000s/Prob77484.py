def solution(lottos, win_nums):
    zcount = 0
    match = 0
    for l in lottos:
        if l in win_nums:
            match += 1
        elif l == 0:
            zcount += 1
    win = lambda x: min(6, 7 - x)
    return [win(match + zcount), win(match)]


lottos = [44, 1, 0, 0, 31, 25]
win_nums = [31, 10, 45, 1, 6, 19]
print(solution(lottos, win_nums))
