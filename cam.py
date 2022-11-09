
import cv2 
import time

cam = cv2.VideoCapture(0)

i = 1

start = time.time()

while True:
	ret, frame = cam.read()
	cv2.imshow("out", frame)

	if cv2.waitKey(1) & 0xFF == ord('q'):
		break

	if time.time() - start > 5:
		name = "Frame_"+str(i)+".png"
		cv2.imwrite(name, frame)
		start = time.time()

	i = i+1

cam.release()
cv2.destroyAllWindows()



import cv2 
import time

cam = cv2.VideoCapture(0)

i = 1

start = time.time()

while True:
        ret, frame = cam.read()
        cv2.imshow("out", frame)

        if cv2.waitKey(1) & 0xFF == ord('q'):
                break

        if time.time() - start > 5:
                name = "Frame_"+str(i)+".png"
                cv2.imwrite(name, frame)
                start = time.time()

        i = i+1

cam.release()
cv2.destroyAllWindows()


