from keras.models import load_model
from keras.preprocessing import image
import numpy as np
import matplotlib.pyplot as plt


model = load_model('mnist.h5')
model.load_weights('mnist_weights.h5')

model.summary()

def load_image(img_path, show=True):
    img = image.load_img(img_path, target_size=(28, 28))
    plt.imshow(img)                           
    img = image.load_img(img_path, target_size=(28, 28), grayscale=True)
    img = np.reshape(img,[1,28,28,1])
    return img

predictions = []

img = load_image('3.png')

pred = model.predict(img)


for x in range(0,10):
    if pred.item(x) == 1.0:
        predictions.append(x)
