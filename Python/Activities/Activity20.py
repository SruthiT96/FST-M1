import pandas as pd

df=pd.read_excel("employeeinfo.xlsx")
print("Number of Rows and Columns")
print(df.shape)
print("------------------------------")
print(df["Email"])
print("------------------------------")
print(df["FirstName"].sort_values)