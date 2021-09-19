def make_menu(order, start, course):
    if course == 1:
        return list(order[start:])
    menu = []
    for i in range(start, len(order) - course + 1):
        menu += [order[i] + m for m in make_menu(order, i + 1, course - 1)]
    return menu


def solution(orders, course):
    answer = []
    for cour in course:
        cnt = {}
        for order in orders:
            order = ''.join(sorted(list(order)))
            menu = make_menu(order, 0, cour)
            menu = {m: menu.count(m) for m in menu}
            for m in menu:
                if m not in cnt:
                    cnt[m] = menu[m]
                else:
                    cnt[m] += menu[m]
        max_cnt = 2
        max_menu = []
        for m, c in cnt.items():
            if max_cnt < c:
                max_menu = [m]
                max_cnt = c
            elif max_cnt == c:
                max_menu.append(m)
        answer += max_menu
    answer.sort()
    return answer


orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2, 3, 4]
print(solution(orders, course))
