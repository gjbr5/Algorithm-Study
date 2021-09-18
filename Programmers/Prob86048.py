def solution(enter, leave):
    convention_room = set()
    meet = {person: set() for person in leave}
    for lperson in leave:
        while lperson not in convention_room:
            convention_room.add(enter.pop(0))
        for person in convention_room:
            meet[person].update(convention_room)
        convention_room.remove(lperson)
    return list(map(lambda p: len(meet[p]) - 1, sorted(leave)))


enter = [1, 3, 2]
leave = [1, 2, 3]
print(solution(enter, leave))
