# 爬虫基本方法

### 1. 使用超时参数

```python 
response = requsets.get(url,header=header,timeout = 3)  #3秒内必须返回相应，否则会报错
```

### 2. retrying模块的学习

```python
- pip install retrying

from retrying import retry

@retry(stop_max_attempt_number=3)
"""反复执行三次，如果三次全部报错，才会报错，如果中间有一次不报错，就会正常执行下去"""
def fun1():
    print("this is fun1")
    raise ValueError("this is a Error")
```

### 3. 获取网页源码的正确打开方式

```python
1. response = requests.content.decode()
2. response = requests.content.decode("gbk")
3. response = requests.text
```

### 4. 处理cookie 相关的请求

1. 直接携带cookie请求相关地址

   1. cookie放在headers中

      ```python
      headers = {"User_agent" = ".....", "cookie" = "cookie字符串"}
      ```

   2. cookie 字典传给cookie参数

      ```python
      cookie = "......"
      cookie_dict = {i.split("=")[0]:i.split("=")[1] for i in cookie.split(";")}
      response = requesets.get(url,headers=headers,cookie=cookie_dict)
      ```

2. 先发送post请求，获取cookie，带上cookie请求登录后的页面

   ```python
   1. seesion = requests.session()  #session具有的方法与requests一样，相当于一个活体的浏览器
   2. session.post(url,data,headers)  # 服务器设置在本地cookie会存储在session中
   3. session.get(url)  # 这里发出请求时会采用保存在session中的cookie
   ```

    证件号码：140502199802030511
   
   民族：汉
   
   学士学位获得时间：2020年6月
   
   邮箱：424193726@qq.com
   
   
   
   

