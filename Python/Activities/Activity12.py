def sum_of_num(num):
    if(num<=1):
        return num
    else:
        return num+sum_of_num(num-1)
    

print(sum_of_num(10))
