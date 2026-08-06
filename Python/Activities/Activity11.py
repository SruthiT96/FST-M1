fruitsDict={"apple":50, "banana":10, "guava":20, "pineapple":15}

reqFruit=input("Enter the fruit you want to buy: ").lower();

if reqFruit in fruitsDict:
    print("Fruit is available")
else:
    print("Fruit is not available")
