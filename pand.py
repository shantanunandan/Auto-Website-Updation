import pandas as pd 

df = pd.read_csv("tyr.csv")
print(df.columns)

# Command taken from Stackoveflow -->> df.groupby('user_id').apply(lambda column: column.sum()/(column != 0).sum())
# Link of question -->> https://stackoverflow.com/questions/26053849/counting-non-zero-values-in-each-column-of-a-dataframe-in-python/34156147
#df = df.apply(lambda column: column.sum())


df = df.to_dict()

print(df)


