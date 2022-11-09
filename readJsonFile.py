
import json
import os



folder=os.listdir('.')
print(len(folder))
data = {}
for f in folder:
    #print(f)
    if f.endswith(".json"):
        f = open(f,)
	# Loading JSON file in variable f 
        data = json.load(f)
	# Printing aquired data which is in form of dicsnory and list
        print(data,"\n")
	# Using dist.keys function to get all keys
        print("Values Inside Key : ",data['shapes'][0].keys(),"\n")
	# Using dist.values function to get all values
        print("Values Inside Value : ",data['shapes'][0].values(),"\n")
	# Capturing first key value from dicsnory
        print("Values Inside Points : ",data['shapes'][0]['points'],"\n")
	# Capturing first key value from dicsnory which is again a dicsnory and then using aquired dicsnory key value from it which is a list
        print("Values Inside Points : ",data['shapes'][0]['points'][0],"\n")
	# Capturing first list value from the list which we got from previous step
        print("Values Inside Points : ",data['shapes'][0]['points'][0][0],"\n")
	# Capturing all the values aquired from the key value combination of shape
        for i in data['shapes'][0].keys():
             print(i)
        
        for i in data['shapes']:
            print(i['shape_type'])
            if len(i['points'])==2:
                x1=i['points'][0][0]
                y1=i['points'][0][1]

                x3=i['points'][1][0]
                y3=i['points'][1][1]

                x2=x1
                y2=y3

                x4=x3
                y4=y1
                i['points']=[]
                i['points'].append([x1,y1])
                i['points'].append([x2,y2])
                i['points'].append([x3,y3])
                i['points'].append([x4,y4])
            if len(i['points'])==4: print('ok')
        f.close()
