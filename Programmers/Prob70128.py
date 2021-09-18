def solution(a, b):
    return sum([a[i] * b[i] for i in range(len(a))])

a = [1,2,3,4]
b = [-3,-1,0,2]
print(solution(a, b))