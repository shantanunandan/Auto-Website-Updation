
import zipfile
import os
import traceback

def unzipping(path_to_zip_file, save_folder):
	with zipfile.ZipFile(path_to_zip_file, 'r') as zip_ref:
		zip_ref.extractall(save_folder)
		print("Unzipped : ",path_to_zip_file)

path = os.getcwd()
file = os.listdir('.')
#print(os.getcwd())

for p in file:
	imageFile = path+'/'+p
	if imageFile.endswith('.zip'):r
		print("-------------------------------------------------------------------------------------------------")
		print(p)
		#try:
		unzipping(imageFile, path+"/")
		#except:
		#	print("Not Readable : ", p)
		#	traceback.print_exc()
		print("--------------------------------------------------------------------------------------------"+"\n")
	print()



