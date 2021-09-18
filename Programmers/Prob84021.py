def find_next(board, block):
    for y in range(len(board)):
        for x in range(len(board)):
            if board[y][x] == block:
                return y, x
    return False


def bfs(game_board, start, block):
    max_y = len(game_board)
    max_x = len(game_board[0])

    visit = []
    queue = [start]
    while queue:
        y, x = node = queue.pop(0)
        if node in visit:
            continue
        visit.append(node)
        for ny, nx in ((y - 1, x), (y, x - 1), (y, x + 1), (y + 1, x)):
            if 0 <= nx < max_x and 0 <= ny < max_y and game_board[ny][nx] == block:
                queue.append((ny, nx))
    return visit, normalize(visit)


def normalize(shape):
    shape.sort()
    return [(p[0] - shape[0][0], p[1] - shape[0][1]) for p in shape]


def rotate(shape):
    return normalize([(-p[1], p[0]) for p in shape])


def solution(game_board, table):
    answer = 0
    shapes = []
    while True:
        start = find_next(table, 1)
        if not start:
            break
        location, shape = bfs(table, start, 1)
        for y, x in location:
            table[y][x] = 0
        r90 = rotate(shape)
        r180 = rotate(r90)
        r270 = rotate(r180)
        shapes.append([shape, r90, r180, r270])

    while True:
        start = find_next(game_board, 0)
        if not start:
            break
        location, blank = bfs(game_board, start, 0)
        for i in range(len(shapes)):
            if blank in shapes[i]:
                shapes.pop(i)
                answer += len(blank)
                break
        for y, x in location:
            game_board[y][x] = 1

    return answer


game_board = [[1, 1, 0, 0, 1, 0], [0, 0, 1, 0, 1, 0], [0, 1, 1, 0, 0, 1], [
    1, 1, 0, 1, 1, 1], [1, 0, 0, 0, 1, 0], [0, 1, 1, 1, 0, 0]]
table = [[1, 0, 0, 1, 1, 0], [1, 0, 1, 0, 1, 0], [0, 1, 1, 0, 1, 1],
         [0, 0, 1, 0, 0, 0], [1, 1, 0, 1, 1, 0], [0, 1, 0, 0, 0, 0]]
print(solution(game_board, table))
