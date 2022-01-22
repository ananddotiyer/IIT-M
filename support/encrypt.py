def encrypt(text):
	encrypted_text = ''
	from string import ascii_lowercase as alphabets
	lines = text.split('\n')
	for line in lines:
		encrypted_line = ''
		for ch in line:
			index = alphabets.find(ch)
			if index != -1:
				encrypted_line += alphabets[(index + 3) % 26]
			else:
				encrypted_line += ch
		encrypted_text += encrypted_line + '\n'
	return encrypted_text

def decrypt(text):
	decrypted_text = ''
	from string import ascii_lowercase as alphabets
	lines = text.split('\n')
	for line in lines:
		decrypted_line = ''
		for ch in line:
			index = alphabets.find(ch)
			if index != -1:
				decrypted_line += alphabets[(index - 3) % 26]
			else:
				decrypted_line += ch
		decrypted_text += decrypted_line + '\n'
	return decrypted_text
	
e = encrypt('''import numpy as np
def OneHotEncode(y):
  # Write your code here
  num_classes = np.max(y) + 1
  encoder = np.eye(num_classes)
  return encoder[y]''')
print(e)

d = decrypt(e)
print(d)