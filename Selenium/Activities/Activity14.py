def get_fib_series(inputNum):
    if inputNum <= 1:
        return inputNum;
    else:
        return (get_fib_series(inputNum-1)+get_fib_series(inputNum-2))
            


fiblen=int(input("Enter the number of fibbonacci series to generate: "))

if(fiblen<=0):
    print("Enter a number greater than 0")
else:
    for i in range(fiblen):
        print(get_fib_series(i))