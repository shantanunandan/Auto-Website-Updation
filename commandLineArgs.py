
import sys

import argparse

def method_1(data1, data2):
	print("Input : {}, {}".format(data1, data2))

method_1(sys.argv[1],sys.argv[2])



parser = argparse.ArgumentParser()
parser.add_argument("first", default="No name provided", help="Your first name please")
parser.add_argument("last", default="No name provided", help="Your second name please")
args = parser.parse_args()

def method_2(first, last):
	print("My name is {first} {last}".format(last=last, first=first))
        print("My name is {} {}".format(first, last))
        print("My name is {} {}".format(last, first))
        print("My name is %s %s" %(first,last))
        print("My name is %s %s" %(last,first))

method_2(args.first, args.last)


t1=(1)
t2=(2,)

print(type(t1))
print(type(t2))

t = [t for t in t2]
print(t)



tup = (1,2,3,4)
fi,se,th,fo = tup

print(fi)
print(se)
print(th)
print(fo)

print([t for t in tup])



s = "ShantanuAANandan"
print(s.partition("AA"))


for i in range(10,0,-2):
	print(i)
print()
for i in range(10,20,2):
	print(i)

l = [10,20,30,40]
for t,tt in enumerate(l,start=1):# Start basically defines from where to start the count. So if we have defined start = 1 then it will start counting from 1. By default it start counting from 0. 
	print(t)
	print(tt)

print(s.split('a'))
print(s.split('a')[::-1]) # [::-1] -> Used to reverse elements of a list

ss = ','.join(s.split('a')[::-1])
print(ss)

print(5.0/4, 5.0//4, 5%4, 4**2)

print(zip([1,2,3,4,5,6],['A','B','C','D','E']))

m = map(lambda x,y: max(x,y), [2,4,8,1,10],[5,2,3,9,1,100])
print(m)

var = "Hello"
def func():
	global var
	var = var+" ##"
	print(var)
	var = "Hi"
	print(var)	

func()

try:
	raise ValueError("There is value error")
	raise Exception("There is an error")
except Exception as e:
	print("Excepting error which was raised : "+repr(e))


try:
	print(2/0)
except Exception:
	raise



