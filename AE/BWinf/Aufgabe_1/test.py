import re
x = "_h __, _a_ __r ___e __b___!"
y = list("arbeit eine für je oh was".split())
x = list(re.sub(r"[^A-Za-z0-9_äÄöÖüÜß\_\s]", " ", x).split())
result = []
tmp = ""


print(x)
print(y)

for head in x:
    for tail in y:
        if(len(head) == len(tail)):
            for i in range(len(head)):
                if(head[i] == tail[i]):
                    tmp = tail
                    result.append(tail)
                    y.remove(tail)

print(y)
print(result)





