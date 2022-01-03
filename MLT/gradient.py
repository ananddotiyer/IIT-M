import numpy as np
from sklearn.model_selection import train_test_split

def add_dummy_feature(x):
    return np.column_stack((np.ones(x.shape[0]), x))

#Predicting label follows the equation y = Xw, in its vectorized form.
def predict(X, w):
    if X.shape[1] == w.shape[0]:
        return X @ w
    else:
        return None

def loss (X, y, w):
    e = X @ w - y
    return 0.5 * (e.T @ e)
	
def calculate_gradient(X, y, w):
    return np.transpose(X) @ (predict(X, w) - y)

def weight_update(w, lr, g):
    return w - lr * g
		
def gradient_descent(epochs):
    # Start with an arbitrary weight vector say, [0, 0].  
    # After "many" iterations, we should reach the original weight vector [3,4]
    w = np.array([0,0])
    losses = list() 
    weights = list()
    for i in range(epochs):
        l = loss(X_train, y_train, w)
        losses.append(l)
        g = calculate_gradient(X_train, y_train, w)
        w = weight_update(w, lr, g)
        weights.append(w)
    return weights, losses
	
#main program
w0 = 3 #weight0
w1 = 4 #weight1
lr = 0.0001 #learning rate
epochs = 10000

X = 10 * np.random.random(100, ) #Generate 100 examples.
y = w0 + w1 * X #Generate the outputs based on pre-determined weight vector [3,4]

#42 is the seed, and allows same split to occur everytime the function is executed.
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42) 

X_train = add_dummy_feature(X_train) #Add a dummy feature to X_train.

w = np.array([w0, w1]) #Construct the weight vector [3,4]

weights, losses = gradient_descent(epochs)

print(weights)  

# I expect that the weights converge to [3,4], but it's increasing forever, why?