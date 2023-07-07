n=[]
for _ in range(10):
  a= int(input())
  b=a%42
  n.append(b)

print(len(set(n)))