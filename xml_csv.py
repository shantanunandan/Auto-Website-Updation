import os
import xml.etree.ElementTree as ET
import csv



def write_csv(file, row1, row2, row3, row4):
	with open(file, 'a') as csv_file:
		writer = csv.writer(csv_file)
		writer.writerow([row1, row2, row3, row4, "No"])


def read_xml(file):
	tree = ET.parse(file)
	root = tree.getroot()

	l = [elem.tag for elem in root.iter()]
	element = []
	red = 0
	brown = 0

	for i in l:
		if i=='filename' or i=='path' or i=='name':
			for description in root.iter('filename'):
				if description.text != '' or description.text != None:
					print(description.text)
					element.append(description.text)
			for description in root.iter('path'):
				if description.text != '' or description.text != None:
					print(description.text)
					element.append(description.text)
			for description in root.iter('name'):
				if description.text != '' or description.text != None:
					print(description.text)
					if description.text == 'redbud':
						#element.append("Yes")
						red = red+1
						print("Red")
					else:
						pass
					if description.text == 'brownbud':
						#element.append("Yes")
						brown = brown+1
						print("Brown")
					else:
						pass
			element.append(red)
			element.append(brown)


			write_csv("image_annotation_data.csv", file.replace(".xml",".jpg"), file, element[2], element[3])
			print(element)
			break




data = os.listdir('/home/ubuntu/Desktop/dataForExcel')
for d in data:
	if '.xml' in d:
		print(d)
		read_xml(d)









