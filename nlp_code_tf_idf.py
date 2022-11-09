import nltk 
import re 
# heapq library is used to find the most appearing word 
import heapq 
# To create 2d array use numpy
import numpy as np


paragraph = """The nearest public fire department is located at Campana city, 1 km away from this mill. However this is a Fire Department with very low resources, since it is a very small city. The Fire Department in Buenos Aires, capital city of Argentina, could also respond, but no earlier than one hour. Tenaris Siderca has its own Fire Brigade who would probably provide the initial response. Please refer to "Emergency Organization Narrative" section. Additionally, there is a mutual and formal agreement in between most important industrial companies installed within this region in order to provide each other with emergency fire protection response in case one of them need. It is named PACEI. To mention some of them: Air Liquide, Cabot Argentina, Carboclor, Celulosa Argentina, Ceveceria y Malteria Quilmes, Clariant, Esso, Lanxess, Dak Americas Argentina, Merisant Argentina, Monsanto Argentina, Petrobras Energia SA, Praxair, among others. There are frequent meetings in between companies representatives and formal procedures. GRASP RB Version 1.8 - Generated: 12-Dec-18"""

# Sentence tokenization
dataset = nltk.sent_tokenize(paragraph)
# Preprocessing of paragraph to create the data for our Bag of words model  
for i in range(len(dataset)):
	dataset[i] = dataset[i].lower()
	# Substitute all non-word character by space
	dataset[i] = re.sub('\W', ' ', dataset[i])
	# Substitute all more than one spaces by a single space
	dataset[i] = re.sub('\s+', ' ', dataset[i])
	
# Creating the matrix/histogram for our model
wordCount = {}
for data in dataset:
	words = nltk.word_tokenize(data)
	for word in words:
		if word not in wordCount.keys():
			wordCount[word] = 1
		else:
			wordCount[word] += 1

# Selecting the top most frequently appearing word
# Parameter for nlargest -->> nlargest(number-of_word_to_run, dataset_in_dics_format, key=dics.get) 
freq_words = heapq.nlargest(4, wordCount, key=wordCount.get)

# Now we have the dataset ready for our model. So lets start.
temp = []
for data in dataset:
	vector = []
	for word in freq_words:
		if word in nltk.word_tokenize(data):
			# If word appears in sentence append 1
			vector.append(1)
		else:
			# If word does not appears in sentence append 0
			vector.append(0)
	temp.append(vector)
	
# create a 2D array for our bag of words model using temp and numpy
temp = np.asarray(temp)
print("temp : ",temp)
print("len(temp) : ",len(temp))
print()

print("wordCount : ",wordCount)
print()
print("dataset : ", dataset)
print()

# Creating IDF_Matrix
word_idfs = {}

for word in freq_words:
	doc_count = 0
	for data in dataset:
		if word in nltk.word_tokenize(data):
			doc_count += 1
	word_idfs[word] = np.log((len(dataset)/doc_count)+1)

print("word_idfs : ", word_idfs)
print()

# Creating TF_Matrix
tf_matrix = {}
for word in freq_words:
	doc_tf = []
	for data in dataset:
		frequency = 0
		for w in nltk.word_tokenize(data):
			if w == word:
				frequency += 1
		tf_word = frequency / len(nltk.word_tokenize(data))	
		doc_tf.append(tf_word)
	tf_matrix[word] = doc_tf

print("tf_matrix : ", tf_matrix)
print()


# TF-IDF calculation
tfidf_matrix = []
tfidf_matrix_dics = {}
for word in tf_matrix.keys():
	tfidf = []
	for value in tf_matrix[word]:
		score = value * word_idfs[word]
		tfidf.append(score)
	tfidf_matrix.append(tfidf)
	tfidf_matrix_dics[word] = tfidf

print("tfidf_matrix : ", tfidf_matrix)
print("tfidf_matrix_dics : ", tfidf_matrix_dics)
print()


# Creating 2D Array and doing transpose on it. Transpose is required to get results in the form of row * column. 
# If we don't do it then we will get the result in the form of column * row.
transpose_matrix_of_tfidf_matrix = np.asarray(tfidf_matrix)
transpose_matrix_of_tfidf_matrix = np.transpose(transpose_matrix_of_tfidf_matrix)
print("transpose_matrix_of_tfidf_matrix : ")
print([k for k in tfidf_matrix_dics.keys()])
print(transpose_matrix_of_tfidf_matrix)
print()








