def solution(s, n):
    return ''.join(chr((ord(c) - 0x41 + n) % 26 + 0x41) if c.isupper() else chr((ord(c) - 0x61 + n) % 26 + 0x61) if c.islower() else c for c in s)


s = "AB"
n = 1
print(solution(s, n))
