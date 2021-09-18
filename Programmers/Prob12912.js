function solution(a, b) {
    var result = 0
    if (a > b) {
        var tmp = a;
        a = b;
        b = tmp;
    }
    for (var i = a; i <= b; i++)
        result += i;

    return result;
}


a = 3
b = 5
console.log(solution(a, b))