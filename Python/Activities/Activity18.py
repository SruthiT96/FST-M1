import pandas as pd

dataframe=pd.read_csv("credentials.csv")
print("----------------------------------------------")
print(dataframe["Usernames"])
print("----------------------------------------------")
print(dataframe["Usernames"][1]+" "+dataframe["Passwords"][1])
print("----------------------------------------------")
print(dataframe.sort_values("Usernames"))
print("----------------------------------------------")
print(dataframe.sort_values("Passwords",ascending=False))


