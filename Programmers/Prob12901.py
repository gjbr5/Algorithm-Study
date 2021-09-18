def solution(a, b):
    days_in_month = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    days_in_week = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU']
    a -= 1
    b -= 1
    answer = 0
    for i in range(a):
        answer += days_in_month[i]
    answer += b
    answer = days_in_week[answer % 7]
    return answer


a = 5
b = 24
print(solution(a, b))
