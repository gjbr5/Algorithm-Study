def solution(s):
    return (len(s) == 4 or len(s) == 6) and s.isdecimal()


s = "a234"
print(solution(s))
