def solution(price, money, count):
    return max(0, sum(range(count + 1)) * price - money)


price = 3
money = 20
count = 4
print(solution(price, money, count))
