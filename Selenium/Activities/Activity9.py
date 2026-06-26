list1=[1,2,3,4]
list2=[1,2,3,4,5,6]
newlist=[]

for val in list1:
    if(val%2!=0):
        newlist.append(val)

for vals in list2:
    if(vals%2==0):
        newlist.append(vals)

print(newlist)