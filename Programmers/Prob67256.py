def getld(left, num):
    mid = (2, 5, 8, 0)
    dist = 0
    if left in (1, 4, 7, -1):
        left += 1
        dist += 1
    dist += abs(mid.index(num) - mid.index(left))
    return dist


def getrd(right, num):
    mid = (2, 5, 8, 0)
    dist = 0
    if right in (3, 6, 9, 1):
        right -= 1
        dist += 1
    dist += abs(mid.index(num) - mid.index(right))
    return dist


def solution(numbers, hand):
    left, right = -1, 1
    answer = []
    for num in numbers:
        if num in (1, 4, 7):
            answer.append('L')
            left = num
        elif num in (3, 6, 9):
            answer.append('R')
            right = num
        else:
            ld = getld(left, num)
            rd = getrd(right, num)
            if ld == rd:
                if hand == 'left':
                    answer.append('L')
                    left = num
                else:
                    answer.append('R')
                    right = num
            elif ld > rd:
                answer.append('R')
                right = num
            else:
                answer.append('L')
                left = num
    return ''.join(answer)


numbers = [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]
hand = "right"
print(solution(numbers, hand))