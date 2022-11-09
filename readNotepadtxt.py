
data = open('final_output.txt', 'r')

data = data.readlines()

c = 0

for line in data:
	c = c+1
	if "Main Result : " in line.strip():
		print(line.strip())


