import requests

r = requests.get('https://api.github.com/events')

r = requests.post('http://httpbin.org/post', data = {'key':'value'})

r = requests.put('http://httpbin.org/put', data = {'key':'value'})
r = requests.delete('http://httpbin.org/delete')
r = requests.head('http://httpbin.org/get')
r = requests.options('http://httpbin.org/get')

print "GOod"
