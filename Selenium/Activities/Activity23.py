import pytest

@pytest.fixture
def input_value():
    list1=[0,1,2,3,4,5,6,7,8,9,10]
    return list1

def sum(input_value):
    sum=0;
    for val in input_value:
        sum+=val
    assert sum==55