inputTuple=input("Enter values into a Tuple: ").split(",")
print(inputTuple)
for val in inputTuple:
    if (int(val))%5==0:
        print(val)
