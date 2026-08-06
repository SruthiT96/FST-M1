fruitsDict={"apple":90, "banana":30, "guava":50, "pineapple":35}

reqFruit=input("Enter the fruit you want to buy: ").lower();

if reqFruit in fruitsDict:
    print("Fruit is available")
else:
    print("Fruit is not available")
