def compress(s, l):
    result = ['']
    cnt = 1
    for i in range(0, len(s) + 1, l):
        token = s[i:i+l]
        if token == result[-1]:
            cnt += 1
        else:
            if cnt > 1:
                result[-1] = str(cnt) + result[-1]
            result.append(token)
            cnt = 1
    return ''.join(result)


def solution(s):
    return min([len(compress(s, l)) for l in range(1, len(s) + 1)])