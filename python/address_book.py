import re

names_file = open("names.txt", encoding = "utf-8")
data = names_file.read()
names_file.close()

print(data)

last_name = r'Love'
first_name = r'Kenneth

#print(re.match(last_name, data))
#print(re.search(first_name, data))
#print(re.search(r'\(\d\d\d\) \d\d\d-\d\d\d\d', data))
#print(re.findall(r'\(?\d{3}\)?-?\s?\d{3}-\d{4}', data))
#print(re.findall(r'\w*, \w+', data))
#print(re.findall(r'[-\w\d+.]+@[-\w\d.]+', data))
#print(re.findall(r'\b[trehous]{9}\b', data, re.I))

#print(re.findall(r'''
#	\b@[-\w\d.]*
#	[^gov\t]+
#	\b
#''', data, re.VERBOSE|re.I))
#

print(re.findall(r"""
	\b[-\w]*, 
	\s
	[-\w ]+
	[^\t\n]
""", data, re.X))

line = re.compile(r'''
	^(?P<name>(?P<last>[-\w ]*),\s(?P<first>[-\w ]+))\t
	(?P<email>[-\w\d.+]+@[-\w\d.]+)\t
	(?P<phone>\(?\d{3}\)?-?\s?\d{3}-\d{4})?\t
	(?P<job>[\w\s]+,\s[\w\s.]+)\t?
	(?P<twitter>@[\w\d]+)?$
''', re.X|re.MULTILINE)

#print(re.search(line, data).groupdict())
#print(line.search(data).groupdict())

for match in line.finditer(data):
	#print(match.group('name'))
	print('{first} {last} <{email}>'.format(**match.groupdict()))
