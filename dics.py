
from sklearn.feature_extraction.text import CountVectorizer

input_1 = """token counts input_1"""

input_2 = """Remove accents counts input_2"""

input = [input_1, input_2, "two dictionaries token horse input_3", "dictionaries value pairs input_3"]

result = {}
for count,v in enumerate(input):
	#print(v)
	vectorizer1 = CountVectorizer(stop_words='english', ngram_range=(1, 1))
	vectorizer1.fit_transform([v])

	l = vectorizer1.get_feature_names()
	result[str(count)] = l

test_dict={'cubed': ['1','2', '3'],
    'melon': ['3','4'],
    'poop': ['2','4']}

def find_matches(dict1):
    match_dict = {}
    for key, values in dict1.items():
        base = []
        keys = list(dict1.keys())
        keys.remove(key)
        #print("Values : ", values)
        #print("keys : ", keys)
        for key_1 in keys:
            for base_key in dict1[key_1]:
                #print("base_key : ",base_key)
                if base_key in values:
                    try:
                        dict1[key].remove(base_key)
                        print("Match")
                    except:
                        pass
    return dict1

print(result)
print(find_matches(result)) #{'cubed': 'melon', 'melon': 'cubed'}


"""
def find_matches(dict1):
    match_dict = {}
    for key, values in dict1.items():
        base = []
        values_ = dict1[key]
        keys = list(dict1.keys())
        keys.remove(key)
        print("Values : ", values)
        for key_1 in keys:
            for base_key in dict1[key_1]:
                print("base_key : ",base_key)
                if base_key not in values:
                    try:
                        dict1[key].remove(base_key)
                    except:
                        pass
                    #if base_key not in base:
                    #    base.append(base_key)
        print(base)
        match_dict[key] = base
    return match_dict, dict1
"""
