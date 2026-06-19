def sum(list1):
    sum=0
    for i in list1:
        sum+=int(i);
    return sum

list1=input("Enter a list of values: ").split(",")
print(list1)
print(sum(list1))
