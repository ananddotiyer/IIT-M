GA = 9
F = 80
Qz1 = 73
Qz2 = 80
Bonus = 10

T = GA + max(0.35 * F + 0.25 * Qz1 + 0.3 * Qz2, 0.5 * F + 0.3 * max(Qz1, Qz2)) + Bonus

print(T)

# 70-80 B
# 60-70 C
# 50-60 D