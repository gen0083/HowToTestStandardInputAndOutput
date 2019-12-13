def test_func():
    count = int(input())
    for i in range(0, count):
        s = sum(map(int, input().split()))
        print(s)


if __name__ == "__main__":
    test_func()
