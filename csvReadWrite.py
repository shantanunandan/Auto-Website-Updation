def csvWrite(self, data, csvFileName):
	"""Writes the given data row-wise to the given csv file."""
	with open(csvFileName, 'w') as csv_file:
		writer = csv.writer(csv_file)
			for key, value in data.items():
				writer.writerow([key,value])

def readCSV(self, csvFileName):
	"""Read a CSV file and returns a dict containing its data."""
	data = []
	with open(csvFileName) as csvFile:
		reader = csv.reader(csvFile)
		for row in reader:
			data.append(row)
	return data
